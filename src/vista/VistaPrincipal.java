package vista;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.TableColumnModel;

import carrito.Cliente;
import carrito.DetalleVenta;
import carrito.Producto;

import javax.swing.SwingConstants;

import controlador.Controlador;

import java.awt.Insets;
import java.util.ArrayList;

public class VistaPrincipal extends JFrame implements InterfazVista{
			
	private VentanaCliente ventanaCliente;
	private VentanaProducto ventanaProducto;
	private VentanaCarrito ventanaCarrito;
	
	private TablaModel<Producto> tablaProductos;
	private JTable tblProducto;
	private TablaModel<Cliente> tablaClientes;
	private JTable tblCliente;
	private TablaCarrito tablaCarrito;
	private JTable tblCarrito;
	
	private JTextField txtTotal;

	private JButton btnInsertarProducto;
	private JButton btnActualizarProducto;
	private JButton btnInsertarCliente;
	private JButton btnAgregarAlCarrito;
	private JButton btnBorrarItem;
	private JButton btnLimpiarCarrito;
	private JButton btnFinalizarCompra;

	public VistaPrincipal() {
		setBounds(175, 175, 700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Carrito de Compras");
		setResizable(false);
		
		// TABLAS
		
		//TABLA PRODUCTOS		
		JScrollPane scrollPaneTablaProducto = new JScrollPane();
		scrollPaneTablaProducto.setBounds(24, 58, 388, 170);
		getContentPane().add(scrollPaneTablaProducto);
		tblProducto = new JTable();
		scrollPaneTablaProducto.setViewportView(tblProducto);
		
		
		//TABLA CLIENTES		
		JScrollPane scrollPaneTablaCliente = new JScrollPane();
		scrollPaneTablaCliente.setBounds(438, 58, 220, 211);
		getContentPane().add(scrollPaneTablaCliente);
		tblCliente = new JTable();
		scrollPaneTablaCliente.setViewportView(tblCliente);
		
		
		//TABLA CARRITO COMPRAS	
		JScrollPane scrollPaneTablaCarrito = new JScrollPane();
		scrollPaneTablaCarrito.setBounds(21, 300, 499, 121);
		getContentPane().add(scrollPaneTablaCarrito);
		tblCarrito = new JTable();
		scrollPaneTablaCarrito.setViewportView(tblCarrito);

		
		// TOTAL DEL CARRITO
		txtTotal = new JTextField("0.00");
		txtTotal.setEditable(false);
		txtTotal.setBounds(470, 432, 50, 20);
		getContentPane().add(txtTotal);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(410, 432, 50, 20);
		getContentPane().add(lblTotal);

		
		// BOTONES
		
		//BOTON INSERTAR PRODUCTO
		btnInsertarProducto = new JButton(this.INSERTAR_PRODUCTO);		
		btnInsertarProducto.setBounds(21, 26, 201, 21);		
		getContentPane().add(btnInsertarProducto);
		btnInsertarProducto.setActionCommand(this.INSERTAR_PRODUCTO);

		//BOTON ACTUALIZAR PRODUCTO
		btnActualizarProducto = new JButton(this.ACTUALIZAR_PRODUCTO);		
		btnActualizarProducto.setBounds(230, 26, 182, 21);
		getContentPane().add(btnActualizarProducto);
		btnActualizarProducto.setActionCommand(this.ACTUALIZAR_PRODUCTO);
		
		//BOTON INSERTAR CLIENTE
		btnInsertarCliente = new JButton(INSERTAR_CLIENTE);
		btnInsertarCliente.setBounds(438, 26, 220, 21);
		getContentPane().add(btnInsertarCliente);
		btnInsertarCliente.setActionCommand(INSERTAR_CLIENTE);

		// BOTON AGREGAR AL CARRITO
		btnAgregarAlCarrito = new JButton(AGREGAR_CARRITO);
		btnAgregarAlCarrito.setBounds(21, 233, 391, 36);
		getContentPane().add(btnAgregarAlCarrito);
		btnAgregarAlCarrito.setActionCommand(AGREGAR_CARRITO);
		
		// BOTON BORRAR ITEM
		btnBorrarItem = new JButton(this.BORRAR_ITEM);
		btnBorrarItem.setActionCommand(this.BORRAR_ITEM);
		btnBorrarItem.setBounds(530, 304, 128, 21);
		getContentPane().add(btnBorrarItem);
		
		// BOTON LIMPIAR CARRITO
		btnLimpiarCarrito = new JButton(LIMPIAR_CARRITO);
		btnLimpiarCarrito.setActionCommand(LIMPIAR_CARRITO);
		btnLimpiarCarrito.setBounds(530, 328, 128, 21);
		getContentPane().add(btnLimpiarCarrito);
		
		//BOTON FINALIZAR COMPRA
		btnFinalizarCompra = new JButton(FINALIZAR_COMPRA);
		btnFinalizarCompra.setMargin(new Insets(2, 10, 2, 10));
		btnFinalizarCompra.setActionCommand(FINALIZAR_COMPRA);
		btnFinalizarCompra.setBounds(530, 360, 128, 61);
		getContentPane().add(btnFinalizarCompra);	
	}
	
	// METODOS	

	public void setControlador(Controlador c) {
		btnInsertarProducto.addActionListener(c);
		btnActualizarProducto.addActionListener(c);
		btnInsertarCliente.addActionListener(c);
		btnAgregarAlCarrito.addActionListener(c);
		btnBorrarItem.addActionListener(c);
		btnLimpiarCarrito.addActionListener(c);
		btnFinalizarCompra.addActionListener(c);
	}

	public void abrirFormulario(String operacion, Controlador c) {
		if (operacion.equals(this.INSERTAR_PRODUCTO)){
			ventanaProducto = new VentanaProducto(this.INSERTAR_PRODUCTO);
			ventanaProducto.btnAceptar.setActionCommand(this.CONFIRMAR_INSERTAR_PRODUCTO);
			ventanaProducto.btnCancelar.setActionCommand(this.CANCELAR_INSERTAR_PRODUCTO);
			ventanaProducto.setControlador(c);
			ventanaProducto.setVisible(true);
		}else if(operacion.equals(this.ACTUALIZAR_PRODUCTO)){
			ventanaProducto = new VentanaProducto(this.ACTUALIZAR_PRODUCTO);
			ventanaProducto.setControlador(c);
			ventanaProducto.btnAceptar.setActionCommand(this.CONFIRMAR_ACTUALIZAR_PRODUCTO);
			ventanaProducto.btnCancelar.setActionCommand(this.CANCELAR_ACTUALIZAR_PRODUCTO);
			ventanaProducto.setVisible(true);
		}else if (operacion.equals(this.INSERTAR_CLIENTE)){
			ventanaCliente = new VentanaCliente(operacion);
			ventanaCliente.setControlador(c);
			ventanaCliente.setActionCommand(CONFIRMAR_INSERTAR_CLIENTE, CANCELAR_INSERTAR_CLIENTE);
			ventanaCliente.setVisible(true);
		}else if (operacion.equals(this.AGREGAR_CARRITO)){
			ventanaCarrito = new VentanaCarrito(operacion);
			ventanaCarrito.setControlador(c);
			ventanaCarrito.setActionCommand(CONFIRMAR_AGREGAR_CARRITO, CANCELAR_AGREGAR_CARRITO);
			ventanaCarrito.setVisible(true);
		}
	}
	
	public void cerrarFormulario(String operacion){
		if (operacion.equals(INSERTAR_PRODUCTO) || operacion.equals(ACTUALIZAR_PRODUCTO)){
			ventanaProducto.dispose();
		}else if(operacion.equals(INSERTAR_CLIENTE)){
			ventanaCliente.dispose();
		}else if(operacion.equals(AGREGAR_CARRITO)){
			ventanaCarrito.dispose();
		}
	}

	public void setTotal(String total){
		txtTotal.setText(total);
	}
	
	// METODOS DE MENSAJES DE DIALOGO
	
	public void errorOperacion(String causaError, String tituloError) {
        JOptionPane.showMessageDialog(null, causaError, tituloError, JOptionPane.ERROR_MESSAGE);
	}
	
	public void operacionCorrecta(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
//METODOS PRIVADOS PARA OBTENER FILAS SELECCIONADAS
	public boolean isItemSeleccionado(String operacion) {
		if (operacion.equals(ACTUALIZAR_PRODUCTO) || operacion.equals(AGREGAR_CARRITO)){
			return -1 != tblProducto.getSelectedRow(); //-1 cuando no hay filas seleccionadas
		}else if (operacion.equals(BORRAR_ITEM)){
			return -1 != tblCarrito.getSelectedRow(); 
		}else if (operacion.equals(FINALIZAR_COMPRA)){
			return -1 != tblCliente.getSelectedRow(); 
		}else return false;
	}
	
	public Object getItemSeleccionado(String operacion){
		if (operacion.equals(ACTUALIZAR_PRODUCTO) || operacion.equals(AGREGAR_CARRITO)){
			int filaSeleccionada = tblProducto.getSelectedRow();
			return tblProducto.getValueAt(filaSeleccionada, -1); // "-1" trae objeto entero.
		} else if(operacion == this.BORRAR_ITEM){
			int filaSeleccionada = tblCarrito.getSelectedRow();
			return tblCarrito.getValueAt(filaSeleccionada, -1);
		}else if(operacion.equals(this.FINALIZAR_COMPRA)){
			int filaSeleccionada = tblCliente.getSelectedRow();
			return tblCliente.getValueAt(filaSeleccionada, -1);
		}else return null;
	}

// METODOS DE SETEAR Y ACTUALIZAR TABLAS
	public void setearCarrito(ArrayList<DetalleVenta> lista) {
		tablaCarrito = new TablaCarrito(lista);
		tblCarrito.setModel(tablaCarrito);
	
		TableColumnModel columnModelCarrito = tblCarrito.getColumnModel();
		columnModelCarrito.getColumn(0).setPreferredWidth(35);
		columnModelCarrito.getColumn(1).setPreferredWidth(140);
		columnModelCarrito.getColumn(2).setPreferredWidth(40);
		columnModelCarrito.getColumn(3).setPreferredWidth(20);
		columnModelCarrito.getColumn(4).setPreferredWidth(35);
		columnModelCarrito.getColumn(5).setPreferredWidth(20);
	}

	public void setearProductos(ArrayList<Producto> productos) {
		tablaProductos = new TablaModel<Producto>("carrito.Producto",productos);
		tblProducto.setModel(tablaProductos);
		
		TableColumnModel columnModelProducto = tblProducto.getColumnModel();
		columnModelProducto.getColumn(0).setPreferredWidth(20);
		columnModelProducto.getColumn(1).setPreferredWidth(200);
		columnModelProducto.getColumn(2).setPreferredWidth(50);
	}

	public void setearClientes(ArrayList<Cliente> clientes) {
		tablaClientes = new TablaModel<Cliente>("carrito.Cliente",clientes);
		tblCliente.setModel(tablaClientes);
		
		TableColumnModel columnModelCliente = tblCliente.getColumnModel();
		columnModelCliente.getColumn(0).setPreferredWidth(20);
		columnModelCliente.getColumn(1).setPreferredWidth(100);
	}	
	
	public void actualizarProductos(ArrayList<Producto> nuevaLista) {
		tablaProductos.actualizarTabla(nuevaLista);
	}
	
	public void actualizarClientes(ArrayList<Cliente> nuevaLista) {
		tablaClientes.actualizarTabla(nuevaLista);
	}
	
	public void actualizarCarrito(){
		tablaCarrito.fireTableDataChanged();
	}

	// METODOS SETTERS Y GETTERS DE VALORES INGRESADOS POR USUARIO
	
	public void setValoresDefectoProducto(String codigo, String descripcion,String precio) {
		ventanaProducto.txtCodigo.setText(codigo);
		ventanaProducto.txtDescripcion.setText(descripcion);
		ventanaProducto.txtPrecio.setText(precio);
	}
	
	public void setValoresDefectoCliente(String codigo, String nombre) {
		ventanaCliente.setTextCodigo(codigo);
		ventanaCliente.setTextNombre(nombre);
	}

	public void setValoresDefectoCarrito(String descuento,String cantidad) {
		ventanaCarrito.setTextDescuento(descuento);
		ventanaCarrito.setTextCantidad(cantidad);
	}
	
	public String getTextDescripcionProducto() {
		return ventanaProducto.txtDescripcion.getText();
	}

	public String getTextPrecioProducto() {
		return ventanaProducto.txtPrecio.getText();
	}

	public String getTextCodigoProducto() {
		return ventanaProducto.txtCodigo.getText();
	}

	public String getTextNombreCliente(){
		return ventanaCliente.getTextNombre();
	}
	
	public String getTextDescuentoCarrito(){
		return ventanaCarrito.getTextDescuento();
	}
	public String getTextCantidadCarrito(){
		return ventanaCarrito.getTextCantidad();
	}
}