# BDD Test Automation Framework

## Overview

This framework implements automated testing for:
- UI Testing: [Automation-Demo](https://automationintesting.online/#rooms) Hotel-Booking website using BDD with Selenium WebDriver

## Prerequisites

- JDK 11 or higher
- Maven 3.8.4 or higher
- Chrome browser for local testing
- Docker and Docker Compose (for remote execution)

## Test Execution

### Local Execution

Run all tests:
```bash
mvn clean verify
```

Run specific test types:
```bash
# UI tests only
mvn clean verify -Dcucumber.filter.tags="@UI"

# Smoke tests
mvn clean verify -Dcucumber.filter.tags="@Smoke"

# Regression tests
mvn clean verify -Dcucumber.filter.tags="@Regression"
```

## Test Reports

Serenity generates HTML reports after test execution:

Location: `target/surefire-reports/emailable-report.html`


## Test Categories (Tags)

- `@UI`: UI tests for Automation-Demo
- `@Smoke`: Critical path tests
- `@Regression`: Full regression suite

## Configuration

### Local Execution Defaults
- Default browser: Chrome
- Headless mode: Enabled


## Troubleshooting

### Common Issues

1. Local Execution
    - Verify browser driver versions
    - Check browser compatibility
    - Validate test user credentials

2. Report Generation
    - Clear target directory: `mvn clean`
    - Verify disk space
    - Check file permissions

### Debugging Tips
- Verify environment variables
- Review Sunfire reports for failure details
