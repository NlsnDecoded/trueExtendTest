package com.restApi.Util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restApi.ErrorException;
import com.restApi.ErrorResponse;
import org.primefaces.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Nelson Flores B.
 * @version: 1.0
 * @created: 07-jun.-2020  15:21
 */

public class Util {
    public static String REST_SERVICE_URL = "http://localhost:8080/restService";

    public static HttpHeaders getHeaders() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String header = request.getHeader("Authorization");
        String base64Credentials = header;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    public static JSONObject sendRestEntityPOSTJSON(String URL, String objectClass) throws ErrorException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity entity = new HttpEntity(objectClass, Util.getHeaders());
        String string = restTemplate.exchange(REST_SERVICE_URL + URL, HttpMethod.POST, entity, String.class).getBody();

        return getRestEntity(string);
    }

    public static JSONObject getRestEntity(String cadenaRest) throws ErrorException {
        ObjectMapper objMapper = new ObjectMapper();
        JSONObject object = new JSONObject(cadenaRest);
        object = (JSONObject) object.get("entity");
        ErrorResponse errorResponse;
        try {
            errorResponse = objMapper.readValue(object.get("response").toString(), ErrorResponse.class);
        } catch (IOException e) {
            throw new ErrorException("Error en lectura de JSON");
        }
        if (!errorResponse.getStatus().equals("OK")) {
            throw new ErrorException(errorResponse.getMessage());
        }
        return object;
    }

    public static <T> T readJsonValue(JSONObject jsonObject, Class<T> classType) throws ErrorException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonObject.toString(), classType);
        } catch (IOException e) {
            throw new ErrorException("Error en lectura de JSON");
        }
    }

    public static <T> T readJsonValue(JSONObject jsonObject, String value, Class<T> classType) throws ErrorException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonObject.get(value).toString(), classType);
        } catch (IOException e) {
            throw new ErrorException("Error en lectura de JSON");
        }
    }

    public static <T> T readJsonValue(JSONObject jsonObject, String value, TypeReference valueTypeRef) throws ErrorException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonObject.get(value).toString(), valueTypeRef);
        } catch (IOException e) {
            throw new ErrorException("Error en lectura de JSON");
        }
    }

    public static Map restOK(Map map) {
        map.put("response", new ErrorResponse());
        return map;
    }

    public static Map restNOK(String messag) {
        Map map = new HashMap();
        map.put("response", new ErrorResponse(messag));
        return map;
    }

}
