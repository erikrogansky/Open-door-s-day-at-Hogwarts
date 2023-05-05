package GUI;

import Game.Player;
import Game.Waiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StatsGUI extends JFrame{
    private Player player;
    private Boolean done;
    private String[] myAnswers = new String[8];
    public StatsGUI(Player player, String[][] information) {
        super("Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(500, 550);

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
                Menu menu = new Menu(player, StatsGUI.this);
                if (menu.getExit() == true)
                    dispose();
            }
        });

        spacerPanel1.add(menuButton);

        everythingPanel.add(spacerPanel1);

        JPanel spacerPanel2 = new JPanel();
        spacerPanel2.setPreferredSize(new Dimension(0, 10));
        spacerPanel2.setOpaque(false);

        JPanel spacerPanel3 = new JPanel();
        spacerPanel3.setPreferredSize(new Dimension(0, 25));
        spacerPanel3.setOpaque(false);

        JPanel spacerPanel4 = new JPanel();
        spacerPanel4.setPreferredSize(new Dimension(0, 20));
        spacerPanel4.setOpaque(false);

        JPanel spacerPanel5 = new JPanel();
        spacerPanel5.setPreferredSize(new Dimension(0, 23));
        spacerPanel5.setOpaque(false);

        JLabel title = new JLabel("Your statistics: ");
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

        JPanel statsPanel = new JPanel(new GridLayout(0, 2, 40, 10));
        statsPanel.setOpaque(false);
        statsPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));

        JLabel label = new JLabel("Name:");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel(information[0][0]);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel("Gender:");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel(information[1][0]);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel("House:");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel(information[2][0]);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel("Interests:");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        JLabel interestLabel = new JLabel(information[3][0]);
        interestLabel.setHorizontalAlignment(JLabel.CENTER);
        interestLabel.setFont(new Font("Arial", Font.BOLD, 20));
        interestLabel.setOpaque(true);
        interestLabel.setForeground(houseColor[i[0]]);
        interestLabel.setBackground(bcgColor[i[0]]);
        statsPanel.add(interestLabel);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int j = 1;
                while (true) {
                    try {
                        Thread.sleep(750);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    interestLabel.setText(information[3][j]);
                    interestLabel.repaint();
                    if (j == information[3].length - 1)
                        j = 0;
                    else
                        j++;
                }
            }
        });
        thread.start();

        label = new JLabel("Points earned:");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel(information[4][0] + "/48");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel("Rewards:");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel();
        statsPanel.add(label);

        label = new JLabel("A house scarf");
        label.setHorizontalAlignment(JLabel.CENTER);
        if (information[5][0].equals("A house scarf"))
            label.setFont(new Font("Arial", Font.BOLD, 20));
        else
            label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel("A goblet");
        label.setHorizontalAlignment(JLabel.CENTER);
        if (information[5][1].equals("A goblet"))
            label.setFont(new Font("Arial", Font.BOLD, 20));
        else
            label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel("An owl");
        label.setHorizontalAlignment(JLabel.CENTER);
        if (information[5][2].equals("An owl"))
            label.setFont(new Font("Arial", Font.BOLD, 20));
        else
            label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel("Felix Felicis");
        label.setHorizontalAlignment(JLabel.CENTER);
        if (information[5][3].equals("Felix Felicis"))
            label.setFont(new Font("Arial", Font.BOLD, 20));
        else
            label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel("A wand");
        label.setHorizontalAlignment(JLabel.CENTER);
        if (information[5][4].equals("A wand"))
            label.setFont(new Font("Arial", Font.BOLD, 20));
        else
            label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel("Firebolt");
        label.setHorizontalAlignment(JLabel.CENTER);
        if (information[5][5].equals("Firebolt"))
            label.setFont(new Font("Arial", Font.BOLD, 20));
        else
            label.setFont(new Font("Arial", Font.PLAIN, 15));;
        label.setOpaque(true);
        label.setForeground(houseColor[i[0]]);
        label.setBackground(bcgColor[i[0]]);
        statsPanel.add(label);

        everythingPanel.add(statsPanel);

        everythingPanel.add(spacerPanel3);

        JButton button = new JButton("Finish");
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

    public String[] getAnswers() {
        return myAnswers;
    }
}
