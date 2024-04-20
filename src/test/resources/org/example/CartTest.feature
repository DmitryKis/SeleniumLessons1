@Cart
Feature: Cart functional

  Scenario: Add and remove from Cart
    When Go to Main Page
    When Add 3 popular product in cart
    Then Go to Cart Page
    Then Remove all products from Cart