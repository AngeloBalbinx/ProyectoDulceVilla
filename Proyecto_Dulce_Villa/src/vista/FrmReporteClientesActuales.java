package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import entidad.Cliente;
import entidad.Torta;
import mantenimiento.GestionClienteDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class FrmReporteClientesActuales extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblReporteDeClientes;
	private JTable tbCliente;
	private JScrollPane scrollPane;
	private JButton btnReporte;
	DefaultTableModel model = new DefaultTableModel();
	GestionClienteDAO gCli = new GestionClienteDAO();
	private JButton btnReportePDF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteClientesActuales frame = new FrmReporteClientesActuales();
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
	public FrmReporteClientesActuales() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 673, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblReporteDeClientes = new JLabel("Reporte de clientes actuales");
		lblReporteDeClientes.setOpaque(true);
		lblReporteDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteDeClientes.setForeground(Color.WHITE);
		lblReporteDeClientes.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblReporteDeClientes.setBackground(Color.ORANGE);
		lblReporteDeClientes.setBounds(0, 0, 665, 31);
		contentPane.add(lblReporteDeClientes);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 637, 293);
		contentPane.add(scrollPane);
		
		tbCliente = new JTable();
		tbCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbCliente);
		//columnas
		model.addColumn("C�digo");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Direcci�n");
		model.addColumn("Celular");
		//asignar el objeto model a la tabla
		tbCliente.setModel(model);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(this);
		btnReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReporte.setIcon(new ImageIcon(FrmReporteClientesActuales.class.getResource("/img/1291737_document_file_notepad_report_survey_icon.png")));
		btnReporte.setBounds(209, 346, 118, 35);
		contentPane.add(btnReporte);
		
		btnReportePDF = new JButton("Generar PDF");
		btnReportePDF.addActionListener(this);
		btnReportePDF.setIcon(new ImageIcon(FrmReporteClientesActuales.class.getResource("/img/272699_pdf_icon.png")));
		btnReportePDF.setBounds(337, 346, 143, 35);
		contentPane.add(btnReportePDF);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReportePDF) {
			actionPerformedBtnReportePDF(arg0);
		}
		if (arg0.getSource() == btnReporte) {
			actionPerformedBtnReporte(arg0);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent arg0) {
		cargarDataClientes();
	}

	private void cargarDataClientes() {
		// paso1: limpiar tabla
		model.setRowCount(0);
		// paso2: Obtener el resultado del proceso de consulta a la tabla Usuarios
		ArrayList<Cliente> lista = gCli.listarClientes();
		// paso3: Validar y crear un bucle para el recorrido
		if(lista.size()==0){
		mensajeError("Lista vac�a");
		}else{
			for(Cliente cli :lista){
			//Crer un arreglo
			Object fila[] = {cli.getCodigo(),cli.getNombre(),cli.getApellido(),cli.getDirecci�n(),cli.getCelular()};
		// A�adir informaci�n a la tabla
		model.addRow(fila);
		}
		}
		
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error!!", 0);
		
	}
	protected void actionPerformedBtnReportePDF(ActionEvent arg0) {
		Document documento = new Document();
		try {
			String ruta = System.getProperty("user.home");
			PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Clientes_Actuales.pdf"));
			documento.open();
			
			PdfPTable tabla = new PdfPTable(5);
			tabla.addCell("C�digo");
			tabla.addCell("Nombre");
			tabla.addCell("Apellido");
			tabla.addCell("Direcci�n");
			tabla.addCell("Celular");
			
			try {
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_dulcevilla?serverTimezone=UTC", "root", "@R1vadeneyra");
				PreparedStatement pstm = cn.prepareStatement("SELECT * FROM tb_cliente");
				ResultSet rs = pstm.executeQuery();
				if(rs.next()){
					do {
						tabla.addCell(rs.getString(1));
						tabla.addCell(rs.getString(2));
						tabla.addCell(rs.getString(3));
						tabla.addCell(rs.getString(4));
						tabla.addCell(rs.getString(5));
					} while (rs.next());
					documento.add(tabla);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			documento.close();
			JOptionPane.showMessageDialog(null, "Reporte creado");;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
