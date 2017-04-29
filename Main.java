package Calculator_Project;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Date;

public class Main {
	private myMonitor m;
	private MonitorNumber numble;
	private MonitorFeatures features; 

	private Button zero,b1,b2,b3,b4,b5,b6,b7,b8,b9,
	equal,plus,less,multiply,point,
	except,power,Lbracket,Rbracket,clean,NF;
	private Panel panel,panel2,panel3;
	private Frame window;
	//������
	public static TextField text = new TextField(20);
	//�����
	public static TextField resultText = new TextField(20);

	public Main() {}
	public Main(boolean b) {
		//��ʼ����ض���
		m = new myMonitor();
		numble = new MonitorNumber();
		features = new MonitorFeatures();
		
		//��ʼ��button
		zero = new Button("0");
		b1 = new Button("1");
		b2 = new Button("2");
		b3 = new Button("3");
		b4 = new Button("4");
		b5 = new Button("5");
		b6 = new Button("6");
		b7 = new Button("7");
		b8 = new Button("8");
		b9 = new Button("9");

		equal = new Button("=");
		plus = new Button("+");
		less = new Button("-");
		multiply = new Button("*");
		point = new Button(".");
		except = new Button("/");
		power = new Button("^");
		Lbracket = new Button("(");
		Rbracket = new Button(")");
		clean = new Button("clean");
		NF = new Button("NF");
		b1.setMinimumSize(null);
		//��ʼ���������
		window = new Frame("Calculator");
		panel = new Panel();panel2 = new Panel();panel3 = new Panel();
		//text = new TextField(20);
		//�������
		set();
		//������������
		add();

		//����
		monitor();
		//m.manitor(window);
		window.setVisible(true);


	}
	//��������
	private void monitor() {
		Button arr[] = {b7,b8,b9,plus,power,b4,b5,b6,less,Lbracket,b1,b2,b3,multiply,Rbracket,zero,
				point,except};
		for(int i = 0; i < arr.length; i++){
			arr[i].addActionListener(numble);
		}
		clean.addActionListener(features);
		equal.addActionListener(features);
		//m.monitor1(NF);
		m.monitor(window);
		
		//b1.addActionListener(m);


	}
	//�������
	private void set() {
		// TODO Auto-generated method stub
		window.setSize(228, 300);
		window.setResizable(false);
		panel.setLayout(new BorderLayout());
		panel.setSize(100,100);
		panel2.setLayout(new GridLayout(5,5,4,4));
		panel3.setLayout(new BorderLayout());

		//SET text
		
		text.setEditable(false);
		text.setBackground(Color.PINK);
		resultText.setEditable(false);
		resultText.setBackground(Color.GREEN);

	}
	//������
	private void add() {
		// TODO Auto-generated method stub
		Button arr[] = {b7,b8,b9,plus,power,b4,b5,b6,less,Lbracket,b1,b2,b3,multiply,Rbracket,zero,
				point,equal,except,
				clean,NF};
		addSome(panel2,arr);
		panel3.add(text,BorderLayout.NORTH);
		panel3.add(resultText,BorderLayout.CENTER);
		panel.add(panel3,BorderLayout.NORTH);
		panel.add(panel2,BorderLayout.CENTER);
		//window.add(panel2);
		window.add(panel);

	}
	//ѭ��������
	private void addSome(Container bady, Component[] arr) {
		// TODO Auto-generated method stub
		for(int i = 0; i < arr.length; i++){
			bady.add(arr[i]);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(new Date());
		new Main(true);
	}



}
