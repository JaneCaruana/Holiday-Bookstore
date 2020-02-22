import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.nio.file.attribute.*;
import java.nio.file.*;
import java.io.*;
import static java.nio.file.AccessMode.*;
import static java.nio.file.StandardOpenOption.*;

public class HolidayBookstore implements ActionListener{


JFrame f = new JFrame("MENU");

JLabel l1 = new JLabel("HOLIDAY BOOKSTORE");
JButton b1 = new JButton("Add new Books");
JButton b2 = new JButton("Search Books");
JButton b3 = new JButton("Display Books");
HolidayBookstore(){
b1.setBounds(120,100,200,40);
b2.setBounds(120,150,200,40);
b3.setBounds(120,200,200,40);
l1.setBounds(120,40,250,30);
l1.setFont (new Font ("Helvetica", Font.BOLD, 20));
l1.setForeground(Color.white);
b1.setBackground(Color.pink);
b2.setBackground(Color.pink);
b3.setBackground(Color.pink);
//b1.setForeground(Color.white);


f.add(b1);
f.add(b2);
f.add(b3);
f.add(l1);
 b1.addActionListener(this);
 b2.addActionListener(this);
 b3.addActionListener(this);

//f.add(add);
//f.getContentPane().add(b1);

f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
f.setLayout(null);
f.setVisible(true);
f.setSize(500,500);
f.setLocation(0,0);

f.getContentPane().setBackground(Color.gray);


 f.addWindowListener(new WindowAdapter(){
         public void windowClosing(WindowEvent e){
            System.exit(0);
            }
            });
 }  
     
     @Override
   public void actionPerformed(ActionEvent e){
   if(e.getSource() == b1){
      AddBooks add = new AddBooks();
   //.setVisible(true);
   add.Add();
   f.dispose();
   

   }
   else if(e.getSource() == b2){
   //f.dispose();
   SearchBooks search = new SearchBooks();
   search.Search();
   
   f.dispose();
   
   }
   else{
   f.dispose();
   Display disp = new Display();
   disp.DisplayBooks();
   f.dispose();
   
  }
   }
   

public static void main(String [] args){

      HolidayBookstore f = new HolidayBookstore();
}
   }