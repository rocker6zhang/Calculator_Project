package Calculator_Project;
/*
 * �¼�����
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
	
	//monitor ����
	public void monitor(Frame f){
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}


//monitor �����ı�����
class MonitorNumber implements ActionListener{

	private Response r = Response.getResponse();
	@Override
	public void actionPerformed(final ActionEvent e) {
		// TODO Auto-generated method stub
		String str = ((Button)e.getSource()).getLabel();
		r.write(str);
		
//���ʺ��ö��̣߳�û�п��첽�����Ĵ���
//		new Thread(new Runnable(){
//			public void run(){
//				String str = ((Button)e.getSource()).getLabel();
//				r.write(str);
//				System.out.println("�����߳̿�");
//			}
//		}).start();
//		System.out.println("���߳���ɵ���");

	}

}

//monitor ���ܰ���
class MonitorFeatures implements ActionListener{

	private Response r = Response.getResponse();
	
	@Override
	public void actionPerformed(final ActionEvent e) {
		// TODO Auto-generated method stub
		
				String str = ((Button)e.getSource()).getLabel();
				
				r.response(str);

	}

}

