package com.olivee.web.model;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<K> {
	private K userObject;
	private List<TreeNode<K>> child;

	public K getUserObject() {
		return userObject;
	}

	public void setUserObject(K userObject) {
		this.userObject = userObject;
	}

	public List<TreeNode<K>> getChild() {
		if(child==null){
			child = new ArrayList<TreeNode<K>>();
		}
		return child;
	}

	public void setChild(List<TreeNode<K>> child) {
		this.child = child;
	}
	
	public void addChild(TreeNode<K> node){
		getChild().add(node);
	}

}
