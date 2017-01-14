/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.smare.PdfCleanupSpringBoot.batch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.OutputCapture;

import com.smare.PdfCleanupSpringBoot.batch.data.PdfMetadataVO;

public class PdfCleanupApplicationTests {

	private HashMap<String, Object> pdfMetadataValues;

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Before
	public void before() throws Exception {

		pdfMetadataValues = new HashMap<String, Object>();
		pdfMetadataValues.put("filename", "PDFBook.pdf");
		pdfMetadataValues.put("isbn", "123456789");
		pdfMetadataValues.put("author", "FirstName LastName");
		pdfMetadataValues.put("title", "PDF Book");
		pdfMetadataValues.put("subject", "Java development");
		pdfMetadataValues.put("keywords", new String[] { "PDF", "book", "test" });
	}

	@Test
	public void testDefaultSettings() throws Exception {
		assertEquals(0, SpringApplication.exit(SpringApplication.run(PdfCleanupApplication.class)));
		String output = this.outputCapture.toString();
		assertTrue("Wrong output: " + output, output.contains("completed with the following parameters"));
	}

	@Test
	public void testPdfMetadataVOToString() {
		PdfMetadataVO pdfMetadataVO = new PdfMetadataVO((String) pdfMetadataValues.get("filename"),
				(String) pdfMetadataValues.get("isbn"), (String) pdfMetadataValues.get("author"),
				(String) pdfMetadataValues.get("title"), (String) pdfMetadataValues.get("subject"),
				(String[]) pdfMetadataValues.get("keywords"));

		String expected = new StringBuilder().append("{ \"").append("PdfMetadataVO").append("\": { \"filename\": \"")
				.append((String) pdfMetadataValues.get("filename")).append("\",").append(" \"isbn\": \"")
				.append((String) pdfMetadataValues.get("isbn")).append("\",").append(" \"author\": \"")
				.append((String) pdfMetadataValues.get("author")).append("\",").append(" \"title\": \"")
				.append((String) pdfMetadataValues.get("title")).append("\",").append(" \"subject\": \"")
				.append((String) pdfMetadataValues.get("subject")).append("\",").append("\"keywords\": [\"")
				.append(StringUtils.join((String[]) pdfMetadataValues.get("keywords"), "\",\"")).append("\"]")
				.append(" } }").toString();

		System.out.printf("Checking equality against\n %s\n", expected);

		assertEquals(expected, pdfMetadataVO.toString());
	}

}
