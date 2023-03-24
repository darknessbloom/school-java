import java.lang.Math;
class printer{
	private int numofpaper=0;
	private boolean duplex;
	public printer(int n, boolean d) {
		numofpaper=n;
		duplex=d;
	}
	
	public boolean isDuplex() {
		return duplex;
	}

	public void setDuplex(boolean duplex) {
		this.duplex = duplex;
	}

	public void print(int amount) {
		//양면복사를 할 경우
		
		if(this.duplex==true) {
			double printpaper=amount/2.0;
			printpaper=Math.ceil(printpaper);
				
			
			System.out.println(printpaper);
			//printpaper=Math.ceil(printpaper); //올림함수가 작동하지 않음
			System.out.println(printpaper);
			
			if(printpaper>numofpaper) {
				if(numofpaper==0)
					System.out.println("용지가 없습니다.");
					
				else{
					int needpaper=(int) (printpaper-numofpaper);
					System.out.println("모두 출력하려면 용지가"+needpaper+"장 필요합니다"+printpaper+"장만 출력합니다");
					numofpaper=0;
				}
				
			}
			
			else {
				numofpaper-=printpaper;
				System.out.println(printpaper+"장 출력했습니다. 현재"+numofpaper+"장 남았습니다");
			}
			
			
		}
		//양면복사를 하지 않을 경우
		else {
			if(amount>numofpaper) {
				if(numofpaper==0)
					System.out.println("용지가 없습니다.");
					
				else{
					int needpaper=amount-numofpaper;
					System.out.println("모두 출력하려면 용지가"+needpaper+"장 필요합니다"+numofpaper+"장만 출력합니다");
					numofpaper=0;
				}
				
			}
			
			else {
				numofpaper-=amount;
				System.out.println(amount+"장 출력했습니다. 현재"+numofpaper+"장 남았습니다");
			}
			
		}
		
		
	}
}
public class p158 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printer p= new printer(20,true);
		p.print(25);
		p.setDuplex(false);
		p.print(10);

	}

}
