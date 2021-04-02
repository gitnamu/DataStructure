import java.util.Scanner;

public class TestHashTable {
	public static void main(String[] args) {
		TestHashTable ht = new TestHashTable();	//TestHashTable ��ü ht ����
		ht.run();								//ht ��ü�� run �Լ� ȣ��
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);		//Scanner ��ü ����
		HashTable table = new HashTable(101,0.75F);	//HashTable ��ü table ���� �� �뷮 101, ������ 0.75�� ����
		
		while(true) {
			System.out.print("1.  [Hash] put\n2.  [Hash] get\n3.  ����\n");	//�Է� ��ȣ�� ��� ���� ���
			int num = input.nextInt();										//�Է¹��� ���ڸ� num�� ����
			
			if(num<1 || num>3) throw new IllegalArgumentException();	//���� num�� 1���� �۰ų� 3���� ũ�� ���� ��ü ����
			if(num == 1) {									//num�� 1�̸�
				System.out.println("key�� �Է��ϼ��� : ");		//key�Է¹��� ���
				String key = input.next();					//���� �Է¹޾Ƽ�  key�� ����
				System.out.println("������ �Է��ϼ��� : ");		//���� �Է¹��� ���
				String name = input.next();					//���� �Է¹޾� name�� ����
				System.out.println("�� �Է��ϼ��� : ");		//��� �Է¹��� ���
				String language = input.next();				//���� �Է¹޾� language�� ����
				
				Country country = new Country(name,language);	//name, language�� �Ű������� �ϴ� Country ��ü country ����
				table.put(key, country);					//HashTable ��ü table�� put()�� ȣ���Ͽ�  �Է¹��� key�� key��, country�� value�� �ϴ� ���ڵ� ���� 
			}
			else if(num == 2) {								//num�� 2�̸�
				System.out.println("key�� �Է��ϼ��� : ");		//key�Է� ���� ���
				String key = input.next();					//������ �Է¹޾� key�� ����
				System.out.println(table.get(key));			//get �޼ҵ带 ȣ���Ͽ� �ش� Ű ���� ���� ���ڵ� ���
			}
			else if(num == 3) {								//num�� 3�̸�
				break;										//�ݺ��� ����
			}
		}
	}
}
