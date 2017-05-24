package Calculator_Project.test;
//测试辅助类，提供随机产生的number
public class Number {
	private int size ;
	
	public Number(){
		this.size = 1;
		}
	
	public Number(int size){
		this.size = size;
	}
	
	//返回一个int值
	public int getInt(){
		return madeInt();
	}
	//返回一个int数组
	public int[] getIntArr(int length){
		int arr[] = new int[length];
		for(int i = 0; i < length; i++){
			arr[i] = madeInt();
		}
		return arr;
	}
	//返回一个double值
	public double getDouble(){
		return  madeDouble();
	}
	//返回一个double数组
	public double[] getDoubleArr(int length){
		double arr[] = new double[length];
		for(int i = 0; i < length; i++){
			arr[i] = madeDouble();
		}
		return arr;
	}

	private double madeDouble() {
		// TODO Auto-generated method stub
		return Math.random() * size * ((Math.random()-0.5)) * 10;
	}

	private int madeInt() {
		// TODO Auto-generated method stub
		return (int)(Math.random() * 10 * size * ((Math.random()-0.5) * 10));
	}
	public int getsize() {
		return size;
	}
	public void setsize(int size) {
		this.size = size;
	}
	
//	public static void main(String agrs[]){
//		System.out.println(new Number().getInt());
//		
//	}
}
