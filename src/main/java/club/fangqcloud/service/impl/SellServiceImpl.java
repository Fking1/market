package club.fangqcloud.service.impl;

import club.fangqcloud.mapper.SellMapper;
import club.fangqcloud.pojo.Sell;
import club.fangqcloud.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SellServiceImpl implements SellService {
    @Autowired
    private SellMapper sellMapper;

    @Override
    public List<Map> select(Sell sell) {
        return sellMapper.select(sell);
    }

    @Override
    public Boolean insert(Sell sell) {
        if(sellMapper.insert(sell)>0) {
            return true;
        }

        return false;
    }

    @Override
    public Boolean update(Sell sell) {
        if(sellMapper.update(sell)>0) {
            return true;
        }

        return false;
    }


    @Override
    public List<Map> selectByName(String seller) {
        return sellMapper.selectByName(seller);
    }


    @Override
    public Boolean deleteById(Integer sellId) {
        if(sellMapper.deleteById(sellId)>0) {
            return true;
        }

        return false;
    }
}
