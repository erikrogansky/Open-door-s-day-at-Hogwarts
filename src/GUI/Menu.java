package GUI;

import Game.*;
import Stories.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * In this class representing a GUI of a menu.
 */
public class Menu extends JDialog {
    private Player player;
    private Boolean exit;

    /**
     * This constructor creates the GUI of the menu with multiple buttons. There are buttons, for resuming, for getting back to login,
     * for changing the player info and their plan, and for exiting the game.
     * @param player the player
     * @param parent since it is a JDialog, it needs a parent JFrame
     */
    public Menu(Player player, JFrame parent) {
        super(parent, "Menu", true);
        this.player = player;
        this.exit = false;
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setSize(300, 500); // 750x525
        setLocationRelativeTo(parent);

        this.player = player;

        final String[] bcg_dir = {"img/setupG.jpg", "img/setupR.jpg", "img/setupH.jpg", "img/setupS.jpg", "img/setup.jpg"};
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
                ImageIcon image = new ImageIcon("img/menuimg.jpg");
                Image img = image.getImage();
//                int imgWidth = img.getWidth(null);
//                int imgHeight = img.getHeight(null);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
            }
        };

        panel.setLayout(new BorderLayout());

        JPanel everythingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, panel.getWidth() + 10, 100 + panel.getHeight()));
        everythingPanel.setOpaque(false);
        everythingPanel.setFocusable(true);

        everythingPanel.setLayout(new BoxLayout(everythingPanel, BoxLayout.Y_AXIS));

        JPanel spacerPanel1 = new JPanel();
        spacerPanel1.setPreferredSize(new Dimension(0, 10));
        spacerPanel1.setOpaque(false);
        spacerPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        everythingPanel.add(spacerPanel1);

        JPanel spacerPanel2 = new JPanel();
        spacerPanel2.setPreferredSize(new Dimension(0, 20));
        spacerPanel2.setOpaque(false);

        JPanel spacerPanel3 = new JPanel();
        spacerPanel3.setPreferredSize(new Dimension(0, 15));
        spacerPanel3.setOpaque(false);

        JPanel spacerPanel4 = new JPanel();
        spacerPanel4.setPreferredSize(new Dimension(0, 15));
        spacerPanel4.setOpaque(false);

        JPanel spacerPanel5 = new JPanel();
        spacerPanel5.setPreferredSize(new Dimension(0, 15));
        spacerPanel5.setOpaque(false);

        JPanel spacerPanel6 = new JPanel();
        spacerPanel6.setPreferredSize(new Dimension(0, 15));
        spacerPanel6.setOpaque(false);

        JLabel title = new JLabel("Menu");
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setForeground(bcgColor[i[0]]);
        JPanel titlePanel = new JPanel();
        titlePanel.setPreferredSize(new Dimension(0, 40));
        titlePanel.setOpaque(false);
        titlePanel.add(title);
        everythingPanel.add(titlePanel);


        everythingPanel.add(spacerPanel2);


        JButton resume = new JButton("Resume");
        resume.setPreferredSize(new Dimension(140, 50));
        resume.setHorizontalAlignment(JButton.CENTER);
        resume.setVerticalAlignment(JButton.CENTER);
        resume.setBackground(houseColor[i[0]]);
        resume.setForeground(bcgColor[i[0]]);
        resume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel resumePanel = new JPanel();
        resumePanel.setOpaque(false);
        resumePanel.add(resume);
        everythingPanel.add(resumePanel, BorderLayout.SOUTH);

        everythingPanel.add(spacerPanel3);


        JButton newGame = new JButton("Go to log in");
        newGame.setPreferredSize(new Dimension(140, 50));
        newGame.setHorizontalAlignment(JButton.CENTER);
        newGame.setVerticalAlignment(JButton.CENTER);
        newGame.setBackground(bcgColor[i[0]]);
        newGame.setForeground(houseColor[i[0]]);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setExit();
                Thread newGameThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Startup start = new Startup();
                        try {
                            new Game(start.getLogin(), start.getBool());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                // Start the thread
                newGameThread.start();
            }
        });
        JPanel newGamePanel = new JPanel();
        newGamePanel.setOpaque(false);
        newGamePanel.add(newGame);
        everythingPanel.add(newGamePanel, BorderLayout.SOUTH);

        everythingPanel.add(spacerPanel4);

        JButton changePlayer = new JButton("Change player info");
        changePlayer.setPreferredSize(new Dimension(140, 50));
        changePlayer.setHorizontalAlignment(JButton.CENTER);
        changePlayer.setVerticalAlignment(JButton.CENTER);
        changePlayer.setBackground(bcgColor[i[0]]);
        changePlayer.setForeground(houseColor[i[0]]);
        changePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setExit();
                Thread changePlayerThreat = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        PlayerSetup playerSetup = new PlayerSetup();
                        try {
                            playerSetup.set(getPlayer().getName(), getPlayer().getGender(), getPlayer().getHouse(), getPlayer().getInterests());
                            Player player = playerSetup.getPlayer();
                            setPlayer(player, getPlayer().getLogin(), getPlayer().changePlan(), getPlayer().getPoints());
                            player.changePlan().reload(player.changePlan().getCurrent(), player.changePlan().getStory(player.changePlan().getCurrent()).reload());
                        } catch (InstantiationException ex) {
                            throw new RuntimeException(ex);
                        } catch (IllegalAccessException ex) {
                            throw new RuntimeException(ex);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            new Game(getPlayer());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                // Start the thread
                changePlayerThreat.start();
            }
        });
        JPanel changePlayerPanel = new JPanel();
        changePlayerPanel.setOpaque(false);
        changePlayerPanel.add(changePlayer);
        everythingPanel.add(changePlayerPanel, BorderLayout.SOUTH);

        everythingPanel.add(spacerPanel5);

        JButton changePlan = new JButton("Change your plan");
        changePlan.setPreferredSize(new Dimension(140, 50));
        changePlan.setHorizontalAlignment(JButton.CENTER);
        changePlan.setVerticalAlignment(JButton.CENTER);
        changePlan.setBackground(bcgColor[i[0]]);
        changePlan.setForeground(houseColor[i[0]]);
        changePlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setExit();
                Thread changePlanThreat = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            CreatePlan plan = new CreatePlan(player);
                            plan.ifChanged();
                            setPlayer(plan.getPlayer());
                            getPlayer().changePlan().reload(0, null);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            new Game(getPlayer());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
                // Start the thread
                changePlanThreat.start();
            }
        });
        JPanel changePlanPanel = new JPanel();
        changePlanPanel.setOpaque(false);
        changePlanPanel.add(changePlan);
        everythingPanel.add(changePlanPanel, BorderLayout.SOUTH);

        everythingPanel.add(spacerPanel6);

        JButton exit = new JButton("Exit");
        exit.setPreferredSize(new Dimension(140, 50));
        exit.setHorizontalAlignment(JButton.CENTER);
        exit.setVerticalAlignment(JButton.CENTER);
        exit.setBackground(bcgColor[i[0]]);
        exit.setForeground(houseColor[i[0]]);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setExit();
                System.exit(0);
            }
        });
        JPanel exitPanel = new JPanel();
        exitPanel.setOpaque(false);
        exitPanel.add(exit);
        everythingPanel.add(exitPanel, BorderLayout.SOUTH);

        JButton[] allButtons = new JButton[]{resume, newGame, changePlayer, changePlan, exit};
        final int[] currentButtonIndex = {0};
        everythingPanel.requestFocus();
        everythingPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    currentButtonIndex[0] = (currentButtonIndex[0] - 1 + allButtons.length) % allButtons.length;
                    allButtons[currentButtonIndex[0]].setBackground(houseColor[i[0]]);
                    allButtons[currentButtonIndex[0]].setForeground(bcgColor[i[0]]);
                    allButtons[(currentButtonIndex[0] + 1) % allButtons.length].setForeground(houseColor[i[0]]);
                    allButtons[(currentButtonIndex[0] + 1) % allButtons.length].setBackground(bcgColor[i[0]]);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    currentButtonIndex[0] = (currentButtonIndex[0] + 1) % allButtons.length;
                    allButtons[currentButtonIndex[0]].setBackground(houseColor[i[0]]);
                    allButtons[currentButtonIndex[0]].setForeground(bcgColor[i[0]]);
                    if(currentButtonIndex[0] == 0){
                        allButtons[allButtons.length - 1].setForeground(houseColor[i[0]]);
                        allButtons[allButtons.length - 1].setBackground(bcgColor[i[0]]);
                    }
                    else {
                        allButtons[(currentButtonIndex[0] - 1) % allButtons.length].setForeground(houseColor[i[0]]);
                        allButtons[(currentButtonIndex[0] - 1) % allButtons.length].setBackground(bcgColor[i[0]]);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    allButtons[currentButtonIndex[0]].doClick();
                }
                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    resume.doClick();
                }
            }
        });

        panel.add(everythingPanel, BorderLayout.NORTH);

        getContentPane().add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    /**
     * This method sets the exit boolean, which indicates that the window menu is opened from should be closed
     */
    public void setExit(){
        this.exit = true;
    }

     /**
     * This is a method that uses {@link Waiter} class to wait until the exit variable is set
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     * @return the boolean value of {@link #exit}
     */
    public Boolean getExit() throws InterruptedException {
        new Waiter().wait(() -> this.exit);
        return this.exit;
    }

    /**
     * This method simply assigns the player to the class
     * @param player is the player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * This method assigns the player to the class and sets its login, plan and points.
     * This method is used when the player information are changed.
     * @param player is a variable for the player
     * @param login is a variable for the login
     * @param plan is a variable for the plan
     * @param points is a variable for the points
     */
    public void setPlayer(Player player, String login, Plan plan, int points) {
        this.player = player;
        this.player.addPoints(points);
        this.player.changePlan(plan);
        this.player.setLogin(login);
    }
    /**
     * This is a method that uses {@link Waiter} class to wait until the player is ready for extracting
     * @throws InterruptedException is thrown if there is a problem in {@link Waiter} class
     * @return the {@link Player}
     */
    public Player getPlayer() throws InterruptedException {
        new Waiter().wait(() -> this.player);
        return player;
    }
}
