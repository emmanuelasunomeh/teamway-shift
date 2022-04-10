package com.teamway.app.exceptions.globalException;

//import com.api.robotapocalypse.exceptions.LocationNotFoundException;
//import com.api.robotapocalypse.exceptions.SurvivalNotFoundException;
import com.teamway.app.exceptions.AlreadyExistsException;
import com.teamway.app.exceptions.CheckSameDayShiftException;
import com.teamway.app.exceptions.TimeTableNotFoundException;
import com.teamway.app.exceptions.WorkerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

@Slf4j
@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({TimeTableNotFoundException.class, WorkerNotFoundException.class})
    ResponseEntity<?> noRecordFound(Exception ex, WebRequest request) {
        return RestResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(ex.getMessage()==null?"NO RECORD FOUND":ex.getMessage())
                .entity();
    }

    @ExceptionHandler({CheckSameDayShiftException.class})
    ResponseEntity<?> checkSameDayException(Exception ex, WebRequest request) {
        return RestResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(ex.getMessage()==null?"YOU CAN'T WORK ANOTHER SHIFT FOR TODAY ":ex.getMessage())
                .entity();
    }

    @ExceptionHandler({AlreadyExistsException.class})
    ResponseEntity<?> AlreadyExistsException(Exception ex, WebRequest request) {
        return RestResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(ex.getMessage()==null?"RECORD ALREADY EXISTS!!":ex.getMessage())
                .entity();
    }

    @ExceptionHandler({InvalidDataAccessApiUsageException.class, IllegalArgumentException.class})
    ResponseEntity<?> IllegalArgument(Exception ex, WebRequest request) {
        return RestResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("THE GIVEN ID MUST NOT BE NULL")
                .entity();
    }


    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<?> handleExceptions(Exception ex, WebRequest request) {
        logger.error(ex.getLocalizedMessage(), ex);
        return RestResponse.builder()
                .status(SERVICE_UNAVAILABLE)
                .message("SERVER UNAVAILABLE, TRY AGAIN LATER: "+ex)
                .entity();
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest request) {
        logger.error(ex.getLocalizedMessage(), ex);
        return RestResponse.builder()
                .status(INTERNAL_SERVER_ERROR)
                .message("SERVER ENCOUNTER AN ERROR : "+ex)
                .entity();
    }

}