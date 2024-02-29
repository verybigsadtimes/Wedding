import java.time.LocalDate;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class TWedding extends JFrame implements ActionListener {
    // creates the labels, text fields, and buttons that will be added to the frame
    JLabel heading = new JLabel("Wedding Planner");

    //sets a default font size that will be used for things like the header
    Font bigFont = new Font("Arial", Font.BOLD, 16);
    JLabel bfnLabel = new JLabel("Enter first name of bride: ");
    JTextField enterBFN = new JTextField();
    JLabel blnLabel = new JLabel("Enter last name of bride: ");
    JTextField enterBLN = new JTextField();
    JLabel gfnLabel = new JLabel("Enter first name of groom: ");
    JTextField enterGFN = new JTextField();
    JLabel glnLabel = new JLabel("Enter last name of groom: ");
    JTextField enterGLN = new JTextField();
    JLabel locLabel = new JLabel("Enter wedding location: ");
    JTextField enterLoc = new JTextField();
    JLabel dateLabel = new JLabel("Enter wedding date (yyyy-mm-dd): ");
    JTextField enterDate = new JTextField();
    JLabel cakeLabel = new JLabel("Enter the layers on the cake: ");
    JTextField enterCake = new JTextField();
    JButton press = new JButton("Confirm");

    JPanel CakePanel = new CakePanel();
    //creates empty labels summarizing wedding info
    JLabel weddingSummary1 = new JLabel("");
    JLabel weddingSummary2 = new JLabel("");
    //declares the default size for the frame
    final int WIDTH = 300;
    final int HEIGHT = 450;


    //TWedding class
    public TWedding(){
        super("My Frame");
        //sets the width and height of the frame
        // setSize(WIDTH,HEIGHT);
        setLayout(new BorderLayout());
        //creates a new gridlayout for the labels, buttons, and text fields
        JPanel gridPanel1 = new JPanel(new GridLayout(0, 1));
        //adds our elements to the grid layout.
        gridPanel1.add(heading);
        gridPanel1.add(bfnLabel);
        gridPanel1.add(enterBFN);
        gridPanel1.add(blnLabel);
        gridPanel1.add(enterBLN);
        gridPanel1.add(gfnLabel);
        gridPanel1.add(enterGFN);
        gridPanel1.add(glnLabel);
        gridPanel1.add(enterGLN);
        gridPanel1.add(locLabel);
        gridPanel1.add(enterLoc);
        gridPanel1.add(dateLabel);
        gridPanel1.add(enterDate);
        gridPanel1.add(cakeLabel);
        gridPanel1.add(enterCake);
        gridPanel1.add(weddingSummary1);
        gridPanel1.add(weddingSummary2);
        //sets the size and color of title text
        heading.setFont(bigFont);
        heading.setForeground(Color.red);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adds an action listener to the button
        press.addActionListener(this);
        //creates a new flowlayout for the confirm button
        JPanel button = new JPanel(new FlowLayout());
        button.add(press);

        //adds the panels to the frame
        add(gridPanel1, BorderLayout.NORTH);
        add(CakePanel, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Updates the empty strings with the user input and adds the values to the classes
        String bfn = enterBFN.getText();
        String bln = enterBLN.getText();
        Person bride = new Person(bfn, bln);
        String gfn = enterGFN.getText();
        String gln = enterGLN.getText();
        Person groom = new Person(gfn, gln);
        Couple c1 = new Couple(bride, groom);
        String locate = enterLoc.getText();
        LocalDate time = LocalDate.parse(enterDate.getText());
        String cl = enterCake.getText();
        int layers = (Integer.parseInt(cl));
        Wedding w1 = new Wedding(c1, time, locate, layers);
        String wedsum1 = "Please join us for the wedding of " + w1.getc1().getp1().getFName() + " " + w1.getc1().getp1().getLName() + " and " + w1.getc1().getp2().getFName() + " " + w1.getc1().getp2().getLName() + "!";
        String wedsum2 = "It will be at " + w1.getLocation() + " on " + w1.getLocalDate() + "! There will be a " + w1.getCake() + "-tier cake!";
        weddingSummary1.setText(wedsum1);
        weddingSummary2.setText(wedsum2);

    }
    //main function that runs the Party Class

    /*class cakePanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawCake(g, 10, 10, 20);

        }

    }*/
    class CakePanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawCake(g, 50, 50, 50);
            drawFrosting(g, 50, 50, 40);
            drawSprinkles(g, 100, 100, 100);

        }
        private void drawCake(Graphics g, int x, int y, int radius) {
            int diameter = radius * 2;
            g.setColor(new Color(120, 60, 0));
            g.fillOval(x-radius + 110, y -radius, diameter + 50, diameter + 50);
        }
        private void drawFrosting(Graphics g, int x, int y, int radius) {
            int diameter = radius * 2;
            g.setColor(new Color(255, 200, 255));
            g.fillOval(x - radius + 110, y - radius, diameter + 50, diameter + 50);
        }
        private void drawSprinkles(Graphics g, int x, int y, int sideLength) {
            g.setColor(new Color(255, 51, 150));

            int totalSprinkles = 30;

            Random random = new Random();

            // Draw multiple scattered smaller squares
            for (int i = 0; i < totalSprinkles; i++)
            {
                int sprinkleSize = sideLength / 20;
                int sprinkleXcoord = x - sideLength / 2 + random.nextInt(sideLength);
                int sprinkleYcoord = y - sideLength / 2 + random.nextInt(sideLength);

                g.fillRect(sprinkleXcoord + 85, sprinkleYcoord - 30, sprinkleSize, sprinkleSize);
            }


            //private void drawSprinkles(Graphics g, int x, int y, int sideLength) {
            //  g.setColor(new Color(0, 0, 0));
            // g.fillRect(x-sideLength / 10, y -sideLength / 10, sideLength, sideLength);
        }
        public Dimension getPreferredSize(){
            return new Dimension(300, 100);
        }
    }

    public static void main(String[] args) {
        TWedding frame = new TWedding();
        frame.setSize(500, 600);

        TWedding ex = new TWedding();
        ex.setVisible(true);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}