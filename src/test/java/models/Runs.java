package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Runs {
    @Expose
    Runs result;
    @Expose
    int id;
    @Expose
    Integer environment_id;
    @Expose
    String description;
    @Expose
    String title;
    @Expose
    String start_time;
    @Expose
    String  end_time;
    @Expose
    Runs stats;
    @Expose
    Runs [] entities;
    @Expose
    int total;
    @Expose
    int untested;
    @Expose
    int passed;
    @Expose
    int failed;
    @Expose
    int blocked;
    @Expose
    int skipped;
    @Expose
    int retest;
    @Expose
    int deleted;
    @Expose
    int [] cases;
}
