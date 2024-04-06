WESTERN GOVERNOR UNIVERSITY
D287 – JAVA FRAMEWORKS
Student ID: 011854349

# Project Documentation - Inventory Management System Customization

## Introduction
This project customizes a Spring application for retail inventory management, adapting its HTML and Java components to a specific business's needs. The focus is on a company selling composite products, necessitating a comprehensive inventory system. Key enhancements include improved UI, purchase functionality, and inventory validation. This document outlines the modifications made per project requirements.


## Commits:

## PART B: 
- **Prompt**: Create a README file that includes notes describing where in the code to find the changes you made for each of parts C to J. Each note should include the prompt, file name, line number, and change.
- **File(s) Created**: `COMMIT_README.md`
- **Description**: Initialized the project documentation file to track changes made for each part of the project.

## PART C: 
- **Prompt**: Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
- **File(s) Modified**: `mainscreen.html`
- **Lines Modified**: 14 & 19
- **Description**: Updated the title & h1 to "Tech Central" on line.

## PART D: 
- **Prompt**: Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
- **File(s) Modified**: 
  - `about.html`: Created About page with company information and mainscreen navigation button. All lines in file
  - `mainscreen.html`: Added navigation button to About page on line 20.
  - `MainScreenController.java`: Added `@GetMapping` for the "/about" endpoint to serve the About page on lines 33-37.

## PART E:
- **Prompt**: Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.
- **File(s) Modified**:
  - `BootstrapData.java`: Added an if statement (Lines 64-109) to add sample inventory when both the part and product lists are both empty
  - `InhousePart.java`: Added a constructor (Lines 20-24) to handle creation of InhousePart with specific ID.

## PART F:
- **Prompt**: Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
  •  The “Buy Now” button must be next to the buttons that update and delete products.
  •  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
  •  Display a message that indicates the success or failure of a purchase.
- **File(s) Modified**:
  - `mainscreen.html`:
    - Lines 86-89: Added "Buy Now" button allowing users to purchase products.
    - Lines 20-23: Inserted div for displaying success and error messages to give feedback after purchase attempts.
  - `MainScreenController.java`:
    - Lines 68-81: Added @PostMapping method buyProduct to handle product purchase requests. Included logic to decrement product inventory, check stock availability, and use RedirectAttributes to pass success or error messages to the view.

## PART G:
- **Prompt**: Modify the parts to track maximum and minimum inventory by doing the following:
  •  Add additional fields to the part entity for maximum and minimum inventory.
  •  Modify the sample inventory to include the maximum and minimum fields.
  •  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
  •  Rename the file the persistent storage is saved to.
  •  Modify the code to enforce that the inventory is between or at the minimum and maximum value.
- **File(s) Modified**:
  - `Part.java` (Lines 31-34): Added fields for min & maxInv to track minimum and maximum inventory levels. (Lines 98-113) Added corresponding getters and setters. (Lines 48-49) Updated constructor to include `minInv` & `maxInv` values.
  - `InhousePart.java` (Lines 20-21): Updated InhousePart to include minimum and maximum inventory levels.
  - `BootStrapData.java` (Lines 66-74): Updated constructor parameters for `InhousePart` objects to include minimum and maximum inventory levels.
  - `InhousePartForm.html` (Lines 23-28): Added input fields for Min & Max inventory levels in the form for Inhouse parts.
  - `AddInhousePartController.java` (Lines 46-56): Modified `submitForm` method to validate that inventory is within min & max bounds. If inventory is outside these bounds, generating an error if not.
  - `OutsourcedPartForm.html` (Lines 24-30): Added input fields for Min & Max inventory levels in the form for Outsourced parts.
  - `AddOutsourcedPartController.java` (Lines 43-55): Modified `submitForm` method to check inventory is within min & max, generating an error if not.
  - `application.properties` (Line 6): Updated the database URL after renaming the database file to reflect the new name.

## PART H:
- **Prompt**: Add validation for between or at the maximum and minimum fields. The validation must include the following:
  •  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
  •  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
  •  Display error messages when adding and updating parts if the inventory is greater than the maximum.
- **File(s) Modified**: `EnufPartsValidator.java`:
  - Added import for ApplicationContextAware (Line 8).
  - Implemented ApplicationContextAware for direct access to Spring app context (Lines 13-18).
  - Updated isValid to check if there are enough parts to update product and display an error message (Lines 23-43).
  - Adjusted setApplicationContext method to be non-static (Lines 17-18).