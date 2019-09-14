package com.example.demo.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.example.demo.Tool.ConversionModelTool;

@Getter
@Setter
@ToString
public class ConversionModel {
	public String Message;
	public double Decimal;
	public String DecimalString;
	public String Binary;
	public String Quad;
	public String Octal;
	public String Hexadecimal;
	
	public ConversionModel(double decimal) {
		Decimal = decimal;
		Binary = ConversionModelTool.DecimalToBinaryString(decimal);
		DecimalString = ConversionModelTool.BinaryToDecimalString(Binary);
		Quad = ConversionModelTool.BinaryToQuadString(Binary);
		Octal = ConversionModelTool.BinaryToOctalString(Binary);
		Hexadecimal = ConversionModelTool.BinaryToHexadecimalString(Binary);
	}
	
	public ConversionModel(String nstr, ConversionType type) {
		
		switch (type) {
			case Binary:
				
				Binary = nstr;
				DecimalString = ConversionModelTool.BinaryToDecimalString(Binary);
				Quad = ConversionModelTool.BinaryToQuadString(Binary);
				Octal = ConversionModelTool.BinaryToOctalString(Binary);
				Hexadecimal = ConversionModelTool.BinaryToHexadecimalString(Binary);
				Decimal = Double.valueOf(DecimalString);
				Message = "Success";
				
				break;
			case Quad:
				
				DecimalString = ConversionModelTool.QuadToDecimalString(nstr);
				Binary = ConversionModelTool.FromDecimalStringToBinaryString(DecimalString);
				Quad = ConversionModelTool.BinaryToQuadString(Binary);
				Octal = ConversionModelTool.BinaryToOctalString(Binary);
				Hexadecimal = ConversionModelTool.BinaryToHexadecimalString(Binary);
				Decimal = Double.valueOf(DecimalString);
				Message = "Success";
				
				break;
			case Octal:
				
				DecimalString = ConversionModelTool.OctalToDecimalString(nstr);
				Binary = ConversionModelTool.FromDecimalStringToBinaryString(DecimalString);
				Quad = ConversionModelTool.BinaryToQuadString(Binary);
				Octal = ConversionModelTool.BinaryToOctalString(Binary);
				Hexadecimal = ConversionModelTool.BinaryToHexadecimalString(Binary);
				Decimal = Double.valueOf(DecimalString);
				Message = "Success";
				
				break;
			case Decimal:
				
				DecimalString = nstr;
				Binary = ConversionModelTool.FromDecimalStringToBinaryString(DecimalString);
				Quad = ConversionModelTool.BinaryToQuadString(Binary);
				Octal = ConversionModelTool.BinaryToOctalString(Binary);
				Hexadecimal = ConversionModelTool.BinaryToHexadecimalString(Binary);
				Decimal = Double.valueOf(DecimalString);
				Message = "Success";
				
				break;
			case Hexadecimal:
				
				DecimalString = ConversionModelTool.HexadecimalToDecimalString(nstr);
				Binary = ConversionModelTool.FromDecimalStringToBinaryString(DecimalString);
				Quad = ConversionModelTool.BinaryToQuadString(Binary);
				Octal = ConversionModelTool.BinaryToOctalString(Binary);
				Hexadecimal = ConversionModelTool.BinaryToHexadecimalString(Binary);
				Decimal = Double.valueOf(DecimalString);
				Message = "Success";
				
				break;
	
			default:
				break;
		}
	}
	
	public enum ConversionType{
		Binary,
		Quad,
		Octal,
		Decimal,
		Hexadecimal
	}
}



