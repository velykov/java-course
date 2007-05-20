package net.azib.java.students.t020632.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DecathlonCompetiton calculates scores for all the 
 * athletes in the competition and writes results into
 * output. 
 *
 * @author Marek Soobik t020632
 */
public class DecathlonCompetition {
	Input input;
	Output output;
	List<AthleteResults> athletes; 
	
	public DecathlonCompetition(Input in, Output out){
		input = in;
		output = out;
		athletes = new ArrayList<AthleteResults>();
	}
	
	/**
	 * Processes one decathlon competition. Reads input data,
	 * calculates scores, sorts results in list, sets correct
	 * places for the athletes and writes results into output.
	 */
	public void processCompetition(){
		athletes = readResults();
		
		if(athletes != null){
			calculateResults();
			sortAthletes();
			setAthletePositions();
			writeResults();
		}
	}
	
	/**
	 * Reads input data
	 * 
	 * @return 	List of AthleteResults
	 */
	public List<AthleteResults> readResults(){
		athletes = input.read();
		return athletes;
	}
	
	/**
	 * Writes results into output
	 */
	public void writeResults(){
		output.write(athletes);
	}
	
	
	/**
	 * Calculates scores for each athlete in the competition
	 */
	public void calculateResults(){
		int i = 0;
		AthleteResults result;
		
		while(i < athletes.size()){
			result = athletes.get(i);
			result.calculateScore();
			i++;
		}
	}
	
	/**
	 * Sorts athletes according to the scores
	 */
	public void sortAthletes(){
		Collections.sort(athletes);
	}
	
	/**
	 * Sets rank for each athlete. If two athletes have equal scores then
	 * they share the position.
	 */
	public void setAthletePositions(){
		int i = 0;
		int pos = 1;
		AthleteResults result;
		
		while(i < athletes.size()){
			result = athletes.get(i);
			if(i == 0){
				result.setPosition(pos);
			}
			else{
				if((result.getScore() - athletes.get(i-1).getScore()) < 0)
					result.setPosition(pos);
				else
					result.setPosition(athletes.get(i-1).getPosition());
			}
			i++;
			pos++;
		}
	}
	
	
}
