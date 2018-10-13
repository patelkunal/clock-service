package org.coderearth.windowsdeployments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import lombok.extern.slf4j.Slf4j;

/**
 * AppConfig
 */
@Configuration
@ComponentScan(basePackages = "org.coderearth.windowsdeployments")
@EnableScheduling
@Slf4j
public class AppConfig implements SchedulingConfigurer {

    @Bean(destroyMethod = "shutdown")
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(1);
        threadPoolTaskScheduler.setThreadNamePrefix("clocker-");
        threadPoolTaskScheduler.setThreadGroupName("clocker");
        threadPoolTaskScheduler.initialize();
        return threadPoolTaskScheduler;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        LOGGER.debug("starting clock-scheduler task !!");
        taskRegistrar.setTaskScheduler(taskScheduler());
        LOGGER.debug("clock-scheduler task is started !!");
    }

}