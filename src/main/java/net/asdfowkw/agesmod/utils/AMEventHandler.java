package net.asdfowkw.agesmod.utils;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

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
    public static void onPlayerInteract(PlayerInteractEvent.RightClickBlock event){
        System.out.println("HEJ!");
    }

    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event)
    {
        if(event.getEntityPlayer() == null)
            return;
        ItemStack itemStack = event.getEntityPlayer().inventory.getCurrentItem();
        if(itemStack == null){
            /*
            List<ItemStack> logs = OreDictionary.getOres("logWood");
            for(ItemStack log : logs){
                if(OreDictionary.itemMatches(new ItemStack(Minecraft.getMinecraft().theWorld.getBlockState(event.getPos()).getBlock()), log, true)){
                    System.out.println("Matches");
                    return;
                } else {
                    System.out.println("No Match");
                    return;
                }
            }
            */
            return;
        }
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
