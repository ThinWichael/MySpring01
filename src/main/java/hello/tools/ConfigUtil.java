package hello.tools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ConfigUtil {
	File file;

	DocumentBuilderFactory documentBuilderFactory;
	DocumentBuilder documentBuilder;
	Document document;

	public ConfigUtil(String path) {
		file = new File(path);
		setUp();
	}

	public void setUp() {
		documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(file);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getString(String s) {
		String[] strs = s.split("\\.");
		if (strs.length == 1)
			return document.getElementsByTagName(s).item(0).getTextContent();

		return getNestedString(strs);
	}

	public Integer getInteger(String s) {
		String[] strs = s.split("\\.");
		if (strs.length == 1)
			return Integer.parseInt(document.getElementsByTagName(s).item(0).getTextContent());

		return Integer.parseInt(getNestedString(strs));
	}

	public List<String> getArrayList(String s) {
		String[] strs = s.split("\\.");

		List<String> list = new ArrayList<>();

		String[] ss;
		if (strs.length == 1) {
			ss = document.getElementsByTagName(s).item(0).getTextContent().split(",");
		} else {
			ss = getNestedString(strs).split(",");
		}

		for (String str : ss) {
			list.add(str);
		}
		return list;

	}

	private String getNestedString(String[] strs) {
		NodeList nodelist = document.getElementsByTagName(strs[0]);
		if(nodelist.getLength() > 1) {
			try {
			throw new Exception("duplicated tag name");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	    }
		
		Element curr = (Element) nodelist.item(0);
		int i = 1;
		while (i < strs.length) {
			curr = (Element) curr.getElementsByTagName(strs[i]).item(0);
			i++;
		}
		return curr.getTextContent();
	}

}
