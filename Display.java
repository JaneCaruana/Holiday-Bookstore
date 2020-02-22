import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;


public class Display extends JFrame{

 public void DisplayBooks(){

JFrame frame = new JFrame("Menu");

JTable table = new JTable();


Object [] columns ={"Book ID","ISBN","Book Title","Author","Edition","Price","Quantity"};
DefaultTableModel model = new DefaultTableModel();
//table.setTableHeader(null);
  table.getTableHeader().setFont(new Font ("TimesRoman", Font.PLAIN ,14));
  table.getTableHeader().setBackground(Color.lightGray);
  table.getTableHeader().setForeground(Color.decode("#4b5320"));
table.setShowHorizontalLines(false);
table.setShowVerticalLines(false);
model.setColumnIdentifiers(columns);
table.setModel(model);
table.setForeground(Color.black);
Font font = new Font("Tahoma",1,12);
table.setFont(font);
table.setRowHeight(30);
table.setSize(150,150);

//column size
table.getColumnModel().getColumn(0).setPreferredWidth(50);
table.getColumnModel().getColumn(1).setPreferredWidth(75);
table.getColumnModel().getColumn(2).setPreferredWidth(150);
table.getColumnModel().getColumn(3).setPreferredWidth(100);
table.getColumnModel().getColumn(4).setPreferredWidth(40);
table.getColumnModel().getColumn(5).setPreferredWidth(90);
table.getColumnModel().getColumn(6).setPreferredWidth(40);

//alignment
DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment(JLabel.CENTER);
table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
    

JScrollPane pane = new JScrollPane(table);
pane.setBounds(25,100,700,300);
  
   
   frame.add(pane);
   
   
   frame.setLayout(null);
   frame.setVisible(true);
   frame.setSize(770,500);
   frame.setLocation(0,0);
   
   
   
  


       Object [] row = new Object[7];
      String[] record = new String[7];
      String entry="";
      String delimiter = " , ";
      
       try{
         Path filepath = Paths.get("C:\\Users\\Jane Caruana\\Documents\\Records.txt");
         InputStream input = new BufferedInputStream(Files.newInputStream(filepath));
         BufferedReader reader = new BufferedReader(new InputStreamReader(input));
         
         //extract the first record
         entry = reader.readLine();
                  
         while(entry != null){
         
            //split entry into fields
            record = entry.split(delimiter);
            row[0] = record[0];
            row[1] = record[1];
            row[2] = record[2];
            row[3] = record[3];
            row[4] = record[4];
            row[5] = record[5];
            row[6] = record[6];
         
            
            model.addRow(row);

            
            
            entry = reader.readLine();      
         }
         
        //close the output stream
        reader.close();
      
      }catch(Exception b){
         System.out.println("Exception : "+ b);
      }
 frame.addWindowListener(new WindowAdapter(){
         public void windowClosing(WindowEvent e){
            System.exit(0);
            }
            });
}
}


   
   
   





