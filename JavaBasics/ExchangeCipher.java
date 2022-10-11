import java.util.Scanner;

public class ExchangeCipher {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a plaintext string: ");
		String str = sc.nextLine().toUpperCase();
		
		System.out.print("The cyphertext string is: " + exchangeCipher(str));
		sc.close();
	}
	
	public static String exchangeCipher(String s) {
		String res = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
				res += Character.toString('A' + 'Z' - s.charAt(i));
			else 
				res += s.charAt(i);
		}
		return res;
	}
	
	public static String exchangeCipherAllStep(String s) {
		String ans = "";
		return ans;
	}
	
}
