package woodferren.izak.palindrome;

public class PalindromeChecker {
	
	private String str;
	private boolean isPalindrome;
	
	public PalindromeChecker(String str) {
		setStr(str);
		
		//Check if palindrome
		isPalindrome = palindromeCheck(str);
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public boolean isPalindrome() {
		return isPalindrome;
	}
	
	private boolean palindromeCheck(String str){
		
		//Create a temporary copy of incoming string
		str = str.toLowerCase();
		System.out.println("String to lower case: " + str);
		//Remove punctuations
		str = StringProcessor.removePunc(str);
		//Assign temp string
		String temp = StringProcessor.flipString(str);
		
		System.out.println("Temporary string: " + temp);
		
		for(int i = 0; i < str.length(); i++){
			if(temp.charAt(i) != str.charAt(i))
				return false;
		}
		return true;
		
	}
	
}
