package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.Cliente;
import entidades.Maquina;
import utils.ConexBD;

public class MaquinaDAO implements OperacionesCRUD<Maquina> {
	Connection conex;

	public MaquinaDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Maquina m) {
		boolean ret = false;

		String consultaInsertStr = "insert into maquina (id,fechaCompra,ubicacion,tipoImpresion,modoImpresion,volumenTinta,idlote) values (?,?,?,?,?,?,?) ";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareCall(consultaInsertStr);
			pstmt.setLong(1, m.getIdMaquina());
			java.sql.Date fechaSQL = java.sql.Date.valueOf(m.getFechaCompra());
			pstmt.setDate(2, fechaSQL);
			pstmt.setString(3, m.getUbicacion());
			pstmt.setString(4, m.getTipoImpresion());
			pstmt.setString(5, m.getModoImpresion());
			pstmt.setDouble(6, m.getVolumenTinta());
			pstmt.setLong(7, m.getIdLote().getIdLote());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				System.out.println("Se ha introducido correctamente");
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
	public long insertarSinID(Maquina m) {
		long ret = -1;
		String consultaInsercionStr = "insert into maquinas (fechaCompra,ubicacion,tipoImpresion,modoImpresion,volumenTinta,idlote) values (?,?,?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsercionStr);
			java.sql.Date fechaSQL = java.sql.Date.valueOf(m.getFechaCompra());
			pstmt.setDate(1, fechaSQL);
			pstmt.setString(3, m.getUbicacion());
			pstmt.setString(4, m.getTipoImpresion());
			pstmt.setString(5, m.getModoImpresion());
			pstmt.setDouble(6, m.getVolumenTinta());
			pstmt.setLong(7, m.getIdLote().getIdLote());
			int resultadoInsercion = pstmt.executeUpdate();

			if (resultadoInsercion == 1) {
				String consultaSelect = "Select id from maquinas where (fechaCompra =? and tipoImpresion=?, and modoImpresion=?, and volumenTinta=? "
						+ "and idLote";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				java.sql.Date fechasql2 = java.sql.Date.valueOf(m.getFechaCompra());
				pstmt.setDate(1, fechasql2);
				pstmt.setString(2, m.getUbicacion());
				pstmt.setString(3, m.getModoImpresion());
				pstmt.setDouble(4, m.getVolumenTinta());
				pstmt.setLong(5, m.getIdLote().getIdLote());

				ResultSet result = pstmt2.executeQuery();
				while (result.next()) {
					long id = result.getLong("id");
					if (id != -1)
						ret = id;

				}
				result.close();
				pstmt2.close();
			}
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return -1;
		}
		return ret;
	}

	@Override
	public Maquina buscarPorID(long id) {
		Maquina ret = null;
		String consultaInsertStr = "select * from maquinas where id=?";
		try {
			if (this.conex == null || this.conex.isClosed())
				conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);

			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("id");
				long idLote = result.getLong("idLote");

				String Apellido = result.getString("apellido");
				ret = new Maquina();
				ret.setIdMaquina(idBD);
				ret.setUbicacion("ubicacion");
				ret.setModoImpresion("impresion");

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
	public Collection<Maquina> buscarTodos() {
		List<Maquina> todos = new ArrayList<>();
		String consultaInsertStr = "select * from maquinas ";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Maquina maquina;
				long idBD = result.getLong("id");
				long idLote = result.getLong("idLote");

				String Apellido = result.getString("apellido");
				maquina = new Maquina();
				maquina.setIdMaquina(idBD);
				maquina.setUbicacion("ubicacion");
				maquina.setModoImpresion("impresion");

			}

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
		}
		return todos;
	}

	@Override
	public boolean modificar(Maquina elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Maquina elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
