WESTERN GOVERNOR UNIVERSITY
D287 – JAVA FRAMEWORKS
Student ID: 011854349

# Project Documentation - Inventory Management System Customization

## Introduction
This project customizes a Spring application for retail inventory management, adapting its HTML and Java components to a specific business's needs. The focus is on a company selling composite products, necessitating a comprehensive inventory system. Key enhancements include improved UI, purchase functionality, and inventory validation. This document outlines the modifications made per project requirements.


## Commits:

## PART B: 
- **Prompt**: Create a README file that includes notes describing where in the code to find the changes you made for each of parts C to J. Each note should include the prompt, file name, line number, and change.
- **File Created**: `COMMIT_README.md`
- **Description**: Initialized the project documentation file to track changes made for each part of the project.

## PART C: 
- **Prompt**: Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
- **File Modified**: `mainscreen.html`
- **Lines Modified**: 14 & 19
- **Description**: Updated the title & h1 to "Tech Central" on line.

## PART D: 
- **Prompt**: Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
- **File Modified**: 
  - `about.html`: Created About page with company information and mainscreen navigation button. All lines in file
  - `mainscreen.html`: Added navigation button to About page on line 20.
  - `MainScreenController.java`: Added `@GetMapping` for the "/about" endpoint to serve the About page on lines 33-37.

## PART E:
- **Prompt**: Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.
- **File Modified**:
  - BootstrapData.java: Added an if statement (Lines 64-109) to add sample inventory when both the part and product lists are both empty
  - InhousePart.java: Added a constructor (Lines 20-24) to handle creation of InhousePart with specific ID.

## PART F:
- **Prompt**: Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
  •  The “Buy Now” button must be next to the buttons that update and delete products.
  •  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
  •  Display a message that indicates the success or failure of a purchase.
- **File Modified**:
  - mainscreen.html:
    - Lines 86-89: Added "Buy Now" button allowing users to purchase products.
    - Lines 20-23: Inserted div for displaying success and error messages to give feedback after purchase attempts.
  - MainScreenController.java:
    - Lines 68-81: Added `@PostMapping` method buyProduct to handle product purchase requests. Included logic to decrement product inventory, check stock availability, and use RedirectAttributes to pass success or error messages to the view.