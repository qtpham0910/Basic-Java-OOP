package Baby;

import java.util.*;

public class ManageBabies {

	/*
	 * Nhap vao thong tin cua n baby tu ban phim. Cac thong tin theo thu tu ten,
	 * ngay thang nam sinh, gioi tinh gioi tinh, can nang, chieu cao
	 */

	// nhap vao so nguyen duong n va thong tin cua n baby
	static Baby[] createData(Scanner sc) {
		int n = sc.nextInt();
		Baby[] babies = new Baby[n];
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			String name = sc.nextLine();
			String day = sc.nextLine();

			boolean gender = sc.nextBoolean();
			double weight = sc.nextDouble();
			double length = sc.nextDouble();
			babies[i] = new Baby(name, day, gender, weight, length);
		}
		return babies;

	}

	// In ra thong tin cua n baby sau khi chuan hoa ho ten
	static void printInforBabies(Baby babies[]) {
		for (int i = 0; i < babies.length; i++) {
			System.out.println(babies[i].toString());
		}
	}

	// Sap xep cac baby theo trong luong giam dan
	static void sortWeight(Baby babies[]) {
		Arrays.sort(babies, Baby.BabyComparator);
	}

	// Loc ra tat ca nhung baby co gioi tinh la gender
	static void filterGender(Baby babies[], String gender) {
		for (int i = 0; i < babies.length; i++) {
			String tempGender = babies[i].getGender();
			if (tempGender.equals(gender))
				System.out.println(babies[i].toString());
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Baby[] babies = createData(sc);
		sortWeight(babies);
		printInforBabies(babies);
//        filterGender(babies, "Boy");
	}

}
