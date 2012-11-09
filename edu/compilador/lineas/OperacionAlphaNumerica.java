/*
 * Creado el 21-may-2005
 *
 */
package edu.compilador.lineas;

import edu.compilador.clases.Cadena;
import edu.compilador.sentencias.Constante;
import edu.recurso.lista.Lista;

public class OperacionAlphaNumerica extends Operacion{

	public OperacionAlphaNumerica(Lista sentencias) {
		super(sentencias);
	}

	public void ejecutar() {
		
	}
	public Cadena ejecutar(boolean b){
		
		return (Cadena) ((Constante)getSentencias().elementoEn(0)).getValor();
	}
}
