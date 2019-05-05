package club.fangqcloud.pojo;


public class Good {

  private long goodId;
  private String goodName;
  private double price;
  private long goodType;
  private java.sql.Timestamp createTimestamp;
  private java.sql.Timestamp changeTimestamp;


  public long getGoodId() {
    return goodId;
  }

  public void setGoodId(long goodId) {
    this.goodId = goodId;
  }


  public String getGoodName() {
    return goodName;
  }

  public void setGoodName(String goodName) {
    this.goodName = goodName;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public long getGoodType() {
    return goodType;
  }

  public void setGoodType(long goodType) {
    this.goodType = goodType;
  }


  public java.sql.Timestamp getCreateTimestamp() {
    return createTimestamp;
  }

  public void setCreateTimestamp(java.sql.Timestamp createTimestamp) {
    this.createTimestamp = createTimestamp;
  }


  public java.sql.Timestamp getChangeTimestamp() {
    return changeTimestamp;
  }

  public void setChangeTimestamp(java.sql.Timestamp changeTimestamp) {
    this.changeTimestamp = changeTimestamp;
  }

}
