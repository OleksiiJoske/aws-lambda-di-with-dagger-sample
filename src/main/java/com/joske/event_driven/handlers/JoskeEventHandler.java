package com.joske.event_driven.handlers;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import com.joske.event_driven.models.EventRequest;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class JoskeEventHandler implements RequestHandler<EventRequest, Map<String, Object>> {

    @Override
    public Map<String, Object> handleRequest(EventRequest request, Context context) {
        var ses = AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion(Regions.valueOf(System.getenv("REGION")))
                .build();
        try {
            var idomSubject = "Testing lambdas with EventBridge";
            var idomEmailBody = "Hello " + request.name;

            var email = constructTextEmail(idomSubject, idomEmailBody, Set.of(System.getenv("TO_EMAIL")));
            ses.sendEmail(email);

            return Map.of("success", true);
        } catch (final Exception e) {
            return Map.of("success", false);
        }
    }

    private SendEmailRequest constructTextEmail(String subject, String body, Set<String> userEmail) {
        var emails = userEmail.stream().filter(Objects::nonNull).collect(Collectors.toSet());
        var destination = new Destination().withBccAddresses(emails);
        var contentSubject = new Content().withData(subject);
        var contentData = new Content().withData(body);
        var contentBody = new Body().withText(contentData);
        var message = new Message().withSubject(contentSubject).withBody(contentBody);

        return new SendEmailRequest().withSource(System.getenv("FROM_EMAIL"))
                .withDestination(destination)
                .withMessage(message);
    }
}
