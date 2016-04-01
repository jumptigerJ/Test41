package com.test.test3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class test03 {

	public static void main(String[] args) {
			new ReadByGet().start();

		}

	}
	class ReadByGet extends Thread{
		
		@Override
		public void run() {
			try {
		
				URL url = new URL("http://hq.sinajs.cn/list=sz300170");
				URLConnection connection = url.openConnection();
				InputStream is = connection.getInputStream();
				InputStreamReader isr = new InputStreamReader(is,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				String line;
				StringBuilder sb = new StringBuilder();
				while((line = br.readLine())!= null){
					sb.append(line);
				}
				br.close();
				isr.close();
				is.close();
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder  = factory.newDocumentBuilder();
				Document document = builder.newDocument();
				
				Element root = document.createElement("languages");
				root.setAttribute("cat", "it");
				
				Element lan1 = document.createElement("lan");
				lan1.setAttribute("id", "1");
				Element name1 = document.createElement("name");
				name1.setTextContent("Java");
				Element ide1 = document.createElement("ide");
				ide1.setTextContent("Eclipse");
				lan1.appendChild(name1);
				lan1.appendChild(ide1);
				
				Element lan2 = document.createElement("lan");
				lan2.setAttribute("id", "2");
				Element name2 = document.createElement("name");
				name2.setTextContent("Swift");
				Element ide2 = document.createElement("ide");
				ide2.setTextContent("Xcode");
				lan2.appendChild(name2);
				lan2.appendChild(ide2);
				
				Element lan3 = document.createElement("lan");
				lan3.setAttribute("id", "3");
				Element name3 = document.createElement("name");
				name3.setTextContent("c#");
				Element ide3 = document.createElement("ide");
				ide3.setTextContent("visual studio");
				lan3.appendChild(name3);
				lan3.appendChild(ide3);
				
				root.appendChild(lan1);
				root.appendChild(lan2);
				root.appendChild(lan3);
				document.appendChild(root);
				
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				StringWriter writer = new StringWriter();
				transformer.transform(new DOMSource(document), new StreamResult(writer));
				
				System.out.println(writer.toString());
				transformer.transform(new DOMSource(document), new StreamResult(new File("newXML.xml")));
				
				System.out.println(sb.toString());
			
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
