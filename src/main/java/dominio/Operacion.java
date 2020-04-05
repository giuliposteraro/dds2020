package dominio;

import java.util.ArrayList;
import java.util.List;

import excepciones.NoSePuedeCambiarPrecio;
import excepciones.NoSePuedeGenerarDocumento;

public class Operacion {
	List<Item> items;
	private int precioFinal;
	Estado estadoOperacion;
	
	public Operacion(Estado nuevoEstado, int nuevoPrecio, List<Item> items) {
		this.items = new ArrayList<Item>();
		this.estadoOperacion = nuevoEstado;
		this.precioFinal = nuevoPrecio;
	}
	
	public int modificarPrecioFinal() {
		if(estadoOperacion.equals(Estado.CERRADA)) {
			throw new NoSePuedeCambiarPrecio("No se puede modificar el precio porque la operacion esta cerrada");
		}
		return obtenerPrecioFinal(); 
	}

	public Estado getEstadoOperacion() {
		return estadoOperacion;
	}

	public void setEstadoOperacion(Estado estadoOperacion) {
		this.estadoOperacion = estadoOperacion;
	}
	
	public void agregarItem(Item nuevoItem) {
		this.items.add(nuevoItem);
	}
	public void quitarItem(Item item) {
		this.items.remove(item);
	}
	
	
	public int obtenerPrecioFinal() {
		int valorTotal = this.items.stream()
			      		.mapToInt(item -> item.getPrecio())
			      		.sum();
		return this.precioFinal = valorTotal;
	}


	public Documento compra() {
		if(!this.items.stream().allMatch(item->item.getTipo().equals(TipoItem.ARTICULO))){
			throw new NoSePuedeGenerarDocumento("No se genera remito");
		}
		return new Documento(TipoDocumento.REMITO);
	}
}
