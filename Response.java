package myCalculator;

import java.awt.Button;

/*
 * �¼����� or ��Ӧ
 * */
public class Response {
	//��¼����
	private StringBuilder sb = new StringBuilder("c");
	//���뻺����
	private SetText st = new SetText();
	//�������ı�
	private String text = null;
	
	//������
	private int comt = 0; 
	
	
	private static Response response = new Response();
	private Response(){}
	
	
	//���밴��������¼���룬print����
	public void write(String str) {
//		if(str.equals("+")|str.equals("-")|str.equals("*")|str.equals("/")){
//			comt++;
//			if(comt >= 2){
//				equel();
//				comt--;
//			}
//		}
		sb.append(str);
		st.setText(sb.toString());
	}
	
	

	//���ܰ�������
	public void response(String str){
		if(str.equals("=")){
			 //�ö��̷߳�ʽ�������
			
			setText();//ͬ���������ж���һ�������Ƿ��Ѽ����꣨ȡ�ߣ���Ȼ���ִ�к�������
			
			//	Thread.sleep(1000);//��������
			
			new Thread(new Runnable(){
				public void run(){
					equel();
				}
			}).start();
			
		}
		else if(str.equals("clean")){
			clean();
		}
		else{

		}
	}
	
	//����= ���������ı��������㷽��
	private void equel(){
		String text = getText();
		st.setResultText(new jisuan(text).moniton());
		
			}
	//������뻺����
	private void myDelete() {
		// TODO Auto-generated method stub
		sb.delete(0, sb.length());
		sb.append("c");
	}



	//����clean��//����������������뻺����
	private void clean(){
		//System.out.println("clean");
		myDelete();
		st.setText("");
		st.setResultText("");
	}

//��������
	public static Response getResponse() {
		return response;
	}

/*ȡ����������
 * ����ȡ����������ݣ����������߳�
 * */
	public synchronized String getText() {
		String copyStr = this.text;
		this.text = null;
		this.notifyAll();
		return copyStr;
	}

/*������ı��ʽ�ı�copy�������õ�String�б��档
 * ͬ��������
 * 		���String��Ϊnull����ʾ����û�б�ȡ�ߣ�Ϊ���ø�������wait
 * */
	public synchronized void setText() {
		if(text != null){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.text = sb.toString();
		//����copy���������뻺����
		myDelete();
	}



	
}
