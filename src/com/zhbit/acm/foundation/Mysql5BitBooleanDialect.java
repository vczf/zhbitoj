package com.zhbit.acm.foundation;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * Created by Cyril on 16/6/15.
 */
public class Mysql5BitBooleanDialect extends MySQL5Dialect {
    public Mysql5BitBooleanDialect() {
        super();
        registerColumnType( java.sql.Types.BOOLEAN, "bit" );
    }
}
