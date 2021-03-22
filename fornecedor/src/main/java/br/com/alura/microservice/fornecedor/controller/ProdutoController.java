package br.com.alura.microservice.fornecedor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.fornecedor.model.Produto;
import br.com.alura.microservice.fornecedor.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

	
	@RequestMapping("/{estado}")
	public List<Produto> getProdutosPorEstado(@PathVariable("estado") String estado) {
		logger.info("Buscando um produo pelo estado " + estado);
		return produtoService.getProdutosPorEstado(estado);
	}
}
