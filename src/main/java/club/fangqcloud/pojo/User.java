package club.fangqcloud.pojo;


public class User {

  private long userId;
  private String username;
  private String password;
  private String userPermission;
  private String productPermission;
  private String purchasePermission;
  private String sellPermission;
  private String supplierPermission;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getUserPermission() {
    return userPermission;
  }

  public void setUserPermission(String userPermission) {
    this.userPermission = userPermission;
  }

  public String getProductPermission() {
    return productPermission;
  }

  public void setProductPermission(String productPermission) {
    this.productPermission = productPermission;
  }

  public String getPurchasePermission() {
    return purchasePermission;
  }

  public void setPurchasePermission(String purchasePermission) {
    this.purchasePermission = purchasePermission;
  }

  public String getSellPermission() {
    return sellPermission;
  }

  public void setSellPermission(String sellPermission) {
    this.sellPermission = sellPermission;
  }

  public String getSupplierPermission() {
    return supplierPermission;
  }

  public void setSupplierPermission(String supplierPermission) {
    this.supplierPermission = supplierPermission;
  }
}
