
public class Quicksort {
	private int [] array;
	private int size;
	private int maxSize;
	
	public Quicksort(int size) {
		maxSize = size;				//입력받은 값을 최대값으로 설정한다
		array = new int[maxSize];	//최대값 크기의 배열을 생성한다
		this.size = 0;				//size를 0으로 초기화한다
	}
	
	public void quickSortRecursively(int left, int right) {
		if(left<right) {							//종료조건을 만족한다면 종료한다
			int mid = partition(left, right);		//partition 메소드로 mid를 찾는다
			quickSortRecursively(left, mid-1);		//위치기 결정된 mid 왼쪽 값들을 재귀호출하여 sorting한다
			quickSortRecursively(mid+1, right);		//위치가 결정된 mid 오른쪽 값들을 재귀호출하여 sorting한다
		}
	}
	
	public void swap(int a, int b) {
		int tmp = array[a];		//array의 a인덱스 값을 tmp에 저장한다
		array[a] = array[b];	//array의 a인덱스에 array의 b인덱스 값을 저장한다 
		array[b] = tmp;			//array의 b인덱스에 tmp를 저장한다
	}
	
	public boolean add(int data) {
		if(size == maxSize) return false;	//만약 size가 배열의 크기에 도달하면 false 반환
		array[size++] = data;				// array[size]에 data 값을 추가하고 size+1한다.
		return true;						//true를 반환한다
	}
	
	public void print() {
		System.out.print(array[0]);			//array의 첫번째 원소를 출력한다
		for(int i=1;i<size;i++) {			//array의 두번째 원소부터 마지막 원소까지
			System.out.print(" "+array[i]);	//공백과 해당 원소를 출력한다
		}
		System.out.println();				//출력이 끝나면 줄바꿈을 한다
	}
	
	public int size() {
		return size;		//size값 반환
	}
	
	public void sorting() {
		this.quickSortRecursively(0, size-1);
	}
	
	public int partition(int left, int right) {
		int pivot = array[left];			//pivot을 array[left]값 으로 설정
		int primaryLeft = left;				//최초의 left값을 primaryLeft에 저장
		
		while(left<=right) {							//right<left일때 까지
			while(array[left]<=pivot && left<right)		//left<right를 만족하면서, pivot>array[left]일때까지
				++left;									//left+1
			while(array[right]>pivot && left<=right) 	//left<=right를 만족하면서, array[right]<pivot일 때까지
				--right;								//right-1
			if(left<right)								//만약 left<right이면
				swap(left,right);						//array[left]와 array[right] 값 바꿔서 저장
			else break;									//left>=right이면 반복문 종료
		}
		array[primaryLeft] = array[right];				//pivot 위치의 array[]에  array[right] 저장 
		array[right] = pivot;							//array[right]에 pivot 저장
		
		return right;									//right값 반환
	}
}
