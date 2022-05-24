import java.util.ArrayList;
public class ShapeTest{
	public static void main(String[] args){
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		
		// Thêm vào mảng shapes 3 hình vuông, 1 hình chữ nhật, 2 hình tròn
		shapes.add(new Square(5));
		shapes.add(new Square(10));
		shapes.add(new Square(4));
		shapes.add(new Rectangle(2,3));
		shapes.add(new Circle(3));
		shapes.add(new Circle(2));
		sort(shapes);
		 
		// In ra diện tích các hình theo thứ tự tăng dần
		for(int i=0;i<shapes.size();i++){
			String className = shapes.get(i).getClass().getName();
			System.out.println(className);
			// Nếu là hình tròn, ép kiểu để gọi phương thức getFrameArea của lớp Circle
			if(className.equals("Circle"))
				System.out.printf("%8.2f\n",((Circle)shapes.get(i)).getFrameArea());	
			else
				System.out.printf("%8.2f\n",(shapes.get(i)).getArea());
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
