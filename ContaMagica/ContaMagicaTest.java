package ContaMagica;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContaMagicaTest {

	private ContaMagica conta;
	private String nome;
	
	@Before
	public void setUp() throws Exception {
		conta = new ContaMagica(nome);
		conta.deposito(100000.00);
		conta.retirada(0.1);
	}

	@Test
	public void depositoSilverTest() {
		conta.deposito(50000.00);
		assertEquals(50500.00, conta.getSaldo());
	}
	@Test
	public void depositoGoldTest() {
		conta.deposito(200000.00);
		assertEquals(205000.00, conta.getSaldo());
	}
	
	@Test
	public void getStatusTest(){
		Categorias cat = conta.getStatus();
		assertEquals(205000.00, cat);
	}
	@Test
	public void retiradaSilverTest(){
		conta.retirada(0.1);
		assertEquals(49999.90, conta.getSaldo());
	}
	
	@Test
	public void retiradaGoldTest(){
		conta.retirada(0.1);
		assertEquals(24999.90, conta.getSaldo());
	}
	@Test
	public void retiradaPlatinumTest(){
		conta.retirada(0.1);
		assertEquals(99999.90, conta.getSaldo());
	}


}
