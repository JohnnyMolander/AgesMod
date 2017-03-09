package net.asdfowkw.agesmod.proxy;

import net.asdfowkw.agesmod.AgesMod;
import net.asdfowkw.agesmod.event.skills.Crafting;
import net.asdfowkw.agesmod.gui.overlay.Overlay;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by Johnny on 2017-03-08.
 */
public class ClientProxy extends CommonProxy {

    private Minecraft mc = Minecraft.getMinecraft();

    public void preInit(){}
    public void init(){

        registerRenders();

        //NetworkRegistry.INSTANCE.registerGuiHandler(AgesMod.instance, new GuiHandler());

    }

    public void postInit(){}

    public void registerRenders(){
        MinecraftForge.EVENT_BUS.register(new Overlay(mc));
        MinecraftForge.EVENT_BUS.register(new Crafting());
    }

    public void registerItemrenderer(Item item, int meta, String id) {

        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(AgesMod.MODID + ":" + id, "inventory"));

    }

}
