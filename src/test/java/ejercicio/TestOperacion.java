package ejercicio;



import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.ArrayList;
import java.util.List;

import dominio.Estado;
import dominio.Item;
import dominio.Operacion;
import dominio.TipoItem;
import excepciones.NoSePuedeCambiarPrecio;
import excepciones.NoSePuedeGenerarDocumento;


public class TestOperacion {
	
	Operacion operacionDeEgreso;
	Item maquina;
	Item lapicera;
	Item luz;
	Item gas;
	List<Item> items;
	
	@Before
	public void init() {
		items = new ArrayList<Item>();
		operacionDeEgreso = new Operacion(Estado.ABIERTA,0,items);
		maquina = new Item(250,TipoItem.ARTICULO);
		lapicera = new Item(90, TipoItem.ARTICULO);
		luz = new Item(800,TipoItem.SERVICIO);
		gas = new Item(500, TipoItem.SERVICIO);
	}
	
	
	@Test
	public void valorConItems() {
		operacionDeEgreso.agregarItem(maquina);
		operacionDeEgreso.agregarItem(lapicera);
		operacionDeEgreso.agregarItem(luz);
		operacionDeEgreso.agregarItem(gas);
		
		assertEquals(1640,operacionDeEgreso.obtenerPrecioFinal());
	}
	
	@Test
	public void valorSinItems() {
		assertEquals(0,operacionDeEgreso.obtenerPrecioFinal());
	}
	
	@Test(expected = NoSePuedeCambiarPrecio.class)
	public void cambiarPrecioConOperacionCerrada() {
		operacionDeEgreso.agregarItem(maquina);
		operacionDeEgreso.agregarItem(lapicera);
		operacionDeEgreso.agregarItem(luz);
		operacionDeEgreso.agregarItem(gas);
		maquina.setPrecio(300);
		
		operacionDeEgreso.setEstadoOperacion(Estado.CERRADA);
		operacionDeEgreso.modificarPrecioFinal();
	}
	
	@Test
	public void cambiarPrecioConOperacionAbierta() {
		operacionDeEgreso.agregarItem(maquina);
		operacionDeEgreso.agregarItem(lapicera);
		operacionDeEgreso.agregarItem(luz);
		operacionDeEgreso.agregarItem(gas);
		maquina.setPrecio(300);
		
		assertEquals(1690,operacionDeEgreso.modificarPrecioFinal());
		
	}
	
	@Test
	public void generarDocumentoConSoloArticulos() {
		operacionDeEgreso.agregarItem(maquina);
		operacionDeEgreso.agregarItem(lapicera);
		
		assertNotNull(operacionDeEgreso.compra());
	}
	
	@Test(expected = NoSePuedeGenerarDocumento.class)
	public void noGenerarDocumentoConItems() {
		operacionDeEgreso.agregarItem(maquina);
		operacionDeEgreso.agregarItem(lapicera);
		operacionDeEgreso.agregarItem(luz);
		operacionDeEgreso.agregarItem(gas);
		
		operacionDeEgreso.compra();
	}
}
