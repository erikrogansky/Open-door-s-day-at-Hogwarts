package GUI;

import Game.Player;

/**
 * A builder class that is used to build a {@link StatsGUI} class
 */
public class StatsBuilder extends Builder implements BuilderInterface {
    protected String name;
    protected String gender;
    protected String house;
    protected String[] interests;
    protected int points;
    protected String[] rewards;
    /**
     * A method to set the player
     * @param player the player
     * @return the builder
     */
    @Override
    public StatsBuilder setPlayer(Player player) {
        this.player = player;
        return this;
    }
    /**
     * A method to set the super title
     * @param spr the super title
     * @return the builder
     */
    @Override
    public StatsBuilder setSuper(String spr) {
        this.super_title = spr;
        return this;
    }
    /**
     * A method to set the background image path
     * @param path the path
     * @return the builder
     */
    @Override
    public StatsBuilder setImagePath(String path) {
        this.image_path = path;
        return this;
    }
    /**
     * A method to set the name
     * @param name the name
     * @return the builder
     */
    public StatsBuilder setName(String name) {
        this.name = name;
        return this;
    }
    /**
     * A method to set the gender
     * @param gender the gender
     * @return the builder
     */
    public StatsBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }
    /**
     * A method to set the house
     * @param house the house
     * @return the builder
     */
    public StatsBuilder setHouse(String house) {
        this.house = house;
        return this;
    }
    /**
     * A method to set the interests
     * @param interests the interests
     * @return the builder
     */
    public StatsBuilder setInterests(String[] interests) {
        this.interests = interests;
        return this;
    }
    /**
     * A method to set the points
     * @param points the points
     * @return the builder
     */
    public StatsBuilder setPoints(int points) {
        this.points = points;
        return this;
    }
    /**
     * A method to set the rewards
     * @param rewards the rewards
     * @return the builder
     */
    public StatsBuilder setRewards(String[] rewards) {
        this.rewards = rewards;
        return this;
    }
    /**
     * A method to build the {@link StatsGUI}.
     * @return the {@link StatsGUI}
     */
    public StatsGUI build() {
        return new StatsGUI(this);
    }
}
