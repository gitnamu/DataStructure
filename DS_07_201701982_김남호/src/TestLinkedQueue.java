import java.util.Scanner;

public class TestLinkedQueue {
	public void run() {
		LinkedQueue queue = new LinkedQueue();
		Scanner scan = new Scanner(System.in);
		int number;
		Object obj;
		
		while(true) {
			System.out.println("====== MENU ======");	//�޴� �� ��ȣ�� ��� ���� ���
			System.out.print("1. [Queue] ���� �߰�\n2. [Queue] �߰��� ���� �߰�\n3. [Queue] ���� 'N'�� ����\n4. [Queue] ���� �ϳ� ����\n5. [Queue] ������ ���\n6. [Queue] ����Ǿ� �ִ� ��� ���� ���\n7. [Queue] ù ��° �� ���\n");
			System.out.print(">> ��ȣ�� �Է�: ");			//��ȣ �Է� ���� ���� ���
			number = scan.nextInt();					//��ȣ�� �Է¹޾Ƽ� number�� ����
			
			if(number == 1) {							//number�� 1�̸�
				System.out.print("�߰��ϰ� ���� ���� �Է�: ");	//�߰� �� ���� �Է� ���� ���� ���
				obj = scan.nextInt();					//�߰� �� ���� �Է¹޾Ƽ� obj�� ����
				queue.add(obj);							//add(obj) ȣ��
			}
			else if(number ==2) {							//number�� 2�̸�
				System.out.print("���° ������ �� �Է��ϼ��� : ");	//��� ° �������� �Է� ���� ���� ���
				int num = scan.nextInt();					//���ڸ� �Է¹޾Ƽ� int�� ���� num�� ����
				System.out.print("�߰��ϰ� ���� ���� �Է�: ");		//�߰� �� ���� �Է� ���� ���� ���
				obj = scan.nextInt();						//obj�� �߰� �� ���� �Է¹޾Ƽ� ����
				queue.add(num, obj);						//add(num, obj) ȣ��
			}
			else if(number ==3) {							//number�� 3�̸�
				System.out.print("�����ϰ� ���� ������ ���� : ");		//���� �� ������ ���� �Է� ���� ���� ���
				int num = scan.nextInt();					//int�� ���� num�� ������ ������ ���� �Է¹޾Ƽ� ����
				for(int i=0;i<num;i++) {												//������ ������ ���� ��ŭ �ݺ��Ͽ�
					System.out.println("[" + queue.remove() + "]" + "  ���� �Ǿ����ϴ�.");	//remove() ȣ�� �� ���� ���� ���
				}
			}
			else if(number ==4) {													//number�� 4�̸�
				System.out.println("[" + queue.remove() +"]" + "  ���� �Ǿ����ϴ�.");	//remove() ȣ�� �� ���� ���� ���
			}
			else if(number ==5) {											//number�� 5�̸�
				System.out.println("�� "+queue.size()+"���� �����Ͱ� �����մϴ�.");	//size() ȣ���Ͽ� ������ ���� ���
			}
			else if(number == 6){											//number�� 6�̸�
				System.out.println("���� ����� �����ʹ� "+queue.checkNode());		//checkNode() ȣ���Ͽ� ������ ���
			}
			else if(number == 7) {										//number�� 7�̸�
				System.out.println("ù��° ���� "+ queue.peek() + "�Դϴ�.");	//peek() ȣ���Ͽ� ù��° �� ���
			}
			else if(number ==8) {					//number�� 8�̸�
				System.out.println("����Ǿ����ϴ�.");	//����Ǿ��ٴ� ���� ���
				break;								//���α׷� ����
			}
			else {									//�� ���� ���ڸ� �Է¹�����
				continue;							//while�� �� ����
			}
			System.out.println();					//while���� �� ����Ŭ�� ������ 1�� ����
		}
	}
}
