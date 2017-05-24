/*
 * 用测试用例测试
 * */
package Calculator_Project.test;

import Calculator_Project.jisuan;

public class All extends MyTest {

	@Override
	public void test(int much) {

		//获取测试数据
		double arr[] = num.getDoubleArr(much);
		double arr2[] = num.getDoubleArr(much);
		
		//遍历计算数据
		for (int i = 0; i < much; i++){
			//测试用例
			double value = arr[i] + arr2[i] * arr[i] - arr2[i] / arr[i] + 
			(arr2[i] / (arr[i] + arr2[i] )) +( arr[i] + arr2[i] );

			String str = arr[i] +"+"+ arr2[i] +"*"+ arr[i] +"-"+ arr2[i] +"/"+ arr[i] +"+"+ 
			"("+arr2[i] +"/"+"("+arr[i] +"+"+ arr2[i]+")"+")" +"+"+"("+arr[i] +"+"+ arr2[i]+")";

			//计算结果
			String value1 = new jisuan(str).moniton();

			//if 说明： 如果计算返回的值是错误的格式（假如格式错误会返回： "Eorr ：..."）
			//	      或者 其返回的值是错误的。   那么输出错误数据。
			if(value1.startsWith("E") | !isRight(value,Double.valueOf(value1))){
				printTest(str+" = "+value+"--test value:"+value1);
				addComt();

			}
		}
		//输出测试结果
		System.out.println(testResult("All"));
		//测试完成后关闭资源
		close();
	}

}
