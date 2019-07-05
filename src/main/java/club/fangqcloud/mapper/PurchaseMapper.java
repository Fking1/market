package club.fangqcloud.mapper;


import club.fangqcloud.pojo.Purchase;

import java.util.List;
import java.util.Map;

public interface PurchaseMapper {

	List<Map> select(Purchase purchase);

	int insert(Purchase purchase);

	int update(Purchase purchase);

	List<Map> selectByName(String purchaser);

	int deleteById(Integer purchaseId);
}
