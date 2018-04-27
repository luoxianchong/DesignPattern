package com.ing.erp.service.online;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.ing.erp.service.online.platform.JD;
import com.ing.erp.service.online.platform.PinDD;
import com.ing.erp.service.online.platform.TaoBao;
import com.ing.erp.service.online.platform.TradePlatform;
import com.ing.erp.service.online.pojo.ItemInventory;
import com.ing.erp.service.online.pojo.Token;

/**
 *      策略模式实践  之  库存同步
 * 
 * +------------------------+                  +-----------------------------------+
 * |(Context)SyncInventory  |                  |<<inteface>>(Strategy)TradePlatform|
 * +------------------------+                  +-----------------------------------+
 * |-(Strategy)TradePlatform|                  | +setToken(xx):void                |
 * +------------------------+ <>-------------> | +syncInventoryToPlatform(xx):void |
 * |+setPlatform()          |                  +-----------------------------------+
 * |+syncTo():void          |                                 /\
 * +------------------------+                                  |
 *                                                             |
 *                        +------------------------------------+---------------------------------------+
 *                        |                                    |                                       |
 *    +---------------------------------+   +---------------------------------+    +---------------------------------+    
 *    |     (ConcreteStrategy)PinDD     |   |     (ConcreteStrategy)JD        |    |     (ConcreteStrategy)TaoBao    |
 *    +---------------------------------+   +---------------------------------+    +---------------------------------+    
 *    |+setToken(Token):void            |   |+setToken(Token):void            |    |+setToken(Token):void            |
 *    |+syncInventoryToPlatform(xx):void|   |+syncInventoryToPlatform(xx):void|    |+syncInventoryToPlatform(xx):void|
 *    +---------------------------------+   +---------------------------------+    +---------------------------------+   
 * 
 * @author Ten
 *
 */
public class ItemSyncService {
	
	
	//模拟客户端入口
	public void uploadInv2Platform(int shopType,String ShopUid,Collection<ItemInventory> itemInvList){
		TradePlatform pf=platFormInstance(shopType);
		Token token=getToken(shopType, ShopUid);
		pf.setToken(token);
		pf.syncInventoryToPlatform(itemInvList);
	}
	
	public TradePlatform platFormInstance(int shopType){
		switch (shopType) {
		case 1:
			return new TaoBao();
		case 2:
			return new JD();
		default:
		    return new PinDD();
		}
	}
	
	public Token getToken(int shopType,String ShopUid){
		Map<String, String> dbShop=new HashMap<>();//假设从数据库存中获取存储的店铺对接线上平台信息
		String session=dbShop.get("session");
		String shopNick=dbShop.get("shopNick");
		String secret=dbShop.get("secret");
		return new Token(shopNick,secret,session);
		
	}
	
	
}
