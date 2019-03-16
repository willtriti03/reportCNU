package blackjackFrame;

public class Dealer extends Player{
	CardDeck cardDeck = new CardDeck();
	DealerPanel dealerPanel;
	
	public Dealer() {
		// TODO Auto-generated constructor stub
		cardDeck.shuffle(); // ������ �����Ǹ� ���� ���� 
	}
	
	
	@Override
	public void playFirstTurn() {		//�÷��̾��� ù�ϰ� ������ ù ���� �ٸ����� ��ӹ޾� �ٸ��� ó��
		addCard();						//ī�� 2�� �߰�
		addCard();
		
		while(17>checkSum()) {			//���� 17�� ������ ���� �� ����
			addCard();
		}
		
		handPanel.firstSet();			//���常 ���� �������� ����� ���
		
	}
	
	public Card callCard() {
		return cardDeck.popCard(); 		//�������� ī�� ��û�� ó��
	}
	
	public void setDealerPanel(DealerPanel dealerPanel) {
		this.dealerPanel = dealerPanel;
	}
}
