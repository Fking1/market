package club.fangqcloud.controller;

import club.fangqcloud.pojo.Good;
import club.fangqcloud.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/good")
public class GoodController {
    @Autowired
    private GoodService goodService;

    @RequestMapping("/getAll.do")
    @ResponseBody
    public List<Good> getAll() {
        return goodService.selectAll();
    }
}
