package com.qizhu.util;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

public class ColorUtil {

	public static void main(String[] args) {
		String tab[] = { "樱桃红,大红", "草绿,深绿", "樱桃红,玫红", "玫红,樱桃红", "橘黄,柠檬黄",
				"雪白,本白", "樱桃红,胭脂红", "大红,胭脂红", "玫红,胭脂红", "玫红,大红", "黑色", "乳白,雪白",
				"樱桃红,大红", "乳白,雪白", "雪白,银白", "黑色", "银白,乳白", "黑色", "白色，黑色，红色",
				"大红,胭脂红", "藏青,靛蓝", "草绿,深绿", "黑色", "樱桃红,胭脂红", "黑色", "藏青,靛蓝",
				"荧光绿,孔雀绿", "深蓝,靛蓝", "樱桃红,胭脂红", "深绿,孔雀绿", "黑色", "草绿,孔雀绿",
				"藏青,水粉蓝", "樱桃红,玫红", "靛蓝,深蓝", "黑色", "孔雀绿,深绿", "黑色", "玫红,樱桃红",
				"黑色", "孔雀绿,荧光绿", "乳白,银白", "孔雀绿,荧光绿", "金色，白色", "银白,雪白",
				"孔雀绿,草绿", "白色，黑色，红色", "深绿,孔雀绿", "红色，白色，绿色", "樱桃红,胭脂红", "雪白,乳白",
				"黑色", "孔雀绿,荧光绿", "本白,银白", "本白,银白", "可带黄金", "孔雀绿,草绿", "雪白,银白",
				"银白,雪白", "荧光绿,孔雀绿", "随便穿", "柠檬黄,橙色", "荧光绿,草绿", "黑色", "银灰,浅灰",
				"黑色", "黑色", "孔雀绿,深绿", "浅黄,柠檬黄", "荧光绿,草绿", "柠檬黄,橙色", "深绿,草绿",
				"深绿,草绿", "黑色", "大红,樱桃红", "黑色", "黑色，绿色", "银白,乳白", "大红,玫红", "黑色",
				"柠檬黄,浅黄", "橙色,橘黄", "孔雀绿,草绿", "柠檬黄,橘黄", "黑色", "橙色,柠檬黄", "橘黄,橙色",
				"乳白,本白", "孔雀绿,草绿", "藏青,靛蓝", "水晶", "浅黄,柠檬黄", "深绿,草绿", "浅黄,柠檬黄",
				"黑色", "可带宝石，水晶", "柠檬黄,浅黄", "本白,银白", "深绿,孔雀绿", "黑色", "藏青,深蓝",
				"本白,银白", "胭脂红,大红", "银白,雪白", "白色，水晶", "黑色", "金色", "黑色",
				"金色，黑色，红色", "玫红,大红", "大红,胭脂红", "草绿,荧光绿", "玫红,胭脂红", "大红,玫红",
				"灰色，黄色", "金色", "胭脂红,大红", "樱桃红,大红", "本白,银白", "樱桃红,大红", "草绿,荧光绿",
				"橘黄,橙色", "深绿,草绿", "银白,雪白", "荧光绿,深绿", "乳白,雪白", "水晶，棕色",
				"荧光绿,深绿", "金色", "深绿,孔雀绿", "乳白,银白", "黑色", "孔雀绿,草绿", "本白,雪白",
				"银白,乳白", "浅黄,橙色", "孔雀绿,荧光绿", "乳白,本白", "乳白,本白", "草绿,荧光绿", "黑色",
				"乳白,银白", "胭脂红,玫红", "金色，白色", "本白,银白", "黑色", "银白,雪白", "黑色",
				"白色，黑色，红色", "大红,樱桃红", "藏青,水粉蓝", "本白,乳白", "胭脂红,大红", "本白,雪白",
				"雪白,本白", "水粉蓝,深蓝", "金色", "黑色", "白色，黑色，红色", "樱桃红,胭脂红", "柠檬黄,浅黄",
				"荧光绿,深绿", "孔雀绿,荧光绿", "樱桃红,胭脂红", "红色，粉红色", "橘黄,浅黄", "黑色，绿色",
				"乳白,本白", "胭脂红,大红", "黑色", "随便穿", "橘黄,浅黄", "孔雀绿,深绿", "深蓝,水粉蓝",
				"黄色，灰色", "黑色", "黑色", "荧光绿,深绿", "橘黄,柠檬黄", "孔雀绿,荧光绿", "荧光绿,深绿",
				"橘黄,柠檬黄", "孔雀绿,深绿", "本白,雪白", "草绿,深绿", "孔雀绿,草绿", "橘黄,橙色",
				"孔雀绿,深绿", "银白,乳白", "深绿,草绿", "黑色", "玫红,大红", "银白,乳白", "本白,银白",
				"玫红,胭脂红", "银白,雪白", "乳白,本白", "草绿,荧光绿", "金色，黑色，红色", "大红,玫红",
				"黑色", "橘黄,浅黄", "黑色", "浅黄,橙色", "黄色，灰色，咖啡色", "黑色", "柠檬黄,橙色",
				"黑色", "黑色", "胭脂红,大红", "藏青,深蓝", "橘黄,橙色", "藏青,水粉蓝", "浅黄,柠檬黄",
				"深灰,铅笔灰", "靛蓝,水粉蓝", "土色", "深蓝,藏青", "靛蓝,水粉蓝", "玫红,胭脂红", "银白,乳白",
				"藏青,靛蓝", "草绿,荧光绿", "本白,银白", "银白,雪白", "柠檬黄,橘黄", "草绿,深绿",
				"本白,雪白", "雪白,银白", "孔雀绿,荧光绿", "深绿,孔雀绿", "浅黄,柠檬黄", "草绿,孔雀绿",
				"银白,雪白", "荧光绿,深绿", "草绿,孔雀绿", "水晶，宝石", "金色", "本白,雪白", "孔雀绿,荧光绿",
				"深绿,草绿", "樱桃红,大红", "本白,雪白", "本白,乳白", "大红,胭脂红", "金色", "本白,银白",
				"草绿,荧光绿", "白色，绿色", "樱桃红,胭脂红", "黑色", "雪白,银白", "草绿,孔雀绿", "雪白,银白",
				"本白,银白", "草绿,荧光绿", "白色，黑色，红色", "孔雀绿,深绿", "红色，白色，绿色", "玫红,樱桃红",
				"深蓝,藏青", "柠檬黄,浅黄", "黑色", "酱色", "柠檬黄,橙色", "黑色", "橘黄,浅黄",
				"樱桃红,大红", "黑色", "胭脂红,大红", "黑色", "橙色,柠檬黄", "靛蓝,深蓝", "黄金色,浅咖",
				"浅灰,银灰", "藏青,靛蓝", "水晶", "深蓝,靛蓝", "黑色", "大红,胭脂红", "草绿,荧光绿",
				"玫红,樱桃红", "雪白,银白", "金色，白色", "樱桃红,胭脂红", "本白,雪白", "雪白,银白",
				"孔雀绿,草绿", "白色，绿色", "玫红,胭脂红", "孔雀绿,荧光绿", "橘黄,浅黄", "荧光绿,孔雀绿",
				"乳白,银白", "草绿,深绿", "草绿,深绿", "柠檬黄,橙色", "荧光绿,草绿", "乳白,银白", "黑色",
				"黑色", "孔雀绿,深绿", "水粉蓝,藏青", "胭脂红,大红", "靛蓝,藏青", "靛蓝,水粉蓝", "深绿,草绿",
				"黑色", "玫红,大红", "黑色", "藏青,水粉蓝", "雪白,乳白", "樱桃红,玫红", "雪白,银白",
				"雪白,本白", "黑色", "雪白,乳白", "靛蓝,水粉蓝", "金色，蓝色，红色", "樱桃红,胭脂红", "随便穿",
				"橙色,柠檬黄", "孔雀绿,深绿", "黑色，蓝色", "柠檬黄,浅黄", "黑色", "黑色", "荧光绿,深绿",
				"柠檬黄,橘黄", "荧光绿,草绿", "随便穿", "橙色,浅黄", "草绿,孔雀绿", "乳白,雪白",
				"橘黄,柠檬黄", "藏青,水粉蓝", "藏青,深蓝", "草绿,深绿", "柠檬黄,橘黄", "孔雀绿,草绿",
				"孔雀绿,深绿", "乳白,银白", "荧光绿,深绿", "金色，白色", "本白,银白", "孔雀绿,草绿",
				"白色，黑色，红色", "孔雀绿,荧光绿", "红色，白色，绿色", "大红,玫红", "深绿,孔雀绿", "银白,乳白",
				"胭脂红,玫红", "金色，白色", "大红,玫红", "金色", "雪白,银白", "孔雀绿,荧光绿", "白色，绿色",
				"胭脂红,玫红", "黑色", "浅黄,橙色", "深绿,孔雀绿", "柠檬黄,橘黄", "黑色", "橘黄,浅黄",
				"橙色,柠檬黄", "本白,雪白", "荧光绿,深绿", "黑色", "浅黄,橙色", "荧光绿,孔雀绿",
				"深绿,孔雀绿", "大红,玫红", "胭脂红,大红", "黑色", "黑色，绿色", "银白,雪白", "大红,胭脂红",
				"黑色", "樱桃红,大红", "孔雀绿,深绿", "樱桃红,玫红", "玫红,胭脂红", "橘黄,浅黄", "乳白,雪白",
				"樱桃红,玫红", "草绿,深绿", "银白,乳白", "大红,胭脂红", "樱桃红,玫红", "荧光绿,草绿",
				"樱桃红,大红", "胭脂红,玫红", "橙色,浅黄", "银白,雪白", "大红,樱桃红", "草绿,孔雀绿",
				"本白,雪白", "樱桃红,玫红", "黑色", "本白,乳白", "大红,胭脂红", "金色，白色", "白色，金色",
				"深蓝,靛蓝", "雪白,银白", "黑色", "金色，黑色，红色", "樱桃红,胭脂红", "水粉蓝,藏青",
				"荧光绿,孔雀绿", "靛蓝,藏青", "大红,樱桃红", "黑色", "黑色", "孔雀绿,草绿", "藏青,靛蓝",
				"玫红,大红", "黑色", "荧光绿,孔雀绿", "柠檬黄,橘黄", "橙色,柠檬黄", "黑色", "柠檬黄,橘黄",
				"藏青,深蓝", "白色，黑色", "孔雀绿,深绿", "黑色", "孔雀绿,荧光绿", "乳白,本白", "黑色",
				"荧光绿,草绿", "本白,雪白", "本白,乳白", "带水晶", "荧光绿,草绿", "雪白,乳白", "乳白,雪白",
				"孔雀绿,荧光绿", "柠檬黄,橙色", "荧光绿,深绿", "孔雀绿,荧光绿", "大红,樱桃红", "玫红,胭脂红",
				"黑色", "黑色，绿色", "雪白,本白", "大红,胭脂红", "黑色", "橙色,橘黄", "草绿,荧光绿",
				"荧光绿,孔雀绿", "玫红,大红", "樱桃红,玫红", "黑色", "黑色，绿色", "本白,雪白", "玫红,胭脂红",
				"藏青,深蓝", "橙色,浅黄", "深绿,草绿", "荧光绿,孔雀绿", "胭脂红,玫红", "樱桃红,大红",
				"藏青,靛蓝", "黑色，绿色", "本白,乳白", "樱桃红,玫红", "水粉蓝,深蓝", "浅黄,柠檬黄",
				"橙色,橘黄", "深绿,孔雀绿", "浅黄,橙色", "靛蓝,水粉蓝", "黄色，棕色", "浅黄,橙色",
				"雪白,本白", "深绿,草绿", "黑色", "蓝色，白色", "柠檬黄,橘黄", "柠檬黄,橘黄", "金色，白色",
				"橘黄,橙色", "草绿,孔雀绿", "本白,银白", "深绿,孔雀绿", "白色，绿色", "红色，黄色",
				"草绿,荧光绿", "大红,玫红", "乳白,银白", "金色，白色", "玫红,樱桃红", "雪白,银白",
				"雪白,乳白", "黑色", "白色，绿色", "玫红,胭脂红", "红色，绿色", "白色，黄色", "黑色",
				"雪白,本白", "雪白,乳白", "黑色", "本白,雪白", "大红,胭脂红", "黑色", "大红,玫红",
				"大红,胭脂红", "橘黄,浅黄", "樱桃红,胭脂红", "银白,乳白", "白色，金色", "藏青,深蓝",
				"本白,银白", "玫红,胭脂红", "靛蓝,深蓝", "玫红,胭脂红", "银白,雪白", "黑色", "深绿,草绿",
				"乳白,雪白", "雪白,本白", "黄色，彩色", "深绿,草绿", "雪白,银白", "本白,乳白", "孔雀绿,草绿",
				"草绿,荧光绿", "浅黄,柠檬黄", "橘黄,浅黄", "黑色", "橘黄,柠檬黄", "藏青,靛蓝", "白色，黑色",
				"孔雀绿,深绿", "黑色", "深绿,孔雀绿", "雪白,乳白", "黑色", "深绿,孔雀绿", "雪白,本白",
				"雪白,本白", "柠檬黄,橙色", "草绿,孔雀绿", "银色", "金色", "荧光绿,草绿", "孔雀绿,草绿",
				"本白,乳白", "孔雀绿,深绿", "乳白,本白", "雪白,本白", "深绿,草绿", "白色，黑色，红色",
				"孔雀绿,草绿", "藏青,靛蓝", "胭脂红,玫红", "黑色，红色", "柠檬黄,浅黄", "玫红,樱桃红", "黑色",
				"柠檬黄,橙色", "藏青,水粉蓝", "绿色，红色", "大红,樱桃红", "绿色，黑色", "胭脂红,玫红",
				"樱桃红,玫红", "橙色,柠檬黄", "孔雀绿,草绿", "水粉蓝,藏青", "橙色,浅黄", "黑色", "绿色，红色",
				"大红,玫红", "绿色，黑色", "大红,玫红", "荧光绿,孔雀绿", "玫红,胭脂红", "乳白,雪白",
				"金色，白色", "大红,玫红", "银白,乳白", "本白,雪白", "深绿,孔雀绿", "白色，绿色",
				"樱桃红,胭脂红", "绿色，白色", "橙色,柠檬黄", "橘黄,柠檬黄", "本白,乳白", "柠檬黄,浅黄",
				"荧光绿,孔雀绿", "金色", "深绿,草绿", "白色，绿色", "柠檬黄,橘黄" };
		System.out.println(tab.length);
		// String color[] = { "乳白", "雪白", "本白", "银白" };
		// String color[] = { "草莓红", "蜡粉红", "水粉红", "牡丹红" };
		String color[] = { "草绿 ", "孔雀绿", "荧光绿", "深绿" };

		List<String> cols = ArryUtil.getArray(color);

		// StringBuffer tempColor=new StringBuffer();
		//
		// for(int i =0;i<2;i++){
		// Random random = new Random();
		// int sub =random.nextInt(32);
		// System.out.println("下表："+sub);
		// tempColor.append("");
		// }
		//
		//
		for (int i = 0; i < tab.length; i++) {
			Random random = new Random();
			int sub = random.nextInt(cols.size() - 1);
			String srcString = tab[i];// 原
			String targetString = cols.get(sub);// 目标
			if (StringUtils.contains(srcString, "绿色")) {
				tab[i] = srcString.replace("绿色", targetString);
			}

		}
		System.out.println(JSONUtil.json(tab));
		//
		// String aString = "白色，绿色";
		// String bString = "乳白色";
		// System.out.println(aString.replace("白色", bString));

	}

}
