import java.util.ArrayList;
import java.io.*;

public class TSerializable implements Serializable{
	private Long serialVersionUID = 42L;
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
		int l = 30;
		String d = "$"+movDeudor,a = "$"+movAcreedor,c = cuenta.getNombre();
		if(d.length() > l)
			l = d.length();
		if(a.length() > l)
			l = a.length();
		if(c.length() > l)
			l = c.length();
		return l;
	}
	public Cuenta getCuenta(){
		return cuenta;
	}
}