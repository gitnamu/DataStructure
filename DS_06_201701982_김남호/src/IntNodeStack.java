
public class IntNodeStack implements IntStack{
	private Node head;
	private int size;
	
	public boolean isEmpty() {		
		return (this.size == 0);	//size�� 0�̸� true��  ��ȯ�Ѵ�
	}
	
	public int pop() {
		if(this.isEmpty())			//���� stack�� �������
			return -1;				//-1 ��ȯ
		int popData = 0;			//pop�� �����͸� ������ ���� ����
		Node currentNode = head;	//currentNode�� head ����
		Node preNode = null;		//preNode ����
		
		if(size==1) {					//���� ��� ������ 1���̸�
			popData = head.getData();	//popData�� head�� data ����
			head =null;					//head�� �����
			size--;						//size����
			return popData;				//popData ��ȯ
		}
		while(currentNode.getNext()!=null) {	//currentNode�� next�� null�� �ƴѵ���
			preNode = currentNode;				//preNode�� currentNode�� �����ϰ�
			currentNode = currentNode.getNext();//currentNode�� currentNode�� next�� �����Ѵ�.
		}
		popData = currentNode.getData();		//popData�� currentNode�� data ����
		preNode.setNext(null); 					//������ �� ��尡 ������ ���� ������� �ʰ� �����ش�
		this.size--;							//size ����
		return popData;							//popData��ȯ
	}
	
	public int popBottom() {
		if(this.isEmpty())				//���� ������ ����ٸ�
			return -1;					//-1 ��ȯ
		
		int headData = head.getData();	//int�� ���� headData�� head�� data ����
		head = head.getNext();			//head�� next�� head�� ����
		this.size--;					//size ����
		return headData;				//headData ��ȯ
	}
	
	public void push(int i) {
		Node newnode = new Node(i);		//�Է¹��� i�� data�� �ϴ� Node�� newnode ����
		if(this.isEmpty()) {			//���� ������ �������
			head = newnode;				//head�� newnode ����
			size++;						//size ����
		}
		else {									//������ ������� ������
			Node tmpNode = head;				//tmpNode�� head ����
			while(tmpNode.getNext()!=null) {	//tmpNode�� next�� null�� �� ������
				tmpNode = tmpNode.getNext();	//tmpNode�� tmpNode�� next ����
			}
			tmpNode.setNext(newnode);			//������ tmpNode�� next�� newnode ����
			size++;								//size ����
		}
	}
	
	public int size() {
		return size;		//size�� ��ȯ
	}
	
	public String checkNode() {
		String content = "";					//������ data�� ������ ���ڿ� content ����
		Node searchNode = this.head;			//searchNode�� head ����
		while(searchNode != null) {				//searchNode�� null�� �� ������
			content += searchNode.getData();	// content�� searchNode�� data�� �߰��Ͽ� ����
			content += " ";						// content�� " "�� �߰��Ͽ� ����
			searchNode = searchNode.getNext();	// searchNode�� searchNode�� next ����
		}
		return content;							//content ��ȯ
	}
}
