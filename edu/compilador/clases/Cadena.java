/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.clases;

/**Cadena.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public class Cadena extends AlphaNumerico{

	private String valor="";
	
	public Cadena(String nombre,String valor) {
		super(nombre);
		this.valor=valor;
		setTipoR("cadena");
	}
	
	//para el caso constante
	public Cadena(String valor){
		super(null);
		this.valor=valor;
		setTipoR("cadena");
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String string) {
		
		valor = string;
	}

}
