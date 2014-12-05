import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorChooserUI;
import javax.swing.text.DefaultCaret;

import jxl.write.Border;


public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JButton jButtonExaminar = null;
	private JTextField jTextFieldRuta = null;
	private JButton jButtonProcesar = null;
	private JLabel jLabelVisor = null;
	private JScrollPane jScrollPane = null;
	private JTextArea jTextAreaLog = null;
	private JProgressBar jProgressBar = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JProgressBar jProgressBarBase = null;
	private JLabel jLabel3 = null;
	private JProgressBar jProgressBarDatos = null;
	private JTextField jTextFieldColumnaAleer = null;
	private JLabel jLabelColumnaAleer = null;
	private JLabel jLabel4 = null;
	private JButton jButtonOrigen = null;
	private JTextField jTextFieldRutaOrigen = null;
	private JLabel jLabel41 = null;
	private JButton jButtonDestino = null;
	private JTextField jTextFieldRutaDestino = null;
	/**
	 * This is the default constructor
	 */
	public PantallaPrincipal() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(1242, 529);
		
		this.setContentPane(getJContentPane());
		this.setTitle("Buscador de remitos");
		//this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Camiones.jpg")));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
		
			jLabel41 = new JLabel();
			jLabel41.setBounds(new Rectangle(11, 56, 221, 17));
			jLabel41.setText("Seleccione Carpeta de DESTINO");
			jLabel41.setForeground(Color.white);
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(12, 35, 229, 19));
			jLabel4.setText("Seleccione Carpeta de ORIGEN");
			jLabel4.setForeground(Color.white);
			jLabelColumnaAleer = new JLabel();
			jLabelColumnaAleer.setBounds(new Rectangle(12, 128, 91, 22));
			jLabelColumnaAleer.setText("Columna a leer");
			jLabelColumnaAleer.setForeground(Color.white);
			jContentPane = new FondoPpal();
			jContentPane.setLayout(null);
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(12, 284, 235, 18));
			jLabel3.setText("Progreso de copia de datos");
			jLabel3.setForeground(Color.white);
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(12, 219, 235, 19));
			jLabel2.setText("Progreso de busqueda en base de datos");
			jLabel2.setForeground(Color.white);
			jLabel1 = new JLabel();
			jLabel1.setForeground(Color.white);
			jLabel1.setBounds(new Rectangle(12, 153, 191, 20));
			jLabel1.setText("Progreso de archivo leido");
			jLabelVisor = new JLabel();
			jLabelVisor.setForeground(Color.white);
			jLabelVisor.setBounds(new Rectangle(446, 128, 113, 20));
			jLabelVisor.setText("Visor de sucesos");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(13, 13, 244, 16));
			jLabel.setText("Seleccione archivo de Excel (XLS) a leer");
			jLabel.setForeground(Color.white);
			
			
			
			
			
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButtonExaminar(), null);
			jContentPane.add(getJTextFieldRuta(), null);
			jContentPane.add(getJButtonProcesar(), null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJProgressBar(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJProgressBarBase(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getJProgressBarDatos(), null);
			jContentPane.add(getJTextFieldColumnaAleer(), null);
			jContentPane.add(jLabelColumnaAleer, null);
			jContentPane.add(jLabelVisor, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getJButtonOrigen(), null);
			jContentPane.add(getJTextFieldRutaOrigen(), null);
			jContentPane.add(jLabel41, null);
			jContentPane.add(getJButtonDestino(), null);
			jContentPane.add(getJTextFieldRutaDestino(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButtonExaminar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonExaminar() {
		if (jButtonExaminar == null) {
			jButtonExaminar = new JButton();
			jButtonExaminar.setBounds(new Rectangle(262, 10, 121, 23));
			jButtonExaminar.setText("Examinar");
			jButtonExaminar.setBorderPainted(true);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jButtonExaminar.setBorder(thickBorder);

			jButtonExaminar.setBackground(new Color(159));
			jButtonExaminar.setForeground(Color.white);
			jButtonExaminar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FileChooser file=new FileChooser();
					String ruta=file.lanzarSeleccion();
					jTextFieldRuta.setText(ruta);
				}
			});
		}
		return jButtonExaminar;
	}

	/**
	 * This method initializes jTextFieldRuta	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRuta() {
		if (jTextFieldRuta == null) {
			jTextFieldRuta = new JTextField();
			jTextFieldRuta.setBounds(new Rectangle(401, 11, 813, 20));
			jTextFieldRuta.setText("D:\\Desktop\\Caja1003bis.xls");
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jTextFieldRuta.setBorder(thickBorder);
			jTextFieldRuta.setBackground(Color.white);
		}
		return jTextFieldRuta;
	}

	/**
	 * This method initializes jButtonProcesar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonProcesar() {
		if (jButtonProcesar == null) {
			jButtonProcesar = new JButton();
			jButtonProcesar.setBounds(new Rectangle(11, 441, 231, 46));
			jButtonProcesar.setText("Procesar");
			jButtonProcesar.setBackground(new Color(159));
			jButtonProcesar.setForeground(Color.white);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jButtonProcesar.setBorder(thickBorder);
			jButtonProcesar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				jTextAreaLog.setText("");
				jButtonExaminar.setEnabled(false);
				jButtonProcesar.setEnabled(false);
				int columna=Integer.parseInt(jTextFieldColumnaAleer.getText());
				Runnable lector=new LectorExcel(jTextAreaLog,jProgressBar,jProgressBarBase,jProgressBarDatos,jTextFieldRuta.getText(),jTextFieldRutaOrigen.getText(),jTextFieldRutaDestino.getText(),jButtonExaminar,jButtonProcesar,columna);				
				new Thread(lector).start();//.start();
				

				}
			});
		}
		return jButtonProcesar;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(444, 157, 776, 328));
			jScrollPane.setViewportView(getJTextAreaLog());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextAreaLog	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextAreaLog() {
		if (jTextAreaLog == null) {
			jTextAreaLog = new JTextArea();
			DefaultCaret caret = (DefaultCaret)jTextAreaLog.getCaret();
			caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			
			jTextAreaLog.setBorder(thickBorder);
			jTextAreaLog.setBackground(Color.white);
		}
		return jTextAreaLog;
	}

	/**
	 * This method initializes jProgressBar	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBar() {
		if (jProgressBar == null) {
			jProgressBar = new JProgressBar();
			jProgressBar.setBounds(new Rectangle(12, 184, 409, 24));
			jProgressBar.setBackground(Color.white);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jProgressBar.setForeground(Color.BLACK);
			
			jProgressBar.setBorder(thickBorder);
		}
		return jProgressBar;
	}

	/**
	 * This method initializes jProgressBarBase	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBarBase() {
		if (jProgressBarBase == null) {
			jProgressBarBase = new JProgressBar();
			jProgressBarBase.setBounds(new Rectangle(12, 249, 409, 24));
			jProgressBarBase.setBackground(Color.white);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jProgressBarBase.setBorder(thickBorder);
		}
		return jProgressBarBase;
	}

	/**
	 * This method initializes jProgressBarDatos	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBarDatos() {
		if (jProgressBarDatos == null) {
			jProgressBarDatos = new JProgressBar();
			jProgressBarDatos.setBounds(new Rectangle(12, 313, 409, 24));
			jProgressBarDatos.setBackground(Color.white);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jProgressBarDatos.setBorder(thickBorder);
		}
		return jProgressBarDatos;
	}

	/**
	 * This method initializes jTextFieldColumnaAleer	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldColumnaAleer() {
		if (jTextFieldColumnaAleer == null) {
			jTextFieldColumnaAleer = new JTextField();
			jTextFieldColumnaAleer.setBounds(new Rectangle(113, 129, 98, 20));
			jTextFieldColumnaAleer.setBorder(new LineBorder(Color.green, 2));
			jTextFieldColumnaAleer.setText("0");
			jTextFieldColumnaAleer.setBackground(Color.white);
		}
		return jTextFieldColumnaAleer;
	}

	/**
	 * This method initializes jButtonOrigen	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonOrigen() {
		if (jButtonOrigen == null) {
			jButtonOrigen = new JButton();
			jButtonOrigen.setBounds(new Rectangle(262, 34, 120, 24));
			jButtonOrigen.setForeground(Color.white);
			jButtonOrigen.setBorder(new LineBorder(Color.green, 2));
			jButtonOrigen.setBorderPainted(true);
			jButtonOrigen.setText("Examinar");
			jButtonOrigen.setBackground(new Color(159));
			jButtonOrigen.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FileChooser file=new FileChooser();					
					String ruta=file.lanzarSeleccionDeCarpeta();
					jTextFieldRutaOrigen.setText(ruta);
				}
			});
		}
		return jButtonOrigen;
	}

	/**
	 * This method initializes jTextFieldRutaOrigen	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRutaOrigen() {
		if (jTextFieldRutaOrigen == null) {
			jTextFieldRutaOrigen = new JTextField();
			jTextFieldRutaOrigen.setBounds(new Rectangle(401, 34, 812, 21));
			jTextFieldRutaOrigen.setBorder(new LineBorder(Color.green, 2));
			jTextFieldRutaOrigen.setText("H:\\Documentos Digitalizados");
			jTextFieldRutaOrigen.setBackground(Color.white);
		}
		return jTextFieldRutaOrigen;
	}

	/**
	 * This method initializes jButtonDestino	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDestino() {
		if (jButtonDestino == null) {
			jButtonDestino = new JButton();
			jButtonDestino.setBounds(new Rectangle(262, 60, 120, 24));
			jButtonDestino.setForeground(Color.white);
			jButtonDestino.setBorder(new LineBorder(Color.green, 2));
			jButtonDestino.setBorderPainted(true);
			jButtonDestino.setText("Examinar");
			jButtonDestino.setBackground(new Color(159));
			jButtonDestino.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					FileChooser file=new FileChooser();					
					String ruta=file.lanzarSeleccionDeCarpeta();
					jTextFieldRutaDestino.setText(ruta);
				}
			});
		}
		return jButtonDestino;
	}

	/**
	 * This method initializes jTextFieldRutaDestino	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRutaDestino() {
		if (jTextFieldRutaDestino == null) {
			jTextFieldRutaDestino = new JTextField();
			jTextFieldRutaDestino.setBounds(new Rectangle(401, 57, 811, 25));
			jTextFieldRutaDestino.setBorder(new LineBorder(Color.green, 2));
			jTextFieldRutaDestino.setText("H:\\DocumentosFiltrados");
			jTextFieldRutaDestino.setBackground(Color.white);
		}
		return jTextFieldRutaDestino;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
