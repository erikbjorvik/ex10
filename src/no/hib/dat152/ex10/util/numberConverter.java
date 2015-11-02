package no.hib.dat152.ex10.util;


import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class numberConverter extends SimpleTagSupport {
	int nummer;
	
	public final void setNummer(final int nummer) {
        this.nummer = nummer;
    }
	
	public final void doTag() throws JspException, IOException {
		
		PageContext pageContext = (PageContext) getJspContext();
        JspWriter out = pageContext.getOut();
      
		int tusener;
		int femhundrere;
		int hundrere;
		int femti;
		int tiere;
		int femere;
		int enere;
		String tekst = "";
		
		if(nummer >= 1000) {
			tusener = nummer/1000;
			nummer-=(tusener*1000);
			for(int i=0;i<tusener;i++) {
				tekst += "M";
			}
		}
		
		if(nummer >= 500) {
			femhundrere = nummer/500;
			nummer-=(femhundrere*500);
			for(int i=0;i<femhundrere;i++) {
				tekst += "D";
			}
		}
		
		if(nummer >= 100) {
			hundrere = nummer/100;
			nummer-=(hundrere*100);
			for(int i=0;i<hundrere;i++) {
				tekst += "C";
			}
		}
		
		if(nummer >= 50) {
			femti = nummer/50;
			nummer-=(femti*50);
			for(int i=0;i<femti;i++) {
				tekst += "L";
			}
		}
		
		if(nummer >= 10) {
			tiere = nummer/10;
			nummer-=(tiere*10);
			for(int i=0;i<tiere;i++) {
				tekst += "X";
			}
		}
		
		if(nummer >= 5) {
			femere = nummer/5;
			nummer-=(femere*5);
			for(int i=0;i<femere;i++) {
				tekst += "V";
			}
		}
		
		if(nummer >= 1) {
			enere = nummer;
			for(int i=0;i<enere;i++) {
				tekst += "I";
			}
		}
		
		
		out.println(tekst);
	}
}
