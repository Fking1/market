package club.fangqcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import club.fangqcloud.pojo.Supplier;

import club.fangqcloud.mapper.SupplierMapper;
@Service
public class SupplierServiceImpl implements club.fangqcloud.service.SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public List<Supplier> select(Supplier supplier) {
        return supplierMapper.select(supplier);
    }

    @Override
    public Boolean insert(Supplier supplier) {
        if(supplierMapper.insert(supplier)>0) {
            return true;
        }

        return false;
    }

    @Override
    public Boolean update(Supplier supplier) {
        if(supplierMapper.update(supplier)>0) {
            return true;
        }

        return false;
    }


    @Override
    public List<Supplier> selectByName(String supplierName) {
        return supplierMapper.selectByName(supplierName);
    }


    @Override
    public Boolean deleteBySupplierId(Integer supplierId) {
        if(supplierMapper.deleteBySupplierId(supplierId)>0) {
            return true;
        }

        return false;
    }
}
