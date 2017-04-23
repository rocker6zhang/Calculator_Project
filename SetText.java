package myCalculator;

import java.awt.TextField;

public class SetText {
	private TextField text = Main.text;
	private TextField resultText = Main.resultText;
	//初始化，获得文本框对象
	
	
	//输出到文本框
	public void setText(String str){
		text.setText(str);
	}
	
	public void setResultText(String str){
		resultText.setText(str);
	}
}
