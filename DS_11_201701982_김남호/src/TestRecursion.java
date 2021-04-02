import java.util.Scanner;

public class TestRecursion {
	public static void main(String[] args) {
		TestRecursion tr = new TestRecursion();	//TestRecursion ��ü tr ���� 
		tr.run();								//tr�� run�Լ� ȣ��
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);	//��ĳ�� ��ü input ����
		Quicksort qs = new Quicksort(100);		// Quicksort ��ü qs ���� �� maxSize 100���� �ʱ�ȭ
		
		while(true) {
			System.out.print("1.  [Recursion] add\n2.  [Recursion] sort\n3.  [Recursion] print\n4.  ����\n");		//�Է� ��ȣ�� ��� ���� ���
			System.out.print("> ��ȣ�� �Է� : ");							//��ȣ �Է� ���� ���
			int num = input.nextInt();									//���ڸ� �Է¹޾Ƽ� num�� ����
			
			if(num==1) {												//num�� 1�̸�
				System.out.print("�߰� �ϰ� ���� ������ �Է��ϼ��� : ");			//�߰��� ���� �Է� ���� ���
				int data = input.nextInt();								//���� �Է¹޾Ƽ� data�� ����
				if(!qs.add(data)) 										//���� add(data)���� false�̸�
					System.out.println("�迭�� �ִ� ����� �����߽��ϴ�.");		//�迭�� size�� maxSize�� �����ߴٴ� ���� ���
			}
			else if(num==2) {									//num�� 2�̸�
				qs.sorting();									//qs ��ü�� sorting �޼ҵ� ȣ��
				System.out.println("> ������������ ������ �Ϸ�.");		//���� �Ϸ� �޼ҵ� ���
			}
			else if(num==3) {		//num�� 3�̸�
				qs.print();			//qs ��ü�� print �޼ҵ� ȣ��
			}
			else if(num==4) {						//num�� 4�̸�
				System.out.println("����Ǿ����ϴ�.");	//���� �޼��� ���
				break;								//�ݺ��� ����
			}
		}
	}
}
