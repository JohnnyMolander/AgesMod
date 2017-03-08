package net.asdfowkw.agesmod;

import net.asdfowkw.agesmod.items.ItemBase;
import net.asdfowkw.agesmod.items.ItemModelProvider;
import net.asdfowkw.agesmod.items.ItemOre;
import net.asdfowkw.agesmod.items.ItemOreDict;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Johnny on 2017-03-08.
 */
public class ModItems {

    public static ItemBase ingotCopper;
    public static ItemBase corn;

    public static void init() {
        ingotCopper = register(new ItemOre("ingotCopper", "ingotCopper"));
        corn = register(new ItemOre("corn", "cropCorn"));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof ItemModelProvider) {
            ((ItemModelProvider)item).registerItemModel(item);
        }
        if (item instanceof ItemOreDict) {
            ((ItemOreDict)item).initOreDict();
        }

        return item;
    }

}
