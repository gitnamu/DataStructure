
public class Node {
	private int data;
	private Node next;
	
	public Node(int data) {
		this.data = data;	//매개변수로 입력받은 값을  data에 저장
		this.next = null;	//next에 null 저장
	}
	
	public Node(int data, Node next) {
		this.data = data;	//매개변수로 입력받은 값을  data에 저장
		this.next = next;	//매개변수로 입력받은 Node를  next에 저장
	}
	
	public int getData() {
		return data;	//data 반환
	}
	
	public Node getNext() {
		return next;	//next 반환
	}
	
	public void setData(int data) {
		this.data = data;	//매개변수로 입력받은 값을 data에 저장
	}
	
	public void setNext(Node next) {
		this.next = next;	//매개변수로 입력받은 Node를 next에 저장
	}
}
