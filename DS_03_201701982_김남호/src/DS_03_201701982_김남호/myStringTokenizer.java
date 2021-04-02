package DS_03_201701982_±è³²È£;

public class myStringTokenizer {
	private String[] words;
	private String line = "";
	private String token = "";
	private int index;
	
	public myStringTokenizer(String line, String token) {
		this.line = line;
		this.token = token;
		this.words = makeWords(line, token);
		this.index = 0;
	}
	
	public boolean hasMoreTokens() {
		if(index<words.length) {
			index++;
			return true;
		}
		else return false;
	}
	
	public String nextToken() {
		return words[index-1];
	}
	
	public void print() {
		for(int i=0;i<words.length;i++) {
			System.out.printf("split string:%15s  split string ±æÀÌ:%3s\n", words[i], words[i].length());
		}
	}
	
	public String[] makeWords(String line, String token) {
		String[] tmp = null;
		int split_index = 0;
		int split_length = 1;
		int begin_index = 0;
		int last_index = 0;
		
		for(int i=0;i<line.length();i++) {
			if(line.charAt(i) == ' ') {
				split_length++;
			}
		}
		
		tmp = new String[split_length];
		
		for(int i=0;i<line.length();i++) {
			if(split_length == (split_index + 1)) {
				tmp[split_index] = line.substring(i);
				break;
			}else if (line.charAt(i)==' ') {
				last_index = i;
				tmp[split_index] = line.substring(begin_index,last_index);
				split_index++;
				begin_index = last_index+1;
			}
		}
		return tmp;
	}
}
