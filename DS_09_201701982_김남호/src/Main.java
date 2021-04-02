import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	//main �޼ҵ�
		Josephus js = new Josephus();			//Josephus Ÿ���� ��ü js�� �����Ѵ�
		js.run();								//js�� run()�� ȣ���Ѵ�
	}
}

class Josephus{
	protected void run(){
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();					//������ ��ĵ�޾� n�� �����Ѵ�
		int k = scan.nextInt();					//������ ��ĵ�޾� k�� �����Ѵ�
		
		String answer = nodeRemove(n,k); 		//nodeRemove(n,k)�� ȣ���Ͽ� ���� ��ȯ���� answer�� �����Ѵ�
		System.out.println("<" + answer.substring(0, answer.length()-2) + ">");	// < > ���̿� 'answer�� ����-2' ��ŭ answer�� ����Ѵ�
	}
	
	private String nodeRemove(int n, int k) {
		String removed = "";				//String���� removed�� �����Ѵ�
		Node head = new Node(1);			//NodeŸ���� head�� �����Ͽ� object�� 1�� �ִ´�
		Node tmpNode = head;				//NodeŸ���� tmpNode�� �����Ͽ� head�� �����Ѵ�
		
		for(int i=2;i<=n;i++) {				//i�� 2���� n���� ���������� �ݺ��Ѵ�
			Node newNode = new Node(i);		//Node Ÿ���� newNode�� �����Ͽ� object�� i�� �ִ´�
			tmpNode.setNext(newNode);		//tmpNode�� next�� newNode�� �����Ѵ�
			newNode.setPrev(tmpNode);		//tmpNode�� prev�� tmpNode�� �����Ѵ�
			tmpNode = newNode;				//tmpNode�� newNode�� �����Ѵ�
		}
		tmpNode.setNext(head);				//for���� ������ ������ ����� next�� head�� �����Ѵ�
		head.setPrev(tmpNode);				//head�� prev�� ������ ��带 �����Ѵ�
		
		tmpNode = head;						//tmpNode�� head�� �ʱ�ȭ �� �ش�
		for(int i=0;i<n;i++) {				//n�� �ݺ��Ѵ�
			for(int j=1;j<k;j++) {			//k-1�� �ݺ��Ͽ�
				tmpNode = tmpNode.next;		//tmpNode�� tmpNode.next�� �����Ѵ�
			}
			removed += tmpNode.object;			//removed�� tmpNode�� object�� ���Ͽ� �����Ѵ�
			removed += ", ";					//removed�� ,�� ������ ���Ͽ� �����Ѵ�
			tmpNode.next.setPrev(tmpNode.prev);	//tmpNode�� ���� ����� prev�� tmpNode�� �� ���� �����Ѵ� 
			tmpNode.prev.setNext(tmpNode.next);	//tmpNode�� ���� ����� next�� tmpNode�� ���� ���� �����Ѵ�
			tmpNode = tmpNode.next;				//tmpNode�� tmpNode.next�� �����Ѵ�
		}
		return removed;							//removed�� ��ȯ�Ѵ�
	}
	
	private class Node {
		private Object object;			//�����͸� ���� Object�� ���� ����
		private Node prev,next;			// NodeŸ���� prev, next ����

		Node(Object object) {			//������
			this.object = object;		//�Է¹��� object�� this.object�� ����
			prev = null;				//prev�� null ����
			next = null;				//next�� null ����
		}
		
		public void setPrev(Node prev) {
			this.prev = prev;			//prev ����
		}
		
		public void setNext(Node next) {
			this.next = next;			//next ����
		}
	}
}

