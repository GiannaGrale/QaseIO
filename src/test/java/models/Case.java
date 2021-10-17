package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {
    @Expose
    Case result;
    @Expose
    int id;
    @Expose
    int position;
    @Expose
    String title;
    @Expose
    String description;
    @Expose
    String preconditions;
    @Expose
    String postconditions;
    @Expose
    int severity;
    @Expose
    int priority;
    @Expose
    int type;
    @Expose
    int behavior;
    @Expose
    String automation;
    @Expose
    int milestone_id;
    @Expose
    int suite_id;
    @Expose
    Case [] tags;
    @Expose
    Case [] links;
    @Expose
    int revision;
    @Expose
    Case [] custom_fields;
    @Expose
    Case [] attachments;
    @Expose
    Case [] steps;
    @Expose
    Case [] entities;
    @Expose
    String action;
    @Expose
    String expected_result;
}
