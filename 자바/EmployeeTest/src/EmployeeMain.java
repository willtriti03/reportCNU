/****************************** 
 *
 * 컴퓨터프로그래밍 1 (11) HW07 
 * 학번 : 201802135 
 * 이름 : 이 정 준 
 * 
 * ******************************/
public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee ep = new Employee();	//객체 생성 및 값 설정
		ep.setName("홍길동");
		ep.setNum("010-2344-8324");
		ep.setSalary(3000);
		
		ep.printID();
	}

}
