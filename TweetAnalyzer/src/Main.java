import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String Args[]){
		int positive = 0;
		int negative = 0;
		int judge = 0;
		Set<String> set = new HashSet<String>();
		try{
		    FileInputStream fstream = new FileInputStream("category B.txt");
			DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String line = null;
	    	while ((line = br.readLine()) != null){
	    		if(line.contains("<id>")==true){
	    			if(set.contains(line.substring(4,line.length()))==false){
	    				set.add(line.substring(4,line.length()));
	    				line=br.readLine();
	    				while ((line.contains("<user>")==false)){
	    					System.out.println(line);
		    				if(line.contains(":)")||line.contains(": )")||line.contains(":D")||line.contains(": D")||line.contains(":^)")||line.contains(":^D")||line.contains("(:")||line.contains("( :")){
		    					if(judge==0)judge++;
		    				}
		    				if(line.contains(":(")||line.contains(": (")||line.contains(":'(")||line.contains(":^(")||line.contains(":'^(")){
		    					if(judge==0)judge--;
		    				}
		    				line=br.readLine();
	    				}
	    				if(judge>0)positive++;
	    				if(judge<0)negative++;
	    				judge=0;
	    			}
	    		}
	    	}
	    	System.out.println(positive);
	    	System.out.println(negative);
		    br.close();  
		    in.close();
		    fstream.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());		  
		}
	}
}
