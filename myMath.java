package Calculator_Project;

import java.math.BigDecimal;
import java.math.MathContext;


public class myMath {
	private double value;
	private final int acy = 8;
	private MathContext context = new MathContext(acy*2);

	//ÇóÖ¸Êý
	public String power(String base, String index){
		value = Math.pow(Double.valueOf(base), Double.valueOf(index));
		return String.format("%."+acy+"f", value);

	}
	//is plus
	public String plus(String str, String str2){
		BigDecimal b = new  BigDecimal(str,context);
		BigDecimal b2 = new  BigDecimal(str2,context);
		b = b.add(b2);
		return String.format("%."+acy+"f", b );
		//String.valueOf(value);
	}

	//is less
	public String less(String str, String str2){
		BigDecimal b = new  BigDecimal(str);
		BigDecimal b2 = new  BigDecimal(str2);
		b = b.subtract(b2);
		return String.format("%."+acy+"f", b);
	}

	//is multiply
	public String multiply(String str, String str2){

		BigDecimal b = new  BigDecimal(str,context);
		BigDecimal b2 = new  BigDecimal(str2,context);
		b = b.multiply(b2);
		return String.format("%."+acy+"f", b);

	}

	//is except
	public String exsept(String str, String str2){
		//System.out.println(str+"*****"+str2);
		BigDecimal b = new  BigDecimal(str,context);
		BigDecimal b2 = new  BigDecimal(str2,context);
		b = b.divide(b2,context);
		return String.format("%."+acy+"f", b );
	}
}
