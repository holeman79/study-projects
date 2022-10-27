package com.example.demospringbasic.config.kafka;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TrainingKafkaMessage {
    private String programName;

    private Long gymId;

    private String gymName;

    private String memberId;

    private String memberName;

    private String trainerId;

    private String trainerName;

    private Integer trainingCount;

    @Builder
    public TrainingKafkaMessage(final String programName, final Long gymId, final String gymName, final String memberId,
                                final String memberName, final String trainerId, final String trainerName, final Integer trainingCount) {
        this.programName = programName;
        this.gymId = gymId;
        this.gymName = gymName;
        this.memberId = memberId;
        this.memberName = memberName;
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.trainingCount = trainingCount;
    }
}
