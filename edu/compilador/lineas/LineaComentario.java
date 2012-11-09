/*
 * Creado el 25-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.lineas;

import edu.recurso.lista.Lista;

public class LineaComentario extends Linea {

	private String comentario;
	
	public LineaComentario(Lista sentencias) {
		super(sentencias);
	}
	public LineaComentario(String comentario){
		super(null);
		this.comentario= comentario;
		addTabs();
	}
	public void addTabs(){
		String actualizado="";
		for(int j=0; j<comentario.length(); j++){
			if(comentario.charAt(j)!='\t')
				actualizado=actualizado+comentario.charAt(j);
		}
		comentario= actualizado;
	}
	public String getFormaCodigo(){
		return comentario;
	}
	//esta linea no debe ejecutar nada.
	public void ejecutar() {
		setEjecutada(true);
	}
}
