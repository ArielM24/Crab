import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import java.util.HashMap;

public class TabBalanza extends Tab {
	private BorderPane bpCuentas;
	private ScrollPane spCuentas, spTes;
	private VBox vbCuentas;
	private ListView<Cuenta> lvCuentas;
	private TextArea taDescripcion;
	private Button btnAgrega;
	private GridPane gpCuentas;
	private int x = 0,y = 0;

	public TabBalanza(String nombre) {
		super(nombre);
		initComp();
		setOnCloseRequest(e->{e.consume();});
	}

	private void initComp(){
		gpCuentas = new GridPane();
		spTes = new ScrollPane(gpCuentas);
		spTes.setMaxHeight(500);
		spTes.setMaxWidth(500);
		lvCuentas = new ListView<Cuenta>();
		bpCuentas = new BorderPane();
		vbCuentas = new VBox(10);
		vbCuentas.setAlignment(Pos.CENTER);
		taDescripcion = new TextArea();
		taDescripcion.setEditable(false);
		btnAgrega = new Button("Agrega");
		btnAgrega.setDisable(true);
		btnAgrega.setOnAction(e->btnAgregaClick());
		agregaCuentas();
		spCuentas = new ScrollPane(vbCuentas);
		spCuentas.setPadding(new Insets(10));
		spCuentas.setMaxHeight(400);
		spCuentas.setMaxWidth(200);
		bpCuentas.setLeft(vbCuentas);
		bpCuentas.setCenter(spTes);
		setContent(bpCuentas);
	}

	private void agregaCuentas() {
		for(int i = 0; i < 20; i++){
			Cuenta c = new Cuenta(""+i);
			lvCuentas.getItems().add(c);
		}
		lvCuentas.getSelectionModel().selectedItemProperty().addListener((obj,oldv,newv) -> {
			taDescripcion.setText(newv.getDescripcion());
			if(newv != null) {
				btnAgrega.setDisable(false);
			}else{
				btnAgrega.setDisable(true);
			}
		});
		taDescripcion.setMaxWidth(200);
		taDescripcion.setMaxHeight(100);
		vbCuentas.getChildren().add(lvCuentas);
		vbCuentas.getChildren().add(taDescripcion);
		vbCuentas.getChildren().add(btnAgrega);
	}

	private void btnAgregaClick(){
		Cuenta c = lvCuentas.getSelectionModel().getSelectedItem();
		if(c!=null){
			gpCuentas.add(new T(c.getNombre(), c), x, y);
			x++;
			if(x > 3){
				x = 0;
				y++;
			}
		}
	}
}