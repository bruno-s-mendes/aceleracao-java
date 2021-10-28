package br.com.codenation.models;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final ArrayList<Player> Players = new ArrayList<>();

    public static List<Player> getPlayers() {
        return Players;
    }

    public static void addPlayer(Player newPLayer) {
        Players.add(newPLayer);
    }

    public static boolean existsPlayer(long id){
        boolean result = false;

        for (Player player : Players) {
            if (player.getId() == id) {
                result = true;
                break;
            }
        }
        return result;
    }
}
