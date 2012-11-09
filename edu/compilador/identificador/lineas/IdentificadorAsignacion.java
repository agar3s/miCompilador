/*
 * Creado el 19-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador.identificador.lineas;

import edu.compilador.clases.AlphaNumerico;
import edu.compilador.clases.Logico;
import edu.compilador.clases.Numerico;
import edu.compilador.instrucciones.Instruccion;
import edu.compilador.lineas.Asignacion;
import edu.compilador.lineas.Indeterminada;
import edu.compilador.lineas.Linea;
import edu.compilador.lineas.Operacion;
import edu.compilador.lineas.OperacionAlphaNumerica;
import edu.compilador.lineas.OperacionLogica;
import edu.compilador.lineas.OperacionNumerica;
import edu.compilador.sentencias.Operador;
import edu.compilador.sentencias.Variable;
import edu.recurso.lista.Lista;

public class IdentificadorAsignacion
	extends IdentificadorLinea {
		
	public IdentificadorAsignacion(Instruccion instruccion) {
		super(instruccion);
		setSucesor(new IdentificadorInvocacion(getInstruccion()));
	}

	public Linea identificarCode(Lista lista){
		Linea linea = null;
		boolean identifico=false;

		if(lista.tamanio()>=3){
			if(	lista.elementoEn(0) instanceof Variable && 
				lista.elementoEn(1) instanceof Operador){
				if(	((Operador)lista.elementoEn(1)).getTipo().compareTo("=")==0||
					((Operador)lista.elementoEn(1)).getTipo().compareTo("<-")==0){	
					linea= identificarAsignacion(lista);
					identifico=true;
				}
			}
		}
		if(identifico){
			
		}
		else
			linea=((IdentificadorInvocacion)getSucesor()).identificarCode(lista);
		return linea;
	}
	
	private Linea identificarAsignacion(Lista lista){
		
		IdentificadorOperacion identificador=
			 new IdentificadorOperacion(getInstruccion());
		Linea operacion=identificador.identificarCode(listaOperacion(lista));
		Lista asigner= new Lista();
		asigner.add(lista.elementoEn(0));
		asigner.add(operacion);
		
		Linea linea= null;
		if(operacion instanceof Operacion){
			
			if((((Variable)lista.elementoEn(0)).getClase() instanceof Numerico
			&&operacion instanceof OperacionNumerica)||
			(((Variable)lista.elementoEn(0)).getClase() instanceof AlphaNumerico
			&&operacion instanceof OperacionAlphaNumerica)||
			(((Variable)lista.elementoEn(0)).getClase() instanceof Logico
			&&operacion instanceof OperacionLogica))
			linea= new Asignacion(asigner);
			else {
				linea= new Indeterminada(asigner);
				((Indeterminada)linea).setError(Indeterminada.ERROR_OPERACION_NO_VALIDA());
				
			}
		}
		else if(operacion instanceof Indeterminada){
			linea= new Indeterminada(asigner);
			((Indeterminada)linea).setError(Indeterminada.ERROR_OPERADOR_NO_VALIDO());
			
		}
		return linea;
	}
	
	private Lista listaOperacion(Lista lista){
		Lista operacion= new Lista();
		int i=2;
		while(i<lista.tamanio()){
			operacion.add(lista.elementoEn(i));
			i++;
		}
		return operacion;
	}
}
