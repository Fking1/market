package club.fangqcloud.controller;

import club.fangqcloud.pojo.Sell;
import club.fangqcloud.service.SellService;
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
@RequestMapping("/sell")
public class SellController {
    @Autowired
    private SellService sellService;

    @RequestMapping(value="getSell.do")
    @ResponseBody
    public JSONObject sells(Integer page, Integer page_size) {
        PageHelper.startPage(page, page_size);
        Sell sell = new Sell();
        List<Map> sellList = sellService.select(sell);
        PageInfo info = new  PageInfo(sellList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "success");
        jsonObject.put("data", info);
        return jsonObject;
    }


    @RequestMapping(value="addSell.do")
    @ResponseBody
    public JSONObject addSell(Sell sell) {
        JSONObject jsonObject = new JSONObject();

        if(sellService.insert(sell)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "Insert Success");
            return jsonObject;
        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "Insert Fail");
        return jsonObject;
    }


    @RequestMapping(value="modifySell.do")
    @ResponseBody
    public JSONObject modifySell(Sell sell) {
        JSONObject jsonObject = new JSONObject();

        if(sellService.update(sell)) {
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
    public JSONObject getByName(Integer page, Integer page_size, String seller) {
        PageHelper.startPage(page, page_size);
        List<Map> sellList = new ArrayList<>();
        if(seller == null || seller == "") {
            Sell sell = new Sell();
            sellList = sellService.select(sell);
        }else{
            sellList = sellService.selectByName(seller);
        }

        PageInfo info = new  PageInfo(sellList);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "success");
        jsonObject.put("data", info);
        return jsonObject;
    }


    @RequestMapping("removeSell.do")
    @ResponseBody
    public JSONObject removeSell(Integer sellId) {
        JSONObject jsonObject = new JSONObject();
        if(sellService.deleteById(sellId)) {
            jsonObject.put("status", 0);
            jsonObject.put("msg", "delete success");
            return jsonObject;
        }

        jsonObject.put("status", -1);
        jsonObject.put("msg", "delete fail");
        return jsonObject;
    }
}
