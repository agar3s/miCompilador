/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.lineas;

import edu.compilador.clases.AlphaNumerico;
import edu.compilador.clases.Cadena;
import edu.compilador.clases.Entero;
import edu.compilador.clases.Numerico;
import edu.compilador.clases.Real;
import edu.compilador.sentencias.Variable;
import edu.recurso.lista.Lista;
/*
 * las lineas de asignacion son aquellas que asignan un valor a una
 * variable, estas lineas estan compuestas solo de dos tipos de 
 * sentencias:
 * 		VariableAsignada valor
 */
public class Asignacion extends Linea{
	//el valor es otra linea de tipo operacion
	//que puede ser un solo valor de retorno, este valor es la ultima
	//sentencia de la linea asignacion 

	public Asignacion(Lista sentencias) {
		super(sentencias);
	}
	
	public void ejecutar(){
		
		//aqui se ejecuta la linea operacion y su valor de retorno
		//se asigna a la variable
		if(getSentencias().elementoEn(1) instanceof OperacionNumerica){
			Numerico valor= ((OperacionNumerica)getSentencias().elementoEn(1)).ejecutar(true);
			double resultado=0;
			if(valor instanceof Entero){
				resultado= ((Entero)valor).getValor();
			}else if(valor instanceof Real){
				resultado= ((Real)valor).getValor();
			}
			System.out.println("Resultado: "+resultado);
			if(getSentencias().elementoEn(0) instanceof Variable){
				Variable variable= (Variable) getSentencias().elementoEn(0);
				if(variable.getClase() instanceof Entero){
					((Entero)variable.getClase()).setValor((int) resultado);	
				}else if(variable.getClase() instanceof Real){
					((Real)variable.getClase()).setValor(resultado);
				}
			}
		}else if(getSentencias().elementoEn(1) instanceof OperacionAlphaNumerica){
			AlphaNumerico valor= ((OperacionAlphaNumerica)getSentencias().elementoEn(1)).ejecutar(true);
			String resultado= ((Cadena)valor).getValor();
			if(getSentencias().elementoEn(0) instanceof Variable){
				Variable variable= (Variable) getSentencias().elementoEn(0);
				if(variable.getClase() instanceof Cadena){
					((Cadena)variable.getClase()).setValor(resultado);	
				}
			}
		}	
		setEjecutada(true);
	}



}
