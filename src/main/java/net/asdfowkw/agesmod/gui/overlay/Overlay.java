package net.asdfowkw.agesmod.gui.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class Overlay extends Gui{

    private Minecraft mc;

    public Overlay(Minecraft mc){
        super();
        this.mc = mc;
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void RenderGameOverlayEvent(RenderGameOverlayEvent.Post event){
        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT){
            RenderBar();
        }
    }

    private void RenderBar(){
        GL11.glScalef(1.0f, 1.0f, 1.0f);

        int bottomBarWidth = 364;
        int bottomBarHeight = 44;
        int startX = (mc.displayWidth / 2) - (bottomBarWidth / 2);
        int startY = 0;

        DrawBar(startX, startY, bottomBarWidth, bottomBarHeight, new ResourceLocation("agesmod", "textures/overlay/bottomBar.png"), 1.0f);

        GL11.glScalef(1f, 1f, 1f);
    }

    private void DrawBar(int x, int y, int width, int height, ResourceLocation texture, float alpha)
    {
        mc.getTextureManager().bindTexture(texture);

        GL11.glColor4f(1f, 1f, 1f, alpha);
        GL11.glPushMatrix();
        GL11.glScalef(0.5f, 0.5f, 0.5f);

        mc.ingameGUI.drawModalRectWithCustomSizedTexture(x, y, 0, 0, width, height, width, height);

        GL11.glPopMatrix();
    }

}