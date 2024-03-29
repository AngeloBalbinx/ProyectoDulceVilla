package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Cliente;
import entidad.Torta;
import mantenimiento.GestionClienteDAO;
import utils.validaciones;

import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Cursor;

@SuppressWarnings("unused")
public class FrmMantenimientoCliente extends JInternalFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMantenimientoCliente;
	private JLabel lblDatosDelCliente;
	private JLabel lblCdigo;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblDireccin;
	private JTextField txtDireccion;
	private JLabel lblCelular;
	private JTextField txtCelular;
	private JLabel lblNewLabel;
	private JTable tbCliente;
	private JScrollPane scrollPane;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;

	// Modelamiento de la tabla
	DefaultTableModel model = new DefaultTableModel();
	// Instanciar
	GestionClienteDAO gCli = new GestionClienteDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoCliente frame = new FrmMantenimientoCliente();
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
	public FrmMantenimientoCliente() {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 969, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMantenimientoCliente = new JLabel("Mantenimiento Cliente");
		lblMantenimientoCliente.setOpaque(true);
		lblMantenimientoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoCliente.setForeground(Color.WHITE);
		lblMantenimientoCliente.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblMantenimientoCliente.setBackground(Color.GREEN);
		lblMantenimientoCliente.setBounds(0, 0, 963, 31);
		contentPane.add(lblMantenimientoCliente);

		lblDatosDelCliente = new JLabel("Datos del cliente");
		lblDatosDelCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelCliente.setForeground(Color.WHITE);
		lblDatosDelCliente.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblDatosDelCliente.setBackground(Color.WHITE);
		lblDatosDelCliente.setBounds(720, 74, 186, 49);
		contentPane.add(lblDatosDelCliente);

		lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblCdigo.setForeground(Color.WHITE);
		lblCdigo.setBounds(707, 134, 66, 14);
		contentPane.add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.setText("<dynamic>");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(801, 134, 116, 20);
		contentPane.add(txtCodigo);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(707, 161, 69, 14);
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setText("<dynamic>");
		txtNombre.setColumns(10);
		txtNombre.setBounds(801, 157, 116, 20);
		contentPane.add(txtNombre);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setBounds(707, 186, 66, 14);
		contentPane.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setText("<dynamic>");
		txtApellido.setColumns(10);
		txtApellido.setBounds(801, 184, 116, 20);
		contentPane.add(txtApellido);

		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblDireccin.setForeground(Color.WHITE);
		lblDireccin.setBounds(707, 217, 66, 14);
		contentPane.add(lblDireccin);

		txtDireccion = new JTextField();
		txtDireccion.setText("<dynamic>");
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(801, 215, 142, 20);
		contentPane.add(txtDireccion);

		lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setBounds(707, 242, 66, 14);
		contentPane.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular.setText("<dynamic>");
		txtCelular.setColumns(10);
		txtCelular.setBounds(801, 244, 116, 20);
		contentPane.add(txtCelular);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 255), new Color(34, 139, 34),
				new Color(0, 250, 154), new Color(165, 42, 42)));
		lblNewLabel.setIcon(new ImageIcon(FrmMantenimientoCliente.class.getResource("/img/OIP-_1_.jpg")));
		lblNewLabel.setBounds(679, 73, 270, 223);
		contentPane.add(lblNewLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 659, 268);
		contentPane.add(scrollPane);

		tbCliente = new JTable();
		tbCliente.setFillsViewportHeight(true);
		tbCliente.addKeyListener(this);
		tbCliente.addMouseListener(this);

		scrollPane.setViewportView(tbCliente);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(
				FrmMantenimientoCliente.class.getResource("/img/4781840_+_add_circle_create_expand_icon (2).png")));
		btnNuevo.setBounds(269, 333, 110, 31);
		contentPane.add(btnNuevo);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon(
				FrmMantenimientoCliente.class.getResource("/img/9133514_signup_register_login_icon (1).png")));
		btnRegistrar.setBounds(402, 333, 131, 31);
		contentPane.add(btnRegistrar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnActualizar.addActionListener(this);
		btnActualizar.setIcon(new ImageIcon(
				FrmMantenimientoCliente.class.getResource("/img/8111405_reset_reload_refresh_sync_arrow_icon.png")));
		btnActualizar.setBounds(554, 333, 131, 31);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(
				new ImageIcon(FrmMantenimientoCliente.class.getResource("/img/3669361_delete_ic_icon (1).png")));
		btnEliminar.setBounds(707, 333, 135, 31);
		contentPane.add(btnEliminar);
		// Determinar columnas de la tabla
		model.addColumn("C�digo");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Direcci�n");
		model.addColumn("Celular");
		// asignar el objeto "model" a la tabla "tbCliente"
		tbCliente.setModel(model);
		// Cargar data a la tabla
		cargarDataClientes();
		// Mostrar datos en las cajas de texto
		mostrarData(0);
		

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(arg0);
		}
	}

	protected void actionPerformedBtnNuevo(ActionEvent arg0) {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDireccion.setText("");
		txtCelular.setText("");
		txtCodigo.requestFocus();
	}

	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		registrarCliente();
		cargarDataClientes();
	}

	private void registrarCliente() {
		// Declarar variables
		String cod, nom, ape, dir, cel;
		// Obtener los valores ingresados en la GUI
		cod = getCodigo();
		nom = getNombre();
		ape = getApellido();
		dir = getDirecci�n();
		cel = getCelular();
		// Validar
		if (cod == null || nom == null || ape == null || dir == null || cel == null) {
			return;
		} else {
			// Crear un objeto de tipo "Cliente"
			Cliente cli = new Cliente();
			// Setear
			cli.setCodigo(cod);
			cli.setNombre(nom);
			cli.setApellido(ape);
			cli.setDirecci�n(dir);
			cli.setCelular(cel);
			// Llamar al proceso de registro
			int ok = gCli.registrar(cli);
			// Validar el resultado del proceso
			if (ok == 0) {
				mensajeError("Error en el registro");
			} else {
				mensajeExitoso("Registro exitoso");
			}
		}
	}

	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema", 1);

	}

	private String getCelular() {
		String cel = null;
		if (txtCelular.getText().trim().length() == 0) {
			mensajeError("Ingreasr el celular del cliente");
			txtCelular.requestFocus();
			cel = null;
		} else if (txtCelular.getText().trim().matches(validaciones.CELULAR) == false) {
			mensajeError("Error en el formato, el celular solo debe contener 9 n�meros");
			txtCelular.requestFocus();
			txtCelular.setText("");
		} else {
			cel = txtCelular.getText().trim();
		}

		return cel;
	}

	private String getDirecci�n() {
		String dir = null;
		if (txtDireccion.getText().trim().length() == 0) {
			mensajeError("Ingresar la direcci�n del cliente");
			txtDireccion.requestFocus();
			dir = null;

		} else if (txtDireccion.getText().trim().matches(validaciones.DIRECCION) == false) {
			mensajeError("Error en el formato, la direcci�n debe contener de 2 a 45 caracteres");
			txtDireccion.requestFocus();
			txtDireccion.setText("");
		} else {
			dir = txtDireccion.getText().trim();
		}
		return dir;
	}

	private String getApellido() {
		String ape = null;
		if (txtApellido.getText().trim().length() == 0) {
			mensajeError("Ingresar el apellido del cliente");
			txtApellido.requestFocus();
			ape = null;
		} else if (txtNombre.getText().trim().matches(validaciones.APELLIDO) == false) {
			mensajeError("Error en el formato, ingrese s�lo letras y de 3 a 45 caracteres");
			txtApellido.requestFocus();
			txtApellido.setText("");
		} else {
			ape = txtApellido.getText().trim();
		}
		return ape;
	}

	private String getNombre() {
		// Validar solo letras y tener de 3 a 45 caracteres
		String nom = null;
		if (txtNombre.getText().trim().length() == 0) {
			mensajeError("Ingresar el nombre del cliente");
			txtNombre.requestFocus();
			nom = null;
		} else if (txtNombre.getText().trim().matches(validaciones.NOMBRE) == false) {
			mensajeError("Error en el formato, ingrese s�lo letras y de 3 a 45 caracteres");
			txtNombre.requestFocus();
			txtNombre.setText("");
		} else {
			nom = txtNombre.getText().trim();
		}
		return nom;
	}

	private String getCodigo() {
		String cod = null;
		if (txtCodigo.getText().trim().length() == 0) {
			mensajeError("Ingresar el c�digo del cliente");
			txtCodigo.requestFocus();
		} else if (txtCodigo.getText().trim().matches(validaciones.CODCLI) == false) {
			mensajeError("Error en el formato, el c�digo debe empezar con C y solo deben ser 4 d�gitos");
			txtCodigo.requestFocus();
			txtCodigo.setText("");
		} else {
			cod = txtCodigo.getText().trim();
		}
		return cod;
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Error", 0);

	}

	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
		actualizarCliente();
		cargarDataClientes();
	}

	private void actualizarCliente() {
		// Declarar variables
		String cod, nom, ape, dir, cel;
		// Obtener los valores ingresados en la GUI
		cod = getCodigo();
		nom = getNombre();
		ape = getApellido();
		dir = getDirecci�n();
		cel = getCelular();
		// Validar
		if (cod == null || nom == null || ape == null || dir == null || cel == null) {
			return;
		} else {
			// Crear un objeto de la clase "Cliente"
			Cliente cli = new Cliente();
			// Setear --> asignar los valores obtenidos de la GUI a los
			// atributos privados
			cli.setCodigo(cod);
			cli.setNombre(nom);
			cli.setApellido(ape);
			cli.setDirecci�n(dir);
			cli.setCelular(cel);
			// Llamar al proceso actualizar
			int ok = gCli.actualizar(cli);
			// Validar el resultado del proceso actualizar
			if (ok == 0) {
				mensajeError("Error en la actualizaci�n");
			} else {
				mensajeExitoso("Cliente actualizado");

			}
		}

	}

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarCliente();
		cargarDataClientes();
	}

	private void eliminarCliente() {
		// obtener el id
		String cod;
		int opcion;
		cod = getCodigo();
		// Validar
		if (cod == null) {
			return;
		} else {
			// mensaje de confirmaci�n para eliminar
			opcion = JOptionPane.showConfirmDialog(this, "Seguro de eliminar? ", "Sistema", JOptionPane.YES_NO_OPTION);
			if (opcion == 0) { // CLICK YES!! SI DESEA ELIMINAR
				// Ejecutar el proceso -- eliminar usuarios
				int ok = gCli.eliminar(cod);
				// validar el resultado del proceso
				if (ok == 0) {
					mensajeError("C�digo no existe");
				} else {
					mensajeExitoso("Cliente eliminado");

				}
			}
		}

	}
	private void cargarDataClientes() {
		// paso1: limpiar tabla
		model.setRowCount(0);
		// paso2: Obtener el resultado del proceso de consulta a la tabla torta
		ArrayList<Cliente> data = gCli.listarClientes(); 
		// paso3: crear un bucle para el recorrido
		for(Cliente cli :data){
			//Crer un arreglo
			Object fila[] = {cli.getCodigo(),cli.getNombre(),cli.getApellido(),cli.getDirecci�n(),cli.getCelular()};
		// A�adir informaci�n a la tabla
		model.addRow(fila);
		}
	}
	// crear m�todo para mostrar datos en las cajas de texto
	private void mostrarData(int posfila){
		// declarar las variables
		String cod,nom,ape,dir,cel;
		// paso1: Obtener los valores de la tabla
		// -- getValueAt(file,columna)
		cod = tbCliente.getValueAt(posfila, 0).toString();
		nom = tbCliente.getValueAt(posfila, 1).toString();
		ape = tbCliente.getValueAt(posfila, 2).toString();
		dir = tbCliente.getValueAt(posfila, 3).toString();
		cel = tbCliente.getValueAt(posfila, 4).toString();	
		//paso2: mostrar los valores obtenidos en las cajas de texto
		txtCodigo.setText(cod);
		txtNombre.setText(nom);
		txtApellido.setText(ape);
		txtDireccion.setText(dir);
		txtCelular.setText(cel);
	}
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tbCliente) {
			mouseClickedTbCliente(arg0);
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
	protected void mouseClickedTbCliente(MouseEvent arg0) {
		// paso1: obtener el valor de la fila seleccionada
			int posfila = tbCliente.getSelectedRow();
		// paso2: mostrar los valores en la caja de texto
			mostrarData(posfila);
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == tbCliente) {
			keyReleasedTbCliente(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyReleasedTbCliente(KeyEvent arg0) {
		// paso1: obtener el valor de la fila seleccionada
			int posfila = tbCliente.getSelectedRow();
		// paso2: mostrar los valores en la caja de texto
			mostrarData(posfila);
	}
}
