/*
 * 功能：
 * 		按运算优先级计算表达式的值。
 * 思路：
 * 		按优先级从高到低匹配替换表达式子串；
 * 			求出使用正则匹配到的子串的值，替换原来的子串。
 * 			将子串匹配到二元表达式。
 * 			循环使用“find（）”寻找匹配，匹配后重置匹配器，直到find返回false。
 * 		优先级从高到低依次是：括号、指数、乘除、加减
 * 实现：
 * 		1.先求括号里的值。去除括号
 * 		2.求指数运算的值，去除指数号
 * 		3.再求乘除法的值，去除乘除号求值时
 * 		4.计算加减法的值，去除加减号，
 * 		得到结果高优先级的计算需要调用低优先级
 * 
 * */

package Calculator_Project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class jisuan {
	myMath math = new myMath();


	private String str;//\\d+\\.*\\d*
	private String reg1 = "(((\\([^()]+\\))))";//匹配括号
	private String reg2 = "(([+,-,*,/,c]{0,1})(\\-{0,1}\\d+\\.{0,1}\\d*\\^\\-{0,1}\\d+\\.{0,1}\\d*))";//匹配指数
	private String reg3 = "(([+,-,*,/,c]{0,1})(\\-{0,1}\\d+\\.{0,1}\\d*[*/]\\-{0,1}\\d+\\.{0,1}\\d*))";//匹配乘除
	private String reg4 = "(([+,-,*,/,c]{0,1})(\\-{0,1}\\d+\\.{0,1}\\d*[+-]\\-{0,1}\\d+\\.{0,1}\\d*))";//匹配加减
	
	private String reg5 = "-*\\d*\\.{0,1}\\d*E*-*\\d*";
	private String error = "Error : Illegal expression";
	static int num = 0;
	int count  = 0;
	public jisuan(String string){
		this.str = "c"+string;
		num++;
		this.count = num;
		//System.out.println("string***"+string);
	}
	public String moniton(){
		brackets();
		//System.out.println(count+"**"+"括号：--"+str);
		power();
//		System.out.println(count+"**"+"指数：--"+str);
		no1();
//		System.out.println(count+"**"+"乘除：--"+str);
		no2();
//		System.out.println(count+"**"+"加减：--"+str);
		
		//处理最终结果
		finalValue(str);
		
		if(isRight()){
			return str;	
		}else{
			//System.out.println("****eroo"+str);
			return error;
		}


	}
	private void finalValue(String str2) {
		str = str.substring(1, str.length());
		if(str.startsWith("+")){
			str = str.substring(1, str.length());
		}
	}
	//匹配加减法and 求值方法
	private void no2() {
		// TODO Auto-generated method stub
		String chaildStr = null;
		while((chaildStr = find(reg4)) != null){
			String value = null;
			if(findSymbol(chaildStr,"\\+")){
				String arrStr[] = chaildStr.split("[+]");
				value = math.plus(arrStr[0],arrStr[1]);
			}
			else{
				//特殊处理
				String a = find(chaildStr,"\\-{0,1}\\d+\\.{0,1}\\d*");
				String b = find(chaildStr, "[\\d\\.]\\-{1,2}\\d+\\.{0,1}\\d*");
				b = b.substring(2, b.length());
				//String arrStr[] = chaildStr.split("[-]");
				value = math.less(a,b);
			}
			String h = str.replace(chaildStr, value);
			str = h;
		}

	}
	//匹配乘除法and 求值方法
	private void no1()  {
		// TODO Auto-generated method stub
		String chaildStr = null;
		while((chaildStr = find(reg3)) != null){
			String value = null;
			String arrStr[] = chaildStr.split("[*/]");
			
			if(findSymbol(chaildStr,"\\*")){
				value = math.multiply(arrStr[0],arrStr[1]);
			}
			else{
				value = math.exsept(arrStr[0],arrStr[1]);
			}
			//System.out.println("1value = "+value);
			//处理value,假如是正数的话 添加符号“+”
			value = addSymbol(value);
			
			str = str.replace(chaildStr, value);
			//System.out.println("value = "+value);
			//处理符号错误
			isError();
		}
	}

	private void isError() {
		//str = str.replaceAll("--", "+");
		str = str.replaceAll("[-][-]", "+");
		str = str.replaceAll("[+][+]", "+");
		str = str.replaceAll("[+-][+-]", "-");
	}
	private String addSymbol(String value) {
		//double dou = Double.valueOf(value);
		if(!value.startsWith("-")){
			return "+"+value;
		}
		return value;
		
		
		
	}
	private boolean findSymbol(String chaildStr, String reg) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(chaildStr);
		return m.find();
	}
	//匹配指数and 求值方法
	private void power() {
		// TODO Auto-generated method stub
		String chaildStr = null;
		while((chaildStr = find(reg2)) != null){
			String arrStr[] = chaildStr.split("\\^");
			String value = math.power(arrStr[0], arrStr[1]);
			str = str.replace(chaildStr, value);
		}


	}

	//匹配括号方法
	private void brackets() {
		// TODO Auto-generated method stub
		String chaildStr = null;
		while((chaildStr = find(reg1)) != null){
			//把found的str去括号
			String bracketStr = chaildStr.substring(1,chaildStr.length()-1);
			//递归调用计算方法求值,赋给bracketStr
			bracketStr = new jisuan(bracketStr).moniton();
			//用求到的值替换found到的括号
			str = str.replace(chaildStr, bracketStr);
		}

	}

	//find 匹配//需要重置匹配器
	private String find( String reg) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str);
		//匹配
		if(m.find(0)){
			return m.group(3);
		}
		return null;
	}
	
	//find 匹配//需要重置匹配器
	private String find(String text, String reg) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(text);
		//匹配
		if(m.find(0)){
			return m.group();
		}
		return null;
	}


	// is split
	private String[] split(String findReg, String splitReg) {
		// TODO Auto-generated method stub
		//first find reg then split it
		String chaildStr = null;
		while((chaildStr = find(findReg)) != null){
			String arrStr[] = chaildStr.split(splitReg);
			return arrStr;
		}
		return null;
	}

	//is final
	public boolean isRight(){
		return str.matches(reg5);
	}
	public String getStr() {
		return str;
	}



}


/*
 * 
 * //			Pattern p = Pattern.compile(string);
//			Matcher m = p.matcher(sb2);
//			//循环匹配
//			while(m.find()){
//				String str = power(new StringBuffer(m.group()),reg2).toString();
//				m.appendReplacement(sb2, str);
//			}
//			 m.appendTail(sb2);
			if (find() != null){

			}else{
				break;
			}
 * */





//private String reg1 = "\\([^()]+\\)";//匹配括号
//private String reg2 = "\\d+\\.*\\d*\\^\\d+\\.*\\d*";//匹配指数
//private String reg3 = "\\d+\\.*\\d*[*/]\\d+\\.*\\d*";//匹配乘除
//private String reg4 = "\\d+\\.??\\d*[+-]\\d+\\.{0,1}\\d*";//匹配加减
//private String reg5 = "-*\\d*\\.*\\d*E*-*\\d*";
//private String error = "Error : Illegal expression";

