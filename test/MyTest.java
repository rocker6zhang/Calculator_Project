package Calculator_Project.test;
/*
 * 测试抽象类，将一些公用的方法抽象出来复用
 * 
 * */
import java.io.IOException;

import Calculator_Project.log.WriteLog;




public abstract class MyTest implements CalculatorTest {

	private static final double max = 0.00001;//比较double大小的精度值
	private static final int size = 1000;//随机数最大值
	private int comt = 0;//错误计数

	//测试记录存放位置
	private final String teatFilePath = "c:";
	private final String testFileName = "myTest.txt";
	//错误信息存放位置
	private final String eorrFilePath = "c:";
	private final String eorrFileName = "c:myEorr";

	//产生随机数的对象
	protected Number num;

	//记录信息的对象
	protected WriteLog write = null;
	protected WriteLog exceptionWrite = null ; 

	//初始化参数
	public MyTest(){

		num = new Number(size);
		try {
			write = new WriteLog(teatFilePath,testFileName);
			exceptionWrite = new WriteLog(eorrFilePath,eorrFileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//输出测试数据到文件
	public void printTest(String ...str){
		for(String i : str){
			try {
				write.writeLine(i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				exceptionWrite.write(e);
				close();
			} 	
		}
	}

	//判断计算结果
	public boolean isRight(double d1, double d2){
		double s = d1 - d2;
		return (s < max && s > -max);
	}

	//输出最终测试结果
	public String testResult(String name){
		if(comt == 0){
			return(name+" test is right!!!");
		} else{
			return(name+"-erro：" + comt);
		}
	}

	public void close(){
		if(write != null){
			try {
				write.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				exceptionWrite.write(e);
			}
		}
		if(exceptionWrite != null){
			try {
				exceptionWrite.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block

			}
		}
	}


	public Number getNum() {
		return num;
	}

	public WriteLog getWrite() {
		return write;
	}

	public WriteLog getExceptionWrite() {
		return exceptionWrite;
	}

	public int getComt() {
		return comt;
	}
	public void addComt() {
		this.comt++;
	}


}
