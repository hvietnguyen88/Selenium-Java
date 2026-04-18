# Selenium-Java---AK2604

Automated browser testing framework using Selenium WebDriver with Java and TestNG.

## 📋 Overview

This project demonstrates automated web browser testing using Selenium WebDriver 4, Java, and TestNG. It includes test cases for opening browsers in both regular and headless modes, validating page content and URLs.

## 🛠️ Tech Stack

- **Language**: Java
- **Selenium WebDriver**: Browser automation
- **TestNG**: Test framework
- **Maven**: Build automation

## 📦 Prerequisites

- Java 8 or higher
- Maven 3.6+
- Chrome browser (for ChromeDriver)
- Edge browser (optional)

## 🚀 Getting Started

### Installation

1. Clone this repository:
```bash
git clone https://github.com/hvietnguyen88/Selenium-Java---AK2604.git
cd Selenium-Java---AK2604
```

2. Install dependencies:
```bash
mvn clean install
```

### Running Tests

Execute all tests:
```bash
mvn test
```

Run a specific test class:
```bash
mvn test -Dtest=OpenBrowserTest
```

## 📝 Test Cases

### testOpenBrowser
- Opens Chrome browser
- Navigates to https://www.selenium.dev/
- Verifies the current URL matches expected value

### openBrowserWithHeadlessMode
- Launches Chrome in headless mode (no UI)
- Navigates to https://www.selenium.dev/
- Validates the page title is "Selenium"

## 📂 Project Structure

```
src/
├── main/java/tvn/lt2602/
│   └── Main.java
├── test/java/heroku/
│   └── OpenBrowserTest.java
└── resources/
pom.xml
```

## 🔧 Configuration

Browser options can be customized in the test files. Headless mode is configured via ChromeOptions:
```java
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.addArguments("--headless=new");
```

## 📄 License

This project is for educational purposes.

## 👨‍💼 Author

hvietnguyen88

---
Last updated: April 18, 2026


