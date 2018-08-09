/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zygon.smartmarket.campaign.execute;

import com.google.common.base.MoreObjects;
import com.zygon.smartmarket.Prospect;

import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author zygon
 */
public class ProspectImpl implements Prospect {

    private final String email;
    private final Optional<String> firstName;
    private final Optional<String> lastName;

    public ProspectImpl(String email, Optional<String> firstName, Optional<String> lastName) {
        this.email = Objects.requireNonNull(email);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Optional<String> getFirstName() {
        return firstName;
    }

    @Override
    public Optional<String> getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this.getClass())
                .add("email", email)
                .add("first name", firstName.orElse(""))
                .add("last name", lastName.orElse(""))
                .toString();
    }

}
