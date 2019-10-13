import java.util.ArrayList;
import java.io.*;

public class TSerializable implements Serializable{
	private static final long serialVersionUID = 6529685098267757690L;
	private Cuenta cuenta;
	private double movAcreedor, movDeudor;

	public TSerializable(Cuenta cuenta, double d,double a){
		this.cuenta = cuenta;
		movDeudor = d;
		movAcreedor = a;
	}

	public double getMovDeudor(){
		return movDeudor;
	}
	public double getMovAcreedor(){
		return movAcreedor;
	}
	public double getSaldo(){
		return movDeudor - movAcreedor;
	}
	public int getLongitudDatos(){
		int l = 40;
		int d = MuestraBalanza.strSize("$"+movDeudor);
		int a = MuestraBalanza.strSize("$"+movAcreedor);
		int c = MuestraBalanza.strSize(cuenta.getNombre());
		if(d > l)
			l = d;
		if(a > l)
			l = a;
		if(c > l)
			l = c;
		return l;
	}
	public Cuenta getCuenta(){
		return cuenta;
	}
}