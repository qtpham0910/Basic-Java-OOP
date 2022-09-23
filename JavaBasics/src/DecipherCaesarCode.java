import java.util.Scanner;

public class DecipherCaesarCode {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a ciphertext string: ");
		String str = sc.next().toUpperCase();

		System.out.print("The plaintext string is: " + decipherCaesarPickThree(str));
		sc.close();
	}

	public static String decipherCaesarPickThree(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'D' && s.charAt(i) <= 'Z') {
				res += Character.toString(s.charAt(i) - 3);
			} else if (s.charAt(i) == 'A')
				res += 'X';
			else if (s.charAt(i) == 'B')
				res += 'Y';
			else if (s.charAt(i) == 'C')
				res += 'Z';
			else
				res += s.charAt(i);

		}
		return res;
	}

}
