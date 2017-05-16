package Calculator_Project;

import java.math.BigDecimal;


public class myMath {
	private double value;
	private final int acy = 8;
	
	//ÇóÖ¸Êý
	public String power(String base, String index){
		value = Math.pow(Double.valueOf(base), Double.valueOf(index));
		return String.format("%.6f", value);
		
	}
	//is plus
	public String plus(String str, String str2){
//		System.out.println(str+"**"+str2);
		value = Double.valueOf(str) + Double.valueOf(str2);
	
		return String.format("%."+acy+"f", value);
		//String.valueOf(value);
	}
	
	//is less
	public String less(String str, String str2){
		value = Double.valueOf(str) - Double.valueOf(str2);
		return String.format("%."+acy+"f", value);
	}
	
	//is multiply
	public String multiply(String str, String str2){
		 BigDecimal b = new  BigDecimal(str);
		 BigDecimal b2 = new  BigDecimal(str2);
		 b = b.multiply(b2);
		return String.format("%."+acy+"f", b);
		
	}
	
	//is except
	public String exsept(String str, String str2){
//		System.out.println("//"+str+"**"+str2);
		
//		System.out.println(value);
		return String.format("%."+acy+"f", Double.valueOf(str) / Double.valueOf(str2) );
	}
}
