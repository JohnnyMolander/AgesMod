package net.asdfowkw.agesmod.utils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AMEventHandler {

    /*@SubscribeEvent(priority = EventPriority.HIGHEST)
    public void breakBlock(BlockEvent.BreakEvent event) {
        if(FMLCommonHandler.instance().getEffectiveSide().isClient())
            return;

        EntityPlayer player = event.getPlayer();

        if(player.inventory.getCurrentItem().getItem() != Items.IRON_PICKAXE) {
            event.setCanceled(true);
        }
    }*/

    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event)
    {
        if(event.getEntityPlayer() == null)
            return;
        ItemStack itemStack = event.getEntityPlayer().inventory.getCurrentItem();
        if(itemStack == null)
            return;
        if(isUselessTool(itemStack.getItem()))
            event.setNewSpeed(0);
    }

    public static boolean isUselessTool(Item item) {

        if(item == null)
            return false;

        //if(IguanaTweaks.toolWhitelist.contains(item))
        //    return false;

        if(item instanceof ItemTool)
            return true;

        return false;
    }

}
