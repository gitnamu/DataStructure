package DS12_1;

public class BinaryTree {
	private Object root;
	private BinaryTree left, right;
	
	public BinaryTree(Object root) {
		this.root = root;
	}
	
	public BinaryTree(Object root, BinaryTree left, BinaryTree right) {
		this(root);
		if(left!=null)	this.left = left;
		if(right!=null)	this.right = right;
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer("[");
		if(left!=null)	buf.append(left + ",");
		buf.append(root);
		if(right!=null)	buf.append("," + right);
		return buf + "]";
	}
	
	public void inorderPrint() {
		if(left!=null) {				//left�� null�� �ƴϸ� 
			left.inorderPrint();		//left�� ���� ���ȣ���Ѵ�
		}
		System.out.print(root + " ");	//���� ��ü, ��, root�� " "�� ����Ѵ�
		if(right!=null) {				//right�� null�� �ƴϸ�
			right.inorderPrint();		//right�� ���� ���ȣ���Ѵ�
		}
	}
	public void preorderPrint() {
		System.out.print(root + " ");	//���� ��ü, ��, root�� " "�� ȣ���Ѵ�
		if(left!=null) {				//���� left�� null�� �ƴϸ�
			left.preorderPrint();		//left�� ���� ���ȣ���Ѵ�
		}
		if(right!=null) {				//right�� null�� �ƴϸ�
			right.preorderPrint();		//right�� ���� ���ȣ���Ѵ�
		}
	}
	
	public void postorderPrint() {
		if(left!=null) {				//left�� null�� �ƴϸ�
			left.postorderPrint();		//left�� ���� ���ȣ���Ѵ�
		}
		if(right!=null) {				//right�� null�� �ƴϸ�
			right.postorderPrint();		//right�� ���� ���ȣ���Ѵ�
		}
		System.out.print(root + " ");	//���� ��ü, ��, root�� " "�� ����Ѵ�
	}
}
