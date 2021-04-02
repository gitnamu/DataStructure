package DS12_1;

public class TestBinaryTree {
	public static void main(String[] args) {
		BinaryTree treeB = new BinaryTree("B");
		BinaryTree treeD = new BinaryTree("D");
		BinaryTree treeE = new BinaryTree("E");
		BinaryTree treeC = new BinaryTree("C", treeD, treeE);
		BinaryTree treeA = new BinaryTree("A", treeB, treeC);
		BinaryTree treeX = new BinaryTree("X");
		BinaryTree treeY = new BinaryTree("Y", treeA, treeX);
		System.out.println("treeY: "+treeY);
		treeY.preorderPrint();
		System.out.println();
		treeY.inorderPrint();
		System.out.println();
		treeY.postorderPrint();
		System.out.println();
	}
}
