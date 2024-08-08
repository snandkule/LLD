# Exercise: Document Generation System

## Problem Statement

You are tasked with designing a document generation system that can produce different types of documents such as reports, invoices, and letters. The structure of these documents has a lot in common (e.g., header, content, footer), but the specifics vary depending on the type of document.

## Requirements

1. **Document Structure:**
    - All documents share a common structure:
        - **Header**: Contains the title and date of creation.
        - **Content**: The main body of the document, which varies depending on the type.
        - **Footer**: Contains additional notes or disclaimers.

2. **Different Document Types:**
    - **Report**: Includes a summary at the top and detailed analysis in the content section.
    - **Invoice**: Lists items/services with their prices in the content section and includes payment instructions in the footer.
    - **Letter**: Has an opening greeting, body, and closing remarks in the content section.

3. **Implementation Details:**
    - Use the Template Method design pattern to implement the common document structure and allow subclasses to define specific behaviors for different document types.
    - The common steps (e.g., generating the header and footer) should be defined in the base class, while the variable steps (e.g., generating the content) should be implemented in the subclasses.

4. **Extension (Optional):**
    - Add a feature that allows optional customization of the header or footer (e.g., adding a company logo in the header or an additional signature in the footer).
    - Implement the ability to generate documents in different formats (e.g., plain text, HTML, or PDF).

## Challenge
- Ensure that the design is flexible and can easily accommodate new types of documents or changes in the structure without modifying the base class.
- Demonstrate the functionality by generating a sample report, invoice, and letter, showing the output for each.
