package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Aspirante;

public class AspiranteDAO {
	private DbConnection conn;
	
	public AspiranteDAO(DbConnection conn) {
		this.conn = conn;
	}
	
	public Aspirante getDatosAspirante(String strNumeroDocumento) {
		String Lsql = "SELECT UPAC_IDENTIFICACION, UPAC_PRIMER_NOMBRE, UPAC_SEGUNDO_NOMBRE, UPAC_PRIMER_APELLIDO, UPAC_SEGUNDO_APELLIDO, UPAC_AC, UPAC_NUEVO_AC, UPAC_FECHA_UPDATE";
		Lsql += " FROM "; 
        Lsql += " DESARROLLO.UPDATE_AC_UA ";
		Lsql += " WHERE UPAC_IDENTIFICACION = '"+strNumeroDocumento+"'";
        
		System.out.println("Esta es ::> "+ Lsql);
        Aspirante aspirante = null;
        PreparedStatement pd;
        
        try {
			pd = conn.getConnection().prepareStatement(Lsql);
			ResultSet rs = pd.executeQuery();
			
			while (rs.next()) {
				aspirante = new Aspirante();
				aspirante.setStrFechaUpdate(rs.getString("UPAC_FECHA_UPDATE"));
				aspirante.setStrNumeroDocumento(rs.getString("UPAC_IDENTIFICACION"));
				aspirante.setStrPrimerApellido(rs.getString("UPAC_PRIMER_APELLIDO"));
				aspirante.setStrPrimerNombre(rs.getString("UPAC_PRIMER_NOMBRE"));
				aspirante.setStrSegundoApellido(rs.getString("UPAC_SEGUNDO_APELLIDO"));
				aspirante.setStrSegundoNombre(rs.getString("UPAC_SEGUNDO_NOMBRE"));
				aspirante.setStrAc(rs.getString("UPAC_AC"));
				aspirante.setStrNuevoAc(rs.getString("UPAC_NUEVO_AC"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
        return aspirante;
	}
	
	public boolean updateInformacionAspirante(Aspirante aspirante_p) {
		String Lsql = "UPDATE DESARROLLO.UPDATE_AC_UA SET UPAC_NUEVO_AC = ? , UPAC_FECHA_UPDATE = sysdate WHERE UPAC_IDENTIFICACION = ?";
		try {
			PreparedStatement ps = conn.getConnection().prepareStatement(Lsql);
			ps.setString(1, aspirante_p.getStrNuevoAc());
			ps.setString(2, aspirante_p.getStrNumeroDocumento());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.print("Soy Batman ::> updateInformacionAspirante ::> Error ::> " + e.getMessage());
			return false;
		}
	}
}
