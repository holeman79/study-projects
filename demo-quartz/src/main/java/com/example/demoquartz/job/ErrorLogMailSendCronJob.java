package com.example.demoquartz.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.InterruptableJob;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@RequiredArgsConstructor
public class ErrorLogMailSendCronJob extends QuartzJobBean implements InterruptableJob {
    private final JobLauncher jobLauncher;

    private final JobLocator jobLocator;

    private String batchJobName;

    private JobKey jobKey = null;

    private boolean isInterrupted = false;

    @Override
    public void interrupt() {
        log.info(jobKey + " -- INTERRUPTING -- ");
        isInterrupted = true;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        JobDataMap map = jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        jobKey = jobExecutionContext.getJobDetail().getKey();
        log.info("ErrorLogMailSendCronJob executeInternal invoked, quartzJobKey: " + jobKey + ", time: " + LocalDateTime.now());
        try {
            batchJobName = map.getString("jobName");
            Job job = jobLocator.getJob(batchJobName);
            JobParameters jobParameters = new JobParametersBuilder()
                    //.addString("input.file.name", fileName)
                    //.addLong("time", System.currentTimeMillis())
                    .addString("time", LocalDateTime.now().minusHours(6l).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                    .toJobParameters();
            JobExecution jobExecution = jobLauncher.run(job, jobParameters);
            log.info("{}_{} was completed successfully", job.getName(), jobExecution.getId());
        } catch (NoSuchJobException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        }

    }
}