package cn.e3mall.pageHelper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;

public class PageHelperTest {

	@Test
	public void testPageHelper() {
		//1.向工程中添加PageHelper的jar包
		//2.需要在mybatis的配置文件中配置插件，原理就是拦截器
		//3.在执行查询之前设置查询信息
		PageHelper.startPage(1, 10);
		//4.执行查询
		//chushiuayige spring rongqi
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		//congspring rongqizhogn huoqu mapper duixiang
		TbItemMapper itemMapper = ac.getBean(TbItemMapper.class);
		TbItemExample itemExample = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(itemExample);
		//5.从查询结果中区分页结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		System.out.println(pageInfo.getTotal());
		System.out.println(pageInfo.getPages());
		System.out.println(pageInfo.getPageSize());
		
		
	}

}
