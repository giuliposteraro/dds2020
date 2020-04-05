package dominio;

import java.util.ArrayList;
import java.util.List;

import excepciones.NoSePuedeCambiarPrecio;
import excepciones.NoSePuedeGenerarDocumento;

public class Operacion {
	List<Item> items = new ArrayList<Item>();
	private double precioFinal;
	Estado estadoOperacion;
	
	private Operacion() {}
	
	public Operacion(Estado nuevoEstado, double nuevoPrecio) {
		this.estadoOperacion = nuevoEstado;
		this.precioFinal = nuevoPrecio;
	}
	
	public double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(double precioFinal) {
		if(estadoOperacion.equals(Estado.Cerrado)) {
			throw new NoSePuedeCambiarPrecio("No se puede cambiar el precio porque la operacion esta cerrada");
		}
		this.precioFinal = precioFinal;
	}
	public void agregarArticulo(Item nuevoItem) {
		this.items.add(nuevoItem);
	}
	public void quitarArticulo(Item item) {
		this.items.remove(item);
	}
	
	
	public double valor() {
		double valorTotal = this.items.stream()
			      		.mapToDouble(o -> o.getPrecio())
			      		.sum();
		return valorTotal;
	}
	
	public Documento compra() {
		if(!this.items.stream().allMatch(item->item.equals(TipoItem.Articulo))) {
			throw new NoSePuedeGenerarDocumento("No se genera remito");
		}
		return new Documento();
	}
}
