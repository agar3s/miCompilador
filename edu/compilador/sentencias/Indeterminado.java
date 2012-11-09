/*
 * Creado el 18-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.sentencias;


/**Indeterminado.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public class Indeterminado extends Sentencia {
	

	public Indeterminado(String tipo) {
		super(tipo);
	}
	
	public boolean isNumerico(){
		boolean numerico=true;
		for(int i=0; i<getTipo().length(); i++){
			char a=getTipo().charAt(i);
			if(	a!='1'&&a!='2'&&a!='3'&&a!='4'&&a!='5'&&
				a!='6'&&a!='7'&&a!='8'&&a!='9'&&a!='0'){
				numerico=false;
				break;		
			}
		}
		return numerico;
	}

}
