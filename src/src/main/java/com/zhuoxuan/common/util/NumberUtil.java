package com.zhuoxuan.common.util;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * 格式化数字的工具类
 * 
 * @author Gao Jiangtao
 * 
 */
public class NumberUtil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param d
	 * @return
	 */
	public static String formatHardNumberTwo(double d) {
		DecimalFormat df = new DecimalFormat("#.00");
		df.setGroupingUsed(false);
		return df.format(d);
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public static String formatHardNumberFour(double d) {
		DecimalFormat df = new DecimalFormat("#.0000");
		df.setGroupingUsed(false);
		return df.format(d);
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public static String formatLocalNumberTwo(double d) {
		return formatLocalByPattern(d, "#.00");
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public static String formatLocalNumberFour(double d) {
		return formatLocalByPattern(d, "#.0000");
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public static String formatNumberTwo(double d) {
		return formatByPattern(d, "#.00");
	}

	/**
	 * 
	 * @param d
	 * @return
	 */
	public static String formatNumberFour(double d) {
		return formatByPattern(d, "#.0000");
	}

	/**
	 * 根据本地区域要求格式化金额
	 * 
	 * @param d
	 * @return
	 */
	public static String formatCurrency(double d) {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		return currencyFormat.format(d);
	}

	/**
	 * 自定义格式化金额
	 * 
	 * @param d
	 * @return
	 */
	public static String formatDecimal(double d) {
		DecimalFormat decimalFormat = new DecimalFormat();
		decimalFormat.setDecimalSeparatorAlwaysShown(true);
		decimalFormat.setMaximumFractionDigits(2);
		decimalFormat.setMinimumFractionDigits(2);
		return decimalFormat.format(d);
	}

	/**
	 * 根据本地区域要求格式化数字
	 * 
	 * @param d
	 * @return
	 */
	public static String formatNumber(double d) {
		NumberFormat currencyFormat = NumberFormat.getNumberInstance();
		return currencyFormat.format(d);
	}

	/**
	 * 根据本地区域要求格式化百分数
	 * 
	 * @param d
	 * @return
	 */
	public static String formatPercent(double d) {
		NumberFormat currencyFormat = NumberFormat.getPercentInstance();
		return currencyFormat.format(d);
	}

	/**
	 * 控制指数形式的格式
	 * 
	 * @return
	 */
	public static String formatENumberByPattern(double d, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(d);
		// eg. pattern = "0.000E0000" ; d = "1234.56"; return = "1.235E0003"
	}

	/**
	 * 
	 * @param d
	 * @param pattern
	 * @return
	 */
	public static String formatByPattern(double d, String pattern) {
		DecimalFormat df = new DecimalFormat(pattern);
		return df.format(d);
		// DecimalFormat df =
		// (DecimalFormat)NumberFormat.getInstance(Locale.GERMAN);
		// df.applyPattern("####.00000");
	}

	/**
	 * 
	 * @return
	 */
	public static String formatLocalByPattern(double d, String pattern) {
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		df.applyPattern(pattern);
		return df.format(d);
	}

	/**
	 * 读取并解析包含格式化的数字的字符串
	 * 
	 * @param number
	 * @return
	 */
	public static Number parseNumber(String number) {
		try {
			NumberFormat nf = NumberFormat.getInstance();
			return nf.parse(number);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @param temp
	 * @param lens
	 * @return
	 */
	private static double getRoundDouble(double numerical, int length) {
		DecimalFormat decimalFormat = null;
		if (length == 4) {
			decimalFormat = new java.text.DecimalFormat("###.####");
		} else if (length == 3) {
			decimalFormat = new java.text.DecimalFormat("########.###");
		} else if (length == 2) {
			decimalFormat = new java.text.DecimalFormat("########.##");
		} else if (length == 1) {
			decimalFormat = new java.text.DecimalFormat("########.#");
		} else if (length == 0) {
			decimalFormat = new java.text.DecimalFormat("#####,###");
		}
		return Double.parseDouble(decimalFormat.format(numerical).toString());
	}

	public static double getRoundDoubleTwo(double numerical) {
		return getRoundDouble(numerical, 2);
	}

	public static double getRoundDoubleThree(double numerical) {
		return getRoundDouble(numerical, 3);
	}

	public static double getRoundDoubleFour(double numerical) {
		return getRoundDouble(numerical, 4);
	}

	private static String getRoundString(double numerical, int length) {
		DecimalFormat decimalFormat = null;
		if (length == 4) {
			decimalFormat = new java.text.DecimalFormat("###.####");
		} else if (length == 3) {
			decimalFormat = new java.text.DecimalFormat("##,###,###.###");
		} else if (length == 2) {
			decimalFormat = new java.text.DecimalFormat("##,###,###.##");
		} else if (length == 1) {
			decimalFormat = new java.text.DecimalFormat("##,###,###.#");
		} else if (length == 0) {
			decimalFormat = new java.text.DecimalFormat("##,###,###");
		}
		return decimalFormat.format(numerical).toString();
	}

	public static String getRoundStringTwo(double numerical) {
		return getRoundString(numerical, 2);
	}
}
