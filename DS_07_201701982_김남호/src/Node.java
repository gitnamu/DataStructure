
public class Node {
	private Object object;	//데이터를 담을 Object형 변수 선언
	private Node prev;		//이전 노드와 연결할 prev
	private Node next;		//다음  노드와 연결할 next
	
	public Node(Object object) {	//생성자
		this.object = object;		//입력받은 object를 this.object에 저장
		prev = null;				//prev에 null 저장
		next = null;				//next에 null 저장
	}
	
	public Node(Object object, Node prev, Node next) {	//생성자
		this.object = object;	//this.object에 입력받은 object 저장
		this.prev = prev;		//this.prev에 입력받은 prev 저장 
		this.next = next;		//this.next에 입력받은 next 저장
	}
	
	public Object getObject() {
		return this.object;		//object반환
	}
	
	public Node getPrev() {
		return this.prev;		//prev반환
	}
	
	public Node getNext() {
		return this.next;		//next반환
	}
	
	public void setObject(Object object) {
		this.object = object;	//object 설정
	}
	
	public void setPrev(Node prev) {
		this.prev = prev;		//prev 설정
	}
	
	public void setNext(Node next) {
		this.next = next;		//next 설정
	}
}
