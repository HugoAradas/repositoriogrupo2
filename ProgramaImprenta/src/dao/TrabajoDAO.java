package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import utils.*;
import entidades.*;
import utils.ConexBD;
import utils.Datos;

public class TrabajoDAO implements OperacionesCRUD<Trabajo> {
	Connection conex;

	@Override
	public boolean insertarConID(Trabajo t) {
		boolean ret = false;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "insert into trabajos(idTrabajo, fechaSolicitud, fechaEntrega, tipoRelieve, idCliente, idMaquina) values (?,?,?,?,?,?)";

		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);

			pstmt.setLong(1, t.getIdTrabajo());
			java.sql.Date fechaSolicitudSQL = java.sql.Date.valueOf(t.getFechaSolicitud());
			java.sql.Date fechaEntregaSQL = java.sql.Date.valueOf(t.getFechaEntrega());
			pstmt.setDate(2, fechaSolicitudSQL);
			pstmt.setDate(3, fechaEntregaSQL);
			pstmt.setString(4, t.getTipoRelieve());
			pstmt.setLong(5, Long.getLong(String.valueOf(t.getIdCliente())));
			pstmt.setLong(6, Long.getLong(String.valueOf(t.getIdMaquina())));
			int resultadoInsercion = pstmt.executeUpdate();
			ret = (resultadoInsercion == 1);
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public long insertarSinID(Trabajo t) {
		long ret = -1;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "insert into trabajos(fechaSolicitud, fechaEntrega, tipoRelieve, idCliente, idMaquina) values (?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			java.sql.Date fechaSolicitudSQL = java.sql.Date.valueOf(t.getFechaSolicitud());
			java.sql.Date fechaEntregaSQL = java.sql.Date.valueOf(t.getFechaEntrega());
			pstmt.setDate(1, fechaSolicitudSQL);
			pstmt.setDate(2, fechaEntregaSQL);
			pstmt.setString(3, t.getTipoRelieve());
			pstmt.setLong(4, Long.getLong(String.valueOf(t.getIdCliente())));
			pstmt.setLong(5, Long.getLong(String.valueOf(t.getIdMaquina())));
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT idTrabajo FROM trabajos WHERE (fechaSolicitufd=? AND fechaEntrega=? AND tipoRelieve=? idMaquina=? AND idCliente=? "
						+ "AND direccion=?)";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				pstmt.setDate(1, fechaSolicitudSQL);
				pstmt.setDate(2, fechaEntregaSQL);
				pstmt.setString(3, t.getTipoRelieve());
				pstmt.setLong(4, Long.getLong(String.valueOf(t.getIdCliente())));
				pstmt.setLong(5, Long.getLong(String.valueOf(t.getIdMaquina())));
				ResultSet result = pstmt2.executeQuery();
				while (result.next()) {
					long idTrabajo = result.getLong("id");
					if (idTrabajo != -1)
						ret = idTrabajo;
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
	public Trabajo buscarPorID(long idTrabajo) {
		Trabajo ret = null;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "select * FROM managers WHERE id=?";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, idTrabajo);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("idTrabajo");
				java.sql.Date fechaSolicitud = java.sql.Date.valueOf(result.getString("fechaSolicitud"));
				java.sql.Date fechaEntrega = java.sql.Date.valueOf(result.getString("fechaEntrega"));
				String tipoRelieve = result.getString("tipoReleive");
				long idCliente = result.getLong("idCliente");
				long idMaquina = result.getLong("idMaquina");
				ret = new Trabajo();
				ret.setIdTrabajo(idBD);
				ret.setFechaSolicitud(fechaSolicitud.toLocalDate());
				ret.setFechaEntrega(fechaEntrega.toLocalDate());
				ret.setTipoRelieve(tipoRelieve);
				ret.setIdCliente(idCliente);
				ret.setIdMaquina(idMaquina);
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
	public Collection<Trabajo> buscarTodos() {
		List<Trabajo> trabajos = new ArrayList<>();
		String consultaInsertStr = "select * FROM atletas";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Trabajo trabajo;
				long idBD = result.getLong("idTrabajo");
				java.sql.Date fechaSolicitud = java.sql.Date.valueOf(result.getString("fechaSolicitud"));
				java.sql.Date fechaEntrega = java.sql.Date.valueOf(result.getString("fechaEntrega"));
				String tipoRelieve = result.getString("tipoReleive");
				long idCliente = result.getLong("idCliente");
				long idMaquina = result.getLong("idMaquina");

				trabajo = new Trabajo();

				trabajo.setIdTrabajo(idBD);
				trabajo.setFechaSolicitud(fechaSolicitud.toLocalDate());
				trabajo.setFechaEntrega(fechaEntrega.toLocalDate());
				trabajo.setTipoRelieve(tipoRelieve);
				trabajo.setIdCliente(idCliente);
				trabajo.setIdMaquina(idMaquina);

				trabajos.add(trabajo);
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
		return trabajos;
	}

	@Override
	public boolean modificar(Trabajo elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Trabajo elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
