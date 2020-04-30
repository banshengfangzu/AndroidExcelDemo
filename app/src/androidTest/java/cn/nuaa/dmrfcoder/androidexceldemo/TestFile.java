package cn.nuaa.dmrfcoder.androidexceldemo;

import java.util.ArrayList;
import java.util.List;

import cn.nuaa.dmrfcoder.androidexceldemo.Bean.Bean;
import cn.nuaa.dmrfcoder.androidexceldemo.Bean.DemoBean;
import cn.nuaa.dmrfcoder.androidexceldemo.Utils.ExcelUtil;

public class TestFile {
    public static final int  max_ex_num=24;
    public static final double  yingli=0.05;
    public static final double  zhisun=0.02;

    public static void main(String[] args) {
//        int temp[] = {1, 2, 3, 5, 10, 20, 30};

        int i1 = 1;

        int beilv;
        int shengchang;
        String filePath = "D:\\androidProject\\demo.xls";


        String[] titles = {"blv", "sc", "syl"};
        ExcelUtil.initExcel(filePath, "demo", titles);

        List<DemoBean> demoBeanList = new ArrayList<>();


        inner:
        for (
                ; i1 <= 8; i1++) {

            double temp = 0;
            out:
            for (int i = 0; i < 31; i++) {

                double result = getResult(i, i1);
                if (result <= 1) continue out;
//                System.out.println("倍率:" + i + "胜场:" + i1 + "收益倍数:" + result);
                temp = result > temp ? result : temp;

//                if (result<300&&result>100)
                demoBeanList.add(new DemoBean(i, i1, result));
            }
        }



        ExcelUtil.writeObjListToExcel(demoBeanList, filePath);
    }

    /**
     * @param x 倍率
     * @param y 胜场 以100为总场次
     * @return
     */
    public static double getResult(int x, int y) {
        double a = 1 - zhisun * x;
        a=a<0.2?0:a;
        return Math.pow(yingli * x + 1, y) * Math.pow(a, max_ex_num - y);
    }


}
