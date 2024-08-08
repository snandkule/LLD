# Exercise: Stock Market Ticker System

## Problem Statement:

You are designing a stock market ticker system that tracks stock prices in real-time. The system should allow various clients (observers) to subscribe to specific stock updates. Whenever the price of a stock changes, all subscribed clients should be notified automatically.

## Requirements:

1. **Stock Market (Subject):**
    - The stock market system maintains a list of stocks, each with a unique ticker symbol (e.g., AAPL, GOOG, TSLA) and a price.
    - The system should allow clients (observers) to subscribe to updates for specific stocks.
    - When the price of a stock changes, the system should notify all clients subscribed to that stock.

2. **Clients (Observers):**
    - Implement different types of clients that might be interested in stock updates, such as:
        - **Investor Client**: Monitors specific stocks in their portfolio and displays the latest prices.
        - **News Agency Client**: Tracks large movements in stock prices and generates news alerts.
        - **Analytics Client**: Collects stock price data for statistical analysis and trend prediction.
    - Each client should automatically update its display or perform its function when notified of a price change.

3. **Implementation Details:**
    - Use the Observer design pattern to manage the communication between the stock market and the clients.
    - Clients should be able to subscribe to multiple stocks and receive updates for each one independently.
    - Clients should also be able to unsubscribe from updates if they are no longer interested.

4. **Extension (Optional):**
    - Implement a feature that allows clients to set price thresholds for notifications (e.g., notify only if a stock price increases by more than 5%).
    - Add support for push notifications, where clients receive a notification only if a certain condition is met (e.g., a stock hits an all-time high).

## Challenge:
- Ensure that the system is scalable, allowing many clients to subscribe to updates for many different stocks without performance degradation.
- Demonstrate the functionality by implementing a simulation where stock prices are updated in real-time, and clients receive updates accordingly.
