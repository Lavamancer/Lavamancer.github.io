package com.jalbarracin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Card extends ImageButton {


    public enum Type {
        PLUS_FOUR, WILDCARD, PLUS_TWO, REVERSE, SKIP, REGULAR
    }

    public enum Color {
        BLUE, GREEN, RED, YELLOW, BLACK
    }

    Integer number;
    Color color;
    Type type;


    public Card(Type type, Color color, Integer number) {
        super(new TextureRegionDrawable(new TextureRegion(new Texture(getTexturePath(type, color, number)))));
        getStyle().imageDisabled = new TextureRegionDrawable(new TextureRegion(new Texture("back.png")));

        this.type = type;
        this.color = color;
        this.number = number;

    }

    public void show(boolean show) {
        setDisabled(!show);
        clearListeners();
    }

    public void setPlayer(final Player player) {
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                player.playCardFromHand(Card.this);
            }
        });
    }

    private static String getTexturePath(Type type, Color color, Integer number) {

        if (color == Color.BLACK && type == Type.PLUS_FOUR) return "black_+4.png";
        if (color == Color.BLACK && type == Type.WILDCARD) return "black_wildcard.png";

        String colorPath = color.toString().toLowerCase();

        switch (type) {
            case PLUS_TWO: return colorPath + "_+2.png";
            case REVERSE: return colorPath + "_reverse.png";
            case SKIP: return colorPath + "_skip.png";
            case REGULAR: return colorPath + "_" + number + ".png";
            default:
                System.out.println("Card does not exist");
                Gdx.app.exit();
                return null;
        }
    }


}
