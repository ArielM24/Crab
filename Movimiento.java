import java.util.ArrayList;

public class Movimiento {
	private String id;
	private ArrayList<Operacion> operaciones;
	public Movimiento(String id,ArrayList<Operacion> operaciones){
		this.id = id;
		this.operaciones = operaciones;
	}
	@Override
	public String toString(){
		return id;
	}
	public String getDescripcion(){
		String str = "";
		for(Operacion op: operaciones){
			str += op.toString()+"\n";
		}
		return str;
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof Movimiento){
			Movimiento aux = (Movimiento)obj;
			return aux.id.equals(this.id);
		}else return false;
	}

	public String getId(){
		return id;
	}
	public ArrayList<Operacion> getOperaciones(){
		return operaciones;
	}
}