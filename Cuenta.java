import java.util.HashMap;

public class Cuenta {
	private String nombre;
	private String descripcion;
	private HashMap<String,Movimiento> movimientos;
	public Cuenta(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString(){
		return nombre;
	}
}