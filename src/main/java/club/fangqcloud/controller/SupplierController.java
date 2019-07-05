package club.fangqcloud.controller;

import club.fangqcloud.pojo.Supplier;
import club.fangqcloud.service.SupplierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value="suppliers.do")
    @ResponseBody
    public JSONObject users(Integer page, Integer page_size) {
        PageHelper.startPage(page, page_size);
        Supplier supplier = new Supplier();
        List<Supplier> supplierList = supplierService.select(supplier);
        PageInfo info = new  PageInfo(supplierList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "success");
        jsonObject.put("data", info);
        return jsonObject;
    }


    @RequestMapping(value="addSupplier.do")
    @ResponseBody
    public JSONObject addSupplier(Supplier supplier) {
        JSONObject jsonObject = new JSONObject();

        if(supplierService.insert(supplier)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "Insert Success");
            return jsonObject;
        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "Insert Fail");
        return jsonObject;
    }


    @RequestMapping(value="modifySupplier.do")
    @ResponseBody
    public JSONObject modifySupplier(Supplier supplier) {
        JSONObject jsonObject = new JSONObject();

        if(supplierService.update(supplier)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "Update Success");
            return jsonObject;
        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "Update Fail");
        return jsonObject;
    }


    @RequestMapping(value="getByName.do")
    @ResponseBody
    public JSONObject getByName(Integer page, Integer page_size, String supplierName) {
        System.out.println(supplierName);
        PageHelper.startPage(page, page_size);
        List<Supplier> supplierList = new ArrayList<>();
        if(supplierName == null || supplierName == "") {
            Supplier supplier = new Supplier();
            supplierList = supplierService.select(supplier);
        }else{
            supplierList = supplierService.selectByName(supplierName);
        }

        PageInfo info = new  PageInfo(supplierList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "success");
        jsonObject.put("data", info);
        return jsonObject;
    }


    @RequestMapping("removeSupplier.do")
    @ResponseBody
    public JSONObject removeSupplier(Integer supplierId) {
        JSONObject jsonObject = new JSONObject();
        if(supplierService.deleteBySupplierId(supplierId)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "delete success");
            return jsonObject;
        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "delete fail");
        return jsonObject;
    }
}
