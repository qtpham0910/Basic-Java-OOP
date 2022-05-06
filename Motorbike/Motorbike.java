package Motorbike;
/*
 * 
 * - Xây dựng lớp (class) Motorbike.java để biểu diễn thông tin của xe máy, trong
 *  + Thuộc tính (đặt private): mã số (String), tên xe (String), hãng sản xuất (String), số lượng (Int), Giá (double), Khối lượng (double), Ngày sản xuất (String)
 *
 *+ Phương thức: printMotorbike(): In ra thông tin của xe theo thứ tự: mã số, tên, hãng, số lượng, giá, khối lượng, ngày sản xuất.
 * 
 */
public class Motorbike
{
    private String id;
	private String name;
	private String manu;
	private int quantity;
	private double price;
	private double weight;
	private String date;
	
	public Motorbike() {
		// TODO Auto-generated constructor stub
	}
	
	public Motorbike(String mid, String mname, String mmanu, int mquantity, double mprice, double mweight, String mdate) {
		this.id = mid;
		this.name = mname;
		this.manu = mmanu;
		this.quantity = mquantity;
		this.price = mprice;
		this.weight = mweight;
		this.date = mdate;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public String getManu() {
		return manu;
	}
	
	public void printMotorbike() {
		System.out.println(this.id + " " + this.name + " " + this.manu + " " + this.quantity + " " + this.price + " " + this.weight + " " + this.date);
	}
}
