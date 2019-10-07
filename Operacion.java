public class Operacion {
	private String id;
	private boolean tipo; //true -> cargo, false -> abono
	private double cantidad;
	public Operacion(boolean tipo, double cantidad){
		this.tipo = tipo;
		this.cantidad = cantidad;
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof Operacion){
			Operacion aux = (Operacion)obj;
			return aux.id.equals(this.id);
		}else return false;
	}
}