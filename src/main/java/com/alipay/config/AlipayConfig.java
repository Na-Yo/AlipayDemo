package com.alipay.config;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2016092100559272";
	// 私钥 pkcs8格式的
	public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCcezB/cOSpcAoKH7Od6AoN302yjglf8Y2I3mD16/oZ02mAaD4y6wCgMTSNHyILuxJYoaPaHx2PwBuC83aOuCqp6o2wTxAwXeG8AET+dJgC3BBXaJcXTidSxUFE45Girln/QaG2DRNnSsg3Jh6wxCA3OYCIMWgrUYi4QQP4wGrE9AJOiJmgCb+NPPt46xxIAyp8dCaHWBNKtKUSu3m1BOBNmLgZsO2+DGOhowNXCKsIqFvLUcrqL3QxdQmO2lGTeNl37T8uTYj5kb/MAdjJH4kmoyCQSOyEMhlJ8vVGl/AbOtCzJVacOVu/eM/XUpO+cR29cgXfqTgZlZtBeTVsBQeRAgMBAAECggEATgM4hYCh7zs1NiDh6mqBgLMASHF5iQSjHEZJrrELyg5VPbg6siXo9PQzD9winBiSp+9GAfubQEx1Ks74H2T/mCCgrPJtzr8vSAwWWYmFM3/FAd7Z3LuQ7Tn8NT0DIUitA44T8fAI6Wkl8iCmElhk+0NGqh9/oIEQmVOIiF5dnHyDo0tjzyilH+DZqdjeY9PRSLU8CzE9/XLEiTA3EjSfX4QOtnsmnreSPdbaVi4+glNAI7ZsS3TuwbxHfk4mCUZ+JScx6u1emFAO9yoCfbSfpcaqWGdke+md/X48QVB/zhSQQXM/Cny2uehiN2Mc+rez7+GLUknbRn7t/EODWUJEZQKBgQDtYQ44m5+zOZmYPfpXw8Uk2g+srpzbvmysoGQPMXJ6GyBrGoTAstOjYgurGA0aEJlH+5kjB73WVAHaiuGnc/BPwquxvCpB34toa8SQskQqQuN1cSpGAZ4/cZN0TGd+rLYqTpVuTzcrzd6wJJcKQkao5fVVMjWTmiNYGhY/aCPoxwKBgQCowZO9og4ji9Mjlk+EXTyoZiS5BsTQTkZvVqtgTygcJz0amrHgEluqPnBM6oG1JcV8Q1FTLdEaTnj+3xH+PR1vYGvovaa/oh4KaKuWpbsuSuGWDVf7SOLUqE1gBqIrmYfWFe6LjrVwjlA2mC8sk4xyQmcUO6zX0tW+BjFT9A4k5wKBgQDnmSrr1gJBNbCCle2bFVlSNCLY4uANkUOsRSx6mk7LjY3akVv2OkM8g9tIicW2qX0zeukVAWeZJgtM8vVokDhlSVSEq0Y7UORN898rIZJZ/Tq5Cbkp5khENAaekDDlqZJtwpAOuODmLwzWpExs6O7RuNLc1YjqQpe7THBqWqu2XwKBgC4MXF8jiE4kymFsk5gfxPyCmsSuVygsI8Yf1TW7g8ti3aaTzbPB7qde0E/8sZYXj3Lf/6H935AZF6Ucg5FnZc/NdMSWc5jZCO94LlI2OQRhxHqoe3iDI/o5TpvEU54oD8vYQjZso4/qFXNARacZP/qxqeT4f6qIynBGylEJSI7DAoGBAMctcyJV+AMBBjWGLkYN7COLEQdHROvisa1Wt167Ps8nlF6/Cwd8D5kbevGShYqjbKucoege6QVUXShMK7MjpONk6NL9z31nHjsO0R40wSme66qDpEwVJDHsYlCrpo9o6FLQbdZwny0vFsZxre8Gnralk23HcQFSnK/s5nJIoXxn";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
//	public static String return_url = "http://localhost:8080/wappay/return";
	public static String return_url = "http://www.baidu.com";
	// 请求网关地址
	public static String URL = "https://openapi.alipaydev.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAok9TxlR3JTx8P9+4IPr/kz8xGgE9ozsWny4wTSgDqfwZOYb3dFVAq8dkT5l+3LM7Jg8VXpxETgWKcqF0oJ0PBzc3TfbpuYDdp4tw8GBq+7PmnjU5AHIhy7+mKPdJfPqdqQTGtxMW0Tz//89w+by0zHvSD3zfZyD6qZk4lfWkbxD4ebVhJ6vmBitEVf46KSLnkA07O+YbhUU3uHhSCCj9JEbu3UCAGDVSsLl3gVIGvNdQ8y5rJWQYUGDalohWd4lMl5KVW79pzkRiwOO7Y6ChLxrIJXTdomFcVrdKod3onhvlBWZwQEX1sCyUuHfw4BeEHQEkgCiMtGRlVfnqzqlnBwIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA2";
}
