package com.zandooy.blog.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseAspect {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
