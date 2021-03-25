package br.com.alura.microservice.fornecedor.services;

import static org.junit.Assert.assertNotNull;

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

import br.com.alura.microservice.fornecedor.model.Pedido;
import br.com.alura.microservice.fornecedor.repository.PedidoRepository;
import br.com.alura.microservice.fornecedor.service.PedidoService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PedidoServiceTest {
	
	@MockBean
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Before
	public void setup() {
		BDDMockito.given(pedidoRepository.findById(Mockito.anyLong())).willReturn(Optional.of(new Pedido()));
	}
	
	@Test
	public void testGetPedidoById() {
		Pedido pedidoPorId = pedidoService.getPedidoPorId(1L);
		assertNotNull(pedidoPorId);
	}

}
