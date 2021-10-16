package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {
    @Expose
    boolean status;
    @Expose
    int id;
    @Expose
    String title;
    @Expose
    String description;
    @Expose
    String preconditions;
    @Expose
    String position;
    @Expose
    int cases_count;
    @Expose
    int parent_id;
    @Expose
    Suite result;
    @Expose
    Suite [] entities;

}
