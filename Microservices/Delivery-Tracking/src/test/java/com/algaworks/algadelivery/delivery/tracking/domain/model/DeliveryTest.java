package com.algaworks.algadelivery.delivery.tracking.domain.model;

import com.algaworks.algadelivery.delivery.tracking.domain.exception.DomainException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Duration;


import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {

    @Test
    public void shouldChangeToPlaced() {
        Delivery delivery = Delivery.draft();

        delivery.editPreparationDetails(createdValidPreparationDetails());

        delivery.place();

        assertEquals(DeliveryStatus.WAITING_FOR_COURIER, delivery.getStatus());
        assertNotNull(delivery.getPlaceAt());
    }

    @Test
    public void shouldNotPlace() {
        Delivery delivery = Delivery.draft();
        assertThrows(DomainException.class, () -> {
            delivery.place();
        });

        assertEquals(DeliveryStatus.DRAFT, delivery.getStatus());
        assertNull(delivery.getPlaceAt());
    }

    private Delivery.PreparationDetails createdValidPreparationDetails() {
          ContactPoint sender = ContactPoint.builder()
                  .zipCode("00000-000")
                  .street("Rua Rio de Janeiro")
                  .number("200")
                  .complement("Sala 502")
                  .name("João das Couves")
                  .phone("(21) 9000-1234")
                  .build();

        ContactPoint recipient = ContactPoint.builder()
                .zipCode("13441-243")
                .street("Rua Espirito Santo")
                .number("300")
                .complement("Sala 1200")
                .name("João do Fubá")
                .phone("(21) 91200-4321")
                .build();

        return Delivery.PreparationDetails.builder()
                .sender(sender)
                .recipient(recipient)
                .distanceFee(new BigDecimal("15.00"))
                .courierPayout(new BigDecimal("5.00"))
                .expectedDeliveryTime(Duration.ofHours(5))
                .build();
    }

}