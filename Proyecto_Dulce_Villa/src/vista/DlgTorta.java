package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Torta;
import mantenimiento.GestionTortaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgTorta extends JDialog implements KeyListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtTorta;
	private JTable tbTorta;
	DefaultTableModel model = new DefaultTableModel();
	GestionTortaDAO gTor = new GestionTortaDAO();
	private JButton okButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgTorta dialog = new DlgTorta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgTorta() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTorta = new JLabel("Torta:");
			lblTorta.setBounds(10, 11, 53, 14);
			contentPanel.add(lblTorta);
		}
		{
			txtTorta = new JTextField();
			txtTorta.addKeyListener(this);
			txtTorta.setBounds(59, 8, 365, 20);
			contentPanel.add(txtTorta);
			txtTorta.setColumns(10);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 53, 414, 164);
			contentPanel.add(scrollPane);
			{
				tbTorta = new JTable();
				scrollPane.setViewportView(tbTorta);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		// agregar columnas
		model.addColumn("idtorta");
		model.addColumn("Descripci�n");
		model.addColumn("Stock");
		model.addColumn("Precio");
		tbTorta.setModel(model);
	}
	private void listarTortas(String tor) {
		// paso1: limpiar tabla
		model.setRowCount(0);
		// paso2: Obtener el resultado del proceso de consulta a la tabla Usuarios
		ArrayList<Torta> lista = gTor.buscarTorta(tor);
		// paso3: Validar y crear un bucle para el recorrido
		if(lista.size()==0){
		mensajeError("Lista vac�a");
		}else{
			for(Torta t :lista){
			//Crer un arreglo
			Object fila[] = {t.getIdtorta(),t.getDescripci�n(),t.getStock(),t.getPrecio()};
		// A�adir informaci�n a la tabla
		model.addRow(fila);
		}
		}
}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema", 0);
		
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtTorta) {
			keyReleasedTxtTorta(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyReleasedTxtTorta(KeyEvent arg0) {
		String tor;
		tor = txtTorta.getText().trim();
		listarTortas(tor);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == okButton) {
			actionPerformedOkButton(arg0);
		}
	}
	protected void actionPerformedOkButton(ActionEvent arg0) {
		enviarDatos();
	}

	private void enviarDatos() {
		String id,des,stock,pre;
		int fila;
		// paso1: Obtener el valor de la fila seleccionada
		fila = tbTorta.getSelectedRow();
		// paso 2:Obtener los datos de la fila seleecionada
		id = tbTorta.getValueAt(fila, 0).toString();
		des = tbTorta.getValueAt(fila, 1).toString();
		stock = tbTorta.getValueAt(fila, 2).toString();
		pre = tbTorta.getValueAt(fila, 3).toString();
		// paso3 : Enviar los datos obtenidos a las cajas de texto de FrmBoleta
		FrmCDP.txtIdTorta.setText(id);
		FrmCDP.txtDescripcionTorta.setText(des);
		FrmCDP.txtStockTorta.setText(stock);
		FrmCDP.txtPrecioTorta.setText(pre);
		// cerrar ventana
		this.dispose();
		
	}
}
