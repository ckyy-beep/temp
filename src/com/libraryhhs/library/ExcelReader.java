package com.libraryhhs.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.libraryhhs.item.Book;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    // Reads, creates and stores 'Book' objects into 'Library' catalog.
    public void readExcelFile(String fileName, String sheetName, ArrayList<Book> books) {

        try (Workbook workbook = new XSSFWorkbook(new File(fileName))) {
            Sheet sheet = workbook.getSheet(sheetName);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                DataFormatter formatter = new DataFormatter();
                String title = formatter.formatCellValue(currentRow.getCell(0));
                String author = formatter.formatCellValue(currentRow.getCell(1));
                String subtitle = formatter.formatCellValue(currentRow.getCell(2));
                String isbn = formatter.formatCellValue(currentRow.getCell(3));
                String publisher = formatter.formatCellValue(currentRow.getCell(4));
                String publicationYear = formatter.formatCellValue(currentRow.getCell(5));
                String publicationMonth = formatter.formatCellValue(currentRow.getCell(6));
                String publicationDay = formatter.formatCellValue(currentRow.getCell(7));
                String genre = formatter.formatCellValue(currentRow.getCell(8));
                String language = formatter.formatCellValue(currentRow.getCell(9));
                int inventory = (int) currentRow.getCell(10).getNumericCellValue();

//                System.out.println("Title            : " + title);
//                System.out.println("Author           : " + author);
//                System.out.println("Subtitle         : " + subtitle);
//                System.out.println("ISBN             : " + isbn);
//                System.out.println("Publisher        : " + publisher);
//                System.out.println("Publication Year : " + publicationYear);
//                System.out.println("Publication Month: " + publicationMonth);
//                System.out.println("Publication Day  : " + publicationDay);
//                System.out.println("Genre            : " + genre);
//                System.out.println("Language         : " + language);
//                System.out.println("Inventory        : " + inventory);
//                System.out.println();

                Book book = new Book(title, author, subtitle, isbn, publisher, publicationYear, publicationMonth, publicationDay, genre, language, inventory);
                books.add(book);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeExcelFile(String fileName, String sheetName, ArrayList<Book> books) {

        try (FileInputStream inputStream = new FileInputStream(fileName);
             Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheet(sheetName);
            int lastRowNum = sheet.getLastRowNum();

            for (Book book : books) {
                Row row = sheet.createRow(++lastRowNum);
                row.createCell(0).setCellValue(book.getTitle());
                row.createCell(1).setCellValue(book.getAuthor());
                row.createCell(2).setCellValue(book.getSubtitle());
                row.createCell(3).setCellValue(book.getIsbn());
                row.createCell(4).setCellValue(book.getPublisher());
                row.createCell(5).setCellValue(book.getPublicationYear());
                row.createCell(6).setCellValue(book.getPublicationMonth());
                row.createCell(7).setCellValue(book.getPublicationDay());
                row.createCell(8).setCellValue(book.getGenre());
                row.createCell(9).setCellValue(book.getLanguage());
                row.createCell(10).setCellValue(book.getInventory());
            }

            try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
                workbook.write(outputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}