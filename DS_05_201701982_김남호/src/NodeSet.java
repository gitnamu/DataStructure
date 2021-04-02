
public class NodeSet implements Set{

	private Node head;
	private int size=0;
	
	@Override
	public boolean add(String data) {
		Node newNode = new Node(data);
		if(this.head == null) {
			head = newNode; 	// newNode를 head에 저장
			size++; 			// 크기 1증가
			return true; 		// true값을 반환한다
		} else if(!this.contains(data)) {
			Node tempNode = head; 				// Node타입의 tempNode를 선언해 head를 저장한다
			while(tempNode.getNext()!=null) { 	// tempNode의 next가 null일 때 까지 
				tempNode = tempNode.getNext();	//tempNode에 tempNode의 next를 저장한다
			}
			tempNode.setNext(newNode); 	// tempNode의 next를 newNode로 연결한다
			size++;						// 크기 1증가
			return true; 				// true 반환
		} else {
			System.out.println("이미 존재하는 데이터 입니다.");
			return false;
		}
	}

	@Override
	public boolean add(int num, String data) {
		Node newNode = new Node(data);
		int idx = 0;
		
		if(this.head == null) {
			head = newNode; 	// newNode를 head에 저장
			size++; 			// 크기 1증가
			return true; 		// true 반환
		} else if(!this.contains(data)) {
			Node tempNode = this.head; 
			if(num==0) {
				head = newNode; 					// newNode를 head에 저장
				head.setNext(tempNode); 			// head의 next에 tempNode(전 head) 연결
			}else {
				for(idx=0;idx<num-1;idx++) { 		// num-1번 반복해서
					tempNode = tempNode.getNext();  // tempNode에 tempNode의 next를 저장한다
				}
				newNode.setNext(tempNode.getNext());// newNode의 next를 tempNode의 next로 연결한다
				tempNode.setNext(newNode);			// tempNode의 next를 newNode로 연결한다
			}
			this.size++;
			return true;
		}else {
			System.out.println("이미 존재하는 데이터 입니다.");
			return false;
		}
		
	}

	@Override
	public boolean remove(String data) {
		Node previousNode = null;
		Node currentNode = this.head;
		boolean found = false;
		
		for(int i=0;i<size;i++) {						// 마지막 node까지 반복
			if(currentNode.getData().equals(data)) {	// 만약 currentNode의 data가 입력받은 data와 같다면
				if(previousNode == null) {				// previousNode가 null이면 지우려는 값이 head값 이므로
					head = currentNode.getNext();		// head에 두번째 node 저장
					size--; 							// 크기 1 감소
					return !found; 						// true 반환
				}else {									//previousNode == null이 아니면 
					previousNode.setNext(currentNode.getNext());// previousNode의 next에 currentNode의 next node를 연결
					size--;			// 연결리스트 크기 1 감소
					return !found;	// true 반환
				}
			}									// 만약 currentNode의 data가 입력받은 data와 다르면
			previousNode = currentNode;			//previousNode에 currentNode 저장
			currentNode = currentNode.getNext();// currentNode에 currentNode의 next 저장
		}				//입력받은 data와 일치하는 data를 못찾은 경우 
		return found;	//false 반환
	}

	@Override
	public boolean contains(String data) {
		Node searchNode = this.head;
		while(searchNode != null) {
			if(searchNode.getData().equals(data)) {	//searchNode의 data가 입력받은 data와 같은 값이면
				return true;						//true 반환
			}									//같지 않으면
			searchNode = searchNode.getNext();	// searchNode에 searchNode의 next값 저장
		}				//마지막 노드까지 일치하는 data가 없으면
		return false;	// false 반환
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public String checkNode() {
		String content = "";
		Node searchNode = this.head;
		while(searchNode != null) {
			content += searchNode.getData();	// content에 searchNode의 data를 추가하여 저장한다
			content += " ";	
			searchNode = searchNode.getNext();	// searchNode에 searchNode의 next 값을 저장한다
		}
		return content;
	}

	@Override
	public boolean swap(int i, int j) {
		if(this.size<i||this.size<j) {
			System.out.println("크기를 확인해 주세요");
			return false;
		} else if(i == j) {
			System.out.println("같은 수를 입력하였습니다.");
			return false;
		}
		else {
			Node inode = this.head;
			Node jnode = this.head;
			String temp = "";
			
			for(int z=0;z<i;z++) {		// i번 반복하여
				inode = inode.getNext();	// inode에 inode의 next를 저장한다
			}
			
			for(int x=0;x<j;x++) {		// j번 반복하여
				jnode = jnode.getNext();	// jnode에 jnode의 next를 저장한다
			}
			
			temp = inode.getData();			//temp에 inode의 data를 저장한다
			inode.setData(jnode.getData());	// inode의 data에 jnode의 data를 저장한다
			jnode.setData(temp);			// jnode의 data에  temp를 저장한다
			return true;					//true값을 반환한다
		}
	}

}
