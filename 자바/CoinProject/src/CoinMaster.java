import java.util.ArrayList;

public class CoinMaster {
	static int coinKind[] = {1,5,10,25,50};
	static int countSum =0;

	
	public static int calCoinCase(int money,int coins){				//금액, 동전 종류
		int count =0,t;												//경우의 수 
		
		if(coins == 0){												//동전 최하로 내려와서 나눠지면 1 리턴 아니면 0리턴
			if(money%coinKind[0]==0) return 1;
			else return 0;
		}
		t= money / coinKind[coins];									//상위 동전을 나눠서 그 개수 만큼 반복함 단 무조건 한번은 동작해야하함 -> 
																	//최대동전이 나누는 돈보다 낮을경우 처리를 못할수도 있기때문
		for(int i=0; i <= t; ++i){										//큰동전을 하나하나 작은 동전으로 바꿈
			count+=calCoinCase(money - (coinKind[coins]*i), coins-1);	//그 반복을 위한 재귀
		}	
		return count;												//개수반환
	}
	
	
	public static int minimalCoin(int money, int coins){ // 21원 등 특수한동전이 없을경우 가장 간단한 재귀
		if(coins == -1){								// 모든 동전 체크시 아웃
			return countSum;
		}
		else{
			countSum+= money/coinKind[coins];			//동전 개수를 현재  동전만큼나눠서 개수를 구함
			
			if (money%coinKind[coins]==0)				//현재 동전으로 빼고 남은 금액이 0이면 불필요한 반복을 없애기 위해 종료
				return countSum;
			
			return minimalCoin(money%coinKind[coins], coins-1);	//현재 동전으로 계산하고 남은 나머지와 현재동전 보다 작은 금액으로 반복
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target =63;
		
		System.out.print("동전은 ");
		for(int i = 0;  i < coinKind.length; ++i  ){
			System.out.print(" "+coinKind[i]);
		}
		System.out.println("원의 종류가 있고");
		System.out.println(target+"원을  "+coinKind.length+"종류로 나누는 방법은 "+calCoinCase(target, coinKind.length-1)+"가지이고");
		System.out.println("최소 동전의 수로 나눙때 , 동전 개수는"+minimalCoin(target, coinKind.length-1)+"개 이다.");
		
	}


}
