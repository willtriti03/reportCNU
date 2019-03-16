package chocolatejar;

public class ChocolateJar implements Jar{	
	
	private int chocolate;						//초콜릿 개수 변수
	private int chilli;							//칠리 개수 변수
	
	public  ChocolateJar() {					//초콜릿 항아리 생성자 생성시 디폴트 값으로 초콜릿과 칠리 생성
		chocolate = 13;
		chilli = 1;
	}
	
	public  ChocolateJar(int chocolate) {		//인자값으로 초콜릿 개수가 들어온다면 초콜릿 개수를 설정하여 생성
		this.chocolate = chocolate;
		chilli = 1;
	}


	@Override
	public int getItem() {						//항아리내 모든 아이템의 개수 반환
		return chocolate + chilli;
	}
	
	public int getChocolate() {					//초콜릿 개수 반환
		return chocolate;
	}
	
	public int getChilli() {					//칠리 개수 반환
		return chilli;
	}
	
	@Override
	public void takeItem(int hand) {			//hand만큼 아이템을 뽑음
		if(getItem() - hand < 0) {				//항아리내 아이템보다 많이 뽑으려한다면 경고 메세지 출력
			System.out.println("남은 개수보다 많습니다");
		}
		else {
			if(chocolate - hand >= 0)
				chocolate -= hand;
			else {
				chocolate = 0;
				chilli = 0;
			}
		}
		
	}

	@Override
	public String status() {
		String jar  = "[ ";
		if(chilli > 0)
			jar +="■ ";
		for(int i = 0; i < chocolate; ++i) {
			jar +="□ ";
		}
		jar +="]";
		return jar;
	}

	@Override
	public boolean isEmpty() {
		if (getItem() == 0)
				return true;
		else
			return false;
	}

}