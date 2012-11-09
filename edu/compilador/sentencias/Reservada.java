/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.sentencias;

import edu.compilador.RecursoCompilador;
import edu.compilador.clases.Cadena;
import edu.compilador.clases.Entero;
import edu.compilador.clases.Real;
import edu.compilador.clases.Bool;
import edu.compilador.funciones.AccionEscribir;
import edu.compilador.funciones.AccionEscribirLn;
import edu.compilador.funciones.AccionLeer;


/*
 * las palabras reservadas son la que utiliza el compilador, para 
 * efectuar instrucciones del sistema:
 * clase, lea, escriba, si, sino, mq, para, nulo, verdadero, falso,
 * ...
 * Ejemplo: clase Perro.	//reservada clase	nueva instruccion claseI 
 * 			si(a==b)		//reservada si		nueva instruccion condicional
 * 			
 */
public class Reservada extends Sentencia{
	
	private RecursoCompilador recurso;

	public Reservada(String tipo) {
		super(tipo);
		if(tipo.compareTo("entero")==0)
			recurso= new Entero(0);
		else if(tipo.compareTo("real")==0)
			recurso= new Real(0);
		else if(tipo.compareTo("cadena")==0)
			recurso= new Cadena("");
		else if(tipo.compareTo("bool")==0)
			recurso= new Bool(false);
		else if(tipo.compareTo("verdadero")==0)
			recurso= new Bool(true);
		else if(tipo.compareTo("falso")==0)
			recurso= new Bool(false);
		else if(tipo.compareTo("leer")==0)
			recurso= new AccionLeer();
		else if(tipo.compareTo("escribir")==0)
			recurso= new AccionEscribir();
		else if(tipo.compareTo("escribirln")==0)
			recurso= new AccionEscribirLn();
		
	}

	public RecursoCompilador getRecurso() {
		return recurso;
	}

	public void setRecurso(RecursoCompilador compilador) {
		recurso = compilador;
	}

}
