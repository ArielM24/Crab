import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;
import java.io.*;
import javafx.event.*;

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
        stagePrincipal.setOnCloseRequest(e->cerrar(e));
    	stagePrincipal.show();
    }

    private void initComp() {
    	fc = new FileChooser();
		fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CRB FILES (*.crb)","*.crb"));
    	panelBalanza = new TabPane();

    	iniciaIconos();
    	iniciaMenu();
    	panePrincipal = new VBox(10, mbMenu, panelBalanza);
        //panePrincipal.setStyle("-fx-background-color:POWDERBLUE");
    }

    private void iniciaIconos() {
    	Tab t1 = new Tab("Crab");
    	panelBalanza.getTabs().add(t1);
    	panelBalanza.getTabs().get(0).setOnCloseRequest(e-> {e.consume();});
    	Text txtInicial = new Text("CRAB");
        txtInicial.setCache(true);
        txtInicial.setFill(Color.ORANGE);
        txtInicial.setFont(Font.font(null, FontWeight.BOLD, 30));
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        txtInicial.setEffect(r);
    	VBox panelInicial = new VBox(10,txtInicial);
    	t1.setContent(panelInicial);
        panelInicial.setStyle("-fx-background-color:#fff99e");
        t1.setStyle("-fx-background-color:POWDERBLUE");
        //panelBalanza.setStyle("-fx-background-color:POWDERBLUE");
    	try{
			InputStream in = getClass().getResourceAsStream("Crab.png"); 
			stagePrincipal.getIcons().add(new Image(in));
		}catch(Exception ex){
			ex.printStackTrace();
		}
    	try{
    		InputStream is = getClass().getResourceAsStream("Crab.png");
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
		miAbrir.setOnAction(e->miAbrirClick());
		miGuardar.setOnAction(e->miGuardarClick());
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

    private void miGuardarClick(){
        fc.setTitle("Guardar archivo");
        File archivo = fc.showSaveDialog(stagePrincipal);
        if(archivo != null){
            if(!archivo.getName().endsWith(".crb")){
                archivo = new File(archivo.getName()+".crb");
            }
            TabBalanza tb = (TabBalanza)panelBalanza.getSelectionModel().getSelectedItem();
            Balanza b = tb.getBalanza();
            b.setNombre(archivo.getName().split("\\.crb")[0]);
            tb.setText(archivo.getName().split("\\.crb")[0]);
            try{
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(archivo));
                os.writeObject(b);
                tb.setText(archivo.getName().split("\\.crb")[0]);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    private void miAbrirClick(){
        fc.setTitle("Abrir archivo");
        File archivo = fc.showOpenDialog(stagePrincipal);
        if(archivo!=null){
            try{
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(archivo));
                Balanza b = (Balanza)is.readObject();
                miNuevoClick();
                TabBalanza tb = (TabBalanza)panelBalanza.getSelectionModel().getSelectedItem();
                tb.cargaBalanza(b);
                tb.setText(b.getNombre());
            }catch(Exception ex){
                ex.printStackTrace();
                MessageBox.show("Error","Error al abrir "+archivo.getName()+"\n:(");
            }
        }
    }

    
    public void cerrar(Event e){
        if(!ConfirmationBox.show("Cerrar","Salir?\n(El programa no detecta si se han modificado los\narchivos abiertos).","Si","No")){
            e.consume();
        }
    }
    public static void main(String args[]) {
    	launch();
    }
}