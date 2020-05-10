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
public class GenericRequest<R> implements Serializable {
  private static final long serialVersionUID = -3017266557673672870L;

  @NotNull(message = "{model.notnull}")
  @Valid
  private R request;

  private String signature;
}
