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

public class LibroDAO implements OperacionesCRUD<Libro> {
	Connection conex;

	@Override
	public boolean insertarConID(Libro l) {
		boolean ret = false;

		String consultaInsertStr1 = "insert into trabajos(idTrabajo, fechaSolicitud, fechaEntrega, tipoRelieve, idCliente, idMaquina) values (?,?,?,?,?,?)";
		;
		String consultaInsertStr3 = "insert into libros(idLibro, colorTapa, numCopiasLibro, idTrabajo, idCliente) values (?,?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			pstmt.setLong(1, l.getIdTrabajo());
			java.sql.Date fechaSolicitudSQL = java.sql.Date.valueOf(l.getFechaSolicitud());
			java.sql.Date fechaEntregaSQL = java.sql.Date.valueOf(l.getFechaEntrega());
			pstmt.setDate(2, fechaSolicitudSQL);
			pstmt.setDate(3, fechaEntregaSQL);
			pstmt.setString(4, l.getTipoRelieve());
			pstmt.setLong(5, Long.getLong(String.valueOf(l.getIdCliente())));
			pstmt.setLong(6, Long.getLong(String.valueOf(l.getIdMaquina())));
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				PreparedStatement pstmt2 = conex.prepareStatement(consultaInsertStr3);
				pstmt2.setLong(1, l.getIdLibro());
				pstmt2.setString(2, l.getColorTapa());
				pstmt2.setLong(3, l.getNumCopiasLibro());
				pstmt2.setLong(4, l.getIdTrabajo());
				pstmt2.setLong(5, l.getIdCliente());
				int resultadoInsercion2 = pstmt2.executeUpdate();
				if (resultadoInsercion2 == 1) {
					System.out.println("Se ha insertado correctamente el nuevo Libro.");
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
	public long insertarSinID(Libro l) {
		long ret = -1;

		String consultaInsertStr1 = "insert into trabajos(nombre, telefono, fechanac, nifnie) values (?,?,?,?)";
		String consultaInsertStr3 = "insert into libros(colorTapa, numCopiasLibro, idTrabajo, idCliente) values (?,?,?,?)";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			java.sql.Date fechaSolicitudSQL = java.sql.Date.valueOf(l.getFechaSolicitud());
			java.sql.Date fechaEntregaSQL = java.sql.Date.valueOf(l.getFechaEntrega());
			pstmt.setDate(1, fechaSolicitudSQL);
			pstmt.setDate(2, fechaEntregaSQL);
			pstmt.setString(3, l.getTipoRelieve());
			pstmt.setLong(4, Long.getLong(String.valueOf(l.getIdCliente())));
			pstmt.setLong(5, Long.getLong(String.valueOf(l.getIdMaquina())));
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT idTrabajo FROM trabajos WHERE (fechaSolicitufd=? AND fechaEntrega=? AND tipoRelieve=? idMaquina=? AND idCliente=? "
						+ "AND direccion=?)";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				pstmt.setDate(1, fechaSolicitudSQL);
				pstmt.setDate(2, fechaEntregaSQL);
				pstmt.setString(3, l.getTipoRelieve());
				pstmt.setLong(4, Long.getLong(String.valueOf(l.getIdCliente())));
				pstmt.setLong(5, Long.getLong(String.valueOf(l.getIdMaquina())));
				ResultSet result = pstmt2.executeQuery();
				while (result.next()) {
					long idTrabajo = result.getLong("id");
					if (idTrabajo != -1) {
						PreparedStatement pstmt21 = conex.prepareStatement(consultaInsertStr3);
						pstmt2.setString(1, l.getColorTapa());
						pstmt2.setLong(2, l.getNumCopiasLibro());
						pstmt2.setLong(3, l.getIdTrabajo());
						pstmt2.setLong(4, l.getIdCliente());
						int resultadoInsercion2 = pstmt21.executeUpdate();
						if (resultadoInsercion2 == 1) {
							String consultaSelect2 = "SELECT id FROM libros WHERE (colorTapa=? AND numCopiasLibro=? AND idTrabajo=? AND idCliente=?)";
							PreparedStatement pstmt3 = conex.prepareStatement(consultaSelect2);
							pstmt3.setString(1, l.getColorTapa());
							pstmt3.setLong(2, l.getNumCopiasLibro());
							pstmt3.setLong(3, l.getIdTrabajo());
							pstmt3.setLong(4, l.getIdCliente());
							ResultSet result3 = pstmt3.executeQuery();
							while (result3.next()) {
								long idlibro = result3.getLong("idLibro");
								if (idlibro != -1) {
									System.out
											.println("Se ha insertado correctamente el nuevo Libro de id: " + idlibro);
									if (conex != null)
										conex.close();
									return idlibro;
								}
							}

						}
					}

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
	public Libro buscarPorID(long idLibro) {
		Libro ret = null;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "select * FROM rotulos WHERE id=?";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, idLibro);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Libro libro;
				long idBD = result.getLong("idLibro");
				String colorTapa = result.getString("colorTapa");
				int numCopiasLibro = result.getInt("numCopiasLibro");
				long idTrabajo = result.getLong("idTrabajo");
				long idCliente = result.getLong("idCliente");

				ret = new Libro();
				ret.setIdLibro(idBD);
				ret.setColorTapa(colorTapa);
				ret.setNumCopiasLibro(numCopiasLibro);
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
	public Collection<Libro> buscarTodos() {
		List<Libro> libros = new ArrayList<>();
		String consultaInsertStr = "select * FROM libros";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Libro libro;
				long idBD = result.getLong("idLibro");
				String colorTapa = result.getString("colorTapa");
				int numCopiasLibro = result.getInt("numCopiasLibro");
				long idTrabajo = result.getLong("idTrabajo");
				long idCliente = result.getLong("idCliente");

				libro = new Libro();

				libro.setIdLibro(idBD);
				libro.setColorTapa(colorTapa);
				libro.setNumCopiasLibro(numCopiasLibro);
				libro.setIdCliente(idCliente);
				libro.setIdTrabajo(idTrabajo);

				libros.add(libro);
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
		return libros;
	}

	@Override
	public boolean modificar(Libro l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Libro l) {
		// TODO Auto-generated method stub
		return false;
	}

}
