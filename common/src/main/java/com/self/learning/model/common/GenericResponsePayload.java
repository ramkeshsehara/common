package com.self.learning.model.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericResponsePayload<H, B> implements Serializable {

    private static final long serialVersionUID = 2256329541175020485L;
    @NotNull(message = "{model.notnull}")
    @Valid
    H head;

    @NotNull(message = "{model.notnull}")
    @Valid
    B body;
}
