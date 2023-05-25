package com.oguzcan.securitydemo.configuration;


import com.oguzcan.securitydemo.exception.NotFoundException;
import com.oguzcan.securitydemo.model.ErrorBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ApiResponse(responseCode = "403", description = "Forbidden Error",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorBody.class)))
    @ExceptionHandler({AuthenticationException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorBody catchForbiddenException(AuthenticationException exception) {
        log.error(exception.getClass().getSimpleName() + ": yetki yok.");
        return ErrorBody.builder()
                .errorCode(403)
                .errorDescription("Yetki yok.")
                .build();
    }

    @ApiResponse(responseCode = "404", description = "Not Found Error",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorBody.class)))
    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorBody catchNotFoundException(NotFoundException exception) {
        log.error(exception.getClass().getSimpleName() + ": " + exception.getMessage());
        return ErrorBody.builder()
                .errorCode(404)
                .errorDescription(exception.getMessage())
                .build();
    }
}
