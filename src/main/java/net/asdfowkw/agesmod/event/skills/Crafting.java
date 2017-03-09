package net.asdfowkw.agesmod.event.skills;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

/**
 * Created by Johnny on 2017-03-08.
 */
public class Crafting {

    public Crafting() {

    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void eventHandler(PlayerEvent.ItemCraftedEvent event) {
        if (event.crafting.getItem() == Item.getItemFromBlock(Blocks.CRAFTING_TABLE)) {
            updateCraftingXP(event.player, 3);
            System.out.println("You crafted a crafting table!");
        }

        if (event.crafting.getItem() == Items.STICK) {
            System.out.println("CraftingXP: " + event.player.getEntityData().getInteger("CraftingXP"));
        }
    }

    public void updateCraftingXP(EntityPlayer player, int xp) {

        if (!player.getEntityData().hasKey("CraftingXP")) {
            player.getEntityData().setInteger("CraftingXP", xp);
        } else {
            player.getEntityData().setInteger("CraftingXP", player.getEntityData().getInteger("CraftingXP") + xp);
        }

    }
}
