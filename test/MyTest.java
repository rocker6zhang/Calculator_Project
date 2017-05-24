package Calculator_Project.test;
/*
 * ���Գ����࣬��һЩ���õķ��������������
 * 
 * */
import java.io.IOException;

import Calculator_Project.log.WriteLog;




public abstract class MyTest implements CalculatorTest {

	private static final double max = 0.00001;//�Ƚ�double��С�ľ���ֵ
	private static final int size = 1000;//��������ֵ
	private int comt = 0;//�������

	//���Լ�¼���λ��
	private final String teatFilePath = "c:";
	private final String testFileName = "myTest.txt";
	//������Ϣ���λ��
	private final String eorrFilePath = "c:";
	private final String eorrFileName = "c:myEorr";

	//����������Ķ���
	protected Number num;

	//��¼��Ϣ�Ķ���
	protected WriteLog write = null;
	protected WriteLog exceptionWrite = null ; 

	//��ʼ������
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

	//����������ݵ��ļ�
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

	//�жϼ�����
	public boolean isRight(double d1, double d2){
		double s = d1 - d2;
		return (s < max && s > -max);
	}

	//������ղ��Խ��
	public String testResult(String name){
		if(comt == 0){
			return(name+" test is right!!!");
		} else{
			return(name+"-erro��" + comt);
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
