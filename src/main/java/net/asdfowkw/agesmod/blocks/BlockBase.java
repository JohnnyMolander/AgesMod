package net.asdfowkw.agesmod.blocks;

import net.asdfowkw.agesmod.AgesMod;
import net.asdfowkw.agesmod.items.ItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Johnny on 2017-03-08.
 */
public class BlockBase extends Block implements ItemModelProvider {

    protected String name;

    public BlockBase(Material material, String name) {
        super(material);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(AgesMod.creativeTab);
    }

    @Override
    public void registerItemModel(Item itemBlock) {
        AgesMod.proxy.registerItemrenderer(itemBlock, 0, name);
    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}