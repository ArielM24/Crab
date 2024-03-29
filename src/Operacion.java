import java.io.*;
public class Operacion implements Serializable{
	private static final long serialVersionUID = 6529685098267757690L;
	private String id;
	private boolean tipo; //true -> cargo, false -> abono
	private double cantidad;
	private Cuenta cuenta;
	public Operacion(boolean tipo, double cantidad, Cuenta cuenta,String id){
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.cuenta = cuenta;
		this.id = id;
	}

	public boolean getTipo(){
		return tipo;
	}

	public double getCantidad(){
		return cantidad;
	}

	public Cuenta getCuenta(){
		return cuenta;
	}

	public void setCuenta(Cuenta c){
		this.cuenta = c;
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof Operacion){
			Operacion aux = (Operacion)obj;
			return aux.id.equals(this.id);
		}else return false;
	}

	@Override
	public String toString(){
		String op = cuenta.toString()+"\n";
		if(tipo){
			return op+"Cargo: $"+cantidad;
		}else{
			return op+"Abono: $"+cantidad;
		}
	}
	public String getId(){
		return id;
	}
}