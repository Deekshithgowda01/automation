Feature: datepicker

  Scenario Outline: To validate date picker jquery
    Given when user launch the browser using url "https://jqueryui.com/datepicker/#default"
    When when user click on datepicker
    And select month <mon> and date <da>
    Then validte the exact date is fetched
  Examples:
    |mon|da|
    |September|26|
    |August     |1 |
    |May      |1 |