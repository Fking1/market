package club.fangqcloud.service.impl;

import club.fangqcloud.mapper.ProductClassMapper;
import club.fangqcloud.pojo.ProductClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductClassServiceImpl implements club.fangqcloud.service.ProductClassService {
    @Autowired
    private ProductClassMapper productClassMapper;

    @Override
    public List<ProductClass> select(ProductClass productClass) {
        return productClassMapper.select(productClass);
    }

    @Override
    public Boolean insert(ProductClass productClass) {
        if(productClassMapper.insert(productClass)>0) {
            return true;
        }

        return false;
    }

    @Override
    public Boolean update(ProductClass productClass) {
        if(productClassMapper.update(productClass)>0) {
            return true;
        }

        return false;
    }


    @Override
    public List<ProductClass> selectByName(String className) {
        return productClassMapper.selectByName(className);
    }


    @Override
    public Boolean deleteById(Integer classId) {
        if(productClassMapper.deleteById(classId)>0) {
            return true;
        }

        return false;
    }
}
