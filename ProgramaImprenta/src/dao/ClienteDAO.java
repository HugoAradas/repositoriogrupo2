package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.Cliente;
import utils.ConexBD;
import utils.Datos;

public class ClienteDAO implements OperacionesCRUD<Cliente> {
	Connection conex;

	public ClienteDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Cliente c) {
		boolean ret = false;
		String consultaInsertSTR = "insert into clientes(id,nombre,apellido) values (?,?,?)";

		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertSTR);
			pstmt.setLong(1, c.getIdCliente());
			pstmt.setString(2, c.getNombre());
			pstmt.setString(3, c.getApellido());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				System.out.println("Se ha insertado correctamente");
				ret = true;
			}
			if (conex != null)
				conex.close();

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return ret;
	}

	@Override
	public long insertarSinID(Cliente c) {
		long ret = -1;
		String consultaInsertStr = " insert into clientes (nombre,apellidos) values (?,?) ";
		try {
			if (this.conex == null || this.conex.isClosed())
				conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setString(1, c.getNombre());
			pstmt.setString(2, c.getApellido());
			int resultadoInsercion = pstmt.executeUpdate();

			if (resultadoInsercion == 1) {
				String consultaSelect = "select idCliente from clientes where (nombre=? and apellidos=?)";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				pstmt2.setString(1, c.getNombre());
				pstmt2.setString(2, c.getApellido());

				ResultSet result = pstmt2.executeQuery();
				while (result.next()) {
					long idCliente = result.getLong("id");
					if (idCliente != -1)
						ret = idCliente;
				}
				result.close();
				pstmt2.close();

			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
			return -1;
		}
		return ret;
	}

	@Override
	public Cliente buscarPorID(long id) {
		Cliente ret = null;

		String consultaInsertStr = "select * from clientes where id=?";
		try {
			if (this.conex == null || this.conex.isClosed())
				conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("id");
				long idCliente = result.getLong("idCliente");
				String Nombre = result.getString("nombre");
				String Apellido = result.getString("apellido");
				ret = new Cliente();
				ret.setIdCliente(idCliente);
				ret.setNombre(Nombre);
				ret.setApellido(Apellido);

			}

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		List<Cliente> todos = new ArrayList<>();
		String consultaInsertStr = "select * from clientes";
		try {
			if (this.conex == null || this.conex.isClosed())
				conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Cliente cliente;
				long idBD = result.getLong("id");
				String Nombre = result.getString("Nombre");
				String Apellido = result.getString("Apellido");
				cliente = new Cliente();
				cliente.setIdCliente(idBD);
				cliente.setNombre(Nombre);
				cliente.setApellido(Apellido);
				todos.add(cliente);
			}
			if (conex != null)
				conex.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		return todos;
	}

	@Override
	public boolean modificar(Cliente elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Cliente elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
