package Baby;

import java.util.Comparator;

public class Baby {

	// khai báo các thuộc tính của một baby
	// tạo tất cả các hàm dựng (có đối và không đối)
	// xây dựng các hàm getter, setter phù hợp với các thuộc tính
	private String day = "01/01/2020";
	private String name = "UnRegistered";
	private boolean gender;
	private double weight, length;

	public Baby() {
	}

	public Baby(String bbName, String bbDay, boolean bbGender, double bbWeight, double bbLength) {
		this.name = bbName;
		this.day = bbDay;
		this.gender = bbGender;
		this.weight = bbWeight;
		this.length = bbLength;
	}

	public String getName() {
		return this.name;
	}

	public String getGender() {
		if (this.gender)
			return "Girl";
		return "Boy";
	}

	public double getWeight() {
		return weight;
	}

	public static Comparator<Baby> BabyComparator = new Comparator<Baby>() {

		public int compare(Baby baby1, Baby baby2) {

			double baby1weight = baby1.getWeight();
			double baby2weight = baby2.getWeight();

			// ascending order
			// return baby1weight.compareTo(baby2weight);

			// descending order
			return Double.compare(baby2weight, baby1weight);
		}

	};

	/*
	 * Lưu ý, đối với hàm public String getGender() sẽ trả về Boy nếu gender =
	 * false, ngược lại trả về "Girl"
	 */
	// in ra thong tin cua baby theo thu tu: ten, ngay thang nam sinh, gioi tinh,
	// can nang, chieu cao
	public String toString() {
		return getName() + " " + this.day + " " + getGender() + "  " + this.length + " " + this.weight;
	}

}
