import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import git.tools.client.GitSubprocessClient;




public class Main {
    
    public static void main (String[] args) {
        
        
        String repoPath = "/Users/ryanseely/Desktop/Quinnipiac/Freshman/CSC111/MazeProject/Maze.java";
        GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);
        
           
        
        JFrame frame = new JFrame("Swing Demo");
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.pink);
        frame.setContentPane(mainPanel);

        JTextField  box1;
        box1= new JTextField(""); 
        box1.setBounds(400,45, 250,50);
        frame.add(box1);  
        frame.setLayout(null);  
        frame.setVisible(true);   

         
        JLabel helloLabel = new JLabel("Paste the path of the Project you want to turn into a Repo");
        helloLabel.setSize(320,100);
        helloLabel.setLocation(50,20);
        mainPanel.add(helloLabel);


        JButton ignoreButton = new JButton("Git Ignore and Readme");
        ignoreButton.setSize(100,50);
        ignoreButton.setLocation(80,100);
        ignoreButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                


                File readMe = new File("README.md");
                System.out.println("README file Created");


                File gitIgnore = new File(".gitignore");
                System.out.println("git Ignore file Created");



                
                

               
            }
        });
        mainPanel.add(ignoreButton);

        frame.setVisible(true);
            
        
       

      
        
 
        JButton clickMeButton = new JButton("1.Turn Project to Repo");
        clickMeButton.setSize(200,50);
        clickMeButton.setLocation(50,100);

        JButton push = new JButton("2.Initial Push");
        push.setSize(200,50);
        push.setLocation(50,150);


        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                helloLabel.setText("Goodbye All");
            }
        });
        
        mainPanel.add(clickMeButton);
        mainPanel.add(push);

        
        frame.setVisible(true);


    }
}
