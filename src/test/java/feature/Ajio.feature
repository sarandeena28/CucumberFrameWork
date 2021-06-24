Feature: Open Ajio Application

Scenario: Tc001:Finding the link having lowercase and sort item by discount
When Mouse over on Women 
When Mouse over on Brands
Then Verify list of brands gets loaded
When Click the link that has most number of lower case characters
Then Verify New Page Loaded
And  Print and store number of items
When Click Size and Fit 
Then Verify its get expanded
When select the Size S
Then Confirm the number of items have reduced thean the  previous results
When Click Sort by  Discount
Then confirm results are sorted  by higher discounts first
