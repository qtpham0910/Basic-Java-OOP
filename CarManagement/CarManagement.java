import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class CarManagement {
	
	// Hàm dựng 
	public CarManagement(){
		super();
	}
	
	// Phương thức readData() cho phép đọc dữ liệu từ tệp văn bản
	/*
	    Thứ tự nhập như sau:
	    - Nhập số lượng xe
	    - Trong vòng lặp với mỗi loại xe:
	       - Nhập 1 số nguyên c, c = 0 là ServiceCar, c = 1 là SportCar
	       - Nhập thông tin của các xe: id, name, manufacturer, hours, price, fee (Đối với ServiceCar, tax với SportCar)
	*/
	
	public ArrayList<Car> readData(String fileName) {
		File file = new File(fileName);
		ArrayList<Car> cars = new ArrayList<>();
	try{
		    
        Scanner scanner = new Scanner(file);
	    int n = Integer.parseInt(scanner.nextLine());
	    for(int i = 0 ; i < n; i++){
            int c = Integer.parseInt(scanner.nextLine());
            if(c == 0){
                // Service
                String id = scanner.nextLine();
                String name = scanner.nextLine();
                String manufacture = scanner.nextLine();
                double hours = Double.parseDouble(scanner.nextLine());
                double price = Double.parseDouble(scanner.nextLine());
                double fee = Double.parseDouble(scanner.nextLine());
                ServiceCar x = new ServiceCar(id, name, manufacture, hours, price, fee);
                cars.add(x);
            }	 	  	 		 	    	  	     	 	
            else if(c == 1){
                // Sport
                String id = scanner.nextLine();
                String name = scanner.nextLine();
                String manufacture = scanner.nextLine();
                double hours = Double.parseDouble(scanner.nextLine());
                double price = Double.parseDouble(scanner.nextLine());
                double tax = Double.parseDouble(scanner.nextLine());
                SportCar x = new SportCar(id, name, manufacture, hours, price, tax);
                cars.add(x);
            }
	    }
	}
	catch (FileNotFoundException e){
	    System.out.println(e);
	}
		return cars;
			
	}
	
	// Phương thức in danh sách thông tin liên quan các loại xe trong mảng
	public void printCars(ArrayList<Car> cars) {
		for (int i = 0; i < cars.size(); i++) {
			System.out.println(cars.get(i).toString());
		}
	}
	
	// Phương thức xuất ra danh sách những xe có tên nhà sản xuất là "manuName"
	public ArrayList<Car> findCars(ArrayList<Car> cars, String manuName){
	    ArrayList<Car> carManu = new ArrayList<Car>();
	    for(Car i:cars){
	        if(i.getManufacturer().equals(manuName))
	            carManu.add(i);
	    }
		return carManu;
	}	 	  	 		 	    	  	     	 	
	
	// Phương thức xuất ra danh sách những xe giá thành tiền (amount) cao nhất thuộc loại typeOfCars
	
	public ArrayList<Car> getMaxAmount(ArrayList<Car> cars, String typeOfCars){
		ArrayList<Car> mx = new ArrayList<Car>();
        double mxamt = -1;
        for(Car i : cars){
            if(i.getClass().getName().equals(typeOfCars)){
                if(i.getAmount() > mxamt){
                    mxamt = i.getAmount();
                }
                               
            }
        }
            for(Car i : cars){
                if(i.getClass().getName().equals(typeOfCars)){
                    if(i.getAmount() == mxamt){
                        mx.add(i);
                    }
                }
            }
        
		return mx;
		
	}
	
	// Phướng thức sắp xếp giá thành tiền các loại xe theo thứ tự giảm dần
	public void sortByAmount(ArrayList<Car> cars){
		//Begin editable part
		 for(int i = 0; i < cars.size() - 1; i++)
            for(int j = i+1; j < cars.size(); j++){
                if(cars.get(i).getAmount() < cars.get(j).getAmount()){
                    Car temp = cars.get(i);
                    cars.set(i,cars.get(j));
                    cars.set(j, temp);
                }	 	  	 		 	    	  	     	 	
            }
		}
	

// Hàm main 
		public static void main(String[] args) {
			CarManagement carManag = new CarManagement();
			ArrayList<Car> cars = carManag.readData("data.txt");
		//	carManag.printCars(cars);
			
			for (int i = 0; i < cars.size(); i++) {
				System.out.print(cars.get(i).getAmount() + " ");
			}
			System.out.println();
			ArrayList<Car> carsList = carManag.findCars(cars,"honda");
			carManag.printCars(carsList);
			
			ArrayList<Car> carsList1 = carManag.getMaxAmount(cars, "SportCar");
			carManag.printCars(carsList1);
			
			carManag.sortByAmount(cars);
			carManag.printCars(cars);
			
		}
	}	 	  	 		 	    	  	     	 	
