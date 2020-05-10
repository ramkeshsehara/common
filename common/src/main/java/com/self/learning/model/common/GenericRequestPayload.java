package com.self.learning.model.common;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericRequestPayload<H, B> implements Serializable {
    private static final long serialVersionUID = 3986606510750893581L;

    @NotNull(message = "{model.notnull}")
    @Valid
    H head;

    @NotNull(message = "{model.notnull}")
    @Valid
    B body;
}
