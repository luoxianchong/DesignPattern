package com.ing.erp.service.online.handler;

import java.util.Collection;

import com.ing.erp.service.online.platform.TradePlatform;
import com.ing.erp.service.online.pojo.ItemInventory;

/**
 * 环境(Context)
 * @author Ten
 */
public class SyncInventory {
	
	private TradePlatform platform;

	public void setPlatform(TradePlatform platform) {
		this.platform = platform;
	}
	
	
	public void syncTo(Collection<ItemInventory> itemInvList){
		this.platform.syncInventoryToPlatform(itemInvList);
	}

}
