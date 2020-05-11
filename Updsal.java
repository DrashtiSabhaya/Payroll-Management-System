import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.lang.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.util.Date;
import java.text.*;
class Updsal extends JFrame
{
	JButton button;
	JComboBox jc;
	JLabel label;
	int empid;
	JMenu menu,menu2,menu1,menu3;
	JMenuItem i1,i2,i3,i4,i5,i6;
	public Updsal()
	{
		super("Update Salary");

		setSize(800,1500);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//background
		ImageIcon background_image=new ImageIcon("2.jpg");
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(800,1500,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		JLabel background=new JLabel("",background_image,JLabel.CENTER);

		//menu
		JMenuBar mb=new JMenuBar();
		menu1=new JMenu("Home");
		menu=new JMenu("Reports");
		menu2=new JMenu("Audit");
		menu3=new JMenu("Logout");
		i2=new JMenuItem("Total Allowance RP");
		i3=new JMenuItem("Total Deduction RP");
		i4=new JMenuItem("Audit Trial");
		i5=new JMenuItem("Home Page");
		i6=new JMenuItem("Log out");
		menu1.add(i5);
		menu.add(i2);
		menu.add(i3);
		menu2.add(i4);
		menu3.add(i6);
		mb.add(menu1);
		mb.add(menu);
		mb.add(menu2);
		mb.add(menu3);

		i5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				new Index();
			}
		});
		i6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				new Login();
			}
		});

		//header
		Font f=new Font("VERDANA",Font.BOLD,30);
		JPanel heading;
		heading=new JPanel();
		heading.setBackground(new Color(0,0,0,80));
		heading.setBounds(0,0,800,70);

		Font f1=new Font("Rockwell Condensed",Font.BOLD,18);
		JLabel name=new JLabel(" Update Salary");
		name.setForeground(Color.WHITE);
		//name.setBounds(200,150,800,100);
		name.setFont(f);
		heading.add(name);

		JPanel upsal=new JPanel();
		upsal.setLayout(null);
		upsal.setSize(400,350);
		upsal.setBackground(new Color(0,0,0,60));
		upsal.setBounds(200,100,500,425);     //from left,from top,width,height

		JLabel lbleid=new JLabel("Select ID  ");
		lbleid.setForeground(Color.WHITE);
		lbleid.setBounds(30,40,150,40);
		lbleid.setFont(f1);
		upsal.add(lbleid);

		JLabel lblfnm=new JLabel("First Name");
		lblfnm.setForeground(Color.WHITE);
		lblfnm.setBounds(30,80,200,40);
		lblfnm.setFont(f1);
		upsal.add(lblfnm);

		JTextField fname=new JTextField("");
		fname.setBounds(200,80,200,30);
		fname.setBackground(new Color(150,150,140));
		upsal.add(fname);

		JLabel lblsnm=new JLabel("SurName");
		lblsnm.setForeground(Color.WHITE);
		lblsnm.setBounds(30,120,200,40);
		lblsnm.setFont(f1);
		upsal.add(lblsnm);

		JTextField sname=new JTextField("");
		sname.setBounds(200,120,200,30);
		sname.setBackground(new Color(150,150,140));
		upsal.add(sname);

		JLabel lbldb=new JLabel("Date of Birth");
		lbldb.setForeground(Color.WHITE);
		lbldb.setBounds(30,160,200,40);
		lbldb.setFont(f1);
		upsal.add(lbldb);

		JTextField dob=new JTextField("");
		dob.setBounds(200,160,200,30);
		dob.setBackground(new Color(150,150,140));
		upsal.add(dob);

		JLabel lbldep=new JLabel("Department");
		lbldep.setForeground(Color.WHITE);
		lbldep.setBounds(30,200,200,40);
		lbldep.setFont(f1);
		upsal.add(lbldep);

		JTextField department=new JTextField("");
		department.setBounds(200,200,200,30);
		department.setBackground(new Color(150,150,140));
		upsal.add(department);

		JLabel lblsal=new JLabel("Salary ");
		lblsal.setForeground(Color.WHITE);
		lblsal.setBounds(30,240,200,40);
		lblsal.setFont(f1);
		upsal.add(lblsal);

		JTextField salary=new JTextField("");
		salary.setBounds(200,240,200,30);
		salary.setBackground(new Color(150,150,140));
		upsal.add(salary);

		JLabel lblupsal=new JLabel("Updated salary by %");
		lblupsal.setForeground(Color.WHITE);
		lblupsal.setBounds(30,280,200,40);
		lblupsal.setFont(f1);
		upsal.add(lblupsal);

		JTextField usalary=new JTextField("");
		usalary.setBounds(200,280,200,30);
		usalary.setBackground(new Color(150,150,140));
		upsal.add(usalary);


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
		upsal.add(jc);
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
		}
		);

		JButton update=new JButton(" Update ");
		update.setBounds(50,330,300,40);
		//sign.setBackground(new Color(200,180,200));
		update.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try{
					float up=Float.parseFloat(usalary.getText());
					float sal=Float.parseFloat(salary.getText());
					float upsal=((up*sal)/100)+sal;
					int flag=0;
					Connection con=DBConnection.getConnection();
					PreparedStatement stmt=con.prepareStatement("update staff_info set salary=? where id=?");
					stmt.setFloat(1,upsal);
					stmt.setInt(2,empid);
					int i=stmt.executeUpdate();
					if(i!=0)
						flag++;
					if(flag==1)
					{
						JOptionPane.showMessageDialog(new JFrame(),"Salary Updated Successfully..");
						usalary.setText("");
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
		upsal.add(update);

		background.add(upsal);
		background.add(heading);
		background.setBounds(0,0,800,1500);
		add(background);
		setJMenuBar(mb);

		setVisible(true);
	}
}