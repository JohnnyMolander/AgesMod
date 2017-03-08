package net.asdfowkw.agesmod;

import net.asdfowkw.agesmod.blocks.BlockTileEntity;
import net.asdfowkw.agesmod.items.ItemModelProvider;
import net.asdfowkw.agesmod.items.ItemOreDict;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Johnny on 2017-03-08.
 */
public class ModBlocks {

    /*
    public static BlockOre oreCopper;
    public static BlockCropCorn cropCorn;
    public static BlockGrowPot growPot;
    public static BlockWindGenerator windGenerator;
    */

    public static void init() {
        /*
        oreCopper = register(new BlockOre("oreCopper", "oreCopper"));
        cropCorn = register(new BlockCropCorn(), null);
        growPot = register(new BlockGrowPot());
        windGenerator = register(new BlockWindGenerator());
        */
    }

    private static <T extends Block> T register(T block, ItemBlock itemBlock) {
        GameRegistry.register(block);
        if (itemBlock != null){
            GameRegistry.register(itemBlock);

            if(block instanceof ItemModelProvider) {
                ((ItemModelProvider)block).registerItemModel(itemBlock);
            }
            if(block instanceof ItemOreDict) {
                ((ItemOreDict)block).initOreDict();
            }
            if(itemBlock instanceof ItemOreDict) {
                ((ItemOreDict)itemBlock).initOreDict();
            }
        }

        if (block instanceof BlockTileEntity) {
            GameRegistry.registerTileEntity(((BlockTileEntity<?>)block).getTileEntityClass(), block.getRegistryName().toString());
        }
        return block;
    }

    private static <T extends Block> T register(T block) {
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }

}
