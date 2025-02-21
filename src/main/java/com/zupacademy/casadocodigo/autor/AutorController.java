package com.zupacademy.casadocodigo.autor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zupacademy.casadocodigo.validator.VerificaEmailDuplicadoValidator;

@RestController
@RequestMapping("/autor")
public class AutorController {
	private final AutorRepository autorRepository;

	/**
	 * 
	 * @param autorRepository
	 * @param verificaEmailDuplicadoValidator
	 */
	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	
	@PostMapping
	private ResponseEntity<AutorDto> cadastrar(@RequestBody @Validated AutorForm autorForm)
			throws Exception{
		Autor autor = autorForm.converter();
		autorRepository.save(autor);
		
		AutorDto autorDto = autor.resposta();
		return ResponseEntity.status(HttpStatus.CREATED).body(autorDto);


    }
		
		
}
	


