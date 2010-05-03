package net.azib.java.lessons.gui;

import java.beans.XMLEncoder;

/**
 * XMLEncoderDemo
 *
 * @author anton
 */
public class XMLEncoderDemo {
	public static void main(String[] args) {
		CommentBean bean = new CommentBean();
		bean.setComment("Hello World!");
		XMLEncoder encoder = new XMLEncoder(System.out);
		encoder.writeObject(bean);
		encoder.flush();
	}
}
