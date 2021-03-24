package br.com.alura.microservice.fornecedor.repositories;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.microservice.fornecedor.model.Produto;
import br.com.alura.microservice.fornecedor.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProdutoRepositoryTest {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	private static final String ESTADO = "SP";
	
	@Before
	public void setup() {
		Produto produto = new Produto();
		produto.setDescricao("Ramo de Margaridas");
		produto.setEstado("SP");
		produto.setNome("Margaridas");
		produto.setPreco(new BigDecimal(320));
		
		produtoRepository.save(produto);
	}
	
	@After
	public void tearDown() {
		produtoRepository.deleteAll();
	}
	
	@Test
	public void testBuscaProdutoPorEstado() {
		List<Produto> estados = produtoRepository.findByEstado(ESTADO);
		assertTrue(!estados.isEmpty());
	}
	

}
