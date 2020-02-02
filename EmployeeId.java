import java.awt.*;
import java.awt.event.*;

import java.sql.*;

class EmpGui implements ActionListener{

	Frame f1;
	Label l1,l2,l3,l4,l5;
	TextField t1,t2,t3,t4;
	Button btn1,btn2,btn3;
	
	public EmpGui(){
		f1=new Frame();
		f1.setSize(500,500);
		
		
		l1= new Label("Eno");
		t1 = new TextField();
		
		l2 = new Label("Ename");
		t2 = new TextField();
		
		l3 = new Label("Sal");
		t3 = new TextField();
		
		l4 = new Label("Dname");
		t4 = new TextField();
		 
		l5 = new Label("Add Account");
		btn1 = new Button("Add Account");
		btn2 = new Button("Clear");
		btn3 = new Button("Exit");
		
		f1.add(l1);
		f1.add(t1);
		
		f1.add(l2);
		f1.add(t2);
		
		f1.add(l3);
		f1.add(t3);
		
		f1.add(l4);
		f1.add(t4);
		
		f1.add(l5);
		f1.add(btn1);
		f1.add(btn2);
		f1.add(btn3);
		
		f1.setLayout(null);
		
		l1.setBounds(100,100,100,30);
		t1.setBounds(220,100,100,30);
		
		l2.setBounds(100,150,100,30);
		t2.setBounds(220,150,100,30);
		
		l3.setBounds(100,200,100,30);
		t3.setBounds(220,200,100,30);
		
		l4.setBounds(100,250,100,30);
		t4.setBounds(220,250,100,30);
		
		l5.setBounds(100,300,100,30);
		
		btn1.setBounds(100,350,100,30);
		btn2.setBounds(220,350,100,30);
		btn3.setBounds(100,400,100,30);

		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		f1.setVisible(true);

	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btn1){
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/iactdata?user=root&password=");
			int a,b;
			a = Integer.parseInt(t1.getText());
			b = Integer.parseInt(t3.getText());

			
			String qry = "insert into emp values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1,a);
			ps.setString(2,t2.getText());
			ps.setInt(3,b);
			ps.setString(4,t4.getText());
			int g = ps.executeUpdate();
			if(g==1){
				l5.setText("Record is added");
			}
			else{
				l5.setText("Record is not added");
			}
		}
			catch(Exception x){
			System.out.println(x);
			}
		}
		else if(e.getSource()==btn2){
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			l5.setText("");
		}
		else if(e.getSource()==btn3){
			System.exit(0);
		}
	}
}

class EmployeeId{
	public static void main(String ar[]){
		new EmpGui();
	}
}