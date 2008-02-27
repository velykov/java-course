package net.azib.java.students.t040719.lessons;

/**
 * Cock
 *
 * @author Romi
 */
public class Cock extends Animal {
	private int numberOfCrows;
	
	public Cock(String name, String breed, int age) {
		super(name,breed,age);
	}

	public Cock(String name, String breed, int age, int numCrows) {
		super(name,breed,age);
		this.numberOfCrows = (numCrows >= 0) ? numCrows : 0;
	}
	
	public int getCrowsCount(){
		return numberOfCrows;
	}
	/* (non-Javadoc)
	 * @see net.azib.java.students.t040719.lessons.Animal#makeSound()
	 */
	@Override
	public void makeSound() {
		System.out.println("Crow!");
		numberOfCrows++;
	}

	/* (non-Javadoc)
	 * @see net.azib.java.students.t040719.lessons.Animal#toString()
	 */
	@Override
	public String toString() {
		String str = super.toString();
		str += "\nNumber of crows since birth: " + numberOfCrows;
		return str;
	}

	
}