package org.bank.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;

@Service
@Slf4j
public class TestMq {
    private final JmsTemplate jmsTemplate;

    public TestMq(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String queueName, String message) {
        jmsTemplate.send(queueName, session -> session.createTextMessage(message));
    }

    @JmsListener(destination = "TEST.QUEUE")
    public void onMessageOut(Message message) throws JMSException {
        log.info("Сообщение получено: {}", message);
    }
}
