package GUI;

import Game.*;
import Stories.*;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;

public class CreatePlan extends JFrame {

    private Player player;
    private Plan plan;
    private Boolean changed;
    public CreatePlan(Player player) {
        super("Let's create a plan for your trip around Hogwarts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700); //750x525

        this.player = player;

        final String[] bcg_dir = {"img/setupG.jpg", "img/setupR.jpg", "img/setupH.jpg", "img/setupS.jpg", "img/setup.jpg"};
        final int[][] i = {{4}};
        final Color[] houseColor = {new Color(238, 186, 48), new Color(148, 107, 45), new Color(125, 107, 93), new Color(170, 170, 170), Color.BLACK};
        final Color[] bcgColor = {new Color(116, 0, 1), new Color(15, 29, 74), new Color(238, 186, 53), new Color(26, 71, 42), Color.BLACK};

        switch (player.getHouse()) {
            case "Gryffindor" -> i[0][0] = 0;
            case "Ravenclaw" -> i[0][0] = 1;
            case "Hufflepuff" -> i[0][0] = 2;
            case "Slytherin" -> i[0][0] = 3;
            default -> i[0][0] = 4;
        }

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon image = new ImageIcon(bcg_dir[i[0][0]]);
                Image img = image.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
            }
        };

        panel.setLayout(new BorderLayout());
        Font sub_title = new Font("Arial", Font.BOLD, 20);

        JPanel everythingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, panel.getWidth() + 10, 100 + panel.getHeight()));
        everythingPanel.setOpaque(false);

        everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));

        JPanel spacerPanel1 = new JPanel();
        spacerPanel1.setPreferredSize(new Dimension(0, 27));
        spacerPanel1.setOpaque(false);
        everythingPanel.add(spacerPanel1);

        JPanel spacerPanel5 = new JPanel();
        spacerPanel5.setPreferredSize(new Dimension(0, 17));
        spacerPanel5.setOpaque(false);

        JLabel title = new JLabel("Customize your plan:");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(houseColor[i[0][0]]);
        JPanel titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(0, 60));
        titlePanel.setOpaque(false);
        titlePanel.add(title);
        everythingPanel.add(titlePanel);

        Font font1 = new Font("Arial", Font.BOLD, 15);



        JLabel interestTitle = new JLabel("Pick your interest:");
        interestTitle.setFont(sub_title);
        interestTitle.setForeground(houseColor[i[0][0]]);

        String[] allInterests = {"Quidditch", "Transfiguration", "Charms", "Herbology", "Potions", "Defense Against the Dark Arts", "Divination", "Muggle Studies", "Care of Magical Creatures", "History of Magic", "Ancient Runes", "Apparition", "Alchemy", "Magical Theory"};
        String[] miniGames = {"Quidditch stadium - Rolanda Hooch","Transfiguration Classroom - Minerva McGonagall","Charms Classroom - Filius Flitwick","Hogwarts' Greenhouses - Pomona Sprout","Potions Classroom - Severus Snape","The Dark Forest - Remus Lupin","The Divination Classroom - Sybill Trelawney","Muggle Storage - Alecto Carrow","The Magical Creatures Forest - Rubeus Hagrid","The History Classroom - Cuthbert Binns", "Archaic Library - Bathsheda Babbling", "The Ghostly Hallways - Nearly Headless Nick", "The Alchemy Classroom - Albus Dumbledore", "The Library - Eleazar Fig"};
        String[] playersInterests = player.getInterests();


        JLabel combo1 = new JLabel("First stop:");
        combo1.setFont(font1);
        combo1.setForeground(houseColor[i[0][0]]);
        JLabel combo2 = new JLabel("Second stop:");
        combo2.setFont(font1);
        combo2.setForeground(houseColor[i[0][0]]);
        JLabel combo3 = new JLabel("Third stop:");
        combo3.setFont(font1);
        combo3.setForeground(houseColor[i[0][0]]);
        JLabel combo4 = new JLabel("Fourth stop:");
        combo4.setFont(font1);
        combo4.setForeground(houseColor[i[0][0]]);
        JLabel combo5 = new JLabel("Fifth stop:");
        combo5.setFont(font1);
        combo5.setForeground(houseColor[i[0][0]]);
        JLabel combo6 = new JLabel("Sixth stop:");
        combo6.setFont(font1);
        combo6.setForeground(houseColor[i[0][0]]);
        JLabel combo7 = new JLabel("Seventh stop:");
        combo7.setFont(font1);
        combo7.setForeground(houseColor[i[0][0]]);
        JComboBox<String> combobox1 = new JComboBox<>(miniGames);
        JComboBox<String> combobox2 = new JComboBox<>(miniGames);
        JComboBox<String> combobox3 = new JComboBox<>(miniGames);
        JComboBox<String> combobox4 = new JComboBox<>(miniGames);
        JComboBox<String> combobox5 = new JComboBox<>(miniGames);
        JComboBox<String> combobox6 = new JComboBox<>(miniGames);
        JComboBox<String> combobox7 = new JComboBox<>(miniGames);

        String[] array = player.changePlan().getPlanArray();

        try {
            if(array != null) {
                combobox1.setSelectedIndex(Arrays.asList(miniGames).indexOf(array[0]));
            }
            else
                combobox1.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[0]));
        } catch (IndexOutOfBoundsException e){
            combobox1.setSelectedIndex(0);
        }
        try {
            if(array != null) {
                combobox2.setSelectedIndex(Arrays.asList(miniGames).indexOf(player.changePlan().getPlanArray()[1]));
            }
            else
                combobox2.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[1]));
        } catch (IndexOutOfBoundsException e){
            combobox2.setSelectedIndex(0);
        }
        try {
            if(array != null) {
                combobox3.setSelectedIndex(Arrays.asList(miniGames).indexOf(player.changePlan().getPlanArray()[2]));
            }
            else
                combobox3.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[2]));
        } catch (IndexOutOfBoundsException e){
            combobox3.setSelectedIndex(0);
        }
        try {
            if(array != null) {
                combobox4.setSelectedIndex(Arrays.asList(miniGames).indexOf(player.changePlan().getPlanArray()[3]));
            }
            else
                combobox4.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[3]));
        } catch (IndexOutOfBoundsException e){
            combobox4.setSelectedIndex(0);
        }
        try {
            if(array != null) {
                combobox5.setSelectedIndex(Arrays.asList(miniGames).indexOf(player.changePlan().getPlanArray()[4]));
            }
            else
                combobox5.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[4]));
        } catch (IndexOutOfBoundsException e){
            combobox5.setSelectedIndex(0);
        }
        try {
            if(array != null) {
                combobox6.setSelectedIndex(Arrays.asList(miniGames).indexOf(player.changePlan().getPlanArray()[5]));
            }
            else
                combobox6.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[5]));
        } catch (IndexOutOfBoundsException e){
            combobox6.setSelectedIndex(0);
        }
        try {
            if(array != null) {
                combobox7.setSelectedIndex(Arrays.asList(miniGames).indexOf(player.changePlan().getPlanArray()[6]));
            }
            else
                combobox7.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[6]));
        } catch (IndexOutOfBoundsException e){
            combobox7.setSelectedIndex(0);
        }


        JLabel[] comboLabels = {combo1, combo2, combo3, combo4, combo5,
                combo6, combo7};
        JComboBox[] comboboxes = {combobox1, combobox2, combobox3, combobox4, combobox5,
                combobox6, combobox7};

        for (JComboBox combobox : comboboxes) {
            combobox.setFont(font1);
            combobox.setForeground(bcgColor[i[0][0]]);
            combobox.setBackground(houseColor[i[0][0]]);
            combobox.setOpaque(false);
        }

        JPanel interestPanel = new JPanel(new GridLayout(0, 1, 15, 1));
        interestPanel.setOpaque(false);
        interestPanel.setBorder(BorderFactory.createEmptyBorder(0, 210, 0, 210));

        for (int g = 0; g < 7;g++){
            interestPanel.add(comboLabels[g]);
            interestPanel.add(comboboxes[g]);
        }

        everythingPanel.add(interestPanel);

        everythingPanel.add(spacerPanel5);

        JButton button = new JButton("Start Game");
        button.setPreferredSize(new Dimension(110, 40));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.setForeground(bcgColor[i[0][0]]);
        button.setBackground(houseColor[i[0][0]]);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plan = player.changePlan();
                int currentMinigame = plan.getCurrent();
                int i = 0;
                Story[] array = new Story[7];
                String[] array2 = new String[7];
                for (JComboBox combobox : comboboxes){
                    int index = combobox.getSelectedIndex();
                    if (index == 0) {
                        array[i] = new Quidditch();
                        array2[i] = miniGames[0];
                    } else if (index == 1) {
                        array[i] = new Transfiguration();
                        array2[i] = miniGames[1];
                    } else if (index == 2) {
                        array[i] = new Charms();
                        array2[i] = miniGames[2];
                    } else if (index == 3) {
                        array[i] = new Herbology();
                        array2[i] = miniGames[3];
                    } else if (index == 4) {
                        array[i] = new Potions();
                        array2[i] = miniGames[4];
                    } else if (index == 5) {
                        array[i] = new DefenseAgainstTheDarkArts();
                        array2[i] = miniGames[5];
                    } else if (index == 6) {
                        array[i] = new Divination();
                        array2[i] = miniGames[6];
                    } else if (index == 7) {
                        array[i] = new MuggleStudies();
                        array2[i] = miniGames[7];
                    } else if (index == 8) {
                        array[i] = new Creatures();
                        array2[i] = miniGames[8];
                    } else if (index == 9) {
                        array[i] = new History();
                        array2[i] = miniGames[9];
                    } else if (index == 10) {
                        array[i] = new Runes();
                        array2[i] = miniGames[10];
                    } else if (index == 11) {
                        array[i] = new Apparition();
                        array2[i] = miniGames[11];
                    } else if (index == 12) {
                        array[i] = new Alchemy();
                        array2[i] = miniGames[12];
                    } else if (index == 13) {
                        array[i] = new MagicalTheory();
                        array2[i] = miniGames[13];
                    }
                    i++;
                }
                plan.createPlan(array, array2);
                plan.setCurrent(currentMinigame);
                player.changePlan(plan);
                changed = true;
                dispose();
            }
        });

        JButton back = new JButton("Back");
        back.setPreferredSize(new Dimension(110, 40));
        back.setHorizontalAlignment(JButton.CENTER);
        back.setVerticalAlignment(JButton.CENTER);
        back.setForeground(bcgColor[i[0][0]]);
        back.setBackground(houseColor[i[0][0]]);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Thread changePlayerThreat = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Game game = new Game(player.getLogin(), true);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                // Start the thread
                changePlayerThreat.start();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(back);
        buttonPanel.add(button);
        everythingPanel.add(buttonPanel, BorderLayout.SOUTH);

        buttonPanel.setFocusable(true);
        interestPanel.setFocusable(true);
        interestPanel.requestFocus();
        combobox1.setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 3));
        final int[] comboboxIndex = {0};
        for (JComboBox combobox : comboboxes){
           combobox.addPopupMenuListener(new PopupMenuListener() {
                @Override
                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                    comboboxes[comboboxIndex[0]].setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 0));
                    button.setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 0));
                    for (int j = 0; j < 7 ; j++) {
                        if (combobox == comboboxes[j]) {
                            comboboxIndex[0] = j;
                            combobox.setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 3));
                            break;
                        }
                    }
                }

                @Override
                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                    interestPanel.requestFocus();
                }

                @Override
                public void popupMenuCanceled(PopupMenuEvent e) {
                }
            });
            combobox.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        comboboxes[comboboxIndex[0]].hidePopup();
                        interestPanel.requestFocus();
                    }
                }
            });
        }

        interestPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    comboboxes[comboboxIndex[0]].showPopup();
                    comboboxes[comboboxIndex[0]].requestFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    comboboxes[comboboxIndex[0]].setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 0));
                    comboboxIndex[0]++;
                    if (comboboxIndex[0] == comboboxes.length) {
                        comboboxIndex[0]--;
                        button.setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 4));
                        button.setSelected(true);
                        buttonPanel.requestFocus();
                    } else
                        comboboxes[comboboxIndex[0]].setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 3));
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    comboboxes[comboboxIndex[0]].setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 0));
                    comboboxIndex[0]--;
                    if (comboboxIndex[0] == -1) {
                        comboboxIndex[0]++;
                        button.setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 4));
                        button.setSelected(true);
                        buttonPanel.requestFocus();
                    } else
                        comboboxes[comboboxIndex[0]].setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 3));
                }
            }
        });

        buttonPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (button.isSelected())
                        button.doClick();
                    else
                        back.doClick();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    comboboxIndex[0] = 0;
                    button.setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 0));
                    back.setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 0));
                    comboboxes[comboboxIndex[0]].setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 3));
                    interestPanel.requestFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    comboboxIndex[0] = comboboxes.length - 1;
                    button.setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 0));
                    back.setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 0));
                    comboboxes[comboboxIndex[0]].setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 3));
                    interestPanel.requestFocus();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    button.setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 4));
                    button.setSelected(true);
                    back.setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 0));
                    back.setSelected(false);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    button.setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 0));
                    button.setSelected(false);
                    back.setBorder(BorderFactory.createLineBorder(bcgColor[i[0][0]], 4));
                    back.setSelected(true);
                }
            }
        });


        panel.add(everythingPanel, BorderLayout.NORTH);


        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    public Player getPlayer(){
        new Waiter().wait(() -> player);
        return player;
    }

    public Boolean ifChanged(){
        new Waiter().wait(() -> changed);
        changed = null;
        return true;
    }
}