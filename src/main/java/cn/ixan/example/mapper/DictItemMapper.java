package cn.ixan.example.mapper;

import cn.ixan.example.domain.DictItem;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月31日, 0031
 */
@Repository
public interface DictItemMapper extends Mapper<DictItem> {
}
