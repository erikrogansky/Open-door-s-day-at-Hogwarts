package GUIPackage;

import GamePackage.Player;
import GamePackage.Waiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * In this class where a GUI with statistics is created.
 */
public class StatsGUI extends JFrame{
    /**
     * A variable to store the player
     */
    private Player player;
    /**
     * A variable to store the Boolean value that represents if all the actions in this class are done
     */
    private Boolean done;

    /**
     * This constructor creates a GUI that displays the players statistics.
     * @param builder the builder of the stats
     */
    public StatsGUI(StatsBuilder builder) {
        super(builder.super_title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(500, 550);

        this.player = builder.player;

        final int[] i = {4};
        final String[] bcg_dir = {"img/statsG.jpg", "img/statsR.jpg", "img/statsH.jpg", "img/statsS.jpg", "img/stats.jpg"};
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
                ImageIcon image = new ImageIcon(bcg_dir[i[0]]);
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
                try {
                    if (menu.getExit() == true)
                        dispose();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
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

        JLabel title = new JLabel(builder.super_title + ":");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(houseColor[i[0]]);
        JPanel titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(0, 85));
        titlePanel.setOpaque(false);
        titlePanel.add(title);
        everythingPanel.add(titlePanel);


        everythingPanel.add(spacerPanel2);

        JPanel statsPanel = new JPanel(new GridLayout(0, 2, 0, 10));
        statsPanel.setOpaque(false);
        statsPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));

        JLabel label = new JLabel("Name:");
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(houseColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel(builder.name);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(houseColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel("Gender:");
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(houseColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel(builder.gender);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(houseColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel("House:");
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(houseColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel(builder.house);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(houseColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel("Interests:");
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(houseColor[i[0]]);
        statsPanel.add(label);

        JLabel interestLabel = new JLabel(builder.interests[0]);
        interestLabel.setHorizontalAlignment(JLabel.LEFT);
        interestLabel.setFont(new Font("Arial", Font.BOLD, 20));
        interestLabel.setForeground(houseColor[i[0]]);
        statsPanel.add(interestLabel);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int j = 0;
                while (true) {
                    interestLabel.setText(builder.interests[j]);
                    interestLabel.repaint();
                    if (j == builder.interests.length - 1)
                        j = 0;
                    else
                        j++;
                    try {
                        Thread.sleep(750);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread.start();

        label = new JLabel("Points earned:");
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(houseColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel(builder.points + "/48");
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(houseColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel("Rewards:");
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(houseColor[i[0]]);
        statsPanel.add(label);

        label = new JLabel();
        statsPanel.add(label);

        if (builder.rewards[0].equals("A house scarf")) {
            label = new JLabel("A house scarf");
            label.setForeground(houseColor[i[0]]);
        }
        else {
            label = new JLabel("<html><strike>A house scarf</strike><html>");
            label.setForeground(Color.RED);
        }
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setFont(new Font("Arial", Font.BOLD, 19));
        statsPanel.add(label);

        if (builder.rewards[1].equals("A goblet")) {
            label = new JLabel("A goblet");
            label.setForeground(houseColor[i[0]]);
        }
        else {
            label = new JLabel("<html><strike>A goblet</strike><html>");
            label.setForeground(Color.RED);
        }
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setFont(new Font("Arial", Font.BOLD, 19));
        statsPanel.add(label);

        if (builder.rewards[2].equals("An owl")) {
            label = new JLabel("An owl");
            label.setForeground(houseColor[i[0]]);
        }
        else {
            label = new JLabel("<html><strike>An owl</strike><html>");
            label.setForeground(Color.RED);
        }
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setFont(new Font("Arial", Font.BOLD, 19));
        statsPanel.add(label);

        if (builder.rewards[3].equals("Felix Felicis")) {
            label = new JLabel("Felix Felicis");
            label.setForeground(houseColor[i[0]]);
        }
        else {
            label = new JLabel("<html><strike>Felix Felicis</strike><html>");
            label.setForeground(Color.RED);
        }
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setFont(new Font("Arial", Font.BOLD, 19));
        statsPanel.add(label);

        if (builder.rewards[4].equals("A wand")) {
            label = new JLabel("A wand");
            label.setForeground(houseColor[i[0]]);
        }
        else {
            label = new JLabel("<html><strike>A wand</strike><html>");
            label.setForeground(Color.RED);
        }
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setFont(new Font("Arial", Font.BOLD, 19));
        statsPanel.add(label);

        if (builder.rewards[5].equals("Firebolt")) {
            label = new JLabel("Firebolt");
            label.setForeground(houseColor[i[0]]);
        }
        else {
            label = new JLabel("<html><strike>Firebolt</strike><html>");
            label.setForeground(Color.RED);
        }
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setFont(new Font("Arial", Font.BOLD, 19));
        statsPanel.add(label);

        everythingPanel.add(statsPanel);

        everythingPanel.add(spacerPanel3);

        JButton button = new JButton("Finish");
        button.setPreferredSize(new Dimension(90, 35));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.setForeground(bcgColor[i[0]]);
        button.setBackground(houseColor[i[0]]);
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

    /**
     * This is a method that uses {@link Waiter} class to wait until everything in this class is done.
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     * @return the boolean value of {@link #done}
     */
    public Boolean ifDone() throws InterruptedException {
        new Waiter().wait(() -> done);
        return done;
    }
}
