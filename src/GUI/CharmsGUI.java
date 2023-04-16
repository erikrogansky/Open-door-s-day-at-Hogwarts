package GUI;

import Game.Player;
import Game.Waiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharmsGUI extends JFrame{
    private Player player;
    private Boolean done;
    private Boolean readTheWholeStory = false;
    public CharmsGUI(Player player) {
        super("Welcome to the Charms Classroom");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700); //750x525

        this.player = player;

        JDialog pauseDialog = new JDialog(this, "Paused", true);
        pauseDialog.setUndecorated(true);
        pauseDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        pauseDialog.setSize(0, 0);
        pauseDialog.setLocationRelativeTo(null);

        final String[] bcg_dir = {"img/charmsG.jpg", "img/charmsR.jpg", "img/charmsH.jpg", "img/charmsS.jpg", "img/charms.jpg"};
        final int[] i = {4};
        final Color[] houseColor = {new Color(238, 186, 48), new Color(148, 107, 45), new Color(125, 107, 93), new Color(170, 170, 170), Color.BLACK};
        final Color[] bcgColor = {new Color(116, 0, 1), new Color(15, 29, 74), new Color(238, 186, 53), new Color(26, 71, 42), Color.BLACK};

        switch (this.player.getHouse()) {
            case "Gryffindor" -> i[0] = 0;
            case "Ravenclaw" -> i[0] = 1;
            case "Hufflepuff" -> i[0] = 2;
            case "Slytherin" -> i[0] = 3;
            default -> i[0] = 4;
        }

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon image = new ImageIcon("img/welcome.jpg");
                Image img = image.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
            }
        };

        panel.setLayout(new BorderLayout());

        JPanel everythingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, panel.getWidth() + 10, 100 + panel.getHeight()));
        everythingPanel.setOpaque(false);

        everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));

        JPanel spacerPanel1 = new JPanel();
        spacerPanel1.setPreferredSize(new Dimension(0, 45));
        spacerPanel1.setOpaque(false);
        spacerPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        ImageIcon menu = new ImageIcon("img/menu1.png");
        JButton menuButton = new JButton(menu);
        menuButton.setVerticalTextPosition(JButton.CENTER);
        menuButton.setHorizontalTextPosition(JButton.LEFT);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorderPainted(false);
        menuButton.setForeground(bcgColor[i[0]]);
        menuButton.setBackground(houseColor[i[0]]);
        menuButton.setPreferredSize(new Dimension(40, 40));
        menuButton.setHorizontalAlignment(JButton.CENTER);
        menuButton.setVerticalAlignment(JButton.CENTER);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu(player, CharmsGUI.this);
                if (menu.getExit() == true)
                    dispose();
            }
        });
        spacerPanel1.add(menuButton);

        everythingPanel.add(spacerPanel1);

        JPanel spacerPanel2 = new JPanel();
        spacerPanel2.setPreferredSize(new Dimension(0, 12));
        spacerPanel2.setOpaque(false);

        JPanel spacerPanel3 = new JPanel();
        spacerPanel3.setPreferredSize(new Dimension(0, 10));
        spacerPanel3.setOpaque(false);

        JPanel spacerPanel4 = new JPanel();
        spacerPanel4.setPreferredSize(new Dimension(0, 20));
        spacerPanel4.setOpaque(false);

        JPanel spacerPanel5 = new JPanel();
        spacerPanel5.setPreferredSize(new Dimension(0, 23));
        spacerPanel5.setOpaque(false);

        JLabel title = new JLabel("Welcome to the Charms Classroom!");
        title.setPreferredSize(new Dimension(700, 55));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setOpaque(true);
        title.setForeground(houseColor[i[0]]);
        title.setBackground(bcgColor[i[0]]);
        JPanel titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(0, 85));
        titlePanel.setOpaque(false);
        titlePanel.add(title);
        everythingPanel.add(titlePanel);


        everythingPanel.add(spacerPanel2);



        JLabel story = new JLabel();
        story.setHorizontalAlignment(JLabel.CENTER);
        story.setFont(new Font("Arial", Font.PLAIN, 18));
        story.setOpaque(true);
        story.setForeground(houseColor[i[0]]);
        story.setBackground(bcgColor[i[0]]);
        JPanel storyPanel = new JPanel();
        storyPanel.setPreferredSize(new Dimension(0, 450));
        storyPanel.setOpaque(false);
        storyPanel.add(story);
        everythingPanel.add(storyPanel);

        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String storyStr = "<html><div style='text-align:center'>Greetings to all our guests and visitors on this special occasion of Open Door's Day at Hogwarts <br> School of Witchcraft and Wizardry. I am Albus Dumbledore, the headmaster of this venerable institution, <br> and I am delighted to have you here today.<br>" +
                        "<br>" +
                        "Hogwarts is more than just a school. It is a home, a family, a community of magical beings <br> who share a common passion for learning and discovery. Here, you will find not only classrooms and teachers,<br> but also friends and mentors challenges and adventures, secrets and mysteries.<br>" +
                        "<br>" +
                        "You are invited to explore our magnificent castle and grounds, <br> to witness the wonders of magic in action, to meet our talented and diverse students and staff, <br> and to experience the rich history and culture of our school. You will also have the opportunity <br> to learn more about our four houses: Gryffindor, Hufflepuff, Ravenclaw and Slytherin. <br> Each house has its own values, traditions and spirit that shape the character and destiny of its members.<br>" +
                        "<br>" +
                        "Whether you are a prospective student or parent, a curious muggle or a fellow wizard or witch, <br> we hope that you will enjoy your visit to Hogwarts and that you will leave with a sense of awe <br> and admiration for our magical world. We also hope that you will feel inspired by our motto:<br> \"Draco dormiens nunquam titillandus\", which means \"Never tickle a sleeping dragon\".<br>" +
                        "<br>" +
                        "Thank you for your attention and have a wonderful day!</div></html>";
                String builder = "";
                for (char character : storyStr.toCharArray()){
                    builder += character;
                    story.setText(builder);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                readTheWholeStory = true;
            }
        });
        // Start the thread
        storyThread.start();


        everythingPanel.add(spacerPanel3);

        JButton button = new JButton("Continue");
        button.setPreferredSize(new Dimension(90, 35));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.setForeground(houseColor[i[0]]);
        button.setBackground(bcgColor[i[0]]);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                done = true;
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(button);
        everythingPanel.add(buttonPanel, BorderLayout.SOUTH);

        panel.add(everythingPanel, BorderLayout.NORTH);


        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }
    public Boolean ifDone() {
        new Waiter().wait(() -> done);
        return done;
    }
    public Boolean getRead() {
        return readTheWholeStory;
    }
}
