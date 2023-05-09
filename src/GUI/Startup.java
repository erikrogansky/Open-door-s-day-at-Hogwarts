package GUI;

import Game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * In this class a login GUI is created.
 */
public class Startup extends JFrame {
    private String login;
    private Boolean newGame;
    public Startup() {
        super("Welcome to Hogwarts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);

        // Create a panel with a background image
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
        spacerPanel1.setPreferredSize(new Dimension(0, 115));
        spacerPanel1.setOpaque(false);
        everythingPanel.add(spacerPanel1);

        JPanel spacerPanel2 = new JPanel();
        spacerPanel2.setPreferredSize(new Dimension(0, 100));
        spacerPanel2.setOpaque(false);

        JPanel spacerPanel5 = new JPanel();
        spacerPanel5.setPreferredSize(new Dimension(0, 40));
        spacerPanel5.setOpaque(false);

        everythingPanel.add(spacerPanel1);

        ImageIcon title_image = new ImageIcon("img/title.png");
        Image img = title_image.getImage(); // transform it
        Image newimg = img.getScaledInstance(800, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        title_image = new ImageIcon(newimg);
        JLabel title = new JLabel(title_image);
        title.setBounds(0, 0, 500, 200);
        JPanel titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(0, 180));
        titlePanel.setOpaque(false);
        titlePanel.add(title);
        everythingPanel.add(titlePanel);

        everythingPanel.add(spacerPanel2);

        JTextField textField = new JTextField(20) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (getText().isEmpty()) {
                    g.setColor(getForeground());
                    String ghostText = "Enter username: ";
                    g.drawString(ghostText, getInsets().left, g.getFontMetrics().getHeight() + getInsets().top);
                }
            }
        };
        textField.setPreferredSize(new Dimension(200, 40));
        Font font = new Font("Arial", Font.PLAIN, 20);
        textField.setFont(font);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBackground(new Color(121, 139, 146));
        textField.setForeground(Color.WHITE);

        JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10 + panel.getHeight()));
        textFieldPanel.setOpaque(false);
        textFieldPanel.add(textField);
        everythingPanel.add(textFieldPanel, BorderLayout.NORTH);

        everythingPanel.add(spacerPanel5);

        ImageIcon buttonIcon = new ImageIcon("img/login.jpg");
        JButton button = new JButton(buttonIcon);
        button.setPreferredSize(new Dimension(buttonIcon.getIconWidth(), buttonIcon.getIconHeight()));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login = textField.getText();
                newGame = false;
                dispose();
            }
        });
        buttonIcon = new ImageIcon("img/newgame.png");
        JButton button2 = new JButton(buttonIcon);
        button2.setPreferredSize(new Dimension(buttonIcon.getIconWidth(), buttonIcon.getIconHeight()));
        button2.setHorizontalAlignment(JButton.CENTER);
        button2.setVerticalAlignment(JButton.CENTER);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login = textField.getText();
                newGame = true;
                dispose();
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(button);
        buttonPanel.add(button2);
        everythingPanel.add(buttonPanel, BorderLayout.SOUTH);

        panel.add(everythingPanel, BorderLayout.NORTH);


        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.doClick();
            }
        });
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (button.isSelected()) {
                        button.doClick();
                    } else if (button2.isSelected()) {
                        button2.doClick();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    button.setSelected(true);
                    button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
                    button2.setSelected(false);
                    button2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 0));
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    button.setSelected(false);
                    button.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 0));
                    button2.setSelected(true);
                    button2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
                }
            }
        });


        // Add the panel to the window
        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public String getLogin() throws InterruptedException {
        new Waiter().wait(() -> login);
        return login;
    }
    public Boolean getBool() throws InterruptedException {
        new Waiter().wait(() -> newGame);
        return newGame;
    }

}
