package cl.sustantiva.model.service;

import java.util.ArrayList;
import java.util.List;

import cl.sustantiva.model.conn.Conexion;
import cl.sustantiva.model.entity.Beca;

public class BecaService {

	
	private List<Beca> becas;

	public BecaService() {
		super();
		
		
		this.becas = new ArrayList<Beca>();
		llenaBecas();
		
	}
	
	public List<Beca> get(){
		return becas;
	}
	
	public void add(Beca p) {
		becas.add(p);
	}
	
	public Beca get(int id) {
		Beca elegido = null;
		
		for (Beca b : becas) {
			if (b.getId() == id)
				elegido = b;
		}
		return elegido;
	}
	
	private void llenaBecas(){
		becas.add(new Beca(1, "Eusevio Lillo", 5550000d, 30));
		becas.add(new Beca(2, "Bill Puertas", 8900000d, 50));
		becas.add(new Beca(3, "Todo Mejora", 1500000d, 10));
		becas.add(new Beca(4, "Jeff Bezos", 9500000d, 40));
		
	}
	
	
	
}
