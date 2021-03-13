package com.example.member.wrapper;

import com.example.member.entity.Claim;
import com.example.member.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateWrapper {

    private Claim claim;
    private Member member;
}
