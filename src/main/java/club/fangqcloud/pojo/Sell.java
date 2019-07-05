package club.fangqcloud.pojo;


import java.sql.Timestamp;

public class Sell {

  private long sellId;
  private long productId;
  private double price;
  private long sellNum;
  private String payWay;
  private String seller;


  public long getSellId() {
    return sellId;
  }

  public void setSellId(long sellId) {
    this.sellId = sellId;
  }


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public long getSellNum() {
    return sellNum;
  }

  public void setSellNum(long sellNum) {
    this.sellNum = sellNum;
  }


  public String getPayWay() {
    return payWay;
  }

  public void setPayWay(String payWay) {
    this.payWay = payWay;
  }


    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
