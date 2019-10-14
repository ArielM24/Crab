import java.io.*;

public class Cuenta implements Serializable{
	private static final long serialVersionUID = 6529685098267757690L;
	private String nombre;
	private String descripcion;
	public Cuenta(String nombre) {
		this.nombre = nombre;
		this.descripcion = "Cuenta.";
	}

	public Cuenta(String nombre, String descripcion){
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public String getDescripcion(){
		return descripcion;
	}

	public void setDescripcion(String descripcion){
		this.descripcion=descripcion;
	}
	@Override
	public String toString(){
		return nombre;
	}

	@Override
	public boolean equals(Object obj){
		if(obj instanceof Cuenta){
			Cuenta a = (Cuenta)obj;
			return a.getNombre().equals(this.nombre);
		}else return false;
	}
}