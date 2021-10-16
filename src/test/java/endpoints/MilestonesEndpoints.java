package endpoints;

public interface MilestonesEndpoints {

    String GET_ALL_MILESTONES = "https://api.qase.io/v1/milestone/%s";
    String GET_SPECIFIC_MILESTONE ="https://api.qase.io/v1/milestone/%s/%d";
    String CREATE_MILESTONE = "https://api.qase.io/v1/milestone/%s";
    String DELETE_MILESTONE = "https://api.qase.io/v1/milestone/%s/%d";
    String UPDATE_MILESTONE = "https://api.qase.io/v1/milestone/%s/%d";
}
