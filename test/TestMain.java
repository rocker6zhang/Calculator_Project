package Calculator_Project.test;
/*
 * ��������Ŀ����������
 * */
import java.util.ArrayList;
import java.util.List;

public class TestMain implements Runnable {
	int size;
	List<CalculatorTest> tests;//�����༯��
	
	public TestMain(){
		this(10);
	}
	
	public TestMain(int size){
		
		this.size = size;
		tests = new ArrayList<CalculatorTest>();

		CalculatorTest  less = new LessTest(),
		plus = new PlusTest(),
		mul = new MultiplyTest(),
		exc = new ExceptTest(),
		all = new All();

		tests.add(less);
		tests.add(mul);
		tests.add(plus);
		tests.add(exc);
		tests.add(all);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����������Բ���
		for(int i = 0; i < 5; i++){
			new Thread(new TestMain(1000)).start();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(CalculatorTest ct : tests){
			ct.test(size);
		}
	}


}
