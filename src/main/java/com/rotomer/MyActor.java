package com.rotomer;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class MyActor extends AbstractActor {

    static class MyMessage {
        private String _message;

        MyMessage(final String message) {
            _message = message;
        }

        String getMessage() {
            return _message;
        }
    }

    public static Props props() {
        return Props.create(MyActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(MyMessage.class, this::onMyMessage)
                .build();
    }

    private void onMyMessage(final MyMessage myMessage) {
        System.out.println("myMessage = [" + myMessage.getMessage() + "]");
    }
}
