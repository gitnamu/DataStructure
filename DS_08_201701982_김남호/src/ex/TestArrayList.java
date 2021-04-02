package ex;
import java.util.*;

public class TestArrayList {
	public void run() {
		//실습 1
		String[] strings = {"CA", "US", "MX", "AR", "BR", "CH"};	//배열 선언
		println(strings);											// println(strings) 호출
		
		ArrayList list1 = new ArrayList(Arrays.asList(strings));	//strings를 리스트로 바꾸어서 ArrayList 타입의 list1에 저장   
		System.out.println("list1 :     "+list1);					//list1 출력
		
		list1.add("VE");											//list1에 "VE" 추가
		System.out.println("list1 :     "+list1);					//list1 출력
		
		ArrayList list2 = new ArrayList(Arrays.asList(new String[] {"MX", "HN", "GT"}));	//배열의 해당 원소를 리스트로 하는 Arraylist인 list2 생성
		System.out.println("list2 :     "+list2);					//list2 출력
		
		list1.addAll(list2);										//list1에 list2의 모든 원소 추가
		System.out.println("list1 + list2 : " + list1);				//list1 출력
		
		list1.remove("MX");											//list1에서 "MX" 제거
		System.out.println("list1 remove MX: "+ list1);				//list1 출력
		
		System.out.println("list1.containsAll(list2) ="+ list1.containsAll(list2));	//list1이 list2의 모든 원소를 포함하는지 boolean으로 출력
		
		list1.remove("HN");											//list1에서 "HN" 제거
		System.out.println("list1 :     "+list1);					//list1 출력
		
		System.out.println("list1.containsAll(list2) ="+ list1.containsAll(list2));	//list1이 list2의 모든 원소를 포함하는지 boolean으로 출력
		
		list1.remove(list2);										//list1에서 list2의 모든 원소 제거
		System.out.println("list1 :     "+list1);					//list1 출력
		
		ArrayList list3 = new ArrayList(Arrays.asList(new String[] {"BR", "US", "PE"}));	//배열의 해당 원소를 리스트로 하는 Arraylist인 list3 생성
		System.out.println("list3 :     "+list3);					//list3 출력
		
		list1.retainAll(list3);										//list1 항목중 list3에 포함되는 내용들만으로 list1 재구성
		System.out.println("list1 :     "+list1);					//list1 출력
		
		list1.toArray(strings);										//ArrayList의 요소를 지정된 요소를 지정된 요소 형식의 새 배열에 복사
																	//list1에 들어있는 US,BR,NULL 값이 strings 배열에 순서대로 저장
		println(strings);											//println(strings) 호출
		
		// 실습2
		ArrayList listIterator = new ArrayList(Arrays.asList(new String[] {"BR", "US", "PE", "KR", "JP", "CN"}));	//배열의 해당 원소들을 항목으로 하는 ArrayList인 listIterator 생성 
		Iterator itr = listIterator.iterator();						//listIterator의 iterator인 itr 생성
		
		System.out.println("반복자를 이용한 1차 출력 및 JP 삭제");				
		while(itr.hasNext()) {										//itr의 next가 존재하는동안 반복
			String currentString = (String)itr.next();				//itr의 next를 String으로 형변환하여  currentString에 저장
			System.out.printf(currentString+" ");					//currentString 출력
			
			if(currentString.compareTo("JP")==0) {					//만약 currentString이 "JP"와 같다면
				itr.remove();										//제거한다
			}
		}
		
		System.out.println("\nJP 삭제 후 반복자를 이용한 2차 출력");
		System.out.println("listIterator :     "+listIterator);		//listIterator 출력
		itr = listIterator.iterator();								//listIterator의 iterator로 itr 지정
		while(itr.hasNext()) {										//itr의 next가 존재하는 동안
			System.out.print(itr.next()+" ");						//itr의  next를 출력
		}
	}
	
	public void println(String[] a) {
		System.out.printf("{" + a[0]);								//처음에 {와 a[0] 출력
		for(int i=1;i<a.length;i++)									//a의 길이만큼 반복하여
			System.out.print("," + a[i]);							//, a[i] 출력
		System.out.println("}");									//마지막으로 } 출력
	}
}
