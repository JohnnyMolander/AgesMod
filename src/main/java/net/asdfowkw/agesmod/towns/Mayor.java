package net.asdfowkw.agesmod.towns;

import java.util.UUID;

/**
 * Created by Johnny on 2017-03-08.
 */
public class Mayor {

    private UUID uuid;
    private String playerName;

    public Mayor(UUID uuid, String playerName){
        this.uuid = uuid;
        this.playerName = playerName;
    }

    public UUID getUniqueId(){
        return uuid;
    }

    public String getPlayerName(){
        return playerName;
    }

}
