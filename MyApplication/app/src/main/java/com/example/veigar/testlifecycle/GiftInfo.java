package com.example.veigar.testlifecycle;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import org.json.JSONObject;

public class GiftInfo implements Parcelable {

    private String giftId;
    private String giftName;
    private String price;
    private String unit;
    private String minNum;
    private String maxNum;
    /**
     * 限量 不为0就是限量的数量
     */
    public String total;
    /**
     * 铁粉专属
     * 1:是
     * 0:否
     */
    public String limiter;
    public String startTime;
    public String endTime;
    public String discount;
    public int saleNum;
    public int pos;// 2普通3精品4尊贵5炫彩
    public String small;
    public String big;
    public String vipPrice;

    public double priceNew;
    public double vipPriceNew;
    public int payType;//1明星币  2爱拍豆


    public double getRawPrice() {
        if (payType == 1) {
            return priceNew * 100;
        } else {
            return priceNew;
        }
    }

    public double getRealPrice() {
        try {
            double p = priceNew;


            try {
                int v = -1;
                if (v > 0 && v < 8) {
                    p = vipPriceNew;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            if ("1".equals(limiter)) {

            } else if (Integer.valueOf(total) > 0) {

            } else if (!TextUtils.isEmpty(discount)) {
                try {
                    long t = System.currentTimeMillis();
                    long s = Long.valueOf(startTime) * 1000;
                    long e = Long.valueOf(endTime) * 1000;
                    if (t >= s && t < e) {
                        float f = (float) Integer.valueOf(discount) / 10f;
                        p *= f;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean isValidate() {
        try {
            if ("1".equals(limiter)) {
                return true;
            } else if (Integer.valueOf(total) > 0) {
                return true;
            } else if (!TextUtils.isEmpty(discount)) {
                long t = System.currentTimeMillis();
                long s = Long.valueOf(startTime) * 1000;
                long e = Long.valueOf(endTime) * 1000;
                if (t >= s && t < e) {
                    return true;
                }
            }

            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public GiftInfo() {
    }

    public GiftInfo(JSONObject obj) {
        giftId = obj.optString("giftId");
        giftName = obj.optString("giftName");
        price = obj.optString("price");
        unit = obj.optString("unit");
        minNum = obj.optString("minNum");
        maxNum = obj.optString("maxNum");
        total = obj.optString("total");
        limiter = obj.optString("limiter");
        startTime = obj.optString("startTime");
        endTime = obj.optString("endTime");
        discount = obj.optString("discount");
        saleNum = obj.optInt("saleNum");
        pos = obj.optInt("pos");
        if (obj.has("small")) {
            small = obj.optString("small");
        } else {
            small = obj.optString("img_app");
        }
        big = obj.optString("big");
        vipPrice = obj.optString("vipPrice");
        priceNew = obj.optDouble("priceNew");
        vipPriceNew = obj.optDouble("vipPriceNew");
        // 适配明星币
        if (obj.has("priceNew")) {
            priceNew = obj.optDouble("priceNew");
        } else {
            priceNew = Float.valueOf(price);
        }
        if (obj.has("vipPriceNew")) {
            vipPriceNew = obj.optDouble("vipPriceNew");
        } else {
            vipPriceNew = Float.valueOf(vipPrice);
        }
        payType = obj.optInt("payType", 1);

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.giftId);
        dest.writeString(this.giftName);
        dest.writeString(this.price);
        dest.writeString(this.unit);
        dest.writeString(this.minNum);
        dest.writeString(this.maxNum);
        dest.writeString(this.total);
        dest.writeString(this.limiter);
        dest.writeString(this.startTime);
        dest.writeString(this.endTime);
        dest.writeString(this.discount);
        dest.writeInt(this.saleNum);
        dest.writeInt(this.pos);
        dest.writeString(this.small);
        dest.writeString(this.big);
        dest.writeString(this.vipPrice);
        dest.writeDouble(this.priceNew);
        dest.writeDouble(this.vipPriceNew);
        dest.writeInt(this.payType);
    }

    protected GiftInfo(Parcel in) {
        this.giftId = in.readString();
        this.giftName = in.readString();
        this.price = in.readString();
        this.unit = in.readString();
        this.minNum = in.readString();
        this.maxNum = in.readString();
        this.total = in.readString();
        this.limiter = in.readString();
        this.startTime = in.readString();
        this.endTime = in.readString();
        this.discount = in.readString();
        this.saleNum = in.readInt();
        this.pos = in.readInt();
        this.small = in.readString();
        this.big = in.readString();
        this.vipPrice = in.readString();
        this.priceNew = in.readDouble();
        this.vipPriceNew = in.readDouble();
        this.payType = in.readInt();
    }

    public static final Creator<GiftInfo> CREATOR = new Creator<GiftInfo>() {
        @Override
        public GiftInfo createFromParcel(Parcel source) {
            return new GiftInfo(source);
        }

        @Override
        public GiftInfo[] newArray(int size) {
            return new GiftInfo[size];
        }
    };

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public static Creator<GiftInfo> getCREATOR() {
        return CREATOR;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getLimiter() {
        return limiter;
    }

    public void setLimiter(String limiter) {
        this.limiter = limiter;
    }

    public String getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(String maxNum) {
        this.maxNum = maxNum;
    }

    public String getMinNum() {
        return minNum;
    }

    public void setMinNum(String minNum) {
        this.minNum = minNum;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public double getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(double priceNew) {
        this.priceNew = priceNew;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(String vipPrice) {
        this.vipPrice = vipPrice;
    }

    public double getVipPriceNew() {
        return vipPriceNew;
    }

    public void setVipPriceNew(double vipPriceNew) {
        this.vipPriceNew = vipPriceNew;
    }
}
