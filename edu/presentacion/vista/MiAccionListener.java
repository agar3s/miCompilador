/*
 * Creado el 25-may-2005
 *
 * Para cambiar la plantilla para este archivo generado vaya a
 * Ventana&gt;Preferencias&gt;Java&gt;Generación de código&gt;Código y comentarios
 */
package edu.presentacion.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;

import edu.compilador.CodigoFuente;

/**MiAccionListener.java
 * @author  Agares (Giovanny Beltrán)
 * ekeisco@gmail.com
 **/
public class MiAccionListener implements ActionListener{
	
	private static final String NUEVO="NEW";
	private static final String ABRIR="OPEN";
	private static final String GUARDAR="SAVE";
	private static final String COMPILAR="COMPILE";
	private static final String GUARDARAS= "SAVEAS";
	private static final String EJECUTAR= "EXECUTE";
	
	private EntornoTrabajo entorno;
	
	public MiAccionListener(EntornoTrabajo entorno){
		this.entorno= entorno;
	}

	public static String abrir(File file){
		String codigo="";
		try {
			DataInputStream in5 =
				new DataInputStream(
					new BufferedInputStream(
						new FileInputStream(file)));
			
			String s=in5.readLine();
			codigo=s+"\n";
			while(s!=null){
				s=in5.readLine();
				if(s!=null)
				codigo= codigo+s+"\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return codigo;
	}
	
	public static void guardar(File file, String codigo){
		DataOutputStream out2;
		try {
			out2 =
				new DataOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(file)));
			out2.writeBytes(codigo);
			out2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent ae) {
		String s= ae.getActionCommand();
		if(s.compareTo(ABRIR)==0){
		
			JFileChooser choser= new JFileChooser();
			choser.setDialogTitle("Abrir:");
			choser.setApproveButtonText("Abrir");
			choser.showOpenDialog(entorno);
		
			if(entorno.getFile()!=null)
				choser.setCurrentDirectory(entorno.getFile());
			
			File file=choser.getSelectedFile();
			
			if(file!=null){	
				entorno.getEditor().setText(abrir(file));
				entorno.setCodigo(new CodigoFuente(entorno.getEditor().getText()));
				entorno.setFile(file);
			}
		
		}else if(s.compareTo(COMPILAR)==0){
			if(entorno.getCodigo()!=null)
			{
				entorno.getCodigo().decodificar();

				String temp=""+entorno.getCodigo().reporte();
				if(entorno.getCodigo().reporte()==1){
					temp= temp+" error encontrado;";
				}
				else
					temp=temp+"errores encontrados";
				temp= temp+	entorno.getCodigo().getInstruccion().getInformeErrores();
				
				entorno.getCompilador().setText(temp);

				guardar(entorno.getFile(),entorno.getEditor().getText());
			} 
		}else if(s.compareTo(NUEVO)==0){
			
		}else if(s.compareTo(GUARDARAS)==0){
			
			JFileChooser choser;
			if(entorno.getFile()!=null){
				choser= new JFileChooser(entorno.getFile());	
			}else
				choser= new JFileChooser();
			
			choser.setDialogTitle("Guardar:");
			choser.setApproveButtonText("Guardar");
			choser.showOpenDialog(entorno);
			File file = choser.getSelectedFile();
			if(file!=null){
				guardar(file,entorno.getEditor().getText()); 
				entorno.setCodigo(new CodigoFuente(entorno.getEditor().getText()));
				entorno.setFile(file);
			} 
		}else if(s.compareTo(GUARDAR)==0){
			if(entorno.getFile()!=null){	
				guardar(entorno.getFile(),entorno.getEditor().getText());
				entorno.setCodigo(new CodigoFuente(entorno.getEditor().getText()));
			} 
		}else if(s.compareTo(EJECUTAR)==0){
			boolean b=entorno.getCodigo().ejecutar();
			if(b){
				entorno.getCompilador().setText("No se puede ejecutar con errores.");
			}
		}
	}

	public static String ABRIR() {
		return ABRIR;
	}

	public static String COMPILAR() {
		return COMPILAR;
	}

	public static String GUARDAR() {
		return GUARDAR;
	}

	public static String NUEVO() {
		return NUEVO;
	}

	public EntornoTrabajo getEntorno() {
		return entorno;
	}

	public void setEntorno(EntornoTrabajo trabajo) {
		entorno = trabajo;
	}

	public static String GUARDARAS() {
		return GUARDARAS;
	}

	/**
	 * @return
	 */
	public static String EJECUTAR() {
		return EJECUTAR;
	}

}
