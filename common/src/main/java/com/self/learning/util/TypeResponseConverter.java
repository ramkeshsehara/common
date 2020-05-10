package com.self.learning.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.paytm.iot.models.common.GenericResponse;

public class TypeResponseConverter {

  public static <T> GenericResponse<T> convert(String s, TypeReference<T> typeReference)
      throws JsonProcessingException {
    GenericResponse<T> genericResponse = new GenericResponse<>();
    genericResponse.setResponse(JsonMapper.mapJsonToObjectWithType(s, typeReference));

    return genericResponse;
  }
}
