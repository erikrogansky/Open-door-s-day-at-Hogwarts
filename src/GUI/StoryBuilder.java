package GUI;

import Game.Player;


public class StoryBuilder extends Builder implements BuilderInterface {
    @Override
    public StoryBuilder setPlayer(Player player) {
        this.player = player;
        return this;
    }
    @Override
    public StoryBuilder setSuper(String spr) {
        this.super_title = spr;
        return this;
    }
    @Override
    public StoryBuilder setImagePath(String path) {
        this.image_path = path;
        return this;
    }
    public Stories build() {
        return new Stories(this);
    }
}