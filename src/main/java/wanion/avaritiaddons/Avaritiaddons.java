package wanion.avaritiaddons;

/*
 * Created by WanionCane(https://github.com/WanionCane).
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkCheckHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import wanion.avaritiaddons.block.chest.infinity.BlockInfinityChest;

import java.util.Map;

import static wanion.avaritiaddons.common.Reference.*;

@Mod(modid = MOD_ID, name = MOD_NAME, version = MOD_VERSION, dependencies = DEPENDENCIES)
public final class Avaritiaddons
{
	@Mod.Instance
	public static Avaritiaddons instance;

	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
	public static CommonProxy proxy;

	public static final int GUI_ID_COMPRESSED_CHEST = 0, GUI_ID_INFINITY_CHEST = 1;

	public static final CreativeTabs creativeTabs = new CreativeTabs(MOD_ID)
	{
		@SideOnly(Side.CLIENT)
		@Override
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(BlockInfinityChest.instance);
		}
	};

	@Mod.EventHandler
	public void preInit(final FMLPreInitializationEvent event)
	{
		proxy.preInit();
	}

	@Mod.EventHandler
	public void init(final FMLInitializationEvent event)
	{
		proxy.init();
	}

	@Mod.EventHandler
	public void postInit(final FMLPostInitializationEvent event)
	{
		proxy.postInit();
	}

	@NetworkCheckHandler
	public boolean matchModVersions(Map<String, String> remoteVersions, Side side)
	{
		return remoteVersions.containsKey(MOD_ID) && remoteVersions.get(MOD_ID).equals(MOD_VERSION);
	}
}