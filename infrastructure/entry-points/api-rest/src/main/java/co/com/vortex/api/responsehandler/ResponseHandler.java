package co.com.vortex.api.responsehandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static <T> ResponseEntity<T> generateResponse(T data, HttpStatus httpStatus) {
        return new ResponseEntity<>(data, httpStatus);
    }

    public static <T> ResponseEntity<T> generateEmptyResponse(HttpStatus httpStatus) {
        return new ResponseEntity<>(httpStatus);
    }
}
