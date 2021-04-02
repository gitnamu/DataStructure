package DS12_2;

public class BinaryTree {
	private Object value;
	private BinaryTree left, right;
	
	public BinaryTree(Object data) {
		this.value = data;
		this.left = null;
		this.right = null;
	}
	
	public Object getValue() {
		return value;					//value�� ��ȯ�Ѵ�
	}
	public void setValue(Object data) {
		value = data;					//value�� �����Ѵ�
	}
	public BinaryTree getLeft() {
		return left;					//left�� ��ȯ�Ѵ�
	}
	public void setLeft(BinaryTree left) {
		this.left = left;				//left�� �����Ѵ�
	}
	public BinaryTree getRight() {
		return right;					//right�� ��ȯ�Ѵ�
	}
	public void setRight(BinaryTree right) {
		this.right = right;				//right�� �����Ѵ�
	}
	public String toString() {
		StringBuffer buf = new StringBuffer("[");
		if(left!=null)	buf.append(left+",");
		buf.append(value);
		if(right!=null)	buf.append(","+right);
		return buf + "]";
	}
	
	public void insertKey(Object data) {
		Comparable key = (Comparable) value;
		if(key.compareTo(data)<0) {			//���� data�� value���� ũ��
			if(this.right != null) {		//right�� null�� �ƴϸ�
				right.insertKey(data);		//right�� ���� ���ȣ���Ѵ�
			}else if(this.right == null) {	//���� right�� null�̸�
			BinaryTree newTree = new BinaryTree(data);	//data�� value�� �ϴ� BinaryTree��ü�� �����Ͽ�
			this.setRight(newTree);			//���� ��ü�� right�� �����Ѵ�
			}
		}
		else {								//���� data�� value���� �۰ų� ����
			if(this.left != null) {			//left�� null�� �ƴϸ�
				left.insertKey(data);		//left�� ���� ���ȣ���Ѵ�
			}else if(this.left == null) {	//���� left�� null�̸�
			BinaryTree newTree = new BinaryTree(data);	//data�� value�� �ϴ� BinaryTree ��ü�� �����Ͽ�
			this.setLeft(newTree);			//���� ��ü�� left�� �����Ѵ�
			}
		}
	}
	
	public boolean deleteKey(BinaryTree root, Object data) {
		Comparable key = (Comparable) root.value;			//���� root�� value�� ComparableŸ���� key�� �����Ѵ�
		if(key.compareTo(data)<0) {								//���� key���� data�� �� ũ��
			if(this.right != null) {							//���� right�� null�� �ƴѵ�
				if(right.deleteKey(right,data)) {					//right�� ���� ���ȣ���� �� ���� ���̶��
					if(right.right !=null && right.left !=null) {		//right�� �ڽ��� �� �� ������
						BinaryTree tmp = getRightMin(right);			//right�� ������ �ڽ��� ���� ���� �ڽ��� tmp�� ����
						tmp.setLeft(this.right.left);					//tmp�� left�� ���� right�� left�� ����
						tmp.setRight(this.right.right);					//tmp�� right�� ���� right�� right�� ����
						this.setRight(tmp);								//tmp�� ���� ��ü�� right�� ����
					}
					else if(right.right !=null || right.left !=null) {//�ڽ��� �� �� �ϳ��� ������
						if(right.right == null) {						//right�� right�� null�̸� 
							this.setRight(right.left);					//���� ��ü�� right�� right�� left�� ����
						}
						else this.setRight(right.right);				//���� right�� left�� null�̸� ���� ��ü�� right�� right�� right�� ����
					}
					else this.setRight(null);							//�ڽ��� �� �� ���ٸ� right�� null�� ����
				}
			}else if(this.right == null) {						//���� right�� null�̸�
				return false;									//false�� ��ȯ
			}
		}
		else if(key.compareTo(data)>0) {						//���� key���� data�� �۰�
			if(this.left != null) {								//���� left�� null�� �ƴѵ�
				if(left.deleteKey(left,data)) {						//left�� ���� ���ȣ���� ���� ���̶��
					if(left.right !=null && left.left !=null) {			//left�� �ڽ��� �� �� ����
						BinaryTree tmp = getRightMin(left);				//left�� ������ �ڽ��� ���� ���� �ڽ��� tmp�� ����
						tmp.setLeft(this.left.left);					//tmp�� left�� ���� left�� left�� ����
						tmp.setRight(this.left.right);					//tmp�� left�� ���� left�� right�� ����
						this.setLeft(tmp);								//���� ��ü�� left�� tmp�� ����
					}
					else if(left.right !=null || left.left !=null) {//left�� �ڽ��� �ϳ��� �ִٸ�
						if(left.right == null) {						//left�� right�� null�̸�
							this.setLeft(left.left);					//left�� left�� left�� ����
						}												//left�� left�� null�̸�
						else this.setLeft(left.right);					//left�� left�� right�� ����
					}													//�ڽ��� �ϳ��� ������
					else this.setLeft(null);							//left�� null�� �����Ѵ�
				}
			}else if(this.left == null) {						//���� left�� null�̸�
				return false;									//false ��ȯ
			}
		}
		else {													//���� key�� data�� ������	
			return true;										//true ��ȯ
		}
		return false;											//���� �ƴ϶�� �߸��� ���̹Ƿ� false ��ȯ
	}
	
	public BinaryTree getRightMin(BinaryTree deleteObj) {
		BinaryTree prev = deleteObj;			//BinaryTree ��ü prev�� �����Ͽ� ������ �� ����
		BinaryTree tmp = deleteObj.right;		//BinaryTree ��ü tmp�� �����Ͽ� ������ ���� right ����
		while(tmp.left!=null) {					//tmp�� left�� null�� �ƴҶ�����
			prev = tmp;							//prev�� tmp ����
			tmp = tmp.left;						//tmp�� tmp�� left ����
		}
			prev.setLeft(tmp.right);			//prev�� left�� tmp�� right�� ����
			tmp.setRight(null);					//tmp�� right�� null�� ����
		return tmp;								//tmp ��ȯ
	}
}
