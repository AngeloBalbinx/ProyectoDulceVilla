package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloHora;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("unused")
public class FrmPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnSistema;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmTortas;
	private JMenuItem mntmClientes;
	private JMenu mnReporte;
	private JMenuItem mntmTortasActuales;
	private JMenuItem mntmTortasPorTipo;
	private JMenuItem mntmClientesActuales;
	private JDesktopPane escritorio;
	public static JLabel lblHora;
	private JLabel lblHoraActual;
	private JMenu mnVentas;
	private JMenuItem mntmGenerarVenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		try {
		//Seleecionar el dise�o a trabajar
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
		setTitle("Bienvenido " + Logueo.usuario.getNombre() + " " + Logueo.usuario.getApellido());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 360);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSistema = new JMenu("Sistema");
		mnSistema.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/3671748_computer_desktop_icon.png")));
		menuBar.add(mnSistema);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmSalir.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/1564506_close_exit_logout_power_icon.png")));
		mnSistema.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/2639855_maintenance_icon.png")));
		menuBar.add(mnMantenimiento);
		
		mntmTortas = new JMenuItem("Tortas");
		mntmTortas.addActionListener(this);
		mntmTortas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/5727004_birthday_cake_celebration_gift_party_icon.png")));
		mnMantenimiento.add(mntmTortas);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mntmClientes.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/1564534_customer_man_user_account_profile_icon.png")));
		mnMantenimiento.add(mntmClientes);
		
		mnVentas = new JMenu("Ventas");
		mnVentas.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/290141_bag_case_handbag_purse_shopping_icon.png")));
		menuBar.add(mnVentas);
		
		mntmGenerarVenta = new JMenuItem("Generar Venta");
		mntmGenerarVenta.addActionListener(this);
		mntmGenerarVenta.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/290145_label_price_sale_shopping_tag_icon.png")));
		mnVentas.add(mntmGenerarVenta);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/img/2931174_clipboard_copy_paste_analysis_report_icon.png")));
		menuBar.add(mnReporte);
		
		mntmTortasActuales = new JMenuItem("Tortas Actuales");
		mntmTortasActuales.addActionListener(this);
		mnReporte.add(mntmTortasActuales);
		
		mntmTortasPorTipo = new JMenuItem("Tortas por tipo");
		mntmTortasPorTipo.addActionListener(this);
		mnReporte.add(mntmTortasPorTipo);
		
		mntmClientesActuales = new JMenuItem("Clientes Actuales");
		mntmClientesActuales.addActionListener(this);
		mnReporte.add(mntmClientesActuales);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(SystemColor.activeCaption);
		contentPane.add(escritorio, BorderLayout.CENTER);
		setExtendedState(MAXIMIZED_BOTH);
		
		lblHora = new JLabel("00:00:00");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblHora.setForeground(Color.WHITE);
		lblHora.setBounds(150, 13, 98, 31);
		escritorio.add(lblHora);
		
		lblHoraActual = new JLabel("Hora Actual:");
		lblHoraActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraActual.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		lblHoraActual.setForeground(Color.WHITE);
		lblHoraActual.setBounds(10, 21, 130, 14);
		escritorio.add(lblHoraActual);
		mostrarHora();
	}
	private void mostrarHora(){
	  // Llamar al proceso
		HiloHora hora = new HiloHora();
	  // Ejecutar el proceso
		hora.start();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmGenerarVenta) {
			actionPerformedMntmGenerarVenta(e);
		}
		if (e.getSource() == mntmClientesActuales) {
			actionPerformedMntmClientesActuales(e);
		}
		if (e.getSource() == mntmClientes) {
			actionPerformedMntmClientes(e);
		}
		if (e.getSource() == mntmTortasPorTipo) {
			actionPerformedMntmTortasPorTipo(e);
		}
		if (e.getSource() == mntmTortasActuales) {
			actionPerformedMntmTortasActuales(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
		if (e.getSource() == mntmTortas) {
			actionPerformedMntmTortas(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedMntmTortas(ActionEvent e) {
		FrmMantenimientoTorta dmto = new FrmMantenimientoTorta();
		dmto.setVisible(true);
		escritorio.add(dmto);
	}
	protected void actionPerformedMntmTortasActuales(ActionEvent e) {
		FrmReporteTortasActuales drta = new FrmReporteTortasActuales();
		drta.setVisible(true);
		escritorio.add(drta);
	}
	protected void actionPerformedMntmTortasPorTipo(ActionEvent e) {
		FrmReporteTortasxTipo drtt = new FrmReporteTortasxTipo();
		drtt.setVisible(true);
		escritorio.add(drtt);
	}
	protected void actionPerformedMntmClientes(ActionEvent e) {
		FrmMantenimientoCliente mtoc = new FrmMantenimientoCliente();
		mtoc.setVisible(true);
		escritorio.add(mtoc);
	}
	protected void actionPerformedMntmClientesActuales(ActionEvent e) {
		FrmReporteClientesActuales rca = new FrmReporteClientesActuales();
		rca.setVisible(true);
		escritorio.add(rca);
	}
	protected void actionPerformedMntmGenerarVenta(ActionEvent e) {
		FrmCDP cdp = new FrmCDP();
		cdp.setVisible(true);
		escritorio.add(cdp);
	}
}
