package endpoints;

public interface ResultsEndpoints {
    String GET_ALL_RUN_RESULTS = "https://api.qase.io/v1/result/%s";
    String GET_SPECIFIC_RUN_RESULT = "https://api.qase.io/v1/result/%s/%s";
    String ADD_RUN_RESULT = "https://api.qase.io/v1/result/%s/%d";
    String UPDATE_RUN_RESULT = "https://api.qase.io/v1/result/%s/%d/%s";
    String DELETE_RUN_RESULT = "https://api.qase.io/v1/result/%s/%d/%s";
}
