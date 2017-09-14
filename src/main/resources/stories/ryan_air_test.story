
Feature: Test Ryanair Page

Scenario Outline: I want to test the error message when credit card number is wrong

Given I make a booking from <from> to <to> on <date> for <numAdult> adults and <numChild> child
When I pay for booking with card details <cardNumber> month <month> year <year> cvs <cvs>
Then I should get payment declined message <message>


Examples:
| from | to  | date       | numAdult | numChild | cardNumber          | month | year | cvs | message                |
| DUB  | SXF | 23/12/2017 | 2        | 1        | 5555 5555 5555 5558 | 10    | 2018 | 265 | Card number is invalid |