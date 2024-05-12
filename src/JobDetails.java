public class JobDetails {

    private String status;
    private Parameters parameters;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(String query, int page, int num_pages) {
        this.parameters.setQuery(query);
        this.parameters.setPage(page);
        this.parameters.setNum_pages(num_pages);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request Status: " + status + "\n" );
        stringBuilder.append("Request Internal Parameters:" + "\n" + getParameters());
        return stringBuilder.toString();
    }
}
