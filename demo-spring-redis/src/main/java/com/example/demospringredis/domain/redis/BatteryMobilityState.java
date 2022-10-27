package com.example.demospringredis.domain.redis;

import com.example.demospringredis.domain.BatteryType;
import com.example.demospringredis.domain.MobilityType;
import com.example.demospringredis.domain.RentalState;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@RedisHash("battery-mobility-state")
public class BatteryMobilityState {
    @Id
    private Long id;

    private Long mobilityId;

    private BatteryType batteryType;

    private RentalState rentalState;

    private MobilityType mobilityType;

    private String ownedCompany;

    private String registrationNumber;

    private GpsState gpsState = new GpsState();

    private BatteryState batteryState;

    private LocalDateTime interfacedTime;

    public BatteryMobilityState(final Long id, final Long mobilityId, final BatteryType batteryType,
                                final RentalState rentalState, final MobilityType mobilityType, final String ownedCompany,
                                final String registrationNumber) {
        this.id = id;
        this.mobilityId = mobilityId;
        this.batteryType = batteryType;
        this.rentalState = rentalState;
        this.mobilityType = mobilityType;
        this.ownedCompany = ownedCompany;
        this.registrationNumber = registrationNumber;
    }

    public void updateGpsBatteryState(final double latitude, final double longitude, final BatteryState batteryState) {
        gpsState.update(latitude, longitude);
        this.batteryState = batteryState;
        this.interfacedTime = LocalDateTime.now();
    }

    public boolean isLithiumBattery() {
        return batteryType.isLithium();
    }

    public boolean checkFaultOnInterface() {
        return !batteryState.isPowerOff() && !batteryState.isFaultOnInterface() && isAfterTenSeconds();
    }

    public BatteryMobilityState updateFaultOnInterface() {
        if (checkFaultOnInterface()) {
            batteryState.updateStateToFaultOnInterface();
        }
        return this;
    }

    private boolean isAfterTenSeconds() {
        return LocalDateTime.now().isAfter(interfacedTime.plusSeconds(10));
    }

}
