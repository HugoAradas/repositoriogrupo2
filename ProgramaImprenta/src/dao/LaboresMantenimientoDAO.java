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

import entidades.LaboresMantenimiento;
import utils.ConexBD;

public class LaboresMantenimientoDAO implements OperacionesCRUD<LaboresMantenimiento> {
	Connection conex;

	public LaboresMantenimientoDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(LaboresMantenimiento l) {
		boolean ret = false;
		String consultaInsertStr = "insert into labores (id,fechaReal,descripcion,idMaquina,idOperario) values (?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, l.getIdLab());
			java.sql.Date fechaSQL = java.sql.Date.valueOf(l.getFechaReal());
			pstmt.setDate(2, fechaSQL);
			pstmt.setString(3, l.getDescripcion());
			pstmt.setLong(4, l.getMaquina().getId_maquina());
			pstmt.setLong(5, l.getOperario().getIdOperario());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				System.out.println("Se ha insertado correctamente el insert");
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
	public long insertarSinID(LaboresMantenimiento l) {
		long ret = -1;

		String consultaInsertStr1 = " insert into labores (fechaReal,descripcion) values (?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			java.sql.Date fechaSQL = java.sql.Date.valueOf(l.getFechaReal());
			pstmt.setDate(1, fechaSQL);
			pstmt.setString(2, l.getDescripcion());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "select id from labores where (fechaReal = ? AND descripcion=?"
						+ "AND idMaquina=? AND idOperario=?)";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				pstmt2.setDate(1, fechaSQL);
				pstmt2.setString(2, l.getDescripcion());
				pstmt2.setLong(3, l.getMaquina().getId_maquina());
				pstmt2.setLong(4, l.getOperario().getIdOperario());
				ResultSet result = pstmt.executeQuery();

				while (result.next()) {
					long idLab = result.getLong("id");
					if (idLab != -1) {
						System.out.println("Se ha insertado correctamente en la base de datos");
						if (conex != null)
							conex.close();
						return idLab;
					}
				}
				result.close();
				pstmt.close();
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
	public LaboresMantenimiento buscarPorID(long id) {
		LaboresMantenimiento ret = null;
		String ConsultaInsertStr = "select * from labores where id=?";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(ConsultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("id");
				long idMaquina = result.getLong("idMaquina");
				long idOperario = result.getLong("idOperario");
				java.sql.Date fechaReal = result.getDate("fechaReal");
				String descripcion = result.getString("descripción");
				ret = new LaboresMantenimiento();
				ret.setIdLab(idBD);
				ret.setDescripcion(descripcion);

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
	public Collection<LaboresMantenimiento> buscarTodos() {
		List<LaboresMantenimiento> todos = new ArrayList<>();
		String consultaInsertStr = "select * from labores";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				LaboresMantenimiento labo = null;
				;
				long idBD = result.getLong("id");
				long idMaquina = result.getLong("idMaquina");
				long idOperario = result.getLong("idOperario");
				LocalDate fechaReal = labo.getFechaReal();
				String descripcion = result.getString("Descripcion");

				labo = new LaboresMantenimiento();
				labo.setIdLab(idBD);
				labo.setFechaReal(fechaReal);
				labo.setDescripcion(descripcion);

				todos.add(labo);
			}
			if (conex != null)
				conex.close();

		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
		}
		return todos;
	}

	@Override
	public boolean modificar(LaboresMantenimiento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(LaboresMantenimiento elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
