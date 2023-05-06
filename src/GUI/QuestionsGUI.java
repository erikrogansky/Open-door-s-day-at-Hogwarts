package GUI;

import Game.Player;
import Game.Waiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

public class QuestionsGUI extends JFrame{
    private Player player;
    private Boolean done;
    private String[] myAnswers = new String[8];
    public QuestionsGUI(Player player, String[] myQuestions, String[][] myOptions) {
        super("Quiz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(1000, 700);

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

        JLabel title = new JLabel("Question time!");
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

        for (int j = 0; j < myQuestions.length; j++) {
            JLabel question = new JLabel(myQuestions[j]);
            question.setFont(new Font("Arial", Font.PLAIN, 17));
            question.setHorizontalAlignment(JLabel.CENTER);
            question.setOpaque(true);
            question.setBackground(bcgColor[i[0]]);
            question.setForeground(houseColor[i[0]]);
            if (j < 4)
                questionsPanel1.add(question);
            else
                questionsPanel2.add(question);

            List<String> opt = Arrays.asList(myOptions[j]);
            Collections.shuffle(opt);
            opt.toArray(myOptions[j]);

            JPanel answersPanel = new JPanel(new GridLayout(1, 3, 10, 10));
            answersPanel.setOpaque(false);
            answersPanel.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 1));
            ButtonGroup group = new ButtonGroup();
            JRadioButton answer = new JRadioButton(myOptions[j][0]);
            answer.setActionCommand(myOptions[j][0]);
            answer.setFont(new Font("Arial", Font.PLAIN, 17));
            answer.setHorizontalAlignment(JLabel.CENTER);
            answer.setOpaque(true);
            answer.setBackground(bcgColor[i[0]]);
            answer.setForeground(houseColor[i[0]]);
            group.add(answer);
            answersPanel.add(answer);
            answer = new JRadioButton(myOptions[j][1]);
            answer.setActionCommand(myOptions[j][1]);
            answer.setFont(new Font("Arial", Font.PLAIN, 17));
            answer.setHorizontalAlignment(JLabel.CENTER);
            answer.setOpaque(true);
            answer.setBackground(bcgColor[i[0]]);
            answer.setForeground(houseColor[i[0]]);
            group.add(answer);
            answersPanel.add(answer);
            answer = new JRadioButton(myOptions[j][2]);
            answer.setActionCommand(myOptions[j][2]);
            answer.setFont(new Font("Arial", Font.PLAIN, 17));
            answer.setHorizontalAlignment(JLabel.CENTER);
            answer.setOpaque(true);
            answer.setBackground(bcgColor[i[0]]);
            answer.setForeground(houseColor[i[0]]);
            group.add(answer);
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
                for (int j = 0; j < myQuestions.length; j++) {
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
