
public class HeapSort {
	int[] newData;
	
	public void sort(int[] a, int size) {
		
		this.newData = new int[size+1];
		this.newData[0] = 0;
		for(int i=0;i<size;i++) {
			this.newData[i+1] = a[i];
		}
		
		int i;
		
		for(int j=size;j>0;j--) {
			for(i=size/2;i>0;i--)
				adjust(this.newData,i,j);
			swap(1,j);
		}
		for(int j=0;j<size;j++)
			a[j] = this.newData[j+1];
	}
	
	public void adjust(int[] newData, int root, int n) {
		int child,rootkey;
		int temp = newData[root];
		rootkey = newData[root];
		child = 2*root;
		
		while(child <= n) {
			if(child+1 <= n && newData[child] < newData[child+1])	//������ child�� �����ϰ�, ���� child���� ������ child�� �� ũ��
				child++;											//child�� ���������� ����
			if(rootkey>newData[child])								//root�� ���� child���� ū ���̸�
				break;												//�ٲ� ���� �����Ƿ� while�� ����
			newData[root] = newData[child];							//root ��ġ�� newData[child] ���� 
			child *=2;												//child�� child*2 ����
			root *=2; 												//root�� root*2 ����
		}
		newData[child/2] = temp;									//while���� ����Ǹ�child/2�� ���Ҹ� ó�� root�� ���Ұ�(temp)���� ����
	}
	
	private void swap(int i, int j) {
		int tmp = newData[j];			//tmp�� newData[j] ����
		newData[j] = newData[i];		//newData[j]�� newData[i] ����
		newData[i] = tmp;				//newData[i]�� tmp ����
	}
}
