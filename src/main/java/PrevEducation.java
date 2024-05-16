public class PrevEducation {
  private String postgraduate_degree,
      professional_certification,
      high_school,
      associates_degree,
      bachelors_degree;

  public void setPostgraduate_degree(String postgraduate_degree) {
    this.postgraduate_degree = postgraduate_degree;
  }

  public void setAssociates_degree(String associates_degree) {
    this.associates_degree = associates_degree;
  }

  public void setBachelors_degree(String bachelors_degree) {
    this.bachelors_degree = bachelors_degree;
  }

  public void setHigh_school(String high_school) {
    this.high_school = high_school;
  }

  public void setProfessional_certification(String professional_certification) {
    this.professional_certification = professional_certification;
  }

  public String getHighSchool() {
    if (this.high_school.equals("false")) {
      return "Not Specified";
    } else {
      return "Required";
    }
  }

  public String getPostgraduateDegree() {
    if (postgraduate_degree.equalsIgnoreCase("false")) {
      return "Not Specified";
    } else {
      return "Required";
    }
  }

  public String getProfessionalCertification() {
    if (professional_certification.equalsIgnoreCase("false")) {
      return "Not Specified";
    } else {
      return "Required";
    }
  }

  public String getAssociatesDegree() {
    if (associates_degree.equalsIgnoreCase("false")) {
      return "Not Specified";
    } else {
      return "Required";
    }
  }

  public String getBachelorsDegree() {
    if (bachelors_degree.equalsIgnoreCase("false")) {
      return "Not Specified";
    } else {
      return "Required";
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("     Postgraduate Degree: ");
    sb.append(getPostgraduateDegree());
    sb.append("\n");

    sb.append("     Professional Certification: ");
    sb.append(getProfessionalCertification());
    sb.append("\n");

    sb.append("     High School: ");
    sb.append(getHighSchool());
    sb.append("\n");

    sb.append("     Associate's Degree: ");
    sb.append(getAssociatesDegree());
    sb.append("\n");

    sb.append("     Bachelor's Degree: ");
    sb.append(getBachelorsDegree());
    sb.append("\n");

    return sb.toString();
  }
}
