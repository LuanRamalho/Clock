import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luan Ramalho
 */
public class Clock implements ActionListener { 

   private javax.swing.Timer timer; 
   private Date data; 
   private JLabel label=new JLabel();; 
   private static JFrame frame=new JFrame("Relógio"); 

   public Clock(){ 
      montaTela();
      disparaRelogio(); 
   } 
   public void montaTela(){
   	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       
      label.setFont(new Font("Itálico", Font.ITALIC, 25)); 
      JPanel panel = new JPanel(); 
      panel.add(label); 
      panel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
      
      frame.getContentPane().add(panel); 

      frame.setResizable(false); 
      frame.setBounds(250, 200, 150, 80); 
      frame.setLocationRelativeTo(null);
      frame.setVisible(true); 
   	} 

   public void disparaRelogio() { 
      if (timer == null) { 
         timer = new javax.swing.Timer(1000, this); 
         timer.setInitialDelay(0); 
         timer.start(); 
      } else if (!timer.isRunning()) { 
         timer.restart(); 
      } 
   } 

   public void actionPerformed(ActionEvent ae) { 
      GregorianCalendar calendario = new GregorianCalendar(); 
      int h = calendario.get(GregorianCalendar.HOUR_OF_DAY); 
      int m = calendario.get(GregorianCalendar.MINUTE); 
      int s = calendario.get(GregorianCalendar.SECOND); 

      String hora = 
         ((h < 10) ? "0" : "") 
            + h 
            + ":" 
            + ((m < 10) ? "0" : "") 
            + m 
            + ":" 
            + ((s < 10) ? "0" : "") 
            + s; 

      label.setText(hora); 
   } 
   public static void main(String args[]) {
   	     try{
   	     javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {	
   	         new Clock();}
                     });  
   	         }
   	     catch(Exception e){
   	     	e.printStackTrace();
   	     	System.err.println("ERRO interno de execução!");
   	     	}     
   } 
}




