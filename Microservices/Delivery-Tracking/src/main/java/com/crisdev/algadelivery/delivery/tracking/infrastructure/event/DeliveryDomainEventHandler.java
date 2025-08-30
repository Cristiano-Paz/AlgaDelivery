package com.crisdev.algadelivery.delivery.tracking.infrastructure.event;


import com.crisdev.algadelivery.delivery.tracking.domain.event.DeliveryFulfilledEvent;
import com.crisdev.algadelivery.delivery.tracking.domain.event.DeliveryPickUpEvent;
import com.crisdev.algadelivery.delivery.tracking.domain.event.DeliveryPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.crisdev.algadelivery.delivery.tracking.infrastructure.Kafka.KafkaTopicConfig.deliveryEventsTopicName;

@Component
@Slf4j
@RequiredArgsConstructor
public class DeliveryDomainEventHandler {

    private final IntegrationEventPublisher integrationEventPublisher;

    @EventListener
    public void handle(DeliveryPlacedEvent event) {
        log.info(event.toString());
        integrationEventPublisher.publish(event,
                event.getDeliveryId().toString(), deliveryEventsTopicName);
    }

    @EventListener
    public void handle(DeliveryPickUpEvent event) {
        log.info(event.toString());
        integrationEventPublisher.publish(event,
                event.getDeliveryId().toString(), deliveryEventsTopicName);
    }

    @EventListener
    public void handle(DeliveryFulfilledEvent event) {
        log.info(event.toString());
        integrationEventPublisher.publish(event,
                event.getDeliveryId().toString(), deliveryEventsTopicName);
    }

}
