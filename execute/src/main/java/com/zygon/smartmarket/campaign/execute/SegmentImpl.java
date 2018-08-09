/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zygon.smartmarket.campaign.execute;

import com.google.common.collect.ImmutableList;
import com.zygon.smartmarket.Prospect;
import com.zygon.smartmarket.campaign.Segment;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author zygon
 */
public final class SegmentImpl implements Segment {

    private final String name;
    private final List<Prospect> prospects;
    private final SendRate sendRate;
    private final String message;

    private long lastSent = 0;

    public SegmentImpl(String name, List<Prospect> prospects, SendRate sendRate, String message, long lastSent) {
        this.name = Objects.requireNonNull(name);
        this.prospects = prospects == null
                ? Collections.emptyList()
                : ImmutableList.copyOf(prospects);
        this.sendRate = Objects.requireNonNull(sendRate);
        this.message = Objects.requireNonNull(message);
        this.lastSent = lastSent;
    }

    public SegmentImpl(String name, List<Prospect> prospects, SendRate sendRate, String message) {
        this(name, prospects, sendRate, message, 0);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Prospect> getProspects() {
        return prospects;
    }

    @Override
    public SendRate getSendRate() {
        return sendRate;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public long getLastSent() {
        return lastSent;
    }

    public void setLastSent(long lastSent) {
        this.lastSent = lastSent;
    }
}
