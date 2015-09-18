package com.qizhu.util;
import java.text.DecimalFormat;   
import java.text.NumberFormat;   
import java.util.Locale;


//总体思路：   
//对数字进行分级处理，级长为4   
//对分级后的每级分别处理，处理后得到字符串相连   
//如：123456=12|3456   
//第二级：12=壹拾贰 + “万”   
//第一级：3456 =叁千肆百伍拾陆 + “”   

public final class RMB {   
	
  private double amount = 0.0D;   
  private static final String NUM = "零壹贰叁肆伍陆柒捌玖";   
  private static final String UNIT = "仟佰拾个";   
  private static final String GRADEUNIT = "仟万亿兆";   
  private static final String DOTUNIT = "角分厘";   
  private static final int GRADE = 4;  
  private static final String SIGN = "￥";   
  private static final NumberFormat nf = new DecimalFormat("#0.###");   

  /**  
   * 带参数的构造方法  
   * @param amount  
   */  

  private RMB(double amount) {   

      this.amount = amount;   

  }   
  
  public static String toBigAmt(double amount) {   

      nf.setMinimumFractionDigits(2);//小数点后不足的补零   
      String amt = nf.format(amount);//将double类型的数格式化并转换成字符串,实际上进行了四舍五入   
      
      Double d = new Double(amount);   
      String dotPart = ""; //取小数位   
      String intPart = ""; //取整数位   

      int dotPos;   
      if ((dotPos = amt.indexOf('.')) != -1) {   
          intPart = amt.substring(0, dotPos);   
          dotPart = amt.substring(dotPos + 1);   
          if(dotPart.length()>4){ //超过4位直接截取   
              dotPart = dotPart.substring(0,4);   
          }   

      } else {   
          intPart = amt;   
      }   

      if (intPart.length() > 16)   
          throw new java.lang.InternalError("数额太大，无法转换。");   

      String intBig = intToBig(intPart);   
      String dotBig = dotToBig(dotPart);   

      //以下代码稍做修改，现在好多了。   

      if ((dotBig.length() == 0) && (intBig.length() != 0)) {   
          return intBig + "元整";   
      } else if ((dotBig.length() == 0) && (intBig.length() == 0)) {   
          return intBig + "零元";   
      } else if ((dotBig.length() != 0) && (intBig.length() != 0)) {   
          return intBig + "元" + dotBig;   
      } else {   
          return dotBig;   
      }   

  }   



  /**  
   * 用来处理几角几分几厘  
   * @param dotPart  
   * @return  
   */  

  private static String dotToBig(String dotPart) {   
      //得到转换后的大写（小数部分）   
      String strRet = "";   
      for (int i = 0; i < dotPart.length() && i < 3; i++) {   
          int num;   
          if ((num = Integer.parseInt(dotPart.substring(i, i + 1))) != 0)   
              strRet += NUM.substring(num, num + 1)+ DOTUNIT.substring(i, i + 1);   
      }   

      return strRet;   

  }   



  /**  
   * 用来处理多少元 ，这个要仔细考虑才行  
   * @param intPart  
   * @return  
   */  

  private static String intToBig(String intPart) {   
      //得到转换后的大写（整数部分）   
      int grade; //级长   
      String result = "";   
      String strTmp = "";   


      //得到当级长   
      grade = intPart.length() / GRADE;   
      //调整级次长度   
      if (intPart.length() % GRADE != 0)   
          grade += 1;   

      //对每级数字处理，先处理最高级，然后再处理低级的   
      for (int i = grade; i >= 1; i--) {   
          strTmp = getNowGradeVal(intPart, i);//取得当前级次数字   
          result += getSubUnit(strTmp);//转换大写   
          //System.out.println(strTmp+"|"+getSubUnit(strTmp));   
          result = dropZero(result);//除零 去掉连续的零   
          //System.out.println("result="+result);   
          //加级次单位   
          if (i > 1) //末位不加单位   
              //单位不能相连续   
              //注意：连续4个零的时候要特殊处理(wmj修改此bug)   
              if(getSubUnit(strTmp).equals("零零零零")){   
                  result = result+"零";   
              }else{   
                  result += GRADEUNIT.substring(i - 1, i);   
              }   
      }   
      return result;   
  }   



  private static String getNowGradeVal(String strVal, int grade) {   

      //得到当前级次的串   
      String rst;   
      if (strVal.length() <= grade * GRADE)   
          rst = strVal.substring(0, strVal.length() - (grade - 1) * GRADE);   
      else  
          rst = strVal.substring(strVal.length() - grade * GRADE, strVal.length() - (grade - 1) * GRADE);   

      return rst;   

  }   



  private static String getSubUnit(String strVal) {   

      //数值转换   
      String rst = "";   
      for (int i = 0; i < strVal.length(); i++) {   
          String s = strVal.substring(i, i + 1);   
          int num = Integer.parseInt(s);   
          if (num == 0) {   
              //“零”作特殊处理   
              if (i != strVal.length()) //转换后数末位不能为零   
                  rst += "零";   
          } else {   

              //If IntKey = 1 And i = 2 Then   
              //“壹拾”作特殊处理   
              //“壹拾”合理   
              //Else   
              rst += NUM.substring(num, num + 1);   
              //End If   
              //追加单位   
              if (i != strVal.length() - 1)//个位不加单位   
                  rst += UNIT.substring(i + 4 - strVal.length(), i + 4 - strVal.length() + 1);   

          }   
      }   
      return rst;   
  }   



  /**
   * 本地默认输出货币值
   * 中国
   * @param d
   * @return
   */
  public static String currencyMoneyFormat(double d){
	   	//NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	   	//NumberFormat germanformat = NumberFormat.getInstance(Locale.CHINA);//china  format
	  	NumberFormat currencyFormat = NumberFormat.getInstance(Locale.CHINA);	
	    return currencyFormat.format(d);
  }
  
  /**  
   *   
   * @param strVal  
   * @return  
   */  

  private static String dropZero(String strVal) {   

      //去除连继的“零”   
      String strRst;   
      String strBefore; //前一位置字符   
      String strNow; //现在位置字符   
      strBefore = strVal.substring(0, 1);   
      strRst = strBefore;   
      for (int i = 1; i < strVal.length(); i++) {   
          strNow = strVal.substring(i, i + 1);   
          if (strNow.equals("零") && strBefore.equals("零"))   
              ;//同时为零   
          else  
              strRst += strNow;   
          strBefore = strNow;   

      }   

      //末位去零   
      if (strRst.substring(strRst.length() - 1, strRst.length()).equals("零"))   
          strRst = strRst.substring(0, strRst.length() - 1);   
      return strRst;   
  }   


  public static void main(String[] args) throws InterruptedException{ 
	 
  	System.out.println(  RMB.toBigAmt(5631213123423456D));

    double d = 10000.0 / 3.0;

    System.out.println("无格式化输出：" + d);

    // 使用本地默认格式输出数

    NumberFormat numberFormat = NumberFormat.getNumberInstance();

    //numberFormat.setMaximumFractionDigits(4);

    //numberFormat.setMinimumIntegerDigits(6);

    String numberString = numberFormat.format(d);

 
    
    
    
    System.out.println("本地默认格式输出数：" + numberString);

    // 使用本地默认格式输出货币值

 

    // 使用本地默认格式输出百分数

    NumberFormat percentFormat = NumberFormat.getPercentInstance();

    System.out.println("本地默认格式输出百分数：" + percentFormat.format(d));

    // 在不同的国家和地区数字表示的格式也有区别。如德国

    // 使用德国的格式化输出数

    NumberFormat numberFormatG = NumberFormat

            .getNumberInstance(Locale.GERMANY);

    System.out.println("德国数字输出形式：" + numberFormatG.format(d));

    // 使用德国货币输出形式

    NumberFormat currencyFormatG = NumberFormat

            .getCurrencyInstance(Locale.GERMANY);

    System.out.println("德国货币输出形式：" + currencyFormatG.format(d));

    // 使用美国货币输出形式

    NumberFormat currencyFormatA = NumberFormat

            .getCurrencyInstance(Locale.US);

    System.out.println("美国货币输出形式：" + currencyFormatA.format(d));

    // 使用德国百分数输出形式

    NumberFormat percentFormatG = NumberFormat

            .getPercentInstance(Locale.GERMANY);

    System.out.println("德国百分数输出形式：" + percentFormatG.format(d));
  } 

}  

