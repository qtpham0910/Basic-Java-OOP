import java.util.Scanner;

public class Hex2Dec {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a Hexadecimal string: ");
		String hex = sc.nextLine();
		if(validHec(hex) == true) {
			System.out.println("The equivalent decimal number for hexadecimal \"" + hex + "\" is: " + hexToDec(hex.toUpperCase()));
		}
		else {
			System.out.println("error: invalid hexadecimal string \"" + hex + "\"");
		}
				sc.close();
	}
	
	public static int hexToDec(String hex) {
		int dec = 0;
		for(int i = 0; i < hex.length(); i++) {
			char hexChar = hex.charAt(i);
			dec = dec * 16 + hexConvertToDec(hexChar);
		}
		return dec;
	}
	
	public static int hexConvertToDec(char hexChar) {
		if(hexChar >= 'A' && hexChar <= 'F') {
			return 10 + hexChar - 'A';
		}
		else return hexChar - '0';
	}
	
	public static boolean validHec(String hex) {
		for(int i = 0; i < hex.length(); i++) {
			if( !(( hex.charAt(i) >= '0' &&  hex.charAt(i)<= '9' )
					||( hex.charAt(i) >= 'A' && hex.charAt(i) <= 'F' )
						||(hex.charAt(i) >= 'a' && hex.charAt(i) <= 'f')))
				return false;
		}
		return true;
	}

}
