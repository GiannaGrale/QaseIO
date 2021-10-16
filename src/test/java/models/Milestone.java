package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Milestone {
    @Expose
    boolean status;
    @Expose
    Milestone result;
    @Expose
    int total;
    @Expose
    int filtered;
    @Expose
    int count;
    @Expose
    Milestone [] entities;
    @Expose
    int id;
    @Expose
    String title;
    @Expose
    String description;

}
