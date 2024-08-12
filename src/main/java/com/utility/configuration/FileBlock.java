package com.utility.configuration.data.model;

import java.util.ArrayList;
import java.util.List;
import static com.utility.configuration.util.StringUtils.*;

public class FileBlock {
	
	String head,rear;
	List<String> content = new ArrayList<>();
	
	public FileBlock( char [] block ) {
		var open =indexOf(block,"<employee>".toCharArray());
		var firstClose =indexOf(block,"</employee>".toCharArray());
		
		if( open > firstClose ) {
			head = subStringBefore(block, open);
		}
		
		var close = indexOf(block,"</employee>".toCharArray(), open);
		StringBuilder contentBuffer = new StringBuilder();
		while( open >= 0 && close > open ) {
			for( var i=open;i<close + "</employee>".toCharArray().length; i++ ) {
				contentBuffer.append(block[i]);
			}
			content.add(contentBuffer.toString());
			contentBuffer.delete(0, contentBuffer.length());
			open = indexOf(block,"<employee>".toCharArray(),close);
			if( open > -1 ) {
				close = indexOf(block,"</employee>".toCharArray(),open);
			}
		}
		if( open > 0 ) {
			rear = subStringAfter(block, open);
		}
	}
	
	public List<String> getContent() {
		return content;
	}
	
	public String getHead() {
		return head;
	}
	
	public String getRear() {
		return rear;
	}
}
