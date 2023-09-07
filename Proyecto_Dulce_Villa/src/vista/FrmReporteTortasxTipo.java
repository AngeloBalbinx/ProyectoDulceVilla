package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import entidad.TipoTorta;
import entidad.Torta;
import mantenimiento.GestionTipoTortaDAO;
import mantenimiento.GestionTortaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

@SuppressWarnings("unused")
public class FrmReporteTortasxTipo extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblReporteDeTortas;
	private JLabel lblTipo;
	private JComboBox<String> cboTipo;
	private JTable tbTorta;
	private JScrollPane scrollPane;
	private JButton btnReporte;
	DefaultTableModel model = new DefaultTableModel();
	// instanciar objeto
	GestionTipoTortaDAO gTipTor = new GestionTipoTortaDAO();
	GestionTortaDAO gTor = new GestionTortaDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmReporteTortasxTipo dialog = new FrmReporteTortasxTipo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmReporteTortasxTipo() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 677, 409);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblReporteDeTortas = new JLabel("Reporte de tortas seg\u00FAn el tipo");
		lblReporteDeTortas.setOpaque(true);
		lblReporteDeTortas.setHorizontalAlignment(SwingConstants.CENTER);
		lblReporteDeTortas.setForeground(Color.WHITE);
		lblReporteDeTortas.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblReporteDeTortas.setBackground(Color.CYAN);
		lblReporteDeTortas.setBounds(0, 0, 668, 31);
		contentPanel.add(lblReporteDeTortas);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 42, 46, 14);
		contentPanel.add(lblTipo);
		
		cboTipo = new JComboBox<String>();
		cboTipo.setBounds(42, 39, 200, 20);
		contentPanel.add(cboTipo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 648, 247);
		contentPanel.add(scrollPane);
		
		tbTorta = new JTable();
		scrollPane.setViewportView(tbTorta);
		tbTorta.setFillsViewportHeight(true);
		//columnas
		model.addColumn("idtorta");
		model.addColumn("Descripci�n");
		model.addColumn("Stock");
		model.addColumn("Precio");
		model.addColumn("Tipo");
		//asignar el objeto model a la tabla
		tbTorta.setModel(model);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReporte.addActionListener(this);
		btnReporte.setIcon(new ImageIcon(FrmReporteTortasxTipo.class.getResource("/img/1291737_document_file_notepad_report_survey_icon.png")));
		btnReporte.setBounds(258, 325, 143, 35);
		contentPanel.add(btnReporte);
		
		cargarDataComboBox();
	}
	private void cargarDataComboBox(){
		// 1. Obtener el resultado del proceso de consulta
		ArrayList<TipoTorta> listaTipTor = gTipTor.listaTipoTorta();
		// 2. validar el resultado del proceso
		if(listaTipTor.size()==0){
			mensajeError("Lista Vac�a");
		}else{
			cboTipo.addItem("Seleccione...");
			for(TipoTorta tipoUsuarios:listaTipTor){
				cboTipo.addItem(tipoUsuarios.getIdtipo()+"-" + tipoUsuarios.getDescripcion());
			}
		}
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error!!", 0);
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnReporte) {
			actionPerformedBtnReporte(arg0);
		}
	}
	protected void actionPerformedBtnReporte(ActionEvent arg0) {
		//limpiar la tabla
		model.setRowCount(0);
		//obtener el tipo de usuario ingresado
		int tipo = getTipo() ;
		// Validar
		if(tipo ==0){
			return;
		}else{
			//obtener el resultado del proceso de consulta
			ArrayList<Torta> listTor = gTor.listarTortaxTipo(tipo);
			//validar el resultado del proceso
			if(listTor.size()==0){
				mensajeError("Lista vac�a");
			}else{
				//bucle
				for(Torta u:listTor){
					Object fila[] = {u.getIdtorta(),u.getDescripci�n(),u.getStock(),u.getPrecio(),u.getTipo()};
					model.addRow(fila);
					}
				}
			}
		}

		private int getTipo() {
			return cboTipo.getSelectedIndex();
		}
	
}