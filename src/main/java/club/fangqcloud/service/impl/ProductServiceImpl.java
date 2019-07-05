package club.fangqcloud.service.impl;

import club.fangqcloud.mapper.ProductMapper;
import club.fangqcloud.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements club.fangqcloud.service.ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> select(Product product) {
        return productMapper.select(product);
    }

    @Override
    public Boolean insert(Product product) {
        if(productMapper.insert(product)>0) {
            return true;
        }

        return false;
    }

    @Override
    public Boolean update(Product product) {
        if(productMapper.update(product)>0) {
            return true;
        }

        return false;
    }


    @Override
    public List<Product> selectByName(String productName) {
        return productMapper.selectByName(productName);
    }


    @Override
    public Boolean deleteById(Integer productId) {
        if(productMapper.deleteById(productId)>0) {
            return true;
        }

        return false;
    }
}
