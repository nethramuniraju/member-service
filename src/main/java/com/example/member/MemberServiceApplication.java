package com.example.member;

import com.example.member.entity.Claim;
import com.example.member.entity.DependentInformation;
import com.example.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.tracing.TracingInstrumentation;
import com.example.member.repository.*;
@SpringBootApplication

public class MemberServiceApplication  implements CommandLineRunner {

	@Autowired
	private MemberRepository memberRepository;

	public static void main(String[] args) {
		SpringApplication.run(MemberServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Claim claimObj=new Claim("1","Tylenol","123456","Branded","CVS","JOHN","CVS",3000);
		//Member memberObj=addSampleData(new Member(3,"medicare", "fname3", "lname3","sss3","ssn3",3,new DependentInformation("Spouse"), claimObj));
		//memberRepository.save(memberObj);
		//System.out.println(memberRepository.findAll());
	}

}
