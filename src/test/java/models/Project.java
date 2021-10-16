package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Project {
    @Expose
    boolean status;
    @Expose
    int total;
    @Expose
    int filtered;
    @Expose
    int count;
    @Expose
    String title;
    @Expose
    Project result;
    @Expose
    Project [] entities;
    @Expose
    Project counts;
    @Expose
    Project defects;
    @Expose
    String code;
    @Expose
    int cases;
    @Expose
    int suites;
    @Expose
    int milestones;
    @Expose
    int totalDefects;
    @Expose
    int openDefects;
    @Expose
    String description;
    @Expose
    String access;
    @Expose
    String group;
}
