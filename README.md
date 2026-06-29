# 📈 Stock Trading Platform

A console-based Stock Trading Platform developed in Java using Object-Oriented Programming (OOP) concepts. This project simulates a basic stock market environment where users can buy and sell stocks, manage their portfolio, and track transaction history.

## 🚀 Features

- Display available stocks and market prices
- Buy stocks
- Sell stocks
- View portfolio holdings
- Track profit/loss
- View transaction history
- Menu-driven console application
- Object-Oriented Design

## 🛠️ Technologies Used

- Java
- OOP Concepts
- Collections Framework
  - ArrayList
  - HashMap
- Exception Handling
- Scanner Class

## 📂 Project Structure

```
StockTradingPlatform/
│
├── Stock.java
├── User.java
├── Portfolio.java
├── Transaction.java
└── StockTradingPlatform.java
```

## 📋 Class Diagram

```
User
  │
  ▼
Portfolio
  ├── Holdings (HashMap)
  └── Transactions (ArrayList)
           │
           ▼
      Transaction

Stock
```

## ⚡ Features Implemented

### Market Data Display

```
AAPL   : 180
TSLA   : 800
GOOGL  : 2500
MSFT   : 320
```

### Buy Stock

```
Enter Stock: AAPL
Quantity: 10

Purchased Successfully
```

### Sell Stock

```
Enter Stock: AAPL
Quantity: 5

Sold Successfully
```

### Portfolio Tracking

```
===== PORTFOLIO =====
AAPL Qty:5 Value:900
TSLA Qty:2 Value:1600

Current Value = 2500
Invested Value = 2200
Profit/Loss = 300
```

### Transaction History

```
BUY : AAPL Qty=10 Price=180
SELL : AAPL Qty=5 Price=180
```

## ▶️ How to Run

Compile the program:

```bash
javac *.java
```

Run the application:

```bash
java StockTradingPlatform
```

## 🎯 Concepts Demonstrated

- Classes and Objects
- Encapsulation
- Constructors
- Collections Framework
- HashMap
- ArrayList
- Method Overriding
- OOP Design
- Transaction Management

## 🔮 Future Enhancements

- PostgreSQL Database Integration
- JDBC Connectivity
- File Persistence
- Spring Boot REST API
- Java Swing GUI
- Real-time Stock Price Simulation

## 👨‍💻 Author

**Yash Dharmik**

GitHub: https://github.com/YashDharmik278

