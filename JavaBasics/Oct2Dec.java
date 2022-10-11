import java.util.Scanner;

public class Oct2Dec {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a Octal string: ");
		String oct = sc.nextLine();
		if(validOct(oct) == true) {
			System.out.println("The equivalent decimal number\"" + oct + "\" is: " + octToDec(oct.toUpperCase()));
		}
		else {
			System.out.println("error: invalid octal string \"" + oct + "\"");
		}
				sc.close();
	}
	
	public static int octToDec(String oct) {
		int dec = 0;
		for(int i = 0; i < oct.length(); i++) {
			char octChar = oct.charAt(i);
			dec = dec * 8 + octConvertToDec(octChar);
		}
		return dec;
	}
	
	public static int octConvertToDec(char hexChar) {
		 return hexChar - '0';
	}
	
	public static boolean validOct(String hex) {
		for(int i = 0; i < hex.length(); i++) {
			if( !( hex.charAt(i) >= '0' &&  hex.charAt(i)<= '7' ) )
				return false;
		}
		return true;
	}

}
