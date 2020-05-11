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
class Search extends JFrame
{
	int empid;
	JComboBox jc;
	JButton button;
	JLabel label;
	JMenu menu,menu2,menu1,menu3;
	JMenuItem i1,i2,i3,i4,i5,i6;

	public Search()
	{
		super("Search");

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

		JLabel name=new JLabel("Search / Update");
		name.setForeground(Color.WHITE);
		//name.setBounds(200,150,800,100);
		name.setFont(f);
		heading.add(name);

		JPanel srch=new JPanel();
		srch.setLayout(null);
		srch.setSize(400,350);
		srch.setBackground(new Color(0,0,0,100));
		srch.setBounds(140,90,490,650);     //from left,from top,width,height

		JLabel lbleid=new JLabel("Enter ID ");
		lbleid.setForeground(Color.WHITE);
		lbleid.setBounds(30,40,150,40);
		lbleid.setFont(f1);
		srch.add(lbleid);

		JLabel lblfnm=new JLabel("First Name");
		lblfnm.setForeground(Color.WHITE);
		lblfnm.setBounds(30,80,200,40);
		lblfnm.setFont(f1);
		srch.add(lblfnm);

		JTextField fname=new JTextField("");
		fname.setBounds(200,80,200,30);
		fname.setBackground(new Color(150,150,140));
		srch.add(fname);

		JLabel lblsnm=new JLabel("Surname ");
		lblsnm.setForeground(Color.WHITE);
		lblsnm.setBounds(30,120,200,40);
		lblsnm.setFont(f1);
		srch.add(lblsnm);

		JTextField sname=new JTextField("");
		sname.setBounds(200,120,200,30);
		sname.setBackground(new Color(150,150,140));
		srch.add(sname);

		JLabel lbldob=new JLabel("Date of Birth ");
		lbldob.setForeground(Color.WHITE);
		lbldob.setBounds(30,160,200,40);
		lbldob.setFont(f1);
		srch.add(lbldob);

		JTextField dob=new JTextField("");
		dob.setBounds(200,160,200,30);
		dob.setBackground(new Color(150,150,140));
		srch.add(dob);

		JLabel lblmno=new JLabel("Mobile Number");
		lblmno.setForeground(Color.WHITE);
		lblmno.setBounds(30,200,200,40);
		lblmno.setFont(f1);
		srch.add(lblmno);

		JTextField mbno=new JTextField("");
		mbno.setBounds(200,200,200,30);
		mbno.setBackground(new Color(150,150,140));
		srch.add(mbno);

		JLabel lblmail=new JLabel("Email");
		lblmail.setForeground(Color.WHITE);
		lblmail.setBounds(30,240,200,40);
		lblmail.setFont(f1);
		srch.add(lblmail);

		JTextField email=new JTextField("");
		email.setBounds(200,240,200,30);
		email.setBackground(new Color(150,150,140));
		srch.add(email);

		JLabel lbladr=new JLabel("Address ");
		lbladr.setForeground(Color.WHITE);
		lbladr.setBounds(30,280,200,40);
		lbladr.setFont(f1);
		srch.add(lbladr);

		JTextArea address=new JTextArea("");
		address.setBounds(200,280,200,60);
		address.setBackground(new Color(150,150,140));
		srch.add(address);

		JLabel lbldep=new JLabel("Department ");
		lbldep.setForeground(Color.WHITE);
		lbldep.setBounds(30,350,200,40);
		lbldep.setFont(f1);
		srch.add(lbldep);

		JTextField department=new JTextField("");
		department.setBounds(200,350,200,30);
		department.setBackground(new Color(150,150,140));
		srch.add(department);

		JLabel lblsal=new JLabel("Salary ");
		lblsal.setForeground(Color.WHITE);
		lblsal.setBounds(30,390,200,40);
		lblsal.setFont(f1);
		srch.add(lblsal);

		JTextField salary=new JTextField("");
		salary.setBounds(200,390,200,30);
		salary.setBackground(new Color(150,150,140));
		srch.add(salary);

		JLabel lbljt=new JLabel("Job Title ");
		lbljt.setForeground(Color.WHITE);
		lbljt.setBounds(30,430,200,40);
		lbljt.setFont(f1);
		srch.add(lbljt);

		JTextField jbtitle=new JTextField("");
		jbtitle.setBounds(200,430,200,30);
		jbtitle.setBackground(new Color(150,150,140));
		srch.add(jbtitle);

		JLabel lbldh=new JLabel("Date Hired");
		lbldh.setForeground(Color.WHITE);
		lbldh.setBounds(30,470,200,40);
		lbldh.setFont(f1);
		srch.add(lbldh);

		JTextField date=new JTextField("");
		date.setBounds(200,470,200,30);
		date.setBackground(new Color(150,150,140));
		srch.add(date);

		jc=new JComboBox();
		jc.setBounds(200,40,200,30);
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
						long mno=rs.getLong(6);
						String mail=rs.getString(5);
						String adrs=rs.getString(7);
						String dep=rs.getString(8);
						String jbt=rs.getString(9);
						float sal=rs.getFloat(12);
						String hd=rs.getString(13);

						fname.setText(fnm);
						sname.setText(snm);
						dob.setText(dt);
						email.setText(mail);
						mbno.setText(Long.toString(mno));
						address.setText(adrs);
						department.setText(dep);
						jbtitle.setText(jbt);
						salary.setText(Float.toString(sal));
						date.setText(hd);
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
		srch.add(jc);

		JButton sign=new JButton(" Update ");
		sign.setBounds(70,535,125,40);
		srch.add(sign);
		sign.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try{
					String fnm=fname.getText();
					String snm=sname.getText();
					String dt=dob.getText();
					long mno=Long.parseLong(mbno.getText());
					String mail=email.getText();
					String adrs=address.getText();
					String dep=department.getText();
					String jbt=jbtitle.getText();
					float sal=Float.parseFloat(salary.getText());
					String hd=date.getText();
					int flag=0;
					Connection con=DBConnection.getConnection();
					PreparedStatement stmt=con.prepareStatement("update staff_info set fname=?, sname=?, dob=?, email=?, mbno=?, address=?, department=?, jbtitle=?, salary=?, hire_date=? where id =?");
					stmt.setString(1,fnm);
					stmt.setString(2,snm);
					stmt.setString(3,dt);
					stmt.setString(4,mail);
					stmt.setLong(5,mno);
					stmt.setString(6,adrs);
					stmt.setString(7,dep);
					stmt.setString(8,jbt);
					stmt.setFloat(9,sal);
					stmt.setString(10,hd);
					stmt.setInt(11,empid);

					int i=stmt.executeUpdate();
					if(i!=0)
						flag++;
					if(flag==1)
					{
						JOptionPane.showMessageDialog(new JFrame(),"Record Updated Successfully..");
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

		JButton canc=new JButton(" Delete ");
		canc.setBounds(230,535,125,40);
		//canc.setBackground(new Color(200,180,200));
		canc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try{
					int flag=0;
					Connection con=DBConnection.getConnection();
					PreparedStatement stmt=con.prepareStatement("DELETE from staff_info where id =?");
					stmt.setInt(1,empid);
					int i=stmt.executeUpdate();
					if(i!=0)
						flag++;
					if(flag==1)
					{
						JOptionPane.showMessageDialog(new JFrame(),"Record Deleted Successfully..");
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
		srch.add(canc);

		background.add(srch);
		background.add(heading);
		background.setBounds(0,0,800,1600);
		add(background);
		setJMenuBar(mb);

		setVisible(true);
		}
}