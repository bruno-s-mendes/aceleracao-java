package br.com.codenation.models;

import java.util.ArrayList;
import java.util.List;

public class Functions {

    public static boolean existsTeam(long id, ArrayList<Team> receivedTeam){
        boolean result = false;

        for (Team team : receivedTeam) {
            if (team.getId() == id) {
                result = true;
                break;
            }
        }
        return result;
    }
}
