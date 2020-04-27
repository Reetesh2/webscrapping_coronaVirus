package com.tut.webscrapYoutube;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
	 public static String  getData(String c) throws Exception{
	    	StringBuffer br=new StringBuffer();
	    	br.append("<html>"+"<body style='text-align:center;color:red; '>");
	    	br.append(c.toUpperCase()+"<br>");
	    	String url="https://www.worldometers.info/coronavirus/country/"+c+"/";
	    	Document doc=Jsoup.connect(url).get();
	    	Elements element=doc.select("#maincounter-wrap");
	    	element.forEach((e)->
	    	{
	    		String text=e.select("h1").text();
	    		String count=e.select(".maincounter-number>span").text();
	    		br.append(text).append(count).append("<br>");
	    	});
	    	br.append("</body>"+"</html>");
	    	return br.toString();
	    }
    public static void main ( String[] args )throws Exception
    {
//    	Scanner s=new Scanner(System.in);
//    	System.out.print("Enter the country name: ");
//    	String con=s.nextLine();
//    	System.out.println(getData(con));
    	
    	
    	JFrame root=new JFrame("Details of country");
    	root.setSize(500,500);
    	Font f=new Font("Poppins",Font.BOLD,30);
    	JTextField field=new JTextField();
    	JLabel dataL=new JLabel();
    	field.setFont(f);
    	dataL.setFont(f);
    	field.setHorizontalAlignment(SwingConstants.CENTER);
    	dataL.setHorizontalAlignment(SwingConstants.CENTER);
    	JButton button=new JButton("Get");
    	button.addActionListener((event)->
    	{
    		//click
    		try {
				String maindata=field.getText();
				String result=getData(maindata);
				dataL.setText(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	});
    	button.setFont(f);
    	
    	root.setLayout(new BorderLayout());
    	root.add(field,BorderLayout.NORTH);
    	root.add(dataL,BorderLayout.CENTER);
    	root.add(button,BorderLayout.SOUTH);
    	root.setVisible(true);
    	
    	
    	
    }
   
}
