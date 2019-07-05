package club.fangqcloud.service.impl;

import club.fangqcloud.mapper.PurchaseMapper;
import club.fangqcloud.pojo.Purchase;
import club.fangqcloud.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<Map> select(Purchase product) {
        return purchaseMapper.select(product);
    }

    @Override
    public Boolean insert(Purchase product) {
        if(purchaseMapper.insert(product)>0) {
            return true;
        }

        return false;
    }

    @Override
    public Boolean update(Purchase purchase) {
        if(purchaseMapper.update(purchase)>0) {
            return true;
        }

        return false;
    }


    @Override
    public List<Map> selectByName(String purchaser) {
        return purchaseMapper.selectByName(purchaser);
    }


    @Override
    public Boolean deleteById(Integer purchaseId) {
        if(purchaseMapper.deleteById(purchaseId)>0) {
            return true;
        }

        return false;
    }
}
