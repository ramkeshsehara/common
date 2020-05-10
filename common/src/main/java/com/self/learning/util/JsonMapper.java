package com.self.learning.util;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.TreeMap;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {

  private static ObjectMapper objectMapper = new ObjectMapper();

  static {
    // Convert to Date Time java 8
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    TimeZone timeZone = TimeZone.getTimeZone("IST");
    sdf.setTimeZone(timeZone);
    objectMapper.setDateFormat(sdf);
    objectMapper.setTimeZone(TimeZone.getTimeZone("IST"));
    objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    objectMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
  }

  public JsonMapper() {}

  public static Object getParamFromJson(String jsonString, String paramName)
      throws JsonProcessingException {
    return objectMapper.readTree(jsonString).get(paramName);
  }

  public static String mapObjectToJson(Object object)
      throws RuntimeException, JsonProcessingException {
    if (object != null) {
      return objectMapper.writeValueAsString(object);
    }

    return null;
  }

  public static TreeMap<String,String> mapObjectToTreemap(Object object)
          throws RuntimeException, JsonProcessingException {
    if (object != null) {
      return objectMapper.convertValue(object,TreeMap.class);
    }

    return null;
  }

  public static <T> T mapJsonToObject(String jsonObject, Class<T> clazz)
      throws RuntimeException, JsonProcessingException {
    T returnValue = objectMapper.readValue(jsonObject, clazz);
    return returnValue;
  }

  public static <T> T mapJsonToObjectWithType(String jsonObject, TypeReference<T> type)
      throws JsonProcessingException {
    T returnValue = null;
    returnValue = objectMapper.readValue(jsonObject, type);

    return returnValue;
  }
}
