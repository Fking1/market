package club.fangqcloud.mapper;


import club.fangqcloud.pojo.Sell;

import java.util.List;
import java.util.Map;

public interface SellMapper {

	List<Map> select(Sell sell);

	int insert(Sell sell);

	int update(Sell sell);

	List<Map> selectByName(String seller);

	int deleteById(Integer sellId);
}
