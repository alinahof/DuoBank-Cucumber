
@API
  Feature: I want to verify the Get/Application feature works properly with JWT token

#    API US 9. Test Case 1: Get User details valid JWT\
    Scenario: Retrieve a single user with valid JWT token

      Given the request is authenticated with a valid API key
      And the request "Content-type" header is set to "application/json"
      And the request "Authorization" header is set to "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9sb2NhbGhvc3RcL2xvYW5cL2FwaSIsImF1ZCI6Imh0dHA6XC9cL2xvY2FsaG9zdFwvbG9hblwvYXBpIiwiaWF0IjoxNjkzMDc3MzY3LCJleHAiOjE2OTMwODA5NjcsImRhdGEiOnsidXNlcl9pZCI6IjExOTgiLCJ0eXBlIjoiMiJ9fQ.8UZ46BzCKsZfJfYJW0tphz0HDhnYT9bu--kIXQqmeBY"
      When I send a "GET" request to the endpoint "/applications"
      Then the response log should be displayed
      Then the response status code should be 200
      And the response "Content-Type" header should be "application/json; charset=UTF-8"
      And the response time should be less than 1000 ms


  @API
    Scenario: Invalid JWT token

      Given the request is authenticated with a valid API key
      And the request "Content-Type" header is set to "application/json"
      When I send a "GET" request to the endpoint "/applications"
      Then the response log should be displayed
      Then the response status code should be 403
      Then the response body should have "message" field with value "Invalid or missing JSON Web Token. Please log in with your credentials to obtain a valid JWT token and provide it in the 'Authorization' header of your request."

#    API US 9. Test Case 3: invalid API key
    Scenario: Invalid api key

      Given the request is not authenticated with a valid API key
      And the request "Content-Type" header is set to "application/json"
      When I send a "GET" request to the endpoint "/applications"
      Then the response log should be displayed
      Then the response status code should be 401
      Then the response body should have "message" field with value "Invalid or missing API Key. Provide a valid api key with 'api_key' query parameter."


#    API US 9. Test Case 4: Invalid mortgage id
    Scenario: Retrieve user with invalid mortgage ID
  Given the request is authenticated with a valid API key
      And the request "Authorization" header is set to "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9sb2NhbGhvc3RcL2xvYW5cL2FwaSIsImF1ZCI6Imh0dHA6XC9cL2xvY2FsaG9zdFwvbG9hblwvYXBpIiwiaWF0IjoxNjkzMDc3MzY3LCJleHAiOjE2OTMwODA5NjcsImRhdGEiOnsidXNlcl9pZCI6IjExOTgiLCJ0eXBlIjoiMiJ9fQ.8UZ46BzCKsZfJfYJW0tphz0HDhnYT9bu--kIXQqmeBY"
      And the request "Content-type" header is set to "application/json"
  When I send a "GET" request to the endpoint "/applications"
  Then the response log should be displayed
  Then the response status code should be 200
  And the response "Content-Type" header should be "application/json; charset=UTF-8"
  And the response time should be less than 1000 ms



#    API US 9. Test Case 5: Mortgage ID missing