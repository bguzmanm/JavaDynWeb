package cl.sustantiva.model.service;

import java.util.ArrayList;
import java.util.List;

import cl.sustantiva.model.entity.Postulante;

public class PostulanteService {

	
	private List<Postulante> postulantes;

	public PostulanteService() {
		super();
		
		this.postulantes = new ArrayList<Postulante>();
		llenaPostulantes();
		
	}
	
	public List<Postulante> get(){
		return postulantes;
	}
	
	public void add(Postulante p) {
		postulantes.add(p);
	}
	
	public Postulante get(int id) {
		Postulante elegido = null;
		
		for (Postulante p : postulantes) {
			if (p.getId() == id)
				elegido = p;
		}
		return elegido;
	}
	
	private void llenaPostulantes(){
		postulantes.add(new Postulante(1, "Angélica", "Ramirez", 46, 6.9f));
		postulantes.add(new Postulante(2, "José Manuel", "Villegas", 35, 6.3f));
		postulantes.add(new Postulante(3, "Annan", "Rojas", 25, 6.4f));
		postulantes.add(new Postulante(4, "Cristian", "Pino", 28, 6.9f));
		
	}
	
	
	
}
