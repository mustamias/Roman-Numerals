package com.tr.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.tr.model.ITransformaion;

@Controller
public class Control_form {
	
	// I will not comment  this class i will explain it in interview :)
	
	@Autowired
	private ITransformaion iTransformaion;
	
	
	@RequestMapping("/")
	public String index() {
		
		
		return "Convert";
	}
	
	@RequestMapping(value= "/convert" , method=RequestMethod.POST)
	public String convert(Model model, String number) {
		
		  
		try 
			{
			if (number.isEmpty()) throw new RuntimeException("Emty From");
			
			try 
				{
				
				Integer Numconverted=Integer.parseInt(number);
		
					if(Numconverted>0) {
							
							String Roman_num=iTransformaion.ToRomanNum(Numconverted);
							model.addAttribute("result", Roman_num);
					
															}
					else 	{model.addAttribute("out", "Out of range");}
	
				}
				catch (Exception Arithmetic_exception) 
									{
				
									try {
					
										int convnum;
										convnum = iTransformaion.ToArabicNum( number);
										model.addAttribute("result", convnum);
					
										}
									catch (Exception excceptionmodel1)
										{
										model.addAttribute("expmodel", excceptionmodel1);
										}
				
									}
			
			
			} 
			catch (Exception excceptionmodel2) 
			{
			
			model.addAttribute("expmodel", excceptionmodel2);
			}
		
		return "Convert";
	}

}
