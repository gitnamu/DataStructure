
public class Node {
	private int data;
	private Node next;
	
	public Node(int data) {
		this.data = data;	//�Ű������� �Է¹��� ����  data�� ����
		this.next = null;	//next�� null ����
	}
	
	public Node(int data, Node next) {
		this.data = data;	//�Ű������� �Է¹��� ����  data�� ����
		this.next = next;	//�Ű������� �Է¹��� Node��  next�� ����
	}
	
	public int getData() {
		return data;	//data ��ȯ
	}
	
	public Node getNext() {
		return next;	//next ��ȯ
	}
	
	public void setData(int data) {
		this.data = data;	//�Ű������� �Է¹��� ���� data�� ����
	}
	
	public void setNext(Node next) {
		this.next = next;	//�Ű������� �Է¹��� Node�� next�� ����
	}
}
