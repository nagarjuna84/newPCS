package pcsstandalone.userinterface;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nagarjun Reddy
 */

import Controller.DataBaseConnection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import static javafx.concurrent.Worker.State.FAILED;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;

public class Employee_Watch1 extends JFrame
{
    
    private JFXPanel jPanel1;
    private WebEngine engine;
    private JPanel panel;
    private final JTextField txtURL = new JTextField();
//    private final JButton btnGo = new JButton("Go");
    static public String video_name;
    static public String uname;
    private String fileName;
      private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
  //  private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    
    public Employee_Watch1() {
        super();
        initComponents();
    }
    
    private void initComponents() 
    {
        //    jfxPanel = new JFXPanel();
        jPanel1=new JFXPanel();
                createScene();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
      //  jPanel1 = new javax.swing.JPanel();
          jLabel5 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(null);

        //jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Capture2.PNG"))); // NOI18N
        jLabel1.setText("Video: "+video_name);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1360, 280);       
       
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("main.png"))); // NOI18N
        jLabel5.setText("Here");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1330, -1));
        
        jTextField2.setText("");
        getContentPane().add(jTextField2);
        jTextField2.setBounds(750, 320, 160, 40);

        jButton2.setText("Post question");
        getContentPane().add(jButton2);
        jButton2.setBounds(750, 380, 120, 23);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Comment");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(750, 320, 70, 14);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(1120, 300, 100, 70);

        jButton3.setText("Post Comment");
        getContentPane().add(jButton3);
        jButton3.setBounds(1130, 380, 120, 23);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
        jButton4.setText("Home");
        getContentPane().add(jButton4);
        jButton4.setBounds(620,30,100,50); 
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        
        jButton5.setText("Upload");
        getContentPane().add(jButton5);
        jButton5.setBounds(790,30,100,50);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        
        jButton6.setText("Courses");
        getContentPane().add(jButton6);
        jButton6.setBounds(950,30,110,50);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(520, 320));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 290, 520, 320);
    }
    
    public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException, IOException
    {
        File file = new File("upload.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String data;
        while(br.readLine()!=null)
        {
            data = br.readLine();
            System.out.println("0000000000000"+data);
        }
    }
    public void jButton3ActionPerformed(java.awt.event.ActionEvent evt)
    {
        this.setVisible(false);
                        String comment=jTextArea1.getText();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date = new Date();
                        String d;
                        d = (String)dateFormat.format(date);
                        Connection conn = null;
                        try {
                        try {
                                conn = DataBaseConnection.dbConnection();
                            } catch (    ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                    PreparedStatement ps;
                                    ps=(PreparedStatement) conn.prepareStatement("Insert into comments values(?,?,?,?)");
                                    ps.setString(1, d);//date
                        	    ps.setString(2, uname);//user name
                        	    ps.setString(3, video_name);//video name
                        	    ps.setString(4, comment);//comment
                                    ps.execute();
                                    FileWriter fileWriter = null;
                                    try {
                                                fileWriter = new FileWriter("C://Program Files/PCS/comments.txt",true);
                                            } catch (IOException ex) {
                                                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                    try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                                                bufferedWriter.write(d+" "+uname+" "+video_name+" "+comment+"*");
                                                bufferedWriter.close();
                                            }
                                } catch (SQLException | IOException ex) {
                                    Logger.getLogger(upload_video.class.getName()).log(Level.SEVERE, null, ex);
                                }
                        //SE connectio
                        Connection conn1 = null;
                        try {
                                conn1 = DataBaseConnection.dbConnection1();
                            } catch (    ClassNotFoundException | SQLException ex) {
                                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
                            }
                                    PreparedStatement ps1 = null;
        try {
            ps1=(PreparedStatement) conn1.prepareStatement("Insert into comments values(?,?,?,?)");
        } catch (SQLException ex) {
            Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ps1.setString(1, d);//date
        } catch (SQLException ex) {
            Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ps1.setString(2, uname);//user name
        } catch (SQLException ex) {
            Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ps1.setString(3, video_name);//video name
        } catch (SQLException ex) {
            Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ps1.setString(4, comment);//comment
        } catch (SQLException ex) {
            Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ps1.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
        }
                                
        Employee_Watch1.main(uname,video_name);
    }
    public void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
    {
        this.setVisible(false);
        String que=jTextField2.getText();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String d;
        d = (String)dateFormat.format(date);
        Connection conn = null;
        try {
            try {
                conn = DataBaseConnection.dbConnection();
            } catch (    ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement ps = null;
            try {
                ps=(PreparedStatement) conn.prepareStatement("Insert into form values(?,?,?,?)");
            } catch (SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ps.setString(1, uname);//user name
            } catch (SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ps.setString(2, que);//question
            } catch (SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ps.setString(3, video_name);//video name
            } catch (SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ps.setString(4, d);//date
            } catch (SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter("C://Program Files/PCS/discussion.txt",true);
            } catch (IOException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(uname+" "+que+" "+video_name+" "+d+"*");
                bufferedWriter.close();
            }
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '"+ fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        /*
          connect to SE
         */
        Connection conn1 = null;
       
            try {
                conn1 = DataBaseConnection.dbConnection1();
            } catch (    ClassNotFoundException | SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement ps1 = null;
            try {
                ps1=(PreparedStatement) conn1.prepareStatement("Insert into form values(?,?,?,?)");
            } catch (SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ps1.setString(1, uname);//user name
            } catch (SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ps1.setString(2, que);//question
            } catch (SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ps1.setString(3, video_name);//video name
            } catch (SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ps1.setString(4, d);//date
            } catch (SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ps1.execute();
            } catch (SQLException ex) {
                Logger.getLogger(Employee_Watch.class.getName()).log(Level.SEVERE, null, ex);
            }
        Employee_Watch1.main(uname,video_name);
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        this.setVisible(false);
        WelcomeScreen.main(uname);
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        this.setVisible(false);
        upload_video.main(uname);
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        this.setVisible(false);
        Employee_courses.main(uname);
    }
    
    private void createScene() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                WebView view = new WebView();
                engine = view.getEngine();
                engine.getLoadWorker()
                        .exceptionProperty()
                        .addListener(new ChangeListener<Throwable>() {
                    @Override
                    public void changed(ObservableValue<? extends Throwable> o, Throwable old, final Throwable value) {
                        if (engine.getLoadWorker().getState() == FAILED) {
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    JOptionPane.showMessageDialog(
                                            panel,
                                            (value != null)
                                            ? engine.getLocation() + "\n" + value.getMessage()
                                            : engine.getLocation() + "\nUnexpected error.",
                                            "Loading error...",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            });
                        }
                    }
                });

                //  jfxPanel.setScene(new Scene(view));
                jPanel1.setScene(new Scene(view));
            }
        });
    }

    public void loadURL(final String url) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                String tmp = toURL(url);

                if (tmp == null) {
                    tmp = toURL("http://" + url);
                }
                System.out.println("Tmp---"+tmp);
                engine.load(tmp);
            }
        });
    }

    private static String toURL(String str) {
        try {
            return new URL(str).toExternalForm();
        } catch (MalformedURLException exception) {
            return null;
        }
    }

    public static void main(final String username,final String v_name) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FileOutputStream outputStream = null;
                video_name=v_name;
                uname=username;
                try {
                    Employee_Watch1 browser = new Employee_Watch1();
                    browser.setVisible(true);
                    video_name=v_name;
//                    String[] final_values = null;
//                    File file = new File("upload_video.txt");
//                    FileReader fr = new FileReader(file);
//                    BufferedReader br = new BufferedReader(fr);
//                    String data;
//                    while((data=br.readLine())!=null)
//                    {                       
//                        if(data.contains(video_name))
//                        {
//                           final_values=data.split("122abb333ccc");
//                            System.out.println("Final Video: "+final_values[3]);
//                        }
//                    }
                    FileWriter fstream = new FileWriter("C:\\Users\\Nagarjun Reddy\\Desktop\\PCSStandalone\\src\\pcsstandalone\\userinterface\\play.html");
                    try (BufferedWriter out = new BufferedWriter(fstream)) {
                        out.write("<html>\n" +
                                "    <head>\n" +
                                "        <title></title>\n" +
                                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                                "    </head>\n" +
                                "    <body>\n" +
                                "        <video width=\"350\" height=\"350\" controls>\n" +
                                "       <source src=\"file:///"+"C:/Users/Nagarjun Reddy/Videos/"+video_name+".mp4"+"\" type=\"video/mp4\">\n" +
                                "       </video>\n" +
                                "    </body>\n" +
                                "</html>");
                        out.close();
                    }
                    //browser.loadURL("file:///C:/Users/Ragasudha/Desktop/Msit_pcs/web/ex.html");
                    browser.loadURL("file:///C:\\Users\\Nagarjun Reddy\\Desktop\\PCSStandalone\\src\\pcsstandalone\\userinterface\\play.html");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Employee_Watch1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Employee_Watch1.class.getName()).log(Level.SEVERE, null, ex);
               } 
            }
        });
    }
}
