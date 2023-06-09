package GUIPackage;

import GamePackage.*;
import StoriesPackage.*;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * In this class where a GUI is created where the user can create a plan for their trip around Hogwarts.
 */
public class CreatePlan extends JFrame {
    /**
     * A variable to store the player
     */
    private Player player;
    /**
     * A variable to store the plan
     */
    private Plan plan;
    /**
     * A variable to store the Boolean to check if some changes were made
     */
    private Boolean changed;

    /**
     * This constructor actually creates the GUI with the JComboBoxes for the player to choose the plan.
     * After submitting, 2 arrays are created. One is filled with String names of the stories, and the other is filled with the
     * actual created {@link Story} objects. The player can use a keyboard or a mouse to work with this GUI.
     * @param player the player
     */
    public CreatePlan(Player player) {
        super("Let's create a plan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700); //750x525

        this.player = player;

        final int[][] i = {{4}};
        final String[] bcg_dir = {"img/setupG.jpg", "img/setupR.jpg", "img/setupH.jpg", "img/setupS.jpg", "img/setup.jpg"};
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

        JPanel everythingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, panel.getWidth() + 10, 100 + panel.getHeight()));
        everythingPanel.setOpaque(false);

        everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));

        JPanel spacerPanel1 = new JPanel();
        spacerPanel1.setPreferredSize(new Dimension(0, 27));
        spacerPanel1.setOpaque(false);
        everythingPanel.add(spacerPanel1);

        JPanel spacerPanel2 = new JPanel();
        spacerPanel2.setPreferredSize(new Dimension(0, 17));
        spacerPanel2.setOpaque(false);

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
        interestTitle.setFont(new Font("Arial", Font.BOLD, 20));
        interestTitle.setForeground(houseColor[i[0][0]]);

        String[] allInterests = {"Quidditch", "Transfiguration", "Charms", "Herbology", "Potions", "Defense Against the Dark Arts", "Divination", "Muggle Studies", "Care of Magical Creatures", "History of Magic", "Ancient Runes", "Apparition", "Alchemy", "Magical Theory"};
        String[] stories = {"Quidditch stadium - Rolanda Hooch","Transfiguration Classroom - Minerva McGonagall","Charms Classroom - Filius Flitwick","Hogwarts' Greenhouses - Pomona Sprout","Potions Classroom - Severus Snape","The Dark Forest - Remus Lupin","The Divination Classroom - Sybill Trelawney","Muggle Storage - Alecto Carrow","The Magical Creatures Forest - Rubeus Hagrid","The History Classroom - Cuthbert Binns", "Archaic Library - Bathsheda Babbling", "The Ghostly Hallways - Nearly Headless Nick", "The Alchemy Classroom - Albus Dumbledore", "The Library - Eleazar Fig"};
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
        JComboBox<String> combobox1 = new JComboBox<>(stories);
        JComboBox<String> combobox2 = new JComboBox<>(stories);
        JComboBox<String> combobox3 = new JComboBox<>(stories);
        JComboBox<String> combobox4 = new JComboBox<>(stories);
        JComboBox<String> combobox5 = new JComboBox<>(stories);
        JComboBox<String> combobox6 = new JComboBox<>(stories);
        JComboBox<String> combobox7 = new JComboBox<>(stories);

        String[] array = player.changePlan().getPlanArray();

        try {
            if(array != null) {
                combobox1.setSelectedIndex(Arrays.asList(stories).indexOf(array[0]));
            }
            else
                combobox1.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[0]));
        } catch (IndexOutOfBoundsException e){
            combobox1.setSelectedIndex(0);
        }
        try {
            if(array != null) {
                combobox2.setSelectedIndex(Arrays.asList(stories).indexOf(player.changePlan().getPlanArray()[1]));
            }
            else
                combobox2.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[1]));
        } catch (IndexOutOfBoundsException e){
            combobox2.setSelectedIndex(1);
        }
        try {
            if(array != null) {
                combobox3.setSelectedIndex(Arrays.asList(stories).indexOf(player.changePlan().getPlanArray()[2]));
            }
            else
                combobox3.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[2]));
        } catch (IndexOutOfBoundsException e){
            combobox3.setSelectedIndex(2);
        }
        try {
            if(array != null) {
                combobox4.setSelectedIndex(Arrays.asList(stories).indexOf(player.changePlan().getPlanArray()[3]));
            }
            else
                combobox4.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[3]));
        } catch (IndexOutOfBoundsException e){
            combobox4.setSelectedIndex(3);
        }
        try {
            if(array != null) {
                combobox5.setSelectedIndex(Arrays.asList(stories).indexOf(player.changePlan().getPlanArray()[4]));
            }
            else
                combobox5.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[4]));
        } catch (IndexOutOfBoundsException e){
            combobox5.setSelectedIndex(4);
        }
        try {
            if(array != null) {
                combobox6.setSelectedIndex(Arrays.asList(stories).indexOf(player.changePlan().getPlanArray()[5]));
            }
            else
                combobox6.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[5]));
        } catch (IndexOutOfBoundsException e){
            combobox6.setSelectedIndex(5);
        }
        try {
            if(array != null) {
                combobox7.setSelectedIndex(Arrays.asList(stories).indexOf(player.changePlan().getPlanArray()[6]));
            }
            else
                combobox7.setSelectedIndex(Arrays.asList(allInterests).indexOf(playersInterests[6]));
        } catch (IndexOutOfBoundsException e){
            combobox7.setSelectedIndex(6);
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

        everythingPanel.add(spacerPanel2);

        JButton button = new JButton("Start Game");
        button.setPreferredSize(new Dimension(110, 40));
        button.setHorizontalAlignment(JButton.CENTER);
        button.setVerticalAlignment(JButton.CENTER);
        button.setForeground(bcgColor[i[0][0]]);
        button.setBackground(houseColor[i[0][0]]);
        button.addActionListener(e -> {
            plan = player.changePlan();
            int currentMinigame = plan.getCurrent();
            int i1 = 0;
            int[] indexArray = new int[]{-1, -1, -1, -1, -1, -1, -1};
            Story[] array1 = new Story[7];
            String[] array2 = new String[7];
            for (JComboBox combobox : comboboxes){
                int index = combobox.getSelectedIndex();
                for (int number : indexArray) {
                    if (number == index) {
                        indexArray[i1] = -1;
                        JOptionPane.showMessageDialog(null, "An option was selected more than once!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                indexArray[i1] = index;
                if (index == 0) {
                    array1[i1] = new Quidditch();
                    array2[i1] = stories[0];
                } else if (index == 1) {
                    array1[i1] = new Transfiguration();
                    array2[i1] = stories[1];
                } else if (index == 2) {
                    array1[i1] = new Charms();
                    array2[i1] = stories[2];
                } else if (index == 3) {
                    array1[i1] = new Herbology();
                    array2[i1] = stories[3];
                } else if (index == 4) {
                    array1[i1] = new Potions();
                    array2[i1] = stories[4];
                } else if (index == 5) {
                    array1[i1] = new Defense();
                    array2[i1] = stories[5];
                } else if (index == 6) {
                    array1[i1] = new Divination();
                    array2[i1] = stories[6];
                } else if (index == 7) {
                    array1[i1] = new MuggleStudies();
                    array2[i1] = stories[7];
                } else if (index == 8) {
                    array1[i1] = new Creatures();
                    array2[i1] = stories[8];
                } else if (index == 9) {
                    array1[i1] = new History();
                    array2[i1] = stories[9];
                } else if (index == 10) {
                    array1[i1] = new Runes();
                    array2[i1] = stories[10];
                } else if (index == 11) {
                    array1[i1] = new Apparition();
                    array2[i1] = stories[11];
                } else if (index == 12) {
                    array1[i1] = new Alchemy();
                    array2[i1] = stories[12];
                } else if (index == 13) {
                    array1[i1] = new MagicalTheory();
                    array2[i1] = stories[13];
                }
                i1++;
            }
            plan.createPlan(array1, array2);
            plan.setCurrent(currentMinigame);
            player.changePlan(plan);
            changed = true;
            dispose();
        });

        JButton back = new JButton("Back");
        back.setPreferredSize(new Dimension(110, 40));
        back.setHorizontalAlignment(JButton.CENTER);
        back.setVerticalAlignment(JButton.CENTER);
        back.setForeground(bcgColor[i[0][0]]);
        back.setBackground(houseColor[i[0][0]]);
        back.addActionListener(e -> {
            dispose();
            Thread changePlayerThreat = new Thread(() -> {
                try {
                    PlayerSetup playerSetup = new PlayerSetup();
                    playerSetup.set(getPlayer().getName(), getPlayer().getGender(), getPlayer().getHouse(), getPlayer().getInterests());
                    Player player1 = playerSetup.getPlayer();
                    setPlayer(player1, getPlayer().getLogin());
                    CreatePlan plan = new CreatePlan(player1);
                    setPlayer(plan.getPlayer());
                    new Waiter().wait(() -> player1.changePlan().getStory(1));
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    new Game(getPlayer());
                } catch (IOException | ClassNotFoundException | InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            });
            changePlayerThreat.start();
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
                    if (comboboxes[comboboxIndex[0]].isEnabled()){
                        comboboxes[comboboxIndex[0]].showPopup();
                        comboboxes[comboboxIndex[0]].requestFocus();
                    }
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

        for (int j = 0; j < this.player.changePlan().getCurrent(); j++) {
            if (j < 7)
                comboboxes[j].setEnabled(false);
        }

        panel.add(everythingPanel, BorderLayout.NORTH);


        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    /**
     * A method to get a player with the assigned plan from the GUI.
     * @return the player
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     */
    public Player getPlayer() throws InterruptedException {
        new Waiter().wait(() -> player);
        return player;
    }

    /**
     * This method sets the player
     * @param player the player
     */
    public void setPlayer(Player player){
        this.player = player;
    }

    /**
     * This method sets the player with the login if needed
     * @param player the player
     * @param login the login
     */
    public void setPlayer(Player player, String login){
        this.player.setLogin(login);
        this.player = player;
    }

    /**
     * This method checks if the player has changed using Boolean value, if so, it can change the value back to null, so it can be checked again.
     * @return true since the player changed
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     */
    public Boolean ifChanged() throws InterruptedException {
        new Waiter().wait(() -> changed);
        changed = null;
        return true;
    }
}