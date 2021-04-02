
public class InsertionSort {
	public void sort(int[] data, int size) {
		for(int i=1;i<size;i++) {					//두번째 원소부터 마지막 원소까지 반복한다
			int tmp = data[i], j;					//변수 tmp에 삽입하려고 하는 값 data[i]를 저장하고, 변수 j를 선언한다
			for(j = i;j>0 && data[j-1]>tmp;j--) {	//삽입 할 값보다 왼쪽에 있는 값이 더 작을때까지 반복한다(단, j>0)
				data[j] = data[j-1];				//원소들을 한 칸씩 오른쪽으로 밀어낸다
			}
			data[j] = tmp;							//위치가 결정되면 해당 위치에 삽입하려고 했던 data[i]값을 삽입한다
		}
	}
}
