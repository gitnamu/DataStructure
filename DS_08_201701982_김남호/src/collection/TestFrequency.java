package collection;
import java.util.*;

public class TestFrequency {
	public void run() {
		String[] countries = {"KO","DE","ES","FR","DE","ES","DE"};
		List list = Arrays.asList(countries);
		
		for(int i=0;i<countries.length;i++) {		//countries�� ���̸�ŭ �ݺ��Ѵ�
			if(countries[i]==null) {				//���� i��° ���Ұ� null�̸�
				continue;							//���� �ݺ����� �Ѿ��
			}else {									// countries�� i��° ���Ұ� null�� �ƴϸ�
				System.out.printf("frequency(list, \"%s\"): %d\n", countries[i], frequency(list,countries[i]));	//frequency(list,countries[i])�� ȣ���Ͽ� ����Ѵ�
				for(int j=i+1;j<countries.length;j++) {			//j=i+1 ���� countries�� ���̸�ŭ �ݺ��Ѵ�
					if(countries[j] ==null)						//countries[j]�� null�̸�
						continue;								//���� �ݺ����� �Ѿ��
					if(countries[i].compareTo(countries[j])==0)	//���� countries[i]�� countries[j]�� ������
						countries[j] = null;					// countries[j]�� null�� �����Ѵ�
				}
			}
		}
	}
	
	public int frequency(List list, Object object) {
		int count = 0;									//�󵵼��� ī�����ϴ� ������ �����Ѵ�
		Iterator itr = list.iterator();					//list�� Iterator�� itr�� �����Ѵ�
		while(itr.hasNext()) {							//itr�� next�� �����ϴ� ���� �ݺ��Ѵ�
			String currentString = (String)itr.next();	//String ������ currentString�� itr�� next�� String ������ ��ȯ�ؼ� �����Ѵ�
			if(currentString == null)						//���� currentString�� null�̸�
				continue;									//���� �ݺ����� �Ѿ��
			if(currentString.compareTo((String)object)==0) {//���� currentString�� �Է¹��� object�� String ����ȯ �� ���� ������
				count++;									//count+1�Ѵ�
			}
		}
		return count;									//while�� ����� count�� ��ȯ�Ѵ�
	}
}
