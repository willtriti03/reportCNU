import java.util.Random;

public class Philosopher extends Thread{
	private final boolean LEFT =false, RIGHT = true;										//함수용 오른쪽 왼쪽 구분 파이널 함수

	private int count;																		//몇 번째 철학자인지  저장
	private int hand[] = {0,0};																//오른손 왼손
	private int leftHand, rightHand;														//왼쪽 오른쪽 포크 번호 저장 왼쪽 : 현재-1 오른쪽: 현재 번호와 동일
	
	private Random random = new Random();													//랜덤 슬림용 변수
	private ForkBuffer forkBuffer;															//포크버퍼 저장
	
	public Philosopher(int count, ForkBuffer forkBuffer, int max) {							//메인에서 철학자 번호와 포크버퍼, 최대인원을 받아옴
		this.count = count;																	//개수 저장
		this.forkBuffer = forkBuffer;														//버퍼 저장
		leftHand = 0 == count ? max-1 : count - 1;											//왼쪽 포크 번호 저장
		rightHand = count;																	//오른쪽 포크 번호 저장
	}
	@Override
	public void run(){																		//동작
		pickUpLeft();																		//왼쪽 포크들고
		pickUpRight();																		//오른쪽 포크 들고
		eat();																				//먹고
		think();																			//생각하고
	}
	
	private void pickUpLeft() {																//왼손 포크 집기
		if(forkBuffer.get(leftHand)==1&&hand[0]==0){										//왼손으로 포크를 가져오는데 성공하고 왼손이 비어있을 경우 동작
			hand[0] = 1;																	//포크를 들고 있는 상태로 저장
			System.out.println("["+count+"]"+"철학자가 ["+leftHand+"] 포크를 들었습니다." );			//출력
			
			if(forkBuffer.isBlank()&& hand[0]+hand[1]!=2){									//들었는데 마지막 남은 포크를 들은 것이고 양손 다 들고 있는 경우가 아니면 내려두고 다시 짚기를 기다림
				dropDown(LEFT);																//왼손 포크를 내려둠
				pickUpLeft();																//다시  들기위한 재귀
			}
		}
	}
	
	private void pickUpRight() {															//왼손과 동작 동일  
		if(forkBuffer.get(rightHand)==1&&hand[1]==0){										//동작은 동일하지만 사용에 용의하기 위해 왼손과 분리 
			hand[1] = 1;							
			System.out.println("["+count+"]"+"철학자가 ["+rightHand+"] 포크를 들었습니다." );
			
			if(forkBuffer.isBlank()&& hand[0]+hand[1]!=2){
				dropDown(RIGHT);
				pickUpRight();
			}
		}
	}
	
	private void dropDown(boolean isRight) {												//isRight에 따라 왼손 오른손 포크 내려 놓음
		if(isRight){
			hand[1] = 0;																	//내려 놓은 손 포크를 0으로 초기화
			forkBuffer.returnBack(rightHand);												//포크 반납
			System.out.println("["+count+"]"+"철학자가 ["+rightHand+"] 포크를 내려놓았습니다.");			//출력
		}
		else{
			hand[0] = 0;																	//상단과 동일 작동
			forkBuffer.returnBack(leftHand);
			System.out.println("["+count+"]"+"철학자가 ["+leftHand+"] 포크를 내려놓았습니다.");
		}
	}
		
	private void eat(){																		//꿀꺽 냠냠 쩝쩝 먹기 함수
		if(hand[0]+hand[1]==2){														//양손다 포크가 있는 경우 1 1이기때문에 두개를 더하면 2 2일경우 먹는다
			System.out.println("["+count+"]"+"철학자 먹는중...");									//출력
			dropDown(LEFT);																	//왼손 내려놓기
			dropDown(RIGHT);																//오른손 내려놓기
		}
		else{																				//못 먹는 경우 일 경우 자진납부
			System.out.println("뿌에에에에에에에엑 안먹거어어어어");
		}
	}
	
	private void think(){																	//생각한다... 고로 존재한다...
		try {
			System.out.println("["+count+"]"+"철학자 생각중...");
			sleep(random.nextInt(100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
