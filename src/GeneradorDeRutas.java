import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import Base.metodosSql;


public class GeneradorDeRutas {
	JProgressBar bar;
	int cantidadConsultas;
	ArrayList<String>chasis;
	ArrayList<String>rutas;
	JTextArea area;
	String rutaOrigen;
	
	public ArrayList<String> getRutas() {
		return rutas;
	}

	public GeneradorDeRutas(JProgressBar bar,String rutaOrigen, ArrayList<String>chasis, JTextArea area){
		this.bar=bar;
		this.chasis=chasis;
		this.area=area;
		this.rutaOrigen=rutaOrigen;
	}
	
	
		
	
/**
 * Entrega la ruta al archivo/s sacado del sql, pero sin la extension
 * @return
 */

	public ArrayList<String>entregarRutas() {
		
		ArrayList<String>rutas=new ArrayList<String>();
		rutaOrigen=rutaOrigen.replace('\\', '/');
		String sentenciaSql="select concat ('"+rutaOrigen+"/',numcaja,if(sobre is null,'/',concat('/',sobre,'/')),barcode)" +
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
		 String ruta=null;
		 int indiceRutas=0;
		 for(int x=0;x<totalRegistros;x++){			
			log=sentenciaSql+"'"+chasis.get(x)+"';";
			ruta=metodos.consultaSimple(log);
			if(ruta!=null){
			ruta.replaceAll("/null","");
			rutas.add(ruta);
			
						
			area.append(rutas.get(indiceRutas)+"\n");
			indiceRutas++;
			}
			bar.setValue(x);
		 }
		

		return rutas;

		
		
		
	}
	
	

}
