package com.ing.erp.service.online.platform;

import java.util.Collection;

import com.ing.erp.service.online.pojo.ItemInventory;
import com.ing.erp.service.online.pojo.Session;
import com.ing.erp.service.online.pojo.Token;


/**
 * 具体策略 
 * @author Ten
 *
 */
public class TaoBao implements TradePlatform {
	
	private Session tbSession;

	@Override
	public void syncInventoryToPlatform(Collection<ItemInventory> itemInvList) {
		for (ItemInventory itemInv : itemInvList) {
			System.out.println("淘宝平台，库存同步，商品："+itemInv.getItemID()
				+"商品规格："+itemInv.getSkuID()+"数量："+itemInv.getQuantity());
		}
	}

	@Override
	public void setToken(Token token) {
		//根据token生成Session
	}

}
