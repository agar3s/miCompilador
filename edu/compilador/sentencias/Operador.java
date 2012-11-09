/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.sentencias;

/**Operador.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
/*
 * Los operadores, son aquellos que permiten realizar operaciones
 * entre constantes y variables: '+', '-', '*', '/', '%', '<-' e '=';
 * Ejemplo: b= a*c; ó b<-a*c; //operadores: '=', '*' y '<-'	//nueva Linea asignacion por operacion; 
 */
public class Operador extends Sentencia{

	private int prioridad;
	
	public Operador(String tipo){
		super(tipo);
		if(tipo.equals("+")||tipo.equals("-"))
			setPrioridad(3);
		else if(tipo.equals("*")||tipo.equals("/"))
			setPrioridad(2);
		else if(tipo.equals("%"))
			setPrioridad(1);
		
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int i) {
		prioridad = i;
	}

}
