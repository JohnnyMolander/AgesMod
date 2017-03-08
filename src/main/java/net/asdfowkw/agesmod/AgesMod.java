package net.asdfowkw.agesmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

/**
 * Created by Johnny on 2017-03-08.
 */
public class AgesMod {

    public static final String MODID = "agesmod";
    public static final String MODNAME = "Ages Mod";
    public static final String MODVERSION = "0.0.1";
    public static final String CHANNEL = "agesmod";
    public static final AgesTab creativeTab = new AgesTab();

    @SidedProxy(clientSide = "net.asdfowkw.agesmod.proxy.ClientProxy", serverSide = "net.asdfowkw.agesmod.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static SimpleNetworkWrapper channel;

    @Mod.Instance
    public static AgesMod instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        ModBlocks.init();
        ModItems.init();
        channel = NetworkRegistry.INSTANCE.newSimpleChannel(CHANNEL);
        //channel.registerMessage(MessageSetEnergy.Handler.class, MessageSetEnergy.class, 0, Side.CLIENT);

        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        ModRecipes.init();
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    }

}
