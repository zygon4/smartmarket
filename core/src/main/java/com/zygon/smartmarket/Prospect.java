/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zygon.smartmarket;

import java.util.Optional;

/**
 *
 * @author zygon
 */
public interface Prospect {

    Optional<String> getFirstName();

    Optional<String> getLastName();

    String getEmail();
}
