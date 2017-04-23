package myCalculator;


public class myMath {
	private double value;
	
	//ÇóÖ¸Êý
	public String power(String base, String index){
		value = Math.pow(Double.valueOf(base), Double.valueOf(index));
		return String.valueOf(value);
		
	}
	//is plus
	public String plus(String str, String str2){
		System.out.println(str+"**"+str2);
		value = Double.valueOf(str) + Double.valueOf(str2);
	
		return String.valueOf(value);
	}
	
	//is less
	public String less(String str, String str2){
		value = Double.valueOf(str) - Double.valueOf(str2);
		return String.valueOf(value);
	}
	
	//is multiply
	public String multiply(String str, String str2){
		System.out.println(str+"**"+str2);
		value = Double.valueOf(str) * Double.valueOf(str2);
		return String.valueOf(value);
	}
	
	//is except
	public String exsept(String str, String str2){
		value = Double.valueOf(str) / Double.valueOf(str2);
		return String.valueOf(value);
	}
}
