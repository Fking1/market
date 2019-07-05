package club.fangqcloud.service;


import club.fangqcloud.pojo.Purchase;

import java.util.List;
import java.util.Map;

public interface PurchaseService {

    List<Map> select(Purchase purchase);

    Boolean insert(Purchase purchase);

    Boolean update(Purchase purchase);

    List<Map> selectByName(String purchaser);

    Boolean deleteById(Integer purchaseId);

}
