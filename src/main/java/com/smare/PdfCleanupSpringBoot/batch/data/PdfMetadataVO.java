package com.smare.PdfCleanupSpringBoot.batch.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PdfMetadataVO {

	private String filename;

	private String isbn;

	private String author;

	private String title;

	private String subject;

	private String[] keywords;

	public PdfMetadataVO() {
		super();
	}

	public PdfMetadataVO(String filename, String isbn, String author, String title, String subject, String[] keywords) {
		super();
		this.filename = filename;
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.subject = subject;
		this.keywords = keywords;
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename
	 *            the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn
	 *            the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the keywords
	 */
	public String[] getKeywords() {
		return keywords;
	}

	public String getKeywordsString() {
		StringBuilder keywordsString = new StringBuilder().append("\"keywords\": [");
		if (this.keywords != null) {
			for (String keyword : keywords) {
				keywordsString.append("\"").append(keyword).append("\",");
			}
			keywordsString.deleteCharAt(keywordsString.length() - 1);
		}
		keywordsString.append("]");
		return keywordsString.toString();
	}

	/**
	 * @param keywords
	 *            the keywords to set
	 */
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return new StringBuilder().append("{ \"").append(this.getClass().getSimpleName())
				.append("\": { \"filename\": \"").append(this.filename).append("\",").append(" \"isbn\": \"")
				.append(this.isbn).append("\",").append(" \"author\": \"").append(this.author).append("\",")
				.append(" \"title\": \"").append(this.title).append("\",").append(" \"subject\": \"")
				.append(this.subject).append("\",").append(this.getKeywordsString()).append(" } }").toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof PdfMetadataVO)) {
			return false;
		}
		PdfMetadataVO pdfMetadataVO = (PdfMetadataVO) obj;
		Set<String> set1 = new HashSet<String>(Arrays.asList(pdfMetadataVO.keywords));
		Set<String> set2 = new HashSet<String>(Arrays.asList(this.keywords));
		return pdfMetadataVO.filename.equals(this.filename) && pdfMetadataVO.isbn.equals(this.isbn)
				&& pdfMetadataVO.author.equals(this.author) && pdfMetadataVO.title.equals(this.title)
				&& pdfMetadataVO.subject.equals(this.subject) && set1.equals(set2);

	}

}
