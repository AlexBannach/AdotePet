package br.com.pet.adoteumpet.api.common.handlers;

import br.com.pet.adoteumpet.api.common.dtos.ErrorResponse;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final PropertyNamingStrategies.SnakeCaseStrategy snakeCase = new PropertyNamingStrategies.SnakeCaseStrategy();

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        var body = ErrorResponse.builder()
                .status(status.value())
                .error(status.getClass().getName())
                .cause(exception.getClass().getSimpleName())
                .message("Houve erros de validação")
                .timestamp(LocalDateTime.now())
                .errors(convertFieldErrorsToMap(exception.getBindingResult().getFieldErrors()))
                .build();
        return new ResponseEntity<>(body, status);
    }
    private Map<String, List<String>> convertFieldErrorsToMap(List<FieldError> fieldErrors) {
        var errors = new HashMap<String, List<String>>();
        fieldErrors.stream().forEach(fieldError -> {
            var field = snakeCase.translate(fieldError.getField());
            if (errors.containsKey(field)) {
                errors.get(field).add(fieldError.getDefaultMessage());

            } else {
                errors.put(field,
                        Stream.of(fieldError.getDefaultMessage())
                                .collect(Collectors.toList()));
            }
        });
        return errors;
    }
}
