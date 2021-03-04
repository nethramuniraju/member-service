package com.example.member.resolver;


import com.example.member.entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.member.repository.MemberRepository;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import java.util.Optional;


@Component
public class Mutation implements GraphQLMutationResolver {
	private MemberRepository memberRepository;

	@Autowired
	public Mutation(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Member createMember(Integer memberId, String firstName, String lastName,
							   DependentInformationInput dependentInfo, AddressInput address) {
		Member member = new Member();
		member.setMemberId(memberId);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setDependentInfoList(dependentInfo);
		member.setAddress(address);
		return memberRepository.save(member);
	}


	public String deleteMember(int memberId) throws JsonMappingException, JsonProcessingException
	{
		memberRepository.deleteById(memberId);
		return  "Member deleted successfully!";
	}

	public String updateMember(int memberId, String firstName, String lastName){
				Member newObj=new Member();
				newObj.setMemberId(memberId);
				newObj.setFirstName(firstName);
				newObj.setLastName(lastName);
			    memberRepository.save(newObj);
		return "Member is updated successfully";
	}
}
