package DS_03_201701982_�賲ȣ;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	public void run(String file) {
		int words = 0, chars = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			
			while (line != null) {
				myStringTokenizer parser = new myStringTokenizer(line, " ");
				while (parser.hasMoreTokens()) {
					++words;
					String word = parser.nextToken();
					chars += word.length();
				}
				line = in.readLine();
				parser.print();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("words: "+words);
		System.out.println("characters: "+chars);
	}
}
