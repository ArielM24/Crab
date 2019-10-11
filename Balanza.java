import java.util.ArrayList;
import java.io.Serializable;

public class Balanza implements Serializable{
	private Long serialVersionUID = 42L;
	private String nombre;
	private ArrayList<TSerializable> datos;
	private double saldoAcreedor,saldoDeudor;
	public Balanza(String nombre,ArrayList<TSerializable> datos){
		this.nombre = nombre;
		this.datos = new ArrayList<TSerializable>(datos);
		saldoDeudor = 0.0;
		saldoAcreedor = 0.0;
	}
	public double getSaldoAcreedor(){
		return saldoAcreedor;
	}
	public double getSaldoDeudor(){
		return saldoDeudor;
	}
	public void setSaldoAcreedor(double s){
		saldoAcreedor = s;
	}
	public void setSaldoDeudor(double s){
		saldoDeudor = s;
	}
	public double getSaldo(){
		return saldoDeudor - saldoAcreedor;
	}
	public boolean estaBalanceada(){
		return saldoDeudor == saldoAcreedor;
	}
	public String getNombre(){
		return nombre;
	}
	public ArrayList<TSerializable> getDatos(){
		return datos;
	}
	public int getLongitudDatos(){
		int l = 30;
		for(TSerializable ts: datos){
			int s = ts.getLongitudDatos();
			if(s > l)
				l = s;
		}
		return l;
	}
	public double getMovDeudor(){
		double d = 0.0;
		for(TSerializable ts: datos){
			d += ts.getMovDeudor();
		}
		return d;
	}
	public double getMovAcreedor(){
		double a = 0.0;
		for(TSerializable ts: datos){
			a += ts.getMovAcreedor();
		}
		return a;
	}
	public double[] getSaldos(){
		double saldos[] = {0.0,0.0};
		for(TSerializable ts: datos){
			if(ts.getSaldo() < 0){
				saldos[1] += -ts.getSaldo();
			}else{
				saldos[0] += ts.getSaldo();
			}
		}
		return saldos;
	}

}	