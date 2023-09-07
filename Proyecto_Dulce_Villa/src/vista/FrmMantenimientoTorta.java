package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import entidad.TipoTorta;
import entidad.Torta;
import mantenimiento.GestionTipoTortaDAO;
import mantenimiento.GestionTortaDAO;
import utils.validaciones;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import java.awt.Cursor;

@SuppressWarnings("unused")
public class FrmMantenimientoTorta extends JInternalFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblIdtorta;
	private JLabel lblNewLabel;
	private JLabel lblDescipcin;
	private JLabel lblStock;
	private JLabel lblPrecio;
	private JLabel lblTipo;
	private JTable tbTorta;
	private JTextField txtId;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JComboBox<String> cboTipo;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JLabel lblDatosDeLa;
	//Instanciar un objeto
	GestionTortaDAO gTor = new GestionTortaDAO();
	GestionTipoTortaDAO gTipTor = new GestionTipoTortaDAO();
	//Modelamiento de la tabla 
	DefaultTableModel model = new DefaultTableModel();
	private JLabel label;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmMantenimientoTorta dialog = new FrmMantenimientoTorta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmMantenimientoTorta() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 884, 432);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 128, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblIdtorta = new JLabel("idtorta:");
		lblIdtorta.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblIdtorta.setForeground(Color.WHITE);
		lblIdtorta.setBounds(627, 125, 59, 14);
		contentPanel.add(lblIdtorta);
		
		lblNewLabel = new JLabel("Mantenimiento Torta");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 879, 31);
		contentPanel.add(lblNewLabel);
		
		lblDescipcin = new JLabel("Descripci\u00F3n:");
		lblDescipcin.setForeground(Color.WHITE);
		lblDescipcin.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblDescipcin.setBounds(627, 156, 69, 14);
		contentPanel.add(lblDescipcin);
		
		lblStock = new JLabel("Stock:");
		lblStock.setForeground(Color.WHITE);
		lblStock.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblStock.setBounds(628, 181, 46, 14);
		contentPanel.add(lblStock);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblPrecio.setBounds(628, 206, 46, 14);
		contentPanel.add(lblPrecio);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setBounds(629, 233, 46, 14);
		contentPanel.add(lblTipo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 593, 268);
		contentPanel.add(scrollPane);
		
		tbTorta = new JTable();
		tbTorta.addKeyListener(this);
		tbTorta.addMouseListener(this);
		scrollPane.setViewportView(tbTorta);
		tbTorta.setFillsViewportHeight(true);
		
		txtId = new JTextField();
		txtId.setBounds(696, 123, 116, 20);
		contentPanel.add(txtId);
		txtId.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(696, 151, 116, 20);
		contentPanel.add(txtDescripcion);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(696, 179, 116, 20);
		contentPanel.add(txtStock);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(697, 204, 116, 20);
		contentPanel.add(txtPrecio);
		
		cboTipo = new JComboBox<String>();
		cboTipo.setBounds(696, 231, 147, 19);
		contentPanel.add(cboTipo);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevo.setIcon(new ImageIcon(FrmMantenimientoTorta.class.getResource("/img/4781840_+_add_circle_create_expand_icon (2).png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(290, 333, 110, 31);
		contentPanel.add(btnNuevo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setIcon(new ImageIcon(FrmMantenimientoTorta.class.getResource("/img/9133514_signup_register_login_icon (1).png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(423, 333, 131, 31);
		contentPanel.add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnActualizar.setIcon(new ImageIcon(FrmMantenimientoTorta.class.getResource("/img/8111405_reset_reload_refresh_sync_arrow_icon.png")));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(575, 333, 131, 31);
		contentPanel.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoTorta.class.getResource("/img/3669361_delete_ic_icon (1).png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(728, 333, 135, 31);
		contentPanel.add(btnEliminar);
		
		lblDatosDeLa = new JLabel("Datos de la torta");
		lblDatosDeLa.setForeground(Color.WHITE);
		lblDatosDeLa.setBackground(Color.WHITE);
		lblDatosDeLa.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblDatosDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDeLa.setBounds(644, 77, 186, 38);
		contentPanel.add(lblDatosDeLa);
		//Determimar columnas de la tabla
		model.addColumn("id_torta");
		model.addColumn("Descipci�n");
		model.addColumn("Stock");
		model.addColumn("Precio");
		model.addColumn("Tipo");
		//asignar el objeto "model" a la tabla "tbTorta"
		tbTorta.setModel(model);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmMantenimientoTorta.class.getResource("/img/OIP-_1_.jpg")));
		label.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 255), new Color(60, 179, 113), new Color(0, 250, 154), new Color(128, 0, 0)));
		label.setBounds(608, 66, 255, 215);
		contentPanel.add(label);
		//cargar data a la tabla
		cargarDataTortas();
		//mostrar datos en las cajas de texto
		mostrarData(0);
		//cargar data al combobox
		cargarDataComboBox();
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(arg0);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		registrarTorta();
		cargarDataTortas();
	}

	private void registrarTorta() {
		// Declarar variables
		String id,des;
		int stock,tipo;
		double precio;
		// Obtener los valores ingresados en la GUI
		id  = getId();
		des = getDescripcion();
		stock = getStock();
		precio = getPrecio();
		tipo = cboTipo.getSelectedIndex();
		// Validar
		if(id==null || des == null || stock == -1 || precio ==-1 || tipo == -1){
			return;
		}else{
			//Crear un objeto de tipo "Torta"
			Torta tor = new Torta();
			//Setear
			tor.setIdtorta(id);
			tor.setDescripci�n(des);
			tor.setStock(stock);
			tor.setPrecio(precio);
			tor.setTipo(tipo);
			//Llamar al proceso de registro
			int ok = gTor.registrar(tor);
			//Validar el resultado del proceso
			if(ok ==0){
				mensajeError("Error en el registro");
			}else
				mensajeExitoso("Registro exitoso");
		}
		
	}

	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema", 1);
		
	}

	private double getPrecio() {
		double pre = -1;
		if(txtPrecio.getText().trim().length()==0){
			mensajeError("Ingresar el precio");
			txtPrecio.requestFocus();
			pre = -1;
		}
		else{
			try {
				pre = Double.parseDouble(txtPrecio.getText());
				if(pre<=0){
					mensajeError("Ingresar precio mayor a 0");
					txtPrecio.setText("");
					txtPrecio.requestFocus();;
					pre =-1;
				}
			} catch (NumberFormatException e) {
				mensajeError("Ingresar solo valores num�ricos al precio");
			}
		}
		return pre;
	}

	private int getStock() {
		int stock = -1;
		if(txtStock.getText().trim().length()==0){
			mensajeError("Ingresar el stock");
			txtStock.requestFocus();
			stock = -1;
		}
		else{
			try {
				stock = Integer.parseInt(txtStock.getText());
				if(stock<=0){
					mensajeError("Ingresar stock mayor a 0");
					txtStock.setText("");
					txtStock.requestFocus();;
					stock =-1;
				}
			} catch (NumberFormatException e) {
				mensajeError("Ingresar solo valores num�ricos al stock");
			}
		}
		return stock;
	}

	private String getDescripcion() {
		String des = null;
		if(txtDescripcion.getText().trim().length()==0){
			mensajeError("Ingresar la descripci�n de la torta");
			txtDescripcion.requestFocus();
		}else if(txtDescripcion.getText().trim().matches(validaciones.DESCRIPCION_TORTA) == false){
			mensajeError("Error en el formato, la descripci�n solo acepta letras hasta un m�ximo de 45 d�gitos");
			txtDescripcion.requestFocus();
			txtDescripcion.setText("");
		}
		else {
			des = txtDescripcion.getText().trim();
		}
		return des;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj,"Error", 0);
		
	}

	private String getId() {
		String id = null;
		if(txtId.getText().trim().length()==0){
			mensajeError("Ingresar el id de la torta");
			txtId.requestFocus();
		}else if(txtId.getText().trim().matches(validaciones.ID_TORTA) == false){
			mensajeError("Error en el formato, el id debe empezar con T y solo deben ser 5 d�gitos");
			txtId.requestFocus();
			txtId.setText("");
		}
		else {
			id = txtId.getText().trim();
		}
		return id;
	}
	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
		actualizarTorta();
		cargarDataTortas();
	}
	private void actualizarTorta() {
		// Declarar variables
		String id,des;
		int stock,tipo;
		double precio;
		// Obtener los datos del GUI
		id = getId();
		des = getDescripcion();
		stock = getStock();
		precio = getPrecio();
		tipo = cboTipo.getSelectedIndex();
		// Validar
		if(id ==null|| des == null || stock == -1 || precio == -1 || tipo ==-1){
				return;
		}else{
		// Crear un objeto de la clase "Torta"
		Torta tor = new Torta();
		// Setear --> asignar los valores obtenidos de la GUI a los atributos privados
		tor.setIdtorta(id);
		tor.setDescripci�n(des);
		tor.setStock(stock);
		tor.setPrecio(precio);
		tor.setTipo(tipo);
		// Llamar al proceso actualizar
		int ok = gTor.actualizar(tor);
		// Validar el resultado del proceso actualizar
		if(ok == 0){
			mensajeError("Error en la actualizaci�n,recuerde seleccionar un tipo de torta ");
		}else{
			mensajeExitoso("Torta actualizada");

		
			}
		}
	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarTorta();
		cargarDataTortas();
	}
	
	private void eliminarTorta() {
		//obtener el id
		String id;
		int opcion;
		id = getId();
		// Validar
		if(id == null){
			return;
		}else{
		//mensaje de confirmaci�n para eliminar
		opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar? ","Sistema",JOptionPane.YES_NO_OPTION);
		if(opcion ==0){ // CLICK YES!! SI DESEA ELIMINAR
			// Ejecutar el proceso -- eliminar usuarios
			int ok = gTor.eliminar(id);
			// validar el resultado del proceso
			if(ok ==0){
				mensajeError("Id no existe");
					}else{
						mensajeExitoso("Torta eliminada");
					
						
					}	
				}
		}
	}

	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		txtId.setText("");
		txtDescripcion.setText("");
		txtStock.setText("");
		txtPrecio.setText("");
		txtId.requestFocus();
		cboTipo.setSelectedIndex(0);
	}
	// Crear un m�todo para cargar los datos de la tabla
		private void cargarDataTortas(){
			// paso1: limpiar tabla
			model.setRowCount(0);
			// paso2: Obtener el resultado del proceso de consulta a la tabla torta
			ArrayList<Torta> data = gTor.listarTortas(); 
			// paso3: crear un bucle para el recorrido
			for(Torta tor :data){
				//Crer un arreglo
				Object fila[] = {tor.getIdtorta(),tor.getDescripci�n(),tor.getStock(),tor.getPrecio(),tor.getTipo()};
			// A�adir informaci�n a la tabla
			model.addRow(fila);
			}
		}
		// crear m�todo para mostrar datos en las cajas de texto
		private void mostrarData(int posfila){
			// declarar las variables
			String id,des,stock,precio;
			// paso1: Obtener los valores de la tabla
			// -- getValueAt(file,columna)
			id = tbTorta.getValueAt(posfila,0).toString();
			des = tbTorta.getValueAt(posfila,1).toString();
			stock = tbTorta.getValueAt(posfila,2).toString();
			precio = tbTorta.getValueAt(posfila,3).toString();
			
			//paso2: mostrar los valores obtenidos en las cajas de texto
			txtId.setText(id);
			txtDescripcion.setText(des);
			txtStock.setText(stock);
			txtPrecio.setText(precio);
			
	
		}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tbTorta) {
			mouseClickedTbTorta(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTbTorta(MouseEvent arg0) {
		// paso1: obtener el valor de la fila seleccionada
		int posfila = tbTorta.getSelectedRow();
		// paso2: mostrar los valores en la caja de texto
		mostrarData(posfila);
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == tbTorta) {
			keyReleasedTbTorta(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyReleasedTbTorta(KeyEvent arg0) {
		// paso1: obtener el valor de la fila seleccionada
		int posfila = tbTorta.getSelectedRow();
		// paso2: mostrar los valores en la caja de texto
		mostrarData(posfila);
	}
	// M�todo para cargar data al combobox desde la BD
	private void cargarDataComboBox(){
		// 1. Obtener el resultado del proceso de consulta
		ArrayList<TipoTorta> listaTipTorta = gTipTor.listaTipoTorta();
		// 2. validar el resultado del proceso
		if(listaTipTorta.size()==0){
			mensajeError("Lista Vac�a");
		}else{
			cboTipo.addItem("Seleccione ...");
			for (TipoTorta tipoTorta : listaTipTorta) {
				cboTipo.addItem(tipoTorta.getIdtipo()+ " - " + tipoTorta.getDescripcion());
			}
		}
	}
}
