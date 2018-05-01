
public class ComplexNum {
	protected double realNum;	//�Ǽ� �κ�
	protected double imagNum;	//��� �κ�

	public ComplexNum(int realNum , int imagNum) {	//��ü�� �����ϸ鼭 �Ǽ��κа� ����κ��� �޾ƿ� �ʱ�ȭ�Ѵ�.
		// TODO Auto-generated constructor stub
		this.realNum = realNum;
		this.imagNum = imagNum;
	}
	String getComplexNum() {
		return realNum+" + "+imagNum+"i";
	}

	double getRealNum() {		//�Ǽ� �κ��� ��ȯ�Ѵ�
		return realNum;
	}

	double getImagNum() {		//����κ��� ��ȯ�Ѵ�
		return imagNum;
	}

	String add(ComplexNum cn) {	//�Ű������� �ڱ��ڽ��� ���� ���
		return ((realNum+cn.getRealNum())+" + "+(imagNum+cn.getImagNum())+"i");
	}
	String sub(ComplexNum cn) {	//�Ű������� �ڱ��ڽ��� ���� ���
		return ((realNum-cn.getRealNum())+" + "+(imagNum-cn.getImagNum())+"i");
	}
	String mul(ComplexNum cn) {	//�Ű������� �ڱ��ڽ��� ���� ���
		double realNum2=cn.getRealNum();
		double imagNum2=cn.getImagNum();
		return ((realNum*realNum2-imagNum*imagNum2)+" + "+
				(realNum*imagNum2+realNum2*imagNum)+"i");
	}
	String div(ComplexNum cn) {	//�Ű������� �ڱ��ڽ��� ������ ���
		double realNum2=cn.getRealNum();
		double imagNum2=cn.getImagNum();
		if(realNum2==0&&imagNum2==0) {
			double r = (realNum*realNum2 +imagNum*imagNum2)/(realNum2*realNum2+imagNum2*imagNum2);
			double i = (imagNum*realNum2 -realNum*imagNum2)/(realNum2*realNum2+imagNum2*imagNum2);
			return (r+" + "+i+"i");
		}
		else
			return "������ ���Ҽ��� 0�̶� ������ �����ϴ�.";
	}
}
