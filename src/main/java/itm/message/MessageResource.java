package itm.message;

import io.smallrye.reactive.messaging.annotations.Channel;

import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.SseElementType;

@Path("/message")
public class MessageResource
{
    @Inject
    @Channel("my-data-stream") Publisher<String> message;

    @GET 
    @Path("/scr")
    @Produces(MediaType.SERVER_SENT_EVENTS) 
    @SseElementType("text/plain")
    public Publisher<String> stream()
    {
        return message;
    }
}