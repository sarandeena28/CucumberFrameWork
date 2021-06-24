Feature: Adding an item to a shopping Bag in Nykaa Application

Scenario Outline: Tc001:Verifying the title of the product
When Mouseover on the Brand
When Mouseover on the Popular
When Click the L'oreal Paris
Then verify new window opened
Then Verify title contains L'oreal Paris
When click sort by customer top rated
Then verify the sorted product
When click category
Then verify whether it is expanded
When click Shampoo
Then Verify the filter is applied with shampoo
When click on Loreal Paris colour protect Shampoo
Then Verify new windows opened
And Select size as 175ml in the new window
And Print the Mrp of the product
When click on Add to Bag
Then verify the bag
When click the shopping bag
Then Print the grand total
When click proceed
Then verify the login page
When click on continue Guest
Given Enter the Name as <name>
And Enter th Email as <Email>
And Enter the Phone number as<phonenumber>
And Enter Pincode as <pincode>
And Enter Address as <address>
When Click Submit
Then Verify Payment page
And Verify the warning Message

Examples:
|name|Email|phonenumber|pincode|address|
|'Sara'|'sara28@gmail.com'|'9884289656'|'612702'|'Sw 34th Chennai'|

  	
