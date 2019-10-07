import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import java.util.List;
import java.util.ArrayList;

public class NuevoMov {
	private static Stage stage;
	private static Scene scene;
	private static GridPane pane;
	private static ScrollPane spPane;
	private static ArrayList<Cuenta> alCuentas;
	private static Movimiento m;
	private static Button btnAceptar, btnCancelar;
	private static ArrayList<CheckBox> cuentas;
	private static ArrayList<TextField> montos;
	public static Movimiento show(List<Cuenta> c){
		stage = new Stage();
		initComp(c);
		scene = new Scene(spPane,500,400);
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
		return m;
	}

	private static void initComp(List<Cuenta> c){
		cuentas = new ArrayList<CheckBox>();
		montos = new ArrayList<TextField>();
		pane = new GridPane();
		pane.setPadding(new Insets(10));
		spPane = new ScrollPane(pane);
		int i = 0;
		for(Cuenta aux: c){
			CheckBox cb = new CheckBox(aux.getNombre());
			cb.setSelected(false);
			TextField tf = new TextField();
			tf.setDisable(true);
			cb.setOnAction(e->select(cb));
			cuentas.add(cb);
			montos.add(tf);
			pane.add(cb,0,i);
			pane.add(tf,1,i);
			i++;
		}	
		btnAceptar = new Button("Aceptar");
		btnCancelar = new Button("Cancelar");
		pane.setMargin(btnAceptar, new Insets(0,10,0,10));
		pane.setMargin(btnCancelar, new Insets(0,10,0,10));
		pane.add(btnAceptar,2,0);
		pane.add(btnCancelar,3,0);
	}

	private static void select(CheckBox c){
		int i = cuentas.indexOf(c);
		if(cuentas.get(i).isSelected()){
			montos.get(i).setDisable(false);
		}else{
			montos.get(i).setDisable(true);
		}
	}
}