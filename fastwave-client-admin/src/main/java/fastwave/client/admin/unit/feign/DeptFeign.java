package fastwave.client.admin.unit.feign;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fastwave.client.admin.unit.entity.Dept;
import fastwave.client.admin.unit.hystrix.DeptFallback;
import fastwave.lib.common.web.R;

/**
 * 
 * @author fastwave.developer
 * @date 2018-05-25 14:14:09
 * @Copyright: 2018 fastwave. All rights reserved. 
 * 注意：本内容仅限于信翰创武汉物联科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@FeignClient(name = "fastwave-service-admin", fallback = DeptFallback.class)
public interface DeptFeign {
	
	/**
	 * @Description 依据指定参数查询结果集及分页信息
	 * @param params 实体和分页的一些信息
	 * @return 分页结果
	 */
	@RequestMapping(value = "/unit/dept/list", method = RequestMethod.POST)
	public Map<String, Object> list(@RequestBody Map<String, Object> params);
   
	/**
	 * @Description 保存指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@RequestMapping(value = "/unit/dept/save", method = RequestMethod.POST)
	public R save(@RequestBody Dept dept);
	
	/**
	 * @Description 更新指定数据
	 * @param params 实体
	 * @return 是否操作成功
	 */
	@RequestMapping(value ="/unit/dept/update", method = RequestMethod.POST)
	public R update(@RequestBody Dept dept) ;
	
	/**
	 * @Description 删除数据
	 * @param params 实体数组
	 * @return 是否操作成功
	 */
	@RequestMapping(value = "/unit/dept/remove", method = RequestMethod.POST)
	public R remove(@RequestBody Map<String, Object> params);
	
	/**
	 * @Description 获取单条数据
	 * @param params 主键
	 * @return 实体
	 */
	@RequestMapping(value = "/unit/dept/view", method = RequestMethod.POST)
	public Map<String, Object> view(@RequestBody Map<String, Object> params);
	
}