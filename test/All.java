/*
 * �ò�����������
 * */
package Calculator_Project.test;

import Calculator_Project.jisuan;

public class All extends MyTest {

	@Override
	public void test(int much) {

		//��ȡ��������
		double arr[] = num.getDoubleArr(much);
		double arr2[] = num.getDoubleArr(much);
		
		//������������
		for (int i = 0; i < much; i++){
			//��������
			double value = arr[i] + arr2[i] * arr[i] - arr2[i] / arr[i] + 
			(arr2[i] / (arr[i] + arr2[i] )) +( arr[i] + arr2[i] );

			String str = arr[i] +"+"+ arr2[i] +"*"+ arr[i] +"-"+ arr2[i] +"/"+ arr[i] +"+"+ 
			"("+arr2[i] +"/"+"("+arr[i] +"+"+ arr2[i]+")"+")" +"+"+"("+arr[i] +"+"+ arr2[i]+")";

			//������
			String value1 = new jisuan(str).moniton();

			//if ˵���� ������㷵�ص�ֵ�Ǵ���ĸ�ʽ�������ʽ����᷵�أ� "Eorr ��..."��
			//	      ���� �䷵�ص�ֵ�Ǵ���ġ�   ��ô����������ݡ�
			if(value1.startsWith("E") | !isRight(value,Double.valueOf(value1))){
				printTest(str+" = "+value+"--test value:"+value1);
				addComt();

			}
		}
		//������Խ��
		System.out.println(testResult("All"));
		//������ɺ�ر���Դ
		close();
	}

}
