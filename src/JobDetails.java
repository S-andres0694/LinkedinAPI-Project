public class JobDetails {

    private String status;
    private String request_id;
    private Parameters parameters;

    public String getRequest_id() {
        return request_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRequest_id(String request_ID) {
        this.request_id = request_ID;
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
        return "JobDetails{" +
                "status='" + status + '\'' +
                ", request_id='" + request_id + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
