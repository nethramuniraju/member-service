package com.example.member.claim.utility;

import com.example.member.claim.model.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Component
public class ClaimsUtility {

    @Autowired
    private RestTemplate restTemplate;

    @Async
    @Retryable(value = {IOException.class, ResourceAccessException.class},
            maxAttempts = 3, backoff = @Backoff(delay = 100))
    public CompletableFuture<Claim> findClaimsForMember(String memberId) throws InterruptedException {

        System.out.println("claim time : " + System.currentTimeMillis() + " on thread : " + Thread.currentThread().getId());
        String url = String.format("http://localhost:8091/v1/claim/%s", memberId);
        ResponseEntity<Claim> results = restTemplate.getForEntity(url, Claim.class);
        return CompletableFuture.completedFuture(results.getBody());
    }

}
