package dominio;

public class Item {
	int precio;
	TipoItem tipo;
	
	public TipoItem getTipo() {
		return tipo;
	}
	public void setTipo(TipoItem tipo) {
		this.tipo = tipo;
	}
	public Item(int precio, TipoItem tipo) {
		this.precio = precio;
		this.tipo = tipo;
	}
	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int nuevoPrecio) {
		this.precio = nuevoPrecio;

	}

}
