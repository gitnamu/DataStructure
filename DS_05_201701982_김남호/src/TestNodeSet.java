import java.util.Scanner;

public class TestNodeSet {
	public void run() {
		Set nodeset = new NodeSet();
		Scanner scan = new Scanner(System.in);
		int number;
		String content;
		
		while(true) {
			System.out.print("1. 마지막에 추가\n2. i번째 삽입\n3. 삭제\n4. 전체 확인\n5. 해당 내용이 있는지 확인\n6. 스왑\n7. 종료\n");
			System.out.print(">>번호를 입력하세요 : ");
			number = scan.nextInt();
			
			if(number == 1) {
				System.out.print(">>추가하고 싶은 내용을 입력하세요: ");
				content = scan.next();
				nodeset.add(content);
			}
			else if(number == 2) {
				if(nodeset.size()==0) {									//저장된 노드가 없으면
					System.out.println("존재하는 노드가 없습니다.");				//"존재하는 노드가 없습니다" 출력
					System.out.print(">>추가 하고 싶은 내용을 입력하세요: ");		//">>추가 하고 싶은 내용을 입력하세요: "출력
					content = scan.next();								//추가 할 내용 입력받아서 content에 저장
					nodeset.add(0, content);							//add(0,content)호출
				} else {
					System.out.print(">>몇 번째 삽입할지 입력하세요: ");
					int num = scan.nextInt();
					if(nodeset.size()>num) {
						System.out.print(">> 추가 하고 싶은 내용을 입력하세요: ");
						content = scan.next();
						nodeset.add(num, content);	
					}else {
						System.out.println("크기보다 작은 숫자를 입력해 주세요.");
					}
				}
			}
			else if(number ==3) {
				System.out.print(">>삭제할 내용을 입력하세요 : ");
				content = scan.next();
				if(nodeset.remove(content)) {
					System.out.println(">>해당 내용을 삭제하였습니다.");
				}else {
					System.out.println(">>해당 내용이 없습니다.");
				}
			}
			else if(number ==4) {
				System.out.println("현재 노드의 데이터는 "+nodeset.checkNode());
				System.out.println("총 "+nodeset.size()+"개의 노드가 존재합니다.");
				
			}
			else if(number ==5) {
				System.out.print(">>확인할 내용을 입력해 주세요.: ");
				content = scan.next();
				if(nodeset.contains(content)) {
					System.out.println(content+"가 있습니다.");
				}else {
					System.out.println(content+"가 없습니다.");
				}
			}
			else if(number ==6) {
				System.out.println("스왑합수입니다.");
				System.out.print(">>바꿀 노드 i를 입력해주세요. i : ");
				int i = scan.nextInt();
				System.out.print(">>바꿀 노드 j를 입력해주세요. j : ");
				int j = scan.nextInt();
				nodeset.swap(i,j);
			}
			else if(number ==7) {
				System.out.println(">>종료되었습니다.");
				break;
			}
		}
	}
}
