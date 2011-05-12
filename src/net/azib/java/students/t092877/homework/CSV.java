package net.azib.java.students.t092877.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSV {

	public static List<Athlete> input(File pathname) {

		List<String> athleteDataAsStrInput = new ArrayList<String>();

		try {
			BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(pathname), "utf-8"));

			System.out.println("Processing file - " + pathname + "...");

			try {
				String line = fin.readLine();

				while(line != null) {
					athleteDataAsStrInput.add(line);
					line = fin.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.out.println("\n>>> ERROR: The specified file is missing!");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO: handle exception
		}

		List<Athlete> athletes = new ArrayList<Athlete>();
		String[] elements;

		try {

		for (String line : athleteDataAsStrInput) {
			elements = line.split(",");
			String name = elements[0].replace("\"", "");
			String dateOfBirth = elements[1];
			String countryCode = elements[2];

			Athlete athlete = new Athlete(name, dateOfBirth, countryCode);
			athletes.add(athlete);

			String[] resultsAsStr = Arrays.copyOfRange(elements, 3, elements.length);
			List<Result> results = new ArrayList<Result>();

			int i = 0;
			for (Event event : Event.values()) {


					Result result = new Result(event, Utils.convertToProperUnits(resultsAsStr[i], event.getType()));
					results.add(result);
					i++;
			}

			athlete.setResults(results);
		}

		} catch (NumberFormatException e) {

			System.out.println("\n>>> ERROR: The specified input file has invalid format!");
			athletes = null;

		}

		return athletes;
	}


	public static void output(List<Athlete> athletes, File pathname) {

		if (athletes == null) {

			System.out.println("\n>>> ACTION: output to csv-file terminated...");
			System.out.println("The input file provided has invalid format or empty.");
			System.out.println("As a result, the output to specified CSV-file was terminated");
			System.out.println("Before continuing operation, please, ensure the validity of input data.");
			return;
		}

		Utils.sortAthletes(athletes);
		List<String> athleteDataAsStrOutput = new ArrayList<String>();

		for (Athlete athlete : athletes) {

			StringBuilder line = new StringBuilder();

			line.append(athlete.getPlace() + ",");
			line.append(athlete.getTotalScore() + ",");
			line.append("\"" + athlete.getName() + "\",");
			line.append(athlete.getDateOfBirth() + ",");
			line.append(athlete.getCountryCode());

			List<Result> results = athlete.getResults();

			int i = 0;
			for (Event event : Event.values()) {

				Result currentEventResult = results.get(i);
				String value = Utils.convertToOriginalUnits(currentEventResult.getValue(), event.getType());
				line.append("," + value);
				i++;
			}

			athleteDataAsStrOutput.add(line.toString());
		}

		try {
			BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathname), "utf-8"));

			for (String line : athleteDataAsStrOutput) {
				fout.write(line);
				fout.newLine();
				fout.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Saving file - " + pathname + "...");
		System.out.println("\nThe file has been saved.");
	}
}
