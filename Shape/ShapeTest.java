/*
*		input type :
*			n
*			s 3
*			c 4
*			r 6 5
*
*		included Shape.java / Circle.java / Rectangle.java / Square.java on MimGo
*/
package Shape;
// MimGo hus
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Shape;
import java.util.*;
public class ShapeTest{
 
	public static ArrayList<Shape> readData()
	{
		ArrayList<Shape> shapes = new ArrayList<Shape>();
	    // Đọc dữ liệu vào danh sách shapes
        Scanner scanner = new Scanner(System.in);
	    int n = Integer.parseInt(scanner.nextLine());
	    for(int i = 0 ; i < n; i++){
	        String[] info = scanner.nextLine().split(" ");
	        String type = info[0];
	        if(type.equals("c")){
	            double radius = Double.parseDouble(info[1]);
	            Circle circle = new Circle(radius);
	            shapes.add(circle);
	        }
	        else if(type.equals("s")){
	            double s = Double.parseDouble(info[1]);
	            Square square = new Square(s);
	            shapes.add(square);
	        }
	        if(type.equals("r")){
	            double lg = Double.parseDouble(info[1]);
	            double st = Double.parseDouble(info[2]);
	            Rectangle rectangle = new Rectangle(lg, st);
	            shapes.add(rectangle);
	        }
	    }
		return shapes;
	}
 
 
	public static Circle getMaxCircle(ArrayList<Shape> shapes)
	{
	    ArrayList<Shape> listCircle = new ArrayList<>();
	    double maxArea = 0;
	    for(Shape i: shapes){
	        if(i instanceof Circle){
	            listCircle.add(i);
 
	            if(i.getArea() > maxArea){
	                maxArea = i.getArea();
	            }
	        }
	    }
		if(listCircle.size() == 0){
		return null;
		}
 
 
		Circle circle = null;
 
		for(Shape i: listCircle){
		    if(i.getArea() == maxArea){
		        circle = (Circle) i;
		    }
		}
 
		return circle;
	}
 
 
	public static Square getMaxSquare(ArrayList<Shape> shapes)
	{
    	ArrayList<Shape> listSquare = new ArrayList<>();
	    double maxArea = 0;
	    for(Shape i: shapes){
	        if(i instanceof Square){
	            listSquare.add(i);
 
	            if(i.getArea() > maxArea){
	                maxArea = i.getArea();
	            }
	        }
	    }
		if(listSquare.size() == 0)
		return null;
 
 
		Square square = null;
 
		for(Shape i: listSquare){
		    if(i.getArea() == maxArea){
		        square = (Square) i;
		    }
		}
 
		return square;
	}
 
	public static Rectangle getMaxRectangle(ArrayList<Shape> shapes)
	{
		ArrayList<Shape> listRectangle = new ArrayList<>();
	    double maxArea = 0;
	    for(Shape i: shapes){
	        if(i instanceof Rectangle){
	            listRectangle.add(i);
 
	            if(i.getArea() > maxArea){
	                maxArea = i.getArea();
	            }
	        }
	    }
		if(listRectangle.size() == 0)
		return null;
 
 
		Rectangle rectangle = null;
 
		for(Shape i: listRectangle){
		    if(i.getArea() == maxArea){
		       rectangle = (Rectangle) i;
		    }
		}
 
		return rectangle;
	}
	public static void main(String[] args){
		ArrayList<Shape> shapes = readData();
		sort(shapes);
		Circle c = getMaxCircle(shapes);
		Square s = getMaxSquare(shapes);
		Rectangle r = getMaxRectangle(shapes);
		if(c!=null)
		{
			System.out.printf("Circle %.2f\n",c.getArea());
		}
		else
		{
			System.out.println("Circle =  null");
		}
		if(s!=null)
		{
			System.out.printf("Square %.2f\n",s.getArea());
		}
		else
		{
			System.out.println("Square =  null");
		}
 
		if(r!=null)
		{
			System.out.printf("Rectangle %.2f\n",r.getArea());
		}
		else
		{
			System.out.println("Rectangle =  null");
		}
 
	}
 
	public static void sort(ArrayList<Shape> shapes){
		int n = shapes.size();
 
		for (int i = 0; i < n - 1; i++)
			for (int j = i+1; j < n; j++) {
				if((shapes.get(i)).compareTo(shapes.get(j)) > 0){
					Shape temp = shapes.get(i);
					shapes.set(i, shapes.get(j)); 
					shapes.set(j, temp);  
				}
			}
	}
}