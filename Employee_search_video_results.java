/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pcsstandalone.userinterface;

import Controller.DataBaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Nagarjun Reddy
 */
public class Employee_search_video_results extends javax.swing.JFrame {

    /**
     * Creates new form Employee_search_video_results
     */
    
    public static String keyword;
    public static String username;
    public static boolean flag=false;
    public String values[]=new String[1000];
    public HashSet results;
    public int i=0;
    public String video=null;
    public Employee_search_video_results() throws ClassNotFoundException, SQLException {
        initComponents();
        Connection con=DataBaseConnection.dbConnection();
        Statement stmt=con.createStatement();
        boolean flag=false;;
        if(flag)
        {
            String videos="select name from videos where course='"+keyword+"';";
            ResultSet rs=stmt.executeQuery(videos);
            while(rs.next())
            {
                //String video_name=rs.getString(1);
                values[i]=rs.getString(1);
                i++;
            }
        }
        else
        {
            String sql_stmt="select name,description,likes,unlikes from videos";
            ResultSet rs=stmt.executeQuery(sql_stmt);
            if(keyword.equalsIgnoreCase(""))
            {
                values[i]="No Results Found";
                flag=true;
            }
            else
            {
                String s2[];
                s2 = keyword.split(" ");
                while (rs.next()) 
                {
                    String s1[]=rs.getString(2).split(" ");
                    for(int j=0;j<s2.length;j++)
                    {
                        for(int k=0;k<s1.length;k++)
                        {
                            if(s1[k].equalsIgnoreCase(s2[j])||s2[j].equalsIgnoreCase(rs.getString(1)))
                            {
                                if(values.equals(rs.getString(1)))
                                {
                                }
                                else
                                {
                                    System.out.println(rs.getString(1));
                                    values[i]=rs.getString(1);
                                    i++;
                                }
                                break;
                            }
                        }       
                    }
                }
            }
            if(i==0)
            {
                values[i]="No Results Found";
                flag=true;
            }
            jList1.setListData(values);
            if(flag)
            {
                jButton3.setEnabled(false);
            }
            try
            {
                jList1.addListSelectionListener(new ListSelectionListener()
                {

                    @Override
                    public void valueChanged(ListSelectionEvent lse) 
                    {
                        video=jList1.getSelectedValue().toString();                
                    }
            
                });
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Search Video");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, -1));

        jButton2.setText("Courses");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 70, 90, 40));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, -1, -1));

        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 780, 170));

        jButton3.setText("Select");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 80, 30));

        jButton4.setText("upload");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 90, 40));

        jButton6.setText("Home");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 80, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Nagarjun Reddy\\Desktop\\PCSStandalone\\src\\pcsstandalone\\userinterface\\main.png")); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //courses
        this.setVisible(false);
        Employee_courses.main(username);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        Employee_Watch1.main(username,video);            
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        upload_video.main(username);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        WelcomeScreen.main(username);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String username1,String keyword,boolean flag1) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee_search_video_results.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Employee_search_video_results.username=username1;
        Employee_search_video_results.flag=flag1;
        Employee_search_video_results.keyword=keyword;
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Employee_search_video_results().setVisible(true);
                } catch (        ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Employee_search_video_results.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables


}