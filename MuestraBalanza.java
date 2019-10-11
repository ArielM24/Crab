import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class MuestraBalanza{
	private static Stage stage;
	private static Scene scene;
	private static VBox pane;
	private static ScrollPane spPane;
	private static TextArea ta;
	private static Button btnImprimir;
	private static Balanza balanza;
	public static void show(Balanza b){
		stage = new Stage();
		initComp(b);
		scene = new Scene(spPane,700,600);
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(b.getNombre());
		stage.showAndWait();
	}
	private static void initComp(Balanza b){
		ta = new TextArea();
		//ta.setEditable(false);
		ta.setMinWidth(600);
		ta.setMinHeight(500);
		btnImprimir = new Button("Imprimir/PDF");
		btnImprimir.setOnAction(e->btnImprimirClick());
		pane = new VBox(10,ta,btnImprimir);
		spPane = new ScrollPane(pane);
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10));
	}
	private static void btnImprimirClick(){
		JTextArea t = new JTextArea();
		t.setText(ta.getText());
		try{
			t.print();
		}catch(Exception ex){
			MessageBox.show("Error","Error al imprimir/exportar pdf :(");
		}
	}
}