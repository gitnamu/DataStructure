import java.util.Scanner;

public class TestHashTable {
	public static void main(String[] args) {
		TestHashTable ht = new TestHashTable();	//TestHashTable 객체 ht 생성
		ht.run();								//ht 객체의 run 함수 호출
	}
	
	public void run() {
		Scanner input = new Scanner(System.in);		//Scanner 객체 생성
		HashTable table = new HashTable(101,0.75F);	//HashTable 객체 table 생성 및 용량 101, 적재율 0.75로 설정
		
		while(true) {
			System.out.print("1.  [Hash] put\n2.  [Hash] get\n3.  종료\n");	//입력 번호별 기능 문구 출력
			int num = input.nextInt();										//입력받은 숫자를 num에 저장
			
			if(num<1 || num>3) throw new IllegalArgumentException();	//만약 num이 1보다 작거나 3보다 크면 에러 객체 생성
			if(num == 1) {									//num이 1이면
				System.out.println("key를 입력하세요 : ");		//key입력문구 출력
				String key = input.next();					//문장 입력받아서  key에 저장
				System.out.println("국가를 입력하세요 : ");		//국가 입력문구 출력
				String name = input.next();					//문장 입력받아 name에 저장
				System.out.println("언어를 입력하세요 : ");		//언어 입력문구 출력
				String language = input.next();				//문장 입력받아 language에 저장
				
				Country country = new Country(name,language);	//name, language를 매개변수로 하는 Country 객체 country 생성
				table.put(key, country);					//HashTable 객체 table의 put()을 호출하여  입력받은 key를 key로, country를 value로 하는 레코드 삽입 
			}
			else if(num == 2) {								//num이 2이면
				System.out.println("key를 입력하세요 : ");		//key입력 문구 출력
				String key = input.next();					//문장을 입력받아 key에 저장
				System.out.println(table.get(key));			//get 메소드를 호출하여 해당 키 값을 가진 레코드 출력
			}
			else if(num == 3) {								//num이 3이면
				break;										//반복문 종료
			}
		}
	}
}
