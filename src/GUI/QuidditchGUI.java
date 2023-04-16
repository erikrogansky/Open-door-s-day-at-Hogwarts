package GUI;

import Game.Player;
import Game.Waiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class QuidditchGUI extends JFrame{
    private Player player;
    private Boolean done;
    private Boolean readTheWholeStory = false;
    public QuidditchGUI(Player player) {
        super("Welcome to the Quidditch Stadium");
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
                ImageIcon image = new ImageIcon("img/quidditch.png");
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
                Menu menu = new Menu(player, QuidditchGUI.this);
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

        JLabel title = new JLabel("Welcome to the Quidditch Stadium!");
        title.setPreferredSize(new Dimension(850, 55));
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
                String storyStr = "<html><div style='text-align:center'>Welcome to the Quidditch stadium, young athlete! I am Professor Sprout, <br> and I am in charge of the Quidditch team at Hogwarts.<br>" +
                        "<br>" +
                        "Quidditch is not just a game. It's a way of life. It's about strength, agility, and teamwork. It's about pushing your limits <br> and reaching for the stars. And here at Hogwarts, we take Quidditch very seriously.<br>" +
                        "<br>" +
                        "In my Quidditch practices, we work hard, we sweat, and we strive to be the best. I demand nothing <br> but the best from my players. I expect discipline, commitment, and a hunger for victory. <br> If you're not willing to give it your all, then you're not cut out for the team.<br>" +
                        "<br>" +
                        "But don't let my strict demeanor fool you. I am full of energy, and I always bring my A-game to every practice. <br> I will push you to your limits, but I will also be your biggest cheerleader when you need it most. I will be there to <br> celebrate your victories and to pick you up when you fall.<br>" +
                        "<br>" +
                        "In my Quidditch practices, we focus on all aspects of the game. We work on improving your flying skills, your accuracy, <br> and your teamwork. We also practice various strategies and techniques to give you an edge on the field.<br>" +
                        "<br>" +
                        "But most importantly, we learn to trust each other. Quidditch is not a game that can be won alone. It takes a team effort <br> to come out on top. We learn to communicate, to rely on each other's strengths, and to cover each other's weaknesses.<br>" +
                        "<br>" +
                        "So, if you're ready to push yourself to your limits and to be part of an incredible team, then welcome to my Quidditch <br> stadium. I promise you that you will leave here not just as a better athlete, but as a better person too.</div></html>";
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

        everythingPanel.setFocusable(true);
        everythingPanel.requestFocus();
        everythingPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    menuButton.doClick();
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    button.doClick();
                }
            }
        });

        panel.add(everythingPanel, BorderLayout.NORTH);

        everythingPanel.requestFocus();

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
