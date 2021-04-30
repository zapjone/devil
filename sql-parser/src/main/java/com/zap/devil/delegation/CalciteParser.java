package com.zap.devil.delegation;

import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;

/**
 * @author zhangap
 * @version 1.0, 2021/4/30
 */
public class CalciteParser {

    private final SqlParser.Config config;

    public CalciteParser(SqlParser.Config config) {
        this.config = config;
    }

    public SqlNode parse(String sql) {
        try {
            SqlParser parser = SqlParser.create(sql, config);
            return parser.parseStmt();
        } catch (SqlParseException e) {
            throw new RuntimeException("SQL parse failed. " + e.getMessage(), e);
        }
    }

}
