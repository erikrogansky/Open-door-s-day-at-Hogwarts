package GUI;

import Game.*;


public class StoryBuilder extends Builder {
    public Stories build() {
        return new Stories(this);
    }
}