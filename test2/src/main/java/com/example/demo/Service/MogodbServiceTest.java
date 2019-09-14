package com.example.demo.Service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.LinkToDB.AccountsDBConnect;
import com.example.demo.LinkToDB.TranscriptModelDBConnect;
import com.example.demo.Model.Accounts;
import com.example.demo.Model.ConversionModel;
import com.example.demo.Model.ConversionModel.ConversionType;
import com.example.demo.Model.TranscriptModel;

@RestController
public class MogodbServiceTest {
	
	@Autowired
	private AccountsDBConnect accountDBConnect;
	
	@Autowired
	private TranscriptModelDBConnect transcriptModelDBConnect;
	
	@GetMapping(value="/getaccounts")
	public List<Accounts> GetAccounts()
	{
		LocalTime now = LocalTime.now();
		return accountDBConnect.findAll();
	}
	
	@GetMapping(value="/FromBinary")
	public ConversionModel GetConversionFromBinary(String digit)
	{
		return new ConversionModel(digit, ConversionType.Binary);
	}
	
	@GetMapping(value="/FromQuad")
	public ConversionModel GetConversionFromQuad(String digit)
	{
		return new ConversionModel(digit, ConversionType.Quad);
	}
	
	@GetMapping(value="/FromOctal")
	public ConversionModel GetConversionFromOctal(String digit)
	{
		return new ConversionModel(digit, ConversionType.Octal);
	}
	
	@GetMapping(value="/FromDecimal")
	public ConversionModel GetConversionFromDecimal(String digit)
	{
		return new ConversionModel(digit, ConversionType.Decimal);
	}
	
	@GetMapping(value="/FromDecimalDouble")
	public ConversionModel GetConversionFromDecimal(double digit)
	{
		return new ConversionModel(digit);
	}
	
	@GetMapping(value="/FromHexadecimal")
	public ConversionModel GetConversionFromHexadecimal(String digit)
	{
		return new ConversionModel(digit, ConversionType.Hexadecimal);
	}
	
	@CrossOrigin(origins = "http://127.0.0.1:5500")
	@PostMapping(value="/Transcript")
	public String SaveTranscript(@RequestBody TranscriptModel tran) {
		transcriptModelDBConnect.save(tran);
		return "OK";
	}
	
}
