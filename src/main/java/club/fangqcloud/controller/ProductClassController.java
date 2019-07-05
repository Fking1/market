package club.fangqcloud.controller;

import club.fangqcloud.pojo.ProductClass;
import club.fangqcloud.service.ProductClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product-class")
public class ProductClassController {
    @Autowired
    private ProductClassService productClassService;

    @RequestMapping(value="getProductClass.do")
    @ResponseBody
    public JSONObject users(Integer page, Integer page_size) {
        PageHelper.startPage(page, page_size);
        ProductClass productClass = new ProductClass();
        List<ProductClass> productClassList = productClassService.select(productClass);
        PageInfo info = new  PageInfo(productClassList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "success");
        jsonObject.put("data", info);
        return jsonObject;
    }


    @RequestMapping(value="addProductClass.do")
    @ResponseBody
    public JSONObject addProductClass(ProductClass productClass) {
        JSONObject jsonObject = new JSONObject();

        if(productClassService.insert(productClass)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "Insert Success");
            return jsonObject;
        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "Insert Fail");
        return jsonObject;
    }


    @RequestMapping(value="modifyProductClass.do")
    @ResponseBody
    public JSONObject modifyProductClass(ProductClass productClass) {
        JSONObject jsonObject = new JSONObject();

        if(productClassService.update(productClass)) {
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
    public JSONObject getByName(Integer page, Integer page_size, String className) {
        PageHelper.startPage(page, page_size);
        List<ProductClass> productClassList = new ArrayList<>();
        if(className == null || className == "") {
            ProductClass productClass = new ProductClass();
            productClassList = productClassService.select(productClass);
        }else{
            productClassList = productClassService.selectByName(className);
        }

        PageInfo info = new  PageInfo(productClassList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "success");
        jsonObject.put("data", info);
        return jsonObject;
    }


    @RequestMapping("removeProductClass.do")
    @ResponseBody
    public JSONObject removeProductClass(Integer classId) {
        JSONObject jsonObject = new JSONObject();
        if(productClassService.deleteById(classId)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "delete success");
            return jsonObject;
        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "delete fail");
        return jsonObject;
    }
}
