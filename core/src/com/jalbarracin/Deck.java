package com.jalbarracin;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    ArrayList<Card> cards = new ArrayList<>();


    public Deck() {

        for (int i = 0; i <= 9; i++) {
            if (i < 2) {
                cards.add(new Card(Card.Type.PLUS_FOUR, Card.Color.BLACK, null));
                cards.add(new Card(Card.Type.WILDCARD, Card.Color.BLACK, null));

                cards.add(new Card(Card.Type.PLUS_TWO, Card.Color.BLUE, null));
                cards.add(new Card(Card.Type.PLUS_TWO, Card.Color.GREEN, null));
                cards.add(new Card(Card.Type.PLUS_TWO, Card.Color.RED, null));
                cards.add(new Card(Card.Type.PLUS_TWO, Card.Color.YELLOW, null));

                cards.add(new Card(Card.Type.REVERSE, Card.Color.BLUE, null));
                cards.add(new Card(Card.Type.REVERSE, Card.Color.GREEN, null));
                cards.add(new Card(Card.Type.REVERSE, Card.Color.RED, null));
                cards.add(new Card(Card.Type.REVERSE, Card.Color.YELLOW, null));

                cards.add(new Card(Card.Type.SKIP, Card.Color.BLUE, null));
                cards.add(new Card(Card.Type.SKIP, Card.Color.GREEN, null));
                cards.add(new Card(Card.Type.SKIP, Card.Color.RED, null));
                cards.add(new Card(Card.Type.SKIP, Card.Color.YELLOW, null));
            }

            int amount = i == 0 ? 1 : 2;
            for (int j = 0; j < amount; j++) {
                cards.add(new Card(Card.Type.REGULAR, Card.Color.BLUE, i));
                cards.add(new Card(Card.Type.REGULAR, Card.Color.GREEN, i));
                cards.add(new Card(Card.Type.REGULAR, Card.Color.RED, i));
                cards.add(new Card(Card.Type.REGULAR, Card.Color.YELLOW, i));
            }
        }

        System.out.println(cards.size() + " Cards");
        Collections.shuffle(cards);
    }

    public Card draw() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

}
