import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.lang.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.*;
class Allowance extends JFrame
{
	int empid;
	JComboBox jc;
	JButton button;
	JLabel label;
	JMenu menu,menu2,menu1,menu3;
	JMenuItem i1,i2,i3,i4,i5,i6;

	public Allowance()
	{
		super("Allowance");

		setSize(800,1600);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//background
		ImageIcon background_image=new ImageIcon("1.jpg");
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(800,1600,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		JLabel background=new JLabel("",background_image,JLabel.CENTER);

		//menu
		JMenuBar mb=new JMenuBar();
		menu1=new JMenu("Home");
		menu=new JMenu("Reports");
		menu3=new JMenu("Logout");
		i2=new JMenuItem("Total Allowance RP");
		i3=new JMenuItem("Total Deduction RP");
		i5=new JMenuItem("Home Page");
		i6=new JMenuItem("Log out");
		menu1.add(i5);
		menu.add(i2);
		menu.add(i3);
		menu3.add(i6);
		mb.add(menu1);
		mb.add(menu);
		mb.add(menu3);

		i6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				new Login();
			}
		});
		i2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				new AllowPdf();
			}
		});
		i3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				new DeductionPdf();
			}
		});
		i5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				new Index();
			}
		});
		//header
		Font f=new Font("VERDANA",Font.BOLD,30);
		JPanel heading;
		heading=new JPanel();
		heading.setBackground(new Color(0,0,0,100));
		heading.setBounds(0,0,800,70);

		Font f1=new Font("Rockwell Condensed",Font.BOLD,18);

		JLabel name=new JLabel("Allowance");
		name.setForeground(Color.WHITE);
		//name.setBounds(200,150,800,100);
		name.setFont(f);
		heading.add(name);

		JPanel allowance=new JPanel();
		allowance.setLayout(null);
		allowance.setSize(400,350);
		allowance.setBackground(new Color(0,0,0,100));
		allowance.setBounds(140,85,500,570);     //from left,from top,width,height

		JLabel lbleid=new JLabel("Select ID ");
		lbleid.setForeground(Color.WHITE);
		lbleid.setBounds(30,40,150,40);
		lbleid.setFont(f1);
		allowance.add(lbleid);

		JLabel lblfnm=new JLabel("First Name");
		lblfnm.setForeground(Color.WHITE);
		lblfnm.setBounds(30,80,200,40);
		lblfnm.setFont(f1);
		allowance.add(lblfnm);

		JTextField fname=new JTextField("");
		fname.setBounds(190,80,240,30);
		fname.setBackground(new Color(150,150,140));
		allowance.add(fname);

		JLabel lblsnm=new JLabel("Surname ");
		lblsnm.setForeground(Color.WHITE);
		lblsnm.setBounds(30,120,200,40);
		lblsnm.setFont(f1);
		allowance.add(lblsnm);

		JTextField sname=new JTextField("");
		sname.setBounds(190,120,240,30);
		sname.setBackground(new Color(150,150,140));
		allowance.add(sname);

		JLabel lbldob=new JLabel("Date of Birth ");
		lbldob.setForeground(Color.WHITE);
		lbldob.setBounds(30,160,200,40);
		lbldob.setFont(f1);
		allowance.add(lbldob);

		JTextField dob=new JTextField("");
		dob.setBounds(190,160,240,30);
		dob.setBackground(new Color(150,150,140));
		allowance.add(dob);

		JLabel lbldep=new JLabel("Department ");
		lbldep.setForeground(Color.WHITE);
		lbldep.setBounds(30,200,200,40);
		lbldep.setFont(f1);
		allowance.add(lbldep);

		JTextField department=new JTextField("");
		department.setBounds(190,200,240,30);
		department.setBackground(new Color(150,150,140));
		allowance.add(department);

		JLabel lblsal=new JLabel("Salary ");
		lblsal.setForeground(Color.WHITE);
		lblsal.setBounds(30,240,200,40);
		lblsal.setFont(f1);
		allowance.add(lblsal);

		JTextField salary=new JTextField("");
		salary.setBounds(190,240,240,30);
		salary.setBackground(new Color(150,150,140));
		allowance.add(salary);

		JLabel lblovr=new JLabel("Overtime ");
		lblovr.setForeground(Color.WHITE);
		lblovr.setBounds(30,290,200,40);
		lblovr.setFont(f1);
		allowance.add(lblovr);

		JTextField overtime=new JTextField("");
		overtime.setBounds(110,290,120,30);
		overtime.setBackground(new Color(150,150,140));
		allowance.add(overtime);

		JLabel lblmed=new JLabel("Medical");
		lblmed.setForeground(Color.WHITE);
		lblmed.setBounds(240,290,200,40);
		lblmed.setFont(f1);
		allowance.add(lblmed);

		JTextField medical=new JTextField("");
		medical.setBounds(310,290,120,30);
		medical.setBackground(new Color(150,150,140));
		allowance.add(medical);

		JLabel lblbns=new JLabel("Bonus ");
		lblbns.setForeground(Color.WHITE);
		lblbns.setBounds(30,330,200,40);
		lblbns.setFont(f1);
		allowance.add(lblbns);

		JTextField bonus=new JTextField("");
		bonus.setBounds(110,330,120,30);
		bonus.setBackground(new Color(150,150,140));
		allowance.add(bonus);

		JLabel lblhra=new JLabel("HRA");
		lblhra.setForeground(Color.WHITE);
		lblhra.setBounds(240,330,200,40);
		lblhra.setFont(f1);
		allowance.add(lblhra);

		JTextField hra=new JTextField("");
		hra.setBounds(310,330,120,30);
		hra.setBackground(new Color(150,150,140));
		allowance.add(hra);

		JLabel lblpf=new JLabel("PF ");
		lblpf.setForeground(Color.WHITE);
		lblpf.setBounds(30,370,200,40);
		lblpf.setFont(f1);
		allowance.add(lblpf);

		JTextField pf=new JTextField("");
		pf.setBounds(110,370,120,30);
		pf.setBackground(new Color(150,150,140));
		allowance.add(pf);

		JLabel lblcea=new JLabel("CEA");
		lblcea.setForeground(Color.WHITE);
		lblcea.setBounds(240,370,200,40);
		lblcea.setFont(f1);
		allowance.add(lblcea);

		JTextField cea=new JTextField("");
		cea.setBounds(310,370,120,30);
		cea.setBackground(new Color(150,150,140));
		allowance.add(cea);


		JLabel lbltovr=new JLabel("Total Overtime");
		lbltovr.setForeground(Color.WHITE);
		lbltovr.setBounds(30,420,200,40);
		lbltovr.setFont(f1);
		allowance.add(lbltovr);

		JTextField totalover=new JTextField("");
		totalover.setBounds(190,420,240,30);
		totalover.setBackground(new Color(150,150,140));
		allowance.add(totalover);

		JLabel lblamt=new JLabel("Total Amount ");
		lblamt.setForeground(Color.WHITE);
		lblamt.setBounds(30,460,200,40);
		lblamt.setFont(f1);
		allowance.add(lblamt);

		JTextField amount=new JTextField("");
		amount.setBounds(190,460,240,30);
		amount.setBackground(new Color(150,150,140));
		allowance.add(amount);

		jc=new JComboBox();
		jc.setBounds(190,40,240,30);
		try
		{
			Connection con=DBConnection.getConnection();
			Statement stmt=DBConnection.getConnection().createStatement();
			ResultSet rs=stmt.executeQuery("select id from staff_info order by id");
			while(rs.next())
			{
				jc.addItem(Integer.toString(rs.getInt("id")));
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		allowance.add(jc);
		jc.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{

				try{
					empid=Integer.parseInt(jc.getSelectedItem().toString());
					Connection con=DBConnection.getConnection();
					PreparedStatement stmt=con.prepareStatement("select * from staff_info where id=?");
					stmt.setInt(1,empid);
					ResultSet rs=stmt.executeQuery();
					if(rs.next())
					{
						String fnm=rs.getString(2);
						String snm=rs.getString(3);
						String dt=rs.getString(4);
						String dep=rs.getString(8);
						float sal=rs.getFloat(12);

						fname.setText(fnm);
						sname.setText(snm);
						dob.setText(dt);
						department.setText(dep);
						salary.setText(Float.toString(sal));
						medical.setText("200");
						cea.setText("200");
						overtime.setText("0");
					}
					else
					{
						JOptionPane.showMessageDialog(new JFrame(),"Record not found..");
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		allowance.add(jc);

		JButton calc=new JButton(" Calculate ");
		calc.setBounds(100,500,125,40);
		calc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try{
					int overt=Integer.parseInt(overtime.getText());
					float med=Float.parseFloat(medical.getText());
					float ch=Float.parseFloat(cea.getText());

					float sal=Float.parseFloat(salary.getText());
					Statement stmt=DBConnection.getConnection().createStatement();
					ResultSet rs=stmt.executeQuery("select * from calc_rate where id = 1");
					if(rs.next())
					{
						float rh=rs.getFloat(2);
						float bons=rs.getFloat(3);
						float prof=rs.getFloat(4);
						float hral=rs.getFloat(5);

						float totovt=((sal*rh)/100)*overt;
						float bns=(sal*bons)/100;
						float pfc=(sal*prof)/100;
						float hrac=((sal/2)*hral)/100;

						totalover.setText(Float.toString(totovt));
						bonus.setText(Float.toString(bns));
						pf.setText(Float.toString(pfc));
						hra.setText(Float.toString(hrac));
						amount.setText(Float.toString(totovt+bns+pfc+hrac+med+ch));
					}
					else
					{
						JOptionPane.showMessageDialog(new JFrame(),"Record not found..");
					}

				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});

		allowance.add(calc);


		JButton save=new JButton(" Save ");
		save.setBounds(260,500,125,40);

		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try{
						float over=Float.parseFloat(totalover.getText());
						float pfc=Float.parseFloat(pf.getText());
						float med=Float.parseFloat(medical.getText());
						float bns=Float.parseFloat(bonus.getText());
						float ce=Float.parseFloat(cea.getText());
						float sal=Float.parseFloat(salary.getText());
						float tal=Float.parseFloat(amount.getText());
						String fnm=fname.getText();
						String snm=sname.getText();

						int flag=0;
						Connection con=DBConnection.getConnection();
						PreparedStatement stmt=con.prepareStatement("insert into allowance(overtime,pf,medical,bonus,ce,emp_id,salary,tallowance,fname,sname) values(?,?,?,?,?,?,?,?,?,?)");
						stmt.setFloat(1,over);
						stmt.setFloat(2,pfc);
						stmt.setFloat(3,med);
						stmt.setFloat(4,bns);
						stmt.setFloat(5,ce);
						stmt.setInt(6,empid);
						stmt.setFloat(7,sal);
						stmt.setFloat(8,tal);
						stmt.setString(9,fnm);
						stmt.setString(10,snm);
						int i=stmt.executeUpdate();
						if(i!=0)
							flag++;
						if(flag==1)
						{
							JOptionPane.showMessageDialog(new JFrame(),"Record Saved Successfully..");
						}
						else
							JOptionPane.showMessageDialog(new JFrame(),"Failed..");
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		allowance.add(save);

		background.add(allowance);
		background.add(heading);
		background.setBounds(0,0,800,1600);
		add(background);
		setJMenuBar(mb);

		setVisible(true);
	}
		public static void main(String a[])
		{
			new Allowance();
		}
}