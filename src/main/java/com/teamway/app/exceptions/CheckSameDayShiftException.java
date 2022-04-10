package com.teamway.app.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CheckSameDayShiftException extends RuntimeException {

	private static final long serialVersionUID = 8085333387338874650L;
	public CheckSameDayShiftException() {
        super();
    }
    public CheckSameDayShiftException(String message) {
        super(message);
    }


}