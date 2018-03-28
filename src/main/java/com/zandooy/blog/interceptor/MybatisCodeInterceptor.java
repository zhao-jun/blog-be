package com.zandooy.blog.interceptor;

import com.zandooy.blog.utils.GenerateCodeUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Properties;

//Executor (update, query, flushStatements, commit, rollback, getTransaction, close, isClosed)

@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class}
)})
@Component
public class MybatisCodeInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            if (arg instanceof MappedStatement) {
                MappedStatement ms = (MappedStatement) arg;
                SqlCommandType sqlCommandType = ms.getSqlCommandType();
                if (sqlCommandType == SqlCommandType.INSERT) {// 如果是“增加”或“更新”操作，则继续进行默认操作信息赋值。否则，则退出
                    continue;
                } else {
                    break;
                }
            }
            // 第二个参数处理。（只有第二个程序才能跑到这）
            if (arg instanceof Map) {// 如果是map，有两种情况：（1）使用@Param多参数传入，由Mybatis包装成map。（2）原始传入Map
                Map map = (Map) arg;
                for (Object obj : map.values()) {
                    setProperty(obj);
                }
            } else {// 原始参数传入
                setProperty(arg);
            }
        }
        return invocation.proceed();
    }

    public void setProperty (Object obj) {
        try {
            if (obj instanceof List) {
                List objs = (List) obj;
                for (Object o : objs) {
                    if (StringUtils.isNotBlank(BeanUtils.getProperty(o, "code"))) {
                        continue;       // code存在的时候跳过
                    }
                    BeanUtils.setProperty(o, "code", GenerateCodeUtil.generateCode());
                }
            } else {
                if (StringUtils.isNotBlank(BeanUtils.getProperty(obj, "code"))) {
                    return;       // code存在的时候返回
                }
                BeanUtils.setProperty(obj, "code", GenerateCodeUtil.generateCode());
            }
        } catch (Exception e) {
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }
}
