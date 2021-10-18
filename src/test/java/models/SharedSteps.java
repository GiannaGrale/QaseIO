package models;


import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SharedSteps {
    @Expose
    boolean status;
    @Expose
    SharedSteps result;
    @Expose
    SharedSteps [] entities;
    @Expose
    String hash;
    @Expose
    String title;
    @Expose
    String action;
    @Expose
    String expected_result;
    @Expose
    int [] cases;
    @Expose
    int cases_count;
}


