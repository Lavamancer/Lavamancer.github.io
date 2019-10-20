package com.jalbarracin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;

import java.util.ArrayList;

public class Player {

    HorizontalGroup horizontalGroup = new HorizontalGroup();
    Main main;
    ArrayList<Card> cards = new ArrayList<>();


    public Player(Main main) {
        this.main = main;
        main.stage.addActor(horizontalGroup);
        drawSevenCards();
    }

    public void update() {
        if (amICurrentPlayer()) {
            horizontalGroup.setPosition(Gdx.graphics.getWidth() / 2f - horizontalGroup.getPrefWidth() / 2f, horizontalGroup.getPrefHeight());
        } else if (amIPreviousPlayer()){
            horizontalGroup.setOrigin(horizontalGroup.getWidth() / 2, horizontalGroup.getHeight() / 2);
            horizontalGroup.setPosition(40, horizontalGroup.getPrefHeight());
            horizontalGroup.setRotation(90);

            for (Card card : cards) {
                card.show(false);
            }
        } else if (amINextPlayer()) {
            horizontalGroup.setOrigin(horizontalGroup.getWidth() / 2, horizontalGroup.getHeight() / 2);
            horizontalGroup.setPosition(Gdx.graphics.getWidth() - 40, horizontalGroup.getPrefHeight());
            horizontalGroup.setRotation(90);

            for (Card card : cards) {
                card.show(false);
            }
        } else {
            horizontalGroup.setVisible(false);
        }
    }

    private void drawSevenCards() {
        for (int i = 0; i < 7; i++) {
            drawFromDeck();
        }
    }

    public void drawFromDeck() {
        Card card = main.deck.draw();
        cards.add(card);
        horizontalGroup.addActor(card);
        card.setPlayer(this);
    }

    public void playCardFromHand(Card card) {
        cards.remove(card);
        horizontalGroup.removeActor(card);
        main.board.putOnBoard(card);
        card.clearListeners();
    }

    public boolean amICurrentPlayer() {
        return main.board.getCurrentPlayer().equals(this);
    }

    public boolean amIPreviousPlayer() {
        return main.board.getPreviousPlayer().equals(this);
    }
    public boolean amINextPlayer() {
        return main.board.getNextPlayer().equals(this);
    }



}
