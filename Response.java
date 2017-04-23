package myCalculator;

import java.awt.Button;

/*
 * 事件处理 or 响应
 * */
public class Response {
	//记录输入
	private StringBuilder sb = new StringBuilder("c");
	//输入缓存区
	private SetText st = new SetText();
	//待处理文本
	private String text = null;
	
	//计数器
	private int comt = 0; 
	
	
	private static Response response = new Response();
	private Response(){}
	
	
	//输入按键处理，记录输入，print输入
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
	
	

	//功能按键处理
	public void response(String str){
		if(str.equals("=")){
			 //用多线程方式处理计算
			
			setText();//同步方法，判断上一次数据是否已计算完（取走）；然后才执行后续代码
			
			//	Thread.sleep(1000);//正常运行
			
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
	
	//处理= 将输入区文本传给计算方法
	private void equel(){
		String text = getText();
		st.setResultText(new jisuan(text).moniton());
		
			}
	//清空输入缓存区
	private void myDelete() {
		// TODO Auto-generated method stub
		sb.delete(0, sb.length());
		sb.append("c");
	}



	//处理clean。//清空输入输出框和输入缓存区
	private void clean(){
		//System.out.println("clean");
		myDelete();
		st.setText("");
		st.setResultText("");
	}

//单例方法
	public static Response getResponse() {
		return response;
	}

/*取待处理数据
 * 数据取到后清空数据，唤醒输入线程
 * */
	public synchronized String getText() {
		String copyStr = this.text;
		this.text = null;
		this.notifyAll();
		return copyStr;
	}

/*将输入的表达式文本copy到计算用的String中保存。
 * 同步方法：
 * 		如果String不为null，表示数据没有被取走，为放置覆盖所以wait
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
		//数据copy完成清空输入缓存区
		myDelete();
	}



	
}
