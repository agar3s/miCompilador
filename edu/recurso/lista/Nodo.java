/*
 * Creado el 19-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.recurso.lista;

/**Nodo.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public class Nodo {
	
	private Nodo siguiente;
	private Object elemento;
	private int posicion=0;
	
	public Nodo(Object elemento){
		this.elemento= elemento;
	}

	
	public void add(Nodo siguiente){
		if(this.siguiente!=null)
			this.siguiente.add(siguiente);
		else{
			this.siguiente= siguiente;
			siguiente.setPosicion(posicion+1);
		}
	}
	public void addEn(Object elemento, int posicion){
		if(this.siguiente!=null && posicion==this.posicion+1){
			Nodo siguiente= new Nodo(elemento);
			siguiente.setPosicion(this.posicion+1);
			siguiente.setSiguiente(this.siguiente);	
			this.siguiente=siguiente;
		}else if(siguiente!=null)
			siguiente.addEn(elemento, posicion);
		else if(posicion==this.posicion+1)
			add(new Nodo(elemento));
	}
	
	public void setSiguiente(Nodo siguiente){
		this.siguiente= siguiente;
		this.siguiente.incrementar();
	}
	public Object elementoEn(int posicion){
		Object elemento= null;
		if(this.posicion==posicion)
			elemento= this.elemento;
		else if(siguiente!=null)
			elemento= siguiente.elementoEn(posicion);
		return elemento;
	}
	
	public int tamanio(){
		int tamanio=posicion+1;
		if(siguiente!=null)
			tamanio= siguiente.tamanio();
			
		return tamanio;
	}
	

	public void setPosicion(int i) {
		posicion = i;
	}
	public void removerEn(int posicion){
		if(siguiente !=null&&posicion==this.posicion+1){
			siguiente= siguiente.getSiguiente();
			if(siguiente!=null)
				siguiente.decrementar();
		}else if(siguiente!=null)
			siguiente.removerEn(posicion);
		
	}

	public Nodo getSiguiente() {
		return siguiente;
	}
	
	public void incrementar(){
		posicion++;
		if(siguiente!=null)
			siguiente.incrementar();
	}
	public void decrementar(){
		posicion--;
		if(siguiente!=null)
			siguiente.decrementar();
	}

}
