package net.azib.java.students.t093052.homework.action.input;

import net.azib.java.students.t093052.homework.Athlete;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

/**
 * This class holds the common methods of console and csv input actions
 * */
public abstract class AbstractInputStreamAction extends AbstractInputAction {
	/**
	 * @return the competitor's input stream
	 * */
	abstract InputStream getInputStream() throws IOException;
	/**
	 * Reads the next line from the input stream
	 * @return the string of data
	 * */
	abstract void addAthletes(Set<Athlete> athletes, 
			Scanner scanner) throws Exception;
	
	public Set<Athlete> handleData() throws Exception {
		Scanner scanner = new Scanner(getInputStream());
		
		Set<Athlete> athletes = createAthleteSet();
		
		try {
			addAthletes(athletes, scanner);
		} finally {
			scanner.close();
		}
		return athletes;
	}
}
