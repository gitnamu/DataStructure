import java.util.Scanner;

public class TestLinkedQueue {
	public void run() {
		LinkedQueue queue = new LinkedQueue();
		Scanner scan = new Scanner(System.in);
		int number;
		Object obj;
		
		while(true) {
			System.out.println("====== MENU ======");	//메뉴 및 번호별 기능 설명 출력
			System.out.print("1. [Queue] 내용 추가\n2. [Queue] 중간에 내용 추가\n3. [Queue] 내용 'N'개 삭제\n4. [Queue] 내용 하나 삭제\n5. [Queue] 사이즈 출력\n6. [Queue] 저장되어 있는 모든 내용 출력\n7. [Queue] 첫 번째 값 출력\n");
			System.out.print(">> 번호를 입력: ");			//번호 입력 유도 문구 출력
			number = scan.nextInt();					//번호를 입력받아서 number에 저장
			
			if(number == 1) {							//number가 1이면
				System.out.print("추가하고 싶은 숫자 입력: ");	//추가 할 숫자 입력 유도 문구 출력
				obj = scan.nextInt();					//추가 할 숫자 입력받아서 obj에 저장
				queue.add(obj);							//add(obj) 호출
			}
			else if(number ==2) {							//number가 2이면
				System.out.print("몇번째 삽입할 지 입력하세요 : ");	//몇번 째 삽입할지 입력 유도 문구 출력
				int num = scan.nextInt();					//숫자를 입력받아서 int형 변수 num에 저장
				System.out.print("추가하고 싶은 숫자 입력: ");		//추가 할 숫자 입력 유도 문구 출력
				obj = scan.nextInt();						//obj에 추가 할 숫자 입력받아서 저장
				queue.add(num, obj);						//add(num, obj) 호출
			}
			else if(number ==3) {							//number가 3이면
				System.out.print("삭제하고 싶은 내용의 갯수 : ");		//삭제 할 내용의 갯수 입력 유도 문구 출력
				int num = scan.nextInt();					//int형 변수 num애 석재할 내용의 갯수 입력받아서 저장
				for(int i=0;i<num;i++) {												//삭제할 내용의 갯수 만큼 반복하여
					System.out.println("[" + queue.remove() + "]" + "  삭제 되었습니다.");	//remove() 호출 및 삭제 내용 출력
				}
			}
			else if(number ==4) {													//number가 4이면
				System.out.println("[" + queue.remove() +"]" + "  삭제 되었습니다.");	//remove() 호출 및 삭제 내용 출력
			}
			else if(number ==5) {											//number가 5이면
				System.out.println("총 "+queue.size()+"개의 데이터가 존재합니다.");	//size() 호출하여 데이터 갯수 출력
			}
			else if(number == 6){											//number가 6이면
				System.out.println("현재 노드의 데이터는 "+queue.checkNode());		//checkNode() 호출하여 데이터 출력
			}
			else if(number == 7) {										//number가 7이면
				System.out.println("첫번째 값은 "+ queue.peek() + "입니다.");	//peek() 호출하여 첫번째 값 출력
			}
			else if(number ==8) {					//number가 8이면
				System.out.println("종료되었습니다.");	//종료되었다는 문구 출력
				break;								//프로그램 종료
			}
			else {									//그 외의 숫자를 입력받으면
				continue;							//while문 재 실행
			}
			System.out.println();					//while문의 한 싸이클이 끝나면 1줄 띄어쓰기
		}
	}
}
