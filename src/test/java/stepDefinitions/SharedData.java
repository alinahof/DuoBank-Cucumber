package stepDefinitions;

import lombok.Data;

import java.util.List;

@Data
public class SharedData {

    private String password;
    private String username;
    private String randomEmail;
    private String randomPlaylistName;
    private String first;
    private String last;
    private String email;
    private String passMD5;
    private List<String> dbColumnNames;
    private List<String> emailsColumn;

    private String firstNameEE;
    private String lastNameEE;
    private String emailEE;
    private String passwordEE;
    private List<String> income_source;
    private List<String> column;
    
     static {
        RestAssured.baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com";
    }
    private RequestSpecification requestSpecification = given();
    private Response response;

}

