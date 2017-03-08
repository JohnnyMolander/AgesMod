package net.asdfowkw.agesmod.utils;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AMEventHandler {

    @SubscribeEvent
    public void onBreakBlock(BlockEvent.BreakEvent event, Block block, EntityPlayer player, int meta) {
        if(player.getHeldEquipment() == Items.IRON_PICKAXE) {
            event.setCanceled(true);
        }
    }

}
