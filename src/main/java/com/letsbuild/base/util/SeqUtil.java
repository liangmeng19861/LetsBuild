package com.letsbuild.base.util;

import com.letsbuild.dao.mapper.factory.MapperFactory;

public class SeqUtil {
    private static String ORD_ORDER_ID = "ORD_ORDER_ID";

    private static String ORD_STAGE_ID = "ORD_STAGE_ID";

    private static String ORD_FOREGIFT_ID = "ORD_FOREGIFT_ID";

    private static String ORD_ADVPAY_ID = "ORD_ADVPAY_ID";

    private static Long getSeqNextval(String seqCode) {
        return MapperFactory.getCustomMapper().getSeqNextval(seqCode);
    }

    public static Long getNewOrderId() {
        return SeqUtil.getSeqNextval(ORD_ORDER_ID);
    }

    public static Long getNewStageId() {
        return SeqUtil.getSeqNextval(ORD_STAGE_ID);
    }

    public static Long getNewForegiftId() {
        return SeqUtil.getSeqNextval(ORD_FOREGIFT_ID);
    }

    public static Long getNewAdvpayId() {
        return SeqUtil.getSeqNextval(ORD_ADVPAY_ID);
    }
}
