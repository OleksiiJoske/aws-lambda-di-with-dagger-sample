package com.joske.event_driven.handlers;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class TestContext implements Context {

    private String awsRequestId = "EXAMPLE";
    private ClientContext clientContext;
    private String functionName = "EXAMPLE";
    private String functionVersion = "V1";
    private String functionArn = "arn:aws";
    private CognitoIdentity identity;
    private String logGroupName = "EXAMPLE";
    private String logStreamName = "EXAMPLE";
    private LambdaLogger logger = new TestLogger();
    private int memoryLimitInMB = 128;
    private int remainingTimeInMillis = 15000;

    @Override
    public String getAwsRequestId() {
        return awsRequestId;
    }

    public void setAwsRequestId(String value) {
        awsRequestId = value;
    }

    @Override
    public ClientContext getClientContext() {
        return clientContext;
    }

    public void setClientContext(ClientContext value) {
        clientContext = value;
    }

    @Override
    public String getFunctionName() {
        return functionName;
    }

    @Override
    public String getFunctionVersion() {
        return functionVersion;
    }

    @Override
    public String getInvokedFunctionArn() {
        return functionArn;
    }

    public void setFunctionName(String value) {
        functionName = value;
    }

    @Override
    public CognitoIdentity getIdentity() {
        return identity;
    }

    public void setIdentity(CognitoIdentity value) {
        identity = value;
    }

    @Override
    public String getLogGroupName() {
        return logGroupName;
    }

    public void setLogGroupName(String value) {
        logGroupName = value;
    }

    @Override
    public String getLogStreamName() {
        return logStreamName;
    }

    public void setLogStreamName(String value) {
        logStreamName = value;
    }

    @Override
    public LambdaLogger getLogger() {
        return logger;
    }

    public void setLogger(LambdaLogger value) {
        logger = value;
    }

    @Override
    public int getMemoryLimitInMB() {
        return memoryLimitInMB;
    }

    public void setMemoryLimitInMB(int value) {
        memoryLimitInMB = value;
    }

    @Override
    public int getRemainingTimeInMillis() {
        return remainingTimeInMillis;
    }

    public void setRemainingTimeInMillis(int value) {
        remainingTimeInMillis = value;
    }

    /**
     * A simple {@code LambdaLogger} that prints everything to stderr.
     */
    private static class TestLogger implements LambdaLogger {

        @Override
        public void log(String message) {
            System.err.println(message);
        }

        @Override
        public void log(byte[] message) {
            System.err.println(new String(message));
        }
    }
}