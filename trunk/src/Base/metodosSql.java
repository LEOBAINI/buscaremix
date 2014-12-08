package Base;



import java.awt.Choice;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
/*import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;*/

import java.util.Date;

import java.util.Locale;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;






@SuppressWarnings("unused")
public class metodosSql extends ConexionMySql {
	
	
	
	public metodosSql() {
	}
	
	public String consultaSimple(String SentenciaSql) {
		ResultSet res =null;
		String resultado=null;
		
		
		ConexionMySql con = new ConexionMySql();
		System.out.println(SentenciaSql);
		
		
		try {
			con.conectar();
			con.resulsete=con.statemente.executeQuery(SentenciaSql);
			res = con.resulsete;
			
			
			
			 
	            while ( res.next()){
	            	
	               resultado=res.getString(1);
	            }
	        con.desconectar();

			

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println("Error en metodosSql.consultarUnaColumna"+e.getMessage());
			
		}

		return resultado;
		

	}

}
