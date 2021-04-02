import java.util.Scanner;

public class TestArraySet{
	public void run() {
		Set set = new myArraySet();
		Scanner scan = new Scanner(System.in);
		int number;
		String content;
		
		while(true) {
			System.out.print("1. �߰�\n2. ����\n3. �������\n4. ������ ���\n5. �ش� ������ �ִ��� Ȯ��\n6. ����\n");
			System.out.print(">>��ȣ�� �Է��ϼ��� : ");
			number = scan.nextInt();
			scan.nextLine();
			
			if(number==1) {
				System.out.print("�߰��ϰ� ���� ������ �Է��ϼ��� : ");
				content = scan.next();
				set.add(content);
			}
			else if(number ==2) {
				System.out.print("������ ������ �Է��ϼ��� : ");
				content = scan.next();
				if(set.remove(content))
					System.out.println("�ش系���� �����Ͽ����ϴ�.");
				else System.out.println(">>�ش� ������ �����ϴ�.");
			}
			else if(number == 3) {
				this.print(set);
			}
			else if(number == 4) {
				System.out.println("������� "+ set.size()+"�Դϴ�.");
			}
			else if(number == 5) {
				System.out.print(">>Ȯ���� ������ �Է��� �ּ��� : ");
				content = scan.next();
				if(set.contains(content)) {
					System.out.println(content+ "�� �ֽ��ϴ�.");
				}else {
					System.out.println(content + "�� �����ϴ�.");
				}
			}
			else {
				System.out.println(">>����Ǿ����ϴ�.");
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
