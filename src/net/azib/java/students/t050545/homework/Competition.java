package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.sportman.Sportman;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Competition
 * 
 * @author libricon
 */
public class Competition {
	public Competition(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public boolean addCompetitor(Sportman sportman) {
		return competitors.add(sportman);
	}

	public void sortCompetitors() {
		Collections.sort(competitors);
	}

	public void dividePlaces() {
	    int score = 0;
		for(int index = 0; index < competitors.size(); index++){
			if(competitors.get(index).getPoints().getScore()==score)
			tableScore.addPlace(competitors.get(index));
			
		}
				

	}

	@Override
	public String toString() {
		return competitors.toString();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	private class Places {
		public Places(String place) {
			placeNum = place;
		}

		public void addPlace(Sportman sportman) {
			sportmans.add(sportman);
		}

		String placeNum;
		ArrayList<Sportman> sportmans;

	}

	private Places tableScore;
	private ArrayList<Sportman> competitors = new ArrayList<Sportman>();
	private String name;
	private int id;

}