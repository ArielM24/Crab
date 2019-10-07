import javafx.scene.control.*;
import javafx.scene.layout.*;

public class T extends TitledPane{
	private Cuenta cuenta;
	private HBox pane;
	private ListView<Double> lvAcredor, lvDeudor;
	private VBox vbAcredor, vbDeudor;
	private Label lblAcredor, lblDeudor;
	public T(String nombre, Cuenta cuenta){
		super(nombre, new HBox());
		initComp();
		this.cuenta = cuenta;
		setMaxWidth(250);
		setMaxHeight(250);
	}

	private void initComp(){
		lvAcredor = new ListView<Double>();
		lvDeudor = new ListView<Double>();
		lblDeudor = new Label("$0.0");
		lblAcredor = new Label("$0.0");
		vbDeudor = new VBox(10, lvDeudor,lblDeudor);
		vbAcredor = new VBox(10,lvAcredor,lblAcredor);
		pane = new HBox(10,vbDeudor ,vbAcredor);
		setContent(pane);
	}
}