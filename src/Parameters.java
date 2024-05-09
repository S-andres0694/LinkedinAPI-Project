public class Parameters {

    private String query;
    private int page;
    private int num_pages;

    public Parameters(String query, int page, int num_pages) {
        this.query = query;
        this.page = page;
        this.num_pages = num_pages;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNum_pages() {
        return num_pages;
    }

    public void setNum_pages(int num_pages) {
        this.num_pages = num_pages;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "query='" + query + '\'' +
                ", page=" + page +
                ", num_pages=" + num_pages +
                '}';
    }
}
