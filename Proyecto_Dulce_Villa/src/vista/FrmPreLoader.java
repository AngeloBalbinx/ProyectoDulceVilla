package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.concurrent.PriorityBlockingQueue;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;

import hilos.HiloBarraProgreso;

import javax.swing.event.ChangeEvent;

@SuppressWarnings("unused")
public class FrmPreLoader extends JFrame implements ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label;
	private JLabel lblNewLabel;
	public static JProgressBar prbCarga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPreLoader frame = new FrmPreLoader();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPreLoader() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("El sistema est\u00E1 cargando, espere unos segundos");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(0, 11, 283, 14);
		contentPane.add(label);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmPreLoader.class.getResource("/img/cargando.gif")));
		lblNewLabel.setBounds(0, 61, 283, 167);
		contentPane.add(lblNewLabel);
		
		prbCarga = new JProgressBar();
		prbCarga.setForeground(new Color(0, 250, 154));
		prbCarga.addChangeListener(this);
		prbCarga.setStringPainted(true);
		prbCarga.setBounds(0, 36, 283, 23);
		contentPane.add(prbCarga);
		// cargar la barra de progreso
		iniciarBarraProgreso();
		

	}
	private void iniciarBarraProgreso() {
		HiloBarraProgreso h = new HiloBarraProgreso();
		h.start();
		}
		
	

	public void stateChanged(ChangeEvent arg0) {
		if (arg0.getSource() == prbCarga) {
			stateChangedPrbCarga(arg0);
		}
	}
	protected void stateChangedPrbCarga(ChangeEvent arg0) {
		if(prbCarga.getValue() == 100) {
			FrmPrincipal prin = new FrmPrincipal();
			prin.setVisible(true);
			prin.setLocationRelativeTo(this);
			this.dispose();
	}
	}
}
