package DS12_2;

public class Main {
	public static void main(String[] args) {
		BinaryTree treeA = new BinaryTree("7");
		treeA.insertKey("2");
		treeA.insertKey("1");
		treeA.insertKey("5");
		treeA.insertKey("3");
		treeA.insertKey("4");
		treeA.deleteKey(treeA,"2");
		System.out.println("treeA: "+treeA);
	}
}
