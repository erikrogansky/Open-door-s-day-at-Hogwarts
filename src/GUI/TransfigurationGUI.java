package GUI;

import Game.Player;
import Game.Waiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TransfigurationGUI extends JFrame{
    private Player player;
    private Boolean done;
    private Boolean readTheWholeStory = false;
    public TransfigurationGUI(Player player) {
        super("Welcome to the Transfiguration Classroom");
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
                ImageIcon image = new ImageIcon("img/transfiguration.png");
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
                Menu menu = new Menu(player, TransfigurationGUI.this);
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

        JLabel title = new JLabel("Welcome to the Transfiguration Classroom!");
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
                String storyStr = "<html><div style='text-align:center'>Welcome to the Transfiguration classroom, young " + player.getGender('s') + ". I am Professor McGonagall, <br> and I am the head of the Transfiguration department at Hogwarts.<br>" +
                        "<br>" +
                        "Transfiguration is a complex branch of magic that involves transforming one object into another. It requires precision, <br> skill, and a deep understanding of the laws of magic. And let me tell you, it is not a subject for the faint-hearted.<br>" +
                        "<br>" +
                        "Here in my classroom, we focus on developing your abilities to transform objects into <br> animals or even completely different objects. You will learn how to transfigure a teapot into a tortoise <br> or a rat into a snuffbox. But beware, this is not a subject for those who lack discipline or patience.<br>" +
                        "<br>" +
                        "Transfiguration requires hours of practice and rigorous attention to detail. Every movement of your wand and every <br> incantation you utter must be precise. One wrong word, one flick of the wrist, and the consequences could be disastrous.<br>" +
                        "<br>" +
                        "But don't let that intimidate you. With hard work and dedication, you too can master <br> the art of Transfiguration. And once you do, the possibilities are endless. You can turn a rock into a bird, <br> a table into a human, and even make objects disappear altogether.<br>" +
                        "<br>" +
                        "TBut remember, with great power comes great responsibility. Transfiguration is not to be taken <br> lightly. It is a powerful branch of magic that must be used wisely and with caution.<br>" +
                        "<br>" +
                        "So, if you're up for the challenge and are willing to put in the effort, then welcome to my classroom. But be warned, <br> I have high expectations for my students. I expect nothing less than the best from each and every one of you.</div></html>";
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
