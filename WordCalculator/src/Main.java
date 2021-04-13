import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {

	public static void main(String[] args) throws IOException {
		//ftiaxnw ta Pos kai Neg sets.
		Set<String> PosLex = new HashSet<String>();
		Set<String> NegLex = new HashSet<String>();
		FileInputStream fstream = new FileInputStream("PosLex.txt");
		DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String line = null;
    	while ((line = br.readLine()) != null){
    		PosLex.add(line);
    	}
    	br.close();
    	FileInputStream fstream0 = new FileInputStream("NegLex.txt");
		DataInputStream in0 = new DataInputStream(fstream0);
	    BufferedReader br0 = new BufferedReader(new InputStreamReader(in0));
	    line = null;
    	while ((line = br0.readLine()) != null){
    		NegLex.add(line);
    	}
    	br0.close();
    	
    	
    	//YPOLOGIZW GIA MITSOTAKI
    	int Mtotal1=0;
    	int Mtotal2=0;
    	int PWT=0;
    	int NWT=0;
    	int[] MPW = new int[14];
    	int[] MNW = new int[14];
    	int[] MPT = new int[14];
    	int[] MNT = new int[14];
    	double MPAvg1=0;
    	double MPAvg2=0;
    	double MNAvg1=0;
    	double MNAvg2=0;
    	double MPTA1=0;
    	double MPTA2=0;
    	double MNTA1=0;
    	double MNTA2=0;
    	for(int i=0;i<14;i++){
			FileInputStream fstream1 = new FileInputStream("data\\mitsotakis\\"+Integer.toString(i+1)+".txt");
			DataInputStream in1 = new DataInputStream(fstream1);
		    BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		    line = null;
		    String tweet = null;
	    	while ((line = br1.readLine()) != null){
	    		if(line.contains("<τςεετ>")){
	    			if(i<7)Mtotal1++;
	    			else Mtotal2++;
	    			PWT = 0;
	    			NWT = 0;
	    			tweet="";
	    			line=br1.readLine();
	    			while (line.contains("<τςεετ/>")== false){
	    				tweet=tweet.concat(" "+line);
	    				line=br1.readLine();
	    			}
	    			String[] words = tweet.split(" ");
	    			for (int j = 0; j < words.length; j++) {
	    				if(PosLex.contains(words[j])){
	    					PWT++;
	    				}
	    				if(NegLex.contains(words[j])){
	    					NWT++;
	    				}
	    		    }
	    			MPW[i]=MPW[i]+PWT;
	    			MNW[i]=MNW[i]+NWT;
	    			if(PWT>NWT)MPT[i]++;
	    			if(PWT<NWT)MNT[i]++;	
	    	}
    	}
	    if(i<7){
	    	MPAvg1 = MPAvg1+MPT[i];
	    	MNAvg1 = MNAvg1+MNT[i];
	    }else{
			MPAvg2 = MPAvg2+MPT[i];	
			MNAvg2 = MNAvg2+MNT[i];
		}
	 }
	    MPAvg1 = (double)MPAvg1/7;
	    MPAvg2 = (double)MPAvg2/7;
	    MNAvg1 = (double)MNAvg1/7;
	    MNAvg2 = (double)MNAvg2/7;
	    for(int i=0;i<14;i++){
	    	if(i<7){
	    		MPTA1 = Math.pow(MPTA1 + (MPT[i]-MPAvg1),2);
	    		MNTA1 = Math.pow(MNTA1 + (MNT[i]-MNAvg1),2);
	    	}else{
	    		MPTA2 = Math.pow(MPTA2 + (MPT[i]-MPAvg2),2);
	    		MNTA2 = Math.pow(MNTA2 + (MNT[i]-MNAvg2),2);
	    	}
	    }
	    MPTA1 = Math.sqrt((double)MPTA1/7);
	    MNTA1 = Math.sqrt((double)MNTA1/7);
	    MPTA2 = Math.sqrt((double)MPTA2/7);
	    MNTA2 = Math.sqrt((double)MNTA2/7);
	    //for(int i=0;i<14;i++){
	    	//System.out.println(MPW[i]+" "+MNW[i]+" "+MPT[i]+" "+MNT[i]);
	    //}
	    //System.out.println(Mtotal1+" "+Mtotal2+" "+MPAvg1+" "+MPAvg2+" "+MNAvg1+" "+MNAvg2+" "+MPTA1+" "+MPTA2+" "+MNTA1+" "+MNTA2);
  
    	//YPOLOGIZW GIA TSIPRA
    	int Ttotal1=0;
    	int Ttotal2=0;
    	int[] TPW = new int[14];
    	int[] TNW = new int[14];
    	int[] TPT = new int[14];
    	int[] TNT = new int[14];
    	double TPAvg1=0;
    	double TPAvg2=0;
    	double TNAvg1=0;
    	double TNAvg2=0;
    	double TPTA1=0;
    	double TPTA2=0;
    	double TNTA1=0;
    	double TNTA2=0;
    	for(int i=0;i<14;i++){
			FileInputStream fstream1 = new FileInputStream("data\\tsipras\\"+Integer.toString(i+1)+".txt");
			DataInputStream in1 = new DataInputStream(fstream1);
		    BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		    line = null;
		    String tweet = null;
	    	while ((line = br1.readLine()) != null){
	    		if(line.contains("<τςεετ>")){
	    			if(i<7)Ttotal1++;
	    			else Ttotal2++;
	    			PWT = 0;
	    			NWT = 0;
	    			tweet="";
	    			line=br1.readLine();
	    			while (line.contains("<τςεετ/>")== false){
	    				tweet=tweet.concat(" "+line);
	    				line=br1.readLine();
	    			}
	    			String[] words = tweet.split(" ");
	    			for (int j = 0; j < words.length; j++) {
	    				if(PosLex.contains(words[j])){
	    					PWT++;
	    				}
	    				if(NegLex.contains(words[j])){
	    					NWT++;
	    				}
	    		    }
	    			TPW[i]=TPW[i]+PWT;
	    			TNW[i]=TNW[i]+NWT;
	    			if(PWT>NWT)TPT[i]++;
	    			if(PWT<NWT)TNT[i]++;	
	    	}
    	}
	    if(i<7){
	    	TPAvg1 = TPAvg1+MPT[i];
	    	TNAvg1 = TNAvg1+MNT[i];
	    }else{
			TPAvg2 = TPAvg2+TPT[i];	
			TNAvg2 = TNAvg2+TNT[i];
		}
	 }
	    TPAvg1 = (double)TPAvg1/7;
	    TPAvg2 = (double)TPAvg2/7;
	    TNAvg1 = (double)TNAvg1/7;
	    TNAvg2 = (double)TNAvg2/7;
	    for(int i=0;i<14;i++){
	    	if(i<7){
	    		TPTA1 = Math.pow(TPTA1 + (TPT[i]-TPAvg1),2);
	    		TNTA1 = Math.pow(TNTA1 + (TNT[i]-TNAvg1),2);
	    	}else{
	    		TPTA2 = Math.pow(TPTA2 + (TPT[i]-TPAvg2),2);
	    		TNTA2 = Math.pow(TNTA2 + (TNT[i]-TNAvg2),2);
	    	}
	    }
	    TPTA1 = Math.sqrt((double)TPTA1/7);
	    TNTA1 = Math.sqrt((double)TNTA1/7);
	    TPTA2 = Math.sqrt((double)TPTA2/7);
	    TNTA2 = Math.sqrt((double)TNTA2/7);
	    
    
    	//YPOLOGIZW GIA SYRIZA
    	int Stotal1=0;
    	int Stotal2=0;
    	int[] SPW = new int[14];
    	int[] SNW = new int[14];
    	int[] SPT = new int[14];
    	int[] SNT = new int[14];
    	double SPAvg1=0;
    	double SPAvg2=0;
    	double SNAvg1=0;
    	double SNAvg2=0;
    	double SPTA1=0;
    	double SPTA2=0;
    	double SNTA1=0;
    	double SNTA2=0;
    	for(int i=0;i<14;i++){
			FileInputStream fstream1 = new FileInputStream("data\\syriza\\"+Integer.toString(i+1)+".txt");
			DataInputStream in1 = new DataInputStream(fstream1);
		    BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		    line = null;
		    String tweet = null;
	    	while ((line = br1.readLine()) != null){
	    		if(line.contains("<τςεετ>")){
	    			if(i<7)Stotal1++;
	    			else Stotal2++;
	    			PWT = 0;
	    			NWT = 0;
	    			tweet="";
	    			line=br1.readLine();
	    			while (line.contains("<τςεετ/>")== false){
	    				tweet=tweet.concat(" "+line);
	    				line=br1.readLine();
	    			}
	    			String[] words = tweet.split(" ");
	    			for (int j = 0; j < words.length; j++) {
	    				if(PosLex.contains(words[j])){
	    					PWT++;
	    				}
	    				if(NegLex.contains(words[j])){
	    					NWT++;
	    				}
	    		    }
	    			SPW[i]=SPW[i]+PWT;
	    			SNW[i]=SNW[i]+NWT;
	    			if(PWT>NWT)SPT[i]++;
	    			if(PWT<NWT)SNT[i]++;	
	    	}
    	}
	    if(i<7){
	    	SPAvg1 = SPAvg1+SPT[i];
	    	SNAvg1 = SNAvg1+SNT[i];
	    }else{
			SPAvg2 = SPAvg2+SPT[i];	
			SNAvg2 = SNAvg2+SNT[i];
		}
	 }
	    SPAvg1 = (double)SPAvg1/7;
	    SPAvg2 = (double)SPAvg2/7;
	    SNAvg1 = (double)SNAvg1/7;
	    SNAvg2 = (double)SNAvg2/7;
	    for(int i=0;i<14;i++){
	    	if(i<7){
	    		SPTA1 = Math.pow(SPTA1 + (SPT[i]-SPAvg1),2);
	    		SNTA1 = Math.pow(SNTA1 + (SNT[i]-SNAvg1),2);
	    	}else{
	    		SPTA2 = Math.pow(SPTA2 + (SPT[i]-SPAvg2),2);
	    		SNTA2 = Math.pow(SNTA2 + (SNT[i]-SNAvg2),2);
	    	}
	    }
	    SPTA1 = Math.sqrt((double)SPTA1/7);
	    SNTA1 = Math.sqrt((double)SNTA1/7);
	    SPTA2 = Math.sqrt((double)SPTA2/7);
	    SNTA2 = Math.sqrt((double)SNTA2/7);
	    
	
    	//YPOLOGIZW GIA ND
    	int Ntotal1=0;
    	int Ntotal2=0;
    	int[] NPW = new int[14];
    	int[] NNW = new int[14];
    	int[] NPT = new int[14];
    	int[] NNT = new int[14];
    	double NPAvg1=0;
    	double NPAvg2=0;
    	double NNAvg1=0;
    	double NNAvg2=0;
    	double NPTA1=0;
    	double NPTA2=0;
    	double NNTA1=0;
    	double NNTA2=0;
    	for(int i=0;i<14;i++){
			FileInputStream fstream1 = new FileInputStream("data\\nd\\"+Integer.toString(i+1)+".txt");
			DataInputStream in1 = new DataInputStream(fstream1);
		    BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		    line = null;
		    String tweet = null;
	    	while ((line = br1.readLine()) != null){
	    		if(line.contains("<τςεετ>")){
	    			if(i<7)Ntotal1++;
	    			else Ntotal2++;
	    			PWT = 0;
	    			NWT = 0;
	    			tweet="";
	    			line=br1.readLine();
	    			while (line.contains("<τςεετ/>")== false){
	    				tweet=tweet.concat(" "+line);
	    				line=br1.readLine();
	    			}
	    			String[] words = tweet.split(" ");
	    			for (int j = 0; j < words.length; j++) {
	    				if(PosLex.contains(words[j])){
	    					PWT++;
	    				}
	    				if(NegLex.contains(words[j])){
	    					NWT++;
	    				}
	    		    }
	    			NPW[i]=NPW[i]+PWT;
	    			NNW[i]=NNW[i]+NWT;
	    			if(PWT>NWT)NPT[i]++;
	    			if(PWT<NWT)NNT[i]++;	
	    	}
    	}
	    if(i<7){
	    	NPAvg1 = NPAvg1+NPT[i];
	    	NNAvg1 = NNAvg1+NNT[i];
	    }else{
			NPAvg2 = NPAvg2+NPT[i];	
			NNAvg2 = NNAvg2+NNT[i];
		}
	 }
	    NPAvg1 = (double)NPAvg1/7;
	    NPAvg2 = (double)NPAvg2/7;
	    NNAvg1 = (double)NNAvg1/7;
	    NNAvg2 = (double)NNAvg2/7;
	    for(int i=0;i<14;i++){
	    	if(i<7){
	    		NPTA1 = Math.pow(NPTA1 + (NPT[i]-NPAvg1),2);
	    		NNTA1 = Math.pow(NNTA1 + (NNT[i]-NNAvg1),2);
	    	}else{
	    		NPTA2 = Math.pow(NPTA2 + (NPT[i]-NPAvg2),2);
	    		NNTA2 = Math.pow(NNTA2 + (NNT[i]-NNAvg2),2);
	    	}
	    }
	    NPTA1 = Math.sqrt((double)NPTA1/7);
	    NNTA1 = Math.sqrt((double)NNTA1/7);
	    NPTA2 = Math.sqrt((double)NPTA2/7);
	    NNTA2 = Math.sqrt((double)NNTA2/7);
	    
	    int l=1;
	    while(l!=0){
	    	System.out.println("1.Τύπωσε την συχνότητα εμφάνισης των θετικών λέξεων");
	    	System.out.println("2.Τύπωσε την συχνότητα εμφάνισης των αρνητικών λέξεων");
	    	System.out.println("3.Τύπωσε το πλήθος των θετικών tweet");
	    	System.out.println("4.Τύπωσε το πλήθος των αρνητικών tweet");
	    	System.out.println("5.Τύπωσε το συνολικό πλήθος των tweet");
	    	System.out.println("6.Τύπωσε το μέσο των θετικών tweet");
	    	System.out.println("7.Τύπωσε το μέσο των αρνητικών tweet");
	    	System.out.println("8.Τύπωσε την τυπική απόκλιση των θετικών tweet");
	    	System.out.println("9.Τύπωσε την τυπική απόκλιση των αρνητικών tweet");
	    	System.out.println("0.ΕΞΟΔΟΣ");
	    	System.out.println();
			Scanner sc = new Scanner(System.in);
			l = sc.nextInt();
			
			if(l==1){
				System.out.println("Mitsotakis");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+MPW[i]);
					else System.out.println("01/02/2017 : "+MPW[i]);
				}
				System.out.println();
				System.out.println("Tsipras");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+TPW[i]);
					else System.out.println("01/02/2017 : "+TPW[i]);
				}
				System.out.println();
				System.out.println("ND");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+NPW[i]);
					else System.out.println("01/02/2017 : "+NPW[i]);
				}
				System.out.println();
				System.out.println("Syriza");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+SPW[i]);
					else System.out.println("01/02/2017 : "+SPW[i]);
				}
				System.out.println();	
			}else if(l==2){
				System.out.println("Mitsotakis");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+MNW[i]);
					else System.out.println("01/02/2017 : "+MNW[i]);
				}
				System.out.println();
				System.out.println("Tsipras");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+TNW[i]);
					else System.out.println("01/02/2017 : "+TNW[i]);
				}
				System.out.println();
				System.out.println("ND");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+NNW[i]);
					else System.out.println("01/02/2017 : "+NNW[i]);
				}
				System.out.println();
				System.out.println("Syriza");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+SNW[i]);
					else System.out.println("01/02/2017 : "+SNW[i]);
				}
				System.out.println();
			}else if(l==3){
				System.out.println("Mitsotakis");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+MPT[i]);
					else System.out.println("01/02/2017 : "+MPT[i]);
				}
				System.out.println();
				System.out.println("Tsipras");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+TPT[i]);
					else System.out.println("01/02/2017 : "+TPT[i]);
				}
				System.out.println();
				System.out.println("ND");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+NPT[i]);
					else System.out.println("01/02/2017 : "+NPT[i]);
				}
				System.out.println();
				System.out.println("Syriza");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+SPT[i]);
					else System.out.println("01/02/2017 : "+SPT[i]);
				}
				System.out.println();	
			}else if(l==4){
				System.out.println("Mitsotakis");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+MNT[i]);
					else System.out.println("01/02/2017 : "+MNT[i]);
				}
				System.out.println();
				System.out.println("Tsipras");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+TNT[i]);
					else System.out.println("01/02/2017 : "+TNT[i]);
				}
				System.out.println();
				System.out.println("ND");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+NNT[i]);
					else System.out.println("01/02/2017 : "+NNT[i]);
				}
				System.out.println();
				System.out.println("Syriza");
				for(int i=0;i<14;i++){
					if(i!=13)System.out.println((i+19)+"/01/2017 : "+SNT[i]);
					else System.out.println("01/02/2017 : "+SNT[i]);
				}
				System.out.println();
			}else if(l==5){
				System.out.println("Mitsotakis");
				System.out.println("19/01/2017-25/01/2017 : "+Mtotal1);
				System.out.println("26/01/2017-01/02/2017 : "+Mtotal2);
				System.out.println();
				System.out.println("Tsipras");
				System.out.println("19/01/2017-25/01/2017 : "+Ttotal1);
				System.out.println("26/01/2017-01/02/2017 : "+Ttotal2);
				System.out.println();
				System.out.println("ND");
				System.out.println("19/01/2017-25/01/2017 : "+Ntotal1);
				System.out.println("26/01/2017-01/02/2017 : "+Ntotal2);
				System.out.println();
				System.out.println("Syriza");
				System.out.println("19/01/2017-25/01/2017 : "+Stotal1);
				System.out.println("26/01/2017-01/02/2017 : "+Stotal2);
				System.out.println();
			}else if(l==6){
				System.out.println("Mitsotakis");
				System.out.println("19/01/2017-25/01/2017 : "+MPAvg1);
				System.out.println("26/01/2017-01/02/2017 : "+MPAvg2);
				System.out.println();
				System.out.println("Tsipras");
				System.out.println("19/01/2017-25/01/2017 : "+TPAvg1);
				System.out.println("26/01/2017-01/02/2017 : "+TPAvg2);
				System.out.println();
				System.out.println("ND");
				System.out.println("19/01/2017-25/01/2017 : "+NPAvg1);
				System.out.println("26/01/2017-01/02/2017 : "+NPAvg2);
				System.out.println();
				System.out.println("Syriza");
				System.out.println("19/01/2017-25/01/2017 : "+SPAvg1);
				System.out.println("26/01/2017-01/02/2017 : "+SPAvg2);
				System.out.println();
			}else if(l==7){
				System.out.println("Mitsotakis");
				System.out.println("19/01/2017-25/01/2017 : "+MNAvg1);
				System.out.println("26/01/2017-01/02/2017 : "+MNAvg2);
				System.out.println();
				System.out.println("Tsipras");
				System.out.println("19/01/2017-25/01/2017 : "+TNAvg1);
				System.out.println("26/01/2017-01/02/2017 : "+TNAvg2);
				System.out.println();
				System.out.println("ND");
				System.out.println("19/01/2017-25/01/2017 : "+NNAvg1);
				System.out.println("26/01/2017-01/02/2017 : "+NNAvg2);
				System.out.println();
				System.out.println("Syriza");
				System.out.println("19/01/2017-25/01/2017 : "+SNAvg1);
				System.out.println("26/01/2017-01/02/2017 : "+SNAvg2);
				System.out.println();
			}else if(l==8){
				System.out.println("Mitsotakis");
				System.out.println("19/01/2017-25/01/2017 : "+MPTA1);
				System.out.println("26/01/2017-01/02/2017 : "+MPTA2);
				System.out.println();
				System.out.println("Tsipras");
				System.out.println("19/01/2017-25/01/2017 : "+TPTA1);
				System.out.println("26/01/2017-01/02/2017 : "+TPTA2);
				System.out.println();
				System.out.println("ND");
				System.out.println("19/01/2017-25/01/2017 : "+NPTA1);
				System.out.println("26/01/2017-01/02/2017 : "+NPTA2);
				System.out.println();
				System.out.println("Syriza");
				System.out.println("19/01/2017-25/01/2017 : "+SPTA1);
				System.out.println("26/01/2017-01/02/2017 : "+SPTA2);
				System.out.println();
			}else if(l==9){
				System.out.println("Mitsotakis");
				System.out.println("19/01/2017-25/01/2017 : "+MNTA1);
				System.out.println("26/01/2017-01/02/2017 : "+MNTA2);
				System.out.println();
				System.out.println("Tsipras");
				System.out.println("19/01/2017-25/01/2017 : "+TNTA1);
				System.out.println("26/01/2017-01/02/2017 : "+TNTA2);
				System.out.println();
				System.out.println("ND");
				System.out.println("19/01/2017-25/01/2017 : "+NNTA1);
				System.out.println("26/01/2017-01/02/2017 : "+NNTA2);
				System.out.println();
				System.out.println("Syriza");
				System.out.println("19/01/2017-25/01/2017 : "+SNTA1);
				System.out.println("26/01/2017-01/02/2017 : "+SNTA2);
				System.out.println();
			}
	    }
 }
}
