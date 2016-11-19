package info.androidhive.customlistviewvolley.model;

/**
 * Created by USER on 11/9/2016.
 */

public class JobInfo {

    private String jobtitle, company, salary, published, deadline, link, website;

    public JobInfo() {
    }

    public JobInfo(String jobtitle, String company, String salary, String published, String deadline, String link, String website) {
        this.jobtitle = jobtitle;
        this.company = company;
        this.salary = salary;
        this.published = published;
        this.deadline = deadline;
        this.link = link;
        this.website = website;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
