/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zygon.smartmarket.campaign.execute;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.zygon.smartmarket.campaign.Segment;
import com.zygon.smartmarket.sender.ProspectSender;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author zygon
 */
public class SegmentManager extends AbstractScheduledService {

    private final Segment segment;
    private final ProspectSender sender;

    public SegmentManager(Segment segment, ProspectSender sender) {
        this.segment = Objects.requireNonNull(segment);
        this.sender = Objects.requireNonNull(sender);
    }

    public Segment getSegment() {
        return segment;
    }

    @Override
    protected void runOneIteration() throws Exception {
        segment.getProspects().parallelStream()
                .forEach(prospect -> {
                    // lol no exceptions yet
                    sender.send(prospect, segment.getMessage());
                });
    }

    @Override
    protected Scheduler scheduler() {

        long lastSent = segment.getLastSent();
        long currentTime = System.currentTimeMillis();
        // TODO: change to DAYS
        TimeUnit timeUnit = TimeUnit.SECONDS;

        // TODO: add some delay if the last sent happened within the time interval associated with the send rate.
        switch (segment.getSendRate()) {
            case DAILY:
                return Scheduler.newFixedRateSchedule(0, 1, timeUnit);
            case MONTHLY:
                // This is obviously not correct, based on changing months
                return Scheduler.newFixedRateSchedule(0, 30, timeUnit);
            case WEEKLY:
                return Scheduler.newFixedRateSchedule(0, 7, timeUnit);
            case YEARLY:
                return Scheduler.newFixedRateSchedule(0, 365, timeUnit);
        }

        // throw?
        return null;
    }
}
