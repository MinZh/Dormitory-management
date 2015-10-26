package SuShe.com.Function;

import java.io.UnsupportedEncodingException;

public class encodingFunction {
	public static String getMethodEncoding(String input){
		try {
			String result=new String(input.getBytes("iso-8859-1"),"UTF-8");
			return result;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
