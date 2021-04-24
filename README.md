# spring-boot-h2-demo
A spring boot demo with h2 in memory database


# Scenarios for tech test

        As an application, I want to be able to perform all CRUD operations on Customer Entity
        
        Background:
                      
             Given the following customer exists
            
                       |id | Organization Name  | First Name | Last Name | Net Worth   |
                       | 1 |Tesco               |Jon         |White      | 10000       |
                       | 2 |M&S                 |Terry       |Red        | 10000       |
                       | 3 |British Airways     |Mike        |White      | 1000000     |
                       | 4 |Google              |Larry       |Page       | 100000      |
                       | 5 |Amazon              |Jeff        |Besoz      | 1000000     |
                       | 6 |Microsoft           |Bill        |Gates      | 100000      |
                       | 7 |Tesla               |Elon        |Musk       | 1000000     |
                       | 8 |Apple               |Tim         |Cook       | 1000000     |
        
        Scenario Outline: Create Customer 
            Given The customer application is up and running
            When I send HTTP POST request to "/api/customers/" with  in request body
            Then I receive a valid HTTP code of "201" with  in response body
        Examples:
            | customerJson                                                                                                | 
            | {"id": 121, "firstName" : "Joe", "lastName" : "Bloggs", "organizationName" : "JoeBloggs", "netWorth" : 100} |
            
         Scenario Outline: Read  All Customers 
             Given The customer application is up and running
             When I send HTTP GET request to "/api/customers/" 
             Then I receive a valid HTTP code of "200"
         
         Scenario Outline: Read  Customer By Id 
             Given The customer application is up and running
             When I send HTTP GET request to "/api/customers/121" 
             Then I receive a valid HTTP code of "200" and  in response body
         Examples:
             | customerJson                                                                                                | 
             | {"id": 121, "firstName" : "Joe", "lastName" : "Bloggs", "organizationName" : "JoeBloggs", "netWorth" : 100} |
             
         Scenario Outline: Update Customer 
             Given The customer application is up and running
             When I send HTTP PUT request to "/api/customers/" with  in JSON
             Then I receive a valid HTTP code of "200" with  in response body
         Examples:
             | customerJson                                                                                                | 
             | {"id": 121, "firstName" : "Joe", "lastName" : "Bloggs", "organizationName" : "JoeBloggs", "netWorth" : 200} |
             
          Scenario Outline: Delete Customer By Id 
               Given The customer application is up and running
               When I send HTTP DELETE request to "/api/customers/121" 
               Then I receive a valid HTTP code of "200"
