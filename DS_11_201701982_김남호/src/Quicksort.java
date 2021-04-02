
public class Quicksort {
	private int [] array;
	private int size;
	private int maxSize;
	
	public Quicksort(int size) {
		maxSize = size;				//�Է¹��� ���� �ִ밪���� �����Ѵ�
		array = new int[maxSize];	//�ִ밪 ũ���� �迭�� �����Ѵ�
		this.size = 0;				//size�� 0���� �ʱ�ȭ�Ѵ�
	}
	
	public void quickSortRecursively(int left, int right) {
		if(left<right) {							//���������� �����Ѵٸ� �����Ѵ�
			int mid = partition(left, right);		//partition �޼ҵ�� mid�� ã�´�
			quickSortRecursively(left, mid-1);		//��ġ�� ������ mid ���� ������ ���ȣ���Ͽ� sorting�Ѵ�
			quickSortRecursively(mid+1, right);		//��ġ�� ������ mid ������ ������ ���ȣ���Ͽ� sorting�Ѵ�
		}
	}
	
	public void swap(int a, int b) {
		int tmp = array[a];		//array�� a�ε��� ���� tmp�� �����Ѵ�
		array[a] = array[b];	//array�� a�ε����� array�� b�ε��� ���� �����Ѵ� 
		array[b] = tmp;			//array�� b�ε����� tmp�� �����Ѵ�
	}
	
	public boolean add(int data) {
		if(size == maxSize) return false;	//���� size�� �迭�� ũ�⿡ �����ϸ� false ��ȯ
		array[size++] = data;				// array[size]�� data ���� �߰��ϰ� size+1�Ѵ�.
		return true;						//true�� ��ȯ�Ѵ�
	}
	
	public void print() {
		System.out.print(array[0]);			//array�� ù��° ���Ҹ� ����Ѵ�
		for(int i=1;i<size;i++) {			//array�� �ι�° ���Һ��� ������ ���ұ���
			System.out.print(" "+array[i]);	//����� �ش� ���Ҹ� ����Ѵ�
		}
		System.out.println();				//����� ������ �ٹٲ��� �Ѵ�
	}
	
	public int size() {
		return size;		//size�� ��ȯ
	}
	
	public void sorting() {
		this.quickSortRecursively(0, size-1);
	}
	
	public int partition(int left, int right) {
		int pivot = array[left];			//pivot�� array[left]�� ���� ����
		int primaryLeft = left;				//������ left���� primaryLeft�� ����
		
		while(left<=right) {							//right<left�϶� ����
			while(array[left]<=pivot && left<right)		//left<right�� �����ϸ鼭, pivot>array[left]�϶�����
				++left;									//left+1
			while(array[right]>pivot && left<=right) 	//left<=right�� �����ϸ鼭, array[right]<pivot�� ������
				--right;								//right-1
			if(left<right)								//���� left<right�̸�
				swap(left,right);						//array[left]�� array[right] �� �ٲ㼭 ����
			else break;									//left>=right�̸� �ݺ��� ����
		}
		array[primaryLeft] = array[right];				//pivot ��ġ�� array[]��  array[right] ���� 
		array[right] = pivot;							//array[right]�� pivot ����
		
		return right;									//right�� ��ȯ
	}
}
