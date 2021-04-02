import java.util.Scanner;

public class TestArraySet{
	public void run() {
		Set set = new myArraySet();
		Scanner scan = new Scanner(System.in);
		int number;
		String content;
		
		while(true) {
			System.out.print("1. 추가\n2. 삭제\n3. 내용출력\n4. 사이즈 출력\n5. 해당 내용이 있는지 확인\n6. 종료\n");
			System.out.print(">>번호를 입력하세요 : ");
			number = scan.nextInt();
			scan.nextLine();
			
			if(number==1) {
				System.out.print("추가하고 싶은 내용을 입력하세요 : ");
				content = scan.next();
				set.add(content);
			}
			else if(number ==2) {
				System.out.print("삭제할 내용을 입력하세요 : ");
				content = scan.next();
				if(set.remove(content))
					System.out.println("해당내용을 삭제하였습니다.");
				else System.out.println(">>해당 내용이 없습니다.");
			}
			else if(number == 3) {
				this.print(set);
			}
			else if(number == 4) {
				System.out.println("사이즈는 "+ set.size()+"입니다.");
			}
			else if(number == 5) {
				System.out.print(">>확인할 내용을 입력해 주세요 : ");
				content = scan.next();
				if(set.contains(content)) {
					System.out.println(content+ "가 있습니다.");
				}else {
					System.out.println(content + "가 없습니다.");
				}
			}
			else {
				System.out.println(">>종료되었습니다.");
				break;
			}
		}
	}
	
	public void print(Set set) {
		System.out.print(set.getFirst());
		for(int idx=1;idx<set.size();idx++) {
			System.out.print(", "+set.getNext());
		}
		System.out.println();
		System.out.println();
	}
}
