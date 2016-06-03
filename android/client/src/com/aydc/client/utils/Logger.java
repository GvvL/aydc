package com.aydc.client.utils;

import java.util.Locale;

import android.util.Log;

public class Logger {
	private static boolean LOGV = true;
	private static boolean LOGD = true;
	private static boolean LOGI = true;
	private static boolean LOGW = true;
	private static boolean LOGE = true;
	public static void v(String tag, String mess) {
		if (LOGV) {
			Log.v(tag, mess);
		}
	}

	public static void d(String tag, String mess) {
		if (LOGD) {
			Log.d(tag, mess);
		}
	}

	public static void i(String tag, String mess) {
		if (LOGI) {
			Log.i(tag, mess);
		}
	}

	public static void w(String tag, String mess) {
		if (LOGW) {
			Log.w(tag, mess);
		}
	}

	public static void e(String tag, String mess) {
		if (LOGE) {
			Log.e(tag, mess);
		}
	}

	private static String getTag() {
		StackTraceElement[] trace = new Throwable().fillInStackTrace()
				.getStackTrace();
		String callingClass = "";
		for (int i = 2; i < trace.length; i++) {
			Class<?> clazz = trace[i].getClass();
			if (!clazz.equals(Logger.class)) {
				callingClass = trace[i].getClassName();
				callingClass = callingClass.substring(callingClass
						.lastIndexOf('.') + 1);
				break;
			}
		}
		return callingClass;
	}

	public static void v(String mess) {
		if (LOGV) {
			Log.v(getTag(), mess);
		}
	}

	public static void d(String mess) {
		if (LOGD) {
			Log.d(getTag(), mess);
		}
	}

	public static void i(String mess) {
		if (LOGI) {
			Log.i(getTag(), mess);
		}
	}

	public static void w(String mess) {
		if (LOGW) {
			Log.w(getTag(), mess);
		}
	}

	public static void e(String mess) {
		if (LOGE) {
			Log.e(getTag(), mess);
		}
	}

	private static String buildMessage(String msg) {
		StackTraceElement[] trace = new Throwable().fillInStackTrace()
				.getStackTrace();
		String caller = "";
		for (int i = 2; i < trace.length; i++) {
			Class<?> clazz = trace[i].getClass();
			if (!clazz.equals(Logger.class)) {
				caller = trace[i].getMethodName();
				break;
			}
		}
		return String.format(Locale.US, "[%d] %s: %s", Thread.currentThread()
				.getId(), caller, msg);
	}

	public static void vv(String mess) {
		if (LOGV) {
			Log.v(getTag(), buildMessage(mess));
		}
	}

	public static void dd(String mess) {
		if (LOGD) {
			Log.d(getTag(), buildMessage(mess));
		}
	}

	public static void ii(String mess) {
		if (LOGI) {
			Log.i(getTag(), buildMessage(mess));
		}
	}

	public static void ww(String mess) {
		if (LOGW) {
			Log.w(getTag(), buildMessage(mess));
		}
	}

	public static void ee(String mess) {
		if (LOGE) {
			Log.e(getTag(), buildMessage(mess));
		}
	}

}
