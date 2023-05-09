package GUI;

import Game.Player;


public class Builder implements BuilderInterface {
    Player player;
    String super_title;
    String image_path;
    @Override
    public Builder setPlayer(Player player) {
        this.player = player;
        return this;
    }

    @Override
    public Builder setSuper(String spr) {
        this.super_title = spr;
        return this;
    }
    @Override
    public Builder setImagePath(String path) {
        this.image_path = path;
        return this;
    }
}