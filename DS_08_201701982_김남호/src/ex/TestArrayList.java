package ex;
import java.util.*;

public class TestArrayList {
	public void run() {
		//�ǽ� 1
		String[] strings = {"CA", "US", "MX", "AR", "BR", "CH"};	//�迭 ����
		println(strings);											// println(strings) ȣ��
		
		ArrayList list1 = new ArrayList(Arrays.asList(strings));	//strings�� ����Ʈ�� �ٲپ ArrayList Ÿ���� list1�� ����   
		System.out.println("list1 :     "+list1);					//list1 ���
		
		list1.add("VE");											//list1�� "VE" �߰�
		System.out.println("list1 :     "+list1);					//list1 ���
		
		ArrayList list2 = new ArrayList(Arrays.asList(new String[] {"MX", "HN", "GT"}));	//�迭�� �ش� ���Ҹ� ����Ʈ�� �ϴ� Arraylist�� list2 ����
		System.out.println("list2 :     "+list2);					//list2 ���
		
		list1.addAll(list2);										//list1�� list2�� ��� ���� �߰�
		System.out.println("list1 + list2 : " + list1);				//list1 ���
		
		list1.remove("MX");											//list1���� "MX" ����
		System.out.println("list1 remove MX: "+ list1);				//list1 ���
		
		System.out.println("list1.containsAll(list2) ="+ list1.containsAll(list2));	//list1�� list2�� ��� ���Ҹ� �����ϴ��� boolean���� ���
		
		list1.remove("HN");											//list1���� "HN" ����
		System.out.println("list1 :     "+list1);					//list1 ���
		
		System.out.println("list1.containsAll(list2) ="+ list1.containsAll(list2));	//list1�� list2�� ��� ���Ҹ� �����ϴ��� boolean���� ���
		
		list1.remove(list2);										//list1���� list2�� ��� ���� ����
		System.out.println("list1 :     "+list1);					//list1 ���
		
		ArrayList list3 = new ArrayList(Arrays.asList(new String[] {"BR", "US", "PE"}));	//�迭�� �ش� ���Ҹ� ����Ʈ�� �ϴ� Arraylist�� list3 ����
		System.out.println("list3 :     "+list3);					//list3 ���
		
		list1.retainAll(list3);										//list1 �׸��� list3�� ���ԵǴ� ����鸸���� list1 �籸��
		System.out.println("list1 :     "+list1);					//list1 ���
		
		list1.toArray(strings);										//ArrayList�� ��Ҹ� ������ ��Ҹ� ������ ��� ������ �� �迭�� ����
																	//list1�� ����ִ� US,BR,NULL ���� strings �迭�� ������� ����
		println(strings);											//println(strings) ȣ��
		
		// �ǽ�2
		ArrayList listIterator = new ArrayList(Arrays.asList(new String[] {"BR", "US", "PE", "KR", "JP", "CN"}));	//�迭�� �ش� ���ҵ��� �׸����� �ϴ� ArrayList�� listIterator ���� 
		Iterator itr = listIterator.iterator();						//listIterator�� iterator�� itr ����
		
		System.out.println("�ݺ��ڸ� �̿��� 1�� ��� �� JP ����");				
		while(itr.hasNext()) {										//itr�� next�� �����ϴµ��� �ݺ�
			String currentString = (String)itr.next();				//itr�� next�� String���� ����ȯ�Ͽ�  currentString�� ����
			System.out.printf(currentString+" ");					//currentString ���
			
			if(currentString.compareTo("JP")==0) {					//���� currentString�� "JP"�� ���ٸ�
				itr.remove();										//�����Ѵ�
			}
		}
		
		System.out.println("\nJP ���� �� �ݺ��ڸ� �̿��� 2�� ���");
		System.out.println("listIterator :     "+listIterator);		//listIterator ���
		itr = listIterator.iterator();								//listIterator�� iterator�� itr ����
		while(itr.hasNext()) {										//itr�� next�� �����ϴ� ����
			System.out.print(itr.next()+" ");						//itr��  next�� ���
		}
	}
	
	public void println(String[] a) {
		System.out.printf("{" + a[0]);								//ó���� {�� a[0] ���
		for(int i=1;i<a.length;i++)									//a�� ���̸�ŭ �ݺ��Ͽ�
			System.out.print("," + a[i]);							//, a[i] ���
		System.out.println("}");									//���������� } ���
	}
}
