package com.example.member.resolver;

/*
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.member.claim.utility.ClaimsUtility;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private MemberRepository memberRepository;

    private ClaimsUtility claimsUtility;


    public Iterable<Member> findAllMember() throws ExecutionException, InterruptedException {

        return memberRepository.findAll();
        /*List<Member> members = memberRepository.findAll();
        return populateClaimsInParallel(members);
    }

public Member findMemberById(Integer memberId)throws ExecutionException,InterruptedException{
        log.info("Inside Query");
        return memberRepository.findByMemberId(memberId);
        // return populateClaimsInParallel(Collections.singletonList(member)).get(0);
        }

public List<Member> findMemberByType(String memberType)throws ExecutionException,InterruptedException{
        return memberRepository.findByMemberType(memberType);
        //return populateClaimsInParallel(members);
        }

    @NotNull
    private List<Member> populateClaimsInParallel(List<Member> members) throws InterruptedException, ExecutionException {

        List<CompletableFuture<Claim>> list = new ArrayList<>();
        members.forEach(m -> {
            try {
                list.add(claimsUtility.findClaimsForMember(String.valueOf(m.getMemberId())));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<List<Claim>> results = allOf(list);

        List<Claim> claimList = new ArrayList<>(results.get());

        Map<String, List<Claim>> claimsMap = claimList.stream().collect(Collectors.groupingBy(Claim::getMemberId));
        for (Member m : members) {
            String id = String.valueOf(m.getMemberId());
            if (claimsMap.containsKey(id)) {
                m.setClaim(claimsMap.get(id).get(0));
            }
        }
        return members;
    }

    private <Claim> CompletableFuture<List<Claim>> allOf(List<CompletableFuture<Claim>> futuresList) {
        CompletableFuture<Void> allFuturesResult =
                CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[0]));
        return allFuturesResult.thenApply(v ->
                futuresList.stream().
                        map(CompletableFuture::join).
                        collect(Collectors.<Claim>toList())
        );
    }
  }
*/