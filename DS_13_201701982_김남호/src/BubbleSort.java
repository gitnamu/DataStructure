
public class BubbleSort {
	void sort(int[] data, int size) {
		for(int i=size-1;i>0;i--) {				//원소가 하나씩 위치를 정해가므로 size-1부터 -1씩 해나감
			for(int j=1;j<=i;j++) {				//두번째 원소부터 i번째 원소까지 반복
				if(data[j] < data[j-1]) {		//이전 원소값이 현재 원소값보다 크면
					int tmp = data[j];			//int형 변수 tmp에 현재 값 저장
					data[j] = data[j-1];		//이전 원소 자리에 현재 원소 저장
					data[j-1] = tmp;			//현재 원소 자리에 이전 원소 저장
				}
			}
		}
	}
}
