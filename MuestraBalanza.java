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
		scene = new Scene(spPane,1000,600);
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(b.getNombre());
		stage.showAndWait();
	}
	private static void initComp(Balanza b){
		balanza = b;
		ta = new TextArea();
		ta.setMinWidth(900);
		ta.setMinHeight(500);
		btnImprimir = new Button("Imprimir/exportar PDF");
		btnImprimir.setTooltip(new Tooltip("Puede no funcionar en linux"));
		btnImprimir.setOnAction(e->btnImprimirClick());
		pane = new VBox(10,ta,btnImprimir);
		spPane = new ScrollPane(pane);
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10));
		ta.setText(generaTexto());
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
	private static String espacios(int n){
		String s = "";
		for(int i = 0; i < n; i++){
			s+=" ";
		}
		return s;
	}
	public static int strSize(String str){
		int s = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == 'l' || str.charAt(i) == 't' ||str.charAt(i) == 'i'||str.charAt(i) == 'f'
				||str.charAt(i) == 'j'||str.charAt(i) == ','||str.charAt(i) == '.'||str.charAt(i) == '|'
				||str.charAt(i) == 'r'||str.charAt(i) == ' ')
				s++;
			else
				s += 2;
		}
		return s;
	}
	private static String generaTexto(){
		String data = "\t\t\tBalanza de comprobacion "+balanza.getNombre()+"\n";
		int l = balanza.getLongitudDatos();
		data += "Cuentas"+espacios(l - strSize("Cuentas"));
		data += "Movimientos"+espacios(l*2 - strSize("Movimientos"));
		data += "Saldos"+espacios(l - strSize("Saldos"))+"\n";
		data += espacios(l);
		data += "Deudor"+espacios(l - strSize("Deudor"));
		data += "Acreedor"+espacios(l - strSize("Acreedor"));
		data += "Deudor"+espacios(l - strSize("Deudor"));
		data += "Acreedor"+espacios(l - strSize("Acreedor"))+"\n";
		for(int i = 0; i < l*5; i++){
			data += "-";
		}
		data += "\n";
		for(TSerializable ts: balanza.getDatos()){
			String str1 = ts.getCuenta().getNombre();
			String str2 = "$"+ts.getMovDeudor();
			String str3 = "$"+ts.getMovAcreedor();
			double saldo = ts.getSaldo();
			data += str1 + espacios(l - strSize(str1));
			data += str2 + espacios(l - strSize(str2));
			data += str3 + espacios(l - strSize(str3));
			if(saldo > 0){
				data += "$"+saldo + espacios(l - strSize("$"+saldo))+"\n";
			}else if (saldo < 0){
				data += espacios(l) + "$"+(-saldo)+"\n";
			}else{
				data += "\n";
			}
		}
		for(int i = 0; i < l*5; i++){
			data += "-";
		}
		data += "\n";
		String str1 = "$"+balanza.getMovDeudor();
		String str2 = "$"+balanza.getMovAcreedor();
		data += espacios(l) + str1 + espacios(l - strSize(str1));
		data += str2 + espacios(l - strSize(str2));
		double saldoFinal[] = balanza.getSaldos();
		data += "$"+saldoFinal[0] + espacios(l - strSize("$"+saldoFinal[0]));
		data += "$"+saldoFinal[1] + espacios(l - strSize("$"+saldoFinal[1]))+"\n";

		return data;
	}
}