
public class QuickSort {
	public void sort(int[] data, int size) {
		quickSortRecursively(data,0,size-1);	//data[] 전체배열에 대해 quickSortRecursively를 호출한다 
	}
	private void quickSortRecursively(int[] data, int left, int right) {
		if(left<right) {										//left가 right보다 작으면
			int pivot = left;									//left를 pivot으로 지정한다.
			int firstRight = right;								//처음 right값을 변수 firstRight에 저장한다
			while(left<=right) {								//left가 right보다 작거나 같으면 아래를 반복한다
				while(data[left]<=data[pivot] && left<right)	//pivot값보다 큰 data[left]를 발견할때까지
					++left;										//++left한다
				while(data[right]>data[pivot] && left<=right)	//pivot값보다 작은 data[right]를 발견할때까지
					--right;									//--right한다
				if(left<right) 									//만약 left<right이면
					swap(data,left,right);						//data[left]와 data[right]를 바꾼다
				else break;										//아니면 while문을 종료한다
			}
				swap(data,right,pivot);							//while문이 종료되면 data[right]와 data[pivot]을 바꾼다 

			quickSortRecursively(data,pivot,right-1);			//(처음 left, right-1)에 대해 재귀호출
			quickSortRecursively(data,right+1,firstRight);		//(right+1, firstRight)에 대해 재귀호출
		}
	}
	private void swap(int[] data, int i, int j) {
		int tmp = data[i];			//int형 변수 tmp에 data[i] 저장
		data[i] = data[j];			//data[i]에 data[j]값 저장
		data[j] = tmp;				//data[j]에 tmp값 저장
	}
}
