/*
 * Creado el 24-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.lineas;

import edu.compilador.funciones.AccionEscribir;
import edu.compilador.funciones.AccionEscribirLn;
import edu.compilador.funciones.AccionLeer;
import edu.compilador.sentencias.Reservada;
import edu.compilador.sentencias.Variable;
import edu.recurso.lista.Lista;

public class FuncionSistema extends Linea{


	public FuncionSistema(Lista sentencias) {
		super(sentencias);
		
	}

	public void ejecutar() {
		if(getSentencias().elementoEn(0) instanceof Reservada){
			if(((Reservada)(getSentencias().elementoEn(0))).getRecurso() instanceof AccionEscribir){
				AccionEscribir escribir=(AccionEscribir) ((Reservada)(getSentencias().elementoEn(0))).getRecurso();
				escribir.setFuncion(getConsola());
				escribir.setClase(((Variable) getSentencias().elementoEn(1)).getClase());
				escribir.ejecutar();
				setEjecutada(true);
			}else if(((Reservada)(getSentencias().elementoEn(0))).getRecurso() instanceof AccionEscribirLn){
				System.out.println("funcion ejecutada: es");
				AccionEscribirLn escribirln=(AccionEscribirLn) ((Reservada)(getSentencias().elementoEn(0))).getRecurso();
				escribirln.setFuncion(getConsola());
				escribirln.setClase(((Variable) getSentencias().elementoEn(1)).getClase());
				escribirln.ejecutar();
				setEjecutada(true);
				
			}else if(((Reservada)(getSentencias().elementoEn(0))).getRecurso() instanceof AccionLeer){
				System.out.println("funcion ejecutada: leer");
				AccionLeer leer= (AccionLeer) ((Reservada)(getSentencias().elementoEn(0))).getRecurso();
				leer.setFuncion(getConsola());
				leer.setClase(((Variable) getSentencias().elementoEn(1)).getClase());
				System.out.println("aquie se quedo");
				leer.setSistem(this);
				leer.ejecutar();
				
			}	
		}
	}

	


}
