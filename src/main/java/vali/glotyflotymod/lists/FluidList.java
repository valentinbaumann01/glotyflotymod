package vali.glotyflotymod.lists;

import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag.INamedTag;
import vali.glotyflotymod.fluids.FluidFondue;

public class FluidList {
	public static FluidFondue.Source fondue = null;
	public static FluidFondue.Flowing flowing_fondue = null;
	
	public static class Tags {
		public static final INamedTag<Fluid> FONDUE = FluidTags.makeWrapperTag("fondue");
	}

}
