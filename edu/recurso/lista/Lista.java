/*
 * Creado el 19-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.recurso.lista;

/**Lista.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public class Lista {
	private Nodo cab;
	
	public Lista(){
		cab= null;
	}
	
	public void add(Object elemento){
		Nodo siguiente= new Nodo(elemento);
		
		if(cab!=null)
			cab.add(siguiente);
		else{
			cab= siguiente;
			cab.setPosicion(0);		
		}
	}
	
	public void addEn(Object elemento, int posicion){
		if(cab!=null && posicion==0){
			Nodo siguiente= new Nodo(elemento);
			siguiente.setPosicion(posicion);
			siguiente.setSiguiente(cab);	
			cab=siguiente;
		}else if(cab!=null)
			cab.addEn(elemento, posicion);
		else if(posicion==0)
			add(elemento);
		
	}
	
	public Object elementoEn(int posicion){
		Object elemento= null;
		if(cab!=null)
			elemento= cab.elementoEn(posicion);
		return elemento;
	}
	
	public void removerEn(int posicion){
		if(posicion==0&&cab!=null){
			cab=cab.getSiguiente();
			if(cab!=null)
				cab.decrementar();
		}else if(cab!=null)
			cab.removerEn(posicion);
	
	}
	
	public int tamanio(){
		int tamanio=0;
		if(cab!=null)
			tamanio= cab.tamanio();
		return tamanio;
	}
}
