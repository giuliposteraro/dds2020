package excepciones;

public class NoSePuedeCambiarPrecio extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NoSePuedeCambiarPrecio(String mensaje) {
		super(mensaje);
	}
}
