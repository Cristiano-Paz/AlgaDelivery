package com.crisdev.algadelivery.delivery.tracking.api.model;


import com.crisdev.algadelivery.delivery.tracking.domain.model.ContactPoint;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeliveryInput {

    @NotNull
    @Valid
    private ContactPoint sender;

    @NotNull
    @Valid
    private ContactPoint recipient;

    @NotEmpty
    @Valid
    @Size(min = 1)
    private List<ItemInput> items;
}
