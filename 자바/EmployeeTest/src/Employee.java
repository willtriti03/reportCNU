
public class Employee {
	private String name;
	private String num;
	private int salary;
	
	////////////////////////get set ���� //////////////////////////////
	public void setName(String name) {
		this.name = name;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	public String getName() {
		return name;
	}
	public String getNum() {
		return num;
	}
	public int getSalary() {
		return salary;
	}
	
	//////////////////////////////////////////////////////////
	
	public void printID() {  //����� �ѹ��� ���ִ� �޼ҵ�
		System.out.println("���� �̸� : "+name);
		System.out.println("��ȭ��ȣ : "+num);
		System.out.println("���� : "+salary);
	}
}
