package Calculator_Project;

import java.awt.TextField;

public class SetText {
	//Ҫ�ĳɵ���
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
