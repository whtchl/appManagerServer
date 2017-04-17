package com.cncoman.product.util;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumberUtil {
	
    public ArrayList<Integer> nums=new ArrayList();

    public RandomNumberUtil (int startnum, int endnum) throws Exception
    {
        if (startnum >= endnum) 
            throw new Exception("对不起，起始数字必须小于结尾数字！");
        else
           for (int i=startnum; i<=endnum;++i)
                nums.add(i);
       
    }

    public int GetNum() throws Exception
    {
        if (nums.size() <= 0)
            throw new Exception("对不起，指定范围的随机数全部产生过了。");
        else
          {
            Random r = new Random();
            int index=(int)(r.nextDouble()*10+1);
            int returnnum =(int)(nums.get(index));
            nums.remove(index);
            return returnnum;
            }
    }

}
