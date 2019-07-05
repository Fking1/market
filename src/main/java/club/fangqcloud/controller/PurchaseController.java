package club.fangqcloud.controller;

import club.fangqcloud.pojo.Purchase;
import club.fangqcloud.service.PurchaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value="getPurchase.do")
    @ResponseBody
    public JSONObject purchases(Integer page, Integer page_size) {
        PageHelper.startPage(page, page_size);
        Purchase purchase = new Purchase();
        List<Map> purchaseList = purchaseService.select(purchase);
        PageInfo info = new  PageInfo(purchaseList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "success");
        jsonObject.put("data", info);
        return jsonObject;
    }


    @RequestMapping(value="addPurchase.do")
    @ResponseBody
    public JSONObject addPurchase(Purchase purchase) {
        JSONObject jsonObject = new JSONObject();

        if(purchaseService.insert(purchase)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "Insert Success");
            return jsonObject;
        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "Insert Fail");
        return jsonObject;
    }


    @RequestMapping(value="modifyPurchase.do")
    @ResponseBody
    public JSONObject modifyPurchase(Purchase purchase) {
        JSONObject jsonObject = new JSONObject();

        if(purchaseService.update(purchase)) {
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
    public JSONObject getByName(Integer page, Integer page_size, String purchaser) {
        PageHelper.startPage(page, page_size);
        List<Map> purchaseList = new ArrayList<>();
        if(purchaser == null || purchaser == "") {
            Purchase purchase = new Purchase();
            purchaseList = purchaseService.select(purchase);
        }else{
            purchaseList = purchaseService.selectByName(purchaser);
        }

        PageInfo info = new  PageInfo(purchaseList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "success");
        jsonObject.put("data", info);
        return jsonObject;
    }


    @RequestMapping("removePurchase.do")
    @ResponseBody
    public JSONObject removePurchase(Integer purchaseId) {
        JSONObject jsonObject = new JSONObject();
        if(purchaseService.deleteById(purchaseId)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "delete success");
            return jsonObject;
        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "delete fail");
        return jsonObject;
    }
}
