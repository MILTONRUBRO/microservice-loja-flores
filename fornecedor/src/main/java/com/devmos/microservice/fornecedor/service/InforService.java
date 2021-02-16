package com.devmos.microservice.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmos.microservice.fornecedor.model.InfoFornecedor;
import com.devmos.microservice.fornecedor.repository.InfoRepository;

@Service
public class InforService {
	
	@Autowired
	private InfoRepository infoRepository;

	public InfoFornecedor getInfoPorEstado(String estado) {
		return infoRepository.findByEstado(estado);
	}

}
