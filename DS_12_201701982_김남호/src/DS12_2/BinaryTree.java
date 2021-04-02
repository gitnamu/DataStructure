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
		return value;					//value¸¦ ¹İÈ¯ÇÑ´Ù
	}
	public void setValue(Object data) {
		value = data;					//value¸¦ ¼³Á¤ÇÑ´Ù
	}
	public BinaryTree getLeft() {
		return left;					//left¸¦ ¹İÈ¯ÇÑ´Ù
	}
	public void setLeft(BinaryTree left) {
		this.left = left;				//left¸¦ ¼³Á¤ÇÑ´Ù
	}
	public BinaryTree getRight() {
		return right;					//right¸¦ ¹İÈ¯ÇÑ´Ù
	}
	public void setRight(BinaryTree right) {
		this.right = right;				//right¸¦ ¼³Á¤ÇÑ´Ù
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
		if(key.compareTo(data)<0) {			//¸¸¾à data°¡ valueº¸´Ù Å©°í
			if(this.right != null) {		//right°¡ nullÀÌ ¾Æ´Ï¸é
				right.insertKey(data);		//right¿¡ ´ëÇØ Àç±ÍÈ£ÃâÇÑ´Ù
			}else if(this.right == null) {	//¸¸¾à right°¡ nullÀÌ¸é
			BinaryTree newTree = new BinaryTree(data);	//data¸¦ value·Î ÇÏ´Â BinaryTree°´Ã¼¸¦ »ı¼ºÇÏ¿©
			this.setRight(newTree);			//ÇöÀç °´Ã¼ÀÇ right·Î ÁöÁ¤ÇÑ´Ù
			}
		}
		else {								//¸¸¾à data°¡ valueº¸´Ù ÀÛ°Å³ª °°°í
			if(this.left != null) {			//left°¡ nullÀÌ ¾Æ´Ï¸é
				left.insertKey(data);		//left¿¡ ´ëÇØ Àç±ÍÈ£­ŒÇÑ´Ù
			}else if(this.left == null) {	//¸¸¾à left°¡ nullÀÌ¸é
			BinaryTree newTree = new BinaryTree(data);	//data¸¦ value·Î ÇÏ´Â BinaryTree °´Ã¼¸¦ »ı¼ºÇÏ¿©
			this.setLeft(newTree);			//ÇöÀç °´Ã¼ÀÇ left·Î ÁöÁ¤ÇÑ´Ù
			}
		}
	}
	
	public boolean deleteKey(BinaryTree root, Object data) {
		Comparable key = (Comparable) root.value;			//ÇöÀç rootÀÇ value¸¦ ComparableÅ¸ÀÔÀÇ key·Î ÁöÁ¤ÇÑ´Ù
		if(key.compareTo(data)<0) {								//¸¸¾à keyº¸´Ù data°¡ ´õ Å©°í
			if(this.right != null) {							//¸¸¾à right°¡ nullÀÌ ¾Æ´Ñµ¥
				if(right.deleteKey(right,data)) {					//right¿¡ ´ëÇØ Àç±ÍÈ£ÃâÀ» ÇÑ °ªÀÌ ÂüÀÌ¶ó¸é
					if(right.right !=null && right.left !=null) {		//rightÀÇ ÀÚ½ÄÀÌ µÑ ´Ù ÀÖÀ»¶§
						BinaryTree tmp = getRightMin(right);			//rightÀÇ ¿À¸¥ÂÊ ÀÚ½ÄÁß °¡Àå ÀÛÀº ÀÚ½ÄÀ» tmp¿¡ ÀúÀå
						tmp.setLeft(this.right.left);					//tmpÀÇ left¸¦ ¿ø·¡ rightÀÇ left·Î ÀúÀå
						tmp.setRight(this.right.right);					//tmpÀÇ right¸¦ ¿ø·¡ rightÀÇ right·Î ÀúÀå
						this.setRight(tmp);								//tmp¸¦ ÇöÀç °´Ã¼ÀÇ right·Î ÀúÀå
					}
					else if(right.right !=null || right.left !=null) {//ÀÚ½ÄÀÌ µÑ Áß ÇÏ³ª¸¸ ÀÖÀ¸¸é
						if(right.right == null) {						//rightÀÇ right°¡ nullÀÌ¸é 
							this.setRight(right.left);					//ÇöÀç °´Ã¼ÀÇ right¸¦ rightÀÇ left·Î ÀúÀå
						}
						else this.setRight(right.right);				//¸¸¾à rightÀÇ left°¡ nullÀÌ¸é ÇöÀç °´Ã¼ÀÇ right¸¦ rightÀÇ right·Î ÀúÀå
					}
					else this.setRight(null);							//ÀÚ½ÄÀÌ µÑ ´Ù ¾ø´Ù¸é right¸¦ null·Î ÀúÀå
				}
			}else if(this.right == null) {						//¸¸¾à right°¡ nullÀÌ¸é
				return false;									//false°ª ¹İÈ¯
			}
		}
		else if(key.compareTo(data)>0) {						//¸¸¾à keyº¸´Ù data°¡ ÀÛ°í
			if(this.left != null) {								//¸¸¾à left°¡ nullÀÌ ¾Æ´Ñµ¥
				if(left.deleteKey(left,data)) {						//left¿¡ ´ëÇØ Àç±ÍÈ£ÃâÇÑ °ªÀÌ ÂüÀÌ¶ó¸é
					if(left.right !=null && left.left !=null) {			//leftÀÇ ÀÚ½ÄÀÌ µÑ ´Ù ÀÖÀ»
						BinaryTree tmp = getRightMin(left);				//leftÀÇ ¿À¸¥ÂÊ ÀÚ½ÄÁß °¡Àå ÀÛÀº ÀÚ½ÄÀ» tmp¿¡ ÀúÀå
						tmp.setLeft(this.left.left);					//tmpÀÇ left¸¦ ¿ø·¡ leftÀÇ left·Î ÀúÀå
						tmp.setRight(this.left.right);					//tmpÀÇ left¸¦ ¿ø·¡ leftÀÇ right·Î ÀúÀå
						this.setLeft(tmp);								//ÇöÀç °´Ã¼ÀÇ left¸¦ tmp·Î ÀúÀå
					}
					else if(left.right !=null || left.left !=null) {//leftÀÇ ÀÚ½ÄÀÌ ÇÏ³ª¸¸ ÀÖ´Ù¸é
						if(left.right == null) {						//leftÀÇ right°¡ nullÀÌ¸é
							this.setLeft(left.left);					//left¸¦ leftÀÇ left·Î ÀúÀå
						}												//leftÀÇ left°¡ nullÀÌ¸é
						else this.setLeft(left.right);					//left¸¦ leftÀÇ right·Î ÀúÀå
					}													//ÀÚ½ÄÀÌ ÇÏ³ªµµ ¾øÀ¸¸é
					else this.setLeft(null);							//left¸¦ null·Î ÀúÀåÇÑ´Ù
				}
			}else if(this.left == null) {						//¸¸¾à left°¡ nullÀÌ¸é
				return false;									//false ¹İÈ¯
			}
		}
		else {													//¸¸¾à key¿Í data°¡ °°À¸¸é	
			return true;										//true ¹İÈ¯
		}
		return false;											//ÀüºÎ ¾Æ´Ï¶ó¸é Àß¸øµÈ °ªÀÌ¹Ç·Î false ¹İÈ¯
	}
	
	public BinaryTree getRightMin(BinaryTree deleteObj) {
		BinaryTree prev = deleteObj;			//BinaryTree °´Ã¼ prev¸¦ »ı¼ºÇÏ¿© »èÁ¦ÇÒ °ª ÀúÀå
		BinaryTree tmp = deleteObj.right;		//BinaryTree °´Ã¼ tmp¸¦ »ı¼ºÇÏ¿© »èÁ¦ÇÒ °ªÀÇ right ÀúÀå
		while(tmp.left!=null) {					//tmpÀÇ left°¡ nullÀÌ ¾Æ´Ò¶§±îÁö
			prev = tmp;							//prev¿¡ tmp ÀúÀå
			tmp = tmp.left;						//tmp¿¡ tmpÀÇ left ÀúÀå
		}
			prev.setLeft(tmp.right);			//prevÀÇ left¸¦ tmpÀÇ right·Î ÀúÀå
			tmp.setRight(null);					//tmpÀÇ right´Â null·Î »èÁ¦
		return tmp;								//tmp ¹İÈ¯
	}
}
