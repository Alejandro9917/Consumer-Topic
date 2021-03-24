package itm.message;

import io.smallrye.reactive.messaging.annotations.Broadcast;

import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageConverter
{
    @Incoming("in-message")                                     
    @Outgoing("my-data-stream")                             
    @Broadcast
    @Acknowledgment(Acknowledgment.Strategy.PRE_PROCESSING)
    public String process(ConsumerRecord<String, String> record)
    {
        return "" + record.value();

    }
}