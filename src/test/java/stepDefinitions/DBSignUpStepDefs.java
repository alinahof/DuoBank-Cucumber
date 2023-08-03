package stepDefinitions;

import Pages.SignUpPage;
import com.beust.ah.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.DBUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DBSignUpStepDefs extends SignUpPage{

    @Then("I retrieve the email")
    public void i_retrieve_the_email () throws SQLException {

        String email = "test@email.com";

        List<Map<String, Object>> listOfMaps = DBUtils.getQueryResultListOfMaps("SELECT email, first_name FROM tbl_user where email = '"+ email +"'");

        System.out.println(listOfMaps);

    }

    @Then("I verify the information is correct")
    public void i_verify_the_information_is_correct() {


        String email = "test@email.com";

        List<Map<String, Object>> listOfMaps = DBUtils.getQueryResultListOfMaps("SELECT email, first_name FROM tbl_user where email = '"+ email +"'");

        String expectedEmail = "test@email.com";
        String expectedFirstName = "testy";

        Assert.assertEquals(expectedEmail, listOfMaps.get(0).get("email"));
        Assert.assertEquals(expectedFirstName, listOfMaps.get(0).get("first_name"));
    }

    @Given("I retrieve the columns from Data Base")
    public void iRetrieveTheColumnsFromDataBase() {

     List<Map<String, Object>> mapList  = DBUtils.getQueryResultListOfMaps("""
             select column_name
             from information_schema.columns
             where table_name = 'tbl_user';""");
        System.out.println(mapList);

    }

    @Then("I verify the columns")
    public void iVerifyTheColumns() {
        String[] expectedColumns = {
                "id", "email", "password", "first_name", "last_name", "phone", "image",
                "type", "created_at", "modified_at", "zone_id", "church_id", "country_id", "active"
        };

        List<Map<String, Object>> mapList = DBUtils.getQueryResultListOfMaps("""
            SELECT COLUMN_NAME
            FROM INFORMATION_SCHEMA.COLUMNS
            WHERE TABLE_NAME = 'tbl_user';""");

        List<String> actualColumns = new ArrayList<>();
        for (Map<String, Object> map : mapList) {
            actualColumns.add(map.get("COLUMN_NAME").toString());
        }

        for (String expectedColumn : expectedColumns) {
            Assert.assertTrue("Column '" + expectedColumn + "' is missing in the database",
                    actualColumns.contains(expectedColumn));
        }
    }


    }

