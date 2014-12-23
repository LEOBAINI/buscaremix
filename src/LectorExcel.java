import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class LectorExcel implements Runnable{
	JProgressBar barCopia;
	JProgressBar bar;
	JProgressBar barQuery;
	JTextArea area;
	String ruta;
	String rutaOrigen;
	String rutaDestino;
	JButton buttonExaminar;
	JButton buttonProcesar;
	int columna=0;
	public LectorExcel(JTextArea area,JProgressBar bar,JProgressBar barQuery,JProgressBar barCopia,String ruta,String rutaOrigen, String rutaDestino, JButton buttonExaminar, JButton buttonProcesar, int columna){
		this.bar=bar;
		this.area=area;
		this.ruta=ruta;
		this.columna=columna;
		this.barQuery=barQuery;
		this.barCopia=barCopia;
		this.buttonExaminar=buttonExaminar;
		this.buttonProcesar=buttonProcesar;
		this.rutaOrigen=rutaOrigen;
		this.rutaDestino=rutaDestino;
	}

	public void habilitarBotones(){
		this.buttonExaminar.setEnabled(true);
		this.buttonProcesar.setEnabled(true);
	}
	public void run() {
		
			Workbook workbook = null;
			try {
				workbook = Workbook.getWorkbook(new File(ruta));
			} catch (BiffException e) {
				
				JOptionPane.showMessageDialog(null, e.getMessage());
				habilitarBotones();
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				habilitarBotones();
				e.printStackTrace();
			} 
			ArrayList<String>contenido=new ArrayList<String>();
			Sheet sheet = workbook.getSheet(0);
			
			
			 for(int i=0;i<sheet.getRows();i++){
				contenido.add(sheet.getCell(columna,i).getContents()) ;
			
			 }
			 bar.setStringPainted(true);
			 bar.setMaximum(sheet.getRows()-1);
			 bar.setBackground(Color.white);
			// bar.setForeground(Color.GREEN.brighter());
			 bar.setBorderPainted(true);			 
			 area.setAutoscrolls(true);
			 
			 
			 for(int x=0;x<contenido.size();x++){
				 area.append("LEYENDO\t\t"+contenido.get(x)+"\n");
				 
				 bar.setValue(x);
				
				 
				// System.out.println(contenido.get(x));
			 }
			 area.append("SE LEYERON \t\t"+contenido.size()+"FILAS");
			 
			 // Hasta acá leyo el excel
			
			 
			 rutaDestino=rutaDestino.replace('\\', '/');
			 
		GeneradorDeRutas gene=new GeneradorDeRutas(barQuery,rutaOrigen,rutaDestino, contenido,area);		
		ArrayList<String>rutasArchivos=null;
		rutasArchivos=gene.entregarRutas(area);// Obtiene las rutas del SQL de los archivos pero sin la extensión
		
		ArrayList<String>rutasCompletas=new ArrayList<String>();
		InicializadorDirectorios ini=new InicializadorDirectorios();
		
		String extension=null;
		String rutaalaCarpeta=null;
		EscribirArchivo log=new EscribirArchivo();
		for(int i=0;i<rutasArchivos.size();i++){
			try{
			rutaalaCarpeta=rutasArchivos.get(i).substring(0,rutasArchivos.get(i).lastIndexOf("/"));// El directorio donde está el archivo
			
			extension=ini.darExtension(rutasArchivos.get(i), rutaalaCarpeta);// obtiene la extension del archivo
			if(extension!=null){
			rutasCompletas.add(rutasArchivos.get(i)+extension);// carga la ruta completa al archivo
			}else{
				log.escribirContinuacionUnaLinea(rutaDestino+"\\logNoOk.txt","No copiado "+rutasArchivos.get(i).substring(rutasArchivos.get(i).lastIndexOf("/")+1)+"\t porque el archivo no se encuentra en "+rutaalaCarpeta);
			}
			
			}catch(Exception e){
				
				log.escribirContinuacionUnaLinea(rutaDestino+"\\logNoOk.txt","No copiado "+rutasArchivos.get(i).substring(rutasArchivos.get(i).lastIndexOf("/")+1)+"\t porque el archivo no se encuentra en "+rutaalaCarpeta);
			}
			
			}
		
		ini.copiarArchivosAruta(rutasCompletas,rutaDestino, barCopia, area);//rutadestino no debe terminar con "/"
		if(	barCopia.getValue()==barCopia.getMaximum()){
		JOptionPane.showMessageDialog(null,"Proceso finalizado.\nPara más detalles, vea el LOG en su Carpeta de Destino.");
		}else{
		JOptionPane.showMessageDialog(null,"Proceso finalizado con errores.\nPara más detalles, vea el LOG en su Carpeta de Destino.");	
		}
		habilitarBotones();
		try{
			ini.abrirDirectorio(rutaDestino.replace('/','\\'));
		}catch(Exception e){
			
		}
		
		

		
		
	}
	}


