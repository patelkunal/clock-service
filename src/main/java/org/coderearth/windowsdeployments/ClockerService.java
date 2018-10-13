package org.coderearth.windowsdeployments;

import java.time.Clock;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * ClockerService
 */
@Service
@Slf4j
public class ClockerService {

    private LocalDateTime datetime;

    @Scheduled(fixedDelayString = "${indexing.delay}", initialDelayString = "${indexing.initial.delay}")
    public void updateClock() {
        LOGGER.info("starting clocker-task !!");
        this.updateDateTime();
        LOGGER.info("finished clocker-task !!");
    }

    /**
     * @return the clock's datetime
     */
    public LocalDateTime getDatetime() {
        return datetime;
    }

    @PostConstruct
    public void init() {
        this.updateDateTime();
    }

    private void updateDateTime() {
        final LocalDateTime prevDateTime = datetime;
        this.datetime = LocalDateTime.now(Clock.systemUTC());
        LOGGER.info("updating clock's datetime, {} ==> {}", prevDateTime, datetime);
    }
}