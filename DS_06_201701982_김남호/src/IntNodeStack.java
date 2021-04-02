
public class IntNodeStack implements IntStack{
	private Node head;
	private int size;
	
	public boolean isEmpty() {		
		return (this.size == 0);	//size가 0이면 true를  반환한다
	}
	
	public int pop() {
		if(this.isEmpty())			//만약 stack이 비었으면
			return -1;				//-1 반환
		int popData = 0;			//pop할 데이터를 저장할 변수 선언
		Node currentNode = head;	//currentNode에 head 저장
		Node preNode = null;		//preNode 선언
		
		if(size==1) {					//만약 노드 갯수가 1개이면
			popData = head.getData();	//popData에 head의 data 저장
			head =null;					//head를 지운다
			size--;						//size감소
			return popData;				//popData 반환
		}
		while(currentNode.getNext()!=null) {	//currentNode의 next가 null이 아닌동안
			preNode = currentNode;				//preNode에 currentNode를 저장하고
			currentNode = currentNode.getNext();//currentNode에 currentNode의 next를 저장한다.
		}
		popData = currentNode.getData();		//popData에 currentNode의 data 저장
		preNode.setNext(null); 					//마지막 전 노드가 마지막 노드와 연결되지 않게 끊어준다
		this.size--;							//size 감소
		return popData;							//popData반환
	}
	
	public int popBottom() {
		if(this.isEmpty())				//만약 스택이 비었다면
			return -1;					//-1 반환
		
		int headData = head.getData();	//int형 변수 headData에 head의 data 저장
		head = head.getNext();			//head의 next를 head로 지정
		this.size--;					//size 감소
		return headData;				//headData 반환
	}
	
	public void push(int i) {
		Node newnode = new Node(i);		//입력받은 i를 data로 하는 Node인 newnode 생성
		if(this.isEmpty()) {			//만약 스택이 비었으면
			head = newnode;				//head에 newnode 저장
			size++;						//size 증가
		}
		else {									//스택이 비어있지 않으면
			Node tmpNode = head;				//tmpNode에 head 저장
			while(tmpNode.getNext()!=null) {	//tmpNode의 next가 null이 될 때까지
				tmpNode = tmpNode.getNext();	//tmpNode에 tmpNode의 next 저장
			}
			tmpNode.setNext(newnode);			//마지막 tmpNode의 next에 newnode 저장
			size++;								//size 증가
		}
	}
	
	public int size() {
		return size;		//size값 반환
	}
	
	public String checkNode() {
		String content = "";					//노드들의 data를 저장할 문자열 content 생성
		Node searchNode = this.head;			//searchNode에 head 저장
		while(searchNode != null) {				//searchNode가 null이 될 때까지
			content += searchNode.getData();	// content에 searchNode의 data를 추가하여 저장
			content += " ";						// content에 " "를 추가하여 저장
			searchNode = searchNode.getNext();	// searchNode에 searchNode의 next 저장
		}
		return content;							//content 반환
	}
}
