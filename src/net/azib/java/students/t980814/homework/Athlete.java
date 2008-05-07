package net.azib.java.students.t980814.homework;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Athlete
 *
 * @author dell
 */
public class Athlete {

	private int athlete_id;
	private String name;
	private Date dob;
	private String country;

	public Athlete(Connection conn,
			       int id) throws SQLException {
		PreparedStatement athlete_statement = conn.prepareStatement("select * from athletes where id = ?");
		athlete_statement.setInt(1, id);
		ResultSet rs = athlete_statement.executeQuery();
		while (rs.next()) {
			this.athlete_id = id;
			this.dob = rs.getDate("dob");
			try {
				this.name = new String(rs.getBytes("name"), "UTF-8");
				this.country = new String(rs.getBytes("country_code"), "UTF-8");
			}
			catch (UnsupportedEncodingException e) {
				System.out.println("Unsupported charset in athlete data");
			}
		}
		rs.close();
	}
	
	@Override
	public String toString() {
		final String COMMA = ",";
		StringBuilder sb = new StringBuilder();
		sb.append("\"").append(name).append("\"").append(COMMA);
		sb.append(dob).append(COMMA);
		sb.append(country); 
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return athlete_id;
	}
}