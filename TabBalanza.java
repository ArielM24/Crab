import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import java.util.HashMap;
import java.util.ArrayList;
import javafx.event.*;

public class TabBalanza extends Tab {
	private BorderPane bpCuentas;
	private ScrollPane spCuentas, spTes, spMovimientos,spSaldos;
	private VBox vbCuentas,vbMovimientos;
	private ListView<Cuenta> lvCuentas;
	private ListView<Movimiento> lvMovimientos;
	private TextArea taCuentas,taMovimientos;
	private Button btnEditaCuenta,btnBorraCuenta,btnCreaCuenta,btnEditaMov,btnBorrarMov,btnNuevoMov,btnVerBalanza;
	private GridPane gpCuentas,gpSaldos;
	private int x = 0,y = 0;
	private Label lblAcreedor,lblDeudor,lblBalanceado;
	private ArrayList<T> tes;
	private ArrayList<Cuenta> alCuentas;
	private double saldoAcreedor = 0.0,saldoDeudor = 0.0;
	private Balanza b;

	public TabBalanza(String nombre) {
		super(nombre);
		initComp();
		setOnCloseRequest(e->cerrar(e));
	}

	private void cerrar(Event ev){
		if(!ConfirmationBox.show("Cerrar","Cerrar archivo?","Si","No")){
			ev.consume();
		}
	}

	private void initComp(){
		tes = new ArrayList<T>();
		gpCuentas = new GridPane();
		spTes = new ScrollPane(gpCuentas);
		spTes.setMinHeight(500);
		spTes.setMinWidth(500);
		lvCuentas = new ListView<Cuenta>();
		lvCuentas.setMaxHeight(300);
		bpCuentas = new BorderPane();
		vbCuentas = new VBox(10);
		vbCuentas.setAlignment(Pos.CENTER);
		taCuentas = new TextArea();
		taCuentas.setEditable(false);
		agregaCuentas();
		spCuentas = new ScrollPane(vbCuentas);
		spCuentas.setPadding(new Insets(10));
		spCuentas.setMaxHeight(400);
		spCuentas.setMaxWidth(200);
		bpCuentas.setLeft(vbCuentas);
		bpCuentas.setCenter(spTes);
		setContent(bpCuentas);
		agregaMovimientos();
		agregaBtnCuenta();
		initComp2();
	}

	private void initComp2(){
		lblAcreedor = new Label("Saldo Duedor\n$0.00");
		lblDeudor = new Label(" Saldo Acreedor\n $0.00");
		lblBalanceado = new Label("Balanceado: Si");
		btnVerBalanza = new Button("Generar balanza de comprobacion");
		btnVerBalanza.setOnAction(e->btnVerBalanzaClick());
		gpSaldos = new GridPane();
		gpSaldos.add(lblDeudor,0,0);
		gpSaldos.add(lblAcreedor,1,0);
		gpSaldos.add(lblBalanceado,0,1);
		gpSaldos.add(btnVerBalanza,0,2);
		gpSaldos.setMargin(btnVerBalanza, new Insets(10,0,10,0));
		spSaldos = new ScrollPane(gpSaldos);
		spSaldos.setMaxWidth(450);
		spSaldos.setMaxHeight(100);
		agregaBtnMov();
		bpCuentas.setBottom(spSaldos);
		bpCuentas.setAlignment(spSaldos,Pos.TOP_CENTER);
		gpSaldos.setPadding(new Insets(10));
		alCuentas = new ArrayList<>();
	}

	private void agregaBtnCuenta(){
		btnEditaCuenta = new Button("Editar");
		btnEditaCuenta.setOnAction(e->btnEditaCuentaClick());
		btnEditaCuenta.setDisable(true);
		btnBorraCuenta = new Button("Borrar");
		btnBorraCuenta.setDisable(true);
		btnBorraCuenta.setOnAction(e->btnBorraCuentaClick());
		btnCreaCuenta = new Button("Nueva");
		btnCreaCuenta.setOnAction(e->btnCreaCuentaClick());
		HBox hbBotones = new HBox(10, btnEditaCuenta, btnBorraCuenta, btnCreaCuenta);
		hbBotones.setPadding(new Insets(10));
		vbCuentas.getChildren().add(hbBotones);
	}

	private void agregaBtnMov(){
		btnEditaMov = new Button("Editar");
		btnEditaMov.setDisable(true);
		btnEditaMov.setOnAction(e->btnEditaMovClick());
		btnNuevoMov = new Button("Nuevo");
		btnNuevoMov.setOnAction(e->btnNuevoMovClick());
		btnBorrarMov = new Button("Borrar");
		btnBorrarMov.setDisable(true);
		btnBorrarMov.setOnAction(e->btnBorrarMovClick());
		HBox hbBotones = new HBox(10,btnEditaMov,btnBorrarMov,btnNuevoMov);
		hbBotones.setPadding(new Insets(10));
		vbMovimientos.getChildren().add(hbBotones);
		spCuentas.setPadding(new Insets(10));
	}

	private void btnNuevoMovClick(){
		Movimiento m = NuevoMov.show(lvCuentas.getItems());
		if(m!=null){
			if(!lvMovimientos.getItems().contains(m)){
				lvMovimientos.getItems().add(m);
				actualizaMov(m);
				actualizaSaldos();
			}else{
				MessageBox.show("Error", "Los nombres de los movimientos\nno se pueden repetir");
			}
		}
	}

	private void agregaMovimientos(){
		lvMovimientos = new ListView<Movimiento>();
		lvMovimientos.setMaxHeight(300);
		lvMovimientos.getSelectionModel().selectedItemProperty().addListener((obj,oldv,newv)->{
			if(newv != null){
				taMovimientos.setText(newv.getDescripcion());
				btnBorrarMov.setDisable(false);
				btnEditaMov.setDisable(false);
			}else{
				btnBorrarMov.setDisable(true);
				btnEditaMov.setDisable(true);
			}
		});
		vbMovimientos = new VBox(10, new Label("Operaciones"),lvMovimientos);
		vbMovimientos.setAlignment(Pos.CENTER);
		taMovimientos = new TextArea();
		taMovimientos.setEditable(false);
		taMovimientos.setMaxWidth(200);
		taMovimientos.setMaxHeight(100);
		vbMovimientos.getChildren().addAll(taMovimientos);
		spMovimientos = new ScrollPane(vbMovimientos);
		spMovimientos.setMaxHeight(600);
		spMovimientos.setMaxWidth(300);
		bpCuentas.setRight(spMovimientos);
	}

	private void agregaCuentas() {
		lvCuentas.getItems().addAll(GeneraCuentas.generaCuentas());
		lvCuentas.getSelectionModel().selectedItemProperty().addListener((obj,oldv,newv) -> {
			if(newv != null) {
				taCuentas.setText(newv.getDescripcion());
				btnEditaCuenta.setDisable(false);
				btnBorraCuenta.setDisable(false);
			}else{
				btnEditaCuenta.setDisable(true);
				btnBorraCuenta.setDisable(true);
			}
		});
		taCuentas.setMaxWidth(200);
		taCuentas.setMaxHeight(100);
		vbCuentas.getChildren().add(new Label("Cuentas"));
		vbCuentas.getChildren().add(lvCuentas);
		vbCuentas.getChildren().add(taCuentas);
	}

	private void actualizaTes(){
		for(Movimiento m: lvMovimientos.getItems()){
			actualizaMov(m);
		}
	}

	private void actualizaMov(Movimiento m){
		ArrayList<Operacion> op = m.getOperaciones();
		int i = 0;
		for(Operacion o: op){
			Cuenta aux = o.getCuenta();
			T t = new T(aux);
			if(!alCuentas.contains(aux)){
				agregaT(t);
				alCuentas.add(aux);
			}
			i = tes.indexOf(t);
			tes.get(i).actualiza(o);
		}
	}

	private void agregaT(T t){
		gpCuentas.add(t, x, y);
		tes.add(t);
		x++;
		if(x > 3){
			x = 0;
			y++;
		}
	}

	private void btnEditaMovClick(){
		Movimiento m1 = lvMovimientos.getSelectionModel().getSelectedItem();
		Movimiento m2 = NuevoMov.show(lvCuentas.getItems(),m1);
		if(m2!=null){
			lvMovimientos.getItems().remove(m1);
			tes.clear();
			gpCuentas.getChildren().clear();
			alCuentas.clear();
			x = 0;
			y = 0;
			lvMovimientos.getItems().add(m2);
			actualizaTes();
			taMovimientos.setText("");
			actualizaSaldos();
		}
	}

	private void btnEditaCuentaClick(){
		Cuenta c1 = lvCuentas.getSelectionModel().getSelectedItem();
		Cuenta c2 = CuentaNueva.show(c1);
		if(c2!=null){
			lvCuentas.getItems().remove(c1);
			lvCuentas.getItems().add(c2);
			for(T t: tes){
				if(t.getCuenta().equals(c1)){
					t.setCuenta(c2);
				}
			}
			for(Movimiento m: lvMovimientos.getItems()){
				if(m.contieneCuenta(c1)){
					m.cambiaC(c1,c2);
				}
			}
			for(Cuenta c: alCuentas){
				if(c.equals(c1)){
					c.setNombre(c2.getNombre());
					c.setDescripcion(c2.getDescripcion());
				}
			}
		}
	}

	private void btnCreaCuentaClick(){
		Cuenta c = CuentaNueva.show();
		if(c!= null){
			lvCuentas.getItems().add(c);
		}
	}
	private void borraCuentaM(Cuenta c){
		lvCuentas.getItems().remove(c);
		for(Movimiento m: lvMovimientos.getItems()){
			if(m.contieneCuenta(c)){
				m.borraC(c);
			}
		}
		x = 0;
		y = 0;
		gpCuentas.getChildren().clear();
		tes.clear();
		alCuentas.clear();
		actualizaTes();
	}
	private void btnBorraCuentaClick(){
		Cuenta c = lvCuentas.getSelectionModel().getSelectedItem();
		if(c!=null){
			if(ConfirmationBox.show("Borrar","Borrar cuenta?","Si","No")){
				boolean vacio = false;
				ArrayList<Movimiento> vacios = new ArrayList<Movimiento>();
				lvCuentas.getItems().remove(c);
				for(Movimiento m: lvMovimientos.getItems()){
					if(m.contieneCuenta(c)){
						m.borraC(c);
					}
					if(m.esVacio()){
						vacio = true;
						vacios.add(m);
					}
				}
				x = 0;
				y = 0;
				gpCuentas.getChildren().clear();
				tes.clear();
				alCuentas.clear();
				actualizaTes();
				if(vacio){
					for(Movimiento mv: vacios){
						lvMovimientos.getItems().remove(mv);
					}
				}
				actualizaSaldos();
			}
		}
	}

	private void btnBorrarMovClick(){
		Movimiento m = lvMovimientos.getSelectionModel().getSelectedItem();
		if(m!=null){
			if(ConfirmationBox.show("Borrar","Deshacer movimiento?","Si","No")){
				lvMovimientos.getItems().remove(m);
				tes.clear();
				gpCuentas.getChildren().clear();
				alCuentas.clear();
				x = 0;
				y = 0;
				actualizaTes();
				taMovimientos.setText("");
				actualizaSaldos();
			}
		}
	}

	private void actualizaSaldos(){
		double saldos[] = calculaSaldos();
		lblDeudor.setText("Saldo Deudor\n$"+saldos[0]);
		lblAcreedor.setText(" Saldo Acreedor\n$"+saldos[1]);
		if(saldos[0] == saldos[1]){
			lblBalanceado.setText("Balanceado: Si");
			lblBalanceado.setStyle("-fx-background-color:#19FF00");
		}else{
			lblBalanceado.setText("Balanceado: No");
			lblBalanceado.setStyle("-fx-background-color:#FF0300");
		}
	}
	private double calculaMovDeudor(){
		double deudor = 0.0;
		for(T t:tes){
			deudor += t.getMovDeudor();
		}
		return deudor;
	}
	private double calculaMovAcreedor(){
		double acreedor = 0.0;
		for(T t:tes){
			acreedor += t.getMovAcreedor();
		}
		return 0.0;
	}
	//0 -> deudor, 1 -> acreedor
	private double[] calculaSaldos(){
		double saldos[] = {0.0,0.0};
		for(T t: tes){
			double s = t.getSaldo();
			if(s > 0){
				saldos[0] += s;
			}else{
				saldos[1] += -s;
			}
		}
		return saldos;
	}
	public void generaBalanza(){
		ArrayList<TSerializable> ts = new ArrayList<TSerializable>();
		for(T t:tes){
			TSerializable taux = new TSerializable(t.getCuenta(),t.getMovDeudor(),t.getMovAcreedor());
			ts.add(taux);
		}
		b = new Balanza(getText(),ts,new ArrayList<Movimiento>(lvMovimientos.getItems())
			,new ArrayList<Cuenta>(lvCuentas.getItems()));
		double saldos[] = calculaSaldos();
		b.setSaldoDeudor(saldos[0]);
		b.setSaldoAcreedor(saldos[1]);
	}
	private void btnVerBalanzaClick(){
		generaBalanza();
		MuestraBalanza.show(b);
	}
	public Balanza getBalanza(){
		generaBalanza();
		return b;
	}
	public void cargaBalanza(Balanza bal){
		lvMovimientos.getItems().clear();
		lvMovimientos.getItems().addAll(bal.getMovimientos());
		alCuentas.clear();
		lvCuentas.getItems().clear();
		actualizaTes();
		for(Cuenta c: GeneraCuentas.generaCuentas()){
			if(!alCuentas.contains(c)){
				alCuentas.add(c);
			}
		}
		lvCuentas.getItems().addAll(bal.getCuentas());
		actualizaSaldos();
	}
}
