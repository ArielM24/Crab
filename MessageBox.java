import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import java.util.ArrayList;
public class MessageBox{
	/*
		show()
		descripción:
			Genera un cuadro de dialogo
		parametros: 
			String message (Mensaje para mostrar), String title (Título de la ventana),
		predecesores: 
			Algun objeto de la clase Application debe estar ejecutando su método launch()
		funcionamiento: 
			Muestra un cuadro de dialogo con el mensaje, título que los parámetros definen,
			si no se cierra el cuadro de dialogo, se bloquea la interfaz gráfica de la aplicación de javafx
	*/
	public static void show(String title,String message) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(251);
		Label lblmsg = new Label(message);
		Button btnOk = new Button("OK");
		btnOk.setOnAction(e->stage.close());
		VBox pane = new VBox(20);
		pane.getChildren().addAll(lblmsg,btnOk);
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(5));
		pane.setMinWidth(250);
		pane.setMargin(lblmsg, new Insets(5));
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(true);
		stage.showAndWait();
	}
}