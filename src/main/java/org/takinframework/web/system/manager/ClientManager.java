package org.takinframework.web.system.manager;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.takinframework.web.system.entity.Client;

/**
 * 对在线用户的管理
 * 
 * @author twg
 * @date 2014-8-28
 * @version 1.0
 */
public class ClientManager {
	private Map<String, Client> map = Collections
			.synchronizedMap(new HashMap<String, Client>());
	
	private static ClientManager instance = new ClientManager();

	private ClientManager() {

	}

	public static ClientManager getInstance() {
		return instance;
	}


	/**
	 * 
	 * @param sessionId
	 * @param client
	 */
	public void addClinet(String sessionId, Client client) {
		map.put(sessionId, client);
	}

	/**
	 * sessionId
	 */
	public void removeClinet(String sessionId) {
		map.remove(sessionId);
	}

	/**
	 * 
	 * @param sessionId
	 * @return
	 */
	public Client getClient(String sessionId) {
		return map.get(sessionId);
	}

	/**
	 * 
	 * @return
	 */
	public Collection<Client> getAllClient() {
		return map.values();
	}

}
