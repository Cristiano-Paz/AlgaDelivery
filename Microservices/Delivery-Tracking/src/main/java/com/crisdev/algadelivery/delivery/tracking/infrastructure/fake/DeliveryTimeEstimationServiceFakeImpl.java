package com.crisdev.algadelivery.delivery.tracking.infrastructure.fake;


import com.crisdev.algadelivery.delivery.tracking.domain.model.ContactPoint;
import com.crisdev.algadelivery.delivery.tracking.domain.service.DeliveryEstimate;
import com.crisdev.algadelivery.delivery.tracking.domain.service.DeliveryTimesEstimationService;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class DeliveryTimeEstimationServiceFakeImpl
        implements DeliveryTimesEstimationService {

    @Override
    public DeliveryEstimate estimate(ContactPoint sender, ContactPoint receiver) {
        return new DeliveryEstimate(
                Duration.ofHours(3),
                3.1
        );
    }
}
