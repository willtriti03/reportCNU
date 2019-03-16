package chocolatejar;

public class ChocolateJar implements Jar{	
	
	private int chocolate;						//���ݸ� ���� ����
	private int chilli;							//ĥ�� ���� ����
	
	public  ChocolateJar() {					//���ݸ� �׾Ƹ� ������ ������ ����Ʈ ������ ���ݸ��� ĥ�� ����
		chocolate = 13;
		chilli = 1;
	}
	
	public  ChocolateJar(int chocolate) {		//���ڰ����� ���ݸ� ������ ���´ٸ� ���ݸ� ������ �����Ͽ� ����
		this.chocolate = chocolate;
		chilli = 1;
	}


	@Override
	public int getItem() {						//�׾Ƹ��� ��� �������� ���� ��ȯ
		return chocolate + chilli;
	}
	
	public int getChocolate() {					//���ݸ� ���� ��ȯ
		return chocolate;
	}
	
	public int getChilli() {					//ĥ�� ���� ��ȯ
		return chilli;
	}
	
	@Override
	public void takeItem(int hand) {			//hand��ŭ �������� ����
		if(getItem() - hand < 0) {				//�׾Ƹ��� �����ۺ��� ���� �������Ѵٸ� ��� �޼��� ���
			System.out.println("���� �������� �����ϴ�");
		}
		else {
			if(chocolate - hand >= 0)
				chocolate -= hand;
			else {
				chocolate = 0;
				chilli = 0;
			}
		}
		
	}

	@Override
	public String status() {
		String jar  = "[ ";
		if(chilli > 0)
			jar +="�� ";
		for(int i = 0; i < chocolate; ++i) {
			jar +="�� ";
		}
		jar +="]";
		return jar;
	}

	@Override
	public boolean isEmpty() {
		if (getItem() == 0)
				return true;
		else
			return false;
	}

}