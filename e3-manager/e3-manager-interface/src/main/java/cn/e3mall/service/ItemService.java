package cn.e3mall.service;

import cn.e3mall.common.pojo.DataGridReult;
import cn.e3mall.pojo.TbItem;

public interface ItemService {
	/**
	 * 根据id查询商品信息
	 * @param id
	 * @return
	 */
	TbItem findItemById(Long id);
	/**
	 * 分页查询商品信息
	 */
	DataGridReult getItemList(int page,int rows);
}
