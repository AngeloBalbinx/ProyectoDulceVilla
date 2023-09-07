package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalPopupMenuSeparatorUI;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import com.toedter.calendar.JDateChooser;

import entidad.TipoUsuario;
import entidad.Usuario;
import mantenimiento.GestionTipoUsuarioDAO;
import mantenimiento.GestionUsuarioDAO;
import utils.validaciones;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

@SuppressWarnings("unused")
public class FrmRegistrarUsuario extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblRegistrarse;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblUsuario;
	private JLabel lblClave;
	private JLabel lblFNacimiento;
	private JLabel lblCargo;
	private JDateChooser dcFecha;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JPasswordField txtClave;
	private JComboBox<String> cboTipo;
	private JButton btnRegistrar;
	// Instanciar
	GestionTipoUsuarioDAO gTipUser = new GestionTipoUsuarioDAO();
	GestionUsuarioDAO gUser = new GestionUsuarioDAO();
	private JButton btnCancelar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmRegistrarUsuario dialog = new FrmRegistrarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmRegistrarUsuario() {
		setTitle("Registrar usuario");
		setBounds(100, 100, 383, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblRegistrarse = new JLabel("Por favor, coloque sus datos");
		lblRegistrarse.setBackground(SystemColor.textHighlight);
		lblRegistrarse.setOpaque(true);
		lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarse.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblRegistrarse.setBounds(0, 0, 367, 34);
		contentPanel.add(lblRegistrarse);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 45, 63, 14);
		contentPanel.add(lblNombre);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 70, 63, 14);
		contentPanel.add(lblApellido);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 92, 63, 14);
		contentPanel.add(lblUsuario);
		
		lblClave = new JLabel("Clave:");
		lblClave.setBounds(10, 115, 63, 14);
		contentPanel.add(lblClave);
		
		lblFNacimiento = new JLabel("F. Nacimiento:");
		lblFNacimiento.setBounds(10, 140, 92, 14);
		contentPanel.add(lblFNacimiento);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(10, 172, 63, 14);
		contentPanel.add(lblCargo);
		
		dcFecha = new JDateChooser();
		dcFecha.setDateFormatString("yyyy/MM/dd");
		dcFecha.setBounds(110, 140, 154, 20);
		contentPanel.add(dcFecha);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(83, 45, 124, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(83, 67, 124, 20);
		contentPanel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(83, 89, 124, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setColumns(10);
		txtClave.setBounds(83, 112, 124, 20);
		contentPanel.add(txtClave);
		
		cboTipo = new JComboBox<String>();
		cboTipo.setBounds(81, 169, 156, 20);
		contentPanel.add(cboTipo);
		
		cargarDataComboBox();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnRegistrar.addActionListener(this);
				btnRegistrar.setIcon(new ImageIcon(FrmRegistrarUsuario.class.getResource("/img/9133514_signup_register_login_icon (1).png")));
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				btnCancelar.addActionListener(this);
				btnCancelar.setIcon(new ImageIcon(FrmRegistrarUsuario.class.getResource("/img/211652_close_icon (1).png")));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(arg0);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		registrarDatos();
	}
	private void cargarDataComboBox(){
		ArrayList<TipoUsuario> listaTipUser = gTipUser.listaTipoUsuario();
		if(listaTipUser.size()==0){
			mensajeError("Lista vac�a");
		}else{
			cboTipo.addItem("Seleccione...");
			for (TipoUsuario tipoUsuario : listaTipUser) {
				cboTipo.addItem(tipoUsuario.getIdtipo() + "-" + tipoUsuario.getDescripcion());
				
			}
		}
	}

	private void mensajeError(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema", 0);
		
	}

	private void registrarDatos() {
		// variables
				String nomb, ape, user, clave, fecha;
				int tipo;
				// entradas
				nomb = getNombre();
				ape = getApellido();
				user = getUsuario();
				clave = getClave();
				fecha = getFecha();
				tipo = cboTipo.getSelectedIndex();
				// validar
				if (nomb == null || ape == null || user == null || clave == null || fecha == null || tipo== -1) {
					return;
				} else {
					// procesos
					// Crear un objeto de la clase Usuario
					Usuario u = new Usuario();
					// setear(asignar los valores ingresado a los atributos privados
					u.setNombre(nomb);
					u.setApellido(ape);
					u.setUsuario(user);
					u.setClave(clave);
					u.setfNacim(fecha);
					u.setTipo(tipo);

					// llamar al m�todo registrar
					int res = gUser.registrar(u);
					// validar el resultado del proceso de registrar
					if (res == 0) {
						mensajeError("Error en el registro, el usuario ya existe");
					} else {
						mensajeExitoso("Registro Exitoso");
					}
				}
		
	}

	private String getFecha() {
		String fec = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			fec = sdf.format(dcFecha.getDate());
		} catch (Exception e) {
			dcFecha.setDateFormatString("");;
			mensajeError("Ingresar una fecha de nacimiento");
			dcFecha.requestFocusInWindow();
		}
		return fec;
	}

	@SuppressWarnings("deprecation")
	private String getClave() {
		String pass = null;
		if (txtClave.getText().trim().length() == 0) {
			mensajeError("Ingresar Clave");
			txtClave.requestFocus();
			pass = null;
		}else if(txtClave.getText().trim().matches(validaciones.CLAVE)==false){
			mensajeError("Error en el formato, la clave solo debe contener 5 caracteres num�ricos");
			txtClave.requestFocus();
			txtClave.setText("");
		}
		pass = String.valueOf(txtClave.getPassword());
		return pass;
	}

	private String getUsuario() {
		String user = null;
		if (txtUsuario.getText().trim().length() == 0) {
			mensajeError("Ingresar Usuario");
			txtUsuario.requestFocus();
			user = null;
		} else if(txtUsuario.getText().trim().matches(validaciones.USUARIO)== false) {
			mensajeError("Error en el formato, el usuario debe empezar con U y solo deben ser 4 caracteres");
			txtUsuario.requestFocus();
			txtUsuario.setText("");
		}
		else {
			user = txtUsuario.getText().trim();
		}
		return user;
	}

	private String getApellido() {
		// Validar solo letras y tener de 3 a 45 caracteres 
		String ape = null;
		if(txtApellido.getText().trim().length()==0){
			mensajeError("Ingresar el apellido del usuario");
			txtApellido.requestFocus();
			ape = null;
		}else if(txtNombre.getText().trim().matches(validaciones.APELLIDO) == false){
			mensajeError("Error en el formato, ingrese s�lo letras y de 3 a 45 caracteres");
			txtApellido.requestFocus();
			txtApellido.setText("");
		}else{
		ape = txtApellido.getText().trim();
		}
		return ape;
	}

	private String getNombre() {
		// Validar solo letras y tener de 3 a 45 caracteres 
		String nom = null;
		if(txtNombre.getText().trim().length()==0){
			mensajeError("Ingresar el nombre del usuario");
			txtNombre.requestFocus();
			nom = null;
		}else if(txtNombre.getText().trim().matches(validaciones.NOMBRE) == false){
			mensajeError("Error en el formato, ingrese s�lo letras y de 3 a 45 caracteres");
			txtNombre.requestFocus();
			txtNombre.setText("");
		}else{
		nom = txtNombre.getText().trim();
		}
		return nom;
	}

	private void mensajeExitoso(String msj) {
		JOptionPane.showMessageDialog(this, msj, "Sistema", 1);
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		Logueo l = new Logueo();
		l.setVisible(true);
		this.dispose();
	}
}
