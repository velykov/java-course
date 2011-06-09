package net.azib.java.students.t100224.homework.interfaces;


import net.azib.java.students.t100224.homework.model.Result;

import java.util.List;

public interface IResultsPrinter {
	/**
	 * Prints output data to specific destination
	 *
	 * @param results - Array list of athletes and their decathlon results
	 */
	public void printResults(List<Result> results);

}