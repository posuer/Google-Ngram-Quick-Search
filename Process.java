import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Preprocess {
	 public static void main(String arg[]) throws Exception{
		List<String> lineList = null;
		String word = "NULL";
		int sum = 0;
		Hashtable<String, Integer> dic = new Hashtable<String, Integer>();
		String filename = "googlebooks-eng-all-1gram-20120701-";
		String filenametemp = null;
		//read Google Ngram file and store in a hash table
		for(int i = (int)'a'; i <= (int)'z'; i++ ){ //a-z file
			filenametemp = filename + (char)i;
			File file = new File(filenametemp);
	        BufferedReader reader = null;
	        reader = new BufferedReader(new FileReader(file));
	        String lineString = null;
	        
	        while ((lineString = reader.readLine()) != null) {
	        	lineList = Arrays.asList(lineString.split("\t"));
	        	
	        	if(lineList.get(0).equals(word)){	
	        		if(lineList.get(1).startsWith("2")){
	        			sum = sum+ Integer.valueOf(lineList.get(2));
	        		}
	        	}
	        	else{
	        		//put to hash table
	        		dic.put(word, sum);
	        		//default
	        		word = lineList.get(0);
	        		sum = 0;
	        	}
	        }
	        reader.close();
	        
		}
        System.out.println(dic.size());
