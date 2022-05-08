package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.Operario;
import utils.ConexBD;

public class OperarioDAO implements OperacionesCRUD<Operario> {
	Connection conex;

	public OperarioDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Operario o) {
		boolean ret = false;

		String consultaInsertStr1 = "insert into operarios(idoperario, nif, nombre, apellido, numtelefono, direccion, senior, iddep) values (?,?,?,?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			pstmt.setLong(1, o.getIdOperario());
			pstmt.setString(2, o.getNIF());
			pstmt.setString(3, o.getNombre());
			pstmt.setString(4, o.getApellido());
			pstmt.setLong(5, o.getNumTelefono());
			pstmt.setString(6, o.getDireccion());
			pstmt.setBoolean(7, o.isSenior());
			pstmt.setFloat(8, o.getidDep().getidDep());
			int resultadoInsercion = pstmt.executeUpdate();
			ret = (resultadoInsercion == 1);

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		}

		return ret;
	}

	@Override
	public long insertarSinID(Operario o) {
		long ret = -1;
		
		String consultaInsertStr = "insert into operarios(nif, nombre, apellido, numtelefono, direccion, senior, iddep) values (?,?,?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setString(2, o.getNIF());
			pstmt.setString(3, o.getNombre());
			pstmt.setString(4, o.getApellido());
			pstmt.setLong(5, o.getNumTelefono());
			pstmt.setString(6, o.getDireccion());
			pstmt.setBoolean(7, o.isSenior());
			pstmt.setFloat(8, o.getidDep().getidDep());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT idoperario FROM operarios WHERE (nif=? AND nombre=? AND apellido=? AND numtelefono=? AND direccion=? AND senior=? AND idep=?)";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				pstmt2.setString(2, o.getNIF());
				pstmt2.setString(3, o.getNombre());
				pstmt2.setString(4, o.getApellido());
				pstmt2.setLong(5, o.getNumTelefono());
				pstmt2.setString(6, o.getDireccion());
				pstmt2.setBoolean(7, o.isSenior());
				pstmt2.setFloat(8, o.getidDep().getidDep());
				
				ResultSet result = pstmt2.executeQuery();
				while (result.next()) {
					long id = result.getLong("idoperario");
					if (id != -1)
						ret = id;
				}
				result.close();
				pstmt2.close();
				if (conex != null)
					conex.close();
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return -1;
		}

		return ret;
	}
	
	@Override
	public Operario buscarPorID(long idOperario) {
		Operario ret = null;
		String consultaInsertStr = "select * FROM operarios WHERE idoperario=?";
		try {
			if (this.conex == null || this.conex.isClosed())
				conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, idOperario);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("idoperario");
				String nif = result.getString("nif");
				String nombre = result.getString("nombre");
				String apellido = result.getString("apellido");
				long numtelefono = result.getLong("numtelefono");
				String direccion = result.getString("direccion");
				boolean senior = result.getBoolean("senior");
				ret = new Operario();
				ret.setIdOperario(idBD);
				ret.setNIF(nif);
				ret.setNombre(nombre);
				ret.setApellido(apellido);
				ret.setNumTelefono(numtelefono);
				ret.setDireccion(direccion);
				ret.setSenior(senior);
			}
			if (conex != null)
				conex.close();
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
	public Collection<Operario> buscarTodos() {
		List<Operario> ret = new ArrayList<>();
		String consultaInsertStr = "select * FROM operarios";
		try {
			if (this.conex == null || this.conex.isClosed())
				conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Operario o = null;
				
				long idBD = result.getLong("idoperario");
				String nif = result.getString("nif");
				String nombre = result.getString("nombre");
				String apellido = result.getString("apellido");
				long numtelefono = result.getLong("numtelefono");
				String direccion = result.getString("direccion");
				boolean senior = result.getBoolean("senior");
				
				o = new Operario();
				o.setIdOperario(idBD);
				o.setNIF(nif);
				o.setNombre(nombre);
				o.setApellido(apellido);
				o.setNumTelefono(numtelefono);
				o.setDireccion(direccion);
				o.setSenior(senior);
				
				ret.add(o);
			}
			if (conex != null)
				conex.close();
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
	public boolean modificar(Operario elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Operario elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}

