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
class Login extends JFrame
{
	public Login()
	{
		setSize(800,500);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//background
		ImageIcon background_image=new ImageIcon("th.jpg");
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(800,500,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		JLabel background=new JLabel("",background_image,JLabel.CENTER);

		//header
		Font f=new Font("VERDANA",Font.BOLD,30);
		JPanel heading;
		heading=new JPanel();
		heading.setBackground(new Color(0,0,0,100));
		heading.setBounds(0,0,800,70);

		Font f1=new Font("Rockwell Condensed",Font.BOLD,30);

		JLabel name=new JLabel("Login");
		name.setForeground(Color.WHITE);
		name.setFont(f1);
		heading.add(name);

		JPanel login=new JPanel();
		login.setLayout(null);

		login.setSize(400,350);
		login.setBackground(new Color(0,0,0,60));
		login.setBounds(200,100,400,300);      //from left,from top,width,height

		JLabel username=new JLabel("Username ");
		username.setForeground(Color.WHITE);
		username.setBounds(30,40,200,40);
		username.setFont(f1);
		login.add(username);

		JTextField uname=new JTextField("");
		uname.setBounds(170,40,200,40);
		login.add(uname);

		JLabel lblpwd=new JLabel("Password ");
		lblpwd.setForeground(Color.WHITE);
		lblpwd.setBounds(30,100,200,40);
		lblpwd.setFont(f1);
		login.add(lblpwd);

		JPasswordField password=new JPasswordField("");
		password.setBounds(170,100,200,40);
		login.add(password);

		JButton sign=new JButton(" Login ");
		sign.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try{
					String unm=uname.getText();
					String pwd=password.getText();
					int flag=0;
					if(unm.equals("admin") && pwd.equals("admin"))
						flag=2;
					Statement stmt=DBConnection.getConnection().createStatement();
					ResultSet rs=stmt.executeQuery("select * from users");
					while(rs.next())
					{
						String unm1=rs.getString(2);
						String pswd=rs.getString(3);
						if(unm1.equals(unm) && pswd.equals(pwd))
							flag=1;
					}
					if(flag==1)
					{
						dispose();
						new Index();
					}
					else if(flag==2)
					{
						dispose();
						new Admin();
					}
					else
						JOptionPane.showMessageDialog(new JFrame(),"Login Failed..");
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}

				}
		});
		sign.setBounds(70,200,100,40);
		login.add(sign);

		JButton reg=new JButton(" Clear ");
		reg.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e)
			{
				uname.setText("");
				password.setText("");
			}
		});
		reg.setBounds(220,200,120,40);
		login.add(reg);

		background.add(login);
		background.add(heading);
		background.setBounds(0,0,800,500);
		add(background);

		setVisible(true);
	}
	public static void main(String a[])
	{
		new Login();
	}
}