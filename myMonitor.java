package Calculator_Project;
/*
 * 事件监听
 * */
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class myMonitor {
	
	//monitor 窗体
	public void monitor(Frame f){
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}


//monitor 输入文本按键
class MonitorNumber implements ActionListener{

	private Response r = Response.getResponse();
	@Override
	public void actionPerformed(final ActionEvent e) {
		// TODO Auto-generated method stub
		String str = ((Button)e.getSource()).getLabel();
		r.write(str);
		
//不适合用多线程，没有可异步操作的代码
//		new Thread(new Runnable(){
//			public void run(){
//				String str = ((Button)e.getSource()).getLabel();
//				r.write(str);
//				System.out.println("输入线程开");
//			}
//		}).start();
//		System.out.println("主线程完成调用");

	}

}

//monitor 功能按键
class MonitorFeatures implements ActionListener{

	private Response r = Response.getResponse();
	
	@Override
	public void actionPerformed(final ActionEvent e) {
		// TODO Auto-generated method stub
		
				String str = ((Button)e.getSource()).getLabel();
				
				r.response(str);

	}

}

