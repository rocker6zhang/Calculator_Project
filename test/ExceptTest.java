/*
 * test except
 * */
package Calculator_Project.test;

import Calculator_Project.jisuan;

public class  ExceptTest extends MyTest {


	@Override
	public void test(int length) {
		
		//���һ��int�������һ��double�͵�
		double douarr[] =  num.getDoubleArr(length);
		int intarr[] = num.getIntArr(length);
		
		//������������
		for (int i = 0; i < length; i++){

			double value = intarr[i] / douarr[i];
			String str = intarr[i] + "/" + douarr[i];
			String value1 = new jisuan(str).moniton();

			//if ˵���� ������㷵�ص�ֵ�Ǵ���ĸ�ʽ�������ʽ����᷵�أ� "Eorr ��..."��
			//	      ���� �䷵�ص�ֵ�Ǵ���ġ�   ��ô����������ݡ�
			if(value1.startsWith("E") | !isRight(value,Double.valueOf(value1))){
				printTest(str+" = "+value+"--test value:"+value1);
				addComt();
			}
		}
		System.out.println(testResult("ExceptTest"));

		//������ɺ�ر���Դ
		close();

	}



}
