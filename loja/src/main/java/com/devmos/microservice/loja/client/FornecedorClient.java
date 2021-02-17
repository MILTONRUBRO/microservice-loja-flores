package com.devmos.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.devmos.microservice.loja.controller.dto.InfoFornecedorDTO;
import com.devmos.microservice.loja.controller.dto.InfoPedidoDTO;
import com.devmos.microservice.loja.controller.dto.ItemCompraDTO;


@FeignClient("fornecedor")
public interface FornecedorClient {
	
	@GetMapping("/info/{estado}")
	InfoFornecedorDTO getInfo(@PathVariable("estado") String estado);
	
	@PostMapping("/pedido")
	InfoPedidoDTO realizaPedido(List<ItemCompraDTO> itens);
	

}
