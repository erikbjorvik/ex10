package no.hib.dat152.ex10.util;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class limitWords extends SimpleTagSupport {
	int maxchars;
	
	public final void setMaxchars(final int maxchars) {
		this.maxchars = maxchars;
	}
	
	public final void doTag() throws JspException, IOException {
        StringWriter sw = new StringWriter();
        getJspBody().invoke(sw);
        
        String tekst = sw.toString();
        
        if(tekst.length() < maxchars) {
        	getJspContext().getOut().print(tekst);
        }
        
        else {
        	getJspContext().getOut().print(tekst.substring(0, maxchars));
        }
        
        
	}

}