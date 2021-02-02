import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class frame1 extends JFrame {

   public frame1() {
        setSize(300, 380);
        setTitle("E-GramDaily");
        setResizable(false);
        setLayout(new CardLayout());




        JButton jB1 = new JButton("Buyer");
        jB1.setForeground(Color.blue);
        JButton jB2 = new JButton("Click Here");
        jB2.setForeground(Color.red);
        JLabel jL1 = new JLabel("Welcome to ");
        JLabel jLabel = new JLabel("E-GramDaily");
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        Font font = jLabel.getFont();
        float size = font.getSize() + 30.0f;
        jLabel.setFont( font.deriveFont(size) );
       jLabel.setForeground(Color.gray);


        JLabel jL2 = new JLabel("Help Center"); // link of manual
        jL2.setHorizontalAlignment(jL2.CENTER);
        Font font1 = jL2.getFont();
        float size1 = font1.getSize() + 5.0f;
        jL2.setFont( font.deriveFont(size1) );

        JLabel jL3 = new JLabel("Login Now As");
        jL3.setHorizontalAlignment(JLabel.CENTER);
        Font font2 = jL2.getFont();
        float size2 = font2.getSize() + 7.0f;
        jL3.setFont( font.deriveFont(size2) );

        JPanel jPanel = new JPanel();
        jPanel.setSize(300 ,350);

        jPanel.add(jL1);
        jPanel.add(jLabel);

      //  jPanel.add(link);


        jB1.setBounds(90, 60, 100, 50);

       jB1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               dispose();
               new buyerinfo();
           }
       });
        jB2.setBounds(90, 60, 100, 50);
       jPanel.add(jL2);
        jPanel.add(jB2);
       jPanel.add(jL3);
       jPanel.add(jB1);
       jB2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               dispose();
               new Helpframe();
           }
       });

        add(jPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //new LoginasBuyer();
   }

}

class Helpframe extends JFrame {

     public Helpframe() {
         setSize(600, 400);
         setTitle("E-GramDaily Help Center");
         setResizable(false);
         setLayout(new CardLayout());

         JButton jB1 = new JButton("Main Menu");
         JTextArea jTextArea = new JTextArea("Welcome to E-GramDaily ,to continue as a buyer please follow the given rules -\n" +
                "1) Make sure the number you are using to order is Registered\n" +
                "2)Contact direct with the buyer \n" +
                "3) All product prices are fixed by the seller ,that has no connection with E-GramDaily authorities.\n" +
                "4) Confirm before finalizing. \n" +
                "5)For a proof please ask for a memo to the seller .\n" +
                "\n" +
                "Contact Options \n" +
                "Contact us via email - egram24@gmail.com\n" +
                "Contact us via Phone - 01918888888\n" +
                "\n" +
                "\n" +
                "Thank you for choosing E-GramDaily\n ");
        jTextArea.setEditable(false);
        JButton jB2 = new JButton("Buyer Login");
        JLabel jLabel = new JLabel("Rules and Policies");

        JPanel jPanel = new JPanel();
        jPanel.setSize(500, 380);

        jB1.setBounds(90, 60, 100, 50);
        jPanel.add(jB1);
        jB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new frame1();
            }
        });
        jB2.setBounds(90, 60, 100, 50);

        jPanel.add(jB2);
        jB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginasBuyer();
            }
        });

        jPanel.add(jB2);
        jB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new frame1();
            }
        });
        jPanel.add(jLabel);
        jPanel.add(jTextArea);
        jPanel.add(jB1);
        jPanel.add(jB2);

        add(jPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class buyerinfo extends JFrame {
    public buyerinfo() {
        setSize(300, 380);
        setTitle("E-GramDaily");
        setResizable(false);
        setLayout(new CardLayout());

        JButton jB1 = new JButton("Register");
        jB1.setForeground(Color.red);
        JButton jB2 = new JButton("View Anyway");
        jB2.setForeground(Color.darkGray);
        JLabel jL1 = new JLabel("Welcome to ");
        JLabel jLabel = new JLabel("E-GramDaily");
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        Font font = jLabel.getFont();
        float size = font.getSize() + 30.0f;
        jLabel.setFont( font.deriveFont(size) );
        jLabel.setForeground(Color.gray);

        JTextField name = new JTextField(5);
        JTextField mobileno = new JTextField(5);
        File filereg = new File("REG.txt");

        jB1.setBounds(90, 60, 100, 50);
        jB1.setHorizontalAlignment(JLabel.CENTER);
        jB1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n = name.getText();
                System.out.println(n);
                String f = mobileno.getText();
                System.out.println(f);

                try {
                    FileWriter fileWriter = new FileWriter(filereg, true);
                    fileWriter.write(n + " " + f  + "\n");
                    fileWriter.close();
                } catch (FileNotFoundException a) {
                } catch (IOException a) {
                }
                name.setText(null);
                mobileno.setText(null);
                dispose();
                new LoginasBuyer();

            }
        });

        JLabel jL2 = new JLabel("Name"); // link of manual
        JLabel jL3 = new JLabel("Phone No");

//        JTextArea nameTA = new JTextArea( 2,7);
//        JTextArea mobilenoTA = new JTextArea(2,7);


        JPanel jPanel = new JPanel();
        jPanel.setSize(300 ,350);

        jPanel.add(jL1);
        jPanel.add(jLabel);

        jB2.setBounds(90, 60, 100, 50);
        jPanel.add(jL2);
        jPanel.add(name);
        jPanel.add(jL3);
        jPanel.add(mobileno);
        jPanel.add(jB1);
        jPanel.add(jB2);

        jB2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginasBuyer();
            }
        });

        add(jPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //new LoginasBuyer();
    }

}

class LoginasBuyer extends JFrame {
    BufferedWriter bufferedWriter;
    OutputStreamWriter outputStreamWriter;
    InputStreamReader inputStreamReader;
    Scanner scanner;
       void Startclient() {
           System.out.println("Started");
           try {
               Socket socket = new Socket("127.0.0.1", 50000);
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                scanner = new Scanner(inputStreamReader);//import
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                bufferedWriter = new BufferedWriter(outputStreamWriter);//export

           } catch (IOException e) {

           }
       }

    File fileFISH = new File("Fisheries.txt");
    File file1MEAT = new File("Meat.txt");
    File file2VEG = new File("Vegetables.txt");
    File file3FRUIT = new File("Fruit.txt");
    File file4MOSHLA = new File("Moshla.txt");
    File file5LG = new File("LocalGood.txt");
    File file6TRAD = new File("Traditional.txt");

    void Update(){

         try {

             String string = scanner.nextLine(); //reading
             string = string + ".txt";
             System.out.println(string);

             FileWriter writer = new FileWriter(string);

             while (scanner.hasNextLine()) {
                 String line = scanner.nextLine();
                 if (line.equals("<efo>")) {
                     string = scanner.nextLine();
                     string = string + ".txt";
                     writer = new FileWriter(string);
                     continue;
                 }
//                 else if (line.equals("<efs"))
//                 {
//                     break;
//                 }
                 System.out.println(line);
                 writer.append(line + "\n");
                 writer.flush();
             }
         } catch (IOException e) {

         }
     }

    public LoginasBuyer() {

        setSize(485, 800);
        setTitle("E-GramDaily : Login As A Buyer");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel2 = new JPanel();
        jPanel2.setPreferredSize(new Dimension(440, 1600));
        jPanel2.setLayout(new FlowLayout());

        JTextArea fisheriesTA = new JTextArea(10, 41);
        fisheriesTA.setEditable(false);

        JTextArea meatTA = new JTextArea(10, 41);
        meatTA.setEditable(false);

        JTextArea vegTA = new JTextArea(10, 41);
        vegTA.setEditable(false);

        JTextArea fruitTA = new JTextArea(10, 41);
        fruitTA.setEditable(false);

        JTextArea moshlaTA = new JTextArea(10, 41);
        moshlaTA.setEditable(false);

        JTextArea localTA = new JTextArea(10, 41);
        localTA.setEditable(false);

        JTextArea tradTA = new JTextArea(10, 41);
        tradTA.setEditable(false);


        JScrollPane jScrollPane = new JScrollPane(jPanel2);

        JScrollPane jScrollPane1 = new JScrollPane(fisheriesTA);
        JScrollPane jScrollPane2 = new JScrollPane(meatTA);
        JScrollPane jScrollPane3 = new JScrollPane(vegTA);
        JScrollPane jScrollPane4 = new JScrollPane(fruitTA);
        JScrollPane jScrollPane5 = new JScrollPane(moshlaTA);
        JScrollPane jScrollPane6 = new JScrollPane(localTA);
        JScrollPane jScrollPane7 = new JScrollPane(tradTA);



        JButton jButton1fisheries = new JButton(" Fisheries Section");
        JButton jButton2meat = new JButton("Meat Section");
        JButton jButton3veg = new JButton("Vegetables Section");
        JButton jButton4fruit = new JButton("Fruits Section");
        JButton jButton5moshla = new JButton("Moshla Section");
        JButton jButton6local = new JButton("Local Good ");
        JButton jButton7trad = new JButton("Traditional Goods");
        JButton mainmenu = new JButton("Main Menu");
        Thread  thread = new Thread(){
            @Override
            public void run(){
                Startclient();
                Update();
            }
        }; //anonymus thread class
        thread.start();


        mainmenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame1 frame1 = new frame1();
            }
        });

        JLabel jLabel = new JLabel("Kacha Bazar");
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setForeground(Color.blue);
        Font font = jLabel.getFont();
        float size = font.getSize() + 15.0f;
        jLabel.setFont(font.deriveFont(size));

        JLabel jLabel2 = new JLabel("Dry Items");
        jLabel2.setForeground(Color.blue);
        jLabel2.setHorizontalAlignment(JLabel.CENTER);
        Font font1 = jLabel2.getFont();
        float size1 = font1.getSize() + 20.0f;
        jLabel2.setFont(font1.deriveFont(size1));

        JLabel jLabel3 = new JLabel("( Pick your desired Options from Here- The Dry Item Section )");

        JLabel jLabel1 = new JLabel("( Pick your desired Options from the Kacha Bazar Section)");



        jButton1fisheries.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fisheriesTA.setText("");// blank korar jonnow
                try {

                    Scanner scanner = new Scanner(fileFISH);
                    while (scanner.hasNextLine()) {
                        String show = scanner.nextLine(); // scanner er line reader (ALL TYPE )
                        fisheriesTA.append(show + "\n");
                    }
                } catch (IOException d) {
                }
            }
        });

        jButton2meat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                meatTA.setText("");
                try {
                    Scanner scanner = new Scanner(file1MEAT);
                    while (scanner.hasNextLine()) {
                        String show = scanner.nextLine();
                        meatTA.append(show + "\n");

                    }
                } catch (IOException d) {
                }
            }
        });

        jButton3veg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vegTA.setText("");

                try {
                    Scanner scanner = new Scanner(file2VEG);
                    while (scanner.hasNextLine()) {
                        String show = scanner.nextLine();
                        vegTA.append(show + "\n");
                    }
                } catch (IOException d) {
                }
            }
        });

        jButton4fruit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fruitTA.setText("");
                try {
                    Scanner scanner = new Scanner(file3FRUIT);
                    while (scanner.hasNextLine()) {
                        String show = scanner.nextLine();
                        fruitTA.append(show + "\n");
                    }
                } catch (IOException d) {
                }
            }
        });

        jButton5moshla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moshlaTA.setText("");
                try {
                    Scanner scanner = new Scanner(file4MOSHLA);
                    while (scanner.hasNextLine()) {
                        String show = scanner.nextLine();
                        moshlaTA.append(show + "\n");
                    }
                } catch (IOException d) {
                }
            }
        });

        jButton6local.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                localTA.setText("");
                try {
                    Scanner scanner = new Scanner(file5LG);
                    while (scanner.hasNextLine()) {
                        String show = scanner.nextLine();
                        localTA.append(show + "\n");
                    }
                } catch (IOException d) {
                }
            }
        });

        jButton7trad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tradTA.setText("");
                try {
                    Scanner scanner = new Scanner(file6TRAD);
                    while (scanner.hasNextLine()) {
                        String show = scanner.nextLine();
                        tradTA.append(show + "\n");
                    }
                } catch (IOException d) {
                }
            }
        });

        jPanel2.add(jLabel);
        jPanel2.add(jLabel1);
        jPanel2.add(jButton1fisheries);
        jPanel2.add(jScrollPane1);
        jPanel2.add(jButton2meat);
        jPanel2.add(jScrollPane2);
        jPanel2.add(jButton3veg);
        jPanel2.add(jScrollPane3);
        jPanel2.add(jButton4fruit);
        jPanel2.add(jScrollPane4);
        jPanel2.add(jLabel2);
        jPanel2.add(jLabel3);
        jPanel2.add(jButton5moshla);
        jPanel2.add(jScrollPane5);
        jPanel2.add(jButton6local);
        jPanel2.add(jScrollPane6);
        jPanel2.add(jButton7trad);
        jPanel2.add(jScrollPane7);
        jPanel2.add(mainmenu);


        add(jScrollPane);
        setVisible(true);
    }

}
    public class EGDBuyer {
        public static void main(String[] args) throws IOException {
            new frame1();
        }
}
