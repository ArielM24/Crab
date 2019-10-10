import java.util.ArrayList;

public class Movimiento {
	private String id;
	private ArrayList<Operacion> operaciones;
	public Movimiento(String id,ArrayList<Operacion> operaciones){
		this.id = id;
		this.operaciones = new ArrayList<Operacion>(operaciones);
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
	public void borraC(Cuenta c){
		ArrayList<Operacion> aux = new ArrayList<Operacion>();
		for(Operacion op: operaciones){
			if(!op.getCuenta().equals(c)){
				aux.add(op);
			}
		}
		operaciones = new ArrayList<Operacion>(aux);
	}
	public void cambiaC(Cuenta c1, Cuenta c2){
		ArrayList<Operacion> aux = new ArrayList<Operacion>();
		for(Operacion op: operaciones){
			if(op.getCuenta().equals(c1)){
				op.setCuenta(c2);
				aux.add(op);
			}else{
				aux.add(op);
			}
		}
		operaciones = new ArrayList<Operacion>(aux);
	}
	public boolean contieneCuenta(Cuenta c){
		boolean s = false;
		for(Operacion op: operaciones){
			if(op.getCuenta().equals(c)){
				s = true;
				break;
			}
		}
		return s;
	}
}