package net.azib.java.students.t010588.homework.importer;

import net.azib.java.students.t010588.homework.Athlete;
import net.azib.java.students.t010588.homework.DecathlonConstants;
import net.azib.java.students.t010588.homework.EventType;
import net.azib.java.students.t010588.homework.FieldEventResult;
import net.azib.java.students.t010588.homework.Result;
import net.azib.java.students.t010588.homework.RunningEventResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Imports athletes from CSV file
 *
 * @author Vjatseslav Rosin, 010588
 */
public class CSVImporter implements AthleteImporter {

	private List<Athlete> athletes;

	/**
	 * @param csvFile
	 *            source file with athletes
	 * @throws WrongFormatException
	 *             in a case of invalid file format
	 */
	public CSVImporter(File csvFile) throws WrongFormatException {
		athletes = new ArrayList<Athlete>();

		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF8"));
			try {
				String line = null;
				while ((line = input.readLine()) != null) {
					addAthlete(line);
				}
			}
			finally {
				input.close();
			}
		}
		catch (IOException ex) {
			throw new WrongFormatException(csvFile.getAbsolutePath());
		}
	}

	/**
	 * @param line
	 *            of CSV file with one athlete results
	 * @throws WrongFormatException
	 *             in a case of invalid athlete information
	 */
	private void addAthlete(String line) throws WrongFormatException {
		Athlete athlete = new Athlete();
		String[] data = line.split("[,]");

		try {
			athlete.setName(data[0]);

			Date birthday = DATE_FORMAT.parse(data[1]);
			athlete.setBirhday(birthday);

			athlete.setCountry(data[2].toCharArray());

			int eventsCount = DecathlonConstants.EVENTS.length;

			Result[] results = new Result[eventsCount];
			for (int i = 0; i < eventsCount; i++) {
				if (DecathlonConstants.EVENTS[i] == EventType.RUNNING)
					results[i] = new RunningEventResult(i, data[i + 3]);
				else
					results[i] = new FieldEventResult(i, Float.parseFloat(data[i + 3]));
			}

			athlete.setResults(results);
		}
		catch (Exception e) {
			throw new WrongFormatException(line);
		}

		athletes.add(athlete);
	}

	public List<Athlete> getAthletes() {
		return athletes;
	}
}