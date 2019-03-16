import java.util.Random;

public class Philosopher extends Thread{
	private final boolean LEFT =false, RIGHT = true;										//�Լ��� ������ ���� ���� ���̳� �Լ�

	private int count;																		//�� ��° ö��������  ����
	private int hand[] = {0,0};																//������ �޼�
	private int leftHand, rightHand;														//���� ������ ��ũ ��ȣ ���� ���� : ����-1 ������: ���� ��ȣ�� ����
	
	private Random random = new Random();													//���� ������ ����
	private ForkBuffer forkBuffer;															//��ũ���� ����
	
	public Philosopher(int count, ForkBuffer forkBuffer, int max) {							//���ο��� ö���� ��ȣ�� ��ũ����, �ִ��ο��� �޾ƿ�
		this.count = count;																	//���� ����
		this.forkBuffer = forkBuffer;														//���� ����
		leftHand = 0 == count ? max-1 : count - 1;											//���� ��ũ ��ȣ ����
		rightHand = count;																	//������ ��ũ ��ȣ ����
	}
	@Override
	public void run(){																		//����
		pickUpLeft();																		//���� ��ũ���
		pickUpRight();																		//������ ��ũ ���
		eat();																				//�԰�
		think();																			//�����ϰ�
	}
	
	private void pickUpLeft() {																//�޼� ��ũ ����
		if(forkBuffer.get(leftHand)==1&&hand[0]==0){										//�޼����� ��ũ�� �������µ� �����ϰ� �޼��� ������� ��� ����
			hand[0] = 1;																	//��ũ�� ��� �ִ� ���·� ����
			System.out.println("["+count+"]"+"ö���ڰ� ["+leftHand+"] ��ũ�� ������ϴ�." );			//���
			
			if(forkBuffer.isBlank()&& hand[0]+hand[1]!=2){									//����µ� ������ ���� ��ũ�� ���� ���̰� ��� �� ��� �ִ� ��찡 �ƴϸ� �����ΰ� �ٽ� ¤�⸦ ��ٸ�
				dropDown(LEFT);																//�޼� ��ũ�� ������
				pickUpLeft();																//�ٽ�  ������� ���
			}
		}
	}
	
	private void pickUpRight() {															//�޼հ� ���� ����  
		if(forkBuffer.get(rightHand)==1&&hand[1]==0){										//������ ���������� ��뿡 �����ϱ� ���� �޼հ� �и� 
			hand[1] = 1;							
			System.out.println("["+count+"]"+"ö���ڰ� ["+rightHand+"] ��ũ�� ������ϴ�." );
			
			if(forkBuffer.isBlank()&& hand[0]+hand[1]!=2){
				dropDown(RIGHT);
				pickUpRight();
			}
		}
	}
	
	private void dropDown(boolean isRight) {												//isRight�� ���� �޼� ������ ��ũ ���� ����
		if(isRight){
			hand[1] = 0;																	//���� ���� �� ��ũ�� 0���� �ʱ�ȭ
			forkBuffer.returnBack(rightHand);												//��ũ �ݳ�
			System.out.println("["+count+"]"+"ö���ڰ� ["+rightHand+"] ��ũ�� �������ҽ��ϴ�.");			//���
		}
		else{
			hand[0] = 0;																	//��ܰ� ���� �۵�
			forkBuffer.returnBack(leftHand);
			System.out.println("["+count+"]"+"ö���ڰ� ["+leftHand+"] ��ũ�� �������ҽ��ϴ�.");
		}
	}
		
	private void eat(){																		//�ܲ� �ȳ� ���� �Ա� �Լ�
		if(hand[0]+hand[1]==2){														//��մ� ��ũ�� �ִ� ��� 1 1�̱⶧���� �ΰ��� ���ϸ� 2 2�ϰ�� �Դ´�
			System.out.println("["+count+"]"+"ö���� �Դ���...");									//���
			dropDown(LEFT);																	//�޼� ��������
			dropDown(RIGHT);																//������ ��������
		}
		else{																				//�� �Դ� ��� �� ��� ��������
			System.out.println("�ѿ��������������� �ȸ԰ž����");
		}
	}
	
	private void think(){																	//�����Ѵ�... ��� �����Ѵ�...
		try {
			System.out.println("["+count+"]"+"ö���� ������...");
			sleep(random.nextInt(100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

}
