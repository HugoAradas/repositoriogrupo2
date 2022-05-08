package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.*;
import utils.ConexBD;

public class RotuloDAO implements OperacionesCRUD<Rotulo> {
	Connection conex;

	@Override
	public boolean insertarConID(Rotulo r) {
		boolean ret = false;

		String consultaInsertStr1 = "insert into trabajos(idTrabajo, fechaSolicitud, fechaEntrega, tipoRelieve, idCliente, idMaquina) values (?,?,?,?,?,?)";
		;
		String consultaInsertStr3 = "insert into rotulos(idRotulo, centroComercial, idCliente, idMaquina) values (?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			pstmt.setLong(1, r.getIdTrabajo());
			java.sql.Date fechaSolicitudSQL = java.sql.Date.valueOf(r.getFechaSolicitud());
			java.sql.Date fechaEntregaSQL = java.sql.Date.valueOf(r.getFechaEntrega());
			pstmt.setDate(2, fechaSolicitudSQL);
			pstmt.setDate(3, fechaEntregaSQL);
			pstmt.setString(4, r.getTipoRelieve());
			pstmt.setLong(5, Long.getLong(String.valueOf(r.getIdCliente())));
			pstmt.setLong(6, Long.getLong(String.valueOf(r.getIdMaquina())));
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				PreparedStatement pstmt2 = conex.prepareStatement(consultaInsertStr3);
				pstmt2.setLong(1, r.getIdRotulo());
				pstmt2.setLong(2, r.getIdTrabajo());
				pstmt2.setString(3, r.getCentroComercial());
				pstmt2.setLong(4, r.getIdMaquina());
				pstmt2.setLong(5, r.getIdMaquina());
				int resultadoInsercion2 = pstmt2.executeUpdate();
				if (resultadoInsercion2 == 1) {
					System.out.println("Se ha insertado correctamente el nuevo Rotulo.");
					ret = true;
				}
				if (conex != null)
					conex.close();
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		}

		return ret;
	}

	@Override
	public long insertarSinID(Rotulo r) {
		long ret = -1;

		String consultaInsertStr1 = "insert into trabajos(nombre, telefono, fechanac, nifnie) values (?,?,?,?)";
		String consultaInsertStr3 = "insert into rotulos(centroComercial, idCliente, idMaquina) values (?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			java.sql.Date fechaSolicitudSQL = java.sql.Date.valueOf(r.getFechaSolicitud());
			java.sql.Date fechaEntregaSQL = java.sql.Date.valueOf(r.getFechaEntrega());
			pstmt.setDate(1, fechaSolicitudSQL);
			pstmt.setDate(2, fechaEntregaSQL);
			pstmt.setString(3, r.getTipoRelieve());
			pstmt.setLong(4, Long.getLong(String.valueOf(r.getIdCliente())));
			pstmt.setLong(5, Long.getLong(String.valueOf(r.getIdMaquina())));
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT idTrabajo FROM trabajos WHERE (fechaSolicitufd=? AND fechaEntrega=? AND tipoRelieve=? idMaquina=? AND idCliente=? "
						+ "AND direccion=?)";
				PreparedStatement pstmt1 = conex.prepareStatement(consultaSelect);
				pstmt.setDate(1, fechaSolicitudSQL);
				pstmt.setDate(2, fechaEntregaSQL);
				pstmt.setString(3, r.getTipoRelieve());
				pstmt.setLong(4, Long.getLong(String.valueOf(r.getIdCliente())));
				pstmt.setLong(5, Long.getLong(String.valueOf(r.getIdMaquina())));
				ResultSet result = pstmt1.executeQuery();
				while (result.next()) {
					long idTrabajo = result.getLong("id");
					if (idTrabajo != -1) {
						PreparedStatement pstmt2 = conex.prepareStatement(consultaInsertStr3);
						pstmt2.setString(1, r.getCentroComercial());
						pstmt2.setLong(4, r.getIdTrabajo());
						pstmt2.setLong(5, r.getIdCliente());
						int resultadoInsercion2 = pstmt2.executeUpdate();
						if (resultadoInsercion2 == 1) {
							String consultaSelect2 = "SELECT id FROM rotulos WHERE (centroComercial=? AND idTrabajo=? AND idCliente=?)";
							PreparedStatement pstmt3 = conex.prepareStatement(consultaSelect2);
							pstmt3.setString(1, r.getCentroComercial());
							pstmt3.setLong(4, r.getIdTrabajo());
							pstmt3.setLong(5, r.getIdCliente());
							ResultSet result3 = pstmt3.executeQuery();
							while (result3.next()) {
								long idrotulo = result3.getLong("idrotulo");
								if (idrotulo != -1) {
									System.out.println(
											"Se ha insertado correctamente el nuevo rotulo de id: " + idrotulo);
									if (conex != null)
										conex.close();
									return idrotulo;
								}
							}

						}
					}

				}
				result.close();
				pstmt1.close();
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
	public Rotulo buscarPorID(long idRotulo) {
		Rotulo ret = null;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "select * FROM rotulos WHERE id=?";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, idRotulo);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("idRotulo");
				String centroComercial = result.getString("centroComercial");
				long idTrabajo = result.getLong("idTrabajo");
				long idCliente = result.getLong("idCliente");

				ret = new Rotulo();
				ret.setIdRotulo(idBD);
				ret.setCentroComercial(centroComercial);
				ret.setIdCliente(idCliente);
				ret.setIdTrabajo(idTrabajo);
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
	public Collection<Rotulo> buscarTodos() {
		List<Rotulo> rotulos = new ArrayList<>();
		String consultaInsertStr = "select * FROM rotulos";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Rotulo rotulo;
				long idBD = result.getLong("idRotulo");
				String centroComercial = result.getString("centroComercial");
				long idTrabajo = result.getLong("idTrabajo");
				long idCliente = result.getLong("idCliente");

				rotulo = new Rotulo();

				rotulo.setIdRotulo(idBD);
				rotulo.setCentroComercial(centroComercial);
				rotulo.setIdCliente(idCliente);
				rotulo.setIdTrabajo(idTrabajo);

				rotulos.add(rotulo);
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
		return rotulos;
	}

	@Override
	public boolean modificar(Rotulo elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Rotulo elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
