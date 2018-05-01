
public class Employee {
	private String name;
	private String num;
	private int salary;
	
	////////////////////////get set 설정 //////////////////////////////
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
	
	public void printID() {  //출력을 한번에 해주는 메소드
		System.out.println("직원 이름 : "+name);
		System.out.println("전화번호 : "+num);
		System.out.println("연봉 : "+salary);
	}
}
