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
 * In this class where a GUI with "the end" title is created.
 */
public class TheEndGUI extends JFrame{
    /**
     * A variable to store the player
     */
    private Player player;
    /**
     * A variable to store the Boolean value that represents if all the actions in this class are done
     */
    private Boolean done;
    /**
     * A variable to store the Boolean value that represents if the player wants to end the game or go back to the stats
     */
    private boolean back_or_finish;

    /**
     * This constructor creates a GUI with a simple text "The End" and two buttons. One for ending the game and the other for returning to the stats window.
     * Player can navigate using a keyboard or mouse.
     * @param player the player
     */
    public TheEndGUI(Player player) {
        super("The End");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(400, 250);

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
                ImageIcon image = new ImageIcon("img/bcg.jpg");
                Image img = image.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
            }
        };

        panel.setLayout(new BorderLayout());

        JPanel everythingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, panel.getWidth() + 10, 100 + panel.getHeight()));
        everythingPanel.setOpaque(false);

        everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));

        JPanel spacerPanel1 = new JPanel();
        spacerPanel1.setPreferredSize(new Dimension(0, 40));
        spacerPanel1.setOpaque(false);
        spacerPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        everythingPanel.add(spacerPanel1);

        JPanel spacerPanel2 = new JPanel();
        spacerPanel2.setPreferredSize(new Dimension(0, 30));
        spacerPanel2.setOpaque(false);

        JPanel spacerPanel3 = new JPanel();
        spacerPanel3.setPreferredSize(new Dimension(0, 10));
        spacerPanel3.setOpaque(false);

        everythingPanel.add(spacerPanel2);

        JLabel title = new JLabel("The End!");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setOpaque(true);
        title.setForeground(houseColor[i[0]]);
        title.setBackground(bcgColor[i[0]]);
        JPanel titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(0, 85));
        titlePanel.setOpaque(false);
        titlePanel.add(title);
        everythingPanel.add(titlePanel);


        everythingPanel.add(spacerPanel3);

        JButton button = new JButton("Back");
        button.setPreferredSize(new Dimension(90, 35));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.setForeground(houseColor[i[0]]);
        button.setBackground(bcgColor[i[0]]);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                back_or_finish = true;
                done = true;
            }
        });

        JButton endButton = new JButton("Finish");
        endButton.setPreferredSize(new Dimension(90, 35));
        endButton.setHorizontalAlignment(JButton.CENTER);
        endButton.setVerticalAlignment(JButton.CENTER);
        endButton.setForeground(houseColor[i[0]]);
        endButton.setBackground(bcgColor[i[0]]);
        endButton.setSelected(true);
        endButton.setBorder(BorderFactory.createLineBorder(houseColor[i[0]], 3));
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                back_or_finish = false;
                done = true;
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(button);
        buttonPanel.add(endButton);
        everythingPanel.add(buttonPanel, BorderLayout.SOUTH);

        everythingPanel.setFocusable(true);
        everythingPanel.requestFocus();
        everythingPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (button.isSelected()) {
                        button.doClick();
                    } else if (endButton.isSelected()) {
                        endButton.doClick();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    button.setSelected(true);
                    button.setBorder(BorderFactory.createLineBorder(houseColor[i[0]], 3));
                    endButton.setSelected(false);
                    endButton.setBorder(BorderFactory.createLineBorder(houseColor[i[0]], 0));
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    button.setSelected(false);
                    button.setBorder(BorderFactory.createLineBorder(houseColor[i[0]], 0));
                    endButton.setSelected(true);
                    endButton.setBorder(BorderFactory.createLineBorder(houseColor[i[0]], 3));
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

    /**
     * This method is to get the value of {@link #back_or_finish} which indicates if the game should end or the player
     * wants to go back to {@link StatsGUI} window.
     * @return the value of {@link #back_or_finish}
     */
    public boolean ifBack() {
        return back_or_finish;
    }
}
