package net.azib.java.students.t020632.homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * CSVInput
 *
 * @author Marek Soobik t020632
 */
public class CSVInput implements Input {

	private String path;
	
	public CSVInput(String path){
		this.path = path;
	}
	
	public List<AthleteResults> read() {
		List<AthleteResults> results = new ArrayList<AthleteResults>();
		String s = "";
		
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"));
			
			while((s = in.readLine()) != null){
				parseLine(s, results);
			}
		}
		catch(Exception e){
			System.out.println("File not found!\n Make sure you have entered correct path");
		}
		
		try {
	        Writer out = new BufferedWriter(new OutputStreamWriter(
	            new FileOutputStream("out.txt"), "UTF8"));
	        out.write(s);
	        out.close();
	    } catch (UnsupportedEncodingException e) {
	    } catch (IOException e) {
	    }

		
		return results;
	}
	
	public void parseLine(String s, List<AthleteResults>results){
		UnitsConverter converter;
		AthleteResults result;
		Event event;
		String name;
		String date;
		String country;
		String [] values;
		
		values = s.split(",");
		
		if(values.length == 13){
			name = values[0];
			date = values[1];
			country = values[2];
			
			result = new AthleteResults(name, date, country);
			
			int i = 3;
			float fResult = 0.0F;
			converter = UnitsConverter.getUnitsConverter();
			
			for(EventInfo eventInfo : EventInfo.values()){
				event = result.createEvent(eventInfo);
				fResult = converter.convert(eventInfo, values[i]);
				event.setResult(fResult);
				result.addEvent(event);
				i++;
			}
			
			result.printResults();
			results.add(result);
		}
		else{
			System.out.println("Input line is not in correct format!");
		}
	}

}
