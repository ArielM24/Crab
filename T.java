import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.ArrayList;

public class T extends TitledPane{
	private Cuenta cuenta;
	private VBox pane;
	private ListView<String> lvAcredor, lvDeudor;
	private ArrayList<Operacion> operaciones;
	private VBox vbAcredor, vbDeudor;
	private Label lblAcredor, lblDeudor,lblSaldo;
	private Double saldoAcredor, saldoDeudor;
	private int X,Y;
	public T(Cuenta cuenta){
		super(cuenta.getNombre(), new HBox());
		initComp();
		this.cuenta = cuenta;
		setMaxWidth(250);
		setMaxHeight(290);
		saldoDeudor = 0.0;
		saldoAcredor = 0.0;
		X = 0;
		Y = 0;
	}

	private void initComp(){
		operaciones = new ArrayList<Operacion>();
		lvAcredor = new ListView<String>();
		lvDeudor = new ListView<String>();
		lblDeudor = new Label("$0.0");
		lblAcredor = new Label("$0.0");
		lblSaldo = new Label("$0.0");
		lblSaldo.setMinHeight(70);
		vbDeudor = new VBox(10, lvDeudor,lblDeudor);
		vbAcredor = new VBox(10,lvAcredor,lblAcredor);
		HBox h = new HBox(10,vbDeudor ,vbAcredor);
		pane = new VBox(10,h,lblSaldo);
		setContent(pane);
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof T){
			T t = (T)obj;
			return t.cuenta.getNombre().equals(this.cuenta.getNombre());
		}else return false;
	}

	public double getSaldo(){
		return saldoDeudor - saldoAcredor;
	}

	public void actualiza(Operacion op){
		double cantidad = op.getCantidad();
		operaciones.add(op);
		if(op.getTipo()){
			saldoDeudor += cantidad;
			lblDeudor.setText("$"+saldoDeudor);
			lvDeudor.getItems().add(op.getId()+")$"+cantidad);
		}else{
			saldoAcredor += cantidad;
			lblAcredor.setText("$"+saldoAcredor);
			lvAcredor.getItems().add(op.getId()+")$"+cantidad);
		}
		double saldo = getSaldo();
		if(saldo > 0){
			lblSaldo.setText("Saldo:\nDeudor: $"+saldo);
		}else if(saldo < 0){
			lblSaldo.setText("Saldo:\nAcredor: $"+ (-saldo));
		}else{
			lblSaldo.setText("$0.00");
		}
	}
	public void borra(Operacion op){
		operaciones.remove(op);
	}

	public void xy(int x, int y){
		this.X = x;
		this.Y = y;
	}
	public int getX(){
		return X;
	}

	public int getY(){
		return Y;
	}

	public boolean esVacia(){
		return lvAcredor.getItems().isEmpty() && lvDeudor.getItems().isEmpty();
	}
	public Cuenta getCuenta(){
		return cuenta;
	}
	public void setCuenta(Cuenta c){
		this.cuenta = c;
		setText(c.getNombre());
		for(Operacion op: operaciones){
			if(op.getCuenta().equals(c)){
				op.setCuenta(c);
			}
		}
	}
}