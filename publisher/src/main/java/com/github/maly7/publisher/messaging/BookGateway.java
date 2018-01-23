package com.github.maly7.publisher.messaging;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface BookGateway {

    /*
     * TODO: use a default request channel for the entire class, but specific header values for
     * the various methods. ie:
     * @MessagingGateway(defaultRequestChannel = "books")
     *
     * with the following on the methods:
     *
     * @Gateway(headers = @GatewayHeader(name = "EventType", value = "write"))
     *
     * @Gateway(headers = @GatewayHeader(name = "EventType", value = "delete"))
     */

    @Gateway(requestChannel = "bookUpdates", headers = @GatewayHeader(name = "EventType", value = "write"))
    void sendUpdate(String message);

    @Gateway(requestChannel = "bookDeletes")
    void sendDelete(String message);
}