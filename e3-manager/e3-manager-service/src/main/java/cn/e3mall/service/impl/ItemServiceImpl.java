package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.DataGridReult;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper tim;
	
	@Override
	public TbItem findItemById(Long id) {
		// TODO Auto-generated method stub
		return tim.selectByPrimaryKey(id);
	}

	@Override
	public DataGridReult getItemList(int page, int rows) {
		// TODO Auto-generated method stub
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = tim.selectByExample(example);
		//从查询结果中取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		//创建一个datagridresult
		DataGridReult dgr = new DataGridReult();
		dgr.setTotal(total);
		dgr.setRows(list);
		//把结果封装到datagridresult对象中
		return dgr;
	}

}
