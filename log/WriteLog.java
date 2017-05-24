


/*
 * ��־�������
 * 
 * ���ܣ���ָ����·�����ļ���������������ļ�ϵͳ���ṩ������
 * 
 * Ҫ�󣺸�Ч������ʹ��
 * */
package Calculator_Project.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteLog {

	private File file;
	private FileWriter fw;
	private BufferedWriter bufwrite;


	//ÿ������Ҫ����File·��ִ�У����Բ��ṩ�޲ι��췽��
	//public WriteLog(){}

	//ͨ�����췽��ȷ������ļ�·����һ�������Ӧһ���ļ���
	public WriteLog(String path, String name) throws IOException {
		if(path == null || name == null){
			throw new NullPointerException("pathname is null");
		}

		file = new File(path+file.separator +name);

		try {

			file.createNewFile();
			fw = new FileWriter(file,true);//true��ʾ��д��������
			bufwrite = new BufferedWriter(fw);

		} catch (IOException e) {

			throw new IOException("������URL�޷����ʡ�");
		}

	}

	//д��log,һ��дһ��
	public void writeLine(String string) throws IOException {
		// TODO Auto-generated method stub
		try {
			bufwrite.write(string,0,string.length());
			bufwrite.newLine();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IOException("����д�����");
		}


	}

	public void close() throws IOException  {
		// TODO Auto-generated method stub
		try {
			bufwrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IOException("�ر�ʧ��");
		}
	}

	private void flush() throws IOException  {
		// TODO Auto-generated method stub
		try {
			bufwrite.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IOException("ˢ��ʧ��");
		}
	}

	//д��Exception,û��ʹ�û���
	public void write(Exception e)  {
		// TODO Auto-generated method stub
		try {
			bufwrite.write(e.getMessage());
		} catch (IOException e1) {
			e1.printStackTrace();
		}


	}

	public String read() {
		// TODO Auto-generated method stub
		return null;
	}

}




