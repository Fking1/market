package club.fangqcloud.mapper;


import club.fangqcloud.pojo.Product;

import java.util.List;

public interface ProductMapper {

	List<Product> select(Product product);

	int insert(Product product);

	int update(Product product);

	List<Product> selectByName(String productName);

	int deleteById(Integer productId);
}
