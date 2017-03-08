package net.asdfowkw.agesmod.client;

import net.asdfowkw.agesmod.AgesMod;
import net.asdfowkw.agesmod.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Johnny on 2017-03-08.
 */
public class AgesTab extends CreativeTabs {

    public AgesTab() {
        super(AgesMod.MODID);
        setBackgroundImageName("item_search.png");
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.ingotCopper;
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

}