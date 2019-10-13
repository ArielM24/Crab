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

		Cuenta clientes = new Cuenta("Clientes");
		clientes.setDescripcion("");
		cuentas.add(clientes);

		Cuenta docCobrar = new Cuenta("Documentos por cobrar");
		docCobrar.setDescripcion("");
		cuentas.add(docCobrar);

		Cuenta deudores = new Cuenta("Deudores");
		deudores.setDescripcion("");
		cuentas.add(deudores);

		Cuenta terrenos = new Cuenta("Terrenos");
		terrenos.setDescripcion("");
		cuentas.add(terrenos);

		Cuenta edificios = new Cuenta("Edificios");
		edificios.setDescripcion("");
		cuentas.add(edificios);

		Cuenta mobiliario = new Cuenta("Mobiliario y equipo");
		mobiliario.setDescripcion("");
		cuentas.add(mobiliario);

		Cuenta eqComputo = new Cuenta("Equipo de computo");
		eqComputo.setDescripcion("");
		cuentas.add(eqComputo);

		Cuenta eqReparto = new Cuenta("Equipo de reparto");
		eqReparto.setDescripcion("");
		cuentas.add(eqReparto);

		Cuenta eqTransporte = new Cuenta("Equipo de transporte");
		eqTransporte.setDescripcion("");
		cuentas.add(eqTransporte);

		Cuenta depGarantia = new Cuenta("Depositos en garantia");
		depGarantia.setDescripcion("");
		cuentas.add(depGarantia);

		Cuenta gastOrg = new Cuenta("Gastos de organizacion");
		gastOrg.setDescripcion("");
		cuentas.add(gastOrg);

		Cuenta gastInst = new Cuenta("Gastos de instalacion");
		gastInst.setDescripcion("");
		cuentas.add(gastInst);

		Cuenta proveedores = new Cuenta("Proveedores");
		proveedores.setDescripcion("");
		cuentas.add(proveedores);

		Cuenta acreedores = new Cuenta("Acreedores");
		acreedores.setDescripcion("");
		cuentas.add(acreedores);

		Cuenta docPagar = new Cuenta("Documentos por pagar");
		docPagar.setDescripcion("");
		cuentas.add(docPagar);

		Cuenta hipotecas = new Cuenta("Hipotecas por pagar");
		hipotecas.setDescripcion("");
		cuentas.add(hipotecas);

		Cuenta ventas = new Cuenta("Ventas");
		ventas.setDescripcion("");
		cuentas.add(ventas);

		Cuenta costVentas = new Cuenta("Costo de ventas");
		costVentas.setDescripcion("");
		cuentas.add(costVentas);

		Cuenta gastVentas = new Cuenta("Gastos de ventas");
		gastVentas.setDescripcion("");
		cuentas.add(gastVentas);

		Cuenta gastAdmin = new Cuenta("Gastos de administracion");
		gastAdmin.setDescripcion("");
		cuentas.add(gastAdmin);

		Cuenta gastFin = new Cuenta("Gastos financieros");
		gastFin.setDescripcion("");
		cuentas.add(gastFin);

		Cuenta prodFin = new Cuenta("Productos financieros");
		prodFin.setDescripcion("");
		cuentas.add(prodFin);

		Cuenta otrosGast = new Cuenta("Otros gastos");
		otrosGast.setDescripcion("");
		cuentas.add(otrosGast);

		Cuenta otrosProd = new Cuenta("Otros productos");
		otrosProd.setDescripcion("");
		cuentas.add(otrosProd);

		Cuenta capSocial = new Cuenta("Capital social");
		capSocial.setDescripcion("");
		cuentas.add(capSocial);
		return cuentas;
	}
}