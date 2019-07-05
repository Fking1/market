package club.fangqcloud.mapper;

import java.util.List;

import club.fangqcloud.pojo.Supplier;

public interface SupplierMapper {

	List<Supplier> select(Supplier supplier);

	int insert(Supplier supplier);

	int update(Supplier supplier);

	List<Supplier> selectByName(String supplierName);

	int deleteBySupplierId(Integer supplierId);
}
