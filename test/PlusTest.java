package Calculator_Project.test;

import Calculator_Project.jisuan;


public class PlusTest extends MyTest{


	@Override
	//much�������������
	public void test(int much) {
		// TODO Auto-generated method stub
		//��ȡ��������
		int arr[] = num.getIntArr(much);
		int arr2[] = num.getIntArr(much);

		//������������
		for (int i = 0; i < much; i++){

			int value = arr[i] + arr2[i];
			String str = arr[i] + "+" + arr2[i];
			String value1 = new jisuan(str).moniton();
//			System.out.println(Double.valueOf(value).doubleValue() +"***"+ Double.valueOf(value).doubleValue());
			if(!isRight(value,Double.valueOf(value1))){
				printTest(str+" = "+value+"--test value:"+value1);
				addComt();
			}

		}

		System.out.println(testResult("plus"));
		//������ɺ�ر���Դ
		close();
	}

}
