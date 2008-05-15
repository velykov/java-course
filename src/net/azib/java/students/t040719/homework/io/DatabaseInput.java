package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DatabaseInput - a class for obtaining decathlon results from a database
 *
 * @version 1.0
 * @author Romi Agar
 */
public class DatabaseInput implements DataInput {
	private static final Logger LOG = Logger.getLogger(DatabaseInput.class.getSimpleName());
	
	private String jdbcURL = "jdbc:mysql://srv.azib.net:3306/decathlon";
	private String jdbcUser = "java";
	private String jdbcPassword = "java";
	
	/**
	 * Exiting from program with given error code
	 * @param errorCode error code (int) for exiting
	 */
	void exit(int errorCode) {
		System.exit(errorCode);
	}
	
	/**
	 * @return returns connection to database
	 */
	Connection openConnection() {
		try {
			return DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
		}
		catch (SQLException e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "Could not connect to database.", e);
			else
				LOG.log(Level.SEVERE, "Could not connect to database.");
			exit(4);
		}
		return null;
	}
	
	/**
	 * @param parameters contains competition id or name
	 * @return returns a list of athletes
	 */
	public List<Athlete> getResults(String... parameters){
		List<Athlete> athletes = new ArrayList<Athlete>();
		if (parameters.length == 0){
			LOG.severe("No competition id nor name given.");
			exit(5);
		} else {
			final String sql = "SELECT A.name, A.dob, A.country_code, R.race_100m, " +
					"R.long_jump, R.shot_put, R.high_jump, R.race_400m, R.hurdles_110m, " +
					"R.discus_throw, R.pole_vault, R.javelin_throw, R.race_1500m FROM " +
					"results AS R INNER JOIN athletes AS A on A.id=R.athlete_id WHERE " +
					"competition_id = (SELECT id FROM competitions WHERE id = ? or name = ?)";
			Connection conn = null;
			String name = "";
			String countryCode = "";
			Date birthday = null;
			float[] results;
	
			try{
				conn = openConnection();
				PreparedStatement prepStmt = conn.prepareStatement(sql);
				prepStmt.setString(1, parameters[0]);
				prepStmt.setString(2, parameters[0]);
				ResultSet rs = prepStmt.executeQuery();
				while (rs.next()) {
					name = rs.getString("name");
					birthday = rs.getDate("dob");
					countryCode = InputParser.parseCountryCode(rs.getString("country_code"));
					results = new float[10];
					for (int i=0; i<10; i++){
						results[i] = rs.getFloat(i+4);
					}
					Athlete athlete = new Athlete(name,birthday,countryCode,results);
					athletes.add(athlete);
				}
				rs.close();
					
			}catch (SQLException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "Could not get records from database.", e);
				else
					LOG.log(Level.SEVERE, "Could not get records from database.");
			}finally {
				if (conn != null)
					try {
						conn.close();
					}
					catch (SQLException e) {
						if (System.getProperty("program.debug") != null)
							LOG.log(Level.SEVERE, "Could not close database connection.",e);
						else
							LOG.log(Level.SEVERE, "Could not close database connection.");
					}
			}
		}
		return athletes;
	}

	/**
	 * @param jdbcPassword the jdbcPassword to set
	 */
	void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}

}
