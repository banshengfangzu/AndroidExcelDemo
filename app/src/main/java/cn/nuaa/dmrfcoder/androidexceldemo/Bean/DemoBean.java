package cn.nuaa.dmrfcoder.androidexceldemo.Bean;

/**
 * @author dmrfcoder
 * @date 2019/2/14
 */

public class DemoBean {
    int beilv;
    int shengchang;
    double shouyibeishu;

    public DemoBean(int beilv, int shengchang, double shouyibeishu) {
        this.beilv = beilv;
        this.shengchang = shengchang;
        this.shouyibeishu = shouyibeishu;
    }

    public int getBeilv() {
        return beilv;
    }

    public void setBeilv(int beilv) {
        this.beilv = beilv;
    }

    public int getShengchang() {
        return shengchang;
    }

    public void setShengchang(int shengchang) {
        this.shengchang = shengchang;
    }

    public double getShouyibeishu() {
        return shouyibeishu;
    }

    public void setShouyibeishu(double shouyibeishu) {
        this.shouyibeishu = shouyibeishu;
    }
}
