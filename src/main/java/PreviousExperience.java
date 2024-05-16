public class PreviousExperience {

  private String no_experience_required, required_experience_in_months, experience_preferred;

  public String getNo_experience_required() {
    if (no_experience_required.equals("true")) {
      return "Yes!";
    } else {
      return "No!";
    }
  }

  public void setNo_experience_required(String no_experience_required) {
    this.no_experience_required = no_experience_required;
  }

  public String getRequired_experience_in_months() {
    if (required_experience_in_months == null) {
      return "Not Specified!";
    } else {
      return required_experience_in_months;
    }
  }

  public void setRequired_experience_in_months(String required_experience_in_months) {
    this.required_experience_in_months = required_experience_in_months;
  }

  public String getExperience_preferred() {
    if (experience_preferred.equals("true")) {
      return "Yes!";
    } else {
      return "No!";
    }
  }

  public void setExperience_preferred(String experience_preferred) {
    this.experience_preferred = experience_preferred;
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append("     Required Experience: " + getNo_experience_required() + "\n")
        .append("     Months of Required Experience: " + getRequired_experience_in_months() + "\n")
        .append(
            "     Does this company prefer previous experience? "
                + getExperience_preferred()
                + "\n")
        .toString();
  }
}
