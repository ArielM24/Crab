import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;

public class ConfirmationBox{
	static Stage stage;
	static boolean btnYesClicked;
	/*
		show()
		descripción:
			Genera un cuadro de confirmación que devuelve verdadero o falso según la 
			opción que el usuario seleccione 
		parametros: 
			String message (Mensaje para mostrar), String title (Título de la ventana),
			String textYes (Texto para mostrar en el botón que retorna verdadero al hacer click en el),
			String textNo (Texto para mostrar en el botón que retorna falso al hacer click en el)
		predecesores: 
			Algun objeto de la clase Application debe estar ejecutando su método launch()
		funcionamiento: 
			Muestra un cuadro de confirmación con el mensaje, título, texto para botones de confirmación
			que los parámetros definen, si no se cierra el cuadro de dialogo, se bloquea la interfaz
			gráfica de la aplicación de javafx
	*/
	public static boolean show(String title,String message,String textYes,String textNo){
		btnYesClicked = false;
		stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(250);
		Label lbl = new Label(message);
		Button btnYes = new Button(textYes);
		btnYes.setOnAction(e->ClickedYes());
		Button btnNo = new Button(textNo);
		btnNo.setOnAction(e->ClickedNo());
		HBox panebtn = new HBox(20);
		panebtn.getChildren().addAll(btnYes,btnNo);
		panebtn.setPadding(new Insets(5));
		panebtn.setAlignment(Pos.CENTER);
		VBox pane = new VBox(20);
		pane.getChildren().addAll(lbl,panebtn);
		pane.setAlignment(Pos.CENTER);
		pane.setMargin(lbl, new Insets(5));
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.showAndWait();
		return btnYesClicked;
	}
	/*
		ClickedYes()
		descripción:
			Es el evento asociado al Button btnYes
		parametros: 
			ninguno
		predecesores: 
			El método show() debio ser llamado 
		funcionamiento: 
			Cierra el cuadro de confirmación y hace que el valor que va a retornar el método show()
			sea verdadero
	*/
	private static void ClickedYes(){
		stage.close();
		btnYesClicked=true;
	}
	/*
		ClickedNo()
		descripción:
			Es el evento asociado al Button btnNo
		parametros: 
			ninguno
		predecesores: 
			El método show() debio ser llamado 
		funcionamiento: 
			Cierra el cuadro de confirmación y hace que el valor que va a retornar el método show()
			sea falso
	*/
	private static void ClickedNo(){
		stage.close();
		btnYesClicked=false;
	}
}
