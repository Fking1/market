package club.fangqcloud.service.impl;

import club.fangqcloud.mapper.GoodMapper;
import club.fangqcloud.pojo.Good;
import club.fangqcloud.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<Good> selectAll() {
        return goodMapper.selectAll();
    }
}
