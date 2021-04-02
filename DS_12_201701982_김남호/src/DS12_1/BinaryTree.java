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
		if(left!=null) {				//left가 null이 아니면 
			left.inorderPrint();		//left에 대해 재귀호출한다
		}
		System.out.print(root + " ");	//현재 객체, 즉, root와 " "를 출력한다
		if(right!=null) {				//right가 null이 아니면
			right.inorderPrint();		//right에 대해 재귀호출한다
		}
	}
	public void preorderPrint() {
		System.out.print(root + " ");	//현재 객체, 즉, root와 " "를 호출한다
		if(left!=null) {				//만약 left가 null이 아니면
			left.preorderPrint();		//left에 대해 재귀호출한다
		}
		if(right!=null) {				//right가 null이 아니면
			right.preorderPrint();		//right에 대해 재귀호출한다
		}
	}
	
	public void postorderPrint() {
		if(left!=null) {				//left가 null이 아니면
			left.postorderPrint();		//left에 대해 재귀호출한다
		}
		if(right!=null) {				//right가 null이 아니면
			right.postorderPrint();		//right에 대해 재귀호출한다
		}
		System.out.print(root + " ");	//현재 객체, 즉, root와 " "를 출력한다
	}
}
