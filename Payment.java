import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.lang.*;
import java.sql.SQLException;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.*;
import java.io.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.*;
import java.awt.event.*;
class Payment extends JFrame
{
	int empid;
	JComboBox jc;
	JButton button;
	JLabel label;
	JMenu menu,menu2,menu1,menu3;
	JMenuItem i1,i2,i3,i4,i5,i6;
	public Payment()
	{
		super("Payment");

		setSize(800,600);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//background
		ImageIcon background_image=new ImageIcon("2.jpg");
		Image img=background_image.getImage();
		Image temp_img=img.getScaledInstance(800,1500,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		JLabel background=new JLabel("",background_image,JLabel.CENTER);

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
		JLabel name=new JLabel(" Payment");
		name.setForeground(Color.WHITE);
		//name.setBounds(200,150,800,100);
		name.setFont(f);
		heading.add(name);

		JPanel pmnt=new JPanel();
		pmnt.setLayout(null);
		pmnt.setSize(400,350);
		pmnt.setBackground(new Color(0,0,0,60));
		pmnt.setBounds(200,100,500,425);     //from left,from top,width,height

		JLabel lbleid=new JLabel("Select ID  ");
		lbleid.setForeground(Color.WHITE);
		lbleid.setBounds(30,40,150,40);
		lbleid.setFont(f1);
		pmnt.add(lbleid);


		JLabel lblfnm=new JLabel("First Name");
		lblfnm.setForeground(Color.WHITE);
		lblfnm.setBounds(30,80,200,40);
		lblfnm.setFont(f1);
		pmnt.add(lblfnm);

		JTextField fname=new JTextField("");
		fname.setBounds(200,80,200,30);
		fname.setBackground(new Color(150,150,140));
		pmnt.add(fname);

		JLabel lblsnm=new JLabel("surname");
		lblsnm.setForeground(Color.WHITE);
		lblsnm.setBounds(30,120,200,40);
		lblsnm.setFont(f1);
		pmnt.add(lblsnm);

		JTextField sname=new JTextField("");
		sname.setBounds(200,120,200,30);
		sname.setBackground(new Color(150,150,140));
		pmnt.add(sname);

		JLabel lbldb=new JLabel("Date of Birth");
		lbldb.setForeground(Color.WHITE);
		lbldb.setBounds(30,160,200,40);
		lbldb.setFont(f1);
		pmnt.add(lbldb);

		JTextField dob=new JTextField("");
		dob.setBounds(200,160,200,30);
		dob.setBackground(new Color(150,150,140));
		pmnt.add(dob);

		JLabel lbldep=new JLabel("Department");
		lbldep.setForeground(Color.WHITE);
		lbldep.setBounds(30,200,200,40);
		lbldep.setFont(f1);
		pmnt.add(lbldep);

		JTextField department=new JTextField("");
		department.setBounds(200,200,200,30);
		department.setBackground(new Color(150,150,140));
		pmnt.add(department);

		JLabel lblsal=new JLabel("Salary ");
		lblsal.setForeground(Color.WHITE);
		lblsal.setBounds(30,240,200,40);
		lblsal.setFont(f1);
		pmnt.add(lblsal);

		JTextField salary=new JTextField("");
		salary.setBounds(200,240,200,30);
		salary.setBackground(new Color(150,150,140));
		pmnt.add(salary);

		JLabel lblhire=new JLabel("Date Hired");
		lblhire.setForeground(Color.WHITE);
		lblhire.setBounds(30,280,200,40);
		lblhire.setFont(f1);
		pmnt.add(lblhire);

		JTextField hire_date=new JTextField("");
		hire_date.setBounds(200,280,200,30);
		hire_date.setBackground(new Color(150,150,140));
		pmnt.add(hire_date);

		JLabel lbltitle=new JLabel("Job Title");
		lbltitle.setForeground(Color.WHITE);
		lbltitle.setBounds(30,320,200,40);
		lbltitle.setFont(f1);
		pmnt.add(lbltitle);

		JTextField jbtitle=new JTextField("");
		jbtitle.setBounds(200,320,200,30);
		jbtitle.setBackground(new Color(150,150,140));
		pmnt.add(jbtitle);

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
								String dep=rs.getString(8);
								float sal=rs.getFloat(12);
								String hiredate=rs.getString(13);
								String jobtitle=rs.getString(9);

								fname.setText(fnm);
								sname.setText(snm);
								dob.setText(dt);
								department.setText(dep);
								hire_date.setText(hiredate);
								jbtitle.setText(jobtitle);
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
		});
		pmnt.add(jc);

		JButton slip=new JButton(" Generate Slip ");
		slip.setBounds(70,360,280,40);
		slip.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//Font blueFont=;
				Document d1=new Document();
				try{
					PdfWriter writer=PdfWriter.getInstance(d1,new FileOutputStream("PaymentSlip_emp"+empid+".pdf"));
					d1.open();

					d1.add(new Paragraph("Payroll Management System"));
					d1.add(new Paragraph("----------------------------------------------------------------------------------------------"));
					d1.add(new Paragraph(new Date().toString()));
					d1.add(new Paragraph(" "));d1.add(new Paragraph(" "));

					PdfPTable t1=new PdfPTable(7);
					t1.setWidthPercentage(110);
					t1.setSpacingBefore(2f);
					t1.setSpacingAfter(2f);
					PdfPCell c=new PdfPCell(new Paragraph("Payment Slip"));
					c.setColspan(7);
					c.setHorizontalAlignment(Element.ALIGN_CENTER);
					c.setPadding(8.0f);
					t1.addCell(c);
					PdfPCell c1=new PdfPCell(new Paragraph("Name"));
					PdfPCell c2=new PdfPCell(new Paragraph("Surname"));
					PdfPCell c3=new PdfPCell(new Paragraph("DOB"));
					PdfPCell c4=new PdfPCell(new Paragraph("Department"));
					PdfPCell c5=new PdfPCell(new Paragraph("Hire_Date"));
					PdfPCell c6=new PdfPCell(new Paragraph("Job_Title"));
					PdfPCell c7=new PdfPCell(new Paragraph("Salary"));

					t1.addCell(c1);t1.addCell(c2);t1.addCell(c3);
					t1.addCell(c4);t1.addCell(c5);t1.addCell(c6);t1.addCell(c7);

					c1=new PdfPCell(new Paragraph(fname.getText()));
					c2=new PdfPCell(new Paragraph(sname.getText()));
					c3=new PdfPCell(new Paragraph(dob.getText()));
					c4=new PdfPCell(new Paragraph(department.getText()));
					c5=new PdfPCell(new Paragraph(hire_date.getText()));
					c6=new PdfPCell(new Paragraph(jbtitle.getText()));
					c7=new PdfPCell(new Paragraph(salary.getText()));

					t1.addCell(c1);t1.addCell(c2);t1.addCell(c3);
					t1.addCell(c4);t1.addCell(c5);t1.addCell(c6);t1.addCell(c7);

					d1.add(t1);
					d1.close();
					JOptionPane.showMessageDialog(new JFrame()," Report Saved Successfully");
					writer.close();
				}
				catch(Exception e1){
						e1.printStackTrace();
						}
				}
		});
		//sign.setBackground(new Color(200,180,200));
		pmnt.add(slip);

		background.add(pmnt);
		background.add(heading);
		background.setBounds(0,0,800,1500);
		add(background);
		setJMenuBar(mb);

		setVisible(true);
	}
}
class AllowPdf
{
	public AllowPdf()
	{
		Document d1=new Document();
		try{
			//
			Connection con=DBConnection.getConnection();
			PreparedStatement stmt=con.prepareStatement("select overtime,pf,medical,bonus,ce,emp_id,salary,tallowance,fname,sname from allowance ");
			//stmt.setInt(1,empid);
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{

				float over=rs.getFloat(1);
				float pfnd=rs.getFloat(2);
				float med=rs.getFloat(3);
				float bns=rs.getFloat(4);
				float cea=rs.getFloat(5);
				int eid=rs.getInt(6);
				float sal=rs.getFloat(7);
				float tallow=rs.getFloat(8);
				String fnm=rs.getString(9);
				String snm=rs.getString(10);

				PdfWriter writer=PdfWriter.getInstance(d1,new FileOutputStream("PaymentSlip1.pdf"));
									d1.open();

									d1.add(new Paragraph("PAYROLL MANAGEMENT SYSTEM"));
									d1.add(new Paragraph("----------------------------------------------------------------------------------------------"));
									d1.add(new Paragraph(new Date().toString()));
									d1.add(new Paragraph(" "));d1.add(new Paragraph(" "));

									PdfPTable t1=new PdfPTable(10);
									t1.setWidthPercentage(110);
									t1.setSpacingBefore(1f);
									t1.setSpacingAfter(1f);
									PdfPCell c=new PdfPCell(new Paragraph("Total Allowance Report "));
									c.setColspan(10);
									c.setHorizontalAlignment(Element.ALIGN_CENTER);
									c.setPadding(8.0f);
									t1.addCell(c);
									PdfPCell c1=new PdfPCell(new Paragraph("Emp id"));
									PdfPCell c2=new PdfPCell(new Paragraph("Name"));
									PdfPCell c3=new PdfPCell(new Paragraph("Surname"));
									PdfPCell c4=new PdfPCell(new Paragraph("Salary"));
									PdfPCell c5=new PdfPCell(new Paragraph("PF"));
									PdfPCell c6=new PdfPCell(new Paragraph("Medical"));
									PdfPCell c7=new PdfPCell(new Paragraph("Child Edu"));
									PdfPCell c8=new PdfPCell(new Paragraph("Bonus"));
									PdfPCell c9=new PdfPCell(new Paragraph("OverTime"));
									PdfPCell c10=new PdfPCell(new Paragraph("Total Allow."));

									t1.addCell(c1);t1.addCell(c2);t1.addCell(c3);t1.addCell(c9);t1.addCell(c8);
									t1.addCell(c4);t1.addCell(c5);t1.addCell(c6);t1.addCell(c7);t1.addCell(c10);

									c1=new PdfPCell(new Paragraph(Integer.toString(eid)));
									c2=new PdfPCell(new Paragraph(fnm));
									c3=new PdfPCell(new Paragraph(snm));
									c4=new PdfPCell(new Paragraph(Float.toString(sal)));
									c5=new PdfPCell(new Paragraph(Float.toString(pfnd)));
									c6=new PdfPCell(new Paragraph(Float.toString(med)));
									c7=new PdfPCell(new Paragraph(Float.toString(cea)));
									c8=new PdfPCell(new Paragraph(Float.toString(bns)));
									c9=new PdfPCell(new Paragraph(Float.toString(over)));
									c10=new PdfPCell(new Paragraph(Float.toString(tallow)));

									t1.addCell(c1);t1.addCell(c2);t1.addCell(c3);t1.addCell(c9);t1.addCell(c8);
									t1.addCell(c4);t1.addCell(c5);t1.addCell(c6);t1.addCell(c7);t1.addCell(c10);
								//System.out.println(over+"\t"+pfnd+"\t"+med+"\t"+bns+"\t"+cea+"\t"+eid+"\t"+sal+"\t"+tallow+"\t"+fnm+"\t"+snm);
									d1.add(t1);
									d1.close();
									JOptionPane.showMessageDialog(new JFrame()," Report Saved Successfully");
									writer.close();
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