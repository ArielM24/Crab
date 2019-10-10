import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import java.io.*;


public class Principal extends Application {
	private Stage stagePrincipal;
	private Scene scenePrincipal;
	private TabPane panelBalanza;
	private VBox panePrincipal;
	private Menu mArchivo;
	private MenuBar mbMenu;
	private MenuItem miNuevo,miAbrir,miGuardar;
	private FileChooser fc;
    @Override

    public void start(Stage primaryStage){
    	stagePrincipal = primaryStage;
    	initComp();
    	scenePrincipal = new Scene(panePrincipal, 1250,700);
    	stagePrincipal.setScene(scenePrincipal);
    	stagePrincipal.setTitle("Crab");
    	stagePrincipal.show();
    }

    private void initComp() {
    	fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CRB FILES (*.crb)","*.crb"));
    	panelBalanza = new TabPane();

    	iniciaIconos();
    	iniciaMenu();
    	panePrincipal = new VBox(10, mbMenu, panelBalanza);
    }

    private void iniciaIconos() {
    	Tab t1 = new Tab("Crab");
    	panelBalanza.getTabs().add(t1);
    	panelBalanza.getTabs().get(0).setOnCloseRequest(e-> {e.consume();});
    	Label lblInicial = new Label("CRAB");
    	VBox panelInicial = new VBox(10,lblInicial);
    	t1.setContent(panelInicial);
    	try{
			InputStream in = getClass().getResourceAsStream("crab.png"); 
			stagePrincipal.getIcons().add(new Image(in));
		}catch(Exception ex){
			ex.printStackTrace();
		}
    	try{
    		InputStream is = getClass().getResourceAsStream("crab.png");
    		Image img = new Image(is);
    		ImageView iv = new ImageView(img);
    		iv.setFitWidth(500);
			iv.setFitHeight(500);
			panelInicial.getChildren().add(iv);
			panelInicial.setAlignment(Pos.CENTER);
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}	
    }

    private void iniciaMenu() {
    	miNuevo = new MenuItem("Nuevo");
		miAbrir = new MenuItem("Abrir");
		miGuardar = new MenuItem("Guardar");
		miNuevo.setOnAction(e->miNuevoClick());
		//miAbrir.setOnAction(e->miAbrirClick());
		//miGuardar.setOnAction(e->miGuardarClick());
		mArchivo = new Menu("Archivo");
		mArchivo.getItems().add(miNuevo);
		mArchivo.getItems().add(miAbrir);
		mArchivo.getItems().add(miGuardar);
		mbMenu = new MenuBar(mArchivo);
    }

    private void miNuevoClick(){
    	TabBalanza tb = new TabBalanza("Cuentas*");
    	panelBalanza.getTabs().add(tb);
    	panelBalanza.getSelectionModel().select(tb);
    }

    public static void main(String args[]) {
    	launch();
    }
}