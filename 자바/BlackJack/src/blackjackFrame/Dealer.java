package blackjackFrame;

public class Dealer extends Player{
	CardDeck cardDeck = new CardDeck();
	DealerPanel dealerPanel;
	
	public Dealer() {
		// TODO Auto-generated constructor stub
		cardDeck.shuffle(); // 딜러가 생성되면 덱을 섞음 
	}
	
	
	@Override
	public void playFirstTurn() {		//플레이어의 첫턴과 딜러의 첫 턴은 다름으로 상속받아 다르게 처리
		addCard();						//카드 2장 추가
		addCard();
		
		while(17>checkSum()) {			//합이 17이 넘을때 까지 더 뽑음
			addCard();
		}
		
		handPanel.firstSet();			//한장만 열고 나머지는 뒤집어서 출력
		
	}
	
	public Card callCard() {
		return cardDeck.popCard(); 		//딜러에게 카드 요청시 처리
	}
	
	public void setDealerPanel(DealerPanel dealerPanel) {
		this.dealerPanel = dealerPanel;
	}
}
