package woodferren.izak.palindrome;

import android.util.Log;

public abstract class StringProcessor {
	
	public static boolean isValidString(String str){
		if(Character.isDigit(str.charAt(0))){ //number only string
			try{
				Double.parseDouble(str);
				return true;
			}catch(Exception ex){
				return false;
			}
		}else{ //character only string
			for(int i = 0; i < str.length(); i++){
				if(Character.isDigit(str.charAt(i))){
					return false;
				}
			}
			return true;
		}
	}
	
	public static String removePunc(String str){
		String temp = "";
		
		for(int i = 0; i < str.length(); i++){
			char strChar = str.charAt(i);
			
			if(Character.isLetterOrDigit(strChar)){
				temp += strChar;
			}
		}

		Log.d("DEBUG", "String after parsing: " + temp);
		
		return temp;
	}
	
	public static String flipString(String str){
		String temp = "";
		
		for(int i = str.length()-1; i >=0; i--){
			temp+=str.charAt(i);
		}

		Log.d("DEBUG", "String after flip: " + temp);
		
		return temp;
	}
}
