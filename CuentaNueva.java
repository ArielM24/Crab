import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class CuentaNueva{
	private static Stage stage;
	private static Scene scene;
	private static HBox pane;
	private static Cuenta c;
	private static TextArea taDescripcion;
	private static TextField tfNombre;
	private static Label lblNombre, lblDescripcion;
	private static Button btnAceptar, btnCancelar;

	public static Cuenta show(){
		stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Nueva cuenta");
		stage.showAndWait();
		return c;
	}

}