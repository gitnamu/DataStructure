import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	//main 메소드
		Josephus js = new Josephus();			//Josephus 타입의 객체 js를 생성한다
		js.run();								//js의 run()을 호출한다
	}
}

class Josephus{
	protected void run(){
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();					//정수를 스캔받아 n에 저장한다
		int k = scan.nextInt();					//정수를 스캔받아 k에 저장한다
		
		String answer = nodeRemove(n,k); 		//nodeRemove(n,k)를 호출하여 받은 반환값을 answer에 저장한다
		System.out.println("<" + answer.substring(0, answer.length()-2) + ">");	// < > 사이에 'answer의 길이-2' 만큼 answer를 출력한다
	}
	
	private String nodeRemove(int n, int k) {
		String removed = "";				//String형의 removed를 생성한다
		Node head = new Node(1);			//Node타입의 head를 생성하여 object에 1을 넣는다
		Node tmpNode = head;				//Node타입의 tmpNode를 생성하여 head를 저장한다
		
		for(int i=2;i<=n;i++) {				//i는 2부터 n보다 작을때까지 반복한다
			Node newNode = new Node(i);		//Node 타입의 newNode를 생성하여 object에 i를 넣는다
			tmpNode.setNext(newNode);		//tmpNode의 next에 newNode를 저장한다
			newNode.setPrev(tmpNode);		//tmpNode의 prev에 tmpNode를 저장한다
			tmpNode = newNode;				//tmpNode에 newNode를 저장한다
		}
		tmpNode.setNext(head);				//for문이 끝나면 마지막 노드의 next에 head를 저장한다
		head.setPrev(tmpNode);				//head의 prev에 마지막 노드를 저장한다
		
		tmpNode = head;						//tmpNode를 head로 초기화 해 준다
		for(int i=0;i<n;i++) {				//n번 반복한다
			for(int j=1;j<k;j++) {			//k-1번 반복하여
				tmpNode = tmpNode.next;		//tmpNode에 tmpNode.next를 저장한다
			}
			removed += tmpNode.object;			//removed에 tmpNode의 object를 더하여 저장한다
			removed += ", ";					//removed에 ,와 공백을 더하여 저장한다
			tmpNode.next.setPrev(tmpNode.prev);	//tmpNode의 다음 노드의 prev를 tmpNode의 전 노드로 저장한다 
			tmpNode.prev.setNext(tmpNode.next);	//tmpNode의 이전 노드의 next를 tmpNode의 다음 노드로 저장한다
			tmpNode = tmpNode.next;				//tmpNode에 tmpNode.next를 저장한다
		}
		return removed;							//removed를 반환한다
	}
	
	private class Node {
		private Object object;			//데이터를 담을 Object형 변수 선언
		private Node prev,next;			// Node타입의 prev, next 선언

		Node(Object object) {			//생성자
			this.object = object;		//입력받은 object를 this.object에 저장
			prev = null;				//prev에 null 저장
			next = null;				//next에 null 저장
		}
		
		public void setPrev(Node prev) {
			this.prev = prev;			//prev 설정
		}
		
		public void setNext(Node next) {
			this.next = next;			//next 설정
		}
	}
}

