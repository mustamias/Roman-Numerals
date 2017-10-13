package com.tr.model;

import java.util.Hashtable;

// Class to implement the interface

import org.springframework.stereotype.Service;

@Service
public class Transformation implements ITransformaion {
	
	private Hashtable<Character, Integer> format;
	
	

	@Override
	public int ToArabicNum(String roman_num) {
		// TODO Auto-generated method stub
		
		format = new Hashtable<Character, Integer>();
		format.put('I',1);
		format.put('V',5);
	    format.put('X',10);
	    format.put('L',50);
	    format.put('C',100);
	    format.put('D',500);
	    format.put('M',1000);
		
		//Methede with two parameters, our structure and the Roman number 

		// local declaration for 2 integer first to save arabic number and second for 
		int arabic_Num=0;
		int prev = 0;
		
		// change change the character oo capital letter
 
		roman_num=roman_num.toUpperCase();
		
		// Loop of transformation
		for(int i = roman_num.length()-1; i>=0 ; i--)
	    {
			
			  // Test every caractraire from roman number if we have it in our structure from class Fromat_Rom 
			 			
			if (format.get(roman_num.charAt(i))==null) throw new RuntimeException("Only the letters IVXLCDM");
			
					//If i find it in structure i will transforme it to integer , else throw exception with some message
				   // Transformation 
				int temp = (int) format.get(roman_num.charAt(i));
	           
				//Test
				if(temp < prev)
	            	arabic_Num-=temp;
	            else
	            	arabic_Num+=temp;
	            prev = temp;
	    }
		
		return arabic_Num;
	}

	@Override
	public String ToRomanNum( int arab_num) {
		
		
     //Other kind of implementation without data structure
		
		int loop;
		String roman="";
		
        loop=arab_num/1000;
        for(int i=1; i<=loop;i++){
            roman=roman+"M";
        }
        arab_num=arab_num%1000;
 
        loop=arab_num/900;
        for(int i=1; i<=loop;i++){
            roman=roman+"CM";
        }
        arab_num=arab_num%900;
 
        loop=arab_num/500;
        for(int i=1; i<=loop;i++){
            roman=roman+"D";
        }
        arab_num=arab_num%500;
 
        loop=arab_num/400;
        for(int i=1; i<=loop;i++){
            roman=roman+"CD";
        }
        arab_num=arab_num%400;
 
        loop=arab_num/100;
        for(int i=1; i<=loop;i++){
            roman=roman+"C";
        }
        arab_num=arab_num%100;
 
        loop=arab_num/90;
        for(int i=1; i<=loop;i++){
            roman=roman+"XC";
        }
        arab_num=arab_num%90;
 
        loop=arab_num/50;
        for(int i=1; i<=loop;i++){
            roman=roman+"L";
        }
        arab_num=arab_num%50;
 
        loop=arab_num/40;
        for(int i=1; i<=loop;i++){
            roman=roman+"XL";
        }
        arab_num=arab_num%40;
 
        loop=arab_num/10;
        for(int i=1; i<=loop;i++){
            roman=roman+"X";
        }
        arab_num=arab_num%10;
 
        loop=arab_num/9;
        for(int i=1; i<=loop;i++){
            roman=roman+"IX";
        }
        arab_num=arab_num%9;
 
        loop=arab_num/5;
        for(int i=1; i<=loop;i++){
            roman=roman+"V";
        }
        arab_num=arab_num%5;
 
        loop=arab_num/4; 
        for(int i=1; i<=loop;i++){
            roman=roman+"IV";
        }
        arab_num=arab_num%4;
 
        loop=arab_num/1; // or simply loop=n or i<=n in the condition part of the loop
        for(int i=1; i<=loop;i++){
            roman=roman+"I";
        }
		
		//-----------------------------------------------------------------------
		
		return roman;
		
	}

}
