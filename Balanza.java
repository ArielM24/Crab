import java.util.ArrayList;
import java.io.Serializable;

public class Balanza implements Serializable{
	private Long serialVersionUID = 42L;
	private String nombre;
	private ArrayList<Movimiento> movimientos;
	private ArrayList<Cuenta> cuentas;
	private double saldoAcreedor,saldoDeudor;
	public Balanza(String nombre,ArrayList<Movimiento> movimientos, ArrayList<Cuenta> cuentas){
		this.nombre = nombre;
		this.movimientos = new ArrayList<Movimiento>(movimientos);
		this.cuentas = new ArrayList<Cuenta>(cuentas);
		saldoDeudor = 0.0;
		saldoAcreedor = 0.0;
	}
	public double getSaldoAcreedor(){
		return 0.0;
	}
	public double getSaldoDeudor(){
		return 0.0;
	}
	public void setSaldoAcreedor(double s){
		saldoAcreedor = s;
	}
	public void setSaldoDeudor(double s){
		saldoDeudor = s;
	}
	public boolean estaBalanceada(){
		return saldoDeudor == saldoAcreedor;
	}
	public String getNombre(){
		return nombre;
	}
}	