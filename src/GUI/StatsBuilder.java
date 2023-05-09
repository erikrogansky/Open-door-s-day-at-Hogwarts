package GUI;

import Game.Player;

public class StatsBuilder extends Builder implements BuilderInterface {
    protected String name;
    protected String gender;
    protected String house;
    protected String[] interests;
    protected int points;
    protected String[] rewards;
    @Override
    public StatsBuilder setPlayer(Player player) {
        this.player = player;
        return this;
    }
    @Override
    public StatsBuilder setSuper(String spr) {
        this.super_title = spr;
        return this;
    }
    @Override
    public StatsBuilder setImagePath(String path) {
        this.image_path = path;
        return this;
    }
    public StatsBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public StatsBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }
    public StatsBuilder setHouse(String house) {
        this.house = house;
        return this;
    }
    public StatsBuilder setInterests(String[] interests) {
        this.interests = interests;
        return this;
    }
    public StatsBuilder setPoints(int points) {
        this.points = points;
        return this;
    }
    public StatsBuilder setRewards(String[] rewards) {
        this.rewards = rewards;
        return this;
    }
    public StatsGUI build() {
        return new StatsGUI(this);
    }
}
