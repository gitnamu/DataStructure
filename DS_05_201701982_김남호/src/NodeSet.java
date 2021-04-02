
public class NodeSet implements Set{

	private Node head;
	private int size=0;
	
	@Override
	public boolean add(String data) {
		Node newNode = new Node(data);
		if(this.head == null) {
			head = newNode; 	// newNode�� head�� ����
			size++; 			// ũ�� 1����
			return true; 		// true���� ��ȯ�Ѵ�
		} else if(!this.contains(data)) {
			Node tempNode = head; 				// NodeŸ���� tempNode�� ������ head�� �����Ѵ�
			while(tempNode.getNext()!=null) { 	// tempNode�� next�� null�� �� ���� 
				tempNode = tempNode.getNext();	//tempNode�� tempNode�� next�� �����Ѵ�
			}
			tempNode.setNext(newNode); 	// tempNode�� next�� newNode�� �����Ѵ�
			size++;						// ũ�� 1����
			return true; 				// true ��ȯ
		} else {
			System.out.println("�̹� �����ϴ� ������ �Դϴ�.");
			return false;
		}
	}

	@Override
	public boolean add(int num, String data) {
		Node newNode = new Node(data);
		int idx = 0;
		
		if(this.head == null) {
			head = newNode; 	// newNode�� head�� ����
			size++; 			// ũ�� 1����
			return true; 		// true ��ȯ
		} else if(!this.contains(data)) {
			Node tempNode = this.head; 
			if(num==0) {
				head = newNode; 					// newNode�� head�� ����
				head.setNext(tempNode); 			// head�� next�� tempNode(�� head) ����
			}else {
				for(idx=0;idx<num-1;idx++) { 		// num-1�� �ݺ��ؼ�
					tempNode = tempNode.getNext();  // tempNode�� tempNode�� next�� �����Ѵ�
				}
				newNode.setNext(tempNode.getNext());// newNode�� next�� tempNode�� next�� �����Ѵ�
				tempNode.setNext(newNode);			// tempNode�� next�� newNode�� �����Ѵ�
			}
			this.size++;
			return true;
		}else {
			System.out.println("�̹� �����ϴ� ������ �Դϴ�.");
			return false;
		}
		
	}

	@Override
	public boolean remove(String data) {
		Node previousNode = null;
		Node currentNode = this.head;
		boolean found = false;
		
		for(int i=0;i<size;i++) {						// ������ node���� �ݺ�
			if(currentNode.getData().equals(data)) {	// ���� currentNode�� data�� �Է¹��� data�� ���ٸ�
				if(previousNode == null) {				// previousNode�� null�̸� ������� ���� head�� �̹Ƿ�
					head = currentNode.getNext();		// head�� �ι�° node ����
					size--; 							// ũ�� 1 ����
					return !found; 						// true ��ȯ
				}else {									//previousNode == null�� �ƴϸ� 
					previousNode.setNext(currentNode.getNext());// previousNode�� next�� currentNode�� next node�� ����
					size--;			// ���Ḯ��Ʈ ũ�� 1 ����
					return !found;	// true ��ȯ
				}
			}									// ���� currentNode�� data�� �Է¹��� data�� �ٸ���
			previousNode = currentNode;			//previousNode�� currentNode ����
			currentNode = currentNode.getNext();// currentNode�� currentNode�� next ����
		}				//�Է¹��� data�� ��ġ�ϴ� data�� ��ã�� ��� 
		return found;	//false ��ȯ
	}

	@Override
	public boolean contains(String data) {
		Node searchNode = this.head;
		while(searchNode != null) {
			if(searchNode.getData().equals(data)) {	//searchNode�� data�� �Է¹��� data�� ���� ���̸�
				return true;						//true ��ȯ
			}									//���� ������
			searchNode = searchNode.getNext();	// searchNode�� searchNode�� next�� ����
		}				//������ ������ ��ġ�ϴ� data�� ������
		return false;	// false ��ȯ
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
			content += searchNode.getData();	// content�� searchNode�� data�� �߰��Ͽ� �����Ѵ�
			content += " ";	
			searchNode = searchNode.getNext();	// searchNode�� searchNode�� next ���� �����Ѵ�
		}
		return content;
	}

	@Override
	public boolean swap(int i, int j) {
		if(this.size<i||this.size<j) {
			System.out.println("ũ�⸦ Ȯ���� �ּ���");
			return false;
		} else if(i == j) {
			System.out.println("���� ���� �Է��Ͽ����ϴ�.");
			return false;
		}
		else {
			Node inode = this.head;
			Node jnode = this.head;
			String temp = "";
			
			for(int z=0;z<i;z++) {		// i�� �ݺ��Ͽ�
				inode = inode.getNext();	// inode�� inode�� next�� �����Ѵ�
			}
			
			for(int x=0;x<j;x++) {		// j�� �ݺ��Ͽ�
				jnode = jnode.getNext();	// jnode�� jnode�� next�� �����Ѵ�
			}
			
			temp = inode.getData();			//temp�� inode�� data�� �����Ѵ�
			inode.setData(jnode.getData());	// inode�� data�� jnode�� data�� �����Ѵ�
			jnode.setData(temp);			// jnode�� data��  temp�� �����Ѵ�
			return true;					//true���� ��ȯ�Ѵ�
		}
	}

}
