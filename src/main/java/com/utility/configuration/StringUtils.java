package com.utility.configuration.util;

import com.utility.configuration.data.model.FileBlock;

public class StringUtils {
	
	public static String subStringBefore( char [] text, int index) {
		if( index > text.length) {
			return null;
		}
		StringBuilder content = new StringBuilder();
		for( var i = 0; i<index; i++ ) {
			content.append(text[i]);
		}
		return content.toString();
	}
	
	public static String subStringAfter( char [] text, int index) {
		if( index > text.length) {
			return null;
		}
		StringBuilder content = new StringBuilder();
		for( var i = index; i<text.length; i++ ) {
			content.append(text[i]);
		}
		return content.toString();
	}
	
	public static int indexOf( char [] text , char [] check, int offset ) {
		var i=offset;
		boolean status = false;
		for( ; i<text.length - check.length+1;i++ ) {
			for( var j=0;j<check.length;j++ ) {
				//System.out.println(text[i+j] + " - " + check[j]);
				if( text[i+j] != check[j] ) {
					status = false;
					break;
				} else {
					status = true;
				}
			}
			//System.out.println(status);
			if( status ) {
				break;
			}
		}
		return status ? i : -1;
	}
	
	public static int indexOf( char [] text , char [] check ) {
		return indexOf(text, check, 0);
	}
	
	public static int lastIndexOf( char [] text , char [] check ) {
		var i=text.length-check.length + 1;
		boolean status = false;
		for( ; i >= 0 ;i-- ) {
			for( var j=0;j<check.length;j++ ) {
				//System.out.println(text[i+j] + " - " + check[j]);
				if( text[i+j] != check[j] ) {
					status = false;
					break;
				} else {
					status = true;
				}
			}
			//System.out.println(status);
			if( status ) {
				break;
			}
		}
		return status ? i : -1;
	}
	
	public static String extractTag( char [] text , char [] tag, char [] closingTag ) {
		var start = indexOf(text, tag);
		var end = indexOf(text, closingTag);
		StringBuilder content = new StringBuilder();
		if( start < end ) {
			for( var i=start;i<end + closingTag.length; i++ ) {
				content.append(text[i]);
			}
		}
		return content.toString();
	}
	
	
	public static void main(String[] args) {
		char [] text = "M</sex></name></employee><employee><name>Abir<sex>M</sex></name></employee><employee><name>Mithu<sex>F</sex></name></employee><employee><name>Bornini</nam".toCharArray();
		char [] tag = "<employee>".toCharArray();
		char [] closingTag = "</employee>".toCharArray();
		//System.out.println( indexOfOpeningTag(text, tag) );
		//var closingIndex = indexOfOpeningTag(text, closingTag);
		//System.out.println( lastIndexOf(text, closingTag) );
		
		//System.out.println( subStringAfter(text, lastIndexOf(text, tag) ));
		//System.out.println( subStringBefore(text, lastIndexOf(text, closingTag) + 1) );
		
		//printArray(text, indexOf(text, tag), tag.length);
		//printArray(text, 5, closingTag.length);
		
		//System.out.println( extractTag(text, tag, closingTag) );
		//System.out.println( extractTag(text, "<name>".toCharArray(), "</name>".toCharArray()) );
		
		//System.out.println( subStringAfter(text, indexOf(text, tag) ));
		//System.out.println( subStringBefore(text, indexOf(text, closingTag) + 1) );
		var fBlock = new FileBlock(text);
		System.out.println(fBlock.getHead());
		fBlock.getContent().forEach(System.out :: println );
		System.out.println(fBlock.getRear());
	}
	
	public static void printArray( char [] arr, int start, int len) {
		for( int i=start;i < arr.length;i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

}
