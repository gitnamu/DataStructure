
public class Node {
	private Object object;	//�����͸� ���� Object�� ���� ����
	private Node prev;		//���� ���� ������ prev
	private Node next;		//����  ���� ������ next
	
	public Node(Object object) {	//������
		this.object = object;		//�Է¹��� object�� this.object�� ����
		prev = null;				//prev�� null ����
		next = null;				//next�� null ����
	}
	
	public Node(Object object, Node prev, Node next) {	//������
		this.object = object;	//this.object�� �Է¹��� object ����
		this.prev = prev;		//this.prev�� �Է¹��� prev ���� 
		this.next = next;		//this.next�� �Է¹��� next ����
	}
	
	public Object getObject() {
		return this.object;		//object��ȯ
	}
	
	public Node getPrev() {
		return this.prev;		//prev��ȯ
	}
	
	public Node getNext() {
		return this.next;		//next��ȯ
	}
	
	public void setObject(Object object) {
		this.object = object;	//object ����
	}
	
	public void setPrev(Node prev) {
		this.prev = prev;		//prev ����
	}
	
	public void setNext(Node next) {
		this.next = next;		//next ����
	}
}
