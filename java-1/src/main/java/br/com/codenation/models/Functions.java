package br.com.codenation.models;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    public static Long getTeamFromPlayer(long playerId, ArrayList<Player> receivedPlayers){
        long teamId = 0L;

        for (Player player : receivedPlayers) {
            if (player.getId() == playerId) {
                teamId = player.getIdTime();
                break;
            }
        }
        return teamId;
    }

    public static void setCaptain(long teamId, long playerId, ArrayList<Team> receivedteams){
        for (Team team : receivedteams) {
            if (team.getId() == teamId) {
                team.setIdCapitao(playerId);
                break;
            }
        }
    }

    public static Long getCapitain(long teamId, ArrayList<Team> receivedTeam){
        long captainId = 0L;

        for (Team team : receivedTeam) {
            if (team.getId() == teamId) {
                if (team.getIdCapitao() != null){
                    captainId = team.getIdCapitao();
                    break;
                }
            }
        }
        return captainId;
    }
}
