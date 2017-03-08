package net.asdfowkw.agesmod.items;

import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Johnny on 2017-03-08.
 */
public class ItemOre extends ItemBase implements ItemOreDict {

    private String oreName;
    public ItemOre(String name, String oreName) {
        super(name);

        this.oreName = oreName;
    }

    @Override
    public void initOreDict() {
        OreDictionary.registerOre(oreName, this);
    }

}