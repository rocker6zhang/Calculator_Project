package Calculator_Project.log;

import java.io.IOException;

public class testLog {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++){
		WriteLog wl = new WriteLog("c:","logTset.txt");
		wl.writeLine("is one"+i);
		wl.close();
		System.out.println(i);
		}
	}

}
