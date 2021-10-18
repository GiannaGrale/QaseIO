package endpoints;

public interface SharedStepsEndpoints {

    String GET_ALL_STEPS = "https://api.qase.io/v1/shared_step/%s";
    String GET_SPECIFIC_STEP = "https://api.qase.io/v1/shared_step/%s/%s";
    String POST_STEP = "https://api.qase.io/v1/shared_step/%s";
    String UPDATE_STEP = "https://api.qase.io/v1/shared_step/%s/%s";
    String DELETE_STEP = "https://api.qase.io/v1/shared_step/%s/%s";

}
