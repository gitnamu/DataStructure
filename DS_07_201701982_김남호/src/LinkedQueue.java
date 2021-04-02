
public class LinkedQueue {
	private Node head = new Node(null);
	private int size = 0;
	
	public boolean isEmpty() {
		return(size==0);	//size가 0이면 참을 반환한다
	}
	
	public void add(int num, Object object) {
		Node newNode = new Node(object);	//입력받은 수를 object로 하는 Node를 생성한다
		if(this.isEmpty()) {				//만약 size가 0이라면
			head.setNext(newNode);			//head의 next를 newNode로 설정한다
			newNode.setPrev(head);			//newNode의 prev를 head로 설정한다
		}
		else {								//만약 size가 0이 아니면
			Node tmp = head;				//Node 타입의 tmp에 head를 저장한다
			for(int i=0;i<num-1;i++) {		//num-1번째 노드에 도달할 때 까지
				tmp = tmp.getNext();		//tmp에 tmp의 next를 저장한다
			}
			tmp.getNext().setPrev(newNode);	//tmp의 next의 prev를 newNode로 설정한다
			newNode.setNext(tmp.getNext());	//newNode의 next를 tmp의 next로 설정한다
			tmp.setNext(newNode);			//tmp의 next를 newNode로 설정한다
			newNode.setPrev(tmp);			//newNode의 prev를 tmp로 설정한다
		}
		size++;								//size를 +1한다
	}
	
	public void add(Object object) {		
		Node newNode = new Node(object);	//입력받은 수를 object로 하는 노드 newNode를 생성한다
		if(this.isEmpty()) {				//만약 size가 0이면
			head.setNext(newNode);			//head의 next를 newNode로 설정한다
			newNode.setPrev(head);			//newNode의 prev를 head로 설정한다
		}
		else {								//만약 size가 0이 아니면
			Node tmp = head;				//Node 타입의 tmp에 head를 저장한다
			for(int i=0;i<size;i++) {		// 마지막 Node에 도달할때 까지 
				tmp = tmp.getNext();		//tmp에 tmp의 next를 저장한다
			}
			tmp.setNext(newNode);			//tmp의 next를 newNode로 설정한다
			newNode.setPrev(tmp);			//newNode의 prev를 tmp로 설정한다
		}
		size++;								//size를 +1한다
	}
	
	public Object remove() {
		if(size ==0) 												//size가 0이면
			throw new IllegalStateException("the queue is empty");	//"the queue is empty" 예외처리
		else {											//size가 0이 아니면
			Object obj = this.peek();					//Object 형의 obj에 첫번쩨 노드의 object를 저장한다
			Node tmp = head.getNext().getNext();		//tmp 노드에 두번째 노드를 저장한다
			head.setNext(tmp);							//head의 next를 tmp로 설정한다			
			if(size == 1) {				//만약 size가 1이면
				size--;					//size를 -1하고
				return obj;				//첫번째 노드의 데이터였던 obj를 반환한다
			}else {						//size가 1보다 크면
				tmp.setPrev(head);		//tmp의 prev를 head로 설정한다
				size--;					//size를 -1한다
				return obj;				//첫번째 노드의 데이터였던 obj를 반환한다
			}
		}
	}
	
	public int size() {
		return size;		//size를 반환한다
	}
	
	public String checkNode() {
		if(this.isEmpty())			//size가 0이면
			return "없습니다.";		// 없다고 출력
		String obj = "";			//String 타입의 변수 obj 생성
		Node tmp = head.getNext();	//Node타입의 tmp에 head의 next저장
		for(int i=0;i<size;i++) {	//마지막 노드까지 반복
			obj += tmp.getObject();	//obj에 tmp의 object 저장
			obj += " ";				//띄어쓰기 저장
			tmp = tmp.getNext();	//tmp에 tmp의 next 저장
		}
		return obj;					//obj반환
	}
	
	public Node getHead() {
		return head;				// head반환
	}
	
	public Object peek() {
		if(size ==0) 												//size가 0이면
			throw new IllegalStateException("the queue is empty");	// 예외 처리 문구 출력
		else {														//size가 0이 아니면
			return head.getNext().getObject();						//head의 next의 object 반환
		}
	}
}
