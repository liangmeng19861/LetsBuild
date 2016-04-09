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

		}
	}
}
