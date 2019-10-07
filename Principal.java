import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import java.io.*;


public class Principal extends Application {
	private Stage stagePrincipal;
	private Scene scenePrincipal;
	private TabPane panePrincipal;
    @Override

    public void start(Stage primaryStage){
    	stagePrincipal = primaryStage;
    	initComp();
    	scenePrincipal = new Scene(panePrincipal, 1200,700);
    	stagePrincipal.setScene(scenePrincipal);
    	stagePrincipal.setTitle("Crab");
    	stagePrincipal.show();
    }

    private void initComp() {
    	panePrincipal = new TabPane();
    	Tab t1 = new Tab("Crab");
    	panePrincipal.getTabs().add(t1);
    	panePrincipal.getTabs().get(0).setOnCloseRequest(e-> {e.consume();});
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

    public static void main(String args[]) {
    	launch();
    }
}