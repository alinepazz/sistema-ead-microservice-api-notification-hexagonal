package com.br.eadnotificationhexagonal.adapters.inbound.consumers;

import com.br.eadnotificationhexagonal.adapters.dtos.NotificationCommandDto;
import com.br.eadnotificationhexagonal.core.domain.NotificationDomain;
import com.br.eadnotificationhexagonal.core.domain.enums.NotificationSatus;
import com.br.eadnotificationhexagonal.core.ports.NotificationServicePort;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    final NotificationServicePort notificationService;

    public NotificationConsumer(NotificationServicePort notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${ead.broker.queue.notificationCommandQueue.name}", durable = "true"),
            exchange = @Exchange(value = "${ead.broker.exchange.notificationCommandExchange}", type = ExchangeTypes.TOPIC, ignoreDeclarationExceptions = "true"),
            key = "${ead.broker.key.notificationCommandKey}")
    )
    public void listenUserEvent(@Payload NotificationCommandDto notificationCommandDto){
        var notificationDomain = new NotificationDomain();
        BeanUtils.copyProperties(notificationCommandDto, notificationDomain);
        notificationDomain.setNotificationSatus(NotificationSatus.CREATED);
        notificationService.saveNotification(notificationDomain);
      }

    }

