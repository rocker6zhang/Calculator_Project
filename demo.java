package Calculator_Project;

public class demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		double d = 12345678901234567890D;
//	    System.out.println(String.format("%.10f", d));
//	//------------------------------------
//	    double d1 = 4573519.2101027435;
//	    System.out.println(String.format("%.4f", d1));
		String s = "123--234+-123-+123++123";
		s = s.replaceAll("--", "+");
		s = s.replaceAll("[+][+]", "+");
		s = s.replaceAll("[+-][+-]", "-");
		System.out.println(String.format("%.6f", -0.6552412801925255/679.7005729753894));
	}}





