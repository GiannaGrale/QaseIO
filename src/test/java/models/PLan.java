package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PLan {
    @Expose
    boolean status;
    @Expose
    PLan result;
    @Expose
    PLan [] entities;
    @Expose
    int id;
    @Expose
    String description;
    @Expose
    int cases_count;
    @Expose
    int average_time;
    int [] cases;
    @Expose
    int case_id;
    @Expose
    int assignee_id;
    @Expose
    String title;
}
