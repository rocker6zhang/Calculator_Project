/*
 * test except
 * */
package Calculator_Project.test;

import Calculator_Project.jisuan;

public class  ExceptTest extends MyTest {


	@Override
	public void test(int length) {
		
		//获得一组int型数组和一组double型的
		double douarr[] =  num.getDoubleArr(length);
		int intarr[] = num.getIntArr(length);
		
		//遍历计算数据
		for (int i = 0; i < length; i++){

			double value = intarr[i] / douarr[i];
			String str = intarr[i] + "/" + douarr[i];
			String value1 = new jisuan(str).moniton();

			//if 说明： 如果计算返回的值是错误的格式（假如格式错误会返回： "Eorr ：..."）
			//	      或者 其返回的值是错误的。   那么输出错误数据。
			if(value1.startsWith("E") | !isRight(value,Double.valueOf(value1))){
				printTest(str+" = "+value+"--test value:"+value1);
				addComt();
			}
		}
		System.out.println(testResult("ExceptTest"));

		//测试完成后关闭资源
		close();

	}



}
