package com.devmos.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmos.microservice.loja.client.FornecedorClient;
import com.devmos.microservice.loja.controller.dto.CompraDTO;
import com.devmos.microservice.loja.controller.dto.InfoFornecedorDTO;
import com.devmos.microservice.loja.controller.dto.InfoPedidoDTO;
import com.devmos.microservice.loja.model.Compra;

@Service
public class CompraService {
	
	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraDTO compra) {
		InfoFornecedorDTO info = fornecedorClient.getInfo(compra.getEndereco().getEstado());
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		System.out.println(info.getEndereco());
		
		Compra compraSalva = new Compra();
		
		compraSalva.setPedidoId(pedido.getId());
		compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
		compraSalva.setEnderecoDestino(compra.getEndereco().toString());
		
		return compraSalva;
	}

}
