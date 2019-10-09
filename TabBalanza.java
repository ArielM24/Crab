import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import java.util.HashMap;
import java.util.ArrayList;

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
	private Label lblAcredor,lblDeudor;
	private ArrayList<T> tes;
	private ArrayList<Cuenta> alCuentas;

	public TabBalanza(String nombre) {
		super(nombre);
		initComp();
		setOnCloseRequest(e->{e.consume();});
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
		lblAcredor = new Label("Saldo Duedor\n$0.00");
		lblDeudor = new Label(" Saldo Acredor\n $0.00");
		btnVerBalanza = new Button("Ver balanza de comprobación");
		gpSaldos = new GridPane();
		gpSaldos.add(lblDeudor,0,0);
		gpSaldos.add(lblAcredor,1,0);
		gpSaldos.add(btnVerBalanza,0,1);
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
		btnNuevoMov = new Button("Nuevo");
		btnNuevoMov.setOnAction(e->btnNuevoMovClick());
		btnBorrarMov = new Button("Borrar");
		btnBorrarMov.setDisable(true);
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
				actualizaTes();
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
		for(int i = 0; i < 20; i++){
			Cuenta c = new Cuenta(""+i);
			lvCuentas.getItems().add(c);
		}
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
			if(!alCuentas.contains(aux)){
				T t = new T(aux);
				agregaT(t);
				alCuentas.add(aux);
				i = tes.indexOf(t);
			}
			tes.get(i).actualiza(o,m.getId());
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

	private void btnEditaCuentaClick(){
		Cuenta c1 = lvCuentas.getSelectionModel().getSelectedItem();
		Cuenta c = CuentaNueva.show(c1);
		if(c!=null){
			lvCuentas.getItems().remove(c1);
			lvCuentas.getItems().add(c);
		}
	}

	private void btnCreaCuentaClick(){
		Cuenta c = CuentaNueva.show();
		if(c!= null){
			lvCuentas.getItems().add(c);
		}
	}
	private void btnBorraCuentaClick(){
		Cuenta c = lvCuentas.getSelectionModel().getSelectedItem();
		if(c!=null){
			if(ConfirmationBox.show("Borrar","¿Borrar cuenta?","Si","No")){
				lvCuentas.getItems().remove(c);
			}
		}
	}
}