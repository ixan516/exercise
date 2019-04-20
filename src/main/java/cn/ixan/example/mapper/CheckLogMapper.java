package cn.ixan.example.mapper;

import cn.ixan.example.domain.CheckLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月21日, 0021
 */
@Repository
public interface CheckLogMapper {
	List<CheckLog> selectAll();
}
