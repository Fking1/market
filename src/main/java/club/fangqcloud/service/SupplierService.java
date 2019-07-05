package club.fangqcloud.service;

import club.fangqcloud.pojo.Supplier;
import java.util.List;

public interface SupplierService {

    List<Supplier> select(Supplier supplier);

    Boolean insert(Supplier supplier);

    Boolean update(Supplier supplier);

    List<Supplier> selectByName(String supplierName);

    Boolean deleteBySupplierId(Integer supplierId);

}
