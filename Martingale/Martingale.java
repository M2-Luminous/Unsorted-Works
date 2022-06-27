
public class Martingale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] money = new double[10000];
		double[] time = new double[10000];
		for(int i = 0; i < 10000; i++) {
			double expectMoney = 0.0;
			double placeBets = 1.0;
			boolean result = false;
			double win = 0.0;
			double loss = 0.0;
			while(placeBets <= 100 && expectMoney < 10) {
				int randomGenerator = (int)(Math.random()*37);
				if(randomGenerator >= 0 && randomGenerator <= 17) {
					result = true;
				}
				else if(randomGenerator > 17 && randomGenerator <= 37){
					result = false;
				}
			
				if(result) {
					expectMoney += placeBets;
					placeBets = 1.0;
					win++;
				}
				else if(!result) {
					expectMoney -= placeBets;
					placeBets = placeBets * 2;
					loss++;
				}
			}
			double total = win + loss;
			money[i] = expectMoney;
			time[i] = total;
			System.out.print(money[i]);
			System.out.print("\n");			
		}
		
		System.out.print("\n");	
		System.out.print("\n");	
		System.out.print("\n");	
		
		
		for(int k = 0; k < 10000; k++) {
			System.out.print(time[k]);
			System.out.print("\n");	
		}
	}
}
