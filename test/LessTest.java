/*
 * test ����
 * */
package Calculator_Project.test;

import Calculator_Project.jisuan;

public class LessTest extends MyTest {
	
	@Override
	public void test(int much) {
		//�������
		int intarr[] = num.getIntArr(much);
		double douarr[] = num.getDoubleArr(much);
		
		//������������
		for (int i = 0; i < much; i++){
			
			double value = intarr[i] - douarr[i];
			String str = intarr[i] + "-" + douarr[i];
			String value1 = new jisuan(str).moniton();
			
			if(value1.startsWith("E") | !isRight(value,Double.valueOf(value1))){
				printTest(str+" = "+value+"--test value:"+value1);
				addComt();
				}
			
		}
		System.out.println(testResult("less"));
		//������ɺ�ر���Դ
		close();
		
	}

}
