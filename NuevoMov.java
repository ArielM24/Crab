import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class NuevoMov {
	private static Stage stage;
	private static Scene scene;
	private static GridPane pane;
	private static ScrollPane spPane;
	private static TextField tfNombre;
	private static ArrayList<Cuenta> alCuentas;
	private static Movimiento m;
	private static Button btnAceptar, btnCancelar;
	private static ArrayList<CheckBox> cuentas;
	private static ArrayList<TextField> montos;
	private static ArrayList<RadioButton[]> tipo;
	private static boolean editado;
	public static Movimiento show(List<Cuenta> c){
		editado = false;
		stage = new Stage();
		initComp(c);
		scene = new Scene(spPane,570,400);
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Nuevo movimiento");
		stage.showAndWait();
		if(!editado){
			m = null;
		}
		return m;
	}

	private static void initComp(List<Cuenta> c){
		tfNombre = new TextField();
		cuentas = new ArrayList<CheckBox>();
		montos = new ArrayList<TextField>();
		tipo = new ArrayList<RadioButton[]>();
		alCuentas = new ArrayList<Cuenta>(c);
		pane = new GridPane();
		pane.setPadding(new Insets(10));
		spPane = new ScrollPane(pane);
		int i = 0;
		for(Cuenta aux: c){
			CheckBox cb = new CheckBox(aux.getNombre());
			cb.setSelected(false);
			TextField tf = new TextField();
			tf.setMaxWidth(100);
			tf.setDisable(true);
			cb.setOnAction(e->select(cb));
			RadioButton rbA = new RadioButton("Abono");
			RadioButton rbC = new RadioButton("Cargo");
			ToggleGroup tg = new ToggleGroup();
			rbA.setToggleGroup(tg);
			rbC.setToggleGroup(tg);
			rbA.setDisable(true);
			rbC.setDisable(true);
			rbC.setSelected(true);
			RadioButton btns[] = {rbC,rbA};
			alCuentas.add(aux);
			cuentas.add(cb);
			montos.add(tf);
			tipo.add(btns);
			pane.add(cb,0,i);
			pane.setMargin(cb,new Insets(5));
			pane.add(tf,1,i);
			pane.add(rbC,2,i);
			pane.add(rbA,3,i);
			i++;
		}	
		btnAceptar = new Button("Aceptar");
		btnCancelar = new Button("Cancelar");
		btnCancelar.setOnAction(e->{
			editado = false;
		 	stage.close();
		});
		btnAceptar.setOnAction(e->btnAceptarClick());
		pane.add(new Label(" Nombre: "),4,0);
		pane.add(tfNombre,5,0);
		pane.add(btnAceptar,4,1);
		pane.add(btnCancelar,5,1);
		pane.setMargin(btnAceptar, new Insets(5));
		pane.setMargin(btnCancelar, new Insets(5));
		pane.setMargin(tfNombre, new Insets(5));
	}

	private static void select(CheckBox c){
		int i = cuentas.indexOf(c);
		if(cuentas.get(i).isSelected()){
			montos.get(i).setDisable(false);
			tipo.get(i)[0].setDisable(false);
			tipo.get(i)[1].setDisable(false);
		}else{
			montos.get(i).setDisable(true);
			tipo.get(i)[0].setDisable(true);
			tipo.get(i)[1].setDisable(true);
		}
	}



	private static void btnAceptarClick(){
		ArrayList <Operacion> al = new ArrayList<Operacion>();
		int i = 0;
		boolean s = false, err = false;
		double cantidad;
		String nombre = tfNombre.getText().trim().replace(" ","").replace("\t","");
		for(CheckBox cb: cuentas){
			if(cb.isSelected()&&!cb.isDisable()){
				s = true;
				try{
					cantidad = Double.parseDouble(montos.get(i).getText());
					cantidad = Double.parseDouble(String.format("%.2f",cantidad));
				}catch(Exception ex){
					MessageBox.show("Error", "Formato de cantidad incorrecto");
					err = true;
					break;
				}
				if(cantidad <= 0){
					MessageBox.show("Error", "No se aceptan cantidades negativas o 0");
					err = true;
					break;
				}
				Operacion op = new Operacion(tipo.get(i)[0].isSelected(),cantidad,alCuentas.get(i),nombre);
				al.add(op);
			}
			i++;
		}
		if(!err){
			if(nombre != null){
				if(nombre.length() > 0){
					if(s){
						m = new Movimiento(nombre,al);
						editado = true;
						stage.close();
					}
				}else{
					MessageBox.show("Error","Nombre muy corto");
				}
			}else{
				MessageBox.show("Error", "Los movimientos necesitan un nombre");
			}
		}
	}
}