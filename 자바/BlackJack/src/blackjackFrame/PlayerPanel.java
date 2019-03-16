package blackjackFrame;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PlayerPanel extends JPanel implements HandPanel{			//딜러패널과 동일 뒤집어서 출력은 필요없음으로 제외 구현
	Player player;
	public PlayerPanel(Player player) {							
		// TODO Auto-generated constructor stub
		this.player= player;
		Border border = BorderFactory.createTitledBorder("Player");
		setBorder(border);
		
	}
	
	@Override
	public void firstSet() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void refresh() {
		this.removeAll();
		
		ArrayList<Card> hand = player.getHand();
		Iterator e = hand.iterator();
		
		
		while(e.hasNext()) {
			this.add(new ImagePanel(((Card)e.next()).getImage()));
		}
		
		repaint();
	}


}
