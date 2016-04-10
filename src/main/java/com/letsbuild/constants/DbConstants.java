package com.letsbuild.constants;

public final class DbConstants {
    /**
     * 订单表
     */
    public final static class OrdOrder {
        /**
         * 状态
         */
        public static final class Status {
            /**
             * 接单立项
             */
            public static String RECEIVE = "1";

            /**
             * 订单报价
             */
            public static String QUOTES = "2";

            /**
             * 订单报价
             */
            public static String SUBMIT = "3";

            /**
             * 订单验收
             */
            public static String ACCEPTANCE = "4";

            /**
             * 开具发票
             */
            public static String INVOICE = "5";

            /**
             * 回款到账
             */
            public static String INCOME = "6";

        }
    }

    /**
     * 押金表
     */
    public final static class OrdForegift {
        /**
         * 状态
         */
        public final static class Status {
            /**
             * 申请
             */
            public final static String APPLY = "1";

            /**
             * 付款
             */
            public final static String PAY = "2";

            /**
             * 退回
             */
            public final static String REFUND = "3";
        }
    }
}
