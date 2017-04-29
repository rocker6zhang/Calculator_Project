/*
 * ���ܣ�
 * 		���������ȼ�������ʽ��ֵ��
 * ˼·��
 * 		�����ȼ��Ӹߵ���ƥ���滻���ʽ�Ӵ���
 * 			���ʹ������ƥ�䵽���Ӵ���ֵ���滻ԭ�����Ӵ���
 * 			���Ӵ�ƥ�䵽��Ԫ���ʽ��
 * 			ѭ��ʹ�á�find������Ѱ��ƥ�䣬ƥ�������ƥ������ֱ��find����false��
 * 		���ȼ��Ӹߵ��������ǣ����š�ָ�����˳����Ӽ�
 * ʵ�֣�
 * 		1.�����������ֵ��ȥ������
 * 		2.��ָ�������ֵ��ȥ��ָ����
 * 		3.����˳�����ֵ��ȥ���˳�����ֵʱ
 * 		4.����Ӽ�����ֵ��ȥ���Ӽ��ţ�
 * 		�õ���������ȼ��ļ�����Ҫ���õ����ȼ�
 * 
 * */

package Calculator_Project;

import java.awt.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class jisuan {
	myMath math = new myMath();


	private String str;
	private String oldstr;//\\d+\\.*\\d*
	private String reg1 = "(((\\([^()]+\\))))";//ƥ������
	private String reg2 = "(([+,-,*,/,c]{0,1})(\\-{0,1}\\d+\\.{0,1}\\d*\\^\\-{0,1}\\d+\\.{0,1}\\d*))";//ƥ��ָ��
	private String reg3 = "(([+,-,*,/,c]{0,1})(\\-{0,1}\\d+\\.{0,1}\\d*[*/]\\-{0,1}\\d+\\.{0,1}\\d*))";//ƥ��˳�
	private String reg4 = "(([+,-,*,/,c]{0,1})(\\-{0,1}\\d+\\.{0,1}\\d*[+-]\\-{0,1}\\d+\\.{0,1}\\d*))";//ƥ��Ӽ�
	
	private String reg5 = "-*\\d*\\.{0,1}\\d*E*-*\\d*";
	private String error = "Error : Illegal expression";

	public jisuan(String string){
		this.str = "c"+string;
		//System.out.println("string***"+string);
	}
	public String moniton(){
		brackets();
		power();
		no1();
		no2();
		str = str.substring(1, str.length());
		if(isRight()){
			oldstr = str;
			return str;	
		}else{
//			System.out.println(str);
			return error;
		}


	}
	//ƥ��Ӽ���and ��ֵ����
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
				//���⴦��
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
	//ƥ��˳���and ��ֵ����
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
			str = str.replace(chaildStr, value);
		}
	}

	private boolean findSymbol(String chaildStr, String reg) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(chaildStr);
		return m.find();
	}
	//ƥ��ָ��and ��ֵ����
	private void power() {
		// TODO Auto-generated method stub
		String chaildStr = null;
		while((chaildStr = find(reg2)) != null){
			String arrStr[] = chaildStr.split("\\^");
			String value = math.power(arrStr[0], arrStr[1]);
			str = str.replace(chaildStr, value);
		}


	}

	//ƥ�����ŷ���
	private void brackets() {
		// TODO Auto-generated method stub
		String chaildStr = null;
		while((chaildStr = find(reg1)) != null){
			//��found��strȥ����
			String bracketStr = chaildStr.substring(1,chaildStr.length()-1);
			//�ݹ���ü��㷽����ֵ,����bracketStr
			bracketStr = new jisuan(bracketStr).moniton();
			//���󵽵�ֵ�滻found��������
			str = str.replace(chaildStr, bracketStr);
		}

	}

	//find ƥ��//��Ҫ����ƥ����
	private String find( String reg) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str);
		//ƥ��
		if(m.find(0)){
			return m.group(3);
		}
		return null;
	}
	
	//find ƥ��//��Ҫ����ƥ����
	private String find(String text, String reg) {
		// TODO Auto-generated method stub
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(text);
		//ƥ��
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



}


/*
 * 
 * //			Pattern p = Pattern.compile(string);
//			Matcher m = p.matcher(sb2);
//			//ѭ��ƥ��
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





//private String reg1 = "\\([^()]+\\)";//ƥ������
//private String reg2 = "\\d+\\.*\\d*\\^\\d+\\.*\\d*";//ƥ��ָ��
//private String reg3 = "\\d+\\.*\\d*[*/]\\d+\\.*\\d*";//ƥ��˳�
//private String reg4 = "\\d+\\.??\\d*[+-]\\d+\\.{0,1}\\d*";//ƥ��Ӽ�
//private String reg5 = "-*\\d*\\.*\\d*E*-*\\d*";
//private String error = "Error : Illegal expression";

