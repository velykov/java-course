package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;
import net.azib.java.students.t040719.homework.DecathlonConstants;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;


/**
 * ConsoleOutputTest
 *
 * @author romi
 */
public class ConsoleOutputTest {
	private static final String LN = System.getProperty("line.separator");;
	private int errorCode;
	
	@Test
	public void testGetLongestNameLength(){
		List<Athlete> al = new ArrayList<Athlete>();
		al.add(new Athlete("Siim Susi", new Date(), "EE", new float[10]));
		al.add(new Athlete("Marek Kala", new Date(), "ET", new float[10]));
		assertEquals(10, new ConsoleOutput().getLongestNameLength(al));
	}
	
	@Test
	public void testGetEventNamesFormatString(){
		assertEquals("%s | %s | %s | %s | %s | %s | %s | %s | %s | %s", new ConsoleOutput().getEventNamesFormatString());
	}

	@Test
	public void testGetEventsFormatString(){
		assertEquals("%9.2f%16$3s | %7.2f%16$2s | %7.2f%16$1s | %7.2f%16$2s | %10s%16$2s | %9.2f%16$4s | %9.2f%16$3s | %8.2f%16$2s | %9.2f%16$4s | %9s", new ConsoleOutput().getEventsFormatString());
	}

	@Test
	public void testGetEventNames(){
		List<String> sl = new ArrayList<String>();
		for(int i=0; i<DecathlonConstants.values().length; i++)
			sl.add(DecathlonConstants.getOrdinal(i).getName());
		assertEquals(sl, new ConsoleOutput().getEventNames());
	}
	
	@Test
	public void testGetAthleteInfo(){
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
		float[] realResults = {12.61f,5.00f,9.22f,1.50f,59.39f,16.43f,21.60f,2.60f,35.81f,325.72f};
		Athlete ath = new Athlete("s s", new Date(), "EE", realResults);
		List<Object> lo = new ArrayList<Object>();
		lo.add("2");
		lo.add(ath.getName());
		lo.add(ath.getDecathlonPoints());
		lo.add(ath.getCountryCode());
		lo.add(df.format(ath.getBirthday()));
		for(int i=0; i<DecathlonConstants.values().length; i++)
			if (i==4 || i==9)
				lo.add(InputParser.formatTime(ath.getDecathlonResult(i)));
			else
				lo.add(ath.getDecathlonResult(i));
		lo.add("");
		
		for(int i=0; i<lo.size(); i++)
			assertEquals(lo.get(i), new ConsoleOutput().getAthleteInfo("2", df, ath)[i]);
	}
	
	@Test
	public void nullArgumentGivenToOutputResults(){
		ConsoleOutput co = new ConsoleOutput() {
			@Override
			public void exit(int errorCode) {
	        	 ConsoleOutputTest.this.errorCode = errorCode;
	         }
		};
		co.outputResults(null);
		assertEquals(9, errorCode);
	}
	
	@Test
	public void nullArgumentGivenToGetAthleteInfo(){
		ConsoleOutput co = new ConsoleOutput() {
			@Override
			public void exit(int errorCode) {
	        	 ConsoleOutputTest.this.errorCode = errorCode;
	         }
		};
		co.getAthleteInfo("1", null, null);
		assertEquals(10, errorCode);
	}
	
	@Test
	public void zeroArgumentTest(){
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
		int dateLength = ((SimpleDateFormat)df).toPattern().length()+1;
		List<String> tableHeader = new ArrayList<String>();
		tableHeader.add("#");
		tableHeader.add("Name");
		tableHeader.add("Score");
		tableHeader.add("Country");
		tableHeader.add("DOB");
		tableHeader.addAll(new ConsoleOutput().getEventNames());
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new ConsoleOutput(new PrintStream(out)).outputResults(new ArrayList<Athlete>());
		String formatted = String.format(Locale.getDefault(), "%1s %-4s %5s %7s %-" + dateLength + "s " + new ConsoleOutput().getEventNamesFormatString(),tableHeader.toArray());
		assertEquals("The decathlon competition final results:"+LN + formatted +LN, out.toString());
	}
	
	@Test
	public void testGetPositionFieldLength() throws ParseException{
		Date d = new SimpleDateFormat("dd.MM.yyyy").parse("01.01.1999");
		float[] realResults = {12.61f,5.00f,9.22f,1.50f,59.39f,16.43f,21.60f,2.60f,35.81f,325.72f};
		List<Athlete> al = new ArrayList<Athlete>();
		al.add(new Athlete("Siim Susi", d, "EE", realResults));
		al.add(new Athlete("Margus Murakas", d, "ET", realResults));
		assertEquals(3,new ConsoleOutput().getPositionFieldLength(al));
	}
}
