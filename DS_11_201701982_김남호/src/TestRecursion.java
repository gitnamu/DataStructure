import java.util.Scanner;

public class TestRecursion {
	public static void main(String[] args) {
		TestRecursion tr = new TestRecursion();	//TestRecursion 객체 tr 생성 
		tr.run();								//tr의 run함수 호출
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);	//스캐너 객체 input 생성
		Quicksort qs = new Quicksort(100);		// Quicksort 객체 qs 생성 및 maxSize 100으로 초기화
		
		while(true) {
			System.out.print("1.  [Recursion] add\n2.  [Recursion] sort\n3.  [Recursion] print\n4.  종료\n");		//입력 번호별 기능 문구 출력
			System.out.print("> 번호를 입력 : ");							//번호 입력 문구 출력
			int num = input.nextInt();									//숫자를 입력받아서 num에 저장
			
			if(num==1) {												//num이 1이면
				System.out.print("추가 하고 싶은 내용을 입력하세요 : ");			//추가할 내용 입력 문구 출력
				int data = input.nextInt();								//숫자 입력받아서 data에 저장
				if(!qs.add(data)) 										//만약 add(data)값이 false이면
					System.out.println("배열이 최대 사이즈에 도달했습니다.");		//배열의 size가 maxSize에 도달했다는 문구 출력
			}
			else if(num==2) {									//num이 2이면
				qs.sorting();									//qs 객체의 sorting 메소드 호출
				System.out.println("> 오름차순으로 정렬이 완료.");		//정렬 완료 메소드 출력
			}
			else if(num==3) {		//num이 3이면
				qs.print();			//qs 객체의 print 메소드 호출
			}
			else if(num==4) {						//num이 4이면
				System.out.println("종료되었습니다.");	//종료 메세지 출력
				break;								//반복문 종료
			}
		}
	}
}
