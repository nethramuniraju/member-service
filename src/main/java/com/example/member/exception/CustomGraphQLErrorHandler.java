package com.example.member.exception;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
//import graphql.kickstart.execution.error.GraphQLErrorHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class CustomGraphQLErrorHandler  {

    public CustomGraphQLErrorHandler() {
    }

    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        return errors.stream().map(this::getNested).collect(Collectors.toList());
    }

    private GraphQLError getNested(GraphQLError e) {
        if (e instanceof ExceptionWhileDataFetching) {
            ExceptionWhileDataFetching dataFetchingEx = (ExceptionWhileDataFetching) e;
            if (dataFetchingEx.getException() instanceof GraphQLError) {

                return (GraphQLError) dataFetchingEx.getException();
            }
        }
        return e;
    }


}