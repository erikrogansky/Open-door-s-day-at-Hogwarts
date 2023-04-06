package GUI;

import Game.Player;
import Game.Waiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CharmsGUI extends JFrame {
    private Player player;
    private Boolean done;
    public CharmsGUI(Player player) {
        super("Welcome to Hogwarts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700); //750x525

        this.player = player;

        final String[] bcg_dir = {"img/charmsG.jpg", "img/charmsR.jpg", "img/charmsH.jpg", "img/charmsS.jpg", "img/charms.jpg"};
        final int[] i = {4};
        final Color[] houseColor = {new Color(238, 186, 48), new Color(148, 107, 45), new Color(125, 107, 93), new Color(170, 170, 170), Color.BLACK};
        final Color[] bcgColor = {new Color(116, 0, 1), new Color(15, 29, 74), new Color(238, 186, 53), new Color(26, 71, 42), Color.BLACK};

        switch (player.getHouse()) {
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
//                int imgWidth = img.getWidth(null);
//                int imgHeight = img.getHeight(null);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
            }
        };

        panel.setLayout(new BorderLayout());

        JPanel everythingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, panel.getWidth() + 10, 100 + panel.getHeight()));
        everythingPanel.setOpaque(false);

        everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));

        JPanel spacerPanel1 = new JPanel();
        spacerPanel1.setPreferredSize(new Dimension(0, 65));
        spacerPanel1.setOpaque(false);
        spacerPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        ImageIcon menu = new ImageIcon("img/menu1.png");
        JButton menuButton = new JButton(menu);
        menuButton.setVerticalTextPosition(JButton.CENTER);
        menuButton.setHorizontalTextPosition(JButton.LEFT);
        menuButton.setContentAreaFilled(false);
        menuButton.setBorderPainted(false);
        menuButton.setPreferredSize(new Dimension(40, 40));
        menuButton.setHorizontalAlignment(JButton.CENTER);
        menuButton.setVerticalAlignment(JButton.CENTER);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu(player, CharmsGUI.this);
                if (menu.getExit() == true){
                    dispose();
                    done = true;
                }
            }
        });
        spacerPanel1.add(menuButton);

        JLabel spacer = new JLabel();
        spacer.setPreferredSize(new Dimension(10, 40));
        spacerPanel1.add(spacer);

        everythingPanel.add(spacerPanel1);

        JLabel title = new JLabel("             Welcome to the Charms Classroom!");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setPreferredSize(new Dimension(760, 40));
        title.setForeground(houseColor[i[0]]);
        //title.setText("                     Your achieved a reward!");
        spacerPanel1.add(title);

        int point = this.player.getPoints();
        JLabel points = new JLabel("Your points: " + point);
        points.setFont(new Font("Arial", Font.BOLD, 20));
        points.setForeground(houseColor[i[0]]);
        points.setPreferredSize(new Dimension(140, 40));
        spacerPanel1.add(points);

        everythingPanel.add(spacerPanel1);

        JPanel spacerPanel2 = new JPanel();
        spacerPanel2.setPreferredSize(new Dimension(0, 20));
        spacerPanel2.setOpaque(false);

        JPanel spacerPanel3 = new JPanel();
        spacerPanel3.setPreferredSize(new Dimension(0, 20));
        spacerPanel3.setOpaque(false);

        JPanel spacerPanel4 = new JPanel();
        spacerPanel4.setPreferredSize(new Dimension(0, 20));
        spacerPanel4.setOpaque(false);

        JPanel spacerPanel5 = new JPanel();
        spacerPanel5.setPreferredSize(new Dimension(0, 23));
        spacerPanel5.setOpaque(false);


        everythingPanel.add(spacerPanel2);

        JPanel game = new JPanel();
        game.setPreferredSize(new Dimension(850, 500));
        game.setMaximumSize(game.getPreferredSize());
        game.setOpaque(true);
        game.setLayout(new FlowLayout(FlowLayout.CENTER));
        everythingPanel.add(game);

        everythingPanel.add(spacerPanel5);

        JButton skip = new JButton("Skip");
        skip.setPreferredSize(new Dimension(90, 35));
        skip.setHorizontalAlignment(JButton.CENTER);
        skip.setVerticalAlignment(JButton.CENTER);
        skip.setForeground(bcgColor[i[0]]);
        skip.setBackground(houseColor[i[0]]);
        skip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });



        JButton restart = new JButton("Restart");
        restart.setPreferredSize(new Dimension(90, 35));
        restart.setHorizontalAlignment(JButton.CENTER);
        restart.setVerticalAlignment(JButton.CENTER);
        restart.setForeground(bcgColor[i[0]]);
        restart.setBackground(houseColor[i[0]]);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JButton cont = new JButton("Continue");
        cont.setPreferredSize(new Dimension(90, 35));
        cont.setHorizontalAlignment(JButton.CENTER);
        cont.setVerticalAlignment(JButton.CENTER);
        cont.setForeground(bcgColor[i[0]]);
        cont.setBackground(houseColor[i[0]]);
        cont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(skip);
        buttonPanel.add(restart);
        buttonPanel.add(cont);
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
    public Player getPlayer() {
        new Waiter().wait(() -> player);
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
}
