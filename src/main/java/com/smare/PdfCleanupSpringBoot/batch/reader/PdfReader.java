/**
 * 
 */
package com.smare.PdfCleanupSpringBoot.batch.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

/**
 * @author clark.westfield
 *
 */
public class PdfReader<T> implements ItemReader<T> {

	List<T> items;

    public PdfReader(List<T> items) {
        this.items = items;
    }
	
	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemReader#read()
	 */
	@Override
	public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		return null;
	}

}
