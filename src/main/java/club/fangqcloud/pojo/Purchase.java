package club.fangqcloud.pojo;



public class Purchase {

  private long purchaseId;
  private long productId;
  private long supplierId;
  private double price;
  private long purchaseNum;
  private String purchaser;


  public long getPurchaseId() {
    return purchaseId;
  }

  public void setPurchaseId(long purchaseId) {
    this.purchaseId = purchaseId;
  }


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public long getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(long supplierId) {
    this.supplierId = supplierId;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public long getPurchaseNum() {
    return purchaseNum;
  }

  public void setPurchaseNum(long purchaseNum) {
    this.purchaseNum = purchaseNum;
  }


    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }
}
