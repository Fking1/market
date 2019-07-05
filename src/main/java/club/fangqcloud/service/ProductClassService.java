package club.fangqcloud.service;


import club.fangqcloud.pojo.ProductClass;

import java.util.List;

public interface ProductClassService {

    List<ProductClass> select(ProductClass productClass);

    Boolean insert(ProductClass productClass);

    Boolean update(ProductClass productClass);

    List<ProductClass> selectByName(String className);

    Boolean deleteById(Integer classId);

}
