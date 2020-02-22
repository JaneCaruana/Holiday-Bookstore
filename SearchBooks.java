import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;




public class SearchBooks extends JFrame{

public void Search(){

JFrame frame = new JFrame("Menu");

 //Labels
   JLabel l1 = new JLabel("Book ID ");
   JLabel l2 = new JLabel("ISBN ");
   JLabel l3 = new JLabel("Book Title ");
   JLabel l4 = new JLabel("Author ");
   JLabel l5 = new JLabel("Edition ");
   JLabel l6 = new JLabel("Price ");
   JLabel l7 = new JLabel("Quantity ");
   
   //Textfields
   JTextField t1 = new JTextField();
   JTextField t2 = new JTextField();
   JTextField t3 = new JTextField();
   JTextField t4 = new JTextField();
   JTextField t5 = new JTextField();
   JTextField t6 = new JTextField();
   JTextField t7 = new JTextField();
   
   //Buttons
   JButton b1 = new JButton("Save");
   JButton b2 = new JButton("Search");
   JButton b3 = new JButton("Display");
   JButton b4 = new JButton("Exit");
   
   
   
  l1.setBounds(50,50,200,40);
  l2.setBounds(50,100,200,30);
  l3.setBounds(50,150,200,30);
  l4.setBounds(50,200,200,30);
  l5.setBounds(50,250,200,30);
  l6.setBounds(50,300,200,30);
  l7.setBounds(50,350,200,30); 
  
  t1.setBounds(150,50,200,30);
  t2.setBounds(150,100,200,30);
  t3.setBounds(150,150,200,30);
  t4.setBounds(150,200,200,30);
  t5.setBounds(150,250,200,30);
  t6.setBounds(150,300,200,30);
  t7.setBounds(150,350,200,30);
  
  b1.setBounds(50,400,80,40);
  b2.setBounds(150,400,80,40);
  b3.setBounds(250,400,80,40);
  b4.setBounds(350,400,80,40);
  
  
   frame.add(l1);
   frame.add(l2);
   frame.add(l3);
   frame.add(l4);
   frame.add(l5);
   frame.add(l6);
   frame.add(l7);
   frame.add(t1);
   frame.add(t2);
   frame.add(t3);
   frame.add(t4);
   frame.add(t5);
   frame.add(t6);
   frame.add(t7);
   frame.add(b1);
   frame.add(b2);
   frame.add(b3);
   frame.add(b4);
   
   
   
   

frame.setLayout(null);
frame.setVisible(true);
frame.setSize(500,500);
frame.setLocation(0,0);
//f.setResizable(false);
//frame.getContentPane().setBackground(Color.gray);

frame.addWindowListener(new WindowAdapter(){
         public void windowClosing(WindowEvent e){
            System.exit(0);
            }
            });
b1.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e){
      String entry;
      String delimiter = " , ";
      int bookId =Integer.parseInt(t1.getText());
      String isbn = t2.getText().toString();
      String bookTitle = t3.getText().toString();
      String author = t4.getText().toString();
      String edition = t5.getText().toString();
      double price =Double.parseDouble(t6.getText());
      int quantity =Integer.parseInt(t7.getText());
      
      try{
         Path filepath = Paths.get("C:\\Users\\Jane Caruana\\Documents\\HOLIDAY BOOKSTORE\\Records.txt");
         OutputStream output = new BufferedOutputStream(Files.newOutputStream(filepath, CREATE, APPEND));
         BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
         

 
        
         entry = bookId + delimiter + isbn + delimiter + bookTitle + delimiter + author + delimiter + edition + delimiter + price + delimiter + quantity;
         writer.write(entry,0,entry.length());
         writer.newLine();
         t1.setText(null);
         t2.setText(null);
         t3.setText(null);
         t4.setText(null);
         t5.setText(null);
         t6.setText(null);
         t7.setText(null);
         writer.close();
        
         int input = JOptionPane.showConfirmDialog(frame,"Books successfully saved."+"\n"+" Do you want to add new entries?","Saving books",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
          if(input == 1){
          System.exit(0);
          }
         }
         
         
         catch(Exception b ){
          System.out.println("Exception : "+ b);
   
          }
          
         
          
          }});
          b2.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e){
     
      String[] record = new String[8];
      String entry="";
      String delimiter = " , ";
      int bookId =Integer.parseInt(t1.getText());

      
   try{
         Path filepath = Paths.get("C:\\Users\\Jane Caruana\\Documents\\HOLIDAY BOOKSTORE\\Records.txt");
         InputStream input = new BufferedInputStream(Files.newInputStream(filepath));
         BufferedReader reader = new BufferedReader(new InputStreamReader(input));
         

          
         //extract the first record
         entry = reader.readLine();
                  
         while(entry != null){
         
            //split entry into fields
            record = entry.split(delimiter);
            
            //check if the employee exists
            if(bookId == (Integer.parseInt(record[0]))){
               t2.setText(record[1]);
               t3.setText(record[2]);
               t4.setText(record[3]);
               t5.setText(record[4]);
               t6.setText(record[5]);
               t7.setText(record[6]);
               
               
               break;
            }else{
               //extract next entry
               entry = reader.readLine();
               if(entry == null)
                 JOptionPane.showMessageDialog(frame,"The book record does not exist!","Book not Found",JOptionPane.WARNING_MESSAGE);
                 t1.setText(null);
                 t2.setText(null);
                 t3.setText(null);
                 t4.setText(null);
                 t5.setText(null);
                 t6.setText(null);
                 t7.setText(null);
            }      
         }
         
        //close the output stream
        reader.close();
      
      }catch(Exception b){
         System.out.println("Exception : "+ b);
            }
         }
      });
      b3.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e){
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
}
});

      

         b4.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e){   
   System.exit(0);
   }
   });



}
}