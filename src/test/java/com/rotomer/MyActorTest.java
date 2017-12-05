package com.rotomer;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;
import org.junit.Test;

public class MyActorTest  {

    @Test
    public void testMyActor() {
        final ActorSystem actorSystem = ActorSystem.create();

        new TestKit(actorSystem) {{
            final ActorRef target = actorSystem.actorOf(MyActor.props());
            final MyActor.MyMessage message = new MyActor.MyMessage("Hello");
            target.tell(message, getRef());
        }};
    }

}