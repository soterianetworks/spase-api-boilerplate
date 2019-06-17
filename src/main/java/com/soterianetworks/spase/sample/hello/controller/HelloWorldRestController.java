package com.soterianetworks.spase.sample.hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping("/foo")
    @ResponseStatus(HttpStatus.OK)
    public Message foobar() {
        return new Message("foobar");
    }

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public Message helloworld() {
        return new Message("Hello world");
    }

    static class Message {
        private String message;

        public Message() {
        }

        public Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}

