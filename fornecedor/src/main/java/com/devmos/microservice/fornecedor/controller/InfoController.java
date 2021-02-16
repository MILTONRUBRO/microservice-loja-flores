package com.devmos.microservice.fornecedor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmos.microservice.fornecedor.model.InfoFornecedor;
import com.devmos.microservice.fornecedor.service.InforService;

@RestController
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	private InforService infoService;
	
	@GetMapping("/{estado}")
	public InfoFornecedor getInfo(@PathVariable("estado") String estado) {
		return infoService.getInfoPorEstado(estado);
	}

}
