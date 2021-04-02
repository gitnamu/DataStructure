
public class Main {
	public static void main(String[] args) {
		int a[] = {66, 33, 99, 55, 88, 22, 44, 77};
		int insert[] = new int[50000];
		int quick[] = new int[50000];
		int bubble[] = new int[50000];
		int heap[] = new int[50000];		
/*
		int insert[] = new int[8];
		int quick[] = new int[8];
		int bubble[] = new int[8];
		int heap[] = new int[8];
*/
		int arr[] = new int[50000];
		for(int i=0;i<50000;i++) {
			arr[i] = (int)(Math.random()*50000)+1;
		}
		
		InsertionSort insertSort = new InsertionSort();
		QuickSort quickSort = new QuickSort();
		BubbleSort bubbleSort = new BubbleSort();
		HeapSort heapSort = new HeapSort();
		
		copyArray(arr, insert);
		copyArray(arr, quick);
		copyArray(arr, bubble);
		copyArray(arr, heap);
		
		long st = System.currentTimeMillis();
		insertSort.sort(insert, insert.length);
		long et = System.currentTimeMillis();
		
		System.out.printf("insert Sort	: ");
		System.out.println((et-st)+" ms");
		//printArray(insert);
		
		st = System.currentTimeMillis();
		quickSort.sort(quick, quick.length);
		et = System.currentTimeMillis();
		System.out.printf("quick Sort	: ");
		System.out.println((et-st)+" ms");
		//printArray(quick);
		
		st = System.currentTimeMillis();
		bubbleSort.sort(bubble, bubble.length);
		et = System.currentTimeMillis();
		System.out.printf("bubble Sort	: ");
		System.out.println((et-st)+" ms");
		//printArray(bubble);
		
		st = System.currentTimeMillis();
		heapSort.sort(heap, heap.length);
		et = System.currentTimeMillis();
		System.out.printf("heap Sort	: ");
		System.out.println((et-st)+" ms");
		//printArray(heap);
/*
		System.out.print(">> 기존배열	: ");
		printArray(a);
		
		insertSort.sort(insert, insert.length);
		System.out.print("insert Sort	: ");
		printArray(insert);
		
		quickSort.sort(quick, quick.length);
		System.out.print("quick Sort	: ");
		printArray(quick);
		
		bubbleSort.sort(bubble, bubble.length);
		System.out.print("bubble Sort	: ");
		printArray(bubble);
		
		heapSort.sort(heap,heap.length);
		System.out.print("heap Sort	: ");
		printArray(heap);
*/
	}
	
	public static void printArray(int a[]) {
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	
	public static void copyArray(int a[], int b[]) {
		for(int i=0;i<a.length;i++)
			b[i] = a[i];
	}
}
