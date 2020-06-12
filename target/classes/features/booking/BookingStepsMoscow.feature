Feature: Hotel search in Moscow
Scenario: Find the hotel with the lowest cost in Moscow

Given I open website booking.com
Then I fill necessary fields such as country, check in, check out
And I use actions to enter adults and rooms
Then I filter hotels at the minimum price
And I'm looking hotel with minimum price
And I compare hotel's price and price in filters