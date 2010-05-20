package net.azib.java.students.t092860.homework;

import java.util.List;

/**
 * Interface to be implemented by different input types
 *
 * @author scythe
 */
interface Input {
	
	/**
	 * Class used as an input data in Input object.
	 */
	public class Data extends Athlete{
		Data(){}
		Data(Athlete athlete)
		{
			athleteName = athlete.athleteName;
			athleteBirthdate = athlete.athleteBirthdate;
			athleteCountry = athlete.athleteCountry;
			athleteEvents = athlete.athleteEvents;
		}
	}
	
	/**
	 * Gets input data from particular input object.
	 * 
	 * @return      list of input data
	 */
	public List<Data> get() throws Exception;
}