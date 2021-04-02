package collection;
import java.util.*;

public class TestFrequency {
	public void run() {
		String[] countries = {"KO","DE","ES","FR","DE","ES","DE"};
		List list = Arrays.asList(countries);
		
		for(int i=0;i<countries.length;i++) {		//countries의 길이만큼 반복한다
			if(countries[i]==null) {				//만약 i번째 원소가 null이면
				continue;							//다음 반복으로 넘어간다
			}else {									// countries의 i번째 원소가 null이 아니면
				System.out.printf("frequency(list, \"%s\"): %d\n", countries[i], frequency(list,countries[i]));	//frequency(list,countries[i])를 호출하여 출력한다
				for(int j=i+1;j<countries.length;j++) {			//j=i+1 부터 countries의 길이만큼 반복한다
					if(countries[j] ==null)						//countries[j]가 null이면
						continue;								//다음 반복으로 넘어간다
					if(countries[i].compareTo(countries[j])==0)	//만약 countries[i]와 countries[j]가 같으면
						countries[j] = null;					// countries[j]에 null을 저장한다
				}
			}
		}
	}
	
	public int frequency(List list, Object object) {
		int count = 0;									//빈도수를 카운팅하는 변수를 생성한다
		Iterator itr = list.iterator();					//list의 Iterator인 itr을 생성한다
		while(itr.hasNext()) {							//itr의 next가 존재하는 동안 반복한다
			String currentString = (String)itr.next();	//String 형태의 currentString에 itr의 next를 String 형으로 변환해서 저장한다
			if(currentString == null)						//만약 currentString이 null이면
				continue;									//다음 반복으로 넘어간다
			if(currentString.compareTo((String)object)==0) {//만약 currentString과 입력받은 object를 String 형변환 한 것이 같으면
				count++;									//count+1한다
			}
		}
		return count;									//while문 종료시 count를 반환한다
	}
}
