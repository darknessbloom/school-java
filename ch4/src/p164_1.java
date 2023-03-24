class Triangle{
	double l;
	double h;
	public Triangle(double a,double b) {
		l=a;
		h=b;
	}
	public double findarea() {
		return l*h/2;
	}
	public boolean issamearea(Triangle k) {
		if(k.findarea()==this.findarea())
			return true;
		else
			return false;
	}
	
	
}
public class p164_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle t=new Triangle(10.0,5.0);
		Triangle t2=new Triangle(5.0,10.0);
		Triangle t3=new Triangle(8.0,8.0);
		System.out.println(t.findarea());
		System.out.println(t2.findarea());
		System.out.println(t3.findarea());
		System.out.println(t.issamearea(t2));
		System.out.println(t.issamearea(t3));
		

	}

}
