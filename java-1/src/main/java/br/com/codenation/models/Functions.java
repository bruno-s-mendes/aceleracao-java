package br.com.codenation.models;

import java.util.ArrayList;

public class Functions {

    public static boolean existsTeam(long id, ArrayList<Team> receivedTeams){
        boolean result = false;

        for (Team team : receivedTeams) {
            if (team.getId() == id) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean existsPlayer(long id, ArrayList<Player> receivedPlayers){
        boolean result = false;

        for (Player player : receivedPlayers) {
            if (player.getId() == id) {
                result = true;
                break;
            }
        }
        return result;
    }
}
