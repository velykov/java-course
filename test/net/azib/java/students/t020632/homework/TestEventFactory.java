package net.azib.java.students.t020632.homework;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TestEventFactory is a tes class for EventFactory class
 *
 * @author Marek Soobik t020632
 */
public class TestEventFactory {

	EventFactory factory;

	
	@Before
	public void setUp() throws Exception {
		factory = new EventFactory();
	}

	
	/**
	 * Both running event and field event are created and
	 * tested if they contain the right points calculator
	 * 
	 * @throws Exception
	 */
	@Test
	public void testname() throws Exception {
		Event event;
		
		for(EventInfo info : EventInfo.values()){
			event = factory.createEvent(info);
			if(info.getType().equals("runningEvent"))
				assertTrue(event.getCalculator() instanceof RunningEventCalculator);
			else if(info.getType().equals("fieldEvent"))
				assertTrue(event.getCalculator() instanceof FieldEventCalculator);
		}	
	}
	
	@After
	public void tearDown() throws Exception {
		factory = null;
	}
	
}