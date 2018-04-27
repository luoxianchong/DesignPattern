package com.ing.erp.service.online.platform;

import java.util.Collection;

import com.ing.erp.service.online.pojo.ItemInventory;
import com.ing.erp.service.online.pojo.Token;

/**
 * 抽象策略(Strategy)
 * @author Ten
 */
public interface TradePlatform {
	
	public void setToken(Token token);

	public void syncInventoryToPlatform(Collection<ItemInventory> itemInv);
	
}
