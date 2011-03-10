package net.azib.java.students.t107110.hometask_0310;

import net.azib.java.lessons.collections.Shape;

public class Square extends Shape {
	private final double size;

	public Square(final double size) {
		this.size = size;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}

		if (!(other instanceof Square)) {
			return false;
		}

		final Square square = (Square) other;
		if (Double.compare(square.size, size) != 0) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final long temp = size != 0.0 ? Double.doubleToLongBits(size) : 0;
		return (int) (temp ^ (temp >>> 32));
	}

	@Override
	public String toString() {
		return "Square{" + "size = " + size + ", area = " + area() + '}';
	}

	@Override
	public double area() {
		return size * size;
	}
}
