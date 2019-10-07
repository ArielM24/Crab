import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Principal extends Application {
	private Stage stagePrincipal;
	private Scene scenePrincipal;
	private TabPane paneTab;
	private BorderPane panePrincipal;
	private GridPane paneTs;
	private ScrollPane spCuentas;
	private VBox paneCuentas;
	private ListView<Cuenta> lvCuentas;
    @Override

    public void start(Stage primaryStage){
    	stagePrincipal = primaryStage;
    	initComp();
    	scenePrincipal = new Scene(paneTab, 1200,700);
    	stagePrincipal.setScene(scenePrincipal);
    	stagePrincipal.setTitle("Principal");
    	stagePrincipal.show();
    }

    private void initComp() {
    	paneTab = new TabPane();
    	panePrincipal = new BorderPane();
    	Tab t1 = new Tab();
    	t1.setContent(panePrincipal);
    	paneTab.getTabs().add(t1);
    	paneCuentas = new VBox(10);
    	spCuentas = new ScrollPane(paneCuentas);
    	lvCuentas = new ListView<Cuenta>();
    	agregaCuentas();
    	paneCuentas.getChildren().add(lvCuentas);
    	panePrincipal.setLeft(spCuentas);
    	panePrincipal.setMargin(spCuentas, new Insets(15));

    }

    private void agregaCuentas(){
    	lvCuentas.getItems().add(new Cuenta("Caja"));
    	lvCuentas.getItems().add(new Cuenta("Bancos"));
    	lvCuentas.getItems().add(new Cuenta("Equipo de cómputo"));
    	lvCuentas.getItems().add(new Cuenta("Equipo de transporte"));
    	lvCuentas.getItems().add(new Cuenta("Documentos por cobrar"));
    	lvCuentas.getItems().add(new Cuenta("Gastos de Administración"));
    }
    public static void main(String args[]) {
    	launch();
    }
}