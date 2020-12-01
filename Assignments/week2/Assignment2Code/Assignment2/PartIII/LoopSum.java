import java.util.Scanner;

public class LoopSum {

	public static int sum100() {
	
		int res=0;

        for(int i= 1; i<= 100; i++){
        	res += i;
        }
        return res;

    }

	
	
	public static int sumN(int N) {
		int res=0;

        for(int i= 1; i<= N; i++){
        	res += i;
        }
        return res;

    }
		
	
	
	public static void main(String[] args) {
		int res = sum100();
		Scanner in = new Scanner(System.in);
		System.out.print("Input num: ");
		int num = in.nextInt();
		int res2 = sumN(num);
		System.out.println(res);
		System.out.println(res2);
		
	}
	
}
