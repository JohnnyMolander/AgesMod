package net.asdfowkw.agesmod.towns;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by Johnny on 2017-03-08.
 */
public class TownManager {

    private static List<Town> towns = new ArrayList<Town>();

    private TownManager(){}

    public static boolean checkPartyExistence(EntityPlayer player, String partyName){
        if(getTown(partyName) == null){
            return false;
        }

        player.addChatMessage(new TextComponentString("Town already exists"));
        return true;
    }

    /*
    public static boolean changeOrJoinTown(EntityPlayer player, String newTownName){
        Resident resident = new Resident(player);

        if(resident.inTown()){
            Town oldTown = resident.getTown();

            if(!handleTownChangeEvent(resident, oldTown.getName(), newTownName, EventReason.CHANGED_TOWN)){
                return false;
            }

            removeFromTown(resident);
        }

    }
    */

    /*
    public static boolean inSameTown(Resident firstResident, Resident secondResident){
        Town firstTown = firstResident.getTown();
        Town secondTown = secondResident.getTown();

        if(firstTown == null || secondTown == null){
            return false;
        }

        return firstTown.equals(secondTown);
    }
    */

    public static LinkedHashMap<UUID, String> getAllResidents(String townName){
        Town town = getTown(townName);

        return town == null ? new LinkedHashMap<UUID, String>() : town.getResidents();
    }

    public static List<Resident> getOnlineResidents(String townName){
        return getOnlineResidents(getTown(townName));
    }

    private static List<Resident> getOnlineResidents(Town town) {
        return town == null ? new ArrayList<Resident>() : town.getOnlineResidents();
    }

    public static Town getTown(String townName){
        for (Town town : towns){
            if(town.getName().equalsIgnoreCase(townName)){
                return town;
            }
        }
        return null;
    }

    public static Town getResidentTown(String residentName, UUID uuid){
        for(Town town : towns){
            LinkedHashMap<UUID, String> residents = town.getResidents();
            if(residents.keySet().contains(uuid) || residents.values().contains(residentName)){

                if(residents.get(uuid) == null || !residents.get(uuid).equals(residentName)){
                    residents.put(uuid, residentName);
                }
                return town;
            }
        }
        return null;
    }

    public static List<Town> getTowns() {
        return towns;
    }

    /*
    public static void removeFromTown(Resident resident, Town town){
        LinkedHashMap<UUID, String> residents = town.getResidents();
        String residentName = resident.getName();

        residents.remove(resident.getUniqueId());

        if(residents.isEmpty()){
            towns.remove(town);
        } else {
            if(town.getMayor().getUniqueId().equals(resident.getUniqueId())){
                setTownMayor(residents.keySet().iterator().next(), town);
            }

            informTownResidentsQuit(town, residentName);
        }
    }
    */

    /*
    public static void disbandTown(Town town){
        for (Resident resident : town.getOnlineResidents()){
            processTownLeaving(resident);
        }
    }
    */


    /*
    public static void createTown(Resident resident, String townName){
        Mayor mayor = new Mayor(resident.getUniqueId(), resident.getName());
        Town town = new Town(mayor, townName);

        towns.add(town);
        addToTown(resident);
    }
    */

    /*
    public static void addToTown(Resident resident, Town town){
        resident.setTown(town);
        town.getResidents().put(resident.getUniqueId(), resident.getName());
    }
    */

    public static String getTownMayorName(String townName){
        Town town = getTown(townName);

        return town == null ? null : town.getMayor().getPlayerName();
    }

    public static void setTownMayor(UUID uuid, Town town){
        //TODO
    }

    public static void loadTowns(){

    }

    public static void saveTowns(){

    }

}
