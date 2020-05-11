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

class AllowPdf
{
	public AllowPdf()
	{
		Document d1=new Document();
		try{
			//
							PdfWriter writer=PdfWriter.getInstance(d1,new FileOutputStream("PaymentAllowance.pdf"));
							d1.open();

							d1.add(new Paragraph("                                             PAYROLL MANAGEMENT SYSTEM"));
							d1.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------"));
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

			Connection con=DBConnection.getConnection();
			PreparedStatement stmt=con.prepareStatement("select * from allowance ");
			//stmt.setInt(1,empid);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{

				float over=rs.getFloat(2);
				float pfnd=rs.getFloat(3);
				float med=rs.getFloat(4);
				float bns=rs.getFloat(5);
				float cea=rs.getFloat(6);
				int eid=rs.getInt(7);
				float sal=rs.getFloat(8);
				float tallow=rs.getFloat(9);
				String fnm=rs.getString(10);
				String snm=rs.getString(11);

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

			}
			d1.add(t1);
			d1.close();
			JOptionPane.showMessageDialog(new JFrame()," Report Saved Successfully");
			writer.close();

		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}

	}
}