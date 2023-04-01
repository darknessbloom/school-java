class car{
	String color;
	static int rednum=0;
	public static int getRednum() {
		return rednum;
	}
	public static void setRednum(int rednum) {
		car.rednum = rednum;
	}
	public static int getTotal() {
		return total;
	}
	public static void setTotal(int total) {
		car.total = total;
	}
	static int total=0;
	public car(String c) {
		color=c;
		total++;
		if(c=="red"||c=="RED")
			rednum++;
	}
	
}
public class T4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		car c1=new car("red");
		car c2=new car("blue");
		car c3=new car("RED");
		System.out.printf("자동차수 %d 빨간색 자동차수 %d",car.getTotal(),car.getRednum());

	}

}
