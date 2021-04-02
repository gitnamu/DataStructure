import java.util.Scanner;

public class TestNodeStack {
	public void run() {
		IntStack stack = new IntNodeStack();
		Scanner scan = new Scanner(System.in);
		int number;
		int content;
		
		while(true) {
			System.out.print("1. ���ÿ� ���� �߰�\n2. ���ÿ� ���������� ���� ���� ����\n3. ���ÿ� ó�� ���� ���� ����\n4. ������ ���\n5. ���� ���\n6. ����\n");
			System.out.print(">>��ȣ�� �Է��ϼ��� : ");	//�� ��ȣ�� ��� ��� �� ��ȣ �Է� ����
			number = scan.nextInt();				//��ȣ�� �Է¹޾� number�� ����
			
			if(number == 1) {
				System.out.print(">>�߰��ϰ� ���� ���� �Է�: ");
				content = scan.nextInt();					//�߰��� ���� �Է¹���
				stack.push(content);						//push()�� ���� stack�� ����
			}
			else if(number ==2) {
				int re = stack.pop();								//stack�� pop()�� ���� ��ȯ���� ���� re�� ����
				if(re>0) {											//re�� 0���� ũ��
					System.out.println("["+re+"]"+"	���� �Ǿ����ϴ�.");	//���� ���� �޼��� ���
				}else {												//re�� 0���� ������
					System.out.println("������ ������ϴ�.");				//������ ����־� pop�� ���� ���ٰ� �˸�
				}
			}
			else if(number ==3) {
				int re = stack.popBottom();							//stack�� popBottom()�� ���� ��ȯ���� ���� re�� ����
				if(re>0) {											//re�� 0���� ũ��
					System.out.println("["+re+"]"+"	���� �Ǿ����ϴ�.");	//���� ���� �޼��� ���
				}else {												//re�� 0���� ������
					System.out.println("������ ������ϴ�.");				//������ ����־� popBottom�� ���� ���ٰ� �˸�
				}
			}
			else if(number ==4) {
				System.out.println("����� ������ "+stack.size()+"�� �Դϴ�.");//stack�� size() ȣ���ؼ� ��� ����  ���
			}
			else if(number ==5) {
				System.out.println("���� ����� �����ʹ� "+stack.checkNode());	//stack�� checkNode() ȣ���ؼ� ��� data ���
				System.out.println("�� "+stack.size()+"���� ��尡 �����մϴ�.");//stack�� size() ȣ���ؼ� ��� ���� ���
			}
			else {
				System.out.println(">>����Ǿ����ϴ�.");		//number�� 6 �Ǵ� �̿��� ���ڸ�
				break;									//���α׷� ����
			}
		}
	}
}
