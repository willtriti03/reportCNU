package blackjackFrame;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class DealerPanel extends JPanel implements HandPanel{
	Dealer dealer;

	public DealerPanel(Dealer dealer) {									//테두리 설정및 생성
		// TODO Auto-generated constructor stub
		this.dealer = dealer;
		Border border = BorderFactory.createTitledBorder("Dealer");
		setBorder(border);
		setAlignmentX(LEFT_ALIGNMENT);

	}

	@Override
	public void firstSet() {												//한장을 뺀 나머지는 뒤집어서 출력
		this.removeAll();

		ArrayList<Card> hand = dealer.getHand();
		for(int i =0; i< hand.size(); ++i) {
			if(i==0) {
				this.add(new ImagePanel(((Card)hand.get(i)).getImage()));
			}
			else {
				this.add(new ImagePanel("./image/Back.png"));
			}
		}

		repaint();
	}

	@Override
	public void refresh() {												//전부 보이게 출력
		if(!dealer.scoreDetector.isFinished()) {
			this.removeAll();

			ArrayList<Card> hand = dealer.getHand();
			Iterator e = hand.iterator();


			while(e.hasNext()) {
				this.add(new ImagePanel(((Card)e.next()).getImage()));
			}

			repaint();
		}
	}

}
