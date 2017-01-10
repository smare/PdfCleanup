# PdfCleanup

  **PdfCleanup** is an application that automatically updates the metadata associated with a PDF using data sourced from Amazon.  It is intended to ensure that books published in PDF format have accurate metadata to be used by enterprise search applications - essentially optimizing PDFs for search.  
  **PdfCleanup** parses PDF files looking for an ISBN number.  When found, it constructs an Amazon *product advertising API* REST request using the ISBN number to retrieve the following information about the publication:
- Author
- Title
- Subject
- Keywords
The application then writes the values to the PDF's metadata fields.

## Getting Started
  **PdfCleanup** is a Spring Batch application configured with Spring Boot, utilizing iText for manipulating PDF files.  It uses Maven to manage dependencies, build, test and deployment.