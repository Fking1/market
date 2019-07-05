package club.fangqcloud.pojo;


public class ProductClass {

  private long classId;
  private String className;
  private String classDesc;


  public long getClassId() {
    return classId;
  }

  public void setClassId(long classId) {
    this.classId = classId;
  }


  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }


  public String getClassDesc() {
    return classDesc;
  }

  public void setClassDesc(String classDesc) {
    this.classDesc = classDesc;
  }

  @Override
  public String toString() {
    return "ProductClass{" +
            "classId=" + classId +
            ", className='" + className + '\'' +
            ", classDesc='" + classDesc + '\'' +
            '}';
  }
}
