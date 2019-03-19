package nwnu.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class test {
	
	public static void main(String[] args) throws IOException {
		String filename = "src\\nwnu\\test\\words";
		FileReader fk = new FileReader(filename);
		BufferedReader br = new BufferedReader(fk);
		
		String s;
		String file = "";
        while((s = br.readLine()) != null) {
            file += s; //读出整篇文章，存入String类的file中。
        }

        StringTokenizer st = new StringTokenizer(file," ,.!?\"'"); //用于切分字符串

        TreeMap hm = new TreeMap<>();
		while(st.hasMoreTokens()) {
            String word = st.nextToken();
            if(hm.get(word) != null) {
                int value = ((Integer)hm.get(word)).intValue();
                value++;
                hm.put(word, new Integer(value));
            } 
            else {
                hm.put(word, new Integer(1));
            }
        }
        
        TreeMap tm = new TreeMap(hm);

        ByValueComparator bvc = new ByValueComparator(tm);
        List<String> ll = new ArrayList<String>(tm.keySet());
        Collections.sort(ll, bvc);
        for(String str:ll){
            System.out.println(str+"——"+tm.get(str));
        }
        
	}
	
	
	
}
