package com.example.member.entity;

import lombok.Data;

@Data
public class AddressInput {
    private String street;
    private String city;
    private String state;
    private int zip;
    private String country;
}
