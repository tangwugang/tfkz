package org.takinframework.web.system.manager;

import java.util.Comparator;

import org.takinframework.web.system.entity.Client;


public class ClientSort implements Comparator<Client> {

	
	public int compare(Client prev, Client now) {
		return (int) (now.getLoginDateTime().getTime()-prev.getLoginDateTime().getTime());
	}

}
