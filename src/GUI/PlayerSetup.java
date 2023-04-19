package GUI;

import Game.*;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class PlayerSetup extends JFrame {
    private Player player;

    public PlayerSetup() {
        super("Welcome to Hogwarts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700); //750x525

        final String[] bcg_dir = {"img/setupG.jpg", "img/setupR.jpg", "img/setupH.jpg", "img/setupS.jpg", "img/setup.jpg"};
        final int[] i = {4};
        final Color[] houseColor = {new Color(238, 186, 48), new Color(148, 107, 45), new Color(125, 107, 93), new Color(170, 170, 170), Color.BLACK};
        final Color[] bcgColor = {new Color(116, 0, 1), new Color(15, 29, 74), new Color(238, 186, 53), new Color(26, 71, 42), new Color(118,125,154)};

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
        Font sub_title = new Font("Arial", Font.BOLD, 20); // set the font size to 20

        JPanel everythingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, panel.getWidth() + 10, 100 + panel.getHeight()));
        everythingPanel.setOpaque(false);

        everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));

        JPanel spacerPanel1 = new JPanel();
        spacerPanel1.setPreferredSize(new Dimension(0, 27));
        spacerPanel1.setOpaque(false);
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

        JLabel title = new JLabel("Customize your character:");
        title.setFont(new Font("Arial", Font.BOLD, 45));
        title.setForeground(houseColor[i[0]]);
        JPanel titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(0, 85));
        titlePanel.setOpaque(false);
        titlePanel.add(title);
        everythingPanel.add(titlePanel);

        JLabel nameTitle = new JLabel("Enter your name:");
        nameTitle.setFont(sub_title);
        nameTitle.setForeground(houseColor[i[0]]);
        JTextField nameField = new JTextField(20);
        nameField.setPreferredSize(new Dimension(150, 30));
        Font font = new Font("Arial", Font.PLAIN, 16); // set the font size to 20
        Font font1 = new Font("Arial", Font.BOLD, 16); // set the font size to 20
        nameField.setFont(font);
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setOpaque(false);
        textFieldPanel.add(nameTitle);
        textFieldPanel.add(nameField);
        everythingPanel.add(textFieldPanel);

        everythingPanel.add(spacerPanel2);

        JLabel genderTitle = new JLabel("Choose your gender:");
        genderTitle.setFont(sub_title);
        genderTitle.setForeground(houseColor[i[0]]);
        JRadioButton option1 = new JRadioButton("Male");
        option1.setFont(font1);
        option1.setOpaque(false);
        option1.setForeground(houseColor[i[0]]);
        JRadioButton option2 = new JRadioButton("Female");
        option2.setFont(font1);
        option2.setOpaque(false);
        option2.setForeground(houseColor[i[0]]);
        JRadioButton option3 = new JRadioButton("Other");
        option3.setFont(font1);
        option3.setOpaque(false);
        option3.setForeground(houseColor[i[0]]);
        ButtonGroup gender = new ButtonGroup(); // create a ButtonGroup to group the radio buttons
        gender.add(option1);
        gender.add(option2);
        gender.add(option3);

        JPanel genderPanel = new JPanel();
        genderPanel.setOpaque(false);
        genderPanel.setPreferredSize(new Dimension(150, 30));
        genderPanel.add(genderTitle);
        genderPanel.add(option1);
        genderPanel.add(option2);
        genderPanel.add(option3);

        everythingPanel.add(genderPanel);

        everythingPanel.add(spacerPanel3);

        JLabel houseTitle = new JLabel("Pick your house:");
        houseTitle.setFont(sub_title);
        houseTitle.setForeground(houseColor[i[0]]);
        JRadioButton option4 = new JRadioButton("Gryffindor");
        option4.setFont(font1);
        option4.setOpaque(false);
        option4.setForeground(houseColor[i[0]]);

        JRadioButton option5 = new JRadioButton("Ravenclaw");
        option5.setFont(font1);
        option5.setOpaque(false);
        option5.setForeground(houseColor[i[0]]);

        JRadioButton option6 = new JRadioButton("Hufflepuff");
        option6.setFont(font1);
        option6.setOpaque(false);
        option6.setForeground(houseColor[i[0]]);

        JRadioButton option7 = new JRadioButton("Slytherin");
        option7.setFont(font1);
        option7.setOpaque(false);
        option7.setForeground(houseColor[i[0]]);

        ButtonGroup house = new ButtonGroup(); // create a ButtonGroup to group the radio buttons
        house.add(option4);
        house.add(option5);
        house.add(option6);
        house.add(option7);

        JPanel housePanel = new JPanel();
        housePanel.setOpaque(false);
        housePanel.setPreferredSize(new Dimension(150, 30));
        housePanel.add(houseTitle);
        housePanel.add(option4);
        housePanel.add(option5);
        housePanel.add(option6);
        housePanel.add(option7);
        everythingPanel.add(housePanel);

        everythingPanel.add(spacerPanel4);

        JLabel interestTitle = new JLabel("Pick your interests (7):");
        interestTitle.setFont(sub_title);
        interestTitle.setForeground(houseColor[i[0]]);
        JLabel interestTitle2 = new JLabel("");
        interestTitle.setFont(sub_title);
        interestTitle2.setOpaque(false);

        JCheckBox checkbox1 = new JCheckBox("Quidditch");
        JCheckBox checkbox2 = new JCheckBox("Transfiguration");
        JCheckBox checkbox3 = new JCheckBox("Charms");
        JCheckBox checkbox4 = new JCheckBox("Herbology");
        JCheckBox checkbox5 = new JCheckBox("Potions");
        JCheckBox checkbox6 = new JCheckBox("Defense Against the Dark Arts");
        JCheckBox checkbox7 = new JCheckBox("Divination");
        JCheckBox checkbox8 = new JCheckBox("Muggle Studies");
        JCheckBox checkbox9 = new JCheckBox("Care of Magical Creatures");
        JCheckBox checkbox10 = new JCheckBox("History of Magic");
        JCheckBox checkbox11 = new JCheckBox("Ancient Runes");
        JCheckBox checkbox12 = new JCheckBox("Apparition");
        JCheckBox checkbox13 = new JCheckBox("Alchemy");
        JCheckBox checkbox14 = new JCheckBox("Magical Theory");

        JCheckBox[] checkboxes = {checkbox1, checkbox2, checkbox3, checkbox4, checkbox5,
                checkbox6, checkbox7, checkbox8, checkbox9, checkbox10,
                checkbox11, checkbox12, checkbox13, checkbox14};

        // this listener will limit the number of checkboxes that can be selected to 7
        for (JCheckBox checkbox : checkboxes) {
            checkbox.setFont(font1);
            checkbox.setForeground(houseColor[i[0]]);
            checkbox.setOpaque(false);
        }
        JPanel interestPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        interestPanel.setOpaque(false);
        interestPanel.setBorder(BorderFactory.createEmptyBorder(0, 220, 0, 200));
        interestPanel.add(interestTitle);
        interestPanel.add(interestTitle2);
        for (JCheckBox checkbox : checkboxes) {
            interestPanel.add(checkbox);
        }
        everythingPanel.add(interestPanel);

        everythingPanel.add(spacerPanel5);

        JButton button = new JButton("Save");
        button.setPreferredSize(new Dimension(90, 35));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player = new Player();
                player.setName(nameField.getText());
                if (option1.isSelected())
                    player.setGender("male");
                else if (option2.isSelected())
                    player.setGender("female");
                else if (option3.isSelected())
                    player.setGender("other");
                if (option4.isSelected())
                    player.setPreferred_house("Gryffindor");
                else if (option5.isSelected())
                    player.setPreferred_house("Ravenclaw");
                else if (option6.isSelected())
                    player.setPreferred_house("Hufflepuff");
                else if (option7.isSelected())
                    player.setPreferred_house("Slytherin");
                String[] array = new String[7];
                int help = 0;
                for (JCheckBox checkbox : checkboxes) {
                    if (checkbox.isSelected()) {
                        array[help] = checkbox.getText();
                        help++;
                    }
                }
                if (help != 6){
                    String[] temp = new String[help];
                    System.arraycopy(array, 0, temp, 0, help);
                    array = temp;
                }
                player.addInterests(array);
                dispose();
            }
        });

        JButton back = new JButton("Back");
        back.setPreferredSize(new Dimension(90, 35));
        back.setHorizontalAlignment(JButton.CENTER);
        back.setVerticalAlignment(JButton.CENTER);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Thread newGameThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Startup start = new Startup();
                        try {
                            Game game = new Game(start.getLogin(), start.getBool());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                // Start the thread
                newGameThread.start();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(back);
        buttonPanel.add(button);
        everythingPanel.add(buttonPanel, BorderLayout.SOUTH);

        panel.add(everythingPanel, BorderLayout.NORTH);


        option4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    i[0] = 0;
                    title.setForeground(houseColor[i[0]]);
                    nameTitle.setForeground(houseColor[i[0]]);
                    genderTitle.setForeground(houseColor[i[0]]);
                    houseTitle.setForeground(houseColor[i[0]]);
                    interestTitle.setForeground(houseColor[i[0]]);
                    for (JCheckBox checkbox : checkboxes) {
                        checkbox.setForeground(houseColor[i[0]]);
                    }
                    option1.setForeground(houseColor[i[0]]);
                    option2.setForeground(houseColor[i[0]]);
                    option3.setForeground(houseColor[i[0]]);
                    option4.setForeground(houseColor[i[0]]);
                    option5.setForeground(houseColor[i[0]]);
                    option6.setForeground(houseColor[i[0]]);
                    option7.setForeground(houseColor[i[0]]);
                    button.setForeground(bcgColor[i[0]]);
                    button.setBackground(houseColor[i[0]]);
                    back.setForeground(bcgColor[i[0]]);
                    back.setBackground(houseColor[i[0]]);
                    nameField.setForeground(bcgColor[i[0]]);
                    nameField.setBackground(houseColor[i[0]]);
                    repaint();
                }
            }
        });

        option5.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    i[0] = 1;
                    title.setForeground(houseColor[i[0]]);
                    nameTitle.setForeground(houseColor[i[0]]);
                    genderTitle.setForeground(houseColor[i[0]]);
                    houseTitle.setForeground(houseColor[i[0]]);
                    interestTitle.setForeground(houseColor[i[0]]);
                    for (JCheckBox checkbox : checkboxes) {
                        checkbox.setForeground(houseColor[i[0]]);
                    }
                    option1.setForeground(houseColor[i[0]]);
                    option2.setForeground(houseColor[i[0]]);
                    option3.setForeground(houseColor[i[0]]);
                    option4.setForeground(houseColor[i[0]]);
                    option5.setForeground(houseColor[i[0]]);
                    option6.setForeground(houseColor[i[0]]);
                    option7.setForeground(houseColor[i[0]]);
                    button.setForeground(bcgColor[i[0]]);
                    button.setBackground(houseColor[i[0]]);
                    back.setForeground(bcgColor[i[0]]);
                    back.setBackground(houseColor[i[0]]);
                    nameField.setForeground(bcgColor[i[0]]);
                    nameField.setBackground(houseColor[i[0]]);
                    repaint();
                }
            }
        });

        option6.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    i[0] = 2;
                    title.setForeground(houseColor[i[0]]);
                    nameTitle.setForeground(houseColor[i[0]]);
                    genderTitle.setForeground(houseColor[i[0]]);
                    houseTitle.setForeground(houseColor[i[0]]);
                    interestTitle.setForeground(houseColor[i[0]]);
                    for (JCheckBox checkbox : checkboxes) {
                        checkbox.setForeground(houseColor[i[0]]);
                    }
                    option1.setForeground(houseColor[i[0]]);
                    option2.setForeground(houseColor[i[0]]);
                    option3.setForeground(houseColor[i[0]]);
                    option4.setForeground(houseColor[i[0]]);
                    option5.setForeground(houseColor[i[0]]);
                    option6.setForeground(houseColor[i[0]]);
                    option7.setForeground(houseColor[i[0]]);
                    button.setForeground(bcgColor[i[0]]);
                    button.setBackground(houseColor[i[0]]);
                    back.setForeground(bcgColor[i[0]]);
                    back.setBackground(houseColor[i[0]]);
                    nameField.setForeground(bcgColor[i[0]]);
                    nameField.setBackground(houseColor[i[0]]);
                    repaint();
                }
            }
        });

        option7.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    i[0] = 3;
                    title.setForeground(houseColor[i[0]]);
                    nameTitle.setForeground(houseColor[i[0]]);
                    genderTitle.setForeground(houseColor[i[0]]);
                    houseTitle.setForeground(houseColor[i[0]]);
                    interestTitle.setForeground(houseColor[i[0]]);
                    for (JCheckBox checkbox : checkboxes) {
                        checkbox.setForeground(houseColor[i[0]]);
                    }
                    option1.setForeground(houseColor[i[0]]);
                    option2.setForeground(houseColor[i[0]]);
                    option3.setForeground(houseColor[i[0]]);
                    option4.setForeground(houseColor[i[0]]);
                    option5.setForeground(houseColor[i[0]]);
                    option6.setForeground(houseColor[i[0]]);
                    option7.setForeground(houseColor[i[0]]);
                    button.setForeground(bcgColor[i[0]]);
                    button.setBackground(houseColor[i[0]]);
                    back.setForeground(bcgColor[i[0]]);
                    back.setBackground(houseColor[i[0]]);
                    nameField.setForeground(bcgColor[i[0]]);
                    nameField.setBackground(houseColor[i[0]]);
                    repaint();
                }
            }
        });


        JRadioButton[] genderOptions = {option1, option2, option3};
        final int[] genderIndex = {0};
        genderPanel.setFocusable(true);
        JRadioButton[] houseOptions = {option4, option5, option6, option7};
        final int[] houseIndex = {0};
        housePanel.setFocusable(true);
        JCheckBox[] interestOptions = {checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6, checkbox7, checkbox8, checkbox9, checkbox10, checkbox11, checkbox12, checkbox13, checkbox14};
        final int[] interestIndex = {0};
        final int[] max = {0};
        for (JCheckBox checkbox : interestOptions) {
            checkbox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    genderOptions[genderIndex[0]].setOpaque(false);
                    genderOptions[genderIndex[0]].setForeground(houseColor[i[0]]);
                    genderOptions[genderIndex[0]].repaint();
                    houseOptions[houseIndex[0]].setOpaque(false);
                    houseOptions[houseIndex[0]].setForeground(houseColor[i[0]]);
                    houseOptions[houseIndex[0]].repaint();
                    nameField.setFocusable(false);
                    interestOptions[interestIndex[0]].setOpaque(false);
                    interestOptions[interestIndex[0]].setForeground(houseColor[i[0]]);
                    interestOptions[interestIndex[0]].repaint();
                    interestPanel.requestFocus();
                    for (int i = 0; i<13; i++) {
                        if (checkbox == interestOptions[i]) {
                            interestIndex[0] = i;
                            break;
                        }
                    }
                    interestOptions[interestIndex[0]].setOpaque(true);
                    interestOptions[interestIndex[0]].setForeground(bcgColor[i[0]]);
                    interestOptions[interestIndex[0]].setBackground(houseColor[i[0]]);
                    interestOptions[interestIndex[0]].repaint();
                    if (checkbox.isSelected()) {
                        max[0]++;
                        if (max[0] > 7){
                            checkbox.setSelected(false);
                            max[0]--;
                        }
                    } else
                        max[0]--;
                }
            });
        }
        for (JRadioButton btn: houseOptions) {
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    genderOptions[genderIndex[0]].setOpaque(false);
                    genderOptions[genderIndex[0]].setForeground(houseColor[i[0]]);
                    genderOptions[genderIndex[0]].repaint();
                    houseOptions[houseIndex[0]].setOpaque(false);
                    houseOptions[houseIndex[0]].setForeground(houseColor[i[0]]);
                    houseOptions[houseIndex[0]].repaint();
                    nameField.setFocusable(false);
                    interestOptions[interestIndex[0]].setOpaque(false);
                    interestOptions[interestIndex[0]].setForeground(houseColor[i[0]]);
                    interestOptions[interestIndex[0]].repaint();
                    housePanel.requestFocus();
                    for (int i = 0; i<13; i++) {
                        if (btn == houseOptions[i]) {
                            houseIndex[0] = i;
                            break;
                        }
                    }
                    houseOptions[houseIndex[0]].setOpaque(true);
                    houseOptions[houseIndex[0]].setForeground(bcgColor[i[0]]);
                    houseOptions[houseIndex[0]].setBackground(houseColor[i[0]]);
                    houseOptions[houseIndex[0]].repaint();
                }
            });
        }
        for (JRadioButton btn: genderOptions) {
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    genderOptions[genderIndex[0]].setOpaque(false);
                    genderOptions[genderIndex[0]].setForeground(houseColor[i[0]]);
                    genderOptions[genderIndex[0]].repaint();
                    houseOptions[houseIndex[0]].setOpaque(false);
                    houseOptions[houseIndex[0]].setForeground(houseColor[i[0]]);
                    houseOptions[houseIndex[0]].repaint();
                    nameField.setFocusable(false);
                    interestOptions[interestIndex[0]].setOpaque(false);
                    interestOptions[interestIndex[0]].setForeground(houseColor[i[0]]);
                    interestOptions[interestIndex[0]].repaint();
                    genderPanel.requestFocus();
                    for (int i = 0; i<13; i++) {
                        if (btn == genderOptions[i]) {
                            genderIndex[0] = i;
                            break;
                        }
                    }
                    genderOptions[genderIndex[0]].setOpaque(true);
                    genderOptions[genderIndex[0]].setForeground(bcgColor[i[0]]);
                    genderOptions[genderIndex[0]].setBackground(houseColor[i[0]]);
                    genderOptions[genderIndex[0]].repaint();
                }
            });
        }
        interestPanel.setFocusable(true);
        buttonPanel.setFocusable(true);
        nameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                genderOptions[genderIndex[0]].setOpaque(false);
                genderOptions[genderIndex[0]].setForeground(houseColor[i[0]]);
                genderOptions[genderIndex[0]].repaint();
                houseOptions[houseIndex[0]].setOpaque(false);
                houseOptions[houseIndex[0]].setForeground(houseColor[i[0]]);
                houseOptions[houseIndex[0]].repaint();
                interestOptions[interestIndex[0]].setOpaque(false);
                interestOptions[interestIndex[0]].setForeground(houseColor[i[0]]);
                interestOptions[interestIndex[0]].repaint();
                nameField.setFocusable(true);
                nameField.requestFocus();
            }
        });
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    nameField.setFocusable(false);
                    genderPanel.requestFocus();
                    genderOptions[genderIndex[0]].setOpaque(true);
                    genderOptions[genderIndex[0]].setBackground(houseColor[i[0]]);
                    genderOptions[genderIndex[0]].setForeground(bcgColor[i[0]]);
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    nameField.setFocusable(false);
                    buttonPanel.requestFocus();
                    back.setBorder(BorderFactory.createLineBorder(bcgColor[i[0]], 4));
                    back.setSelected(true);
                }
            }
        });
        genderPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    genderOptions[genderIndex[0]].setSelected(true);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    genderIndex[0] = (genderIndex[0] + 1) % genderOptions.length;
                    genderOptions[genderIndex[0]].setOpaque(true);
                    genderOptions[genderIndex[0]].setBackground(houseColor[i[0]]);
                    genderOptions[genderIndex[0]].setForeground(bcgColor[i[0]]);
                    genderOptions[genderIndex[0]].repaint();
                    if (genderIndex[0] == 0) {
                        genderOptions[genderOptions.length - 1].setOpaque(false);
                        genderOptions[genderOptions.length - 1].setForeground(houseColor[i[0]]);
                        genderOptions[genderOptions.length - 1].repaint();
                    }
                    else{
                        genderOptions[genderIndex[0] - 1].setOpaque(false);
                        genderOptions[genderIndex[0] - 1].setForeground(houseColor[i[0]]);
                        genderOptions[genderIndex[0] - 1].repaint();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    genderIndex[0] = (genderIndex[0] - 1 + genderOptions.length) % genderOptions.length;
                    genderOptions[genderIndex[0]].setOpaque(true);
                    genderOptions[genderIndex[0]].setBackground(houseColor[i[0]]);
                    genderOptions[genderIndex[0]].setForeground(bcgColor[i[0]]);
                    genderOptions[genderIndex[0]].repaint();
                    genderOptions[(genderIndex[0] + 1) % genderOptions.length].setOpaque(false);
                    genderOptions[(genderIndex[0] + 1) % genderOptions.length].setForeground(houseColor[i[0]]);
                    genderOptions[(genderIndex[0] + 1) % genderOptions.length].repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    for (JRadioButton but : genderOptions) {
                        but.setOpaque(false);
                        but.setForeground(houseColor[i[0]]);
                        but.repaint();
                    }
                    nameField.setFocusable(true);
                    nameField.requestFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    for (JRadioButton but : genderOptions) {
                        but.setOpaque(false);
                        but.setForeground(houseColor[i[0]]);
                        but.repaint();
                    }
                    housePanel.requestFocus();
                    houseOptions[houseIndex[0]].setOpaque(true);
                    houseOptions[houseIndex[0]].setBackground(houseColor[i[0]]);
                    houseOptions[houseIndex[0]].setForeground(bcgColor[i[0]]);
                }
            }
        });

        housePanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    houseOptions[houseIndex[0]].setSelected(true);
                    houseOptions[houseIndex[0]].setBackground(houseColor[i[0]]);
                    houseOptions[houseIndex[0]].setForeground(bcgColor[i[0]]);
                    houseOptions[houseIndex[0]].repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    houseIndex[0] = (houseIndex[0] + 1) % houseOptions.length;
                    houseOptions[houseIndex[0]].setOpaque(true);
                    houseOptions[houseIndex[0]].setBackground(houseColor[i[0]]);
                    houseOptions[houseIndex[0]].setForeground(bcgColor[i[0]]);
                    houseOptions[houseIndex[0]].repaint();
                    if (houseIndex[0] == 0) {
                        houseOptions[houseOptions.length - 1].setOpaque(false);
                        houseOptions[houseOptions.length - 1].setForeground(houseColor[i[0]]);
                        houseOptions[houseOptions.length - 1].repaint();
                    }
                    else{
                        houseOptions[houseIndex[0] - 1].setOpaque(false);
                        houseOptions[houseIndex[0] - 1].setForeground(houseColor[i[0]]);
                        houseOptions[houseIndex[0] - 1].repaint();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    houseIndex[0] = (houseIndex[0] - 1 + houseOptions.length) % houseOptions.length;
                    houseOptions[houseIndex[0]].setOpaque(true);
                    houseOptions[houseIndex[0]].setBackground(houseColor[i[0]]);
                    houseOptions[houseIndex[0]].setForeground(bcgColor[i[0]]);
                    houseOptions[houseIndex[0]].repaint();
                    houseOptions[(houseIndex[0] + 1) % houseOptions.length].setOpaque(false);
                    houseOptions[(houseIndex[0] + 1) % houseOptions.length].setForeground(houseColor[i[0]]);
                    houseOptions[(houseIndex[0] + 1) % houseOptions.length].repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    for (JRadioButton but : houseOptions) {
                        but.setOpaque(false);
                        but.setForeground(houseColor[i[0]]);
                        but.repaint();
                    }
                    genderPanel.requestFocus();
                    genderOptions[genderIndex[0]].setOpaque(true);
                    genderOptions[genderIndex[0]].setBackground(houseColor[i[0]]);
                    genderOptions[genderIndex[0]].setForeground(bcgColor[i[0]]);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    for (JRadioButton but : houseOptions) {
                        but.setOpaque(false);
                        but.setForeground(houseColor[i[0]]);
                        but.repaint();
                    }
                    if (interestIndex[0] % 2 == 0) {
                        interestIndex[0] = 0;
                    } else {
                        interestIndex[0] = 1;
                    }
                    interestPanel.requestFocus();
                    interestOptions[interestIndex[0]].setOpaque(true);
                    interestOptions[interestIndex[0]].setBackground(houseColor[i[0]]);
                    interestOptions[interestIndex[0]].setForeground(bcgColor[i[0]]);
                }
            }
        });

        interestPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (interestOptions[interestIndex[0]].isSelected()) {
                        interestOptions[interestIndex[0]].setSelected(false);
                        max[0]--;
                    }
                    else {
                        interestOptions[interestIndex[0]].setSelected(true);
                        max[0]++;
                        if (max[0] > 7) {
                            interestOptions[interestIndex[0]].setSelected(false);
                            max[0]--;
                        }
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                    if (interestIndex[0] % 2 == 0) {
                        interestIndex[0] = (interestIndex[0] + 1) % interestOptions.length;
                        interestOptions[interestIndex[0]].setOpaque(true);
                        interestOptions[interestIndex[0]].setBackground(houseColor[i[0]]);
                        interestOptions[interestIndex[0]].setForeground(bcgColor[i[0]]);
                        interestOptions[interestIndex[0]].repaint();
                        interestOptions[(interestIndex[0] - 1) % interestOptions.length].setOpaque(false);
                        interestOptions[(interestIndex[0] - 1) % interestOptions.length].setForeground(houseColor[i[0]]);
                        interestOptions[(interestIndex[0] - 1) % interestOptions.length].repaint();
                    } else {
                        interestIndex[0] = (interestIndex[0] - 1 + interestOptions.length) % interestOptions.length;
                        interestOptions[interestIndex[0]].setOpaque(true);
                        interestOptions[interestIndex[0]].setBackground(houseColor[i[0]]);
                        interestOptions[interestIndex[0]].setForeground(bcgColor[i[0]]);
                        interestOptions[interestIndex[0]].repaint();
                        interestOptions[(interestIndex[0] + 1) % interestOptions.length].setOpaque(false);
                        interestOptions[(interestIndex[0] + 1) % interestOptions.length].setForeground(houseColor[i[0]]);
                        interestOptions[(interestIndex[0] + 1) % interestOptions.length].repaint();
                    }
                if (e.getKeyCode() == KeyEvent.VK_LEFT)
                    if (interestIndex[0] % 2 != 0) {
                        interestIndex[0] = (interestIndex[0] - 1 + interestOptions.length) % interestOptions.length;
                        interestOptions[interestIndex[0]].setOpaque(true);
                        interestOptions[interestIndex[0]].setBackground(houseColor[i[0]]);
                        interestOptions[interestIndex[0]].setForeground(bcgColor[i[0]]);
                        interestOptions[interestIndex[0]].repaint();
                        interestOptions[(interestIndex[0] + 1) % interestOptions.length].setOpaque(false);
                        interestOptions[(interestIndex[0] + 1) % interestOptions.length].setForeground(houseColor[i[0]]);
                        interestOptions[(interestIndex[0] + 1) % interestOptions.length].repaint();
                    } else {
                        interestIndex[0] = (interestIndex[0] + 1) % interestOptions.length;
                        interestOptions[interestIndex[0]].setOpaque(true);
                        interestOptions[interestIndex[0]].setBackground(houseColor[i[0]]);
                        interestOptions[interestIndex[0]].setForeground(bcgColor[i[0]]);
                        interestOptions[interestIndex[0]].repaint();
                        interestOptions[(interestIndex[0] - 1) % interestOptions.length].setOpaque(false);
                        interestOptions[(interestIndex[0] - 1) % interestOptions.length].setForeground(houseColor[i[0]]);
                        interestOptions[(interestIndex[0] - 1) % interestOptions.length].repaint();
                    }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (interestIndex[0] == 13) {
                        interestOptions[interestIndex[0]].setOpaque(false);
                        interestOptions[interestIndex[0]].setForeground(houseColor[i[0]]);
                        interestOptions[interestIndex[0]].repaint();
                        button.setBorder(BorderFactory.createLineBorder(bcgColor[i[0]], 4));
                        button.setSelected(true);
                        buttonPanel.requestFocus();
                    } else if (interestIndex[0] == 12) {
                        interestOptions[interestIndex[0]].setOpaque(false);
                        interestOptions[interestIndex[0]].setForeground(houseColor[i[0]]);
                        interestOptions[interestIndex[0]].repaint();
                        back.setBorder(BorderFactory.createLineBorder(bcgColor[i[0]], 4));
                        back.setSelected(true);
                        buttonPanel.requestFocus();
                    } else {
                        interestIndex[0] = (interestIndex[0] + 2);
                        interestOptions[interestIndex[0]].setOpaque(true);
                        interestOptions[interestIndex[0]].setBackground(houseColor[i[0]]);
                        interestOptions[interestIndex[0]].setForeground(bcgColor[i[0]]);
                        interestOptions[interestIndex[0]].repaint();
                        interestOptions[(interestIndex[0] - 2) % interestOptions.length].setOpaque(false);
                        interestOptions[(interestIndex[0] - 2) % interestOptions.length].setForeground(houseColor[i[0]]);
                        interestOptions[(interestIndex[0] - 2) % interestOptions.length].repaint();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (interestIndex[0] == 0 || interestIndex[0] == 1) {
                        interestOptions[interestIndex[0]].setOpaque(false);
                        interestOptions[interestIndex[0]].setForeground(houseColor[i[0]]);
                        interestOptions[interestIndex[0]].repaint();
                        houseOptions[houseIndex[0]].setOpaque(true);
                        houseOptions[houseIndex[0]].setBackground(houseColor[i[0]]);
                        houseOptions[houseIndex[0]].setForeground(bcgColor[i[0]]);
                        houseOptions[houseIndex[0]].repaint();
                        housePanel.requestFocus();
                    } else {
                        interestIndex[0] = (interestIndex[0] - 2);
                        interestOptions[interestIndex[0]].setOpaque(true);
                        interestOptions[interestIndex[0]].setBackground(houseColor[i[0]]);
                        interestOptions[interestIndex[0]].setForeground(bcgColor[i[0]]);
                        interestOptions[interestIndex[0]].repaint();
                        interestOptions[interestIndex[0] + 2].setOpaque(false);
                        interestOptions[interestIndex[0] + 2].setForeground(houseColor[i[0]]);
                        interestOptions[interestIndex[0] + 2].repaint();
                    }
                }
            }
        });

        buttonPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (button.isSelected()) {
                        button.doClick();
                    } else if (back.isSelected()) {
                        back.doClick();
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    button.setBorder(BorderFactory.createLineBorder(bcgColor[i[0]], 0));
                    back.setBorder(BorderFactory.createLineBorder(bcgColor[i[0]], 0));
                    if (button.isSelected())
                        interestIndex[0] = 13;

                    else
                        interestIndex[0] = 12;
                    interestPanel.requestFocus();
                    interestOptions[interestIndex[0]].setOpaque(true);
                    interestOptions[interestIndex[0]].setBackground(houseColor[i[0]]);
                    interestOptions[interestIndex[0]].setForeground(bcgColor[i[0]]);
                    interestOptions[interestIndex[0]].repaint();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    button.setBorder(BorderFactory.createLineBorder(bcgColor[i[0]], 0));
                    back.setBorder(BorderFactory.createLineBorder(bcgColor[i[0]], 0));
                    nameField.setFocusable(true);
                    nameField.requestFocus();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    button.setSelected(true);
                    button.setBorder(BorderFactory.createLineBorder(bcgColor[i[0]], 4));
                    back.setSelected(false);
                    back.setBorder(BorderFactory.createLineBorder(bcgColor[i[0]], 0));
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    button.setSelected(false);
                    button.setBorder(BorderFactory.createLineBorder(bcgColor[i[0]], 0));
                    back.setSelected(true);
                    back.setBorder(BorderFactory.createLineBorder(bcgColor[i[0]], 4));
                }
            }
        });






        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    public Player getPlayer() {
        new Waiter().wait(() -> player);
        return player;
    }
}