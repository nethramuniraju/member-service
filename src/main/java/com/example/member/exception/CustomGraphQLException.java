package com.example.member.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class CustomGraphQLException extends RuntimeException implements GraphQLError {

    public CustomGraphQLException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}