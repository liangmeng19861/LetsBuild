package com.letsbuild.util;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.letsbuild.base.util.SeqUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/application.xml" })
public class SeqUtilTest extends TestCase {

    @Test
    public void testGetSeq() {
        SeqUtil.getNewOrderId();
    }
}
