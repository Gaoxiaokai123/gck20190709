package com.bawei.gaochenkai20190709.data.bean;

import java.util.List;

/**
 * @Auther: 高晨凯
 * @Date: 2019/7/9 09:09:20
 * @Description:  接口bean类
 */
public class GsonBean {
    private String commodityName;
    private String masterPic;
    private String price;

    public GsonBean(String commodityName, String masterPic, String price) {
        this.commodityName = commodityName;
        this.masterPic = masterPic;
        this.price = price;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getMasterPic() {
        return masterPic;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GsonBean{" +
                "commodityName='" + commodityName + '\'' +
                ", masterPic='" + masterPic + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
