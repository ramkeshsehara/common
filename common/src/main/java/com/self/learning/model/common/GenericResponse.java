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
public class GenericResponse<R> implements Serializable {

    private static final long serialVersionUID = 327587592455659073L;
    @NotNull(message = "{model.notnull}")
    @Valid
    private R response;
}
