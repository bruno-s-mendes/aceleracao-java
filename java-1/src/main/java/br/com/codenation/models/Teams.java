package br.com.codenation.models;

import java.util.ArrayList;
import java.util.List;

public class Teams {
    private static final ArrayList<Team> Teams = new ArrayList<>();

    public static List<Team> getTeams() {
        return Teams;
    }

    public static void addTeam(Team newTeam){
        Teams.add(newTeam);
    }

    public static boolean existsTeam(long id){
        boolean result = false;

        for (Team team : Teams) {
            if (team.getId() == id) {
                result = true;
                break;
            }
        }
        return result;
    }
}
