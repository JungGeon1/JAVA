package Triangle;

public class Triangle {
	double height;
	double weight;
	double Area;

	Triangle(double a, double b) {
		this.height = a;
		this.weight = b;
	}
	/*
	 * Triangle(){
	 * 
	 * }
	 */

	public double heightch(double a) {
		height = a;
		return height;
	}

	public double weightch(double a) {
		weight = a;
		return weight;
	}

//넓이구하기
	public double triangle() {
		double area = (double) height * weight / 2;
		this.Area = area;
		return area;
	}

}
