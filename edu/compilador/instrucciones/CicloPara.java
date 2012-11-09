/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.instrucciones;

import edu.recurso.lista.Lista;

public class CicloPara extends Instruccion {
	private Lista sentencias;
	//para(entero a=0;a<=10;a=a+1)
	//entero x=10;
	//para(x;x>0;x=x-1)
	//el ciclo esta divido en 3 instrucciones:
	//1ª de inicio de ciclo	que debe ser un entero//ejemplo:0
	//2ª de final de ciclo			//ejemplo:10
	//3ª de incremento en el ciclo	//ejemplo:1

	public CicloPara(Instruccion antecesor, Lista lineas, String nombre) {
		super(antecesor, lineas, nombre);
	}


	public boolean ejecutar() {
		//aqui se decide que se ejecuta?
		boolean b=super.ejecutar();
		return b;
	}



}
