import java.util.Scanner;

public class CountVowelsDigits {
	
	public static void main(String args[]) {
		
		
		CountVowelsDigits testCountVowelsDigits = new CountVowelsDigits();
		testCountVowelsDigits.run();
		
	}
	
	private void run()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a String: ");
		String str = sc.nextLine().toLowerCase();
		int noDigit = 0; // number of Digits
		int noVow = 0;	// Number of Vowel
		for (int i = 0; i < str.length(); i++) {
			if ( '0' <= str.charAt(i) && str.charAt(i) <='9' ) {
				noDigit++;
			}
			switch (str.charAt(i)){
				case 'a': 
				case 'e':
				case 'i':
				case 'u':
				case 'o': noVow++;
			}
		}
			double perVow = (double) (noVow * 100) / str.length();
			double perDigit = (double) (noDigit * 100) / str.length();
		
			System.out.printf("Number of vowels: %2d (%.2f%%)\n", noVow, perVow );
			System.out.printf("Number of digits: %2d (%.2f%%)", noDigit, perDigit );
			
			sc.close();
		
	}
}