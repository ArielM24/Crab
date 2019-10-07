import java.util.HashMap;

public class Movimiento {
	private String id;
	private HashMap<Cuenta, Operacion> operaciones;
	public Movimiento(String id,HashMap<Cuenta, Operacion> operaciones){
		this.id = id;
		this.operaciones = operaciones;
	}
}