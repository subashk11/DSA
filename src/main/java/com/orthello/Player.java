package com.orthello;

public class Player {

    // Player will have name and coin colour
    String name;
    int coin; // 0 - BLACK , 1 = WHITE.

    public Player(String name, int coin){
        this.setCoin(coin);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!name.trim().isEmpty()) {
            System.out.println("ENTER A VALID NAME : ");
            return ;
        }
        this.name = name.trim();
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        if(coin != 0 && coin != 1) {
            System.out.println("ENTER A VALID COIN NUMBER 0 OR 1 !");
        }
        this.coin = coin;
    }


}
