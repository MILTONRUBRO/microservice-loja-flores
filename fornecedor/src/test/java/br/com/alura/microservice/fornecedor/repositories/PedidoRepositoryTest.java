package br.com.alura.microservice.fornecedor.repositories;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.microservice.fornecedor.model.Pedido;
import br.com.alura.microservice.fornecedor.model.PedidoItem;
import br.com.alura.microservice.fornecedor.model.PedidoStatus;
import br.com.alura.microservice.fornecedor.repository.PedidoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class PedidoRepositoryTest {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Before
	public void setup() {
		Pedido pedido = new Pedido();
		pedido.setStatus(PedidoStatus.PRONTO);
		pedido.setTempoDePreparo(24);
	}
	
	@Test
	public void testSave() {
		List<PedidoItem> itens = new ArrayList<>();
		PedidoItem item = new PedidoItem();
		itens.add(item);
		
		Pedido pedido = new Pedido();
		pedido.setStatus(PedidoStatus.PRONTO);
		pedido.setTempoDePreparo(13);
		pedido.setItens(itens);
		
		Pedido savedPedido = pedidoRepository.save(pedido);
		
		assertNotNull(savedPedido);
	}

}
