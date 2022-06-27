
public class AP {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] money = new double[3000];
		double[] rate = new double[3000];
		double[] time = new double[3000];
		for(int index = 0; index < 3000; index++){
			
		int[] array = {1, 2, 3, 4};
        double win = 0;
        double loss = 0;
        double total = 0;
        int expectMoney = 0;
        int stop = 0;
        int random = 0;
		
			while(stop <= 100 && array.length != 0){	
				int ran = (int)(Math.random()*37);
				if(ran >= 0 && ran <= 17){
					random = 1;
				}
				else {
					random = 0;
				}
			
				if(random == 1){
					win++;
					expectMoney = expectMoney + array[0] + array[array.length - 1];
			
					if(array.length > 2){
						int[] temp = new int [array.length-2];
							for(int i2 = 0; i2 < array.length-2; i2++){
								temp[i2] = array[i2+1];
							}
							array = temp;
					}
					else if(array.length <= 2){
						int[] end = {};
						array = end;
					}
					
				}
				else{				 
					loss ++;
					int a = array[0];
					int b = array[array.length-1];
					int c = a + b;
					expectMoney = expectMoney - c;
					int[] temp = new int [array.length+1];
					for(int i3 = 0; i3 < array.length; i3++){
						temp[i3] = array[i3];
					}
					temp[temp.length-1] = c;
					array = temp;
					
				}
				total = win + loss;
				if(array.length == 1){
				stop = 2 * array[0];
				}
				else if(array.length >= 2){
					stop = array[0] + array[array.length-1];
				}
			}		
			money[index] = expectMoney;
			rate[index] = win / total;
			time[index] = total;
			System.out.printf("%.2f", rate[index]);
			System.out.printf("\n");						
		}
		
		System.out.printf("\n");
		System.out.printf("\n");
		System.out.printf("\n");
		
		for(int j = 0; j < 3000; j++) {
			System.out.print(time[j]);
			System.out.printf("\n");
		}
		
		System.out.printf("\n");
		System.out.printf("\n");
		System.out.printf("\n");
		
		for(int k = 0; k < 3000; k++) {
			System.out.printf("%s",money[k]);
			System.out.printf("\n");
		}
	}
}
