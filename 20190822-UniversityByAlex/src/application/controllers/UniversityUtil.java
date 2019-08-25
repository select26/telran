package application.controllers;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import application.exceptions.DuplicateDataException;
import application.exceptions.NoDataFoundException;
import application.exceptions.NoStudentsException;
import application.exceptions.RemoveForbiddenException;

public class UniversityUtil {
	
	public static <T,R> List<R> listToList(List<T> list, Function<T,R> mapper){
		return list.stream().map(mapper).collect(Collectors.toList());
	}
	
	public static ResponseEntity<String> exceptionsHandler(Exception e){
		Class<?> eClass = e.getClass();
		if (eClass.equals(NoDataFoundException.class) ||
			eClass.equals(DuplicateDataException.class) ||
			eClass.equals(RemoveForbiddenException.class) ||
			eClass.equals(NoStudentsException.class))
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<String>("Server error", HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
