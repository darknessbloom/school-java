
public class t1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder s1= new StringBuilder();
		s1.append("a").append("b").append("c");
		System.out.println(s1);
		System.out.println(s1.length());
		//String에 StringBuilder넣을때 ToString사용
		String s1_1=s1.toString();
		System.out.println(s1_1.length());

	}

}
