import java.util.HashMap;

public class Cuenta {
	private String nombre;
	private String descripcion;
	private HashMap<String,Movimiento> movimientos;
	public Cuenta(String nombre) {
		this.nombre = nombre;
		this.descripcion = " ifrji{rifoneqrfionq3oifn4oinfo2irnadasasasdas.\nsdnsd.";
	}

	public String getNombre(){
		return nombre;
	}

	public String getDescripcion(){
		return descripcion;
	}

	@Override
	public String toString(){
		return nombre;
	}
}