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
class Deduction extends JFrame
{
	int empid;
	JComboBox jc;
	JButton button;
	JLabel label;
	JMenu menu,menu2,menu1,menu3;
	JMenuItem i1,i2,i3,i4,i5,i6;

	public Deduction()
	{
		super("Deduction");

		setSize(800,1600);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//background
		ImageIcon background_image=new ImageIcon("2.jpg");
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

		JLabel name=new JLabel("Deduction");
		name.setForeground(Color.WHITE);
		//name.setBounds(200,150,800,100);
		name.setFont(f);
		heading.add(name);

		JPanel deduction=new JPanel();
		deduction.setLayout(null);
		deduction.setSize(400,350);
		deduction.setBackground(new Color(0,0,0,100));
		deduction.setBounds(150,85,500,570);     //from left,from top,width,height

		JLabel lbleid=new JLabel("Select ID ");
		lbleid.setForeground(Color.WHITE);
		lbleid.setBounds(30,40,150,40);
		lbleid.setFont(f1);
		deduction.add(lbleid);

		JLabel lblfnm=new JLabel("First Name");
		lblfnm.setForeground(Color.WHITE);
		lblfnm.setBounds(30,80,200,40);
		lblfnm.setFont(f1);
		deduction.add(lblfnm);

		JTextField fname=new JTextField("");
		fname.setBounds(200,80,240,30);
		fname.setBackground(new Color(150,150,140));
		deduction.add(fname);

		JLabel lblsnm=new JLabel("Surname ");
		lblsnm.setForeground(Color.WHITE);
		lblsnm.setBounds(30,120,200,40);
		lblsnm.setFont(f1);
		deduction.add(lblsnm);

		JTextField sname=new JTextField("");
		sname.setBounds(200,120,240,30);
		sname.setBackground(new Color(150,150,140));
		deduction.add(sname);

		JLabel lbldob=new JLabel("Date of Birth ");
		lbldob.setForeground(Color.WHITE);
		lbldob.setBounds(30,160,200,40);
		lbldob.setFont(f1);
		deduction.add(lbldob);

		JTextField dob=new JTextField("");
		dob.setBounds(200,160,240,30);
		dob.setBackground(new Color(150,150,140));
		deduction.add(dob);

		JLabel lbldep=new JLabel("Department ");
		lbldep.setForeground(Color.WHITE);
		lbldep.setBounds(30,200,200,40);
		lbldep.setFont(f1);
		deduction.add(lbldep);

		JTextField department=new JTextField("");
		department.setBounds(200,200,240,30);
		department.setBackground(new Color(150,150,140));
		deduction.add(department);

		JLabel lblsal=new JLabel("Salary ");
		lblsal.setForeground(Color.WHITE);
		lblsal.setBounds(30,240,200,40);
		lblsal.setFont(f1);
		deduction.add(lblsal);

		JTextField salary=new JTextField("");
		salary.setBounds(200,240,240,30);
		salary.setBackground(new Color(150,150,140));
		deduction.add(salary);

		JLabel lbldth=new JLabel("Date Hired");
		lbldth.setForeground(Color.WHITE);
		lbldth.setBounds(30,285,200,40);
		lbldth.setFont(f1);
		deduction.add(lbldth);

		JTextField datehire=new JTextField("");
		datehire.setBounds(120,285,120,30);
		datehire.setBackground(new Color(150,150,140));
		deduction.add(datehire);

		JLabel lbljbtitle=new JLabel("Job Title ");
		lbljbtitle.setForeground(Color.WHITE);
		lbljbtitle.setBounds(250,285,200,40);
		lbljbtitle.setFont(f1);
		deduction.add(lbljbtitle);

		JTextField jbtitle=new JTextField("");
		jbtitle.setBounds(320,285,120,30);
		jbtitle.setBackground(new Color(150,150,140));
		deduction.add(jbtitle);

		JLabel lblptax=new JLabel("P Tax");
		lblptax.setForeground(Color.WHITE);
		lblptax.setBounds(30,325,200,40);
		lblptax.setFont(f1);
		deduction.add(lblptax);

		JTextField ptax=new JTextField("");
		ptax.setBounds(120,325,120,30);
		ptax.setBackground(new Color(150,150,140));
		deduction.add(ptax);

		JLabel lblleave=new JLabel("Leaves");
		lblleave.setForeground(Color.WHITE);
		lblleave.setBounds(250,325,200,40);
		lblleave.setFont(f1);
		deduction.add(lblleave);

		JTextField leave=new JTextField("");
		leave.setBounds(320,325,120,30);
		leave.setBackground(new Color(150,150,140));
		deduction.add(leave);

		JLabel lblrsn=new JLabel("Reason ");
		lblrsn.setForeground(Color.WHITE);
		lblrsn.setBounds(30,370,200,40);
		lblrsn.setFont(f1);
		deduction.add(lblrsn);

		JTextField reason=new JTextField("");
		reason.setBounds(200,370,240,30);
		reason.setBackground(new Color(150,150,140));
		deduction.add(reason);

		JLabel lbltotded=new JLabel("Total Deduction ");
		lbltotded.setForeground(Color.WHITE);
		lbltotded.setBounds(30,410,200,40);
		lbltotded.setFont(f1);
		deduction.add(lbltotded);

		JTextField totded=new JTextField("");
		totded.setBounds(200,410,240,30);
		totded.setBackground(new Color(150,150,140));
		deduction.add(totded);

		JLabel lblsalded=new JLabel("Salary After Deduction");
		lblsalded.setForeground(Color.WHITE);
		lblsalded.setBounds(30,450,200,40);
		lblsalded.setFont(f1);
		deduction.add(lblsalded);

		JTextField salded=new JTextField("");
		salded.setBounds(200,450,240,30);
		salded.setBackground(new Color(150,150,140));
		deduction.add(salded);


		jc=new JComboBox();
		jc.setBounds(200,40,240,30);
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
						String dep=rs.getString(8);
						String jbt=rs.getString(9);
						float sal=rs.getFloat(12);
						String hd=rs.getString(13);

						fname.setText(fnm);
						sname.setText(snm);
						dob.setText(dt);
						department.setText(dep);
						jbtitle.setText(jbt);
						salary.setText(Float.toString(sal));
						datehire.setText(hd);
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
		deduction.add(jc);

		JButton calc=new JButton(" Calculate ");
		calc.setBounds(110,500,125,40);
		calc.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try{
					int lv=Integer.parseInt(leave.getText());
					float sal=Float.parseFloat(salary.getText());

					Statement stmt=DBConnection.getConnection().createStatement();
					ResultSet rs=stmt.executeQuery("select * from calc_rate where id = 1");
					if(rs.next())
					{
						float rh=rs.getFloat(2);
						int max=rs.getInt(6);
						int l;
						if(max>lv)
							l=0;
						else
							l=lv-max;
						System.out.println("l ="+l);

						float taxa=(sal/2);

						float taxp=0;
						if(taxa<6000)
							taxp=0;
						else if(taxa>=6000 && taxa<9000)
							taxp=80;
						else if(taxa>=9000 && taxa<12000)
							taxp=150;
						else if(taxa>=12000)
							taxp=200;

						float la=((sal*rh)/100)*l;

						float tot=taxp+la;
						ptax.setText(Float.toString(taxp));
						totded.setText(Float.toString(tot));
						salded.setText(Float.toString(sal-tot));
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
		deduction.add(calc);

		JButton save=new JButton(" Save ");
		save.setBounds(270,500,125,40);
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try{
						String fnm=fname.getText();
						String snm=sname.getText();
						float taxp=Float.parseFloat(ptax.getText());
						float sal=Float.parseFloat(salary.getText());
						int lv=Integer.parseInt(leave.getText());
						float ded=Float.parseFloat(totded.getText());
						String rsn=reason.getText();

						int flag=0;
						Connection con=DBConnection.getConnection();
						PreparedStatement stmt=con.prepareStatement("insert into deduction(fname,sname,salary,ptax,leaves,deduction_amt,reason,emp_id) values(?,?,?,?,?,?,?,?)");
						stmt.setString(1,fnm);
						stmt.setString(2,snm);
						stmt.setFloat(3,sal);
						stmt.setFloat(4,taxp);
						stmt.setInt(5,lv);
						stmt.setFloat(6,ded);
						stmt.setString(7,rsn);
						stmt.setInt(8,empid);
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
		deduction.add(save);

		background.add(deduction);
		background.add(heading);
		background.setBounds(0,0,800,1600);
		add(background);
		setJMenuBar(mb);

		setVisible(true);
	}
}