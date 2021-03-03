package com.example.member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Claim {

    private String claimId;
    private String drugName;
    private String drugNDC;
    private String drugType;
    private String providerName;
    private String prescriberName;
    private String pharmacyName;
    private int claimAmount;
}
