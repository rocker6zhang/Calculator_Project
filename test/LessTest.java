/*
 * test 减法
 * */
package Calculator_Project.test;

import Calculator_Project.jisuan;

public class LessTest extends MyTest {
	
	@Override
	public void test(int much) {
		//获得数据
		int intarr[] = num.getIntArr(much);
		double douarr[] = num.getDoubleArr(much);
		
		//遍历计算数据
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
		//测试完成后关闭资源
		close();
		
	}

}
