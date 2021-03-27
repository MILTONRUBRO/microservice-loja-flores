package br.com.alura.microservice.fornecedor.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.microservice.fornecedor.model.Produto;
import br.com.alura.microservice.fornecedor.repository.ProdutoRepository;
import br.com.alura.microservice.fornecedor.service.ProdutoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProdutoServiceTest {
	
	@MockBean
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Before
	public void setup() {
		
		BDDMockito.given(produtoRepository.findByEstado(Mockito.anyString())).willReturn(getListProdutos());
		BDDMockito.given(produtoRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Produto()));

	}
	
	@Test
	public void testGetProdutosPorEstado() {
		List<Produto> produtosPorEstado = produtoService.getProdutosPorEstado("SP");
		assertNotNull(produtosPorEstado);
	}

	private List<Produto> getListProdutos() {
		List<Produto> produtos = List.of(new Produto());
		return produtos;
	}
	
	@Test
	public void testGetProdutoporId() {
		Produto produtoPorid = produtoService.getProdutoPorid(1L);
		assertNotNull(produtoPorid);
	}
	

}
