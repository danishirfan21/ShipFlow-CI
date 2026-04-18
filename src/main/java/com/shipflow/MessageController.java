package com.shipflow;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createMessage(@Valid @RequestBody MessageRequest request) {
        messageService.addMessage(request.getText());
    }

    @GetMapping
    public List<MessageResponse> getMessages() {
        return messageService.getAllMessages().stream()
                .map(MessageResponse::new)
                .collect(Collectors.toList());
    }
}
