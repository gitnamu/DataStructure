
public class InsertionSort {
	public void sort(int[] data, int size) {
		for(int i=1;i<size;i++) {					//�ι�° ���Һ��� ������ ���ұ��� �ݺ��Ѵ�
			int tmp = data[i], j;					//���� tmp�� �����Ϸ��� �ϴ� �� data[i]�� �����ϰ�, ���� j�� �����Ѵ�
			for(j = i;j>0 && data[j-1]>tmp;j--) {	//���� �� ������ ���ʿ� �ִ� ���� �� ���������� �ݺ��Ѵ�(��, j>0)
				data[j] = data[j-1];				//���ҵ��� �� ĭ�� ���������� �о��
			}
			data[j] = tmp;							//��ġ�� �����Ǹ� �ش� ��ġ�� �����Ϸ��� �ߴ� data[i]���� �����Ѵ�
		}
	}
}
