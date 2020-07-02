package com.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcWebClientController {
    String target = "localhost:50052";

    @RequestMapping("/send")
    public String sendMessage(
            @RequestParam(value = "content", defaultValue = "Sample message text") String content
    ) {
        Message message = new Message(content);
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
        String response;
        try {
            GrpcClient client = new GrpcClient(channel);
            response = client.sendMessage(message);
        } catch (Exception exc){
            response = "Send message error: " + exc.getMessage();
        } finally {
            channel.shutdownNow();
        }
        return response;
    }
}
