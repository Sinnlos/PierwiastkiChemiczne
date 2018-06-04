Scenario: Open testowe repository on Github

Given user is on github page of Sinnlos
When user clicks the testowe link
Then the link with text src should be displayed


Scenario: Open src folder

Given user is on repository page
When user clicks the src link
Then the link with text main should be displayed

Scenario: open main folder

Given user is in src folder
When user clicks the main link
Then the link with text java should be displayed

Scenario: Open java folder

Given user is in main folder
When user clicks the java link
Then the link with text Pierwiastek.java should be displayed

Scenario: open Pierwiastek class

Given user is in java folder
When user clicks the Pierwiastek.java link
Then the article Pierwiastek is displayed
