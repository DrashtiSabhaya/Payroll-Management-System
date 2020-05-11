import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.lang.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.*;
class Registration extends JFrame
{
	JButton button;
	JLabel label;
	JMenu menu,menu1,menu3;
	JMenuItem i1,i2,i3,i4,i5,i6;
	String s;
	public Registration()
	{
		super("Registration");

		setSize(800,800);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//background
		ImageIcon background_image=new ImageIcon("1.jpg");
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(800,1700,Image.SCALE_SMOOTH);
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
		heading.setBackground(new Color(0,0,0,80));
		heading.setBounds(0,0,800,70);

		Font f1=new Font("Rockwell Condensed",Font.BOLD,18);

		JLabel name=new JLabel("Registration");
		name.setForeground(Color.WHITE);
		//name.setBounds(200,150,800,100);
		name.setFont(f);
		heading.add(name);

		JPanel registration=new JPanel();
		registration.setLayout(null);
		registration.setSize(400,550);
		registration.setBackground(new Color(0,0,0,60));
		registration.setBounds(65,100,650,570);      //from left,from top,width,height

		JLabel lblid=new JLabel("Id ");
		lblid.setForeground(Color.WHITE);
		lblid.setBounds(30,40,200,40);
		lblid.setFont(f1);
		registration.add(lblid);

		JTextField id=new JTextField("");
		id.setBounds(150,40,200,30);
		id.setBackground(new Color(150,150,140));
		registration.add(id);

		JLabel lblfnm=new JLabel("First Name ");
		lblfnm.setForeground(Color.WHITE);
		lblfnm.setBounds(30,80,200,40);
		lblfnm.setFont(f1);
		registration.add(lblfnm);

		JTextField fname=new JTextField("");
		fname.setBounds(150,80,200,30);
		fname.setBackground(new Color(150,150,140));
		registration.add(fname);

		JLabel lblsnm=new JLabel("Surname ");
		lblsnm.setForeground(Color.WHITE);
		lblsnm.setBounds(30,120,200,40);
		lblsnm.setFont(f1);
		registration.add(lblsnm);

		JTextField sname=new JTextField("");
		sname.setBounds(150,120,200,30);
		sname.setBackground(new Color(150,150,140));
		registration.add(sname);

		button=new JButton("Browse");
		button.setBounds(500,140,200,30);
		label=new JLabel();
		label.setBounds(400,120,200,200);
		add(button);
		File selectdFile;
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","gif","png");
				fileChooser.addChoosableFileFilter(filter);
				int result=fileChooser.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION)
				{
					File selectdFile = fileChooser.getSelectedFile();
					String path=selectdFile.getAbsolutePath();
					label.setIcon(ResizeImage(path));
					s=path;
				}
				else if(result==JFileChooser.CANCEL_OPTION)
				{
					System.out.println("No File Choosen");
				}
			}
	});
	registration.add(label);

	JLabel lbldob=new JLabel("Date of Birth ");
	lbldob.setForeground(Color.WHITE);
	lbldob.setBounds(30,160,200,40);
	lbldob.setFont(f1);
	registration.add(lbldob);

	JTextField dob=new JTextField("");
	dob.setBounds(150,160,200,30);
	dob.setBackground(new Color(150,150,140));
	registration.add(dob);

	JLabel lblmail=new JLabel("Email ");
	lblmail.setForeground(Color.WHITE);
	lblmail.setBounds(30,200,200,40);
	lblmail.setFont(f1);
	registration.add(lblmail);

	JTextField email=new JTextField("");
	email.setBounds(150,200,200,30);
	email.setBackground(new Color(150,150,140));
	registration.add(email);

	JLabel lblmno=new JLabel("Mobile Number");
	lblmno.setForeground(Color.WHITE);
	lblmno.setBounds(30,240,200,40);
	lblmno.setFont(f1);
	registration.add(lblmno);

	JTextField mbno=new JTextField("");
	mbno.setBounds(150,240,200,30);
	mbno.setBackground(new Color(150,150,140));
	registration.add(mbno);

	JLabel lbladr=new JLabel("Address ");
	lbladr.setForeground(Color.WHITE);
	lbladr.setBounds(30,280,200,40);
	lbladr.setFont(f1);
	registration.add(lbladr);

	JTextArea address=new JTextArea("");
	address.setBounds(150,280,200,50);
	address.setBackground(new Color(150,150,140));
	registration.add(address);

	JLabel lbldep=new JLabel("Department ");
	lbldep.setForeground(Color.WHITE);
	lbldep.setBounds(30,340,200,40);
	lbldep.setFont(f1);
	registration.add(lbldep);

	JTextField department=new JTextField("");
	department.setBounds(150,340,200,30);
	department.setBackground(new Color(150,150,140));
	registration.add(department);

	ButtonGroup btn=new ButtonGroup();
	JRadioButton fm=new JRadioButton("Female",true);
	fm.setBounds(30,390,130,30);
	JRadioButton m=new JRadioButton("Male",false);
	m.setBounds(200,390,150,30);
	btn.add(fm);
	btn.add(m);
	registration.add(fm);
	registration.add(m);

	JLabel lblsal=new JLabel("Salary");
	lblsal.setForeground(Color.WHITE);
	lblsal.setBounds(30,440,200,40);
	lblsal.setFont(f1);
	registration.add(lblsal);

	JTextField salary=new JTextField("");
	salary.setBounds(150,440,200,30);
	salary.setBackground(new Color(150,150,140));
	registration.add(salary);

	JLabel lblhd=new JLabel("Hired Date");
	lblhd.setForeground(Color.WHITE);
	lblhd.setBounds(380,340,100,40);
	lblhd.setFont(f1);
	registration.add(lblhd);

	JTextField hire_dt=new JTextField("");
	hire_dt.setBounds(470,340,150,30);
	hire_dt.setBackground(new Color(150,150,140));
	registration.add(hire_dt);

	JLabel lbljob=new JLabel("Job Title ");
	lbljob.setForeground(Color.WHITE);
	lbljob.setBounds(380,390,100,40);
	lbljob.setFont(f1);
	registration.add(lbljob);

	JTextField jbtitle=new JTextField("");
	jbtitle.setBounds(470,390,150,30);
	jbtitle.setBackground(new Color(150,150,140));
	registration.add(jbtitle);

	JButton sign=new JButton(" ADD RECOED ");
	sign.setBounds(150,500,125,40);
	//sign.setBackground(new Color(200,180,200));
	registration.add(sign);

	sign.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			try{
					int id1=Integer.parseInt(id.getText());
					String fnm=fname.getText();
					String snm=sname.getText();
					String db=dob.getText();
					String mail=email.getText();
					long mno=Long.parseLong(mbno.getText());
					String adrs=address.getText();
					String dep=department.getText();
					String jbt=jbtitle.getText();
					InputStream is=new FileInputStream(new File(s));
					String hd=hire_dt.getText();

					String gen;
					if(m.isSelected())
						gen="Male";
					else
						gen="Female";
					float sal=Float.parseFloat(salary.getText());
					int flag=0;
					Connection con=DBConnection.getConnection();
					PreparedStatement stmt=con.prepareStatement("insert into staff_info values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
					stmt.setInt(1,id1);
					stmt.setString(2,fnm);
					stmt.setString(3,snm);
					stmt.setString(4,db);
					stmt.setString(5,mail);
					stmt.setLong(6,mno);
					stmt.setString(7,adrs);
					stmt.setString(8,dep);
					stmt.setString(9,jbt);
					stmt.setBlob(10,is);
					stmt.setString(11,gen);
					stmt.setFloat(12,sal);
					stmt.setString(13,hd);
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

		JButton canc=new JButton(" CLEAR ");
		canc.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
						fname.setText(null);
				}
		});
		canc.setBounds(350,500,125,40);
		registration.add(canc);

		background.add(registration);
		background.add(heading);
		background.setBounds(0,0,800,1700);
		add(background);
		setJMenuBar(mb);
		setVisible(true);
	}

	ImageIcon ResizeImage(String ImagePath)
	{
		ImageIcon MyImage=new ImageIcon(ImagePath);
		Image img=MyImage.getImage();
		Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image=new ImageIcon(newImg);
		return image;
	}
}