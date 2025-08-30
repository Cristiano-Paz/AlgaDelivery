package com.crisdev.algadelivery.delivery.tracking.domain.service;

import com.crisdev.algadelivery.delivery.tracking.domain.model.ContactPoint;

public interface DeliveryTimesEstimationService {
    DeliveryEstimate estimate(ContactPoint sender, ContactPoint receiver);
}
