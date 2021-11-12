package unisa.studenti.it.Operazioni;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Result;
import com.mysql.cj.xdevapi.Statement;

import unisa.studenti.it.Entity.DBMCinema;

public class Controll {

	public Controll() {
		// TODO Auto-generated constructor stub
	}
	public static void controllProgrammazioni() throws SQLException {
		String query = "delete from programmazioni where dfine<NOW()";
		PreparedStatement stm=DBMCinema.getConn().prepareStatement(query);
		stm.executeUpdate();
	}

}
