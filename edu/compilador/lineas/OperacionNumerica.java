/*
 * Creado el 21-may-2005
 *
 */
package edu.compilador.lineas;

import edu.compilador.clases.Entero;
import edu.compilador.clases.Numerico;
import edu.compilador.clases.Real;
import edu.compilador.sentencias.Constante;
import edu.compilador.sentencias.Operador;
import edu.compilador.sentencias.Variable;
import edu.recurso.lista.Lista;

public class OperacionNumerica extends Operacion {
	
	private Lista posfijo;

	public OperacionNumerica(Lista sentencias) {
		super(sentencias);
		setPosfijo();

	}
	
	public void setPosfijo(){
		posfijo= new Lista();
		Lista operadores= new Lista();
		for(int i=0; i<getSentencias().tamanio(); i++){
			if(getSentencias().elementoEn(i) instanceof Variable||
			getSentencias().elementoEn(i) instanceof OperacionNumerica||
			getSentencias().elementoEn(i) instanceof Constante){
				posfijo.add(getSentencias().elementoEn(i)); 
			}else if(getSentencias().elementoEn(i) instanceof Operador){
				if(operadores.tamanio()==0){
					operadores.add(getSentencias().elementoEn(i));	
				}else{
					Operador ultimo=
						(Operador)operadores.elementoEn
									(operadores.tamanio()-1);
					Operador nuevo=
						((Operador)getSentencias().elementoEn(i));
					if(nuevo.getPrioridad()>=ultimo.getPrioridad()){	
						while(ultimo!=null){
							posfijo.add(ultimo);
							operadores.removerEn(operadores.tamanio()-1);
							ultimo=
								(Operador) operadores.elementoEn(operadores.tamanio()-1);
						}
					}
					operadores.add(nuevo);
					
				}
			}
		}
		if(operadores.tamanio()>0){
			Operador ultimo=(Operador)operadores.elementoEn(operadores.tamanio()-1);
			while(ultimo!=null){
				posfijo.add(ultimo);
				operadores.removerEn(operadores.tamanio()-1);
				ultimo=
					(Operador) operadores.elementoEn(operadores.tamanio()-1);
			}
		}
	}
	

	public void ejecutar() {
			
	}
	
	public Numerico ejecutar(boolean b){
		Numerico r=null;
		Lista temp=new Lista();
		
		for(int i=0; i<posfijo.tamanio(); i++){
			
			if(posfijo.elementoEn(i) instanceof Operador){
				temp=operar((Operador) posfijo.elementoEn(i),temp);
			}else if(posfijo.elementoEn(i) instanceof OperacionNumerica)
				temp.add(((OperacionNumerica)posfijo.elementoEn(i)).ejecutar(true));
			else
				temp.add(posfijo.elementoEn(i));
				
		}
		if(temp.tamanio()==1){
			
			if(temp.elementoEn(0) instanceof Constante){
				
				if(((Constante)temp.elementoEn(0)).getValor() instanceof Real)
					r= (Real) ((Constante)temp.elementoEn(0)).getValor();
				else if(((Constante)temp.elementoEn(0)).getValor() instanceof Entero)
					r=(Entero)((Constante)temp.elementoEn(0)).getValor();
			}else if(temp.elementoEn(0) instanceof Real){
				System.out.println("Real?:"+((Real) temp.elementoEn(0)).getValor());
				r=(Real) temp.elementoEn(0);
			}else if(temp.elementoEn(0) instanceof Entero){
				r=(Entero) temp.elementoEn(0);
			}else
				System.out.println(temp.elementoEn(0));
		}
		return r;
	}
	
	public Lista operar(Operador operador, Lista lista){
		double a=0;
		double b=0;
		double r=0;
		if(lista.elementoEn(lista.tamanio()-1) instanceof Variable){
			Variable v=(Variable) lista.elementoEn(lista.tamanio()-1);
			if(v.getClase() instanceof Real)
				a= ((Real)v.getClase()).getValor();
			else if(v.getClase() instanceof Entero)
				a=((Entero)v.getClase()).getValor();
		}else if(lista.elementoEn(lista.tamanio()-1) instanceof Constante){
			Constante c= (Constante)lista.elementoEn(lista.tamanio()-1);
			if(c.getValor() instanceof Real)
				a= ((Real)c.getValor()).getValor();
			else if(c.getValor() instanceof Entero)
				a=((Entero)c.getValor()).getValor();
		}else if(lista.elementoEn(lista.tamanio()-1) instanceof OperacionNumerica){
			Numerico n= ((OperacionNumerica)lista.elementoEn(lista.tamanio()-1)).ejecutar(true);
			if(n instanceof Real)
				a=((Real)n).getValor();
			else if(n instanceof Entero)
				a=((Entero)n).getValor();
		}else if(lista.elementoEn(lista.tamanio()-1) instanceof Numerico){
			Numerico n=(Numerico) lista.elementoEn(lista.tamanio()-1);
			if(n instanceof Real)
				a=((Real)n).getValor();
			else if(n instanceof Entero)
				a=((Entero)n).getValor();
		}
			
		
		if(lista.elementoEn(lista.tamanio()-2) instanceof Variable){
			Variable v=(Variable) lista.elementoEn(lista.tamanio()-2);
			if(v.getClase() instanceof Real)
				b= ((Real)v.getClase()).getValor();
			else if(v.getClase() instanceof Entero)
				b=((Entero)v.getClase()).getValor();
		}else if(lista.elementoEn(lista.tamanio()-2) instanceof Constante){
			Constante c= (Constante)lista.elementoEn(lista.tamanio()-2);
			if(c.getValor() instanceof Real)
				b= ((Real)c.getValor()).getValor();
			else if(c.getValor() instanceof Entero)
				b=((Entero)c.getValor()).getValor();
		}else if(lista.elementoEn(lista.tamanio()-2) instanceof OperacionNumerica){
			Numerico n= ((OperacionNumerica)lista.elementoEn(lista.tamanio()-2)).ejecutar(true);
			if(n instanceof Real)
				b=((Real)n).getValor();
			else if(n instanceof Entero)
				b=((Entero)n).getValor();
		}else if(lista.elementoEn(lista.tamanio()-2) instanceof Numerico){
			Numerico n=(Numerico) lista.elementoEn(lista.tamanio()-2);
			if(n instanceof Real)
				b=((Real)n).getValor();
			else if(n instanceof Entero)
				b=((Entero)n).getValor();
		}
		
		
		lista.removerEn(lista.tamanio()-1);
		lista.removerEn(lista.tamanio()-1);
		
		if(operador.getTipo().compareTo("+")==0){
			r=b+a;
		}else if(operador.getTipo().compareTo("-")==0){
			r=b-a;
		}else if(operador.getTipo().compareTo("/")==0){
			r=b/a;
		}else if(operador.getTipo().compareTo("*")==0){
			r=b*a;
		}else if(operador.getTipo().compareTo("%")==0){
			r=b%a;
		}
		System.out.print(" b: "+b);
		System.out.print(operador.getTipo());
		System.out.print(" a: "+a);
		System.out.println("resultd: "+r);
		lista.add(new Constante("",new Real(r)));
		return lista;
	}
	
}
