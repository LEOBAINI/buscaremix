import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Border;
import jxl.read.biff.BiffException;


public class LectorExcel implements Runnable{
	JProgressBar bar;
	JProgressBar barQuery;
	JTextArea area;
	String ruta;
	int columna=0;
	public LectorExcel(JTextArea area,JProgressBar bar,JProgressBar barQuery,String ruta,int columna){
		this.bar=bar;
		this.area=area;
		this.ruta=ruta;
		this.columna=columna;
		this.barQuery=barQuery;
	}

	@Override
	public void run() {
		
			Workbook workbook = null;
			try {
				workbook = Workbook.getWorkbook(new File(ruta));
			} catch (BiffException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
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
			
			 area.setText("");
			 Runnable gene=new GeneradorDeRutas(barQuery, contenido,area);				
				new Thread(gene).start();//.start();
			 
			

		
		
	}
	}


