package club.fangqcloud.service;

import club.fangqcloud.pojo.Sell;

import java.util.List;
import java.util.Map;

public interface SellService {

    List<Map> select(Sell sell);

    Boolean insert(Sell sell);

    Boolean update(Sell sell);

    List<Map> selectByName(String seller);

    Boolean deleteById(Integer sellId);

}
