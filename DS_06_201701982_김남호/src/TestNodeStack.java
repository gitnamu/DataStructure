import java.util.Scanner;

public class TestNodeStack {
	public void run() {
		IntStack stack = new IntNodeStack();
		Scanner scan = new Scanner(System.in);
		int number;
		int content;
		
		while(true) {
			System.out.print("1. 스택에 내용 추가\n2. 스택에 마지막으로 들어온 내용 삭제\n3. 스택에 처음 들어온 내용 삭제\n4. 사이즈 출력\n5. 내용 출력\n6. 종료\n");
			System.out.print(">>번호를 입력하세요 : ");	//각 번호별 기능 출력 및 번호 입력 유도
			number = scan.nextInt();				//번호를 입력받아 number에 저장
			
			if(number == 1) {
				System.out.print(">>추가하고 싶은 숫자 입력: ");
				content = scan.nextInt();					//추가할 숫자 입력받음
				stack.push(content);						//push()를 통해 stack에 저장
			}
			else if(number ==2) {
				int re = stack.pop();								//stack의 pop()을 통해 반환받은 값을 re에 저장
				if(re>0) {											//re가 0보다 크면
					System.out.println("["+re+"]"+"	삭제 되었습니다.");	//정상 삭제 메세지 출력
				}else {												//re가 0보다 작으면
					System.out.println("스택이 비었습니다.");				//스택이 비어있어 pop할 값이 없다고 알림
				}
			}
			else if(number ==3) {
				int re = stack.popBottom();							//stack의 popBottom()을 통해 반환받은 값을 re에 저장
				if(re>0) {											//re가 0보다 크면
					System.out.println("["+re+"]"+"	삭제 되었습니다.");	//정상 삭제 메세지 출력
				}else {												//re가 0보다 작으면
					System.out.println("스택이 비었습니다.");				//스택이 비어있어 popBottom할 값이 없다고 알림
				}
			}
			else if(number ==4) {
				System.out.println("노드의 갯수는 "+stack.size()+"개 입니다.");//stack의 size() 호출해서 노드 갯수  출력
			}
			else if(number ==5) {
				System.out.println("현재 노드의 데이터는 "+stack.checkNode());	//stack의 checkNode() 호출해서 노드 data 출력
				System.out.println("총 "+stack.size()+"개의 노드가 존재합니다.");//stack의 size() 호출해서 노드 갯수 출력
			}
			else {
				System.out.println(">>종료되었습니다.");		//number가 6 또는 이외의 숫자면
				break;									//프로그램 종료
			}
		}
	}
}
