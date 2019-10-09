import javafx.scene.control.*;
import javafx.scene.layout.*;

public class T extends TitledPane{
	private Cuenta cuenta;
	private HBox pane;
	private ListView<String> lvAcredor, lvDeudor;
	private VBox vbAcredor, vbDeudor;
	private Label lblAcredor, lblDeudor;
	private Double saldoAcredor, saldoDeudor;
	public T(Cuenta cuenta){
		super(cuenta.getNombre(), new HBox());
		initComp();
		this.cuenta = cuenta;
		setMaxWidth(250);
		setMaxHeight(250);
		saldoDeudor = 0.0;
		saldoAcredor = 0.0;
	}

	private void initComp(){
		lvAcredor = new ListView<String>();
		lvDeudor = new ListView<String>();
		lblDeudor = new Label("$0.0");
		lblAcredor = new Label("$0.0");
		vbDeudor = new VBox(10, lvDeudor,lblDeudor);
		vbAcredor = new VBox(10,lvAcredor,lblAcredor);
		pane = new HBox(10,vbDeudor ,vbAcredor);
		setContent(pane);
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof T){
			T t = (T)obj;
			return t.cuenta.getNombre().equals(this.cuenta.getNombre());
		}else return false;
	}

	public void actualiza(Operacion op, String mov){
		double cantidad = op.getCantidad();
		if(op.getTipo()){
			saldoDeudor += cantidad;
			lblDeudor.setText("$"+cantidad);
			lvDeudor.getItems().add(mov+")$"+cantidad);
		}else{
			saldoAcredor += cantidad;
			lblAcredor.setText("$"+cantidad);
			lvAcredor.getItems().add(mov+")$"+cantidad);
		}
	}
}