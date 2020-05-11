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
class Index extends JFrame
{
	JMenu menu,menu2,menu1,menu3;
	JMenuItem i1,i2,i3,i4,i5,i6;
	public Index()
	{
		super("Home Page");

		setSize(800,500);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//background
		ImageIcon background_image=new ImageIcon("10.jpg");
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(800,500,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		JLabel background=new JLabel("",background_image,JLabel.CENTER);

		//menu
		JMenuBar mb=new JMenuBar();
		menu1=new JMenu("Home");
		menu=new JMenu("Reports");
		menu3=new JMenu("Logout");
		//i1=new JMenuItem("RP");
		i2=new JMenuItem("Total Allowance RP");
		i3=new JMenuItem("Total Deduction RP");
		i5=new JMenuItem("Home Page");
		i6=new JMenuItem("Log out");
		menu1.add(i5);
		//menu.add(i1);
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

		Font f=new Font("VERDANA",Font.BOLD,30);
		JPanel heading;
		heading=new JPanel();
		heading.setBackground(new Color(0,0,0,100));
		heading.setBounds(0,0,800,70);

		Font f1=new Font("Rockwell Condensed",Font.BOLD,18);
		JLabel name=new JLabel("Payroll Management System ");
		name.setForeground(Color.WHITE);
		//name.setBounds(200,150,800,100);
		name.setFont(f);
		heading.add(name);

		JPanel login=new JPanel();
		login.setLayout(null);
		login.setSize(400,350);
		login.setBackground(new Color(0,0,0,60));
		login.setBounds(150,100,450,250);      //from left,from top,width,height

		JButton emng=new JButton(" Employee Manager ");
		emng.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				new Registration();
			}
		});
		emng.setBounds(50,40,150,40);
		//sign.setBackground(new Color(200,180,200));
		login.add(emng);

		JButton srch=new JButton(" Search ");
		srch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				//dispose();
				new Search();
			}
		});
		srch.setBounds(250,40,150,40);
		//srch.setBackground(new Color(200,180,200));
		login.add(srch);

		JButton alw=new JButton(" Allowance ");
		alw.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				//dispose();
				new Allowance();
			}
		});
		alw.setBounds(50,90,150,40);
		//srch.setBackground(new Color(200,180,200));
		login.add(alw);

		JButton upd=new JButton(" Update Salary ");
		upd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				//dispose();
				new Updsal();
			}
		});
		upd.setBounds(250,90,150,40);
		//srch.setBackground(new Color(200,180,200));
		login.add(upd);

		JButton ded=new JButton(" Deduction ");
		ded.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				new Deduction();
			}
		});
		ded.setBounds(50,140,150,40);
		login.add(ded);

		JButton pmnt=new JButton(" Payment ");
		pmnt.setBounds(250,140,150,40);
		pmnt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				dispose();
				new Payment();
			}
		});
		ded.setBounds(50,140,150,40);
		login.add(pmnt);

		background.add(login);
		background.add(heading);
		setJMenuBar(mb);
		setSize(800,500);
		background.setBounds(0,0,800,500);
		add(background);

		setVisible(true);
	}
}