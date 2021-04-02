import java.util.Scanner;

public class TestNodeSet {
	public void run() {
		Set nodeset = new NodeSet();
		Scanner scan = new Scanner(System.in);
		int number;
		String content;
		
		while(true) {
			System.out.print("1. �������� �߰�\n2. i��° ����\n3. ����\n4. ��ü Ȯ��\n5. �ش� ������ �ִ��� Ȯ��\n6. ����\n7. ����\n");
			System.out.print(">>��ȣ�� �Է��ϼ��� : ");
			number = scan.nextInt();
			
			if(number == 1) {
				System.out.print(">>�߰��ϰ� ���� ������ �Է��ϼ���: ");
				content = scan.next();
				nodeset.add(content);
			}
			else if(number == 2) {
				if(nodeset.size()==0) {									//����� ��尡 ������
					System.out.println("�����ϴ� ��尡 �����ϴ�.");				//"�����ϴ� ��尡 �����ϴ�" ���
					System.out.print(">>�߰� �ϰ� ���� ������ �Է��ϼ���: ");		//">>�߰� �ϰ� ���� ������ �Է��ϼ���: "���
					content = scan.next();								//�߰� �� ���� �Է¹޾Ƽ� content�� ����
					nodeset.add(0, content);							//add(0,content)ȣ��
				} else {
					System.out.print(">>�� ��° �������� �Է��ϼ���: ");
					int num = scan.nextInt();
					if(nodeset.size()>num) {
						System.out.print(">> �߰� �ϰ� ���� ������ �Է��ϼ���: ");
						content = scan.next();
						nodeset.add(num, content);	
					}else {
						System.out.println("ũ�⺸�� ���� ���ڸ� �Է��� �ּ���.");
					}
				}
			}
			else if(number ==3) {
				System.out.print(">>������ ������ �Է��ϼ��� : ");
				content = scan.next();
				if(nodeset.remove(content)) {
					System.out.println(">>�ش� ������ �����Ͽ����ϴ�.");
				}else {
					System.out.println(">>�ش� ������ �����ϴ�.");
				}
			}
			else if(number ==4) {
				System.out.println("���� ����� �����ʹ� "+nodeset.checkNode());
				System.out.println("�� "+nodeset.size()+"���� ��尡 �����մϴ�.");
				
			}
			else if(number ==5) {
				System.out.print(">>Ȯ���� ������ �Է��� �ּ���.: ");
				content = scan.next();
				if(nodeset.contains(content)) {
					System.out.println(content+"�� �ֽ��ϴ�.");
				}else {
					System.out.println(content+"�� �����ϴ�.");
				}
			}
			else if(number ==6) {
				System.out.println("�����ռ��Դϴ�.");
				System.out.print(">>�ٲ� ��� i�� �Է����ּ���. i : ");
				int i = scan.nextInt();
				System.out.print(">>�ٲ� ��� j�� �Է����ּ���. j : ");
				int j = scan.nextInt();
				nodeset.swap(i,j);
			}
			else if(number ==7) {
				System.out.println(">>����Ǿ����ϴ�.");
				break;
			}
		}
	}
}
