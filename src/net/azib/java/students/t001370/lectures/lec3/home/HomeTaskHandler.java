package net.azib.java.students.t001370.lectures.lec3.home;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;


/**
 * DuplicateRemoverImplUser
 *
 * @author maksim
 */
public class HomeTaskHandler {
	
	public static void useDublicateRemover(){
		System.out.println("Dublicate Remover ---------------------");
		
		DuplicateRemoverImpl dri = new DuplicateRemoverImpl();
		String[] strArray = new String[]{
			"0000",
			"0001",
			"0010",
			"0011",
			"0000",
			"0100",
			"0010"};
		
		System.out.println("Array size before DublicateRemover: " + strArray.length);
		strArray = dri.removeDuplicateStrings(strArray);
		System.out.println("Array size after DublicateRemover: " + strArray.length);
		int i = 0;
		for (String string : strArray) {
			System.out.println((++i) + " " + string);
		}
		
		System.out.println("---------------------------------------\n");
	}
	
	public static void useWordFrequencyCalculator(){
		
		System.out.println("Word Frequency Calculator -------------");
		
		String str = "Hash table based implementation of the Map " +
				"interface. This implementation provides all of " +
				"the optional map operations, and permits null " +
				"values and the null key. (The HashMap  class is " +
				"roughly equivalent to Hashtable, except that it is " +
				"unsynchronized and permits nulls.) This class makes " +
				"no guarantees as to the order of the map; in particular, " +
				"it does not guarantee that the order will remain constant " +
				"over time.";
		WordFrequencyCalculatorImp wfci = new WordFrequencyCalculatorImp();
		Map wfciMap = new HashMap();
		
		wfciMap = wfci.calculateFrequenciesOf(str);
		
		/*Set s = wfciMap.entrySet();
		for(Iterator i = s.iterator();i.hasNext();){
		   Map.Entry me = (Map.Entry)i.next();
		   System.out.println(me.getKey() + " : " + me.getValue()); 
		}*/
		
		
		System.out.println("---------------------------------------");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		useDublicateRemover();
		useWordFrequencyCalculator();
		
		//getProperty practice
		System.out.println("JVM version:" + System.getProperty("java.version"));
	}
}