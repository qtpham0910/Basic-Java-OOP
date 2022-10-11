import java.util.Scanner;

public class RadixN2Dec {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the radix: "); // Radix should not bigger than 16
		int radix = sc.nextInt();
		sc.nextLine();
		if (radix <= 1 || radix > 16) {
			System.out.println("error: Invalid radix input.");
			System.exit(0);
		}
		System.out.print("Enter the string: ");
		String num = sc.nextLine();
		if (validNumber(num, radix) == true) {
			System.out.println(
					"The equivalent decimal number \"" + num + "\" is: " + convertToDec(num.toUpperCase(), radix));
		} else {
			System.out.println("error: invalid octal string \"" + num + "\"");
		}
		sc.close();
	}

	public static int convertToDec(String num, int radix) {
		int dec = 0;
		for (int i = 0; i < num.length(); i++) {
			char numChar = num.charAt(i);
			dec = dec * radix + charConvertToDec(numChar, radix);
		}
		return dec;
	}

	public static int charConvertToDec(char numChar, int radix) {
		if (radix > 10) {
			if (numChar >= 'A' && numChar - radix + 16 <= 'F') {
				return 10 + numChar - 'A';
			}
			return numChar - '0';
		} else {
			return numChar - '0';
		}
	}

	public static boolean validNumber(String num, int radix) {
		if (radix > 10) {
			for (int i = 0; i < num.length(); i++) {
				if (!((num.charAt(i) >= '0' && num.charAt(i) <= '9')
						|| (num.charAt(i) >= 'A' && num.charAt(i) + 16 - radix <= 'F')
						|| (num.charAt(i) >= 'a' && num.charAt(i) + 16 - radix <= 'f')))

					return false;
			}
			return true;
		} else {
			for (int i = 0; i < num.length(); i++) {
				if (!(num.charAt(i) >= '0' && num.charAt(i) + 10 - radix <= '9'))
					return false;
			}
			return true;
		}

	}

}
