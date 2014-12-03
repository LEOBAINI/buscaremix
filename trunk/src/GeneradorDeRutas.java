import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import Base.metodosSql;


public class GeneradorDeRutas implements Runnable{
	JProgressBar bar;
	int cantidadConsultas;
	ArrayList<String>chasis;
	ArrayList<String>rutas;
	JTextArea area;
	
	public ArrayList<String> getRutas() {
		return rutas;
	}

	public GeneradorDeRutas(JProgressBar bar,ArrayList<String>chasis, JTextArea area){
		this.bar=bar;
		this.chasis=chasis;
		this.area=area;
	}
	
	
		
	

	@Override
	public void run() {
		
		ArrayList<String>rutas=new ArrayList<String>();
		String sentenciaSql="select concat('C:/Documents and Settings/idmartin/Escritorio/Documentos Digitalizados/',numcaja,'/',sobre,barcode)" +
		" as 'Ruta a buscar' from flexibar.archivo where barcode=";
		metodosSql metodos=new metodosSql();
		int totalRegistros=chasis.size();
		 bar.setStringPainted(true);
		 bar.setMaximum(chasis.size()-1);		 
		 bar.setBackground(Color.white);
		 bar.setBorderPainted(true);
		 bar.setBackground(Color.white);
		 LineBorder thickBorder = new LineBorder(Color.green,2);
		 bar.setForeground(Color.BLACK);			
		 bar.setBorder(thickBorder);
		 
		 String log;
		 for(int x=0;x<totalRegistros;x++){			
			log=sentenciaSql+"'"+chasis.get(x)+"';";
			rutas.add(metodos.consultaSimple(log));
			area.append(rutas.get(x)+"\n");
			bar.setValue(x);
		 }
		
		 for(int i=0;i<rutas.size();i++){
			 System.out.println("Direccion es "+rutas.get(i));
			 
		 }

		
		
		
	}
	
	

}
