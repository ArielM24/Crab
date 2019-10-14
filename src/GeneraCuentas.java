import java.util.ArrayList;

public class GeneraCuentas {
	public static ArrayList<Cuenta> generaCuentas(){
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Cuenta caja = new Cuenta("Caja");
		caja.setDescripcion("Activo\nDinero en efectivo");
		cuentas.add(caja);

		Cuenta bancos = new Cuenta("Bancos");
		bancos.setDescripcion("Activo\nDinero en una cuentas\nbancaria");
		cuentas.add(bancos);

		Cuenta almacen = new Cuenta("Almacen");
		almacen.setDescripcion("Activo\nMercancias y gastos\nrelacionados");
		cuentas.add(almacen);

		Cuenta clientes = new Cuenta("Clientes");
		clientes.setDescripcion("Activo\nVentas de mercancias\na credito");
		cuentas.add(clientes);

		Cuenta docCobrar = new Cuenta("Documentos por cobrar");
		docCobrar.setDescripcion("Activo\nTitulos de credito\ndonde se comprometen\na pagarnos");
		cuentas.add(docCobrar);

		Cuenta deudores = new Cuenta("Deudores");
		deudores.setDescripcion("Activo\nNos deben por conceptos\ndiferentes a la mercia");
		cuentas.add(deudores);

		Cuenta terrenos = new Cuenta("Terrenos");
		terrenos.setDescripcion("Activo\nPredios que son propiedad\nde la empresa");
		cuentas.add(terrenos);

		Cuenta edificios = new Cuenta("Edificios");
		edificios.setDescripcion("Activo\nConstrucciones que son\npropiedad de la empresa");
		cuentas.add(edificios);

		Cuenta mobiliario = new Cuenta("Mobiliario y equipo");
		mobiliario.setDescripcion("Activo\nMuebles y utencilios\nque son propiedad de\nla empresa");
		cuentas.add(mobiliario);

		Cuenta eqComputo = new Cuenta("Equipo de computo");
		eqComputo.setDescripcion("Activo\nComputadoras que son\npropiedad de la empresa");
		cuentas.add(eqComputo);

		Cuenta eqReparto = new Cuenta("Equipo de reparto");
		eqReparto.setDescripcion("Activo\nVehiculos para transportar\nmercancia que son\npropiedad de la empresa");
		cuentas.add(eqReparto);

		Cuenta eqTransporte = new Cuenta("Equipo de transporte");
		eqTransporte.setDescripcion("Activo\nVehiculos para transportar\npersonas y documentos que\nson propiedad de la\nempresa");
		cuentas.add(eqTransporte);

		Cuenta depGarantia = new Cuenta("Depositos en garantia");
		depGarantia.setDescripcion("Activo\nDinero que se usa\ncomo garantia");
		cuentas.add(depGarantia);

		Cuenta gastOrg = new Cuenta("Gastos de organizacion");
		gastOrg.setDescripcion("Activo\nPagos para tramites\npermisos, licencias, etc");
		cuentas.add(gastOrg);

		Cuenta gastInst = new Cuenta("Gastos de instalacion");
		gastInst.setDescripcion("Activo\nPagos para acondicionar\nel lugar de trabajo");
		cuentas.add(gastInst);

		Cuenta proveedores = new Cuenta("Proveedores");
		proveedores.setDescripcion("Pasivo\nNos vende mercancias\na credito");
		cuentas.add(proveedores);

		Cuenta acreedores = new Cuenta("Acreedores");
		acreedores.setDescripcion("Pasivo\nLe debemos dinero por\nun concepto distinto\na la mercancia");
		cuentas.add(acreedores);

		Cuenta docPagar = new Cuenta("Documentos por pagar");
		docPagar.setDescripcion("Pasivo\nDocumentos firmados\nque debemos pagar");
		cuentas.add(docPagar);

		Cuenta hipotecas = new Cuenta("Hipotecas por pagar");
		hipotecas.setDescripcion("Pasivo\nPrestamos donde dejamos\ncomo garantia un bien");
		cuentas.add(hipotecas);

		Cuenta capSocial = new Cuenta("Capital social");
		capSocial.setDescripcion("Capital\nImporte de las aportaciones\nque hacen los socios\no accionistas a\nla empresa");
		cuentas.add(capSocial);

		Cuenta ventas = new Cuenta("Ventas");
		ventas.setDescripcion("Sistema de inventarios perpetuos\nSe registran las ventas al\nprecio de venta");
		cuentas.add(ventas);

		Cuenta costVentas = new Cuenta("Costo de ventas");
		costVentas.setDescripcion("Sistema de inventarios perpetuos\nSe registran las ventas al\nprecio de compra");
		cuentas.add(costVentas);

		Cuenta gastVentas = new Cuenta("Gastos de ventas");
		gastVentas.setDescripcion("Gastos de operacion\nGastos del area de ventas\npublicidad, seguros\nrentas de ventas, etc");
		cuentas.add(gastVentas);

		Cuenta gastAdmin = new Cuenta("Gastos de administracion");
		gastAdmin.setDescripcion("Gastos de operacion\nGastos del area de administracion\npapeleria, seguros\nrentas de oficinas, etc");
		cuentas.add(gastAdmin);

		Cuenta gastFin = new Cuenta("Gastos financieros");
		gastFin.setDescripcion("Gastos de operacion\nGastos por intereses\ndocumentos, etc");
		cuentas.add(gastFin);

		Cuenta prodFin = new Cuenta("Productos financieros");
		prodFin.setDescripcion("Gastos de operacion\nDescuentos sobre compras\nintereses cobrados,etc");
		cuentas.add(prodFin);

		Cuenta otrosGast = new Cuenta("Otros gastos");
		otrosGast.setDescripcion("Perdidas de la empresa por\noperaciones que no son\nde su giro");
		cuentas.add(otrosGast);

		Cuenta otrosProd = new Cuenta("Otros productos");
		otrosProd.setDescripcion("Utilidad de la empresa por\noperaciones que no son\nde su giro");
		cuentas.add(otrosProd);

		return cuentas;
	}
}