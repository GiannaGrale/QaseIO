package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Result {
    @Expose
    Result result;
    @Expose
    Result[] entities;
    @Expose
    String hash;
    @Expose
    String comment;
    @Expose
    int run_id;
    @Expose
    int case_id;
    @Expose
    Result [] steps;
    @Expose
    String status;
    @Expose
    boolean is_api_result;
    @Expose
    int time_spent;
    @Expose
    String end_time;
}
