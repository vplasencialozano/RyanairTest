
Feature: Test Ryanair Page

Scenario: scenario description
Given I make a booking from <from> to <to> on <date> for <numAdult> adults and <numChild> child
When I pay for booking with card details “5555 5555 5555 5557”, “10/18” and “265”
Then I should get payment declined message


Examples:
| from | to  | date       | numAdult | numChild |
| DUB  | SXF | 12/03/2017 | 2        | 1        |