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
class Admin extends JFrame
{
	JButton button;
	JLabel label;
	JMenu menu,menu2,menu1,menu3;
	JMenuItem i1,i2,i3,i4,i5,i6;
	public Admin()
	{
		super("Admin");

		setSize(800,700);
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
		menu1=new JMenu("Logout");
		i1=new JMenuItem("Log out");
		menu1.add(i1);
		mb.add(menu1);
		i1.addActionListener(new ActionListener()
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
		JLabel name=new JLabel(" Admin ");
		name.setForeground(Color.WHITE);
		//name.setBounds(200,150,800,100);
		name.setFont(f);
		heading.add(name);

		JPanel pmnt=new JPanel();
		pmnt.setLayout(null);
		pmnt.setSize(400,350);
		pmnt.setBackground(new Color(0,0,0,80));
		pmnt.setBounds(150,100,500,400);     //from left,from top,width,height

		JLabel lblrph=new JLabel("Rate Per Hour ");
		lblrph.setForeground(Color.WHITE);
		lblrph.setBounds(30,40,200,30);
		lblrph.setFont(f1);
		pmnt.add(lblrph);

		JTextField rph=new JTextField("");
		rph.setBounds(200,40,200,30);
		rph.setBackground(new Color(150,150,140));
		pmnt.add(rph);

		JLabel lblbs=new JLabel("Bonus");
		lblbs.setForeground(Color.WHITE);
		lblbs.setBounds(30,80,200,40);
		lblbs.setFont(f1);
		pmnt.add(lblbs);

		JTextField bonus=new JTextField("");
		bonus.setBounds(200,80,200,30);
		bonus.setBackground(new Color(150,150,140));
		pmnt.add(bonus);

		JLabel lblpf=new JLabel("Provident Fund");
		lblpf.setForeground(Color.WHITE);
		lblpf.setBounds(30,120,200,40);
		lblpf.setFont(f1);
		pmnt.add(lblpf);

		JTextField pf=new JTextField("");
		pf.setBounds(200,120,200,30);
		pf.setBackground(new Color(150,150,140));
		pmnt.add(pf);

		JLabel lblhra=new JLabel("HRA");
		lblhra.setForeground(Color.WHITE);
		lblhra.setBounds(30,160,200,40);
		lblhra.setFont(f1);
		pmnt.add(lblhra);

		JTextField hra=new JTextField("");
		hra.setBounds(200,160,200,30);
		hra.setBackground(new Color(150,150,140));
		pmnt.add(hra);

		JLabel lbllv=new JLabel("Leave");
		lbllv.setForeground(Color.WHITE);
		lbllv.setBounds(30,200,200,40);
		lbllv.setFont(f1);
		pmnt.add(lbllv);

		JTextField maxl=new JTextField("");
		maxl.setBounds(200,200,200,30);
		maxl.setBackground(new Color(150,150,140));
		pmnt.add(maxl);

		JLabel lblmd=new JLabel("Medical ");
		lblmd.setForeground(Color.WHITE);
		lblmd.setBounds(30,240,200,40);
		lblmd.setFont(f1);
		pmnt.add(lblmd);

		JTextField medical=new JTextField("");
		medical.setBounds(200,240,200,30);
		medical.setBackground(new Color(150,150,140));
		pmnt.add(medical);

		JLabel lblce=new JLabel("Child Education ");
		lblce.setForeground(Color.WHITE);
		lblce.setBounds(30,280,200,40);
		lblce.setFont(f1);
		pmnt.add(lblce);

		JTextField ce=new JTextField("");
		ce.setBounds(200,280,200,30);
		ce.setBackground(new Color(150,150,140));
		pmnt.add(ce);

		JButton sign=new JButton(" ADD  ");
		sign.setBounds(90,330,280,40);
		//sign.setBackground(new Color(200,180,200));
		pmnt.add(sign);

		sign.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try{
					float rh=Float.parseFloat(rph.getText());
					float bn=Float.parseFloat(bonus.getText());
					float pfund=Float.parseFloat(pf.getText());
					float hr=Float.parseFloat(hra.getText());
					int lv=Integer.parseInt(maxl.getText());
					float medi=Float.parseFloat(medical.getText());
					float ced=Float.parseFloat(ce.getText());

					int flag=0;
					Connection con=DBConnection.getConnection();
					PreparedStatement stmt=con.prepareStatement("Update calc_rate set rph=?,bonus=?,pf=?,hra=?,maxl=?,medical=?,ce=? where id=1");
					stmt.setFloat(1,rh);
					stmt.setFloat(2,bn);
					stmt.setFloat(3,pfund);
					stmt.setFloat(4,hr);
					stmt.setInt(5,lv);
					stmt.setFloat(6,medi);
					stmt.setFloat(7,ced);
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

		background.add(pmnt);
			background.add(heading);
			background.setBounds(0,0,800,1500);
			add(background);
			setJMenuBar(mb);

			setVisible(true);
		}
}
