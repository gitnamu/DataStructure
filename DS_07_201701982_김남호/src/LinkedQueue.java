
public class LinkedQueue {
	private Node head = new Node(null);
	private int size = 0;
	
	public boolean isEmpty() {
		return(size==0);	//size�� 0�̸� ���� ��ȯ�Ѵ�
	}
	
	public void add(int num, Object object) {
		Node newNode = new Node(object);	//�Է¹��� ���� object�� �ϴ� Node�� �����Ѵ�
		if(this.isEmpty()) {				//���� size�� 0�̶��
			head.setNext(newNode);			//head�� next�� newNode�� �����Ѵ�
			newNode.setPrev(head);			//newNode�� prev�� head�� �����Ѵ�
		}
		else {								//���� size�� 0�� �ƴϸ�
			Node tmp = head;				//Node Ÿ���� tmp�� head�� �����Ѵ�
			for(int i=0;i<num-1;i++) {		//num-1��° ��忡 ������ �� ����
				tmp = tmp.getNext();		//tmp�� tmp�� next�� �����Ѵ�
			}
			tmp.getNext().setPrev(newNode);	//tmp�� next�� prev�� newNode�� �����Ѵ�
			newNode.setNext(tmp.getNext());	//newNode�� next�� tmp�� next�� �����Ѵ�
			tmp.setNext(newNode);			//tmp�� next�� newNode�� �����Ѵ�
			newNode.setPrev(tmp);			//newNode�� prev�� tmp�� �����Ѵ�
		}
		size++;								//size�� +1�Ѵ�
	}
	
	public void add(Object object) {		
		Node newNode = new Node(object);	//�Է¹��� ���� object�� �ϴ� ��� newNode�� �����Ѵ�
		if(this.isEmpty()) {				//���� size�� 0�̸�
			head.setNext(newNode);			//head�� next�� newNode�� �����Ѵ�
			newNode.setPrev(head);			//newNode�� prev�� head�� �����Ѵ�
		}
		else {								//���� size�� 0�� �ƴϸ�
			Node tmp = head;				//Node Ÿ���� tmp�� head�� �����Ѵ�
			for(int i=0;i<size;i++) {		// ������ Node�� �����Ҷ� ���� 
				tmp = tmp.getNext();		//tmp�� tmp�� next�� �����Ѵ�
			}
			tmp.setNext(newNode);			//tmp�� next�� newNode�� �����Ѵ�
			newNode.setPrev(tmp);			//newNode�� prev�� tmp�� �����Ѵ�
		}
		size++;								//size�� +1�Ѵ�
	}
	
	public Object remove() {
		if(size ==0) 												//size�� 0�̸�
			throw new IllegalStateException("the queue is empty");	//"the queue is empty" ����ó��
		else {											//size�� 0�� �ƴϸ�
			Object obj = this.peek();					//Object ���� obj�� ù���� ����� object�� �����Ѵ�
			Node tmp = head.getNext().getNext();		//tmp ��忡 �ι�° ��带 �����Ѵ�
			head.setNext(tmp);							//head�� next�� tmp�� �����Ѵ�			
			if(size == 1) {				//���� size�� 1�̸�
				size--;					//size�� -1�ϰ�
				return obj;				//ù��° ����� �����Ϳ��� obj�� ��ȯ�Ѵ�
			}else {						//size�� 1���� ũ��
				tmp.setPrev(head);		//tmp�� prev�� head�� �����Ѵ�
				size--;					//size�� -1�Ѵ�
				return obj;				//ù��° ����� �����Ϳ��� obj�� ��ȯ�Ѵ�
			}
		}
	}
	
	public int size() {
		return size;		//size�� ��ȯ�Ѵ�
	}
	
	public String checkNode() {
		if(this.isEmpty())			//size�� 0�̸�
			return "�����ϴ�.";		// ���ٰ� ���
		String obj = "";			//String Ÿ���� ���� obj ����
		Node tmp = head.getNext();	//NodeŸ���� tmp�� head�� next����
		for(int i=0;i<size;i++) {	//������ ������ �ݺ�
			obj += tmp.getObject();	//obj�� tmp�� object ����
			obj += " ";				//���� ����
			tmp = tmp.getNext();	//tmp�� tmp�� next ����
		}
		return obj;					//obj��ȯ
	}
	
	public Node getHead() {
		return head;				// head��ȯ
	}
	
	public Object peek() {
		if(size ==0) 												//size�� 0�̸�
			throw new IllegalStateException("the queue is empty");	// ���� ó�� ���� ���
		else {														//size�� 0�� �ƴϸ�
			return head.getNext().getObject();						//head�� next�� object ��ȯ
		}
	}
}
