
public class ComplexNum {
	protected double realNum;	//실수 부분
	protected double imagNum;	//허수 부분

	public ComplexNum(int realNum , int imagNum) {	//객체를 생성하면서 실수부분과 허수부분을 받아와 초기화한다.
		// TODO Auto-generated constructor stub
		this.realNum = realNum;
		this.imagNum = imagNum;
	}
	String getComplexNum() {
		return realNum+" + "+imagNum+"i";
	}

	double getRealNum() {		//실수 부분을 반환한다
		return realNum;
	}

	double getImagNum() {		//허수부분을 반환한다
		return imagNum;
	}

	String add(ComplexNum cn) {	//매개변수와 자기자신의 덧셈 출력
		return ((realNum+cn.getRealNum())+" + "+(imagNum+cn.getImagNum())+"i");
	}
	String sub(ComplexNum cn) {	//매개변수와 자기자신의 뺄셈 출력
		return ((realNum-cn.getRealNum())+" + "+(imagNum-cn.getImagNum())+"i");
	}
	String mul(ComplexNum cn) {	//매개변수와 자기자신의 곱셈 출력
		double realNum2=cn.getRealNum();
		double imagNum2=cn.getImagNum();
		return ((realNum*realNum2-imagNum*imagNum2)+" + "+
				(realNum*imagNum2+realNum2*imagNum)+"i");
	}
	String div(ComplexNum cn) {	//매개변수와 자기자신의 나눗셈 출력
		double realNum2=cn.getRealNum();
		double imagNum2=cn.getImagNum();
		if(realNum2==0&&imagNum2==0) {
			double r = (realNum*realNum2 +imagNum*imagNum2)/(realNum2*realNum2+imagNum2*imagNum2);
			double i = (imagNum*realNum2 -realNum*imagNum2)/(realNum2*realNum2+imagNum2*imagNum2);
			return (r+" + "+i+"i");
		}
		else
			return "나누는 복소수가 0이라서 나눌수 없습니다.";
	}
}
