import java.util.ArrayList;

public class CoinMaster {
	static int coinKind[] = {1,5,10,25,50};
	static int countSum =0;

	
	public static int calCoinCase(int money,int coins){				//�ݾ�, ���� ����
		int count =0,t;												//����� �� 
		
		if(coins == 0){												//���� ���Ϸ� �����ͼ� �������� 1 ���� �ƴϸ� 0����
			if(money%coinKind[0]==0) return 1;
			else return 0;
		}
		t= money / coinKind[coins];									//���� ������ ������ �� ���� ��ŭ �ݺ��� �� ������ �ѹ��� �����ؾ����� -> 
																	//�ִ뵿���� ������ ������ ������� ó���� ���Ҽ��� �ֱ⶧��
		for(int i=0; i <= t; ++i){										//ū������ �ϳ��ϳ� ���� �������� �ٲ�
			count+=calCoinCase(money - (coinKind[coins]*i), coins-1);	//�� �ݺ��� ���� ���
		}	
		return count;												//������ȯ
	}
	
	
	public static int minimalCoin(int money, int coins){ // 21�� �� Ư���ѵ����� ������� ���� ������ ���
		if(coins == -1){								// ��� ���� üũ�� �ƿ�
			return countSum;
		}
		else{
			countSum+= money/coinKind[coins];			//���� ������ ����  ������ŭ������ ������ ����
			
			if (money%coinKind[coins]==0)				//���� �������� ���� ���� �ݾ��� 0�̸� ���ʿ��� �ݺ��� ���ֱ� ���� ����
				return countSum;
			
			return minimalCoin(money%coinKind[coins], coins-1);	//���� �������� ����ϰ� ���� �������� ���絿�� ���� ���� �ݾ����� �ݺ�
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target =63;
		
		System.out.print("������ ");
		for(int i = 0;  i < coinKind.length; ++i  ){
			System.out.print(" "+coinKind[i]);
		}
		System.out.println("���� ������ �ְ�");
		System.out.println(target+"����  "+coinKind.length+"������ ������ ����� "+calCoinCase(target, coinKind.length-1)+"�����̰�");
		System.out.println("�ּ� ������ ���� ������ , ���� ������"+minimalCoin(target, coinKind.length-1)+"�� �̴�.");
		
	}


}
