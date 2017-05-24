


/*
 * 日志输出工具
 * 
 * 功能：按指定的路径和文件名把数据输出到文件系统。提供读方法
 * 
 * 要求：高效，易于使用
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


	//每个对象都要依赖File路径执行，所以不提供无参构造方法
	//public WriteLog(){}

	//通过构造方法确定输出文件路径，一个对象对应一个文件。
	public WriteLog(String path, String name) throws IOException {
		if(path == null || name == null){
			throw new NullPointerException("pathname is null");
		}

		file = new File(path+file.separator +name);

		try {

			file.createNewFile();
			fw = new FileWriter(file,true);//true表示续写，不覆盖
			bufwrite = new BufferedWriter(fw);

		} catch (IOException e) {

			throw new IOException("给定的URL无法访问。");
		}

	}

	//写入log,一次写一行
	public void writeLine(String string) throws IOException {
		// TODO Auto-generated method stub
		try {
			bufwrite.write(string,0,string.length());
			bufwrite.newLine();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IOException("数据写入错误");
		}


	}

	public void close() throws IOException  {
		// TODO Auto-generated method stub
		try {
			bufwrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IOException("关闭失败");
		}
	}

	private void flush() throws IOException  {
		// TODO Auto-generated method stub
		try {
			bufwrite.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IOException("刷新失败");
		}
	}

	//写入Exception,没有使用缓冲
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




