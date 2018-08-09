/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zygon.smartmarket.campaign;

import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author zygon
 */
public class CampaignImpl implements Campaign {

    private final String name;
    private final List<Segment> segments;

    public CampaignImpl(String name, List<Segment> segments) {
        this.name = Objects.requireNonNull(name);
        this.segments = segments == null
                ? Collections.emptyList()
                : ImmutableList.copyOf(segments);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Segment> getSegments() {
        return segments;
    }
}
