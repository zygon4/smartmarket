/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zygon.smartmarket.sender;

import com.zygon.smartmarket.Prospect;

/**
 *
 * @author zygon
 */
public interface ProspectSender {

    void send(Prospect prospect, String message);
}
