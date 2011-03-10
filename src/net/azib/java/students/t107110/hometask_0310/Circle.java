package net.azib.java.students.t107110.hometask_0310;

import net.azib.java.lessons.collections.Shape;

public class Circle extends Shape {
	private final double radius;

	public Circle(final double radius) {
		this.radius = radius;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}

		if (!(other instanceof Circle)) {
			return false;
		}

		final Circle otherCircle = (Circle) other;
		if (Double.compare(otherCircle.radius, radius) != 0) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final long temp = radius != 0.0 ? Double.doubleToLongBits(radius) : 0;
		return (int) (temp ^ (temp >>> 32));
	}

	@Override
	public String toString() {
		return "Circle{" + "radius = " + radius + ", area = " + area() + '}';
	}

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
}
