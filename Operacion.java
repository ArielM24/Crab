public class Operacion {
	private String id;
	private boolean tipo; //true -> cargo, false -> abono
	private double cantidad;
	private Cuenta cuenta;
	public Operacion(boolean tipo, double cantidad, Cuenta cuenta){
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.cuenta = cuenta;
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
}