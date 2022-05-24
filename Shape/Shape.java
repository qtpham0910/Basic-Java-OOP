package Shape;

public interface Shape {
	double getPerimeter(); // chu vi
	double getArea(); // dien tich

	default int compareTo(Shape shape){
		if(getArea() > shape.getArea()) {
			return 1;
		}
		if(getArea() == shape.getArea()) {
			return 0;
		}
		return -1;
	}
}