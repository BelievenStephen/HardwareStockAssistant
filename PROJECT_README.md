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


## Part D: About Page Navigation (cont'd)
- **Prompt**: Add an “About” page to the application to describe the automotive parts shop and include navigation.
- **File**: ****`mainscreen.html`****
  - Added navigation bar with links to Home and About pages (lines 20-35).
- **File**: `about.html`
  - Created About page with company information and navigation bar (lines 10-30).
  - Added back link to Main Screen at the bottom of the page content (line 40).
- **File**: `AboutController.java`
  - Created new controller for About page to handle navigation (lines 5-12).


## Part E: Populate with Sample Inventory
- **Prompt**: Add a sample inventory appropriate for the automotive parts store to the application, ensuring five parts and five products in the sample inventory without overwriting existing data.
- **File**: BootStrapData.java
- **Lines Added**: Approx. 40-76 
- **Description**: Updated run method in BootStrapData to check if the partRepository and productRepository are empty before populating them with sample data. Added logic to create and save five parts and five products, each with a unique name, inventory, and price, to the database to represent a sample inventory for "AutoParts Central". This ensures the application starts with a default set of inventory relevant to the store's theme.


## Part F: Implement 'Buy Now' Button for Products
- **Prompt**: Implement a "Buy Now" button for each product listed on the main screen, decrementing the product inventory by one upon each purchase and displaying a success or error message accordingly.
- **Files**:
  - `AddProductController.java`: Added `buyProduct` method to process the purchase action.
  - `mainscreen.html`: Inserted form submission for "Buy Now" button within the product listing loop and message display elements for feedback.
- **Key Changes**:
  - Created a new `buyProduct` method within `AddProductController.java` to handle POST requests from the "Buy Now" button, decrement inventory, and add flash attributes for displaying messages (137-156).
  - Updated `mainscreen.html` to include form elements enabling the submission of the product ID to the new controller method. Incorporated Thymeleaf conditions to render success or error feedback messages based on the presence of flash attributes (36-37 & 105-108).
Testing confirmed that inventory decrement and message display functionalities are working.


## Step G: Implementing Inventory Minimum and Maximum Tracking
- **Prompt**: Modify the parts to track maximum and minimum inventory by doing the following:
  •  Add additional fields to the part entity for maximum and minimum inventory.
  •  Modify the sample inventory to include the maximum and minimum fields.
  •  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
  •  Rename the file the persistent storage is saved to.
  •  Modify the code to enforce that the inventory is between or at the minimum and maximum value.
### Summary of Changes
Implemented functionality to track minimum and maximum inventory levels for parts, updated forms to allow setting these values, enforced inventory constraints, and ensured persistent storage file renaming.
### Detailed Changes
- **Part.java**
  - Added fields for minInv and maxInv, including getters and setters (Lines 32-36, 100-114).
  - Implemented method `isInventoryValid` to enforce inventory constraints (Lines 117-119).
- **application.properties**
  - Updated datasource URL to reflect new database file name (Line 6).
  - Adjusted Hibernate DDL auto configuration (Line 14).
- **InhousePartForm.html and OutsourcedPartForm.html**
  - Updated forms to include inputs for minInv and maxInv. Adjustments made to enhance form validation and user feedback (Lines 15-16, 21, 27-46 for InhousePartForm.html; Lines 22, 31, 39-46 for OutsourcedPartForm.html).
- **BootStrapData.java**
  - Modified sample inventory data to include minInv and maxInv for parts (Lines 53-56, 63-66, 74, 85-86).
- **Controller Changes**
  - Updated `AddInhousePartController.java` and `AddOutsourcedPartController.java` to validate inventory against min/max constraints before saving (Lines 40-54 in AddInhousePartController.java; Lines 41-52 in AddOutsourcedPartController.java).
These changes collectively ensure that inventory levels for parts are tracked within specified minimum and maximum limits, improving the inventory management capabilities of our application.


## Step H: Validations for between, maximum and minimum fields.
- **Prompt**: Add validation for between or at the maximum and minimum fields.
### Summary of Changes
Implemented functionality to display error messages for
### Detailed Changes
- **Part.java**
  - Added validation for low inventory when adding or updating the parts (Lines 54-56, 98-100).
  - Added validation for low inventory when adding or updating the products (Lines 112-116).
  - Added validation if inventory is greater than maximum when adding or updating the parts (Lines 57-59, 101-103).