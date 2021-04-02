
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
			if(child+1 <= n && newData[child] < newData[child+1])	//오른쪽 child가 존재하고, 왼쪽 child보다 오른쪽 child가 더 크면
				child++;											//child를 오른쪽으로 설절
			if(rootkey>newData[child])								//root의 값이 child보다 큰 값이면
				break;												//바꿀 것이 없으므로 while문 종료
			newData[root] = newData[child];							//root 위치에 newData[child] 복사 
			child *=2;												//child에 child*2 저장
			root *=2; 												//root에 root*2 저장
		}
		newData[child/2] = temp;									//while문이 종료되면child/2의 원소를 처음 root의 원소값(temp)으로 변경
	}
	
	private void swap(int i, int j) {
		int tmp = newData[j];			//tmp에 newData[j] 저장
		newData[j] = newData[i];		//newData[j]에 newData[i] 저장
		newData[i] = tmp;				//newData[i]에 tmp 저장
	}
}
