package blackjackFrame;

import java.util.ArrayList;
import java.util.Iterator;

public class Player {
	private int sum;										//카드 숫자합
	private ArrayList<Card> hand = new ArrayList<>();		//핸드 
	private int aCnt= 0;									//a의 개수
	private Dealer dealer;									//딜러
	private boolean blackjack = false;						//블랙잭 여부
	protected HandPanel handPanel;							//출력 패널
	protected ScoreDetector scoreDetector;					//점수 처리기

	public int getSum() {									//핸드의 합 가져오기
		this.sum = checkSum();
		return sum;
	}

	public void addCard() {									//카드를 뽑고 카드를 추가한 다음 합을 계산후 블랙잭이면 기능 정지처리
		hand.add(dealer.callCard());
		if(21 <= checkSum()) {
			blackjack = true;
			dealer.handPanel.refresh();
			scoreDetector.detectAllScore();
			
		}
		else {
			handPanel.refresh();
		}
	}

	protected int checkSum() {							//합 처리
		int sum=0;										//계산 전 초기화
		Iterator iter = hand.iterator();				//핸드를 전부다 돌리는 이터레이터

		while(iter.hasNext()) {							//다음이 없을때 까지
			int rank =((Card)iter.next()).getRank();	//카드의 랭크를 가져와 계산
			if(rank == 1)								//에이면 추후 계산을  위해 카운트 상승 
				aCnt++;
			else
				sum += rank;							//나머지는 계산
		}

		for(int i =0; i< aCnt; ++i) {					//에이의 개수만큼 11을 더해서 21이 넘는다면 a를 1로 계산
			if(sum+11 <= 21)
				sum += 11;
			else
				sum += 1;
		}
		aCnt=0;

		return sum;
	}

	public void playFirstTurn() {						//첫턴은 카드 두장을 뽑고 둔 상태 세팅
		addCard();
		addCard();
		handPanel.refresh();
		scoreDetector.detectPlayerScore();
	}

	public void playMoreTurn() {						//카드를 더 뽑는 상태
		if(!blackjack) {
			addCard();
			handPanel.refresh();
			scoreDetector.detectPlayerScore();
		}
	}
	
	public boolean isBlackjack() {						//이하 겟터 세터
		return blackjack;
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public void setHandPanel(HandPanel handPanel) {
		this.handPanel = handPanel;
	}

	public void setScoreDetector(ScoreDetector scoreDetector) {
		this.scoreDetector = scoreDetector;
	}




}
