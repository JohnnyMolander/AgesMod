package net.asdfowkw.agesmod.proxy;

import net.asdfowkw.agesmod.AgesMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by Johnny on 2017-03-08.
 */
public class ClientProxy extends CommonProxy {

    public void preInit(){}
    public void init(){

        //NetworkRegistry.INSTANCE.registerGuiHandler(AgesMod.instance, new GuiHandler());

    }

    public void postInit(){}

    public void registerItemrenderer(Item item, int meta, String id) {

        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(AgesMod.MODID + ":" + id, "inventory"));

    }

}
