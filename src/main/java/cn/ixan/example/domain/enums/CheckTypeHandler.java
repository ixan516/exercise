package cn.ixan.example.domain.enums;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月22日, 0022
 */
public class CheckTypeHandler extends BaseTypeHandler<CheckType> {
	@Override
	public void setNonNullParameter(PreparedStatement ps, int index, CheckType parameter, JdbcType jdbcType) throws SQLException {
		ps.setInt(index,parameter.getKey());
	}

	@Override
	public CheckType getNullableResult(ResultSet rs, String index) throws SQLException {
		return CheckType.parse(rs.getInt(index));
	}

	@Override
	public CheckType getNullableResult(ResultSet rs, int index) throws SQLException {
		return CheckType.parse(rs.getInt(index));
	}

	@Override
	public CheckType getNullableResult(CallableStatement cs, int index) throws SQLException {
		return CheckType.parse(cs.getInt(index));
	}
}
