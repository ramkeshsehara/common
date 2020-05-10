package com.self.learning.util;

import com.paytm.iot.exception.JerseyClientException;
import com.paytm.pgplus.httpclient.HttpRequestPayload;
import com.paytm.pgplus.httpclient.JerseyHttpClient;
import com.paytm.pgplus.httpclient.exception.HttpCommunicationException;
import com.paytm.pgplus.httpclient.exception.IllegalPayloadException;

import javax.ws.rs.core.Response;

public class JerseyClientUtil {

  public static <P, T> P sendPost(HttpRequestPayload<T> requestPayload, Class<P> type)
      throws JerseyClientException {

    Response response = null;
    try {
      response = JerseyHttpClient.sendHttpPostRequest(requestPayload);

    } catch (HttpCommunicationException | IllegalPayloadException e) {
      throw new JerseyClientException("Jersey Client Exception", e);
    }
    return response.readEntity(type);
  }
}
