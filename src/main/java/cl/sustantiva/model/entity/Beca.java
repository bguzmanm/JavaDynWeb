package cl.sustantiva.model.entity;

public class Beca {
	
	private int id;
	private String nombre;
	private double monto;
	private int cupos;
	
	public Beca(int id, String nombre, double monto, int cupos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.monto = monto;
		this.cupos = cupos;
	}
	
	public Beca() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public int getCupos() {
		return cupos;
	}
	public void setCupos(int cupos) {
		this.cupos = cupos;
	}
	
	
	
}
