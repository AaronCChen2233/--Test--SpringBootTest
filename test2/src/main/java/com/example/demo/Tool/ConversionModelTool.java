package com.example.demo.Tool;

import java.text.DecimalFormat;
import java.util.Arrays;

public class ConversionModelTool {
	
	public static String DecimalToBinaryString(double n) {
		String value = "";
		long nlong = (long)n;
		double nfloat = n-nlong;
		
		String longpart = LongToBinaryString(nlong);
		String floatpart = FloatToBinaryString(nfloat);
		
		if(longpart=="0")
		{
			value = "0" + floatpart;
		}
		else if (floatpart == ".")
		{
			value = longpart;
		}
		else
		{
			value = longpart + floatpart;
		}
	
		return value;
	}
	
	public static String FromDecimalStringToBinaryString(String decimal) {
		
		return DecimalToBinaryString(Double.valueOf(decimal));
	}
	
	public static String BinaryToDecimalString(String binary)
	{
		return OtherElseToDecimal(binary, 2);
	}
	
	public static String QuadToDecimalString(String quad) {
		return OtherElseToDecimal(quad, 4);
	}
	
	public static String OctalToDecimalString(String octal) {
		return OtherElseToDecimal(octal, 8);
	}
	
	public static String HexadecimalToDecimalString(String hexadecimal) {
		return OtherElseToDecimal(hexadecimal, 16);
	}

	
	public static String BinaryToQuadString(String binary) {
		return BinaryOtherelse(binary, ConversionType.Quad);
	}
	
	public static String BinaryToOctalString(String binary) {
		return BinaryOtherelse(binary, ConversionType.Octal);
	}
	
	public static String BinaryToHexadecimalString(String binary) {
		return BinaryOtherelse(binary, ConversionType.Hexadecimal);
	}
	

	public static String OtherElseToDecimal(String quad, int bascdigt) {
		String twopart[]=quad.split("\\.");
		String longpart = twopart[0];
	
		char[] binaryLongpartArray = longpart.toCharArray();
		
		//this part maybe could be easier
		int p = binaryLongpartArray.length - 1;
		double longpartdouble = 0;
		for(char digit : binaryLongpartArray) {
			int n = HexadecimalCorvertoDecimal(digit);
			longpartdouble =(n * Math.pow(bascdigt, p)) + longpartdouble;
			p=p-1;
		}
		
		if(twopart.length>1)
		{
			String floatpart = twopart[1];
			char[] binaryFloatpartArray = floatpart.toCharArray();
			p=-1;
			double floatpartdouble=0;
			for(char digit : binaryFloatpartArray) {
				int n = HexadecimalCorvertoDecimal(digit);
				floatpartdouble =(n * Math.pow(bascdigt, p)) + floatpartdouble;
				p=p-1;
			}
			return Double.toString(longpartdouble+ floatpartdouble);
		}
		return Double.toString(longpartdouble);
	}
	
	public static String FloatToBinaryString(double n ) {
		
	    String value = ".";    
	    while ( n > 0 ) {    
	        double r = n * 2;   
	        if( r >= 1 ) {  
	            value += "1";     
	            n = r - 1;        
	        }else{              
	            value += "0";      
	            n = r;            
	        }
	    }
	    return value;          
	}
	
	public static String LongToBinaryString(long n){
		
		if(n==0)
			return "0";
		
		String value="";
		long left=0;
		while(n>=1) {
			left = n%2;
			value = Long.toString(left) + value;
			n=(n-left)/2;
		}
		
		return value;
	}
	
	public static String BinaryOtherelse(String binary, int type) { 
		String twopart[]=binary.split("\\.");
		String longpart = twopart[0];

		int patchLength = (type - (longpart.length()%type))%type;
		for(;patchLength>0;patchLength--)
			longpart = "0" + longpart;
			
		char[] binaryLongpartArray = longpart.toCharArray();


		int count = type;
		String longpartdoubleString = "";
		double longpartdouble = 0;
		for(char digit : binaryLongpartArray) {
			int n = digit - '0';
			
			count--;
			longpartdouble =(n * Math.pow(2, count))+ longpartdouble;
			if(count==0)
			{
				count = type;
				if(type==4) {
					longpartdoubleString = longpartdoubleString + CorvertoHexadecimal(longpartdouble);
				}
				else {
					longpartdoubleString = longpartdoubleString + Long.toString((long)longpartdouble);
				}
				longpartdouble = 0;
			}
		}
		
		if(twopart.length>1) {
			String floatpart = twopart[1];
			patchLength = (type - (floatpart.length()%type))%type;
			for(;patchLength>0;patchLength--)
				floatpart = floatpart + "0";
			
			char[] binaryFloatpartArray = floatpart.toCharArray();
			
			String floatPartDoubleString = "";
			for(char digit : binaryFloatpartArray) {
				int n = digit - '0';
				count--;
				longpartdouble =(n * Math.pow(2, count))+ longpartdouble;
				if(count==0)
				{
					count = type;
					if(type==4) {
						floatPartDoubleString = floatPartDoubleString + CorvertoHexadecimal(longpartdouble);
					}
					else {
						floatPartDoubleString = floatPartDoubleString + Long.toString((long)longpartdouble);
					}
					longpartdouble = 0;
				}
			}
			
			return longpartdoubleString+"."+ floatPartDoubleString;
		}

		return longpartdoubleString;
	}
	
	private static String CorvertoHexadecimal(double n)
	{
		String Hex ="";
		if(n<10) {
			Hex = Long.toString((long)n);
		}
		else if(n==10){
			Hex = "A";
		}
		else if(n==11){
			Hex = "B";
		}
		else if(n==12){
			Hex = "C";
		}
		else if(n==13){
			Hex = "D";
		}
		else if(n==14){
			Hex = "E";
		}
		else if(n==15){
			Hex = "F";
		}	
		return Hex;
	}

	private static int HexadecimalCorvertoDecimal(char n) {		
		
		if(n=='A')
			return 10;
		if(n=='B')
			return 11;
		if(n=='C')
			return 12;
		if(n=='D')
			return 13;
		if(n=='E')
			return 14;
		if(n=='F')
			return 15;
		
		return n - '0';

	}
	
	public final class ConversionType {
		public static final int Decimal = 0;
	    public static final int Binary = 1;
	    public static final int Quad = 2;
	    public static final int Octal = 3;
	    public static final int Hexadecimal = 4;
	    private ConversionType() {}
	}
}
