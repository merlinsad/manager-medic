package com.med.rest.infra.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ExceptionHelper {

	//Classe responsável por tratar Exceptions

	//Converter erro 500 para 404 ao procurar um dado e não encontrar
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity exceptionErrorHttp404() {
		return ResponseEntity.notFound().build();
	}

	//Tratar dados inválidos ao criar médico
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity exceptionError400PostMedic(MethodArgumentNotValidException exceptions) {
		List<ExceptionPostMedicError400DTO> exceptionFieldErrors = new ArrayList<ExceptionPostMedicError400DTO>();
		for(ObjectError argumentNotValidException : exceptions.getAllErrors()) {
			//Feito cast para FieldError pois ObjectError herdava o atributo Field mas não possuia o get do mesmo
			FieldError fieldError = (FieldError) argumentNotValidException;

			ExceptionPostMedicError400DTO error400dto = new ExceptionPostMedicError400DTO();
			error400dto.setError(fieldError.getDefaultMessage());
			error400dto.setField(fieldError.getField());
			exceptionFieldErrors.add(error400dto);
		}

		return ResponseEntity.badRequest().body(exceptionFieldErrors);
	}
}
