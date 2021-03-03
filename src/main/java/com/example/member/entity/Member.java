package com.example.member.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import java.lang.annotation.Documented;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "member")
public class Member {

    @Transient
    public static final String SEQUENCE_NAME = "member_sequence";

    @Id
    protected int memberId;
    protected String memberType;
    protected String firstName;
    protected String lastName;
    protected String dob;
    protected String ssn;
    protected int agn;
    private DependentInformation dependentInfoList;
    private Claim claim;
}
