package org.ssssssss.magicapi.dialect;


import org.ssssssss.magicapi.modules.BoundSql;
import org.ssssssss.magicapi.utils.CountSqlParser;

public class MySQLDialect implements Dialect {

	@Override
	public boolean match(String jdbcUrl) {
		return jdbcUrl.contains(":mysql:") || jdbcUrl.contains(":mariadb:") || jdbcUrl.contains(":cobar:");
	}

	@Override
	public String getPageSql(String sql, BoundSql boundSql, long offset, long limit) {
		boundSql.addParameter(offset);
		boundSql.addParameter(limit);
		return sql + " limit ?,?";
	}
	@Override
	public String getCountSql(String sql) {
		CountSqlParser countSqlParser = new CountSqlParser();
		return countSqlParser.getSmartCountSql(sql);
		//return "select count(1) from (" + sql + ") count_";
	}
}
