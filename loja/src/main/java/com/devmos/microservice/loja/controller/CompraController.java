package com.devmos.microservice.loja.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmos.microservice.loja.controller.dto.CompraDTO;
import com.devmos.microservice.loja.service.CompraService;

@RestController
@RequestMapping("/compra")
public class CompraController {
	
	private CompraService compraService;
	
	@PostMapping
	public void realizaCompra(@RequestBody CompraDTO compra){
		
		compraService.realizaCompra(compra);
		
	}

}
