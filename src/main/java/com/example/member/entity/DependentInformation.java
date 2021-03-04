package com.example.member.entity;

import com.example.member.Relationship;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DependentInformation {

    private String name;
    private Relationship relationship;
}
