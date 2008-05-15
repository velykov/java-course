package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;

import java.util.List;

/**
 * DataOutput - an interface for outputting the results
 *
 * @version 1.0
 * @author Romi Agar
 */
public interface DataOutput {
	/**
	 * Outputs the decathlon results.
	 * @param results a list of athletes' results
	 * @param parameters contains output file name and output format. Not used for console output.
	 */
	void outputResults(List<Athlete> results, String... parameters);
}
