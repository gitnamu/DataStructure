
public class BubbleSort {
	void sort(int[] data, int size) {
		for(int i=size-1;i>0;i--) {				//���Ұ� �ϳ��� ��ġ�� ���ذ��Ƿ� size-1���� -1�� �س���
			for(int j=1;j<=i;j++) {				//�ι�° ���Һ��� i��° ���ұ��� �ݺ�
				if(data[j] < data[j-1]) {		//���� ���Ұ��� ���� ���Ұ����� ũ��
					int tmp = data[j];			//int�� ���� tmp�� ���� �� ����
					data[j] = data[j-1];		//���� ���� �ڸ��� ���� ���� ����
					data[j-1] = tmp;			//���� ���� �ڸ��� ���� ���� ����
				}
			}
		}
	}
}
