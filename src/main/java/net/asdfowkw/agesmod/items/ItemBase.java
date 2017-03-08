package net.asdfowkw.agesmod.items;

import net.asdfowkw.agesmod.AgesMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Johnny on 2017-03-08.
 */
public class ItemBase extends Item implements ItemModelProvider{

    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(AgesMod.creativeTab);
    }

    @Override
    public void registerItemModel(Item item) {
        AgesMod.proxy.registerItemrenderer(item, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}
