/*
 * Creado el 11-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
 
/*
 * Las instrucciones son aquellas que contienen mas codigo entre
 * llaves, como clases, fuciones y sentencias de control, dentro de
 * cada intruccion se hallan lineas de codigo, la funcion Ppal, es
 * una instruccion y debe tener lineas dentro de ella.
 */
package edu.compilador.instrucciones;

import edu.compilador.RecursoCompilador;
import edu.compilador.funciones.FuncionCompilador;
import edu.compilador.lineas.FuncionSistema;
import edu.compilador.lineas.Indeterminada;
import edu.compilador.lineas.Linea;
import edu.compilador.sentencias.Variable;
import edu.recurso.lista.Lista;


public abstract class Instruccion extends RecursoCompilador{
	
	//estas lineas pueden ser tanto sencillas como instrucciones
	private Lista instrucciones;
	private Instruccion antecesor;
	private Lista variables;
	private String error;
	private String nombre;
	private String informeErrores;
	private boolean ERROR;
	
	private boolean ejecutada;
	private Object siguiente;
	private FuncionCompilador consola;
	private boolean ultimaInstruccion;
	
	public Instruccion(Instruccion antecesor,Lista lineas, String nombre){
		this.instrucciones= lineas;
		this.antecesor= antecesor;
		variables= new Lista();
		this.nombre= nombre;
		informeErrores="";
	}

	public Instruccion getAntecesor() {
		return antecesor;
	}

	/**
	 * @param instruccion
	 */
	public void setAntecesor(Instruccion instruccion) {
		antecesor = instruccion;
	}
	
	public int mostrarErrores(){
		int errores=0;
		informeErrores="";
		if(error!=null){
			
			errores++;
		} 
		for(int i=0; i<instrucciones.tamanio(); i++){
			if(instrucciones.elementoEn(i) instanceof Indeterminada){
				errores++;
				informeErrores=informeErrores+("\nerror en linea "+((Linea)instrucciones.elementoEn(i)).getLinea());
				informeErrores=informeErrores+": "+(((Indeterminada)instrucciones.elementoEn(i)).getError());

			} else if(instrucciones.elementoEn(i) instanceof Instruccion){
				errores= errores+((Instruccion)instrucciones.elementoEn(i)).mostrarErrores();
			}
		}
		if(errores>0)
			ERROR=true;
		return errores;
	}

	public Lista getInstrucciones() {
		return instrucciones;
	}
	public void setInstrucciones(Lista lista) {
		instrucciones = lista;
	}

	public Lista getVariables() {
		return variables;
	}

	public void setVariables(Lista lista) {
		variables = lista;
	}
	public void addVariable(Variable variable){
		variables.add(variable);
	}
	public Variable estaVariable(String variable){
		boolean encontro=false;
		Variable var= null;
		for(int i=0; i<variables.tamanio(); i++){
			if(variable.compareTo(((Variable)variables.elementoEn(i)).getTipo())==0){
				encontro=true;
				var= ((Variable)variables.elementoEn(i));
				break;
			}
		}
		if(!encontro&&antecesor!=null){
			var=antecesor.estaVariable(variable);
		}
		return var;
	}
	public String mostrarVariables(){
		String variables="";
		for(int i=0; i<this.variables.tamanio(); i++)
			variables= variables+((Variable)this.variables.elementoEn(i)).getTipo()+"\n";
		for(int i=0; i<instrucciones.tamanio(); i++){
			if(instrucciones.elementoEn(i) instanceof Instruccion){
				variables= variables+((Instruccion)instrucciones.elementoEn(i)).mostrarVariables();
			}
		}
		return variables;
	}

	/**
	 * @return
	 */
	public String getError() {
		return error;
	}

	/**
	 * @param string
	 */
	public void setError(String string) {
		error = string;
	}

	public String getFormaCodigo(int profundidad) {
		String codigo="\n";
		String tab="";
		for(int j=0; j<profundidad; j++)
			tab= tab+"\t";
		for(int i=0; i<instrucciones.tamanio(); i++){
			if(instrucciones.elementoEn(i) instanceof Linea){
				codigo= codigo+tab+((Linea)instrucciones.elementoEn(i)).getFormaCodigo()+"\n";			 
			}else if(instrucciones.elementoEn(i) instanceof Instruccion){
				codigo= codigo+tab+((Instruccion)instrucciones.elementoEn(i)).getNombre()+"{"+((Instruccion)instrucciones.elementoEn(i)).getFormaCodigo(profundidad+1)+"\n"+tab+"}";
			}
		}
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String string) {
		nombre = string;
	}

	/**
	 * @return
	 */
	public String getInformeErrores() {
		String erroress=informeErrores;
		for(int i=0; i<instrucciones.tamanio(); i++){
			if(instrucciones.elementoEn(i) instanceof Instruccion){
				erroress= ((Instruccion)instrucciones.elementoEn(i)).getInformeErrores();
			} 
		}
	
		return erroress;
	}

	/**
	 * @param string
	 */
	public void setInformeErrores(String string) {
		informeErrores = string;
	}

	public boolean ejecutar() {
		if(!ERROR)
		{
		
		for(int i=0; i<instrucciones.tamanio(); i++){
			if(i+1!=instrucciones.tamanio()){
				if(instrucciones.elementoEn(i) instanceof Linea){
					((Linea)instrucciones.elementoEn(i)).
						setSiguiente(instrucciones.elementoEn(i+1));
				}else if(instrucciones.elementoEn(i) instanceof Instruccion){
					((Instruccion)instrucciones.elementoEn(i)).
						setSiguiente(instrucciones.elementoEn(i+1));
				}	
			}else{
				if(instrucciones.elementoEn(i) instanceof Linea){
					((Linea)instrucciones.elementoEn(i)).
						setSiguiente(this);
					((Linea)instrucciones.elementoEn(i)).
						setUltimaLinea(true);
				}else if(instrucciones.elementoEn(i) instanceof Instruccion){
					((Instruccion)instrucciones.elementoEn(i)).
						setSiguiente(this);
					((Instruccion)instrucciones.elementoEn(i)).
						setUltimaInstruccion(true);
				}
			}
		}
		
		if(instrucciones.tamanio()>0){
			if(instrucciones.elementoEn(0) instanceof Linea){
				if(instrucciones.elementoEn(0) instanceof FuncionSistema)
					((FuncionSistema)instrucciones.elementoEn(0)).setConsola(consola);
				((Linea)instrucciones.elementoEn(0)).ejecutar();
			}else if(instrucciones.elementoEn(0) instanceof Instruccion){
				((Instruccion)instrucciones.elementoEn(0)).ejecutar();
			}
		}
		}
		return ERROR;
	}
	


	public boolean isERROR() {
		return ERROR;
	}

	public void setERROR(boolean b) {
		ERROR = b;
	}


	public boolean isEjecutada() {
		return ejecutada;
	}

	public void setEjecutada(boolean b) {
		ejecutada = b;
		if(b){
			if(siguiente instanceof Instruccion){
				if(ultimaInstruccion)
					((Instruccion)siguiente).setEjecutada(true);
				else	
					((Instruccion)siguiente).ejecutar(); 
			} 
			else if(siguiente instanceof Linea){
				if(siguiente instanceof FuncionSistema)
					((FuncionSistema)siguiente).setConsola(consola);
				((Linea)siguiente).ejecutar(); 
			} else if(siguiente ==null)
			{
				consola.getConsola().getConsola().setText(
				consola.getConsola().getConsola().getText()+
				"\n<<Programa Finalizado>>");
			}
			
		}
	}

	public Object getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Object object) {
		siguiente = object;
	}
	public void setConsola(FuncionCompilador consola){
		this.consola=consola;
		for(int i=0; i<instrucciones.tamanio(); i++){
			if(instrucciones.elementoEn(i) instanceof Linea)
				((Linea)instrucciones.elementoEn(i)).setConsola(consola);
			else if(instrucciones.elementoEn(i) instanceof Instruccion)
				((Instruccion)instrucciones.elementoEn(i)).setConsola(consola);
		}
	}

	/**
	 * @return
	 */
	public boolean isUltimaInstruccion() {
		return ultimaInstruccion;
	}

	/**
	 * @param b
	 */
	public void setUltimaInstruccion(boolean b) {
		ultimaInstruccion = b;
	}

}
