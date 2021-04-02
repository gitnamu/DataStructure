
public class QuickSort {
	public void sort(int[] data, int size) {
		quickSortRecursively(data,0,size-1);	//data[] ��ü�迭�� ���� quickSortRecursively�� ȣ���Ѵ� 
	}
	private void quickSortRecursively(int[] data, int left, int right) {
		if(left<right) {										//left�� right���� ������
			int pivot = left;									//left�� pivot���� �����Ѵ�.
			int firstRight = right;								//ó�� right���� ���� firstRight�� �����Ѵ�
			while(left<=right) {								//left�� right���� �۰ų� ������ �Ʒ��� �ݺ��Ѵ�
				while(data[left]<=data[pivot] && left<right)	//pivot������ ū data[left]�� �߰��Ҷ�����
					++left;										//++left�Ѵ�
				while(data[right]>data[pivot] && left<=right)	//pivot������ ���� data[right]�� �߰��Ҷ�����
					--right;									//--right�Ѵ�
				if(left<right) 									//���� left<right�̸�
					swap(data,left,right);						//data[left]�� data[right]�� �ٲ۴�
				else break;										//�ƴϸ� while���� �����Ѵ�
			}
				swap(data,right,pivot);							//while���� ����Ǹ� data[right]�� data[pivot]�� �ٲ۴� 

			quickSortRecursively(data,pivot,right-1);			//(ó�� left, right-1)�� ���� ���ȣ��
			quickSortRecursively(data,right+1,firstRight);		//(right+1, firstRight)�� ���� ���ȣ��
		}
	}
	private void swap(int[] data, int i, int j) {
		int tmp = data[i];			//int�� ���� tmp�� data[i] ����
		data[i] = data[j];			//data[i]�� data[j]�� ����
		data[j] = tmp;				//data[j]�� tmp�� ����
	}
}
