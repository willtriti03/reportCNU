import java.nio.Buffer;

public class ForkBuffer extends Thread{
	private int fork[];											//포크 배열
	private int count;											//포크 개수
	
	public ForkBuffer(int count) {								//포크 개수를 받아서 포크 인스턴스 생성
		this.count = count;										//개수 저장
		this.fork = new int[count];								//배열 길이 설정 개수로
		for(int i =0; i< count; ++i){							//배열에 포크를 채워 넣음
			fork[i] = 1;
		}
	}
	
	public synchronized int get(int target){					//타겟 번호에 있는 포크를 넘겨주는 함수
		while(fork[target]==0){									//타겟이 비어있다면 생길때까지 웨이팅
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		fork[target] = 0;										//포크를 주는 상황이므로 0으로 바꾸고 1를 리턴하여 포크 전달
		notifyAll();											//변화 완료
		return 1;				
	}
	public synchronized boolean isBlank() {						//포크 테이블이 비어있는지 확인
		for(int i =0; i< count; ++ i){							//배열의 끝까지 돌면서 1이 있는 순간  false 리턴
			if(fork[i]==1)
				return false;
		}
		return true;
	}
	
	public synchronized void returnBack(int target){			//목표에 포크를 돌려놓음
		fork[target] = 1;										//포크가 돌아왔으니  1로 변경
		notifyAll();											//변경 알림
	}

}
