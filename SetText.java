package myCalculator;

import java.awt.TextField;

public class SetText {
	private TextField text = Main.text;
	private TextField resultText = Main.resultText;
	//��ʼ��������ı������
	
	
	//������ı���
	public void setText(String str){
		text.setText(str);
	}
	
	public void setResultText(String str){
		resultText.setText(str);
	}
}
