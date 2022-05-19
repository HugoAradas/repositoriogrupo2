package ventanas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JTextField;

import dao.ClienteDAO;
import entidades.Cliente;
import utils.ConexBD;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class VentanaCliente extends JPanel {
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private final ButtonGroup buttonFIN = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public VentanaCliente() {
		setLayout(null);

		JLabel lblVentanacliente = new JLabel("Ventana NuevoCliente");
		lblVentanacliente.setSize(999, 14);
		lblVentanacliente.setLocation(new Point(0, 0));
		lblVentanacliente.setBackground(Color.WHITE);
		lblVentanacliente.setForeground(Color.RED);
		lblVentanacliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		add(lblVentanacliente);

		JLabel lblNombre = new JLabel("Nombre* :");
		lblNombre.setBounds(32, 77, 112, 41);
		add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(138, 87, 253, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido* :");
		lblApellido.setBounds(32, 168, 112, 41);
		add(lblApellido);

		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(138, 178, 253, 20);
		add(textFieldApellido);
		textFieldApellido.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente nuevo = new Cliente();
				boolean valido = false;
				String titulo;
				String msj;
				String errores = "";
				String nombre = getTextFieldNombre().getText();
				valido = validacion.validador.validarnombre(nombre);
				if (!valido)
					errores += "/n el nombre introducido es incorrecto";
				valido = false;
				lblNombre.setForeground(Color.red);
				String apellidos = getTextFieldApellido().getText();
				valido = validacion.validador.validarapellido(apellidos);
				if (!valido)
					errores += "/n el apellido introducido es incorrecto";
				lblApellido.setForeground(Color.red);
				nuevo.setNombre(nombre);
				nuevo.setApellido(apellidos);

				int opcion = JOptionPane.showConfirmDialog(null,
						"�Son correctos los datos del nuevo cliente" + nuevo.toString(),
						"Confirmar datos del nuebo Cliente", JOptionPane.YES_NO_OPTION);
				if (opcion == JOptionPane.NO_OPTION) {
					return;
				}
				boolean exportardoOK = false;
				ClienteDAO cdao = new ClienteDAO(ConexBD.establecerConexion());
				long idclientenuevo = cdao.insertarSinID(nuevo);
				if (idclientenuevo <= 0) {
					titulo = "ERROR AL INSERTAR NUEVO CLIENTE";
					msj = "HUBO UN ERROR Y NO SE HA INSERTADO";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);

				} else {
					nuevo.setIdCliente(idclientenuevo);
					titulo = "Nuevo Cliente insertado en la BD";
					msj = "Se ha insertado correctamente el nuevo Cliente:\n" + nuevo.toString();
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);

					File f = new File("" + nuevo.getNombre() + ".dat");
					FileOutputStream fo;
					try {
						fo = new FileOutputStream(f);
						ObjectOutputStream oos = new ObjectOutputStream(fo);
						oos.writeLong(idclientenuevo);
						oos.writeObject(nombre);
						oos.writeObject(apellidos);

					} catch (FileNotFoundException exc) {
						System.out.println("Se ha producido una FileNotFoundException:" + exc.getMessage());
						exc.printStackTrace();
					} catch (IOException ex) {
						System.out.println("Se ha producido una IOException:" + ex.getMessage());
						ex.printStackTrace();
					}

				}
				ConexBD.cerrarConexion();
			}
		});

		buttonFIN.add(btnAceptar);
		btnAceptar.setBounds(708, 482, 89, 23);

		add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String titulo = "Cerrar ventana";
				String msj = "¿Realmente desea cerrar la ventana?";
				int opcion = JOptionPane.showConfirmDialog(null, msj, titulo, JOptionPane.OK_CANCEL_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					/// Aqui se redirigiría al usuario hacia la pantalla principal o se saldria
					System.exit(0); /// SALIR directamente
				}
			}
		});
		buttonFIN.add(btnCancelar);
		btnCancelar.setBounds(843, 482, 89, 23);
		add(btnCancelar);

	}

	public JTextField getTextFieldNombre() {
		// TODO Auto-generated method stub
		return textFieldNombre;
	}

	public JTextField getTextFieldApellido() {
		// TODO Auto-generated method stub
		return textFieldApellido;
	}
}
