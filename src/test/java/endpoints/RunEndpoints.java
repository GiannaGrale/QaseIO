package endpoints;

public interface RunEndpoints {
    String GET_ALL_TEST_RUNS = "https://api.qase.io/v1/run/%s";
    String GET_ONE_TEST_RUN = "https://api.qase.io/v1/run/%s/%d";
    String CREATE_TEST_RUN = "https://api.qase.io/v1/run/%s";
    String DELETE_TEST_RUN = "https://api.qase.io/v1/run/%s/%d";
}
