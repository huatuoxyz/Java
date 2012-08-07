package spring.example05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Properties;

public class ExampleBean {
	@SuppressWarnings({ "unchecked" })
	private ArrayList list;
	@SuppressWarnings("unchecked")
	private LinkedHashMap map;
	@SuppressWarnings("unchecked")
	private HashSet set;
	
	private Properties properties;
	
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	@SuppressWarnings("unchecked")
	public ArrayList getList() {
		return list;
	}
	@SuppressWarnings("unchecked")
	public void setList(ArrayList list) {
		this.list = list;
	}
	@SuppressWarnings("unchecked")
	public LinkedHashMap getMap() {
		return map;
	}
	@SuppressWarnings("unchecked")
	public void setMap(LinkedHashMap map) {
		this.map = map;
	}
	@SuppressWarnings("unchecked")
	public HashSet getSet() {
		return set;
	}
	@SuppressWarnings("unchecked")
	public void setSet(HashSet set) {
		this.set = set;
	}
}

