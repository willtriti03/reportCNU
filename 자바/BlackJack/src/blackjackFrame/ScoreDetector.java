package blackjackFrame;

import javax.swing.JLabel;

public class ScoreDetector {
	private JLabel score;					//점수 라벨
	private Player player;					//플레이어
	private Dealer dealer;					//딜러
	private boolean finished = false;		//게임 끝 여부

	public ScoreDetector(JLabel score, Player player, Dealer dealer) { //인스턴스 받아오기
		this.score = score;
		this.player = player;
		this.dealer = dealer;
	}
	public void startPlayerTurn() {// 딜러도 블랙잭이되면 게임 종료처리를 해놨기 때문에 그것을 초기화를 위한 함수 
		finished=false;
		detectPlayerScore();
	}

	public void detectPlayerScore() {									//플레이어가 카드를 뽑을때마다 점수 텍스트를 바꿔주는 함수
		if(!finished)
			score.setText("Dealer : ???, Player : "+player.getSum());
	}

	public void detectAllScore() {										// 게임 종료시 승패 처리
		if(!finished) {														//게임종료후 버튼 입력 방지
			finished = true;												//종료상태로 변경
			String ment="";
			if(dealer.getSum() == 21 ) {													//딜러가 21일때
				ment = "  딜러 승리";
			}
			else if(player.getSum() == 21 ) {												//플레이어가 21일때
				ment = "  플레이어 승리";
			}
			else if(!dealer.isBlackjack() && !player.isBlackjack() ){								//둘다 21이 넘었을때 처리
				if(Math.abs(21 - dealer.getSum()) < Math.abs(21 - player.getSum())) {
					ment = "  딜러 승리";
				}
				else if(Math.abs(21 - dealer.getSum()) > Math.abs(21 - player.getSum())) {
					ment = "  플레이어 승리";
				}
				else if(Math.abs(21 - dealer.getSum()) == Math.abs(21 - player.getSum())) {
					ment = "  딜러 승리";
				}
			}
			else if(player.isBlackjack()) {													//플레이어만 21이 넘었을때
				ment = "  딜러 승리";
			}
	
			score.setText("Dealer : "+dealer.getSum()+", Player : "+player.getSum()+ment);		//텍스트 설정
			
		}
	}
	
	public boolean isFinished() {
		return finished;
	}

}
