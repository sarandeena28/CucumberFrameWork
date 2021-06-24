Feature: Login to Pepperfry Add chair and table 

Scenario Outline: Tc001:Add Chair and table to whislist, Take Screenshot of order summary
When Mouseover on Furniture 
When click Office Chairs under Chairs
When click Executive Chairs
When Change the minimum Height as <Dimension> in under Dimensions
When Add Buff High Back Executive Chair In Brown Colour chair to Wishlist
When Mouseover on Bedroom 
When Click Study tables Under Tabels
When Select Spacewood as Brand
When Select Price as 7000 to 8000
When Add Winner Hutch Table In Rigato Walnut Finish to Wishlist
Then Verify the number of items in Wishlist
When Navigate to Wishlist
When Move Table to Cart from Wishlist
When Click Proceed to Pay Securely
Then Enter Pincode as <Pincode> in Delivery & Assembly Details 
When click Go
When Click Place Order
When  Capture a screenshot by Clicking on Order Summary

Examples:
|Dimension|Pincode|
|'50'|'600028'|