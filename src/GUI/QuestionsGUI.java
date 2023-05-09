package GUI;

import Game.Player;
import Game.Waiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class QuestionsGUI extends JFrame{
    Player player;
    Boolean done;
    String[] myAnswers = new String[8];
    public QuestionsGUI(QuestionsBuilder builder) {
        super(builder.super_title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(1000, 700);

        this.player = builder.player;

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
                ImageIcon image = new ImageIcon(builder.image_path);
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
                Menu menu = new Menu(player, QuestionsGUI.this);
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
        spacerPanel3.setPreferredSize(new Dimension(0, 35));
        spacerPanel3.setOpaque(false);

        JPanel spacerPanel4 = new JPanel();
        spacerPanel4.setPreferredSize(new Dimension(0, 20));
        spacerPanel4.setOpaque(false);

        JPanel spacerPanel5 = new JPanel();
        spacerPanel5.setPreferredSize(new Dimension(0, 23));
        spacerPanel5.setOpaque(false);

        JLabel title = new JLabel(builder.super_title + "!");
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

        JPanel questionsPanel = new JPanel(new GridLayout(0, 2, 40, 10));
        questionsPanel.setOpaque(false);
        questionsPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));

        JPanel questionsPanel1 = new JPanel(new GridLayout(0, 1, 10, 10));
        questionsPanel1.setOpaque(false);
        questionsPanel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JPanel questionsPanel2 = new JPanel(new GridLayout(0, 1, 10, 10));
        questionsPanel2.setOpaque(false);
        questionsPanel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        questionsPanel.add(questionsPanel1);
        questionsPanel.add(questionsPanel2);

        ButtonGroup[] groups = new ButtonGroup[8];
        JRadioButton[][] allButtons = new JRadioButton[8][3];

        for (int j = 0; j < builder.myQuestions.length; j++) {
            JLabel question = new JLabel(builder.myQuestions[j]);
            question.setFont(new Font("Arial", Font.PLAIN, 17));
            question.setHorizontalAlignment(JLabel.CENTER);
            question.setOpaque(true);
            question.setBackground(bcgColor[i[0]]);
            question.setForeground(houseColor[i[0]]);
            if (j < 4)
                questionsPanel1.add(question);
            else
                questionsPanel2.add(question);

            List<String> opt = Arrays.asList(builder.myOptions[j]);
            Collections.shuffle(opt);
            opt.toArray(builder.myOptions[j]);

            JPanel answersPanel = new JPanel(new GridLayout(1, 3, 10, 10));
            answersPanel.setOpaque(false);
            answersPanel.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 1));
            ButtonGroup group = new ButtonGroup();
            JRadioButton answer = new JRadioButton(builder.myOptions[j][0]);
            answer.setActionCommand(builder.myOptions[j][0]);
            answer.setFont(new Font("Arial", Font.PLAIN, 17));
            answer.setHorizontalAlignment(JLabel.CENTER);
            answer.setOpaque(true);
            answer.setBackground(bcgColor[i[0]]);
            answer.setForeground(houseColor[i[0]]);
            group.add(answer);
            allButtons[j][0] = answer;
            answersPanel.add(answer);
            answer = new JRadioButton(builder.myOptions[j][1]);
            answer.setActionCommand(builder.myOptions[j][1]);
            answer.setFont(new Font("Arial", Font.PLAIN, 17));
            answer.setHorizontalAlignment(JLabel.CENTER);
            answer.setOpaque(true);
            answer.setBackground(bcgColor[i[0]]);
            answer.setForeground(houseColor[i[0]]);
            group.add(answer);
            allButtons[j][1] = answer;
            answersPanel.add(answer);
            answer = new JRadioButton(builder.myOptions[j][2]);
            answer.setActionCommand(builder.myOptions[j][2]);
            answer.setFont(new Font("Arial", Font.PLAIN, 17));
            answer.setHorizontalAlignment(JLabel.CENTER);
            answer.setOpaque(true);
            answer.setBackground(bcgColor[i[0]]);
            answer.setForeground(houseColor[i[0]]);
            group.add(answer);
            allButtons[j][2] = answer;
            answersPanel.add(answer);

            groups[j] = group;

            if (j < 4) {
                questionsPanel1.add(answersPanel);
                if (j < 3)
                    questionsPanel1.add(new JLabel());
            }
            else {
                questionsPanel2.add(answersPanel);
                if (j < 7)
                    questionsPanel2.add(new JLabel());
            }
        }

        everythingPanel.add(questionsPanel);

        everythingPanel.add(spacerPanel3);

        JButton button = new JButton("Confirm");
        button.setPreferredSize(new Dimension(90, 35));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.setForeground(houseColor[i[0]]);
        button.setBackground(bcgColor[i[0]]);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                for (int j = 0; j < builder.myQuestions.length; j++) {
                    try {
                        myAnswers[j] = groups[j].getSelection().getActionCommand();
                    } catch (NullPointerException ex) {
                        myAnswers[j] = "$EMPTY$";
                    }
                }
                done = true;
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(button);

        everythingPanel.add(buttonPanel, BorderLayout.SOUTH);

        everythingPanel.setFocusable(true);

        panel.add(everythingPanel, BorderLayout.NORTH);

        everythingPanel.requestFocus();
        buttonPanel.setFocusable(true);
        final int[] buttonIndex = {0};
        final int[] buttonGroupIndex = {0};
        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(houseColor[i[0]]);
        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(bcgColor[i[0]]);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(houseColor[i[0]]);
                button.setForeground(bcgColor[i[0]]);
                buttonPanel.requestFocus();
                allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(bcgColor[i[0]]);
                allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(houseColor[i[0]]);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bcgColor[i[0]]);
                button.setForeground(houseColor[i[0]]);
            }
        });

        for (int j = 0; j < allButtons.length; j++) {
            for (int j1 = 0; j1 < allButtons[j].length; j1++) {
                int finalJ = j1;
                int finalJ1 = j;
                allButtons[j][j1].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(bcgColor[i[0]]);
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(houseColor[i[0]]);
                        button.setBackground(bcgColor[i[0]]);
                        button.setForeground(houseColor[i[0]]);
                        buttonGroupIndex[0] = finalJ1;
                        buttonIndex[0] = finalJ;
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(houseColor[i[0]]);
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(bcgColor[i[0]]);
                        everythingPanel.requestFocus();
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        button.setBackground(bcgColor[i[0]]);
                        button.setForeground(houseColor[i[0]]);
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(bcgColor[i[0]]);
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(houseColor[i[0]]);
                        buttonGroupIndex[0] = finalJ1;
                        buttonIndex[0] = finalJ;
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(houseColor[i[0]]);
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(bcgColor[i[0]]);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        int temp1 = buttonGroupIndex[0];
                        int temp2 = buttonIndex[0];
                        buttonGroupIndex[0] = finalJ1;
                        buttonIndex[0] = finalJ;
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(bcgColor[i[0]]);
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(houseColor[i[0]]);
                        buttonGroupIndex[0] = temp1;
                        buttonIndex[0] = temp2;
                    }
                });
            }
        }
        everythingPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    menuButton.doClick();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(bcgColor[i[0]]);
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(houseColor[i[0]]);
                    buttonGroupIndex[0]++;
                    if (buttonGroupIndex[0] == 4 || buttonGroupIndex[0] == 8) {
                        buttonGroupIndex[0]--;
                        buttonPanel.requestFocus();
                        button.setBackground(houseColor[i[0]]);
                        button.setForeground(bcgColor[i[0]]);
                    } else {
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(houseColor[i[0]]);
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(bcgColor[i[0]]);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(bcgColor[i[0]]);
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(houseColor[i[0]]);
                    buttonGroupIndex[0]--;
                    if (buttonGroupIndex[0] == -1 || buttonGroupIndex[0] == 3) {
                        buttonGroupIndex[0]++;
                        buttonPanel.requestFocus();
                        button.setBackground(houseColor[i[0]]);
                        button.setForeground(bcgColor[i[0]]);
                        if (buttonGroupIndex[0] == 0)
                            buttonGroupIndex[0] = 3;
                        else
                            buttonGroupIndex[0] = 7;
                    } else {
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(houseColor[i[0]]);
                        allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(bcgColor[i[0]]);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(bcgColor[i[0]]);
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(houseColor[i[0]]);
                    buttonIndex[0]++;
                    if (buttonIndex[0] == 3) {
                        buttonGroupIndex[0] += 4;
                        buttonGroupIndex[0] %= 8;
                        buttonIndex[0] = 0;
                    }
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(houseColor[i[0]]);
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(bcgColor[i[0]]);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(bcgColor[i[0]]);
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(houseColor[i[0]]);
                    buttonIndex[0]--;
                    if (buttonIndex[0] < 0) {
                        buttonGroupIndex[0] += 4;
                        buttonGroupIndex[0] %= 8;
                        buttonIndex[0] = 2;
                    }
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(houseColor[i[0]]);
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(bcgColor[i[0]]);
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].doClick();
                }
            }
        });
        buttonPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    menuButton.doClick();
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    button.doClick();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    everythingPanel.requestFocus();
                    button.setBackground(bcgColor[i[0]]);
                    button.setForeground(houseColor[i[0]]);
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(houseColor[i[0]]);
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(bcgColor[i[0]]);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    everythingPanel.requestFocus();
                    button.setBackground(bcgColor[i[0]]);
                    button.setForeground(houseColor[i[0]]);
                    if (buttonGroupIndex[0] == 3)
                        buttonGroupIndex[0] = 0;
                    else
                        buttonGroupIndex[0] = 4;
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setBackground(houseColor[i[0]]);
                    allButtons[buttonGroupIndex[0]][buttonIndex[0]].setForeground(bcgColor[i[0]]);
                }
            }
        });


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
