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
		return value;					//value를 반환한다
	}
	public void setValue(Object data) {
		value = data;					//value를 설정한다
	}
	public BinaryTree getLeft() {
		return left;					//left를 반환한다
	}
	public void setLeft(BinaryTree left) {
		this.left = left;				//left를 설정한다
	}
	public BinaryTree getRight() {
		return right;					//right를 반환한다
	}
	public void setRight(BinaryTree right) {
		this.right = right;				//right를 설정한다
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
		if(key.compareTo(data)<0) {			//만약 data가 value보다 크고
			if(this.right != null) {		//right가 null이 아니면
				right.insertKey(data);		//right에 대해 재귀호출한다
			}else if(this.right == null) {	//만약 right가 null이면
			BinaryTree newTree = new BinaryTree(data);	//data를 value로 하는 BinaryTree객체를 생성하여
			this.setRight(newTree);			//현재 객체의 right로 지정한다
			}
		}
		else {								//만약 data가 value보다 작거나 같고
			if(this.left != null) {			//left가 null이 아니면
				left.insertKey(data);		//left에 대해 재귀호춯한다
			}else if(this.left == null) {	//만약 left가 null이면
			BinaryTree newTree = new BinaryTree(data);	//data를 value로 하는 BinaryTree 객체를 생성하여
			this.setLeft(newTree);			//현재 객체의 left로 지정한다
			}
		}
	}
	
	public boolean deleteKey(BinaryTree root, Object data) {
		Comparable key = (Comparable) root.value;			//현재 root의 value를 Comparable타입의 key로 지정한다
		if(key.compareTo(data)<0) {								//만약 key보다 data가 더 크고
			if(this.right != null) {							//만약 right가 null이 아닌데
				if(right.deleteKey(right,data)) {					//right에 대해 재귀호출을 한 값이 참이라면
					if(right.right !=null && right.left !=null) {		//right의 자식이 둘 다 있을때
						BinaryTree tmp = getRightMin(right);			//right의 오른쪽 자식중 가장 작은 자식을 tmp에 저장
						tmp.setLeft(this.right.left);					//tmp의 left를 원래 right의 left로 저장
						tmp.setRight(this.right.right);					//tmp의 right를 원래 right의 right로 저장
						this.setRight(tmp);								//tmp를 현재 객체의 right로 저장
					}
					else if(right.right !=null || right.left !=null) {//자식이 둘 중 하나만 있으면
						if(right.right == null) {						//right의 right가 null이면 
							this.setRight(right.left);					//현재 객체의 right를 right의 left로 저장
						}
						else this.setRight(right.right);				//만약 right의 left가 null이면 현재 객체의 right를 right의 right로 저장
					}
					else this.setRight(null);							//자식이 둘 다 없다면 right를 null로 저장
				}
			}else if(this.right == null) {						//만약 right가 null이면
				return false;									//false값 반환
			}
		}
		else if(key.compareTo(data)>0) {						//만약 key보다 data가 작고
			if(this.left != null) {								//만약 left가 null이 아닌데
				if(left.deleteKey(left,data)) {						//left에 대해 재귀호출한 값이 참이라면
					if(left.right !=null && left.left !=null) {			//left의 자식이 둘 다 있을
						BinaryTree tmp = getRightMin(left);				//left의 오른쪽 자식중 가장 작은 자식을 tmp에 저장
						tmp.setLeft(this.left.left);					//tmp의 left를 원래 left의 left로 저장
						tmp.setRight(this.left.right);					//tmp의 left를 원래 left의 right로 저장
						this.setLeft(tmp);								//현재 객체의 left를 tmp로 저장
					}
					else if(left.right !=null || left.left !=null) {//left의 자식이 하나만 있다면
						if(left.right == null) {						//left의 right가 null이면
							this.setLeft(left.left);					//left를 left의 left로 저장
						}												//left의 left가 null이면
						else this.setLeft(left.right);					//left를 left의 right로 저장
					}													//자식이 하나도 없으면
					else this.setLeft(null);							//left를 null로 저장한다
				}
			}else if(this.left == null) {						//만약 left가 null이면
				return false;									//false 반환
			}
		}
		else {													//만약 key와 data가 같으면	
			return true;										//true 반환
		}
		return false;											//전부 아니라면 잘못된 값이므로 false 반환
	}
	
	public BinaryTree getRightMin(BinaryTree deleteObj) {
		BinaryTree prev = deleteObj;			//BinaryTree 객체 prev를 생성하여 삭제할 값 저장
		BinaryTree tmp = deleteObj.right;		//BinaryTree 객체 tmp를 생성하여 삭제할 값의 right 저장
		while(tmp.left!=null) {					//tmp의 left가 null이 아닐때까지
			prev = tmp;							//prev에 tmp 저장
			tmp = tmp.left;						//tmp에 tmp의 left 저장
		}
			prev.setLeft(tmp.right);			//prev의 left를 tmp의 right로 저장
			tmp.setRight(null);					//tmp의 right는 null로 삭제
		return tmp;								//tmp 반환
	}
}
