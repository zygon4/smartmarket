/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zygon.smartmarket.campaign;

import com.zygon.smartmarket.Prospect;

import java.util.List;

/**
 * Campaign segments
 *
 *
 */
public interface Segment {
    // TODO:

    public static enum SendRate {
        DAILY,
        WEEKLY,
        MONTHLY,
        YEARLY
    }

    // TBD: stronger identification
    String getName();

    List<Prospect> getProspects();

    SendRate getSendRate();

    // Probably want stonger typing. This could be email or sms, whatever
    String getMessage();

    // ms since epoch
    long getLastSent();
}
