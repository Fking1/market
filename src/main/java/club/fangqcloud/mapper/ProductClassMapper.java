package club.fangqcloud.mapper;

import club.fangqcloud.pojo.ProductClass;

import java.util.List;

public interface ProductClassMapper {

	List<ProductClass> select(ProductClass productClass);

	int insert(ProductClass productClass);

	int update(ProductClass productClass);

	List<ProductClass> selectByName(String className);

	int deleteById(Integer classId);
}
