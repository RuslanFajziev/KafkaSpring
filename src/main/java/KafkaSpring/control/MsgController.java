package KafkaSpring.control;

import KafkaSpring.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("msg")
public class MsgController {
    @Autowired
    private KafkaTemplate<Long, UserDTO> kafkaTemplate;

    @PostMapping
    public UserDTO sendOrder(Long msgId, @RequestBody UserDTO msg) {
        ListenableFuture<SendResult<Long, UserDTO>> future = kafkaTemplate.send("msg", msgId, msg);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
        return msg;
    }
}