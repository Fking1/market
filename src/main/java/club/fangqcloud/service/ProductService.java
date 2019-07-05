package club.fangqcloud.service;



import club.fangqcloud.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> select(Product product);

    Boolean insert(Product product);

    Boolean update(Product product);

    List<Product> selectByName(String productName);

    Boolean deleteById(Integer productId);

}
