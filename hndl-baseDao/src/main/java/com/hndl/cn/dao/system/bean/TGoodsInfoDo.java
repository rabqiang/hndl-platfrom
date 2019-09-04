package com.hndl.cn.dao.system.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * t_goods_info
 * @author 
 */
public class TGoodsInfoDo implements Serializable {
    /**
     * 编号
     */
    private String goodscode;

    /**
     * 名称
     */
    private String goodsname;

    /**
     * 分类
     */
    private String goodstype;

    /**
     * 库存量
     */
    private Long numbers;

    /**
     * 品牌
     */
    private String goodsbrand;

    /**
     * 规格
     */
    private String goodsformat;

    /**
     * 是否上架（0：否；1：是）
     */
    private Integer isshelves;

    /**
     * 上架时间
     */
    private Date shelvesdate;

    /**
     * 积分
     */
    private Long goodsintegral;

    /**
     * 市场价
     */
    private Double marketprice;

    /**
     * 销售价
     */
    private Double payprice;

    /**
     * 成本价
     */
    private Double costprice;

    /**
     * 详细描述
     */
    private String description;

    /**
     * 图片（相对路径）
     */
    private String image;

    /**
     * 是否删除（0：否；1：是）
     */
    private Integer isdelete;

    private String other1;

    private String other2;

    private String other3;

    private String other4;

    private String other5;

    private String other6;

    private static final long serialVersionUID = 1L;

    public String getGoodscode() {
        return goodscode;
    }

    public void setGoodscode(String goodscode) {
        this.goodscode = goodscode;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype;
    }

    public Long getNumbers() {
        return numbers;
    }

    public void setNumbers(Long numbers) {
        this.numbers = numbers;
    }

    public String getGoodsbrand() {
        return goodsbrand;
    }

    public void setGoodsbrand(String goodsbrand) {
        this.goodsbrand = goodsbrand;
    }

    public String getGoodsformat() {
        return goodsformat;
    }

    public void setGoodsformat(String goodsformat) {
        this.goodsformat = goodsformat;
    }

    public Integer getIsshelves() {
        return isshelves;
    }

    public void setIsshelves(Integer isshelves) {
        this.isshelves = isshelves;
    }

    public Date getShelvesdate() {
        return shelvesdate;
    }

    public void setShelvesdate(Date shelvesdate) {
        this.shelvesdate = shelvesdate;
    }

    public Long getGoodsintegral() {
        return goodsintegral;
    }

    public void setGoodsintegral(Long goodsintegral) {
        this.goodsintegral = goodsintegral;
    }

    public Double getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(Double marketprice) {
        this.marketprice = marketprice;
    }

    public Double getPayprice() {
        return payprice;
    }

    public void setPayprice(Double payprice) {
        this.payprice = payprice;
    }

    public Double getCostprice() {
        return costprice;
    }

    public void setCostprice(Double costprice) {
        this.costprice = costprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    public String getOther4() {
        return other4;
    }

    public void setOther4(String other4) {
        this.other4 = other4;
    }

    public String getOther5() {
        return other5;
    }

    public void setOther5(String other5) {
        this.other5 = other5;
    }

    public String getOther6() {
        return other6;
    }

    public void setOther6(String other6) {
        this.other6 = other6;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TGoodsInfoDo other = (TGoodsInfoDo) that;
        return (this.getGoodscode() == null ? other.getGoodscode() == null : this.getGoodscode().equals(other.getGoodscode()))
            && (this.getGoodsname() == null ? other.getGoodsname() == null : this.getGoodsname().equals(other.getGoodsname()))
            && (this.getGoodstype() == null ? other.getGoodstype() == null : this.getGoodstype().equals(other.getGoodstype()))
            && (this.getNumbers() == null ? other.getNumbers() == null : this.getNumbers().equals(other.getNumbers()))
            && (this.getGoodsbrand() == null ? other.getGoodsbrand() == null : this.getGoodsbrand().equals(other.getGoodsbrand()))
            && (this.getGoodsformat() == null ? other.getGoodsformat() == null : this.getGoodsformat().equals(other.getGoodsformat()))
            && (this.getIsshelves() == null ? other.getIsshelves() == null : this.getIsshelves().equals(other.getIsshelves()))
            && (this.getShelvesdate() == null ? other.getShelvesdate() == null : this.getShelvesdate().equals(other.getShelvesdate()))
            && (this.getGoodsintegral() == null ? other.getGoodsintegral() == null : this.getGoodsintegral().equals(other.getGoodsintegral()))
            && (this.getMarketprice() == null ? other.getMarketprice() == null : this.getMarketprice().equals(other.getMarketprice()))
            && (this.getPayprice() == null ? other.getPayprice() == null : this.getPayprice().equals(other.getPayprice()))
            && (this.getCostprice() == null ? other.getCostprice() == null : this.getCostprice().equals(other.getCostprice()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getIsdelete() == null ? other.getIsdelete() == null : this.getIsdelete().equals(other.getIsdelete()))
            && (this.getOther1() == null ? other.getOther1() == null : this.getOther1().equals(other.getOther1()))
            && (this.getOther2() == null ? other.getOther2() == null : this.getOther2().equals(other.getOther2()))
            && (this.getOther3() == null ? other.getOther3() == null : this.getOther3().equals(other.getOther3()))
            && (this.getOther4() == null ? other.getOther4() == null : this.getOther4().equals(other.getOther4()))
            && (this.getOther5() == null ? other.getOther5() == null : this.getOther5().equals(other.getOther5()))
            && (this.getOther6() == null ? other.getOther6() == null : this.getOther6().equals(other.getOther6()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodscode() == null) ? 0 : getGoodscode().hashCode());
        result = prime * result + ((getGoodsname() == null) ? 0 : getGoodsname().hashCode());
        result = prime * result + ((getGoodstype() == null) ? 0 : getGoodstype().hashCode());
        result = prime * result + ((getNumbers() == null) ? 0 : getNumbers().hashCode());
        result = prime * result + ((getGoodsbrand() == null) ? 0 : getGoodsbrand().hashCode());
        result = prime * result + ((getGoodsformat() == null) ? 0 : getGoodsformat().hashCode());
        result = prime * result + ((getIsshelves() == null) ? 0 : getIsshelves().hashCode());
        result = prime * result + ((getShelvesdate() == null) ? 0 : getShelvesdate().hashCode());
        result = prime * result + ((getGoodsintegral() == null) ? 0 : getGoodsintegral().hashCode());
        result = prime * result + ((getMarketprice() == null) ? 0 : getMarketprice().hashCode());
        result = prime * result + ((getPayprice() == null) ? 0 : getPayprice().hashCode());
        result = prime * result + ((getCostprice() == null) ? 0 : getCostprice().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getIsdelete() == null) ? 0 : getIsdelete().hashCode());
        result = prime * result + ((getOther1() == null) ? 0 : getOther1().hashCode());
        result = prime * result + ((getOther2() == null) ? 0 : getOther2().hashCode());
        result = prime * result + ((getOther3() == null) ? 0 : getOther3().hashCode());
        result = prime * result + ((getOther4() == null) ? 0 : getOther4().hashCode());
        result = prime * result + ((getOther5() == null) ? 0 : getOther5().hashCode());
        result = prime * result + ((getOther6() == null) ? 0 : getOther6().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodscode=").append(goodscode);
        sb.append(", goodsname=").append(goodsname);
        sb.append(", goodstype=").append(goodstype);
        sb.append(", numbers=").append(numbers);
        sb.append(", goodsbrand=").append(goodsbrand);
        sb.append(", goodsformat=").append(goodsformat);
        sb.append(", isshelves=").append(isshelves);
        sb.append(", shelvesdate=").append(shelvesdate);
        sb.append(", goodsintegral=").append(goodsintegral);
        sb.append(", marketprice=").append(marketprice);
        sb.append(", payprice=").append(payprice);
        sb.append(", costprice=").append(costprice);
        sb.append(", description=").append(description);
        sb.append(", image=").append(image);
        sb.append(", isdelete=").append(isdelete);
        sb.append(", other1=").append(other1);
        sb.append(", other2=").append(other2);
        sb.append(", other3=").append(other3);
        sb.append(", other4=").append(other4);
        sb.append(", other5=").append(other5);
        sb.append(", other6=").append(other6);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}