# String Calculator using TDD

This is a small Java project where I created a string calculator by following Test Driven Development (TDD) approach. I did this as an interview assignment and to improve my Java + testing skills.

## What it does

- If I pass an empty string, it gives 0
- It adds numbers given in string format, separated by commas like `"1,2"` = 3
- I also handled new line characters like `"1\n2,3"` = 6
- If any negative numbers are there, it throws an exception and shows them
- Numbers above 1000 are ignored
- Custom delimiter support is added like `"//;\n1;2"` will return 3
- Also added support for multiple delimiters like `"//[*][%]\n1*2%3"` = 6

## Tools I used

- Java 20
- IntelliJ IDEA
- JUnit 5
- Maven (for dependency and running tests)

## How to test it

You can just run the tests by clicking the green play icon near each `@Test` in IntelliJ.

Or if you're using terminal, you can run:

