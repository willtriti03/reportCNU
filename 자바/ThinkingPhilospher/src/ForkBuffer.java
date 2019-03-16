import java.nio.Buffer;

public class ForkBuffer extends Thread{
	private int fork[];											//��ũ �迭
	private int count;											//��ũ ����
	
	public ForkBuffer(int count) {								//��ũ ������ �޾Ƽ� ��ũ �ν��Ͻ� ����
		this.count = count;										//���� ����
		this.fork = new int[count];								//�迭 ���� ���� ������
		for(int i =0; i< count; ++i){							//�迭�� ��ũ�� ä�� ����
			fork[i] = 1;
		}
	}
	
	public synchronized int get(int target){					//Ÿ�� ��ȣ�� �ִ� ��ũ�� �Ѱ��ִ� �Լ�
		while(fork[target]==0){									//Ÿ���� ����ִٸ� ���涧���� ������
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		fork[target] = 0;										//��ũ�� �ִ� ��Ȳ�̹Ƿ� 0���� �ٲٰ� 1�� �����Ͽ� ��ũ ����
		notifyAll();											//��ȭ �Ϸ�
		return 1;				
	}
	public synchronized boolean isBlank() {						//��ũ ���̺��� ����ִ��� Ȯ��
		for(int i =0; i< count; ++ i){							//�迭�� ������ ���鼭 1�� �ִ� ����  false ����
			if(fork[i]==1)
				return false;
		}
		return true;
	}
	
	public synchronized void returnBack(int target){			//��ǥ�� ��ũ�� ��������
		fork[target] = 1;										//��ũ�� ���ƿ�����  1�� ����
		notifyAll();											//���� �˸�
	}

}
