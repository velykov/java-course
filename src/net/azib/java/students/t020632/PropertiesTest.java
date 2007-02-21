package net.azib.java.students.t020632;

import java.util.Properties;
import java.util.Iterator;
import java.util.Collection;

/**
 * PropertiesTest
 *
 * @author t020632
 */
public class PropertiesTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties sysprops = System.getProperties();
		
		Collection c = sysprops.keySet();
		
		for(Iterator i = c.iterator(); i.hasNext(); ){
			Object key = i.next();
			System.out.println(key);
		}
		
		for(Object key : c){
			System.out.println(key);
		}
		
		//for(Object key : sysprops.keySet()){
		//	System.out.println(key + " = " + sysprops.get(key));
		//}
	}

}
