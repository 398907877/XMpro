﻿package com.gotop.jbpm.jpdl.model;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class JpdlModel {
	private Map<String, Node> nodes = new LinkedHashMap<String, Node>();
	public static final int RECT_OFFSET_X = -7;
	public static final int RECT_OFFSET_Y = -8;
	public static final int DEFAULT_PIC_SIZE = 48;

	private final static Map<String, Object> nodeInfos = new HashMap<String, Object>();
	static {
		nodeInfos.put("start", "start_event_empty.png");
		nodeInfos.put("end", "end_event_terminate.png");
		nodeInfos.put("end-cancel", "end_event_cancel.png");
		nodeInfos.put("end-error", "end_event_error.png");
		nodeInfos.put("decision", "gateway_exclusive.png");
		nodeInfos.put("fork", "gateway_parallel.png");
		nodeInfos.put("join", "gateway_parallel.png");
		nodeInfos.put("state", null);
		nodeInfos.put("hql", null);
		nodeInfos.put("sql", null);
		nodeInfos.put("java", null);
		nodeInfos.put("script", null);
		nodeInfos.put("task", null);
		nodeInfos.put("sub-process", null);
		nodeInfos.put("custom", null);
	}

	public JpdlModel(String filePath) throws Exception {
		//this(new SAXReader().read(is).getRootElement());
		this(dd(filePath));
	}

	private static Element dd (String filePath) throws IOException, DocumentException{
		Document dom = null;
		try {
			StringBuffer content = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(filePath), "UTF-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				content.append(line + "\n");
			}
			br.close();
			dom = DocumentHelper.parseText(content.toString());
		} catch (Exception e) {

		}
		Element root = dom.getRootElement();
		return root;
	}
	
	@SuppressWarnings("unchecked")
	private JpdlModel(Element rootEl) throws Exception {
		for (Element el : (List<Element>) rootEl.elements()) {
			String type = el.getQName().getName();
			if (!nodeInfos.containsKey(type)) { // 不是可展示的节点
				continue;
			}
			String name = null;
			if (el.attribute("name") != null) {
				name = el.attributeValue("name");
			}
			String[] location = el.attributeValue("g").split(",");
			int x = Integer.parseInt(location[0]);
			int y = Integer.parseInt(location[1]);
			int w = Integer.parseInt(location[2]);
			int h = Integer.parseInt(location[3]);

			if (nodeInfos.get(type) != null) {
				w = DEFAULT_PIC_SIZE;
				h = DEFAULT_PIC_SIZE;
			} else {
				x -= RECT_OFFSET_X;
				y -= RECT_OFFSET_Y;
				w += (RECT_OFFSET_X + RECT_OFFSET_X);
				h += (RECT_OFFSET_Y + RECT_OFFSET_Y);
			}
			Node node = new Node(name, type, x, y, w, h);
			parserTransition(node, el);
			nodes.put(name, node);
		}
	}

	@SuppressWarnings("unchecked")
	private void parserTransition(Node node, Element nodeEl) {
		for (Element el : (List<Element>) nodeEl.elements("transition")) {
			String label = el.attributeValue("name");
			String to = el.attributeValue("to");
			Transition transition = new Transition(label, to);
			String g = el.attributeValue("g");
			if (g != null && g.length() > 0) {
				if (g.indexOf(":") < 0) {
					transition.setLabelPosition(getPoint(g));
				} else {
					String[] p = g.split(":");
					transition.setLabelPosition(getPoint(p[1]));
					String[] lines = p[0].split(";");
					for (String line : lines) {
						transition.addLineTrace(getPoint(line));
					}
				}
			}
			node.addTransition(transition);
		}
	}

	private Point getPoint(String exp) {
		if (exp == null || exp.length() == 0) {
			return null;
		}
		String[] p = exp.split(",");
		return new Point(Integer.valueOf(p[0]), Integer.valueOf(p[1]));
	}

	/**
	 * @return the nodes
	 */
	public Map<String, Node> getNodes() {
		return nodes;
	}

	/**
	 * @return the nodeInfos
	 */
	public static Map<String, Object> getNodeInfos() {
		return nodeInfos;
	}

	@Override
	public String toString(){
	    StringBuffer buf = new StringBuffer();
	    buf.append("JpdlModel ( \n");
	    buf.append(" nodes = ").append(this.nodes).append("\n");
	    buf.append(")");    
	    return buf.toString();
	}
	
}
