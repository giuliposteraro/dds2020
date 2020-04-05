package excepciones;

public class NoSePuedeGenerarDocumento extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NoSePuedeGenerarDocumento(String mensaje) {
		super(mensaje);
	}
}
