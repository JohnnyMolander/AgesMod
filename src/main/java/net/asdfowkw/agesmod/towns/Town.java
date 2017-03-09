package net.asdfowkw.agesmod.towns;

import net.minecraft.entity.player.EntityPlayer;

import java.util.*;

/**
 * Created by Johnny on 2017-03-08.
 */
public class Town {

    private final LinkedHashMap<UUID, String> residents = new LinkedHashMap<UUID, String>();
    private final List<Resident> onlineResidents = new ArrayList<Resident>();

    private Mayor mayor;
    private String name;
    private String password;
    private boolean locked;
    private int level;

    public Town(Mayor mayor, String name){
        this.name = name;
        this.mayor = mayor;
    }

    public LinkedHashMap<UUID, String> getResidents() {
        return residents;
    }

    public List<Resident> getOnlineResidents() {
        return onlineResidents;
    }

    public boolean addOnlineResident(Resident player){
        return onlineResidents.add(player);
    }

    public boolean removeOnlineMember(Resident player) {
        return onlineResidents.remove(player);
    }

    public String getName() {
        return name;
    }

    public Mayor getMayor() {
        return mayor;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMayor(Mayor mayor) {
        this.mayor = mayor;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean hasMember(String memberName) {
        return this.getResidents().values().contains(memberName);
    }

    public boolean hasMember(UUID uuid) {
        return this.getResidents().keySet().contains(uuid);
    }

    /*
    public String createMembersList(String playerName, List<Resident> nearMembers) {
        StringBuilder memberList = new StringBuilder();

        for (Map.Entry<UUID, String> memberEntry : this.getResidents().entrySet()) {
            UUID uuid = memberEntry.getKey();
            String memberName = memberEntry.getValue();

            Resident member = GET_PLAYER_UUID;

            if (this.getMayor().getUniqueId().equals(uuid)) {
                memberList.append(ChatColor.GOLD);

                if (member == null) {
                    memberName = memberName.substring(0, 1) + ChatColor.GRAY + ChatColor.ITALIC + "" + memberName.substring(1);
                }
            }
            else if (member != null) {
                memberList.append(ChatColor.WHITE);
            }
            else {
                memberList.append(ChatColor.GRAY);
            }

            if (!nearMembers.contains(member) && !playerName.equalsIgnoreCase(memberName)) {
                memberList.append(ChatColor.ITALIC).append("");
            }

            memberList.append(memberName).append(ChatColor.RESET).append(" ");
        }

        return memberList.toString();
    }
    */



}
