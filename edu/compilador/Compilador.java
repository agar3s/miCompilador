/*
 * Creado el 14-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.compilador;


import edu.compilador.identificador.Identificador;
import edu.compilador.identificador.lineas.IdentificadorDeclaracion;
import edu.compilador.identificador.sentencia.IdentificadorReservada;
import edu.compilador.instrucciones.Defecto;
import edu.compilador.instrucciones.Instruccion;
import edu.compilador.lineas.Linea;
import edu.compilador.sentencias.Sentencia;
import edu.recurso.lista.Lista;

/**Codigo.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/

/*
 * Esta clase se encarga de descomponer y examinar el codigo
 */
public class Compilador {
	private Identificador identificador;
	private int contadorLineas;
	//aqui esta el usuario
	private Instruccion instruccion;
	
	public Compilador(Instruccion instruccion){
		contadorLineas=1;
		this.instruccion= instruccion;
		
	}
	
	public void enviarLinea(String linea){
		Lista fragmentos=descomponerLinea(linea);

		identificador= new IdentificadorDeclaracion(instruccion);
		Linea nueva= ((IdentificadorDeclaracion)identificador).
				identificarCode(fragmentos);
		nueva.setLinea(contadorLineas);
		instruccion.getInstrucciones().add(nueva);
		contadorLineas++;
	}
	public Lista descomponerLinea(String codeLinea){
		Lista sentencias= new Lista();
		String temp= "";
		for(int i=0; i<codeLinea.length(); i++){
			if(codeLinea.charAt(i)==' '){
				if(temp!="")
					sentencias.add(temp);	
				temp= "";
			}else{
				if(i+1!=codeLinea.length()){
				
					if(identificarSeparador(codeLinea.charAt(i),codeLinea.charAt(i+1))!=null){
						
						if(temp!="")
							sentencias.add(temp);
							
						temp="";
						sentencias.add(identificarSeparador(codeLinea.charAt(i),codeLinea.charAt(i+1)));
						
						if(identificarSeparador(codeLinea.charAt(i),codeLinea.charAt(i+1)).length()==2)
							i++;
					}else{
						temp= temp + codeLinea.charAt(i);
					}
				}else{
					if(identificarSeparador(codeLinea.charAt(i),' ')!=null){
						if(temp!="")
							sentencias.add(temp);
						
						temp="";
						sentencias.add(identificarSeparador(codeLinea.charAt(i),' '));

					}else{
						temp= temp + codeLinea.charAt(i);
						if(i+1==codeLinea.length())
							sentencias.add(temp);
						
					}
				}
			}
		}
					

		Lista sentences = new Lista();
		identificador= new IdentificadorReservada(instruccion);
		for(int i=0; i<sentencias.tamanio(); i++){

			Sentencia sentencia= (Sentencia) 
				((IdentificadorReservada)identificador).
					identificarCode((String)sentencias.elementoEn(i));
			sentences.add(sentencia);
		}
		
		return sentences;
	}
	
	public void enviarInstruccion(String nombre, String codigo){
		
		Instruccion defecto= new Defecto(instruccion,new Lista(),nombre);
		Lector lector= new Lector(defecto);
		Compilador temp= new Compilador(defecto);
		contadorLineas++;
		temp.setInstruccion(lector.decodificar(codigo,contadorLineas));
		defecto.setInstrucciones(temp.getInstrucciones());
		//esta instruccion se debe identificar
		instruccion.getInstrucciones().add(defecto);
		contadorLineas=contadorLineas+defecto.getInstrucciones().tamanio()+1;
		
	}

	
	private String identificarSeparador( char s, char r){
		String nueva= null;
		if(	(s=='&'&&r=='&')||(s=='|'&&r=='|')||(s=='='&&r=='=')||
			(s=='>'&&r=='=')||(s=='<'&&r=='=')||(s=='!'&&r=='=')||
			(s=='<'&&r=='-'))	
				nueva=""+s+r;
			
		else if((s=='>')||(s=='<')||(s=='!')||(s=='+')||(s=='+')||
				(s=='-')||(s=='*')||(s=='/')||(s=='%')||(s=='=')||
				(s==',')||(s=='.')||(s=='(')||(s==')')||(s=='[')||
				(s==']')||(s=='\'')||(s=='"')||(s=='\''))
				nueva=""+s;
		return nueva;
	}
	
	//test metodo
	public int resumir(){

		return instruccion.mostrarErrores();
	}	
	public int getContadorLineas() {
		return contadorLineas;
	}

	public void setContadorLineas(int i) {
		contadorLineas = i;
	}

	public Lista getInstrucciones() {
		return instruccion.getInstrucciones();
	}

	public Instruccion getInstruccion() {
		return instruccion;
	}
	public void setInstruccion(Instruccion instruccion) {
		this.instruccion = instruccion;
	}

}
