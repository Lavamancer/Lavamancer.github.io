package com.jalbarracin;

import com.badlogic.gdx.Gdx;

import java.util.ArrayList;

public class Board {

    private static final int OFFSET_RANGE = 10;

    ArrayList<Player> players = new ArrayList<>();
    ArrayList<Card> cards = new ArrayList<>();
    Main main;

    Player currentPlayer;


    public Board(Main main) {
        this.main = main;

        players.add(new Player(main));
        players.add(new Player(main));
        players.add(new Player(main));
        players.add(new Player(main));
        setCurrentPlayer(players.get(0));
    }

    public void putOnBoard(Card card) {
        cards.add(card);
        float offsetX = (float) ((Math.random() * OFFSET_RANGE * 2) - OFFSET_RANGE);
        float offsetY = (float) ((Math.random() * OFFSET_RANGE * 2) - OFFSET_RANGE);
        card.setPosition(Gdx.graphics.getWidth() / 2f - card.getPrefWidth() / 2 + offsetX, Gdx.graphics.getHeight() / 2f - card.getPrefHeight() / 2 + offsetY);
        main.stage.addActor(card);
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getPreviousPlayer() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).equals(currentPlayer)) {
                int index = i - 1;
                return index < 0 ? players.get(players.size() - 1) : players.get(index);
            }
        }
        return null;
    }

    public Player getNextPlayer() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).equals(currentPlayer)) {
                int index = i + 1;
                return index >= players.size() ? players.get(0) : players.get(index);
            }
        }
        return null;
    }

}
