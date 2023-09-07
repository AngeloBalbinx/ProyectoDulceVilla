package utils;

public class validaciones {
	public static final String ID_TORTA = "[T\\d]{5}";
	public static final String DESCRIPCION_TORTA = "[a-zA-Z\\s]{8,45}";
	//public static final String DNI = "\\d{8}"; // 47853206
	//public static final String APELLIDO = "[a-zA-Z������������\\s] {2,25}";
	//public static final String USUARIO = "[a-zA-Z������������\\s\\d] {4}";
	//public static final String CLAVE= "[a-zA-Z������������\\s\\d] {5}";
	//public static final String FECHA= "\\d{4}-\\d{2}-\\d{2}";
	public static final String NOMBRE = "[a-zA-Z\\s]{3,45}";
	public static final String APELLIDO = "[a-zA-Z\\s]{3,45}";
	public static final String USUARIO= "[U\\d]{4}";
	public static final String CLAVE= "[\\d]{5}";
	public static final String CODCLI = "[C\\d]{4}";
	public static final String DIRECCION = "[a-zA-Z\\d\\s.]{2,45}";
	public static final String CELULAR = "\\d{9}";
}
