/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zygon.smartmarket.campaign;

import java.util.List;

/**
 *
 * @author zygon
 */
public interface Campaign {

    // TBD: stronger identification
    String getName();

    // Order matters
    List<Segment> getSegments();
}
