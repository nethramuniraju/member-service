package com.example.member.entity;

import com.example.member.Relationship;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
public class DependentInformationInput {
    private String name;
    private Relationship relationship;
}

