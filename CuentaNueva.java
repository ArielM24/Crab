import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class CuentaNueva{
	private static Stage stage;
	private static Scene scene;
	private static VBox pane;
	private static Cuenta c;
	private static TextArea taDescripcion;
	private static TextField tfNombre;
	private static Label lblNombre, lblDescripcion;
	private static Button btnAceptar, btnCancelar;

	public static Cuenta show(){
		stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		initComp();
		scene = new Scene(pane,500,400);
		stage.setScene(scene);
		stage.setTitle("Nueva cuenta");
		stage.showAndWait();
		return c;
	}

	public static Cuenta show(Cuenta editar){
		stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		initComp();
		tfNombre.setText(editar.getNombre());
		taDescripcion.setText(editar.getDescripcion());
		scene = new Scene(pane,500,400);
		stage.setScene(scene);
		stage.setTitle("Nueva cuenta");
		stage.showAndWait();
		return c;
	}

	private static void initComp(){
		lblNombre = new Label("Nombre:\n");
		lblNombre.setMinWidth(100);
		tfNombre = new TextField();
		lblDescripcion = new Label("Descripcion:\n");
		lblDescripcion.setMinWidth(200);
		taDescripcion = new TextArea();
		btnCancelar = new Button("Cancelar");
		btnCancelar.setMinWidth(100);
		btnAceptar = new Button("Aceptar");
		btnAceptar.setMinWidth(100);
		HBox h = new HBox(50,btnCancelar,btnAceptar);
		pane = new VBox(10,lblNombre,tfNombre,lblDescripcion,taDescripcion,h);
		pane.setPadding(new Insets(10));
		h.setAlignment(Pos.CENTER);
		btnCancelar.setOnAction(e->btnCancelarClick());
		btnAceptar.setOnAction(e->btnAceptarClick());
	}

	private static void btnCancelarClick(){
		stage.close();
	}

	private static void btnAceptarClick(){
		String nombre = tfNombre.getText().trim();
		if(nombre!=null){
			if(nombre.replace(" ","").replace("\t","").length()>0){
				String descripcion = taDescripcion.getText().trim();
				if(descripcion!=null){
					c = new Cuenta(nombre,descripcion);
				}else{
					c = new Cuenta(nombre);
				}
				stage.close();
			}else{
				MessageBox.show("Error", "Nombre no valido");
			}
		}else{
			MessageBox.show("Error","Las cuentas necesitan un nombre");
		}
	}
}