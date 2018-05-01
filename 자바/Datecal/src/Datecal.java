import java.util.Scanner;

/****************************** 
 * 
 * 컴퓨터프로그래밍 1 (11) HW05 
 * 학번 : 201802135 
 * 이름 : 이 정 준 
 * 
 * ******************************/
public class Datecal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year,month,date,calDate=0;
		Scanner sc = new Scanner(System.in);    								//년월일 입력
		System.out.print("연도 입력");
		year = sc.nextInt();
		System.out.print("월 입력");
		month= sc.nextInt();
		System.out.print("일 입력");
		date = sc.nextInt();
		
		calDate = (year-1900)*365 + (year-1900)/4;								//년도로 날짜 수 계산
		
		for(int i = 1; i<month; ++i ) {											// 월 날짜수 계산
			switch (i) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				calDate+=31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				calDate+=30;
				break;
			case 2:
				if(( year % 4==0 && year%100!=0)||year%400==0) {
					calDate+=29;
				}
				else
					calDate += 28;
				break;
			default:
				break;
			}
			
		
		}
		
		calDate+=date-1;														//날짜를 더함
			
		switch (calDate%7) {													//총날짜를 7로 나눠 요일을 구함
		case 0:
			System.out.println(year+"년 "+month+"월 "+date+"일은 월요일입니다");
			break;
		case 1:
			System.out.println(year+"년 "+month+"월 "+date+"일은 화요일입니다");
			break;
		case 2:
			System.out.println(year+"년 "+month+"월 "+date+"일은 수요일입니다");
			break;
		case 3:
			System.out.println(year+"년 "+month+"월 "+date+"일은 목요일입니다");
			break;
		case 4:
			System.out.println(year+"년 "+month+"월 "+date+"일은 금요일입니다");
			break;
		case 5:
			System.out.println(year+"년 "+month+"월 "+date+"일은 토요일입니다");
			break;
		case 6:
			System.out.println(year+"년 "+month+"월 "+date+"일은 일요일입니다");
			break;

		}

	}

}

