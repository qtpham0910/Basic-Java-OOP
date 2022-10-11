import java.lang.ref.PhantomReference;
import java.util.Scanner;

public class TestPalindromicPhrase {
    
    public static void main(String[] args) {
    	
        TestPalindromicPhrase aTestPalindromicPhrase = new TestPalindromicPhrase();
        
//       aTestPalindromicPhrase.run("Madam, I'm Adam");
//       aTestPalindromicPhrase.run("A man, a plan, a canal - Panama!");
        
        Scanner sc = new Scanner(System.in);
        String  phrase;        
        System.out.print("Enter a phrase to test it for palindromic: ");
        phrase = sc.nextLine();        
        aTestPalindromicPhrase.check(phrase);
        System.out.println("Using alternate check function");
        aTestPalindromicPhrase.checkAlternate(phrase);
        sc.close();
    }
    
    
    private void check(String phrase)
    {
        String left2Right = modifyString(phrase); // clean quote 
        String right2Left = "";
        for(int i = left2Right.length() - 1; i >= 0; i-- ) {
        	right2Left += left2Right.charAt(i);
        }
        
        if (left2Right.toLowerCase().equals(right2Left.toLowerCase())) {
            System.out.printf("\"%1$s\" is a palindrome.\n", phrase);
        } else {
            System.out.printf("\"%1$s\" is not a palindrome.\n", phrase);
        }
    }
    
    private void checkAlternate(String phrase) {
    	int fldx = 0;
    	int bldx = 0;
    	Boolean chk= true;
    	while(fldx < bldx) {
    		if(!(Character.isLetter(phrase.charAt(fldx)))) {
    			++fldx;
    		}
    		if(!(Character.isLetter(phrase.charAt(bldx)))) {
    			--bldx;
    		}
    		
    		if( phrase.charAt(fldx) != phrase.charAt(bldx)) {
    			chk = false;
    			break;
    		}
    		++fldx;
			++bldx;
    	}
    	
    	if(chk) {
    		System.out.printf("\"%1$s\" is a palindrome.\n", phrase);
        } else {
            System.out.printf("\"%1$s\" is not a palindrome.\n", phrase);
        }
    	
    }
    
    private String modifyString(String s)
    {
        String str = "";
        for(int i = 0; i < s.length(); i++)
        {
          
            if((Character.isLetter(s.charAt(i)))) {
            	str += s.charAt(i);
            }
        }
        return str;
    }
}