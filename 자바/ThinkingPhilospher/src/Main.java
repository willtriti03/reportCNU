
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int COUNT =5;
		ForkBuffer forkBuffer = new ForkBuffer(COUNT);
		Philosopher philospher[]=new Philosopher[COUNT];
		
		for(int i =0; i < COUNT; ++i){
			philospher[i]=  new Philosopher(i, forkBuffer, COUNT);
			philospher[i].start();
		}
	}

}


/*
   d 3 c 
 4      2
c        b                           �迭 ��ȣ|0|1|2|3|4|����
  5    1                                  +-+-+-+-+-+----
     a                                    |a|b|c|d|e|ö����
     									  +-+-+-+-+-+----      
     									  |1|2|3|4|5|��ũ 
     									   
*/