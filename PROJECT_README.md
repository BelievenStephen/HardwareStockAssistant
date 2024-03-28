WESTERN GOVERNOR UNIVERSITY
D287 – JAVA FRAMEWORKS
Student ID: 011854349

# Project Documentation - Inventory Management System Customization

## Introduction
This project customizes a Spring application for retail inventory management, adapting its HTML and Java components to a specific business's needs. The focus is on a company selling composite products, necessitating a comprehensive inventory system. Key enhancements include improved UI, purchase functionality, and inventory validation. This document outlines the modifications made per project requirements.


## Commits:

## Repository Setup
- **File Created**: `PROJECT_README.md`
- **Description**: Initialized the project documentation file to track changes made for each part of the project (Parts C to J).

## Part C: Customize HTML User Interface
- **Prompt**: Customize the HTML user interface for the customer's application to include the shop name, the product names, and the names of the parts.
- **File Modified**: `mainscreen.html`
- **Lines Modified**:
  - Title changed from "My Bicycle Shop" to "AutoParts Central" (line 10)
  - Headers updated to "Vehicle Parts" and "Vehicle Maintenance Kits" (lines 23, 64)
  - Labels and placeholders for filters updated (lines 27, 66)
  - Button text updated to "Add Inhouse Part" and "Add Outsourced Part" (lines 33, 35)
  - Table headers updated to "Part Name," "Unit Price," etc. (lines 39, 80)
- **Description**: Updated titles, headers, labels, placeholders, and button text to align with the theme of an Automotive Parts Shop.

## Part D: Add an "About" Page
- **Prompt**: Add an “About” page to the application to describe the automotive parts shop and include navigation.
- **File Created**: `AboutController.java`
- **Location**: `src/main/java/com/example/demo/controllers`
- **Lines Added**: 1-9
- **Description**: Created AboutController within the `controllers` package to manage GET requests for the `/about` URL and render the `about.html` template. This allows users to access and view the About page which contains information about the automotive parts shop.

