package org.bank.controller;

import org.bank.service.impl.TestMq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mq")
public class TestMqController {
    @Autowired
    private TestMq mqService;

    @PostMapping("/send")
    public String send(@RequestParam String message) {
        mqService.sendMessage("TEST.QUEUE", message);
        return "Sent: " + message;
    }
}
