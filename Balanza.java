import java.util.ArrayList;
import java.io.Serializable;

public class Balanza implements Serializable{
	private Long serialVersionUID = 42L;
	private String nombre;
	private ArrayList<Movimiento> movimientos;
	private ArrayList<Cuenta> cuentas;
	private ArrayList<T> tes;
	private double saldoAcredor,saldoDeudor;
	public Balanza(String nombre,ArrayList<Movimiento> movimientos, ArrayList<Cuenta> cuentas,ArrayList<T> tes){
		this.nombre = nombre;
		this.movimientos = new ArrayList<Movimiento>(movimientos);
		this.cuentas = new ArrayList<Cuenta>(cuentas);
		this.tes = new ArrayList<T>(tes);
		saldoDeudor = 0.0;
		saldoAcredor = 0.0;
	}
	public double getSaldoAcredor(){
		return 0.0;
	}
	public double getSaldoDeudor(){
		return 0.0;
	}
	public void setSaldoAcredor(double s){
		saldoAcredor = s;
	}
	public void setSaldoDeudor(double s){
		saldoDeudor = s;
	}
	public boolean estaBalanceada(){
		return saldoDeudor == saldoAcredor;
	}
	public double calculaSaldoAcredor(){
		double s = 0.0;
		for(T t: tes){
			
		}
		return s;
	}
}	