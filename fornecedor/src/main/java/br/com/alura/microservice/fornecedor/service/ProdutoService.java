package br.com.alura.microservice.fornecedor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.alura.microservice.fornecedor.model.Produto;
import br.com.alura.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getProdutosPorEstado(String estado) {
		return produtoRepository.findByEstado(estado);
	}
	
	public Produto getProdutoPorid(Long id) {
		 Optional<Produto> possivelProduto = produtoRepository.findById(id);
		 
		 if(!possivelProduto.isPresent()) {
			 throw new  ResponseStatusException(HttpStatus.NOT_FOUND);
		 }
		 
		 return possivelProduto.get();
		
	}

	
}
