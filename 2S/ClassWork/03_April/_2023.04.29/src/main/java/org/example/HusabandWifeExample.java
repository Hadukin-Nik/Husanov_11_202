package org.example;

public class HusabandWifeExample {
    BonusCard bonusCard;

    Human wife, husband;

    public HusabandWifeExample(int money) {
        bonusCard = new BonusCard(money);

        wife = new Human(bonusCard, "wife");
        husband  = new Human(bonusCard, "husband");
    }

    public void run() {
        wife.start();
        husband.start();
    }
}
