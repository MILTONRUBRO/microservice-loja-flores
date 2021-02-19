package com.devmos.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmos.microservice.loja.client.FornecedorClient;
import com.devmos.microservice.loja.controller.dto.CompraDTO;
import com.devmos.microservice.loja.controller.dto.InfoFornecedorDTO;
import com.devmos.microservice.loja.controller.dto.InfoPedidoDTO;
import com.devmos.microservice.loja.model.Compra;

@Service
public class CompraService {
	
	private static final Logger logger = LoggerFactory.getLogger(CompraService.class);
	
	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraDTO compra) {
		logger.info("Buscando informações do fornecedor de " + compra.getEndereco().getEstado());
		
		InfoFornecedorDTO info = fornecedorClient.getInfo(compra.getEndereco().getEstado());
		
		logger.info("Realizando um pedido");
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		Compra compraSalva = new Compra();
		
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
		return compraSalva;
	}

}
