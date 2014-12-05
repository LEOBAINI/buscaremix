import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Base.metodosSql;



import jxl.*;
import jxl.read.biff.BiffException;
public class Principal {


	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public static void main(String[] args) throws BiffException, IOException {
		
		PantallaPrincipal pantalla=new PantallaPrincipal();
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PantallaPrincipal.setDefaultLookAndFeelDecorated(true);
		pantalla.setLocationRelativeTo(null);
		URL urlDeLaImagen = Principal.class.getClassLoader().getResource("Imagenes/F_DE_FURLONG.png");
		ImageIcon icon = new ImageIcon(urlDeLaImagen);
		pantalla.setIconImage(icon.getImage());
		pantalla.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pantalla.setVisible(true);
		
		
		/*InicializadorDirectorios ini=new InicializadorDirectorios();
		//System.out.println(ini.existeFichero());
		File fichero = new File("H:\\Documentos Digitalizados\\1000\\02\\0000000B7DB481800");
		String a=fichero.getAbsolutePath();
		String b=fichero.getParent();
		System.out.println(ini.darExtension(a,b));
		
		//String h="H:\\DocumentosFiltrados\\jo";
	//	System.out.println(h.substring(0,h.lastIndexOf("\\")));
	 * 
*/		
		
	
	
	
	}

}
