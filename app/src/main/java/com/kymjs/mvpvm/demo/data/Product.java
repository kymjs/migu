package com.kymjs.mvpvm.demo.data;

import com.kymjs.mvpvm.model.IModel;

public class Product implements IModel {
    /**
     * imgUrl : https://img01.yit.com/CMSRESQN/dcd43c22dd62c54ba94490f331421169_750X500.jpeg
     * dailyPrice : 0
     * price : 0
     * productName :
     * spuId : 0
     */

    private String imgUrl;
    private int dailyPrice;
    private int price;
    private String productName;
    private int spuId;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(int dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSpuId() {
        return spuId;
    }

    public void setSpuId(int spuId) {
        this.spuId = spuId;
    }
}
