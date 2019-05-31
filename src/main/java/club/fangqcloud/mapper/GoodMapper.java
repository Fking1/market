package club.fangqcloud.mapper;

import club.fangqcloud.pojo.Good;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GoodMapper {
    List<Good> selectAll();

    List<Good> select(Good good);
}
