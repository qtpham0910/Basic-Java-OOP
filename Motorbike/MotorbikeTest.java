package Motorbike;
/*
 * 
 * - Xây dựng lớp MotorbikeTest.java để thực hiện các yêu cầu:

+ Phương thức void inputMotorbike(ArrayList<Motorbike> motorbikes, int n) để nhập danh sách n  xe máy từ bàn phím

+Phương thức void outputMotorbike (ArrayList<Motorbike> motorbikes) để in thông tin của các xe máy, mỗi xe trên một dòng.

+ Phương thức ArrayList<Motorbike> search(String manu, ArrayList<Motorbike> motorbikes) để tìm kiếm và trả về danh sách các xe có hãng sản xuất là manu

+ Phương thức ArrayList<Motorbike> maxWeight(ArrayList<Motorbike> motorbikes) để tìm kiếm và trả về các xe có khối lượng lớn nhất.

+ Phương thức ArrayList<Motorbike> minQuantity(ArrayList<Motorbike> motorbikes) để tìm kiếm và trả về các xe có số lượng ít.

+ Phương main(String[]) thực hiện việc  các yêu cầu sau:

 -- Nhập số lượng xe;

-- Nhập số 1 <= c <=3

+) Nếu c==1. Tìm và in ra tất cả các loại xe có hãng sản xuất là "Honda"

+) Nếu c==2. Tìm và in ra thông tin của xe có trọng lượng nặng nhất

+)Nếu c==3. Tìm và in ra thông tin của xe có số lượng ít nhất.
 */

import java.util.*;

public class MotorbikeTest{
	
    static	Scanner scanner = new Scanner(System.in);
    public static void inputMotorbike (ArrayList<Motorbike> motorbikes, int n)
	{
    	
    	for(int i = 0 ; i < n; i++) {
    		String id = scanner.nextLine();
    		String name = scanner.nextLine();
    		String manu = scanner.nextLine();
    		 int quantity = Integer.parseInt(scanner.nextLine()); 
    		 double price =  Double.parseDouble(scanner.nextLine());
    		 double weight = Double.parseDouble(scanner.nextLine());
    		 String date = scanner.nextLine();
    		 Motorbike data = new Motorbike(id, name, manu, quantity, price, weight, date);
    		 motorbikes.add(data);
       	}
    
	}
	public static void ouputMotorbike (ArrayList<Motorbike> motorbikes){
		for (Motorbike i : motorbikes) {
			i.printMotorbike();
		}
	}
	public static ArrayList<Motorbike> search (String manu, ArrayList<Motorbike> motorbikes)
	{
		ArrayList<Motorbike> s = new ArrayList<Motorbike>(); 
		for(Motorbike i : motorbikes) {
			if(i.getManu().equals(manu)) {
				s.add(i);
			}
		}
		return s;
	}
	public static ArrayList<Motorbike> maxWeight (ArrayList<Motorbike> motorbikes)
	{
		ArrayList<Motorbike> mx = new ArrayList<Motorbike>();
		double mxt = -1.0;
		for(int i = 0 ; i < motorbikes.size(); i++) {
			if( mxt < motorbikes.get(i).getWeight()) {
				mxt = motorbikes.get(i).getWeight();
			}
		}
		
		for(Motorbike i : motorbikes) {
			if(i.getWeight() == mxt) {
				mx.add(i);
			}
		}
		return mx;
	}
	public static ArrayList<Motorbike> minQuantity (ArrayList<Motorbike> motorbikes)
	{
		ArrayList<Motorbike> mn = new ArrayList<Motorbike>();
		int mnq = Integer.MAX_VALUE;
		for(Motorbike i : motorbikes) {
			if( mnq > i.getQuantity()) {
				mnq = i.getQuantity();
			}
		}
		
		for(Motorbike i : motorbikes) {
			if(i.getQuantity() == mnq) {
				mn.add(i);
			}
		}
		return mn;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Motorbike> motorbikes = new ArrayList<Motorbike>();
		int n = Integer.parseInt(scanner.nextLine());
	    inputMotorbike(motorbikes, n);
		int c = Integer.parseInt(scanner.nextLine());
		
		if(c == 1) {
			ouputMotorbike(search("Honda", motorbikes));
			}
		
		else if( c == 2) {
			ouputMotorbike(maxWeight(motorbikes));
			
		}
		else if( c == 3) {
			ouputMotorbike(minQuantity(motorbikes));
			
		}
	}

}