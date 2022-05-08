package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.Lote;
import utils.ConexBD;

public class LoteDAO implements OperacionesCRUD<Lote> {
	Connection conex;

	public LoteDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insertarConID(Lote l) {
		boolean ret = false;
		String consultaInsertStr = "insert into lotes(id,nombre,idDep) values (?,?,?,?) ";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareCall(consultaInsertStr);
			pstmt.setLong(1, l.getIdLote());
			pstmt.setString(2, l.getnombreLote());
			pstmt.setLong(3, l.getDepartamento().getidDep());

			int resultadoInsercion = pstmt.executeUpdate();

			if (resultadoInsercion == 1) {
				System.out.println("Se ha ejectuado la insercion");
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
	public long insertarSinID(Lote l) {
		long ret = -1;
		String consultaInsertStr = "insert into lotes(nombre,idDepartamento";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setString(1, l.getnombreLote());
			pstmt.setLong(2, l.getDepartamento().getidDep());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "select id from lotes where (nombre =? and idDep=?) ";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaSelect);
				pstmt2.setString(1, l.getnombreLote());
				pstmt2.setLong(2, l.getDepartamento().getidDep());
				ResultSet result = pstmt.executeQuery();
				while (result.next()) {
					long idLote = result.getLong("id");
					if (idLote != -1) {
						System.out.println("SE HA INSERTADO CORRECTAMENTE");
						if (conex != null)
							conex.close();
						return idLote;
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
	public Lote buscarPorID(long id) {
		Lote ret = null;
		String consultaInsertStr = "select * from lotes where id=?";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("id");
				long idDepartamento = result.getLong("idDepartamento");
				String nombreLote = result.getString("nombreLote");
				ret = new Lote();
				ret.setIdLote(idBD);
				ret.setnombreLote(nombreLote);

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
	public Collection<Lote> buscarTodos() {
		List<Lote> todos = new ArrayList<>();
		String consultaInsertStr = "select * from  lotes ";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Lote lote;
				long idBD = result.getLong("id");
				long idDep = result.getLong("idDep");
				String nombre = result.getString("nombre");
				lote = new Lote();
				lote.setIdLote(idBD);
				lote.setnombreLote(nombre);
				todos.add(lote);

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

		return null;
	}

	@Override
	public boolean modificar(Lote elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Lote elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
