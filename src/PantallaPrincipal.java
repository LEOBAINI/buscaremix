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
	private JLabel jLabelCantFilasTotal = null;
	private JTextField jTextFieldFilasTotales = null;
	private JLabel jLabelFilasLeidas = null;
	private JTextField jTextFieldFilasLeidas = null;
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
		
			jLabelColumnaAleer = new JLabel();
			jLabelColumnaAleer.setBounds(new Rectangle(1001, 334, 91, 22));
			jLabelColumnaAleer.setText("Columna a leer");
			jLabelColumnaAleer.setForeground(Color.white);
			jContentPane = new FondoPpal();
			jContentPane.setLayout(null);
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(11, 192, 235, 18));
			jLabel3.setText("Progreso de copia de datos");
			jLabel3.setForeground(Color.white);
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(11, 127, 235, 19));
			jLabel2.setText("Progreso de busqueda en base de datos");
			jLabel2.setForeground(Color.white);
			jLabel1 = new JLabel();
			jLabel1.setForeground(Color.white);
			jLabel1.setBounds(new Rectangle(11, 61, 191, 20));
			jLabel1.setText("Progreso de archivo leido");
			jLabelVisor = new JLabel();
			jLabelVisor.setBounds(new Rectangle(432, 35, 113, 20));
			jLabelVisor.setForeground(Color.white);
			jLabelVisor.setText("Visor de sucesos");
			jLabelFilasLeidas = new JLabel();
			jLabelFilasLeidas.setBounds(new Rectangle(1001, 305, 77, 20));
			jLabelFilasLeidas.setText("Filas leidas");
			jLabelFilasLeidas.setForeground(Color.white);
			jLabelCantFilasTotal = new JLabel();
			jLabelCantFilasTotal.setBounds(new Rectangle(1001, 278, 77, 18));
			jLabelCantFilasTotal.setText("Filas totales");
			jLabelCantFilasTotal.setForeground(Color.white);
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(13, 13, 244, 16));
			jLabel.setText("Seleccione archivo de Excel (XLS) a leer");
			jLabel.setForeground(Color.white);
			
			
			
			
			
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButtonExaminar(), null);
			jContentPane.add(getJTextFieldRuta(), null);
			jContentPane.add(getJButtonProcesar(), null);
			jContentPane.add(jLabelCantFilasTotal, null);
			jContentPane.add(getJTextFieldFilasTotales(), null);
			jContentPane.add(jLabelFilasLeidas, null);
			jContentPane.add(getJTextFieldFilasLeidas(), null);
			jContentPane.add(jLabelVisor, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(getJProgressBar(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJProgressBarBase(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(getJProgressBarDatos(), null);
			jContentPane.add(getJTextFieldColumnaAleer(), null);
			jContentPane.add(jLabelColumnaAleer, null);
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
			jButtonExaminar.setBounds(new Rectangle(15, 275, 231, 46));
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
			jTextFieldRuta.setBounds(new Rectangle(264, 11, 659, 20));
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
			jButtonProcesar.setBounds(new Rectangle(15, 350, 231, 46));
			jButtonProcesar.setText("Procesar");
			jButtonProcesar.setBackground(new Color(159));
			jButtonProcesar.setForeground(Color.white);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jButtonProcesar.setBorder(thickBorder);
			jButtonProcesar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				jTextAreaLog.setText("");
				
				int columna=Integer.parseInt(jTextFieldColumnaAleer.getText());
				Runnable lector=new LectorExcel(jTextAreaLog,jProgressBar,jProgressBarBase,jTextFieldRuta.getText(),columna);				
				new Thread(lector).start();//.start();
				}
			});
		}
		return jButtonProcesar;
	}

	/**
	 * This method initializes jTextFieldFilasTotales	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldFilasTotales() {
		if (jTextFieldFilasTotales == null) {
			jTextFieldFilasTotales = new JTextField();
			jTextFieldFilasTotales.setBounds(new Rectangle(1102, 306, 98, 20));
			jTextFieldFilasTotales.setBackground(Color.white);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jTextFieldFilasTotales.setBorder(thickBorder);
		
			
		}
		return jTextFieldFilasTotales;
	}

	/**
	 * This method initializes jTextFieldFilasLeidas	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldFilasLeidas() {
		if (jTextFieldFilasLeidas == null) {
			jTextFieldFilasLeidas = new JTextField();
			jTextFieldFilasLeidas.setBounds(new Rectangle(1102, 277, 98, 20));
			jTextFieldFilasLeidas.setBackground(Color.white);
			LineBorder thickBorder = new LineBorder(Color.green,2);
			jTextFieldFilasLeidas.setBorder(thickBorder);
			
		}
		return jTextFieldFilasLeidas;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(433, 59, 770, 189));
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
			jProgressBar.setBounds(new Rectangle(11, 92, 409, 24));
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
			jProgressBarBase.setBounds(new Rectangle(11, 157, 409, 24));
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
			jProgressBarDatos.setBounds(new Rectangle(11, 221, 409, 24));
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
			jTextFieldColumnaAleer.setBounds(new Rectangle(1102, 335, 98, 20));
			jTextFieldColumnaAleer.setBorder(new LineBorder(Color.green, 2));
			jTextFieldColumnaAleer.setText("0");
			jTextFieldColumnaAleer.setBackground(Color.white);
		}
		return jTextFieldColumnaAleer;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
