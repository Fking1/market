package club.fangqcloud.controller;

import club.fangqcloud.pojo.Product;
import club.fangqcloud.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value="getProduct.do")
    @ResponseBody
    public JSONObject users(Integer page, Integer page_size) {
        PageHelper.startPage(page, page_size);
        Product product = new Product();
        List<Product> productList = productService.select(product);
        PageInfo info = new  PageInfo(productList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "success");
        jsonObject.put("data", info);
        return jsonObject;
    }


    @RequestMapping(value="addProduct.do")
    @ResponseBody
    public JSONObject addProduct(Product product) {
        JSONObject jsonObject = new JSONObject();

        if(productService.insert(product)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "Insert Success");
            return jsonObject;
        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "Insert Fail");
        return jsonObject;
    }


    @RequestMapping(value="modifyProduct.do")
    @ResponseBody
    public JSONObject modifyProduct(Product product) {
        JSONObject jsonObject = new JSONObject();

        if(productService.update(product)) {
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
    public JSONObject getByName(Integer page, Integer page_size, String productName) {
        PageHelper.startPage(page, page_size);
        List<Product> productList = new ArrayList<>();
        if(productName == null || productName == "") {
            Product product = new Product();
            productList = productService.select(product);
        }else{
            productList = productService.selectByName(productName);
        }

        PageInfo info = new  PageInfo(productList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "success");
        jsonObject.put("data", info);
        return jsonObject;
    }


    @RequestMapping("removeProduct.do")
    @ResponseBody
    public JSONObject removeProduct(Integer productId) {
        JSONObject jsonObject = new JSONObject();
        if(productService.deleteById(productId)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "delete success");
            return jsonObject;
        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "delete fail");
        return jsonObject;
    }
}
