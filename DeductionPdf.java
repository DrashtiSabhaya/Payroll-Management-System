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

class DeductionPdf
{
	public DeductionPdf()
	{
		Document d1=new Document();
		try{
			//
							PdfWriter writer=PdfWriter.getInstance(d1,new FileOutputStream("PaymentDeduction.pdf"));
							d1.open();

							d1.add(new Paragraph("                                             PAYROLL MANAGEMENT SYSTEM"));
							d1.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
							d1.add(new Paragraph(new Date().toString()));
							d1.add(new Paragraph(" "));d1.add(new Paragraph(" "));

							PdfPTable t1=new PdfPTable(8);
							t1.setWidthPercentage(110);
							t1.setSpacingBefore(1f);
							t1.setSpacingAfter(1f);
							PdfPCell c=new PdfPCell(new Paragraph("Total Deduction Report "));
							c.setColspan(8);
							c.setHorizontalAlignment(Element.ALIGN_CENTER);
							c.setPadding(8.0f);
							t1.addCell(c);
							PdfPCell c1=new PdfPCell(new Paragraph("Emp id"));
							PdfPCell c2=new PdfPCell(new Paragraph("Name"));
							PdfPCell c3=new PdfPCell(new Paragraph("Surname"));
							PdfPCell c4=new PdfPCell(new Paragraph("Salary"));
							PdfPCell c5=new PdfPCell(new Paragraph("Profational Tax"));
							PdfPCell c6=new PdfPCell(new Paragraph("Leaves"));
							PdfPCell c7=new PdfPCell(new Paragraph("Total Deduction"));
							PdfPCell c8=new PdfPCell(new Paragraph("reason"));

							t1.addCell(c1);t1.addCell(c2);t1.addCell(c3);t1.addCell(c8);
							t1.addCell(c4);t1.addCell(c5);t1.addCell(c6);t1.addCell(c7);

			Connection con=DBConnection.getConnection();
			PreparedStatement stmt=con.prepareStatement("select * from deduction ");
			//stmt.setInt(1,empid);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				String fnm=rs.getString(2);
				String snm=rs.getString(3);
				float sal=rs.getFloat(4);
				float ptax=rs.getFloat(5);
				int lv=rs.getInt(6);
				float ded=rs.getFloat(7);
				String rsn=rs.getString(8);
				int eid=rs.getInt(9);

				c1=new PdfPCell(new Paragraph(Integer.toString(eid)));
				c2=new PdfPCell(new Paragraph(fnm));
				c3=new PdfPCell(new Paragraph(snm));
				c4=new PdfPCell(new Paragraph(Float.toString(sal)));
				c5=new PdfPCell(new Paragraph(Float.toString(ptax)));
				c6=new PdfPCell(new Paragraph(Integer.toString(lv)));
				c7=new PdfPCell(new Paragraph(Float.toString(ded)));
				c8=new PdfPCell(new Paragraph(rsn));

				t1.addCell(c1);t1.addCell(c2);t1.addCell(c3);t1.addCell(c8);
				t1.addCell(c4);t1.addCell(c5);t1.addCell(c6);t1.addCell(c7);
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