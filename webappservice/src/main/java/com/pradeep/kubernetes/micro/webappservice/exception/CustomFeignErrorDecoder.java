package com.pradeep.kubernetes.micro.webappservice.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.databind.ObjectMapper;


public class CustomFeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorResponse error = objectMapper.readValue(response.body().asInputStream(), ErrorResponse.class);

            if (response.status() == HttpStatus.NOT_FOUND.value()) {
                return new ResourceNotFoundException(error.getMessage());
            }

            // Handle other statuses if needed
            return new RuntimeException("Unknown error: " + error.getMessage());

        } catch (IOException e) {
            return new RuntimeException("Failed to decode error response", e);
        }
    }
}

