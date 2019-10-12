import java.util.ArrayList;

public class GeneraCuentas {
	public static ArrayList<Cuenta> generaCuentas(){
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Cuenta caja = new Cuenta("Caja");
		caja.setDescripcion("");
		cuentas.add(caja);
		Cuenta bancos = new Cuenta("Bancos");
		bancos.setDescripcion("");
		cuentas.add(bancos);
		Cuenta almacen = new Cuenta("Almacen");
		almacen.setDescripcion("");
		cuentas.add(almacen);

		return cuentas;
	}
}