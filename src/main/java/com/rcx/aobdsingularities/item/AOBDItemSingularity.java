package com.rcx.aobdsingularities.item;

import com.rcx.aobdsingularities.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.avaritia.items.ItemResource;
import fox.spiteful.avaritia.items.LudicrousItems;
import fox.spiteful.avaritia.render.IHaloRenderItem;
import ganymedes01.aobd.AOBD;
import ganymedes01.aobd.client.ItemOreRenderer;
import ganymedes01.aobd.items.AOBDItem;
import ganymedes01.aobd.ore.Ore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.oredict.OreDictionary;

public class AOBDItemSingularity extends AOBDItem implements IHaloRenderItem {

    public static IIcon background;
    public static IIcon foreground;

	public AOBDItemSingularity(String base, Ore ore) {
		super(base, ore);
		setCreativeTab(AOBD.tab);
		setTextureName("avaritia:singularity");
		setUnlocalizedName(Reference.MOD_ID + "." + base + ore);
	}

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemstack, int renderpass) {
        return renderpass == 0 ? ore.getColour().darker().darker().getRGB() : ore.colour();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir) {
    	foreground = ir.registerIcon("avaritia:singularity");
    	background = ir.registerIcon("avaritia:singularity2");
    }
    
    @Override
    public IIcon getIcon(ItemStack stack, int pass) {
    	if (pass == 0) { return background; }
    	return foreground;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int meta, int pass) {
    	if (pass == 0) { return background; }
    	return foreground;
	}

	@SideOnly(Side.CLIENT)
	public IItemRenderer getSpecialRenderer() {
		if ("ore".equals(base))
			return ItemOreRenderer.INSTANCE;
		return null;
	}

    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }

    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.uncommon;
    }

	@SideOnly(Side.CLIENT)
	public boolean drawHalo(ItemStack paramItemStack) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getHaloTexture(ItemStack paramItemStack) {
		return ((ItemResource)LudicrousItems.resource).halo[0];
	}

	@SideOnly(Side.CLIENT)
	public int getHaloSize(ItemStack paramItemStack) {
		return 4;
	}

	@SideOnly(Side.CLIENT)
	public boolean drawPulseEffect(ItemStack paramItemStack) {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int getHaloColour(ItemStack paramItemStack) {
		return 0xFF000000;
	}
}
