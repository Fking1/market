package club.fangqcloud.pojo;


public class Product {

  private long productId;
  private long classId;
  private long supplierId;
  private String productName;
  private String productDesc;
  private double price;


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public long getClassId() {
    return classId;
  }

  public void setClassId(long classId) {
    this.classId = classId;
  }


  public long getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(long supplierId) {
    this.supplierId = supplierId;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  @Override
  public String toString() {
    return "Product{" +
            "productId=" + productId +
            ", classId=" + classId +
            ", supplierId=" + supplierId +
            ", productName='" + productName + '\'' +
            ", productDesc='" + productDesc + '\'' +
            ", price=" + price +
            '}';
  }
}
