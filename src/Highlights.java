import java.util.ArrayList;

public class Highlights {

  private ArrayList<String> Qualifications;
  private ArrayList<String> Responsibilities;
  private ArrayList<String> Benefits;

  public ArrayList<String> getQualifications() {
    if (Qualifications == null) {
      Qualifications = new ArrayList<>();
      return Qualifications;
    } else {
      return Qualifications;
    }
  }

  public ArrayList<String> getBenefits() {
    if (Benefits == null) {
      Benefits = new ArrayList<>();
      return Benefits;
    } else {
      return Benefits;
    }
  }

  public void setBenefits(ArrayList<String> benefits) {
    Benefits = benefits;
  }

  public void setQualifications(ArrayList<String> qualifications) {
    Qualifications = qualifications;
  }

  public ArrayList<String> getResponsibilities() {
    if (Responsibilities == null) {
      Responsibilities = new ArrayList<>();
      return Responsibilities;
    } else {
      return Responsibilities;
    }
  }

  public void setResponsibilities(ArrayList<String> responsibilities) {
    Responsibilities = responsibilities;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (Responsibilities != null) {
      builder.append("Responsibilities: " + "\n");
      for (String s : getResponsibilities()) {
        builder.append("     " + s + "\n");
      }
    }
    if (Qualifications != null) {
      builder.append("Qualifications: " + "\n");
      for (String s : getQualifications()) {
        builder.append("     " + s + "\n");
      }
    }
    if (Benefits != null) {
      builder.append("Benefits: " + "\n");
      for (String s : getBenefits()) {
        builder.append("     " + s + "\n");
      }
    }
    return builder.toString();
  }
}
