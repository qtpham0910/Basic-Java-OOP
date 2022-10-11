import java.util.Scanner;

public class CaesarCode {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a step: ");
		int step = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter a plaintext string: ");
		String str = sc.next().toUpperCase();

		System.out.print("The ciphertext string is: " + caesarCrypto(str, step));
		sc.close();
	}

	public static String caesarStepThree(String s) {
		String res = "";
		for(int i= 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'W') {
				res += (char) (s.charAt(i) + 3);
			} else if (s.charAt(i) == 'X')
				res += 'A';
			else if (s.charAt(i) == 'Y')
				res += 'B';
			else if (s.charAt(i) == 'Z')
				res += 'C';
			else
				res += s.charAt(i);

		}
		return res;
	}

	public static String caesarCrypto(String s, int step) {
		String ans = "";
		for (int i = 0; i < s.length(); i++) {
			char c = (char) (s.charAt(i) + step);

			if (c >= 'Z') {
				c = (char) ((c % 'Z') + 'A' - 1);
			}

			ans += c;
		}
		return ans;
	}

}
