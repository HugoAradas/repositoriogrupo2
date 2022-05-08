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

public class PosterDAO implements OperacionesCRUD<Poster> {
	Connection conex;

	@Override
	public boolean insertarConID(Poster p) {
		boolean ret = false;

		String consultaInsertStr1 = "insert into trabajos(idTrabajo, fechaSolicitud, fechaEntrega, tipoRelieve, idCliente, idMaquina) values (?,?,?,?,?,?)";
		;
		String consultaInsertStr3 = "insert into poster(idPoster, ancho, alto, numCopiasPoster, idTrabajo, idCliente) values (?,?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			pstmt.setLong(1, p.getIdTrabajo());
			java.sql.Date fechaSolicitudSQL = java.sql.Date.valueOf(p.getFechaSolicitud());
			java.sql.Date fechaEntregaSQL = java.sql.Date.valueOf(p.getFechaEntrega());
			pstmt.setDate(2, fechaSolicitudSQL);
			pstmt.setDate(3, fechaEntregaSQL);
			pstmt.setString(4, p.getTipoRelieve());
			pstmt.setLong(5, Long.getLong(String.valueOf(p.getIdCliente())));
			pstmt.setLong(6, Long.getLong(String.valueOf(p.getIdMaquina())));
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				PreparedStatement pstmt2 = conex.prepareStatement(consultaInsertStr3);
				pstmt2.setLong(1, p.getIdPoster());
				pstmt2.setDouble(2, p.getAncho());
				pstmt2.setDouble(3, p.getAlto());
				pstmt2.setLong(4, p.getNumCopiasPoster());
				pstmt2.setLong(5, p.getIdTrabajo());
				pstmt2.setLong(6, p.getIdCliente());
				int resultadoInsercion2 = pstmt2.executeUpdate();
				if (resultadoInsercion2 == 1) {
					System.out.println("Se ha insertado correctamente el nuevo Poster.");
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
	public long insertarSinID(Poster p) {
		long ret = -1;

		String consultaInsertStr1 = "insert into trabajos(nombre, telefono, fechanac, nifnie) values (?,?,?,?)";
		String consultaInsertStr3 = "insert into poster(ancho, alto, numCopiasPoster, idTrabajo, idCliente) values (?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			java.sql.Date fechaSolicitudSQL = java.sql.Date.valueOf(p.getFechaSolicitud());
			java.sql.Date fechaEntregaSQL = java.sql.Date.valueOf(p.getFechaEntrega());
			pstmt.setDate(1, fechaSolicitudSQL);
			pstmt.setDate(2, fechaEntregaSQL);
			pstmt.setString(3, p.getTipoRelieve());
			pstmt.setLong(4, Long.getLong(String.valueOf(p.getIdCliente())));
			pstmt.setLong(5, Long.getLong(String.valueOf(p.getIdMaquina())));
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT idTrabajo FROM trabajos WHERE (fechaSolicitufd=? AND fechaEntrega=? AND tipoRelieve=? idMaquina=? AND idCliente=? "
						+ "AND direccion=?)";
				PreparedStatement pstmt1 = conex.prepareStatement(consultaSelect);
				pstmt.setDate(1, fechaSolicitudSQL);
				pstmt.setDate(2, fechaEntregaSQL);
				pstmt.setString(3, p.getTipoRelieve());
				pstmt.setLong(4, Long.getLong(String.valueOf(p.getIdCliente())));
				pstmt.setLong(5, Long.getLong(String.valueOf(p.getIdMaquina())));
				ResultSet result = pstmt1.executeQuery();
				while (result.next()) {
					long idTrabajo = result.getLong("id");
					if (idTrabajo != -1) {
						PreparedStatement pstmt2 = conex.prepareStatement(consultaInsertStr3);
						pstmt2.setDouble(1, p.getAncho());
						pstmt2.setDouble(2, p.getAlto());
						pstmt2.setInt(3, p.getNumCopiasPoster());
						pstmt2.setLong(4, p.getIdTrabajo());
						pstmt2.setLong(5, p.getIdCliente());
						int resultadoInsercion2 = pstmt2.executeUpdate();
						if (resultadoInsercion2 == 1) {
							String consultaSelect2 = "SELECT id FROM posters WHERE (ancho=? AND alto=? AND numCopiasPoster=? AND idTrabajo=? AND idCliente=?)";
							PreparedStatement pstmt3 = conex.prepareStatement(consultaSelect2);
							pstmt3.setDouble(1, p.getAncho());
							pstmt3.setDouble(2, p.getAlto());
							pstmt3.setInt(3, p.getNumCopiasPoster());
							pstmt3.setLong(4, p.getIdTrabajo());
							pstmt3.setLong(5, p.getIdCliente());
							ResultSet result3 = pstmt3.executeQuery();
							while (result3.next()) {
								long idposter = result3.getLong("idposter");
								if (idposter != -1) {
									System.out
											.println("Se ha insertado correctamente el nuevo Libro de id: " + idposter);
									if (conex != null)
										conex.close();
									return idposter;
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
	public Poster buscarPorID(long idPoster) {
		Poster ret = null;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "select * FROM posters WHERE id=?";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, idPoster);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Poster poster;
				long idBD = result.getLong("idPoster");
				float ancho = result.getFloat("ancho");
				float alto = result.getFloat("alto");
				int numCopiasPoster = result.getInt("numCopiasPoster");
				long idTrabajo = result.getLong("idTrabajo");
				long idCliente = result.getLong("idCliente");

				ret.setIdPoster(idBD);
				ret.setAncho(ancho);
				ret.setAlto(alto);
				ret.setNumCopiasPoster(numCopiasPoster);
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
	public Collection<Poster> buscarTodos() {
		List<Poster> posters = new ArrayList<>();
		String consultaInsertStr = "select * FROM posters";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Poster poster;
				long idBD = result.getLong("idPoster");
				float ancho = result.getFloat("ancho");
				float alto = result.getFloat("alto");
				int numCopiasPoster = result.getInt("numCopiasPoster");
				long idTrabajo = result.getLong("idTrabajo");
				long idCliente = result.getLong("idCliente");

				poster = new Poster();

				poster.setIdPoster(idBD);
				poster.setAncho(ancho);
				poster.setAlto(alto);
				poster.setNumCopiasPoster(numCopiasPoster);
				poster.setIdCliente(idCliente);
				poster.setIdTrabajo(idTrabajo);

				posters.add(poster);
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
		return posters;
	}

	@Override
	public boolean modificar(Poster p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Poster p) {
		// TODO Auto-generated method stub
		return false;
	}

}
