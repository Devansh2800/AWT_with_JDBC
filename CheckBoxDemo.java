//This program will only consist of the awt and event handling. It will make use of the frames, checkboxes, buttons etc.

import java.awt.*;
import java.awt.event.*;

class MyCheckBox implements ActionListener{

	Frame f1;
	Label l1,l2;
	CheckBox cb1,cb2,cb3;
	Button btn1,btn2;
	
	public MyCheckBox(){
		f1=new Frame();
		f1.setSize(500,500);
		
		
		l1= new Label("Bhatia Pizza Cafe");
		
		cb1= new CheckBox("Pizza:250/-");
		cb2= new CheckBox("Momos:50/-");
		cb3= new CheckBox("Burgers:50/-");
	
		
		l2= new Label("Bill");
		
		btn1= new Button("Bill");
		btn2=new Button("exit");
		
		f1.add(l1);
		
		f1.add(cb1);
		f1.add(cb2);
		f1.add(cb3);
		
		f1.add(l2);
		
		f1.add(btn1);
		f1.add(btn2);
		
		f1.setLayout(null);
		l1.setBounds(100,100,100,30);
		
		cb1.setBounds(100,150,100,30);
		cb2.setBounds(100,200,100,30);
		cb3.setBounds(100,250,100,30);
		
		btn1.setBounds(200,150,100,30);
		btn2.setBounds(200,200,100,30);
		
		l2.setBounds(100,300,100,30);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	
		
		f1.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btn1){
			int bill=0;
			if(cb1.getState()==true){
				bill=bill+250;
			}
			if(cb2.getState()==true){
				bill=bill+50;
			}
			if(cb3.getState()==true){
				bill=bill+50;
			}
			
			
		}
		else if(e.getSource()==btn2){
			System.exit(0);
		}
	}
}
class CheckBoxDemo{
	public static void main(String ar[]){
		new MyCheckBox();
	}
}
