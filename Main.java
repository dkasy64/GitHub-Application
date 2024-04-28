import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import git.tools.client.GitSubprocessClient;

public class Main {
    public static void main (String[] args) {
        

           
        
        JFrame frame = new JFrame("Swing Demo");
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.pink);
        frame.setContentPane(mainPanel);

        JTextField  box1;
        box1= new JTextField("");  // box where user inputs his file path
        box1.setBounds(300,60, 250,50);
        mainPanel.add(box1);  
        mainPanel.setLayout(null);  
        mainPanel.setVisible(true); 

        JTextField  box2;
        box2= new JTextField("");  // box where user inputs gitHub Username
        box2.setBounds(400,200, 250,50);
        mainPanel.add(box2);  
        mainPanel.setLayout(null);  
        mainPanel.setVisible(true); 
    
         
        JLabel helloLabel = new JLabel("Paste the path of the Project you want to turn into a Repo");
        helloLabel.setSize(325,100);
        helloLabel.setLocation(50,180);
        mainPanel.add(helloLabel);
        helloLabel.setVisible(true);


        // JLabel repoName = new JLabel("What do you");
        // repoName.setSize(325,100); make a input box next to text asking for repo name
        // repoName.setLocation(50,180);
        // mainPanel.add(repoName);
        // repoName.setVisible(true);

        //to-do generate a git ignore




        JButton ignoreButton = new JButton("Git Ignore and Readme");
        ignoreButton.setSize(100,50);
        ignoreButton.setLocation(80,100);
        ignoreButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                try{  


                    File readMe = new File("README.md");
                    if (readMe.createNewFile()){
                        System.out.println("README file Created" + readMe.getName());
    
                    } else {
                        System.out.println("File Already exists.");
                    }
                }catch (IOException t){
                    System.out.println("An error occured.");
                    t.printStackTrace();
                }
                try{
    
                    File gitIgnore = new File(".gitignore");
                if (gitIgnore.createNewFile()){
                    System.out.println("Ignore file Created" + gitIgnore.getName());
    
                } else {
                    System.out.println("File Already exists.");
                }
            }catch (IOException f){
                    System.out.println("An error occured.");
                    f.printStackTrace();
            }

            }
               
            

            
        
    });
    
    
     
    
    
        mainPanel.add(ignoreButton);

        frame.setVisible(true);
            
        
       

      

        JLabel gitUserName = new JLabel("Input your GitHub UserName");
        gitUserName.setSize(325,100);
        gitUserName.setLocation(70,45);
        mainPanel.add(gitUserName);
        gitUserName.setVisible(true);

        
 
        JButton clickMeButton = new JButton("1.Turn Project to Repo");
        clickMeButton.setSize(200,50);
        clickMeButton.setLocation(50,300);

        JButton push = new JButton("2.Initial Push");
        push.setSize(200,50);
        push.setLocation(50,350);


        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        
                String repoPath = box1.getText(); // reads the path the user inputed
                GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);

                String gitInit = gitSubprocessClient.gitInit(); // git init command 
                
                String gitRemoteAdd = gitSubprocessClient.gitRemoteAdd("origin", "https://github.com/"+ box2.getText());// ask for username
                
            }

        });

   

    

mainPanel.add(clickMeButton);mainPanel.add(push);

frame.setVisible(true);



 }
}






