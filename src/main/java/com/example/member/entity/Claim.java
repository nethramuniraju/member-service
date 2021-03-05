package com.example.member.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Claim {

    private String id;
    private String claimId;
    private String drugName;
    private String drugNDC;
    private String drugType;
    private String prescriberName;
    private String providerName;
    private String pharmacyName;
    private String createdDate;
    private double claimAmount;
    private String memberId;
}
