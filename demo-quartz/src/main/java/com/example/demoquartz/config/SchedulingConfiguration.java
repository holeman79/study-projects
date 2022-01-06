package com.example.demoquartz.config;

import com.example.demoquartz.job.ErrorLogMailSendCronJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class SchedulingConfiguration {

    private final Scheduler scheduler;

    @PostConstruct
    public void start() {
        log.info("ErrorLogMailSendJob start invoked");
        try {
            HashMap<String, String> map = new HashMap<>();
            map.put("jobName", ErrorLogMailSendBatchConfiguration.JOB_NAME);

            JobDetail jobDetail = buildJobDetail(ErrorLogMailSendCronJob.class,
                    "errorLogMailSendJob",
                    "시스템 에러 로그 주기적 메일 발송",
                    map);

            scheduler.clear();
            if (scheduler.checkExists(jobDetail.getKey())) {
                scheduler.deleteJob(jobDetail.getKey());
            }

            scheduler.scheduleJob(
                    jobDetail,
                    buildCronJobTrigger(CronExpressionType.EVERY_MINUTE)
            );
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    private Trigger buildCronJobTrigger(CronExpressionType scheduleExp) {
        return TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(scheduleExp.getCronExpression()))
                .build();
    }

    private Trigger buildSimpleJobTrigger(Integer hour) {
        return TriggerBuilder.newTrigger()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .repeatForever()
                        .withIntervalInHours(hour))
                .build();
    }

    private JobDetail buildJobDetail(Class job, String name, String desc, Map params) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.putAll(params);

        return JobBuilder
                .newJob(job)
                .withIdentity(name)
                .withDescription(desc)
                .usingJobData(jobDataMap)
                .build();
    }
}