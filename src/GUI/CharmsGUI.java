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
        setUndecorated(true);
        setSize(1000, 700); //750x525

        this.player = player;

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
                ImageIcon image = new ImageIcon("img/charms.jpg");
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
        spacerPanel2.setPreferredSize(new Dimension(0, 5));
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
        storyPanel.setPreferredSize(new Dimension(0, 490));
        storyPanel.setOpaque(false);
        storyPanel.add(story);
        everythingPanel.add(storyPanel);

        Thread storyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String storyStr = "<html><div style='text-align:center'>Welcome to Hogwarts, young " + player.getGender('s') + "! I am Professor Flitwick, and I teach Charms at this prestigious school <br> of magic. Today is Open Door's day, and I am excited to show you the wonders of the Charms Classroom.<br>" +
                        "<br>" +
                        "Charms is one of the most important subjects taught at Hogwarts because it helps students <br> to develop their magical abilities. Charms allow us to perform spells that can do anything from <br> cleaning up a room to levitating objects to even protecting us from danger.<br>" +
                        "<br>" +
                        "Now, let me show you some of the basic spells that we teach here at Hogwarts. One of the first spells you will learn <br> is the Wingardium Leviosa. This spell allows you to levitate an object and move it around at your will. It requires a lot of <br> concentration and precise wand movements, but with practice, you'll be able to move even the heaviest objects with ease.<br>" +
                        "<br>" +
                        "Another spell that we teach is the Lumos. This spell creates a beam of light at the tip <br> of your wand, which can be useful for exploring dark areas or reading books at night. This spell is also handy <br> if you want to impress your friends with some cool wand tricks.<br>" +
                        "<br>" +
                        "We also teach spells that can protect you from danger. The Protego charm creates a magical shield <br> that can block spells and curses. It's a vital spell for defending yourself in battle.<br>" +
                        "<br>" +
                        "Charms classes at Hogwarts are always exciting because we're always learning new spells and discovering new ways to <br> use them. The possibilities are endless, and it's up to you to decide how to use your magical abilities for good.<br>" +
                        "<br>" +
                        "I hope you enjoyed this short introduction to Charms, young wizard. I look forward to seeing you in my classroom next year!</div></html>";
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
